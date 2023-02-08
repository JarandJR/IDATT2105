<template>
  <div class="calculation">
    <h3>{{logg.element1 + logg.operator + logg.element2 + logg.equals + logg.result}}</h3>
  </div>
</template>

<script>
export default {
  name: "Calculation",
  props: {
    logg: Object
  }
}
</script>

<style scoped>

.calculation {
  margin: 0;
  padding: 1px 20px;
  cursor: pointer;
}

.calculation h3 {
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-style: solid;
  border-width: 3px;
  border-color: #181818;
}
</style>