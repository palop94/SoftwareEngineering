function validar(){
var username = document.getElementById("username").value;
var password = document.getElementById("password").value;
if (username.lenght==0) {
	alert("Username is empty)")
}
if (password.lenght==0) {
	alert("password is empty)")
}
if ( username == "a123" && password == "123"){
alert ("Haz logrado Iniciar sesion/You sucessfully loged in");
window.location = "Inicio.html"; 
}
else { alert("Error total")}
}