<template>
  <div id="container">
    <div id="info">
      <h1 id="title">Calculator</h1>
      <p id="infoText">simple but effective</p>
    </div>
    <div id="calc">
      <Calculator @add-logg="addLogg"/>
    </div>
    <div id="logg">
      <Logger :logg="logg"/>
    </div>
  </div>
</template>

<script>
import Calculator from "../components/Calculator.vue";
import Logger from "../components/Logger.vue";

export default {
  name: "CalculatorView",
  components: {
    Calculator,
    Logger
  },
  data() {
    return {
      logg: []
    }
  },
  methods: {
    addLogg(calculation) {
      this.logg = [...this.logg, calculation]
    }
  }
}
</script>

<style scoped>
#info {
  grid-area: info;
}

#calc {
  grid-area: calc;
}

#logg {
  grid-area: logg;
}

#container {
  display: grid;
  grid-template-areas:
            'info calc'
            'logg calc'
            'calc calc';
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
  top: 0;
  width: 100%;
  text-align: left;
  font-family: "Agency FB", serif;
  font-size: 30px;
}

#title {
  font-size: 100px;
}

#calc {
  position: absolute;
  top: 30%;
  left: 45%;
}

#logg {
  position: absolute;
  top: 30%;
  width: 20%;
  text-align: left;
}
</style>