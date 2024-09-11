import Navbar from "@/components/Navbar/Navbar";

export default function Page(){
    return(
        <div>
            <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">
          <Navbar />

          <div
            className="w-full h-5/6 px-4 py-2 flex mt-4"
          >
            <div>
                <div className="font-bold text-4xl mb-4">Write something!</div>                
                <form>
                    <textarea 
                        id="articleMain"
                        cols={100}
                        rows={20}
                        className="bg-[#353778] overflow-y-scroll p-4 rounded-2xl"
                    />
                </form>
            </div>
            <div
                className="h-full w-full flex flex-col items-center"
            >
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
                >
                    Submit Your Article!
                </div>

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