<template>
  <div id="container">
    <AddUser/>
  </div>
</template>

<script setup lang="ts">

import AddUser from "@/components/loginpage/AddUser.vue";
</script>

<style scoped>
#container {
  display: flex;
  justify-content: center;
  padding: 2rem;
}
</style>