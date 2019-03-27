/*Apertura de paginas*/
var crearEvento = "newEvent.html";
var seleccionarCategorias = "listCategories.html";
var login = "login.html"
/*Variables de validacion*/
var nombre;
var fecha;
var urlFoto;
var urlWiki;
/*Variables de acceso*/
var userName;
var password;

/*Entrada a Login*/
function enterLogin() {
    window.open(login, "Login", "width=500px,height=500px,margin=auto");
}

/*Validacion del login*/
function dataLogin() {
    var dataOk = true;
    userName = document.getElementById("loginUser").value.trim();
    password = document.getElementById("loginPassword").value.trim();

    /*Validacion del nombre de usuario*/
    if (userName == "") {
        errorUser.style.color = "red";
        document.getElementById("errorUser").innerHTML = "X Usuario incorrecto";
        dataOk = false;
    } else {
        dataOk = true;
    }

    /*Validacion de contraseña*/
    if (password == "") {
        errorPassword.style.color = "red";
        document.getElementById("errorPassword").innerHTML = "X Contraseña incorrecto";
        dataOk = false;
    } else {
        dataOk = true;
    }

    if (dataOk == true) {
        window.open("practicaDAW.html", "_parent");
    }
}

/*Validacion de los datos*/
function validarDatos() {
    var validacion = true;
    nombre = document.getElementById("nombre").value.trim();
    fecha = document.getElementById("fecha").value.trim();
    urlFoto = document.getElementById("foto").value.trim();
    urlWiki = document.getElementById("wiki").value.trim();

    /*Validacion del nombre*/
    if (nombre == "") {
        errorNombre.style.color = "red";
        document.getElementById("errorNombre").innerHTML = "X Nombre obligatorio";
        validacion = false;
    } else {
        errorNombre.style.color = "green";
        document.getElementById("errorNombre").innerHTML = "✔";
    }

    /*Validacion fecha*/
    if (fecha == "") {
        errorFecha.style.color = "red";
        document.getElementById("errorFecha").innerHTML = "X Fecha obligatoria";
        validacion = false;
    } else {
        errorFecha.style.color = "green";
        document.getElementById("errorFecha").innerHTML = "✔";
    }

    /*Validacion foto*/
    if (urlFoto == "") {
        errorFoto.style.color = "red";
        document.getElementById("errorFoto").innerHTML = "X URL obligatoria";
        validacion = false;
    } else {
        errorFoto.style.color = "green";
        document.getElementById("errorFoto").innerHTML = "✔";
    }

    /*Validacion url*/
    if (urlWiki == "") {
        errorWiki.style.color = "red";
        document.getElementById("errorWiki").innerHTML = "X URL obligatoria";
        validacion = false;
    } else {
        errorWiki.style.color = "green";
        document.getElementById("errorWiki").innerHTML = "✔";
    }
    /*validacion*/
    if (validacion == true) {
        window.close(crearEvento);
    }
}

/*Funcion para el cierre de pestaña*/
function newEvent() {
    window.open(crearEvento, "", "width=500px,height=500px");
}

/*Funcion para el cambio de pestaña*/
function categories() {
    window.open(seleccionarCategorias, "", "width=500px,height=500px;");
}

function comprobar() {
    var seleccion = false;
    var listaDeCategorias = document.forms[0];
    var i;
    for (i = 0; i < listaDeCategorias.length; i++) {
        if (listaDeCategorias[i].checked) {
            seleccion = true;
        }
    }

    if (seleccion == false) {
        errorSeleccionar.style.color = "red";
        document.getElementById("errorSeleccionar").innerHTML = "Seleccione un campo";
        seleccion = false;
    }

    if (seleccion == true) {
        window.close(seleccionarCategorias);
    }
}
