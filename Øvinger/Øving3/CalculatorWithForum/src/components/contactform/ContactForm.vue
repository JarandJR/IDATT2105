<template>
  <div>
    <form @submit.prevent="submitForm">
      <div>
        <label>Full name: </label>
        <input type="text" placeholder="Name" v-model="name" name="name" v-on:keydown="validate" v-on:change="validate" v-on:keyup="validate">
      </div>
      <div>
        <label>E-mail: </label>
        <input type="text" placeholder="E-mail" v-model="mail" name="mail" v-on:keydown="validate()" v-on:change="validate" v-on:keyup="validate">
      </div>
      <div>
        <label>Message: </label>
        <textarea placeholder="Message" v-model="message" name="message" v-on:keydown="validate" @click="validate" v-on:change="validate" v-on:keyup="validate"/>
      </div>
      <div>
        <button  type="submit" disabled="disabled" ref="submitBtn">Submit</button>
      </div>
    </form>
  </div>
</template>

<script>
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
    submitForm() {
      /*
      * To do!
      * fix state on mail and name
      * mock json-server
      * unit test for calculator and form
      * scenario tests for contact form
      * */
      //this.$store.commit("SET_NAME",this.name);
      //this.$store.commit("SET_EMAIL",this.mail);
      //let counter = 0;
      //console.log(counter);
      //this.$store.commit("increment", counter);
      //console.log(counter);

      const { name, mail, message } = this;
      console.log(name + " " + mail + " " + message);
      //this.name = this.$store.name;
      //this.mail = this.$store.mail;
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
  }
}
</script>

<style scoped>
form {
  font-family: "Agency FB", serif;
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
  height: 200px;
  font-size: 20px;
  min-width: 350px;
}

@media (max-width: 550px) {
  form, input, textarea, button {
    font-size: 20px;
  }
}
</style>