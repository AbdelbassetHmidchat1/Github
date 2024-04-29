import { useEffect, useState } from "react";
import axios from "axios";
import person from "../assets/images/person.svg";

export default function Count() {
  const [votes, setVotes] = useState("");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:5000/vote-count");
        setVotes(response.data);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  return (
    <>
      <div className="h-screen w-screen bg-[#001124] flex">
        <div className="w-screen max-w-[40%] flex items-center justify-center">
          <img src={person} alt="person" className="scale-[150%]" />
        </div>

        <div className=" w-full flex justify-center items-center">
          <div className="max-w-md mx-auto">
            <h1 className="text-center text-3xl text-white mb-8">Vote Count</h1>
            <div className="text-center text-white text-3xl">
              Total number of voters are : {votes ? votes.count : "loading"}
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
