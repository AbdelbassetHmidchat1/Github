const express = require("express");
const cors = require("cors");
const axios = require("axios").default;
const openpgp = require("openpgp");
const User = require("./models/User");
require("dotenv").config();
const mongoose = require("mongoose");

mongoose.connect("mongodb://localhost:27017/votes");

const app = express();

app.use(express.json());
app.use(cors());

let client1 = null;
let client2 = null;

const server = app.listen(5000, () => {
  console.log("working on port 5000");
});

app.post("/vote1", async (req, res) => {
  const privateKey = `-----BEGIN PGP PRIVATE KEY BLOCK-----

xYYEZi0LORYJKwYBBAHaRw8BAQdAk9JNcieooSiUesIFWfyotLQDigSLGOWh
i5FVuiVLIkz+CQMI+Is6TlPLg13gcE0CXHVm50emlYv0aaPR0hvCuPA79SbG
za0HXf98WqqTP+3eotM/fmExMBG7QDUvNnzC46fqJX4sCLAk0Yg4fOVp5g4p
Zs0Vdm90ZSA8dm90ZUBnbWFpbC5jb20+wowEEBYKAD4FgmYtCzkECwkHCAmQ
VcSZkkmIpigDFQgKBBYAAgECGQECmwMCHgEWIQQIlRW5XDIp4QJap/xVxJmS
SYimKAAAvY0BAPTxqcyjMaM/wdG/xvkp+mL9SGIpLoTp5FSR5HnaNEfUAP4o
5upY9KeehmYDBFtNv9xNCqzTqDVxq3CZf7vQfAA3AceLBGYtCzkSCisGAQQB
l1UBBQEBB0CRhJ7WI4ViFnPkmO8n3EY9Ldzvbvt6kFcHKwBUKHkkLAMBCAf+
CQMIRw8usepxe/XgFzYknhHZyxVAIQhNrYqpe6yMP78B8iplUuOvpj8HT2Pe
DMgpPa9f7J3QujPSl9tKz/INWbiVz4sRhUMFXBXseodQv2iG/MJ4BBgWCgAq
BYJmLQs5CZBVxJmSSYimKAKbDBYhBAiVFblcMinhAlqn/FXEmZJJiKYoAABg
1wEA2HsrUrSZFDZp/QdU/0/IzBD/7WoXXPBG85VHSMZIddUA/0g6eUKzRtlU
bEVaKYRTLftgzYXE8YgWS6EISG4OMvsA
=U73b
-----END PGP PRIVATE KEY BLOCK-----
`;
  const passphrase = "T0t@11y!F1ct1ti0us!P@ssphr@se!F0r!OP3nPGP";

  const { id, encrypted } = req.body;
  const privateKeyArmored = await openpgp.decryptKey({
    privateKey: await openpgp.readPrivateKey({
      armoredKey: privateKey,
    }),
    passphrase: passphrase,
  });

  const message = await openpgp.readMessage({
    armoredMessage: encrypted,
  });

  const { data: decrypted, signatures } = await openpgp.decrypt({
    message: message,
    decryptionKeys: privateKeyArmored,
  });
  client1 = { id: id, vote: decrypted, data: encrypted };

  comparePasswords(res);
});

app.post("/vote2", async (req, res) => {
  const privateKey = `-----BEGIN PGP PRIVATE KEY BLOCK-----

xYYEZi0LORYJKwYBBAHaRw8BAQdAk9JNcieooSiUesIFWfyotLQDigSLGOWh
i5FVuiVLIkz+CQMI+Is6TlPLg13gcE0CXHVm50emlYv0aaPR0hvCuPA79SbG
za0HXf98WqqTP+3eotM/fmExMBG7QDUvNnzC46fqJX4sCLAk0Yg4fOVp5g4p
Zs0Vdm90ZSA8dm90ZUBnbWFpbC5jb20+wowEEBYKAD4FgmYtCzkECwkHCAmQ
VcSZkkmIpigDFQgKBBYAAgECGQECmwMCHgEWIQQIlRW5XDIp4QJap/xVxJmS
SYimKAAAvY0BAPTxqcyjMaM/wdG/xvkp+mL9SGIpLoTp5FSR5HnaNEfUAP4o
5upY9KeehmYDBFtNv9xNCqzTqDVxq3CZf7vQfAA3AceLBGYtCzkSCisGAQQB
l1UBBQEBB0CRhJ7WI4ViFnPkmO8n3EY9Ldzvbvt6kFcHKwBUKHkkLAMBCAf+
CQMIRw8usepxe/XgFzYknhHZyxVAIQhNrYqpe6yMP78B8iplUuOvpj8HT2Pe
DMgpPa9f7J3QujPSl9tKz/INWbiVz4sRhUMFXBXseodQv2iG/MJ4BBgWCgAq
BYJmLQs5CZBVxJmSSYimKAKbDBYhBAiVFblcMinhAlqn/FXEmZJJiKYoAABg
1wEA2HsrUrSZFDZp/QdU/0/IzBD/7WoXXPBG85VHSMZIddUA/0g6eUKzRtlU
bEVaKYRTLftgzYXE8YgWS6EISG4OMvsA
=U73b
-----END PGP PRIVATE KEY BLOCK-----
`;
  const passphrase = "T0t@11y!F1ct1ti0us!P@ssphr@se!F0r!OP3nPGP";
  const { id, vote } = req.body;

  const publicKeyArmored = await openpgp.readKey({
    armoredKey: process.env.SERVERPUBLICKEY,
  });

  const privateKeyArmored = await openpgp.decryptKey({
    privateKey: await openpgp.readPrivateKey({
      armoredKey: privateKey,
    }),
    passphrase: passphrase,
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
  client2 = { id: id, vote: decrypted, data: encrypted };

  comparePasswords(res);
});

app.get('/vote-count', async (req, res) => {
  try {
    const count = await User.countDocuments();
    res.json({ count }); // Send the count as JSON response
  } catch (error) {
    console.error('Error counting documents:', error);
    res.status(500).json({ error: 'Internal server error' });
  }
});

async function comparePasswords(res) {
  if (client1 !== null) {
    try {
      if (client2 !== null) {
        if (client1.vote === client2.vote) {
          result = client1;
          const user = await User.create({
            id: client1.id,
            vote: client1.data,
          });
          io.emit("comparisonResult", result);
          // Send the user data as the response
          res.json(user);
        } else {
          result = "encryption failed";
          io.emit("comparisonResult", result);
          // Send the result message as the response
          res.json({ error: "encryption failed" });
        }
        client1 = null;
        client2 = null;
      }
    } catch (error) {
      if (
        error.code === 11000 &&
        error.keyPattern &&
        error.keyPattern.hasOwnProperty("id")
      ) {
        // Handle duplicate key error
        res.status(400).json({ error: "User with this ID already exists." });
      } else {
        // Handle other errors
        console.error("Error creating user:", error);
        res.status(500).json({ error: "Internal server error" });
      }
    }
  }
}

const io = require("socket.io")(server);
