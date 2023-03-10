<template>
  <div class="container">
    <div class="row">
    </div>
    <div class="row">
      <p id="display">{{display}}</p>
    </div>
    <div class="row">
      <button @click="clear('0')">C</button>
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
import {ref, watch} from "vue";
import {useCalcStore} from "@/stores/calc";
import axios from "axios";
import {useUserStore} from "@/stores/user";

//Todo bug: When a user has calculated a value, and then proceeds to calculate on the newly calculated value an error occurs.
// The error makes it impossible to add an operator
//Todo feature: It is atm impossible to multiply with -1 or any other negative number
const store = useCalcStore();
const userStore = useUserStore();
const emit = defineEmits(['logCalculation'])

const props = defineProps({
  equation: String
})
const { equation } = props;


const display = ref(store.display);
const previous = ref(store.previous);
const ans = ref(store.ans);

async function equals() {
  if (display.value.slice(-1) === " ")
    display.value = display.value.slice(0, -3);

  const postBody = {equation: display.value}
  const response = await axios.post("http://127.0.0.1:8080/calculate", postBody);

  const result = Math.round((response.data + Number.EPSILON) * 100) / 100;
  emit('logCalculation', (display.value + " = " + result))
  if (userStore.loggedIn) {
    const postBody = {
      equation: display.value,
      result: result
    };
    await axios.post("http://127.0.0.1:8080/equation/" + userStore.username, postBody);
  }
  ans.value = response.data;
  clear(response.data.toString());
  setState();
}
interface Equation {
  id: number;
  equation: string;
  result: number;
  user: any;
  completeEquation: string;
}

async function loggList() {
  if (userStore.loggedIn) {
    const response = await axios.get("http://127.0.0.1:8080/red/equations/" + userStore.username);
    const equations: Equation[] = response.data;
    const results: number[] = equations.map((equation: Equation) => equation.result);
    if (results.length > 0) {
      for (let i = 0; i < results.length; i++) {
        emit('logCalculation', `${equations[i].equation} = ${results[i]}`);
      }
    }
  }
}
loggList();

watch(() => props.equation, setProps);

function setProps() {
  if (props.equation !== "") {
    display.value = props.equation
    display.value = display.value.slice(0, -1);
  }
}

function clear(current:string) {
  display.value = current;
  previous.value = "";
  setState();
}

function deleteLastInput() {
  const lastChar = display.value.slice(-1);
  let lastIndex = -1;
  if (lastChar === " ") {
    lastIndex *= 3;
  }
  display.value = display.value.slice(0, lastIndex);
  previous.value = display.value.slice(lastIndex);

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
  if (display.value.trim().length === 1){
    if (input !== "-")
      if (isOperator(display.value.trim()) || display.value === "0") {
        return;
      }
  }
  if (isOperator(previous.value.trim())) {
    if (isOperator(input.trim())){
      display.value = display.value.slice(0, -3);
    } else if (input === ".") {
      return;
    }
  }
  addInput(' ' + input + ' ');
}

function addInput(input: string) {
  if (previous.value === '.' && input === '.')
    return;

  addInputToDisplay(input);
  if (input === '.' && validateCommas()) {
    //Todo Feature: Add some way of alerting the user that they are doing something wrong
    deleteLastInput();
    return;
  }
  previous.value = input;
  setState();
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

function isANumber(s:string):boolean {
  const numbers = ["0","1","2","3","4","5","6","7","8","9",]
  for (const n in numbers)
    if (s === numbers[n])
      return true;
  return false;
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