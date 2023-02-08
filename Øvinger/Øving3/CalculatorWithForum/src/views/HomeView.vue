<script>

</script>

<template>
  <div id="container">
    <h1>Welcome</h1>
    <p>This is my homepage</p>
  </div>
</template>

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
  font-size: 100px;
  font-family: "Agency FB", serif;
  min-width: 350px;
}

@media (max-width: 650px) {
  #container {
    font-size: 50px;
  }
}
</style>
