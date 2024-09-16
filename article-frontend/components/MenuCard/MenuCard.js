'use client';
import useSWR from "swr";
import { useRouter } from "next/navigation";

export default function MenuCard({ articleId }){
    const fetcher = (...args) => fetch(...args).then((res)=>res.json());
    const fetchUrl = process.env.NEXT_PUBLIC_BASE_URL + process.env.NEXT_PUBLIC_GET_ARTICLE_INFO + `${articleId}`;
    const { data, error, isLoading } = useSWR([fetchUrl], fetcher);

    const router = useRouter();

    if(error) return(
        <div className="w-56 h-48 
        bg-gradient-to-br from-red-400 via-orange-300 to-yellow-400
        bg-size-200 bg-pos-0 hover:bg-pos-100
        m-2 
        p-4 
        rounded-2xl
        hover:scale-105
        transition-all duration-300"
        
        onClick={() => router.push(`/article/${articleId}`)}
        >
            <div
                className="text-4xl font-bold"
            >Sorry</div>
            <div>Something went wrong</div>
        </div>
    )

    if(isLoading) return(
        <div className="w-56 h-48 
        bg-gradient-to-br from-blue-200 via-blue-400 to-blue-600
        bg-size-200 bg-pos-0 hover:bg-pos-100
        m-2 
        p-4 
        rounded-2xl
        hover:scale-105
        transition-all duration-300"
        
        onClick={() => router.push(`/article/${articleId}`)}
        >
            <div
                className="text-4xl font-bold"
            >Loading...</div>
            <div>Please wait</div>
        </div>
    )

    return(
        <div className="w-56 h-48 
        bg-gradient-to-br from-blue-400 via-yellow-300 to-green-400
        bg-size-200 bg-pos-0 hover:bg-pos-100
        m-2 
        p-4 
        rounded-2xl
        hover:scale-105
        transition-all duration-300"
        
        onClick={() => router.push(`/article/${articleId}`)}
        >
            <div
                className="text-4xl font-bold"
            >{data.title}</div>
            <div>by <span className="font-bold">{data.author_id}</span></div>
        </div>
    )
}