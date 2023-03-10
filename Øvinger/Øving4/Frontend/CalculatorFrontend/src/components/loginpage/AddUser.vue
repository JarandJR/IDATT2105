<template>
  <div id="container">
    <form >
      <div class="wrapper">
        <label>Username:  </label>
        <input type="text" placeholder="Username" v-model="username" v-on:keyup="validate">
      </div>
      <div class="wrapper">
        <label>Password:  </label>
        <input type="password" placeholder="Password" v-model="password" v-on:keyup="validate">
      </div>
      <div class="wrapper" id="buttons">
        <button v-on:click="signUp" :disabled="valid">Sign up</button>
        <RouterLink id="cancel" to="/login" >Cancel</RouterLink>
      </div>
    </form>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import Router from "@/router";
import {useUserStore} from "@/stores/user";
import axios from "axios";

const username = ref("")
const password = ref("")
const store = useUserStore();
const valid = ref(false);
const router = Router;

async function signUp() {
  const userObj = {
    username: username.value,
    password: password.value
  };
  const response = await axios.post("http://127.0.0.1:8080/user", userObj);
  if (response.status == 201){
    username.value = response.data.username;
    setState();
    await router.push("/login")
  }
}

function setState() {
  store.loggedIn = true;
  store.username = username.value;
}

validate();
function validate() {
  valid.value = !(
      checkMessage(username.value) &&
      checkMessage(password.value)
  );
}

function checkMessage(message:String):boolean {
  return message.length > 0 && isEmpty(message);
}

function isEmpty(str:String):boolean {
  return !str || str.trim().length > 0;
}
</script>

<style scoped>
#buttons {
  display: flex;
  flex-direction: column;;
}

#routerNewUser {
  width: 30%;
}

#buttons div {
  width: 100%;
  text-align: right;
}

form {
  font-size: 2rem;
}

#container {
  margin-top: 7rem;
  display: flex;
  justify-content: center;
  flex-direction: column;
  padding: 2rem;
  background-color: lightseagreen;
  border: solid darkslateblue;
}

.wrapper {
  padding: 1rem;
  display: flex;
  justify-content: center;
  flex-direction: row;
}

label {
  color: black;
  padding-right: 1rem;
  font-weight: bold;
}

button {
  border-radius: 5rem;
  width: 100%;
  font-size: 2rem;
  height: 3rem;
  text-align: center;
  min-width: 20rem;
  padding: 0 10px;
}

button:disabled {
  background-color: dimgrey;
  color: lightgrey;
}

button:hover {
  color: white;
}

input {
  width: 100%;
  height: 3rem;
  font-size: 2rem;
}

@media (max-width: 550px) {
  form, input, textarea, button {
    font-size: 1rem;
  }

  button {
    height: 2rem;
  }
}

#cancel {
  margin-top: 5px;
  background-color: darkred;
  color: white;
  border-radius: 2rem;
  font-size: 2rem;
  text-align: center;
  border: black solid;
  width: 40rem;
}

#cancel:hover {
  background-color: red;
  color: purple;
}
</style>