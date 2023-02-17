<template>
  <div class="wrapper">
    <div class="calc-container">
      <Calculator/>
    </div>
    <div class="logg-container">
      <CalculationLogg/>
    </div>
  </div>
</template>
<script setup lang="ts">

import Calculator from "@/components/calculatorpage/Calculator.vue";
import CalculationLogg from "@/components/calculatorpage/CalculationLogg.vue";
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
</style>
