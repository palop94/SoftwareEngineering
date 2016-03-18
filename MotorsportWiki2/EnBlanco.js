function EnBlanco(field) {
	mt=field.value;
	if (mt.length<1) {
		alert("Debe rellenar el campo Codigo");
		field.focus();
		return false;
	} 
	
}

			