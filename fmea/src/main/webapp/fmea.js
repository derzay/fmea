/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function dropdownToggle1() {
    document.getElementById("myDropdown1").classList.toggle("show");
}
function dropdownToggle2() {
    document.getElementById("myDropdown2").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
    var myDropdown = document.getElementById("myDropdown1");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
    myDropdown = document.getElementById("myDropdown2");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }

}