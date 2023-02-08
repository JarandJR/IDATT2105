<template>
  <div id="container">
    <ContactForm/>
  </div>
</template>

<script>
import ContactForm from "../components/contactform/ContactForm.vue";

export default {
  name: "ContactFormView",
  components: {
    ContactForm
  }
}
</script>

<style>
#container {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: darkslategrey;
  color: white;
  position: fixed;
  top: 18.4%;
  left: 0;
  right: 0;
  bottom: 0;
  font-size: 250%;
}

button {
  width: 100%;
  height: 30px;
  font-size: 70%;
  text-align: center;
  background-color: limegreen;
}

input {
  width: 100%;
  height: 50px;
  font-size: 30px;
}

textarea {
  resize: none;
  width: 100%;
  height: 200px;
  font-size: 20px;
}
</style>
