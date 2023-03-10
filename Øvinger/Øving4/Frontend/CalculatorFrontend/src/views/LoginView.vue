<template>
  <div id="container">
    <Login v-show="!loggedInStatus" @login = "update"/>
    <Profile v-show="loggedInStatus" @login = "updateLogOut" :username="username" :calculations="calculationsLog"/>
  </div>
</template>

<script setup lang="ts">

import Login from "../components/loginpage/Login.vue";
import Profile from "../components/loginpage/Profile.vue";
import {useUserStore} from "../stores/user";
import {ref} from "vue";
import axios from "axios";

const store = useUserStore();
const loggedInStatus = ref(store.loggedIn);
const username = ref(store.username);
const calculationsLog = ref([]);

async function update() {
  loggedInStatus.value = store.loggedIn;
  username.value = store.username;
  calculationsLog.value = (await axios.get("http://127.0.0.1:8080/red/equations/" + username.value)).data;
  await loggList()
}

async function loggList() {
  if (store.loggedIn) {
    const response = await axios.get("http://127.0.0.1:8080/red/equations/" + store.username);
    const equations: Equation[] = response.data;
    const results: number[] = equations.map((equation: Equation) => equation.result);
    if (results.length > 0) {
      for (let i = 0; i < results.length; i++) {
        calculationsLog.value.push(`${equations[i].equation} = ${results[i]}`);
      }
    }
  }
}
loggList();

interface Equation {
  id: number;
  equation: string;
  result: number;
  user: any;
  completeEquation: string;
}

function updateLogOut() {
  loggedInStatus.value = store.loggedIn;
}
</script>

<style scoped>
#container {
  display: flex;
  justify-content: center;
  padding: 2rem;
}
</style>