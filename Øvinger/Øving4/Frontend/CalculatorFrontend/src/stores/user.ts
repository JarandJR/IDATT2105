import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', () => {
    const username = ref("Undefined");
    const loggedIn = ref(false);

    return { username, loggedIn }
})