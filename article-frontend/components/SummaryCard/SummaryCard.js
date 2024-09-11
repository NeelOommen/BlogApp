import { useEffect, useState } from "react"

export default function SummaryCard({ bodyText }){
    const fetchUrl = 'http://localhost:8000/summarize'
    
    const [data, setData] = useState()
    const [isLoading, setIsloading] = useState(true)
    const [err, setError] = useState(false)

    useEffect(() => {
        const fetchData = async () => {
            setIsloading(true)
            try{
                const response = await fetch(fetchUrl,{
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({"textBody": bodyText})
                });

                const dataJson = await response.json();
                setData(dataJson);
            }
            catch(error){
                setError(true)
            }
            setIsloading(false)
        }

        fetchData();
    }, [])

    if(err) return(
        <div
            className="bg-gradient-to-br from-red-500 via-orange-500 to-yellow-500 
            bg-size-200 bg-pos-0 hover:bg-pos-100
             w-1/3 h-full
             px-3 py-2 pr-12
             text-[#faf8ff] 
             rounded-2xl
             transition-all duration-500
             hover:scale-[103%]
             overflow-clip
             "
        >
            <div
                className="text-4xl font-bold m-4"
            >
                {/* Heading */}
                Sorry
            </div>
            <div
                className="w-full text-pretty h-full overflow-y-scroll mx-4"
            >
                {/* Body */}
                There was an error while fethcing your data.
            </div>
               
        </div>
    )

    if(isLoading) return(
        <div
            className="bg-gradient-to-br from-blue-500 via-yellow-500 to-lime-500 
            bg-size-200 bg-pos-0 hover:bg-pos-100
             w-1/3 h-full
             px-3 py-2 pr-12
             text-[#faf8ff] 
             rounded-2xl
             transition-all duration-500
             hover:scale-[103%]
             overflow-clip
             "
        >
            <div
                className="text-4xl font-bold m-4"
            >
                {/* Heading */}
                Loading...
            </div>
            <div
                className="w-full text-pretty h-full overflow-y-scroll mx-4"
            >
                {/* Body */}
                Please Wait
            </div>
               
        </div>
    )

    return(
        <div
            className="bg-gradient-to-br from-blue-500 via-yellow-500 to-lime-500 
            bg-size-200 bg-pos-100 hover:bg-pos-0
             w-1/3 h-full
             px-3 py-2 pr-12
             text-[#faf8ff] 
             rounded-2xl
             transition-all duration-500
             hover:scale-[103%]
             overflow-clip
             "
        >
            <div
                className="text-4xl font-bold m-4"
            >
                {/* Heading */}
                Summary
            </div>
            <div
                className="w-full text-pretty h-full overflow-y-scroll mx-4"
            >
                {/* Body */}
                {data.summary}
            </div>
               
        </div>
    )
}