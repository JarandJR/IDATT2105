
let incrementBtn = document.querySelector("#increment");
incrementBtn.addEventListener("click",() => {
    let number = Number(document.getElementById("number").innerHTML);
    document.getElementById("number").innerHTML = number + 1;
})

let decrementBtn = document.querySelector("#decrement");
decrementBtn.addEventListener("click", () => document.getElementById("number").innerHTML -= 1);

let togglerBtn = document.querySelector("#toggler");
togglerBtn.addEventListener("click", ()=> toggle())

function toggle() {
    let info = document.getElementById("displayItems");
    if (info.style.display === "none")
        info.style.display = "block";
    else
        info.style.display = "none";
}

let clearListBtn = document.getElementById("clearItems")
clearListBtn.addEventListener("click", ()=> document.getElementById("list").innerHTML = "");

let listBtn = document.getElementById("listItems");
listBtn.addEventListener("click", ()=> {

    const randomList = Array.apply(null, Array(2)).map(()=> {
        return Array.apply(null, Array(~~(Math.random() * 10  + 3))).map(()=> {
            return String.fromCharCode(Math.random() * (123 - 97) + 97);
        }).join('')
    });

    let list = document.getElementById("list");
    for (let i = 0; i < randomList.length; i++) {
        let listItem = document.createElement("li");
        listItem.appendChild(document.createTextNode(randomList[i]));
        list.appendChild(listItem);
    }
    document.getElementById("displayItems").appendChild(list);
})