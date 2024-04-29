import React from "react";
import { useForm } from "react-hook-form";
import person from "../assets/images/person.svg";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function Vote() {
  const { register, handleSubmit } = useForm();
  const navigate = useNavigate();

  const onSubmit = async (data) => {
    const test = { id: data.id, vote: data.vote };
    data.vote = data.vote.toUpperCase();

    try {
      console.log("Sending request to /vote and /vote1 concurrently");
      let res2 = axios.post("http://localhost:5000/vote2", test);
      let res = await axios.post("http://localhost:4000/vote", test);
      console.log(res);

      if (!res.data.error) {
        alert("form submitted successfully");
        navigate("/vote-count");
      } else {
        alert("ID already used");
        navigate("/vote");
      }
      console.log("Form data submitted successfully!");
    } catch (error) {
      console.error("Error submitting form data:", error);
    }
  };

  return (
    <>
      <div className="h-screen w-screen bg-[#001124] flex">
        <div className="w-screen max-w-[40%] flex items-center justify-center">
          <img src={person} alt="person" className="scale-[150%]" />
        </div>

        <div className="w-full flex justify-center items-center">
          <div className="max-w-md mx-auto">
            <h1 className="text-center text-3xl text-white mb-8">
              Registration Form
            </h1>
            <form onSubmit={handleSubmit(onSubmit)}>
              <div className="mb-4">
                <label htmlFor="id" className="text-white block mb-2">
                  ID:
                </label>
                <input
                  type="text"
                  id="id"
                  name="id"
                  className="bg-gray-200 rounded-lg px-3 py-2 w-full text-xl outline-none"
                  {...register("id")}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="name" className="text-white block mb-2">
                  Name:
                </label>
                <input
                  type="text"
                  id="name"
                  name="name"
                  className="bg-gray-200 rounded-lg px-3 py-2 w-full text-xl outline-none"
                  {...register("name")}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="lastName" className="text-white block mb-2">
                  Last Name:
                </label>
                <input
                  type="text"
                  id="lastName"
                  name="lastName"
                  className="bg-gray-200 rounded-lg px-3 py-2 w-full text-xl outline-none"
                  {...register("lastName")}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="address" className="text-white block mb-2">
                  Address:
                </label>
                <input
                  type="text"
                  id="address"
                  name="address"
                  className="bg-gray-200 rounded-lg px-3 py-2 w-full text-xl outline-none"
                  {...register("address")}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="email" className="text-white block mb-2">
                  Email:
                </label>
                <input
                  type="email"
                  id="email"
                  name="email"
                  className="bg-gray-200 rounded-lg px-3 py-2 w-full text-xl outline-none"
                  {...register("email")}
                />
              </div>
              <div className="mb-4">
                <label htmlFor="phone" className="text-white block mb-2">
                  Phone:
                </label>
                <input
                  type="tel"
                  id="phone"
                  name="phone"
                  className="bg-gray-200 rounded-lg px-3 py-2 w-full text-xl outline-none"
                  {...register("phone")}
                />
              </div>
              <div className="mb-4">
                <label
                  htmlFor="Vote Candidate"
                  className="text-white block mb-2"
                >
                  Voting for:
                </label>
                <input
                  id="vote"
                  name="vote"
                  className="bg-gray-200 rounded-lg px-3 py-2 w-full text-xl outline-none"
                  {...register("vote")}
                ></input>
              </div>
              <div className="flex justify-center">
                <button
                  type="submit"
                  className="my-6 px-8 py-2 hover:bg-[#001124] border border-blue-500 bg-blue-500 transition-all rounded-xl text-3xl duration-700 text-white"
                >
                  Submit
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
}
