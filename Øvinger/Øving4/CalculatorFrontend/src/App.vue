<script setup lang="ts">
import Navbar from "@/components/global/Navbar.vue";
import { RouterView } from 'vue-router'
</script>

<template>
  <Navbar class="navbar"/>
  <RouterView />
</template>

<style scoped>
</style>
