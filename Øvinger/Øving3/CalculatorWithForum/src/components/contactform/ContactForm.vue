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

</style>