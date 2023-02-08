<template>
  <div id="container">
    <div id="info">
      <h1 id="title">Calculator</h1>
      <p id="infoText">simple but effective</p>
    </div>
      <div id="logg">
        <Logger :logg="logg"/>
      </div>
      <div id="calc">
        <Calculator @add-logg="addLogg"/>
      </div>
  </div>
</template>

<script>
import Calculator from "../components/calculator/Calculator.vue";
import Logger from "../components/calculator/Logger.vue";

export default {
  name: "CalculatorView",
  components: {
    Calculator,
    Logger,
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
}

#info {
  position: relative;
  top: 0;
  text-align: left;
  font-family: "Agency FB", serif;
  font-size: 30px;
}

#title {
  font-size: 80px;
}

#calc {
  position: absolute;
  margin-top: 200px;
  justify-self: center;
}

#logg {
  position: relative;
  align-self: flex-start;
  text-align: left;
  margin-left: 10px;
}
</style>