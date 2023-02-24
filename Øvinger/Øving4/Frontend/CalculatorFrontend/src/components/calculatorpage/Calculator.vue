<template>
  <div class="container">
    <div class="row">

    </div>
    <div class="row">
      <p id="display">{{display}}</p>
    </div>
    <div class="row">
      <button @click="clear">C</button>
      <button @click="lastAnswer">ANS</button>
      <button @click="deleteLastInput">DEL</button>
      <button @click="addOperator('+')">+</button>
    </div>
    <div class="row">
      <button @click="addInput('1')">1</button>
      <button @click="addInput('2')">2</button>
      <button @click="addInput('3')">3</button>
      <button @click="addOperator('-')">-</button>
    </div>
    <div class="row">
      <button @click="addInput('4')">4</button>
      <button @click="addInput('5')">5</button>
      <button @click="addInput('6')">6</button>
      <button @click="addOperator('*')">*</button>
    </div>
    <div class="row">
      <button @click="addInput('7')">7</button>
      <button @click="addInput('8')">8</button>
      <button @click="addInput('9')">9</button>
      <button @click="addOperator('/')">/</button>
    </div>
    <div class="row">
      <button @click="addInput('0')" id="zero">0</button>
      <button @click="addInput('.')">.</button>
      <button @click="equals">=</button>
    </div>
  </div>
</template>

<script setup lang="ts">
import {ref} from "vue";
import {useCalcStore} from "@/stores/calc";
import axios from "axios";

const store = useCalcStore();

const display = ref(store.display);
const previous = ref(store.previous);
const ans = ref(store.ans);

async function equals() {
  //Todo fix bug: If u add an operator and then deletes it. if u add a new operator the number will be deleted
  //Todo fix bug: It is possible to add an operator as the first input. '-' is the only correct operator
  //Todo fix bug: When adding '-' as the first operator, it is possible to change it to another operator
  addPotentialMissingZeros();
  if (display.value.slice(-1) === " ")
    display.value = display.value.slice(0, -3);

  const postBody = {equation: display.value}
  const response = await axios.post("http://127.0.0.1:8080/calculate", postBody);
  //emit to logg display.value + " = " + response.data
  ans.value = response.data;
  clear();
  setState();
}

function clear() {
  display.value = "0";
  previous.value = "";
  setState();
}

function deleteLastInput() {
  const lastChar = display.value.slice(-1);
  let lastIndex = -1;
  if (lastChar === " ") {
    lastIndex *= 3;
  }
  previous.value = display.value.slice(lastIndex);
  display.value = display.value.slice(0, lastIndex);

  if (display.value === "") {
    display.value = "0"
  }
  setState();
}

function lastAnswer() {
  if (ans.value !== "")
    addInput(ans.value);
  setState();
}

function addOperator(input: string) {
  addInput(' ' + input + ' ');
}

function addInput(input: string) {
  if (previous.value === " + " || previous.value === " - " || previous.value === " * " || previous.value === " / ") {
    if (input === " + " || input === " - " || input === " * " || input === " / "){
      display.value = display.value.slice(0, -3);
    } else if (input === ".") {
      return;
    }
  }
  if (previous.value === '.' && input === '.')
    return;

  addInputToDisplay(input);
  if (input === '.' && validateCommas()) {
    //alert("invalid use of '.'");
    deleteLastInput();
    return;
  }
  previous.value = input;
  setState();
}

function addPotentialMissingZeros() {
  const inputs = display.value.split(' ');

  let temp = "";
  for (const i in inputs) {
    if (isOperator(inputs[i]))
      temp += " " + inputs[i] + " ";
    else
      temp += inputs[i];
    if (inputs[i].slice(-1) === '.'){
      temp += "0";
    }
  }
  display.value = temp;
}

function isOperator(s:string):boolean {
  const operators = ["+", "-", "/", "*"];
  for (const o in operators)
    if (s === operators[o])
      return true;
  return false;
}

function validateCommas():boolean {
  const inputs = display.value.split(' ');

  for (const i in inputs) {
    if (countNumberOfCommas(inputs[i]) > 1)
      return true;
  }
  return false;
}

function countNumberOfCommas(s:string) :number {
  let numberOfCommas = 0;
  const chars = s.split('')

  for (const i in chars)
    if (chars[i] === '.')
      numberOfCommas ++;

  return numberOfCommas;
}

function addInputToDisplay(input: string) {
  if (display.value === "0" && input !== ".") {
    display.value = input;
  } else {
    display.value += input;
  }
}

function setState() {
  store.display = display.value;
  store.previous = previous.value;
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