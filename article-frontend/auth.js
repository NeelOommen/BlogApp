import NextAuth from "next-auth";
import Credentials from "next-auth/providers/credentials";

const fetchUrl = 'http://localhost:8080/api/user/validate'

const getUserFromDb = async (credentials) => {
    try{
        const response = await fetch(fetchUrl, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(credentials)
        })

        const dataJson = await response.json();

        return dataJson;
    }
    catch(error){
        console.log("Failed to validate");
    }
} 


export const { handlers, signIn, signOut, auth } = NextAuth({
    providers: [
        Credentials({
          // You can specify which fields should be submitted, by adding keys to the `credentials` object.
          // e.g. domain, username, password, 2FA token, etc.
          credentials: {
            email: {},
            password: {},
          },
          authorize: async (credentials) => {
            let user = null
     
            // logic to salt and hash password
            //const pwHash = saltAndHashPassword(credentials.password)
     
            // logic to verify if the user exists
            user = await getUserFromDb(credentials)
     
            if (!user) {
              // No user found, so this is their first attempt to login
              // meaning this is also the place you could do registration
              throw new Error("User not found.")
            }
     
            // return user object with their profile data
            return user
          },
        }),
      ],
})