function validate() {	
	if(noEntry(document.forms[0].elements[0]) == false) return;
	if(noEntry(document.forms[0].elements[1]) == false) return;
	if(noEntry(document.forms[0].elements[2]) == false) return;
	if(noEntry(document.forms[0].elements[3]) == false) return;
	if(noEntry(document.forms[0].elements[4]) == false) return;
	if(noEntry(document.forms[0].elements[5]) == false) return;
	if(noEntry(document.forms[0].elements[6]) == false) return;
	if(noEntry(document.forms[0].elements[7]) == false) return;
	if(noEntry(document.forms[0].elements[8]) == false) return;
	field1="Document Code";
	if(sizeIs(document.forms[0].elements[8], 7, field1) == false) return;
	if(noEntry(document.forms[0].elements[9]) == false) return;
	document.forms[0].submit();
}