const openpgp = require("openpgp");
const express = require("express");
const mongoose = require("mongoose");
const cors = require("cors");
const axios = require("axios").default;
require("dotenv").config();

mongoose.connect("mongodb://localhost:27017/votes");

const app = express();

app.use(express.json());
app.use(cors());

app.listen(4000, () => {
  console.log("app listening on port 4000");
});

app.post("/vote", async (req, res) => {
  try {
    const { id, vote } = req.body;
    console.log(req.body);

    const publicKeyArmored = await openpgp.readKey({
      armoredKey: process.env.SERVERPUBLICKEY,
    });

    const privateKeyArmored = await openpgp.decryptKey({
      privateKey: await openpgp.readPrivateKey({
        armoredKey: process.env.SERVERPRIVATEKEY,
      }),
      passphrase: "T0t@11y!F1ct1ti0us!P@ssphr@se!F0r!OP3nPGP",
    });

    const encrypted = await openpgp.encrypt({
      message: await openpgp.createMessage({
        text: JSON.stringify(vote),
      }),
      encryptionKeys: publicKeyArmored,
    });

    const message = await openpgp.readMessage({
      armoredMessage: encrypted,
    });

    const { data: decrypted, signatures } = await openpgp.decrypt({
      message: message,
      decryptionKeys: privateKeyArmored,
    });

    const data = { id, encrypted };
    try {
      const response = await axios.post("http://localhost:5000/vote1", data);
      res.json(response.data);
    } catch (error) {
      res.json({ error: "id already used" });
    }
  } catch (error) {
    console.log(error);
  }
});
