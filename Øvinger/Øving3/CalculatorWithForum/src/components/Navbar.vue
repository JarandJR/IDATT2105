<template>
  <div class="wrapper">
    <nav>
      <RouterLink id="routerHome" to="/">Home</RouterLink>
      <RouterLink id="routerForm" to="/contact-form">Contact form</RouterLink>
      <RouterLink id="routerCalc" to="/calculator">Calculator</RouterLink>
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
  font-family: "Agency FB", serif;
}

nav {
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 50px;
  letter-spacing: 5px;
  align-content: center;
  height: 100px;
  min-width: 350px;
}

nav a:hover {
  color: lightskyblue;
}

nav a {
  margin-left: 2%;
  margin-right: 2%;
  color: red;
}

@media (max-width: 950px) {
  nav {
    padding: 30px 16px;
    font-size: 30px;
  }
}

@media (max-width: 650px) {
  nav {
    padding: 43px 5px;
    font-size: 23px;
  }
}

@media (max-width: 430px) {
  nav {
    padding: 48px 5px;
    font-size: 18px;
  }
}
</style>