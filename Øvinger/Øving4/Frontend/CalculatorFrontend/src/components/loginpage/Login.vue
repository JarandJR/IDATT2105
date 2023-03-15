<template>
  <div id="container">
        <div class="wrapper">
          <label>Username:  </label>
          <input type="text" placeholder="Username" v-model="username" v-on:keyup="validate">
        </div>
        <div class="wrapper">
          <label>Password:  </label>
          <input type="password" placeholder="Password" v-model="password" v-on:keyup="validate">
        </div>
        <div class="wrapper" id="buttons">
          <button v-on:click="login" :disabled="valid">Login</button>
          <div>
            <button id="routerNewUser" v-on:click="newUser">Create user</button>
          </div>
        </div>
  </div>
</template>

<script setup lang="ts">
import {useUserStore} from "../../stores/user";
import {ref} from "vue";
import Router from "@/router";

const emit = defineEmits(['login'])
const store = useUserStore();
const router = Router;
const username = ref("");
const password = ref("");
const valid = ref(false);


function newUser() {
  router.push("/newuser");
}

async function login() {
  await store.getTokenAndSaveInStore(username.value, password.value);
  if(store.loggedIn) {
    emit("login")
  }
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

#routerNewUser {
  border-radius: 2rem;
  background-color: darkslateblue;
  color: white;
  width: 40rem;
}

#routerNewUser:hover {
  background-color: lightcyan;
  color: darkslateblue;
}

#container {
  font-size: 2rem;
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

</style>