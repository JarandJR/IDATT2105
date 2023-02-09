import { ref } from "vue";
import { defineStore } from "pinia";

export const useMailStore = defineStore("mail", () => {
    const mail = ref("");
    function getMail() {
        //todo fetch from database
        return mail.value
    }
    function setMail(mail:string) {
        //todo set value in database
        useMailStore().$patch({mail: mail})
    }
    return { mail, getMail, setMail };
});