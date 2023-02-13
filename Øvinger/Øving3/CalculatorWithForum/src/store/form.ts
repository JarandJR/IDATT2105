import {ref} from "vue";
import {defineStore} from "pinia";
import axios from "axios";

export const useFormStore = defineStore("form", () => {
    const mail = ref("");
    const name = ref("");
    function getMail() {
        return mail.value
    }
    function setMail(mail:string) {
        useFormStore().$patch({mail: mail})
    }
    function getName() {
        return name.value
    }
    function setName(full_name:string) {
        useFormStore().$patch({name: full_name})
    }
    function submit(name:string, mail:string, message:string) {
        setName(name);
        setMail(mail);
        const form = {
            name: name,
            mail: mail,
            message: message,
        };
        return axios.post('http://localhost:3000/form', form)
    }
    return { mail, getMail, setMail , name, getName, setName, submit};
});