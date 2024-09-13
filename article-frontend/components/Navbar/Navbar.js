'use client';
import { useRouter } from "next/navigation";
import { SignOut } from "@/app/utils";

export default function Navbar({ sessionCtx }){
    const router = useRouter();

    return(
        <div
            className="py-2 px-4 text-[#faf8ff] w-full relative"
          >
            {/* navbar */}
            <span
              className="w-fit text-4xl font-bold"
            >
               Article {/* SITE NAME */}
            </span>
            <span
              className="w-fit absolute right-4 mt-auto mb-auto"
            >
              <span className="mx-3 cursor-pointer hover:text-amber-400 transition-all duration-300" onClick={() => router.push('http://localhost:3000')}>Home</span>
              <span className="mx-3 cursor-pointer hover:text-amber-400 transition-all duration-300" onClick={() => router.push('http://localhost:3000/write-post')}>Post an Article</span>
              <span className="mx-3 cursor-pointer hover:text-amber-400 transition-all duration-300" onClick={() => router.push('http://localhost:3000/login')}>
                {
                  (sessionCtx.status == "authenticated")
                  ?
                  `Logged in as ${sessionCtx.data.user.name}`:'Log In'
                }
              </span>
              {
                (sessionCtx.status == "authenticated")
                ?   
                <span className="mx-3 cursor-pointer hover:text-amber-400 transition-all duration-300" onClick={() => SignOut()}>Log Out</span>
                :
                <></>
              }
            </span>
          </div>
    )
}