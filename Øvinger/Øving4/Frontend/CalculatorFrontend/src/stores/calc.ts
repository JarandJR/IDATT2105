import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useCalcStore = defineStore('calc', () => {
    const display = ref("0");
    const previous = ref("");
    const ans = ref("")

    return { display, previous, ans }
})
