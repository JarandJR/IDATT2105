<template>
  <div class="wrapper">
    <div class="calc-container">
      <Calculator @logCalculation = "log"/>
    </div>
    <div class="logg-container">
      <CalculationLogg :calculations="calculationsLog"/>
    </div>
  </div>
</template>
<script setup lang="ts">
import Calculator from "@/components/calculatorpage/Calculator.vue";
import CalculationLogg from "@/components/calculatorpage/CalculationLogg.vue";
import {ref} from "vue";

const calculationsLog = ref([]);

function log(calculation: string) {
  calculationsLog.value.push(calculation)
}
</script>
<style>
.wrapper {
  display: flex;
  flex-direction: row;
  justify-content: center;
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
