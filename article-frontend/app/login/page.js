'use client';

import { useState } from "react";

export default function Page(){

    const [email, setEmail] = useState('')
    const [pword, setPword] = useState('')
    return(
    <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen p-8">
          <div
            className="font-bold text-6xl"
          >
            Login
          </div>
          <div
            className="h-full w-96 my-4 rounded-2xl border-2 p-6"
          >
            <form>
              <div
                className="font-bold text-2xl my-2"
              >
                Email
              </div>

              <input 
                type="email"
                className="bg-[#353778] rounded-2xl h-12 w-full p-4"
                value={email}
                onChange={(e)=>setEmail(e.target.value)}
              />

              <div
                className="font-bold text-2xl my-2"
              >
                Password
              </div>
              <input 
                type="password"
                className="bg-[#353778] rounded-2xl h-12 w-full p-4"
                value={pword}
                onChange={(e)=>{setPword(e.target.value)}}
              />
            </form>
            <div
                    className="
                        bg-gradient-to-br from-blue-500 via-amber-500 to-lime-500
                        bg-size-200 bg-pos-0 hover:bg-pos-100
                        transition-all duration-300
                        p-4
                        rounded-2xl
                        w-fit
                        ml-auto mr-auto
                        mt-10
                        font-bold
                        hover:scale-110
                    "
                >
                    Login
                </div>
          </div>

         
      </main>
      {/* <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        add footer
      </footer> */}
    </div>
    )
}