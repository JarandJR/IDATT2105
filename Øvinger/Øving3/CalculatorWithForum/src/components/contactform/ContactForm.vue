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
      <div>
        <button  id="submitBtn" type="submit" disabled="disabled" ref="submitBtn">Submit</button>
      </div>
    </form>
  </div>
</template>

<script>
import {useFormStore} from "../../store/form";
import axios from "axios";

export default {
  name: "ContactForm.vue",
  data() {
    return {
      name: "",
      mail: "",
      message: ""
    }
  },
  methods: {
    async submitForm() {
      console.log("Before")
      this.getData()

      const response = await useFormStore().submit(this.name, this.mail, this.message)
      if (response.status === 201) {
        alert("Success")
      }
      console.log(response)

      console.log("After")
      this.getData()
    },
    async getData() {
      const data = await axios.get("http://localhost:3000/form")
      console.log(data)
    },
    validate() {
      this.$refs["submitBtn"].disabled = !(
        this.checkMail() &&
        this.checkName() &&
        this.checkMessage()
      );
    },
    checkName() {
      return this.name.split(" ").length > 1;
    },
    checkMail() {
      return this.mail.split("@").length > 1 && this.mail.split(".").length > 1;
    },
    checkMessage() {
      return this.message.length > 0 && this.isEmpty(this.message);
    },
    isEmpty(str) {
      return !str || str.trim().length > 0;
    }
  },

}
</script>

<style scoped>
form {
  font-family: "Agency FB", serif;
  font-size: 50px;
}

button {
  border-radius: 25px;
  width: 100%;
  font-size: 80%;
  height: 50px;
  text-align: center;
  background-color: green;
  min-width: 350px;
  padding: 0 10px;
}
button:hover:enabled {
    background-color: limegreen;
}

input {
  width: 100%;
  height: 50px;
  font-size: 30px;
  min-width: 350px;
}

textarea {
  resize: none;
  width: 100%;
  height: 100px;
  font-size: 20px;
  min-width: 350px;
}

#container {
  overflow-y: scroll;
}

@media (max-width: 550px) {
  form, input, textarea, button {
    font-size: 20px;
  }
}
</style>