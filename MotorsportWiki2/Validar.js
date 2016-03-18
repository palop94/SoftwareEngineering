function noEntra(field) {
	mt=field.value;
	if (mt.length<1) {
		alert("Los campos de nombre de carpeta y fecha debe rellenarse");
		field.focus();
		return false;
	}else { return true; }
}

function EsNumeric(field) {
	var valid = "0123456789/"
	var ok = "yes";
	var temp;
	for (var i=0; i<field.value.length; i++) {
		temp = "" + field.value.substring(i, i+1);
		if (valid.indexOf(temp) == "-1") ok = "no";
	}
	if (ok == "no") {
		alert("Entrada Incorrecta!  Se debe introducir la fecha en formato xx/xx/xxxx con numeros");
		field.focus();
		field.select();
		return false;
   	}
	return true;
}


function validated() {	
	if(noEntra(document.forms[0].elements[0]) == false) return;
	if(noEntra(document.forms[0].elements[1]) == false) return;
	if(noEntra(document.forms[0].elements[2]) == false) return;

	if(EsNumeric(document.forms[0].elements[2]) == false) return;

	document.forms[0].submit();
}
