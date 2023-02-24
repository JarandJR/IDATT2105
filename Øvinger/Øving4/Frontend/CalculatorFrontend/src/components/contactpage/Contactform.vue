<template>
  <div id="container">
    <form @submit.prevent="submitForm">
      <div>
        <label>Full name: </label>
        <input id="inputName" type="text" placeholder="Name" v-model="name" name="name" v-on:keydown="validate" v-on:change="validate" v-on:keyup="validate">
      </div>
      <div>
        <label>E-mail: </label>
        <input id="inputMail" type="text" placeholder="E-mail" v-model="mail" name="mail" v-on:keydown="validate()" v-on:change="validate" v-on:keyup="validate">
      </div>
      <div>
        <label>Message: </label>
        <textarea id="inputMessage" placeholder="message" v-model="message" name="message" v-on:keydown="validate" @click="validate" v-on:change="validate" v-on:keyup="validate"/>
      </div>
      <div class="wrapper">
        <button  id="submitBtn" type="submit" disabled="disabled" ref="submitBtn">Submit</button>
      </div>
    </form>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";

const name = ref("")
const mail = ref("")
const message = ref("")

async function submitForm() {
  //const response = await useFormStore().submit(this.name, this.mail, this.message)
  const response = 201;
  if (response/*.status*/ === 201) {
    alert("Success")
  }
  console.log(response)
}

function validate() {
  /*this.$refs["submitBtn"].disabled = !(
      this.checkMail() &&
      this.checkName() &&
      this.checkMessage()
  );*/
}

function checkName() {
  return name.value.split(" ").length > 1;
}

function checkMail() {
  return mail.value.split("@").length > 1 && mail.value.split(".").length > 1;
}

function checkMessage() {
  return message.value.length > 0 && isEmpty(message.value);
}

function isEmpty(str:String) {
  return !str || str.trim().length > 0;
}

</script>
<style scoped>
form {
  font-size: 2rem;
}

.wrapper {
  display: flex;
  justify-content: center;
}

button {
  border-radius: 5rem;
  width: 100%;
  font-size: 2rem;
  height: 3rem;
  text-align: center;
  background-color: green;
  min-width: 20rem;
  padding: 0 10px;
}

button:hover {
  color: white;
}

button:hover:enabled {
  background-color: limegreen;
}

input {
  width: 100%;
  height: 3rem;
  font-size: 2rem;
}

textarea {
  resize: none;
  width: 100%;
  height: 15rem;
  font-size: 1rem;
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