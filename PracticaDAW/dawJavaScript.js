function openTab(event, tab) {
    var i, tabcontent, section;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    section = document.getElementsByClassName("section");
    for (i = 0; i < section.length; i++) {
        section[i].className = section[i].className.replace(" active", "");
    }

    document.getElementById(tab).style.display = "block";
    event.currentTarget.className += " active";
}

document.getElementById("default").click();
