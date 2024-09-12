import NextAuth from "next-auth";
import Credentials from "next-auth/providers/credentials";

const fetchUrl = 'http://localhost:8080/validate'

const getUserfromDB = async (email, pword) => {
    try{
        const response = await fetch(fetchUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({"email": email, "password": pword})
        });
        const dataJson = await response.json()
        return dataJson
    }
    catch(error){
        return null
    }
}

export const { handlers ,signIn, signOut, auth } = NextAuth({
    providers:[
        Credentials({
            credentials: {
                email: {},
                password: {},
            },
            authorize: async (credentials) => {
                let user = null
                
                //const pwhash = 'hash credentials.password'

                user = await getUserfromDB(credentials.email, credentials.password)

                if(!user){
                    throw new Error("No Such user")
                }

                return user
            }
        }),
    ],
})