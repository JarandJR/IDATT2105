import { ref } from "vue";
import { defineStore } from "pinia";

export const useNameStore = defineStore("name", () => {
    const name = ref("");
    function getName() {
        //todo fetch from database
        return name.value
    }
    function setName(name:string) {
        //todo set value in database
        useNameStore().$patch({name: name})
    }
    return { name, getName, setName};
});