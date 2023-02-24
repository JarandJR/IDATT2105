<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/calculator">Calculator</RouterLink>
        <RouterLink to="/contact">Contact</RouterLink>
      </nav>
    </div>
  </header>
</template>

<script setup lang="ts">
import { RouterLink } from 'vue-router'
</script>

<style scoped>
header {
  line-height: 1.5;
  max-height: 100vh;
  min-width: 265px;
}

nav {
  width: 100%;
  text-align: center;
  /*margin-top: 0;*/
  background-color: lightseagreen;
}

nav a.router-link-exact-active {
  color: white;
  background-color: darkslateblue;
  border-radius: 5rem;
}

nav a.router-link-exact-active:hover {
  background-color: firebrick;
}

nav a {
  padding: 0 1rem;
  font-size: 3rem;
}

@media (max-width: 0px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}

@media (max-width: 600px) {
  nav a{
    font-size: 2rem;
  }
}

@media (max-width: 435px) {
  nav a{
    font-size: 1rem;
  }
}
</style>