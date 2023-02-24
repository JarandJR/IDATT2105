import { ref } from 'vue'
import { defineStore } from 'pinia'

export const useFormStore = defineStore('form', () => {
  const name = ref("");
  const mail = ref("");

  return { name, mail }
})
