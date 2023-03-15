import { ref } from 'vue'
import { defineStore } from 'pinia'
import axios from "axios";

export const useUserStore = defineStore('user', () => {
    const username = ref("Undefined");
    const loggedIn = ref(false);
    const jwtToken = ref("invalid");
    const storage = sessionStorage;

    async function getTokenAndSaveInStore(usernameData:string, password:string) {
        try{
            let response = await getJwtToken(usernameData, password);
            console.log("Response: " + response);
            let data = response.data;
            console.log("Data: " + data);
            if(data != null && data != '' && data != undefined){
                jwtToken.value = data;
                loggedIn.value = true;
                username.value = usernameData;
            }
        } catch (err){
            console.log(err)
        }
    }

    function getJwtToken(username:string, password:string) {
        const config = {
            headers: {
                "Content-type": "application/json",
            },
        };
        return axios.post("http://localhost:8080/login/token", JSON.stringify({ username, password }), config);
    }

    return { username, loggedIn, jwtToken, getTokenAndSaveInStore, storage}
})