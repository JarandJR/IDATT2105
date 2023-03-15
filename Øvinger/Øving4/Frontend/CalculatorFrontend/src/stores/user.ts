import axios from "axios";
import { defineStore } from "pinia";

export const useUserStore = defineStore("user", {
    state: () => ({
        jwtToken: null,
        loggedIn: false,
        username: "Login",
        password: "",
    }),
    persist: {
        storage: sessionStorage,
    },
    actions: {
        async getTokenAndSaveInStore(usernameData:string, password:string) {
            try {
                let response = await this.getJwtToken(usernameData, password);
                let data = response.data;
                if (data != null && data != '' && data != undefined) {
                    this.jwtToken = data;
                    this.loggedIn = true;
                    this.username = usernameData;
                    this.password = password;
                }
            } catch (err) {
                console.log(err)
            }
        },
        getJwtToken(username:string, password:string) {
            const config = {
                headers: {
                    "Content-type": "application/json",
                },
            };
            return axios.post("http://localhost:8080/login/token", JSON.stringify({ username, password }), config);
        }
    },
});
