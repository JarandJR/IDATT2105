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

<style scoped>
#container {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: darkslategrey;
  color: white;
  position: fixed;
  top: 130px;
  left: 0;
  right: 0;
  bottom: 0;
  font-size: 250%;
}
</style>
