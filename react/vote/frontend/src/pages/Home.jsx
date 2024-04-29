import React from "react";
import vote from "../assets/images/vote.svg";

export default function Home() {
  return (
    <>
      <div className="w-screen h-screen bg-black flex ">
        <img src={vote} alt="vote" className="object-cover h-full" />
        <div className="text-white flex items-center justify-center flex-col w-full">
          <h1 className="text-3xl my-6">Be part of the decision</h1>
          <h1 className="text-6xl my-6 text-blue-500 ">Vote today</h1>
          <button className=" my-6 px-8 py-2 hover:bg-black border border-blue-500 bg-blue-500 transition-all rounded-xl text-3xl duration-700">
            <a href="/vote">Vote</a>
          </button>
        </div>
      </div>
    </>
  );
}
