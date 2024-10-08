'use client'
import ArticleCard from "@/components/ArticleCard/ArticleCard"
import Navbar from "@/components/Navbar/Navbar";
import SummaryCard from "@/components/SummaryCard/SummaryCard"

import { usePathname } from "next/navigation";
import { useRouter } from "next/navigation";
import { auth } from "@/auth";
import { useSession } from "next-auth/react";


export default function Page(){
    
    const pName = usePathname();
    const id = pName.split("/")[2];

    const router = useRouter();

    const session = useSession();

    if(session?.status == "unauthenticated"){
      router.push("/login");
    }

    return(
        <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">
          <Navbar sessionCtx={session}/>

          <div
            className="w-full h-5/6 px-4 py-2 flex"
          >
            {/* article view */}
            <ArticleCard articleId={id}/>
            
          </div>
      </main>
      {/* <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        add footer
      </footer> */}
    </div>
    )
}