<template>
  <div class="wrapper">
    <h1>Welcome to my app</h1>
    <p>Greetings from backend: {{connection}}</p>
    <button @click="testConnection">Test connection</button>
  </div>
</template>

<script setup lang="ts">
import axios from "axios";
import {ref} from "vue";

const connection = ref("Not Connected");

async function testConnection(){
  connection.value = await (await axios.get("http://127.0.0.1:8080/")).data;
}
</script>

<style scoped>
.wrapper {
  justify-content: center;
  padding: 2rem;
}
</style>