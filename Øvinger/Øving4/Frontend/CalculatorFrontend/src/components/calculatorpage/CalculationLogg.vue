<template>
  <div class="container">
    <h2>Calculation-log:</h2>
    <ul>
      <li v-for="c in props.calculations" :key="c">{{ c }}</li>
    </ul>
  </div>
</template>

<script setup lang="ts">

const props = defineProps({
  calculations: Array
})
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;

  font-size: 1rem;
  color: white;
  width: 20rem;
  height: 26rem;
  padding: 0;
  margin: 0;
  background-color: darkgrey;
  border-style: solid;
  border-color: black;
  border-width: 2px;

  overflow-y: auto;
}
</style>