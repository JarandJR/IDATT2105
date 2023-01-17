<script setup>
import CalculatorBtn from './CalculatorBtn.vue'
</script>

<template>
  <div id="grid-container">
    <p id="display">{{ input }}</p>

    <CalculatorBtn id="C" text="C" color="grey" @click="clear(0)"/>
    <CalculatorBtn id="ANS" text="ANS" color="grey" @click="ans"/>
    <CalculatorBtn id="DEL" text="DEL" color="grey" @click="del"/>

    <CalculatorBtn id="plus" text="+" color="grey" @click="addOperator('+')"/>
    <CalculatorBtn id="minus" text="-" color="grey" @click="addOperator('-')"/>
    <CalculatorBtn id="divide" text="/" color="grey" @click="addOperator('/')"/>
    <CalculatorBtn id="multiply" text="x" color="grey" @click="addOperator('x')"/>

    <CalculatorBtn id="zero" text="0" color="grey" @click="addElement('0')"/>
    <CalculatorBtn id="one" text="1" color="grey" @click="addElement('1')"/>
    <CalculatorBtn id="two" text="2" color="grey" @click="addElement('2')"/>
    <CalculatorBtn id="three" text="3" color="grey" @click="addElement('3')"/>
    <CalculatorBtn id="four" text="4" color="grey" @click="addElement('4')"/>
    <CalculatorBtn id="five" text="5" color="grey" @click="addElement('5')"/>
    <CalculatorBtn id="six" text="6" color="grey" @click="addElement('6')"/>
    <CalculatorBtn id="seven" text="7" color="grey" @click="addElement('7')"/>
    <CalculatorBtn id="eight" text="8" color="grey" @click="addElement('8')"/>
    <CalculatorBtn id="nine" text="9" color="grey" @click="addElement('9')"/>

    <CalculatorBtn id="blank" text="" color="grey" @click="hiddenFeature"/>
    <CalculatorBtn id="comma" text="." color="grey" @click="addComma"/>
    <CalculatorBtn id="equal" text="=" color="orange" @click="equal()"/>
  </div>
</template>

<script>
export default {
  methods: {
    addElement(input) {
      if (this.result !== 0) {
        this.input = "";
        this.result = 0;
      }
      if (this.input.toString().slice(-1) === ".") {
        console.log("ASd");
        return this.input += input;
      }
      else if (parseFloat(this.input) === 0) {
        return this.input = input;
      }
      this.input += input;
    },
    setElement1(n) {
      this.element1 = n;
    },
    setElement2(n) {
      this.element2 = n;
    },
    setOperator(o) {
      if (this.operator === o) {
        return this.operator = "";
      }
      else if (this.operator !== "") {
        return this.operator = "";
      }
      this.operator = o;
    },
    addOperator(o) {
      this.setElement1(parseFloat(this.input));

      this.setOperator(o);
      if (this.operator === "") {
        this.del();
      }
      this.operator = o;
      this.addElement(this.operator);
    },
    del() {
      if (this.input.slice(-1) === this.operator){
        this.operator = "";
      }
      this.input = this.input.slice(0, -1);
      if (this.input === "") {
        this.clear();
      }
    },
    ans() {
      this.addElement(this.previousResult);
    },
    clear(n) {
      this.input = n;
      this.element1 = 0;
      this.operator = "";
      this.element2 = 0;
    },
    equal() {
      this.setElement2(parseFloat(this.input.split(this.operator)[1]));

      if (this.operator === "") {
        return;
      }
      else if (this.operator === "+") {
        this.result = this.element1 + this.element2;
      }
      else if (this.operator === "-") {
        this.result = this.element1 - this.element2;
      }
      else if (this.operator === "x") {
        this.result = this.element1 * this.element2;
      }
      else {
        this.result = this.element1 / this.element2;
      }
      this.loggResult();
      this.input = this.result;
      this.previousResult = this.result;
      this.clear(this.result);
    },
    loggResult() {
      const newLogg = {
        element1: this.element1,
        operator: this.operator,
        element2: this.element2,
        equals: this.equals,
        result: this.result,
      }
      this.$emit('add-logg', newLogg);
    },
    addComma() {
      if (this.input === 0 || this.input.slice(-1) === ".") {
        return;
      }
      if (this.input.split(".").length <= 1 && this.element1 === 0) {
        this.input += ".";
      }
      else if (this.input.split(this.operator)[1].split(".").length <= 1 && this.operator !== ""){
        this.input += ".";
      }
    },
    hiddenFeature() {
      console.log("Congratulations!!!");
    }
  },
  data() {
    return {
      input: 0,
      element1: 0,
      operator: "",
      element2: 0,
      equals: " = ",
      result: 0,
      previousResult: 0,
    }
  }
}
</script>

<style scoped>

#display {grid-area: display;}

#C {grid-area: C;}
#ANS {grid-area: ANS;}
#DEL {grid-area: DEL;}
#plus {grid-area: plus;}
#minus {grid-area: minus;}
#divide {grid-area: divide;}
#multiply {grid-area: multiply;}
#comma {grid-area: comma;}
#equal {grid-area: equal;}
#blank {grid-area: blank;}

#zero {grid-area: zero;}
#one {grid-area: one;}
#two {grid-area: two;}
#three {grid-area: three;}
#four {grid-area: four;}
#five {grid-area: five;}
#six {grid-area: six;}
#seven {grid-area: seven;}
#eight {grid-area: eight;}
#nine {grid-area: nine;}

#grid-container {
  width: 300px;
  height: 350px;
  display: grid;
  grid-template-areas:
            'display display display display'
            'C ANS DEL plus'
            'one two three minus'
            'four five six multiply'
            'seven eight nine divide'
            'blank zero comma equal';
  gap: 10px;
  padding: 10px;
  margin: 0;
  background-color: lightgrey;
  border-style: solid;
  border-color: black;
  border-width: 2px;
  text-align: center;
}

#display {
  background-color: grey;
  width: 275px;
  height: 35px;
  color: white;
  text-align: center;
  border-color: black;
  border-width: 2px;
  border-style: solid;
}
</style>
