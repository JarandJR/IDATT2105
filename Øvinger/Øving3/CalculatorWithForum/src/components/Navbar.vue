<template>
  <div class="wrapper">
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/contact-form">Contact form</RouterLink>
      <RouterLink to="/calculator">Calculator</RouterLink>
    </nav>
  </div>
  <RouterView />
</template>

<script setup lang="ts">
  import { RouterLink, RouterView } from "vue-router";
</script>

<style scoped>
.wrapper {
  position: fixed;
  width: 100%;
  top: 0;
  left: 0;
  background-color: darkblue;
  font-family: 'Exo 2', sans-serif;
  padding: 1em;
}

nav {
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 50px;
  letter-spacing: 5px;
  align-content: center;
}

nav a:hover {
  color: red;
}

nav a {
  margin-left: 5%;
  margin-right: 5%;
}
</style>