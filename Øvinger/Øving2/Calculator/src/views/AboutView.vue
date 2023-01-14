<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
  <div class="calculator">
    <div class="calcOutput"></div>
    <div class="calcBtnContainer">
      <div class="calcBtn" id="btnVal-C"><button id="btnC">C</button></div>
      <div class="calcBtn" id="btnVal-ANS"><button id="btnANS">ANS</button></div>
      <div class="calcBtn" id="btnVal- DEL"><button id="btnDEL">DEL</button></div>
      <div class="calcBtn" id="btnVal-Plus"><button id="btnPlus">+</button></div>

      <div class="calcBtn" id="btnVal-One"><button id="btnOne">1</button></div>
      <div class="calcBtn" id="btnVal-Two"><button id="btnTwo">2</button></div>
      <div class="calcBtn" id="btnVal-Three"><button id="btnThree">3</button></div>
      <div class="calcBtn" id="btnVal-Minus"><button id="btnMinus">-</button></div>

      <div class="calcBtn" id="btnVal-Four"><button id="btnFour">4</button></div>
      <div class="calcBtn" id="btnVal-Five"><button id="btnFive">5</button></div>
      <div class="calcBtn" id="btnVal-Six"><button id="btnSix">6</button></div>
      <div class="calcBtn" id="btnVal-Multiplie"><button id="btnMultiplie">x</button></div>

      <div class="calcBtn" id="btnVal-Seven"><button id="btnSeven">7</button></div>
      <div class="calcBtn" id="btnVal-Eight"><button id="btnEight">8</button></div>
      <div class="calcBtn" id="btnVal-Nine"><button id="btnNine">9</button></div>
      <div class="calcBtn" id="btnVal-Divide"><button id="btnDivide">/</button></div>

      <div class="calcBtn" id="btnVal-Modolo"><button id="btnModolo">%</button></div>
      <div class="calcBtn" id="btnVal-Zero"><button id="btnZero">0</button></div>
      <div class="calcBtn" id="btnVal-Comma"><button id="btnComma">.</button></div>
      <div class="calcBtn" id="btnVal-Equal"><button id="btnEqual">=</button></div>
    </div>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
