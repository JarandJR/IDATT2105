<template>
  <div>
    <form @submit.prevent="submitForm">
      <div>
        <label>Full name: </label>
        <input type="text" placeholder="Name" v-model="name" name="name" required>
      </div>
      <div>
        <label>E-mail: </label>
        <input type="text" placeholder="E-mail" v-model="mail" name="mail" required>
      </div>
      <div>
        <label>Message: </label>
        <textarea placeholder="Message" v-model="message" name="message" required/>
      </div>
      <div>
        <button type="submit">Submit</button>
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
    async submitForm() {
      const {name, mail, message} = this;
      console.log(name + " " + mail + " " + message);
    }
  }
}
</script>

<style scoped>
form {
  font-family: "Agency FB", serif;
}

button {
  width: 100%;
  height: 30px;
  font-size: 70%;
  text-align: center;
  background-color: limegreen;
  min-width: 350px;
  padding: 0 10px;
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