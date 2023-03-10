<template>
  <header>
    <div class="wrapper">
      <nav>
        <div class="left">
          <RouterLink id="routerHome" to="/">Home</RouterLink>
        </div>
        <div class="center">
          <RouterLink id="routerCalc" to="/calculator">Calculator</RouterLink>
          <RouterLink id="routerForm" to="/contact">Contact</RouterLink>
        </div>
        <div class="right">
          <RouterLink id="routerLogin" to="/login">Profile </RouterLink>
        </div>
      </nav>
    </div>
  </header>
</template>

<script setup lang="ts">
</script>

<style scoped>

.left {
  grid-area: left;
  text-align: left;
}
.center {
  grid-area: center;
  text-align: center;
}
.right {
  grid-area: right;
  text-align: right;
  margin-right: 2rem;
}

img {
  border-radius: 7rem;
  width: 4rem;
  height: auto;
}

header {
  line-height: 1.5;
  max-height: 100vh;
  min-width: 265px;
}

nav {
  border: darkslateblue solid;
  display: grid;
  grid-template-areas:
            'left center right';
  gap: 10px;
  width: 100%;
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

@media (max-width: 800px) {
  nav a{
    font-size: 2rem;
  }
}

@media (max-width: 600px) {
  nav a{
    font-size: 1rem;
  }
}
</style>