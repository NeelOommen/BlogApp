import ArticleCard from "@/components/ArticleCard/ArticleCard"
import SummaryCard from "@/components/SummaryCard/SummaryCard"


export default function Page(){
    return(
        <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">
          <div
            className="py-6 px-4 text-[#faf8ff] w-full relative h-auto flex items-center h-" 
          >
            {/* navbar */}
            <span
              className="w-fit text-4xl font-bold ml-8"
            >
               Article {/* SITE NAME */}
            </span>
            <span
              className="w-fit absolute right-4 mt-auto mb-auto"
            >
              <span className="mx-3">Button1</span>
              <span className="mx-3">Button2</span>
              <span className="mx-3">Button3</span>
              <span className="mx-3">Button4</span>
            </span>
          </div>

          <div
            className="w-full h-5/6 px-4 py-2 flex"
          >
            {/* article view */}
            <ArticleCard />
            <SummaryCard />
          </div>
      </main>
      {/* <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        add footer
      </footer> */}
    </div>
    )
}