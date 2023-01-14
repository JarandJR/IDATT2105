<script setup>
import CalculatorBtn from './CalculatorBtn.vue'
</script>

<template>
  <div id="container">
  <div id="logger">
    <p>Logg:</p>
    <ul id="logg">
      <li>- element</li>
      <li>- element</li>
      <li>- element</li>
    </ul>
  </div>
  </div>
  <div id="grid-container">
    <p id="display">{{ input }}</p>

    <CalculatorBtn id="C" text="C" color="grey" @click="clear"/>
    <CalculatorBtn id="ANS" text="ANS" color="grey" @click="log"/>
    <CalculatorBtn id="DEL" text="DEL" color="grey" @click="log"/>
    <CalculatorBtn id="plus" text="+" color="grey" @click="log"/>

    <CalculatorBtn id="one" text="1" color="grey" @click="addInput('1')"/>
    <CalculatorBtn id="two" text="2" color="grey" @click="log"/>
    <CalculatorBtn id="three" text="3" color="grey" @click="log"/>
    <CalculatorBtn id="minus" text="-" color="grey" @click="log"/>

    <CalculatorBtn id="four" text="4" color="grey" @click="log"/>
    <CalculatorBtn id="five" text="5" color="grey" @click="log"/>
    <CalculatorBtn id="six" text="6" color="grey" @click="log"/>
    <CalculatorBtn id="multiply" text="x" color="grey" @click="log"/>

    <CalculatorBtn id="seven" text="7" color="grey" @click="log"/>
    <CalculatorBtn id="eight" text="8" color="grey" @click="log"/>
    <CalculatorBtn id="nine" text="9" color="grey" @click="log"/>
    <CalculatorBtn id="divide" text="/" color="grey" @click="log"/>

    <CalculatorBtn id="blank" text="" color="grey"/>
    <CalculatorBtn id="zero" text="0" color="grey" @click="log"/>
    <CalculatorBtn id="comma" text="." color="grey" @click="log"/>
    <CalculatorBtn id="equal" text="=" color="orange" @click="log"/>
  </div>
</template>

<script>
export default {
  methods: {
    log() {
      this.input += "YES";
    },
    addInput(input) {
      if (this.input === 0) {
        return this.input = input;
      }
      this.input += input;
    },
    clear() {
      this.input = 0;
    }
  },
  data() {
    return {
      input: 0,
    }
  }
}
</script>

<style scoped>
#logger {
  grid-area: logger;
}

#display {
  grid-area: display;
}

#C {
  grid-area: C;
}

#ANS {
  grid-area: ANS;
}

#DEL {
  grid-area: DEL;
}

#plus {
  grid-area: plus;
}

#one {
  grid-area: one;
}

#two {
  grid-area: two;
}

#three {
  grid-area: three;
}

#minus {
  grid-area: minus;
}

#four {
  grid-area: four;
}

#five {
  grid-area: five;
}

#six {
  grid-area: six;
}

#multiply {
  grid-area: multiply;
}

#seven {
  grid-area: seven;
}

#eight {
  grid-area: eight;
}

#nine {
  grid-area: nine;
}

#divide {
  grid-area: divide;
}

#blank {
  grid-area: blank;
}

#zero {
  grid-area: zero;
}

#comma {
  grid-area: comma;
}

#equal {
  grid-area: equal;
}

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


ul {
  list-style: none none;
}
</style>
