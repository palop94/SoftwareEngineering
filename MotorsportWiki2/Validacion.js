function noEntry(field) {
	mt=field.value;
	if (mt.length<1) {
		alert("El nombre de carpeta y procedencia deben rellenarse");
		field.focus();
		return false;
	}else { return true; }
}

function IsNumeric(field) {
	var valid = "0123456789"
	var ok = "yes";
	var temp;
	for (var i=0; i<field.value.length; i++) {
		temp = "" + field.value.substring(i, i+1);
		if (valid.indexOf(temp) == "-1") ok = "no";
	}
	if (ok == "no") {
		alert("Entrada Incorrecta!  Se debe introducir un numero");
		field.focus();
		field.select();
		return false;
   	}
	return true;
}
function validate() {	
     if(noEntry(document.forms[0].elements[0]) == false) return;
     if(noEntry(document.forms[0].elements[1]) == false) return;
	
	if(IsNumeric(document.form[0].elements[1])==false) return
     
	 document.forms[0].submit();
}

