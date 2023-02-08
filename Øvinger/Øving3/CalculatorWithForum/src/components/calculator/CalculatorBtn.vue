<template>
  <div class="calcBtn">
    <button :style="{background: color}">{{ text }}</button>
  </div>
</template>

<script>

export default {
  name: 'CalculatorBtn',
  props: {
    text: String,
    color: String
  }
}
</script>

<style scoped>
button {
  width: 60px;
  height: 30px;
  border-width: 2px;
  border-style: solid;
  text-align: center;
  color: #f2f2f2;
  padding: 0;
  margin: 0;
}
</style>