'use client';
import Navbar from "@/components/Navbar/Navbar";
import { useState } from "react";
import { useSession } from "next-auth/react";
import { useRouter } from "next/navigation";

export default function Page(){
    const fetchUrl = 'http://localhost:8080/api/articles/create'

    const [article, setArticle] = useState('')
    const [isLoading, setIsloading] = useState('')
    const [title, setTitle] = useState('')

    const session = useSession();
    console.log("article " + JSON.stringify(session));

    const router = useRouter();

    if(session.status == "unauthenticated"){
        router.push("/login");
      }

    const postArticle = async () => {
        setIsloading('Loading, Please Wait')
        try{
            const response = await fetch(fetchUrl, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",               
                },
                body: JSON.stringify({
                    "author_name": session.data.user.name,
                    "title": title,
                    "articleBody": article
                })
            })

            const dataJson = response.json()
            setIsloading('Posted!')
        }
        catch(error){
            setIsloading('Something went wrong')
        }
    }


    return(
        <div>
            <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">
          <Navbar sessionCtx={session}/>

          <div
            className="w-full h-5/6 px-4 py-2 flex mt-4"
          >
            <div>
                <div className="font-bold text-4xl mb-4">Write something!</div>                
                <form>
                    <label className="font-bold text-lg">Title</label>
                    <input 
                        id="titleField"
                        className="bg-[#353778] p-4 rounded-2xl mb-4 w-full"
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                    />

                    <textarea 
                        id="articleMain"
                        cols={100}
                        rows={15}
                        className="bg-[#353778] overflow-y-scroll p-4 rounded-2xl"
                        value={article}
                        onChange={(e) => setArticle(e.target.value)}
                    />
                </form>
            </div>
            <div
                className="h-full w-full flex flex-col items-center"
            >
                <div className="text-center">
                    This Article will be sumbitted as written by:
                    <br />
                    <span className="font-bold">{session.data.user.name}</span>
                </div>

                <div
                    className="
                        bg-gradient-to-br from-blue-500 via-amber-500 to-lime-500
                        bg-size-200 bg-pos-0 hover:bg-pos-100
                        transition-all duration-300
                        p-4
                        rounded-2xl
                        w-fit
                        mt-auto mb-auto
                        font-bold
                        hover:scale-110
                    "
                    onClick={postArticle}
                >
                    Submit Your Article!
                </div>

                <div>{isLoading}</div>

                <div
                    className="
                        bg-gradient-to-br from-red-500 via-orange-500 to-yellow-500
                        bg-size-200 bg-pos-0 hover:bg-pos-100
                        transition-all duration-300
                        p-4
                        rounded-2xl
                        w-fit
                        mt-auto mb-auto
                        font-bold
                        hover:scale-110
                    "
                    onClick={()=>setArticle('')}
                >
                    Reset Your Article
                </div>
            </div>
          </div>
      </main>
    </div>
        </div>
    )
}