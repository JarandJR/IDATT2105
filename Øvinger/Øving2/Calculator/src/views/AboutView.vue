<template>
  <div class="about">
    <h1>This is an about page</h1>
  </div>
  <div class="calculator">
    <div class="calcOutput"></div>
    <div class="calcBtnContainer">
      <div class="calcBtn" id="btnVal-C"><button id="btnC"></button></div>
      <div class="calcBtn" id="btnVal-ANS"><button id="btnANS"></button></div>
      <div class="calcBtn" id="btnVal- DEL"><button id="btnDEL"></button></div>
      <div class="calcBtn" id="btnVal-Plus"><button id="btnPlus"></button></div>

      <div class="calcBtn" id="btnVal-One"><button id="btnOne"></button></div>
      <div class="calcBtn" id="btnVal-Two"><button id="btnTwo"></button></div>
      <div class="calcBtn" id="btnVal-Three"><button id="btnThree"></button></div>
      <div class="calcBtn" id="btnVal-Minus"><button id="btnMinus"></button></div>

      <div class="calcBtn" id="btnVal-Four"><button id="btnFour"></button></div>
      <div class="calcBtn" id="btnVal-Five"><button id="btnFive"></button></div>
      <div class="calcBtn" id="btnVal-Six"><button id="btnSix"></button></div>
      <div class="calcBtn" id="btnVal-Multiplie"><button id="btnMultiplie"></button></div>

      <div class="calcBtn" id="btnVal-Seven"><button id="btnSeven"></button></div>
      <div class="calcBtn" id="btnVal-Eight"><button id="btnEight"></button></div>
      <div class="calcBtn" id="btnVal-Nine"><button id="btnNine"></button></div>
      <div class="calcBtn" id="btnVal-Divide"><button id="btnDivide"></button></div>

      <div class="calcBtn" id="btnVal-Modolo"><button id="btnModolo"></button></div>
      <div class="calcBtn" id="btnVal-Zero"><button id="btnZero"></button></div>
      <div class="calcBtn" id="btnVal-Comma"><button id="btnComma"></button></div>
      <div class="calcBtn" id="btnVal-Equal"><button id="btnEqual"></button></div>
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
