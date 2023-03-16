<script setup lang="ts">
import Navbar from "@/components/global/Navbar.vue";
import { RouterView } from 'vue-router'
import {onMounted, watch} from "vue";
import {useUserStore} from "@/stores/user";


const store = useUserStore();

watch(() => store.loggedIn, refreshToken);
onMounted(() => {
  if (store.loggedIn) {
    refreshToken()
  }
});

async function refreshToken() {
  setInterval(async () => {
    if(store.loggedIn) {
      console.log("refreshing token")
      return await store.getTokenAndSaveInStore(store.username, store.password)
    }
  }, 1000 * 60 * 5)
}
</script>

<template>
  <Navbar class="navbar"/>
  <RouterView />
</template>