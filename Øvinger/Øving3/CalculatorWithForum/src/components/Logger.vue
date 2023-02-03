<template>
  <div class="scroll">
    <p>Calculation-logg:</p>
    <div :key="l.element1 + l.operator + l.element2 + l.equals + l.result" v-for="l in logg">
      <Calculation :logg="l" />
    </div>
  </div>
</template>

<script>
import Calculation from "./Calculation.vue";

export default {
  name: "Logger",
  props: {
    logg: Array
  },
  components: {
    Calculation,
  }
}
</script>

<style scoped>
.scroll {
  overflow-y: scroll;
  max-height: 400px;
}
</style>