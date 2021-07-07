"use strict";
var category= "CategoryDialog.html";

function newCategory() {
    window.open(category, "", "width=500px,height=200px");
}
function createNewCategory() {
   
}
function deleteCategory() {
   
}
function changeCategory() {
   var x = prompt("Escribe el nombre de la categoría: ");
   document.getElementById("change").innerHTML=x;
}