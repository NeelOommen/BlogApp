'use client'
import MenuCard from "@/components/MenuCard/MenuCard";
import Navbar from "@/components/Navbar/Navbar";
import Image from "next/image";
import useSWR from "swr";

export default function Home() {

  const fetcher = (...args) => fetch(...args).then((res) => res.json());
  const fetchUrl = 'http://localhost:8080/api/articles/list_article_ids'
  const { data, error, isLoading } = useSWR([fetchUrl], fetcher);


  if(error) return(
    <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">
          <Navbar />

          <div
            className="w-full h-full px-4 py-2"
          >
            <div 
              className="text-6xl font-bold mb-4"
            >
              Sorry!
            </div>
            <div className="font-bold">There was an error while fetching this data for you.</div>
            
          </div>
      </main>
      {/* <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        add footer
      </footer> */}
    </div>
  )

  if(isLoading) return(
    <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">
          <Navbar />

          <div
            className="w-full h-full px-4 py-2"
          >
            <div className="text-6xl font-bold mb-4">Loading...</div>
            <div className="font-bold">Please wait</div>
          </div>
      </main>
      {/* <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        add footer
      </footer> */}
    </div>
  )

  return (
    <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">
          <Navbar />

          <div
            className="w-full h-full px-4 py-2 grid grid-cols-5 overflow-y-scroll"
          >
            {data.map((id)=>(
              <MenuCard key={id} articleId={id}/>
            ))}
            
          </div>
      </main>
      {/* <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        add footer
      </footer> */}
    </div>
  );
}
