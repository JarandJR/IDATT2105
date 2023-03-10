<template>
  <div class="wrapper">
    <h1>Welcome to my app</h1>
    <p>Greetings from backend: {{connection}}</p>
    <button @click="testConnection">Test connection</button>
    <button id="danger" v-on:click="clearDatabase">Clear Database</button>
  </div>
</template>

<script setup lang="ts">
import axios from "axios";
import {ref} from "vue";

const connection = ref("Not Connected");

async function testConnection(){
  connection.value = await (await axios.get("http://127.0.0.1:8080/")).data;
}

async function clearDatabase() {
  const response = await axios.delete("http://127.0.0.1:8080/clear/all");
  console.log(response.status);
}
</script>

<style scoped>
.wrapper {
  margin-top: 7rem;
  display: flex;
  justify-content: center;
  flex-direction: column;
  padding: 2rem;
  background-color: lightseagreen;
  border: solid darkslateblue;
}

.wrapper button:hover {
  background-color: lightcyan;
}

#danger {
  margin-top: 5px;
  background-color: darkred;
  color: white;
  border-radius: 2rem;
  font-size: 2rem;
  text-align: center;
  border: black solid;
  width: 40rem;
}

#danger:hover {
  background-color: red;
  color: darkslateblue;
}
</style>