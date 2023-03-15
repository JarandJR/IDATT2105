<script setup lang="ts">
import Navbar from "@/components/global/Navbar.vue";
import { RouterView } from 'vue-router'
import {onMounted} from "vue";
import {useUserStore} from "@/stores/user";

const store = useUserStore();

onMounted(() => {
  if(store.loggedIn) {
    setInterval(() => {
      refreshToken();
    }, 1000 * 60 * 5)
  }
});

async function refreshToken() {
  console.log("refreshing token");
  return await store.getTokenAndSaveInStore(store.username, store.password)

}
</script>

<template>
  <Navbar class="navbar"/>
  <RouterView />
</template>

<style scoped>
</style>
