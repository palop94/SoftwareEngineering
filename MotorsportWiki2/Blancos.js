function Blancos(){
	
var username = document.getElementById("comentario").value;
var password = document.getElementById("autor").value;

if( username == null || username .length == 0 || /^\s+$/.test(username ) ) {
	alert("El comentario está en blanco, por favor vuelva a entrar y reintroduzcalo")
	return false;
	
  
}


if( username == null || password .length == 0 || /^\s+$/.test(password) ) {
	alert("El comentario está en blanco, por favor vuelva a entrar y reintroduzcalo")
	return false;
	
 
}
}