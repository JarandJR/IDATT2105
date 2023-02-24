import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useCalcStore = defineStore('calc', () => {
    const display = ref("0");
    const previous = ref("");

    return { display, previous }
})
