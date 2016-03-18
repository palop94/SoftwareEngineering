function noEntry(field) {
	t1=field.value;
	if (t1.length<1) {
		alert("The field should not be empty");
		field.focus();
		return false;
	}else { return true; }
}