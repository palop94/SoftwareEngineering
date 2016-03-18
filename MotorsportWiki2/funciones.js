
function Ocultar(nombre){
document.getElementById(nombre).style.display = 'none';
return;
}
	
function Mostrar(nombre){
document.getElementById(nombre).style.display = 'initial';
return;
}	


function desbloquear(nombre){
document.getElementById(nombre).disabled=false;
return;
}

function bloquear(nombre){
document.getElementById(nombre).disabled=true;
return;
}
	
	
function Mensaje(tipo, busqueda){
alert('La busqueda realizada no tiene documentacion relacionada: tipo: " + tipo +"  busqueda: " + busqueda +"');
return;
}
	

function Limpiar(nombre){
document.getElementById(nombre).value= "";
return;
}