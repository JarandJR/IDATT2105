<template>
  <div id="container">
    <div class="profile">
      <h1>Username: {{props.username}}</h1>
    </div>
    <div class="logOut">
      <button v-on:click="logOut">Log out</button>
    </div>
    <div class="logg">
      <h2>Calculation-log:</h2>
      <ul>
        <li v-for="c in equations" :key="c">{{ c }}</li>
      </ul>
    </div>
  </div>
</template>

<script setup lang="ts">
import {useUserStore} from "@/stores/user";

const store = useUserStore();
const emit = defineEmits(['login'])
const props = defineProps({
  username: String,
  calculations: Array
})

let equations = props.calculations;

function logOut() {
  store.username = "undefined";
  store.loggedIn = false;
  emit("login");
}
</script>

<style scoped>
#container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  width: 100%;
  align-content: center;
  min-width: 500px;
}

.profile {
  text-align: center;
  padding: 1rem;
  align-content: center;
  width: 100%;
}

.logOut {
  width: 100%;
  text-align: center;
}

.logOut button {
  width: 30%;
  height: 3rem;
  font-size: 2rem;
}

ul {
  list-style: none;
}

h1 {
  font-weight: bold;
  font-size: 3rem;
}

.logg {
  text-align: center;
  align-content: center;
  width: 100%;
}
</style>