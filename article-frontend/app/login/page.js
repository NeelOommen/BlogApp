import { signIn, auth } from "@/auth"
import { redirect } from "next/navigation";

export default async function Page(){
    const session = await auth();
    console.log(JSON.stringify(session))

    if(session?.user){
      redirect('http://localhost:3000');
    }

    return(
        <div className="items-center justify-items-center bg-[#111344] min-h-screen min-w-screen font-[family-name:var(--font-geist-sans)]">
      <main className="flex flex-col items-center sm:items-start w-full h-screen">

          <div
            className="w-full h-full px-4 py-8 flex"
          >
            <div className="border-2 rounded-2xl h-full my-4 mx-4 w-1/2 p-8">
              <div className="font-bold text-6xl mb-10">Login</div>
              <form
                  action={ async (formData) => {
                      "use server";
                      const user = await signIn("credentials", formData);
                      

                      const session = await auth();
                      console.log(JSON.stringify(session))

                      if(session.user){
                        redirect('http://localhost:3000');
                      }

                  }}
              >
                  <div>
                    <div className="font-bold text-2xl my-2">Email</div>
                    <input 
                      className="rounded-2xl bg-[#353778] border-2 h-12 w-full my-4 p-4"
                      name="email"
                      type="email"
                    />
                  </div>
                  <div>
                    <div className="font-bold text-2xl mys-2">Password</div>
                    <input 
                      className="rounded-2xl bg-[#353778] border-2 h-12 w-full my-4 p-4"
                      type="password"
                      name="password"
                    />
                  </div>
                  <button
                    className="bg-gradient-to-br from-blue-500 via-amber-500 to-lime-500
                        bg-size-200 bg-pos-0 hover:bg-pos-100
                        transition-all duration-300
                        p-4
                        rounded-2xl
                        w-fit
                        mt-auto mb-auto
                        font-bold
                        hover:scale-110"
                  >Sign in</button>
              </form>
            </div>

            <div
              className="border-2 rounded-2xl h-full my-4 mx-4 w-1/2 p-8"
            >
              <div className="font-bold text-6xl mb-10">Sign Up</div>
              <form
                action={
                  async (formData) => {
                    "use server";

                    var data = {};
                    formData.forEach(function(value, key){
                        data[key] = value;
                    });

                    const response = await fetch('http://localhost:8080/api/user/save',{
                      method: "POST",
                      headers: {
                        "Content-Type": "application/json"
                      },
                      body: JSON.stringify({
                        "email": data.email,
                        "username": data.username,
                        "password": data.password
                      })
                    })
                  }
                }
              >
              <div>
                  <div className="font-bold text-2xl my-2">Email</div>
                    <input 
                      className="rounded-2xl bg-[#353778] border-2 h-12 w-full my-4 p-4"
                      type="email"
                      name="email"
                    />
                  </div>
                  <div>
                    <div className="font-bold text-2xl my-2">User Name</div>
                    <input 
                      className="rounded-2xl bg-[#353778] border-2 h-12 w-full my-4 p-4"
                      type="text"
                      name="username"
                    />
                  </div>
                  <div>
                    <div className="font-bold text-2xl my-2">Create Password</div>
                    <input 
                      className="rounded-2xl bg-[#353778] border-2 h-12 w-full my-4 p-4"
                      type="text"
                      name="password"
                    />
                  </div>
                  <button
                    className="bg-gradient-to-br from-blue-500 via-amber-500 to-lime-500
                        bg-size-200 bg-pos-0 hover:bg-pos-100
                        transition-all duration-300
                        p-4
                        rounded-2xl
                        w-fit
                        mt-auto mb-auto
                        font-bold
                        hover:scale-110"
                  >Create Account</button>
              </form>
            </div>
          </div>
      </main>
      {/* <footer className="row-start-3 flex gap-6 flex-wrap items-center justify-center">
        add footer
      </footer> */}
    </div>
    )
}