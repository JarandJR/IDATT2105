<template>
  <div class="container">
    <div class="row">

    </div>
    <div class="row">
      <p id="display">{{display}}</p>
    </div>
    <div class="row">
      <button>C</button>
      <button>ANS</button>
      <button>DEL</button>
      <button @click="addInput('+')">+</button>
    </div>
    <div class="row">
      <button @click="addInput('1')">1</button>
      <button @click="addInput('2')">2</button>
      <button @click="addInput('3')">3</button>
      <button @click="addInput('-')">-</button>
    </div>
    <div class="row">
      <button @click="addInput('4')">4</button>
      <button @click="addInput('5')">5</button>
      <button @click="addInput('6')">6</button>
      <button @click="addInput('*')">*</button>
    </div>
    <div class="row">
      <button @click="addInput('7')">7</button>
      <button @click="addInput('8')">8</button>
      <button @click="addInput('9')">9</button>
      <button @click="addInput('/')">/</button>
    </div>
    <div class="row">
      <button @click="addInput('0')" id="zero">0</button>
      <button @click="addInput('.')">.</button>
      <button>=</button>
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import {useCalcStore} from "@/stores/calc";

const store = useCalcStore();
const display = ref(store.display);

function addInput(input:string) {
  if (display.value === "0") {
    display.value = input;
  } else {
    display.value += input;
  }
  store.display = display.value;
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;

  width: 20rem;
  height: 26rem;
  gap: 10px;
  padding: 10px;
  margin: 0;
  background-color: lightgrey;
  border-style: solid;
  border-color: black;
  border-width: 2px;
}

.row {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.row button {
  border-radius: 1rem;
  width: 5rem;
  height: 3.5rem;
}

#zero {
  width: 8.5rem;
}

p {
  font-size: 1rem;
  background-color: grey;
  width: 20rem;
  height: 3rem;
  color: white;
  text-align: center;
  border-color: black;
  border-width: 2px;
  border-style: solid;
}
</style>