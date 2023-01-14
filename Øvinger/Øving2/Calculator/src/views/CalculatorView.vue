<template>
  <div id="container">

    <div id="info">
      <h1 id="title">Calculator</h1>
      <p id="infoText">simple but effective</p>
    </div>

    <div id="calc">
      <Calculator/>
    </div>
  </div>
</template>

<script>
import Calculator from "../components/Calculator.vue";

export default {
  name: "CalculatorView",
  components: {Calculator},
}
</script>

<style scoped>
#info { grid-area: info; }
#calc { grid-area: calc; }

#container {
  display: grid;
  grid-template-areas:
            'info'
            'calc';
  background-color: darkslategrey;
  color: white;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

#info {
  position: absolute;
  top: 50%;
  width: 100%;
  text-align: center;
}

#calc {
  position: absolute;
  top: 50%;
  left: 45%;
}
</style>