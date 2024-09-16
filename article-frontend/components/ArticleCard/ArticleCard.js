'use client';
import useSWR  from "swr"
import SummaryCard from "../SummaryCard/SummaryCard";

export default function ArticleCard({ articleId }){

    const fetcher = (...args) => fetch(...args).then((res) => res.json());
    const article_url = process.env.NEXT_PUBLIC_BASE_URL + process.env.NEXT_PUBLIC_GET_ARTICLE + `${articleId}`;
    const { data, error, isLoading } = useSWR([article_url], fetcher);

    if(error) return(
        <div
            className="bg-gradient-to-tr from-red-500 via-orange-500 to-yellow-500 
            bg-size-200 bg-pos-0 hover:bg-pos-n100
            w-2/3 h-full 
            px-6 pb-4 py-4
            mx-4
            text-[#faf8ff] 
            rounded-2xl
            transition-all duration-500
            hover:scale-[103%]
            "
        >
            <div
                className="text-6xl font-bold my-4"
            >
                Sorry!
            </div> 
            <div
                className="font-bold text-lg"
            >
                There was an error while fetching the data you requested.
            </div>
        </div>
    )

    if(isLoading) return(
        <div
            className="bg-gradient-to-tr from-green-500 via-blue-500 to-yellow-500 
            bg-size-200 bg-pos-0 hover:bg-pos-n100
            w-2/3 h-full 
            px-6 pb-4 py-4
            mx-4
            text-[#faf8ff] 
            rounded-2xl
            transition-all duration-500
            hover:scale-[103%]
            "
        >
            <div
                className="text-6xl font-bold my-4"
            >
                Loading
            </div> 
            <div
                className="font-bold text-lg"
            >
                Please wait.
            </div>
        </div>
    )

    return(
        <>
            {console.log(data)}
            <div
                className="bg-gradient-to-tr from-indigo-500 via-purple-500 to-yellow-500 
                bg-size-200 bg-pos-0 hover:bg-pos-n100
                w-2/3 h-full 
                px-6 pb-4
                mx-4
                text-[#faf8ff] 
                rounded-2xl
                transition-all duration-500
                hover:scale-[103%]
                "
            >
                <div className="h-full w-full overflow-clip p-2">
                    <div
                        className="w-fit text-4xl font-bold mt-3"
                    >
                        {data.author_name}
                    </div>
                    <div
                        className="w-fit text-lg font-bold my-1"
                    >
                        by <span>{data.title}</span>
                    </div>
                    <div
                        className="h-full mb-4 overflow-y-scroll"
                    >
                        {data.articleBody}
                    </div>
                </div>
            </div>
            <SummaryCard bodyText={data.articleBody}/>
        </>
    )
}