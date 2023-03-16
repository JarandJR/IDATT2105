<template>
  <div id="container">
    <Login v-show="!loggedInStatus" @login = "update"/>
    <Profile v-show="loggedInStatus" @login = "updateLogOut" :username="username" :calculations="calculationsLog"/>
  </div>
</template>

<script setup lang="ts">

import Login from "../components/loginpage/Login.vue";
import Profile from "../components/loginpage/Profile.vue";
import {useUserStore} from "@/stores/user";
import {ref, watch} from "vue";
import axios from "axios";

const store = useUserStore();
const loggedInStatus = ref(store.loggedIn);
const username = ref(store.username);
const calculationsLog = ref<string[]>([]);

watch(() => store.loggedIn, loggList);

async function update() {
  loggedInStatus.value = store.loggedIn;
  username.value = store.username;
  const config = {
    headers: {
      "Content-type": "application/json",
      "Authorization" : "Bearer " + store.jwtToken
    },
  };
  calculationsLog.value = (await axios.get("http://127.0.0.1:8080/red/equations/" + username.value, config)).data;
}

async function loggList() {
  if (store.loggedIn) {
    const response = await getUserInfo();
    const data: Equation[] = response.data;
    const equations: string[] = data.map((eq: Equation) => eq.equation);
    const results: number[] = data.map((equation: Equation) => equation.result);
    for (let i = 0; i < results.length; i++) {
      calculationsLog.value.push(equations[i] + " = " + results[i]);
    }
  }
}

function getUserInfo() {
  const config = {
    headers: {
      "Content-type": "application/json",
      "Authorization" : "Bearer " + store.jwtToken
    },
  };
  return axios.get("http://localhost:8080/red/equations/" + store.username, config);
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