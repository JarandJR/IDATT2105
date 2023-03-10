<template>
  <div class="wrapper">
    <div class="calc-container">
      <Calculator @logCalculation = "log" :equation="calc"/>
    </div>
    <div class="logg-container">
      <CalculationLogg @useCalc="useCalculation" :calculations="calculationsLog"/>
    </div>
  </div>
</template>
<script setup lang="ts">
import Calculator from "@/components/calculatorpage/Calculator.vue";
import CalculationLogg from "@/components/calculatorpage/CalculationLogg.vue";
import {ref} from "vue";

const calculationsLog = ref([]);
const calc = ref("");

function useCalculation(calculation:string) {
  calc.value = calculation;
}

function log(calculation: string) {
  calculationsLog.value.push(calculation)
}
</script>
<style scoped>
.wrapper {
  margin-top: 2rem;
  display: flex;
  flex-direction: row;
  justify-content: center;
  padding: 2rem;
  background-color: lightseagreen;
  border: solid darkslateblue;
}

.calc-container {
  padding: 2rem;
}

.logg-container {
  padding: 2rem;
}

@media (max-width: 750px) {
  .wrapper {
    flex-direction: column;
  }
}
</style>
