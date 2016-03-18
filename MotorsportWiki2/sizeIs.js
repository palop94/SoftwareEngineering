function sizeIs(field, n, field1) {
	mt=field.value;
	if (mt.length!=n) {
		alert("The "+field1+" must have "+n+" digits");
		field.focus();
		return false;
	}else { return true; }
}