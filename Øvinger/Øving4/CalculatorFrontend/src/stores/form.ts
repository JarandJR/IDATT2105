import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useFormStore = defineStore('counter', () => {
  const name = ref("");
  const mail = ref("");

  return { name, mail }
})
