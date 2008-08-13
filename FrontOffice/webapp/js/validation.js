var valid = null;
var referenceYear = new Date().getFullYear() - 2000 + 1;
	
function submitForm(form) {
 if (validateForm(form))
     form.submit();
}

function validateForm(form) {
	if (valid == null)
		valid = new validationData();

	errors = checkForm(form, valid);
	if (errors.length > 0) {
		alert(errors);
        return false
	} else {
		return true;
	}
}

function checkForm(form, data) {
    errors = "";
    for (x in data) {
    	var dataItem = data[x];
    	if ((dataItem("type") != null) && (dataItem("type").indexOf("list") == 0))
    		x = x + "[0]";
    	var field = form[x];
    	if (field == null)
    		field = document.getElementById(x);
    		
    	switch (checkField(field, dataItem)) { 
    	case 0: break;
    	case 1: if (dataItem("msg") != null)
			    	errors = errors + dataItem("msg").replace( /&quote;/, "'" ) + "\n";
    			else
			    	errors = errors + "Le champ " + fieldLabel(field,dataItem) + " est obligatoire.\n";
    			break;
    	case 2: errors = errors + "Le format de saisie du champ " + fieldLabel(field,dataItem) + " est en erreur.\n";
    			break;
    	case 3: errors = errors + "Le nombre de caractères saisis est trop important pour le champ " + fieldLabel(field,dataItem) + ".\n";
				break;
    	case 4: errors = errors + "Le nombre de caractères saisis n'est pas assez pour le champ " + fieldLabel(field,dataItem) + ".\n";
				break;
        }
    }
    return errors;
}

function fieldLabel(field, dataItem) {
	if (dataItem("label") != null)
		return dataItem("label").replace( /&quote;/, "'" );
	
	return field.name;
}

function validateField(field) {
	if (typeof validationData == 'undefined')
		return;
		
	if (valid == null)
		valid = new validationData();

	data = valid[field.id];
	switch (checkField(field, data)) { 
    	case 0: updateDisplay(field.name);
    			return;
    	case 1: if (data("msg") != null)
			    	alert(data("msg").replace( /&quote;/, "'" ) + " est obligatoire.");
    			else
			    	alert("Le champ " + fieldLabel(field,data) + " est obligatoire.");
    			break;
    	case 2: alert("Le format de saisie du champ " + fieldLabel(field,data) + " est faux.");
    			break;
    	case 3: alert("Le nombre de caractères saisis est trop important pour le champ " + fieldLabel(field,data) + ".");
				break;
    	case 4: alert("Le nombre de caractères saisis n'est pas assez pour le champ " + fieldLabel(field,data) + ".");
				break;
    	case 5: alert(data("extra")(1));
				break;
    }
   	field.focus();
}	
	
function checkField(field, data) {
	if (data == null)
		return null;
		
	mask = null;
	transform = null;

	required = data("required");
	mask = data("mask");
	maxLength = data("maxlength");
	transform = data("transform");
	type = data("type");
	extra = data("extra");
	minLength = data("minlength");

	if (isVisible(field)) {
        if (transform != null)
    		transformField(field,transform);
    
    	if (required && !checkRequired(field,type)) {
    		return 1;
    	}
    
    	if ((mask != null) && !checkMask(field,mask)) {
    		return 2;
    	}
    	
    	if ((maxLength != null) && (maxLength != 0) && !checkMaxLength(field,maxLength)) {
    		return 3;
    	}

    	if ((minLength != null) && (minLength != 0) && !checkMinLength(field,minLength)) {
    		return 4;
    	}

		if ((extra != null) && !extra()) {
			return 4;
		}
    }			
	return 0;
}

function isVisible(field) {
	if (field == null)
		return false;
		
    node = field.parentNode;
    while ((node != null) && (node.style.display != "none") && ((node.id == null) || (node.id == "")))
        node = node.parentNode;

    return (node == null) || (node.style.display != "none");
}

function transformField(field,transform) {
	if (transform == 'uppercase')
		field.value = field.value.toUpperCase();
	else if (transform == 'lowercase')
		field.value = field.value.toLowerCase();
    else if (transform == 'firstupper')
        field.value = field.value.slice(0,1).toUpperCase()+field.value.slice(1);
    else if (transform == 'date') {
        var D = DatVal(field.value, 2, referenceYear)
        if (D[0])
            field.value = D[2];
    }
}

function checkRequired(field, type) {
	isValid = false;
	if (type == null) {
		isValid = true;
		if (field.type == 'text' ||
	        field.type == 'textarea' ||
	        field.type == 'file' ||
	        field.type == 'select-one' ||
	        field.type == 'radio' ||
	        field.type == 'password') {
	        var value = '';
			// get field's value
			if (field.type == "select-one") {
				var si = field.selectedIndex;
				if (si >= 0) {
					value = field.options[si].value;
				}
			} else {
				value = field.value;
			}
	        if (trim(value).length == 0) {
	            isValid = false;
	        }
	    } else if (field.length > 0) {
	    	if (field[0].type == "radio") {
	    		isValid = false;
	    		for (var i = 0; i < field.length; i++) {
	    			if (field[i].checked)
	    				isValid = true;
	    		}
	    	}
	    }
	} else if (type.indexOf('list') == 0) {
		isValid = false;
		currentForm = field.form;
		name = field.name.substring(0,field.name.indexOf('['));
		i = 1;
		while (field != null) {
			if (field.checked)
				isValid = true;
			id = name +"[" + i++ + "]";
			field = currentForm[id];
		}
		if (!isValid && (type.indexOf('list:') == 0)) {
			var block = type.substring(5);
			var blockElement = document.getElementById(block);
			var inputFields = blockElement.getElementsByTagName("input");
			for (var i = 0; i < inputFields.length; i++) {
				if (inputFields[i].value != "")
					isValid = true;
			}
		}
	} else if (type == 'ticket') {
		isValid = false;
		if (typeof hasReservations != 'undefined')
			isValid = hasReservations();

	} else if (type == 'referential') {
		isValid = false;
		if (typeof hasReferential != 'undefined')
			isValid = hasReferential();
	} else if (type.indexOf('block:') == 0) {
		var block = type.substring(6);
		var blockElement = document.getElementById(block);
		var inputFields = blockElement.getElementsByTagName("input");
		isValid = false;
		for (var i = 0; i < inputFields.length; i++) {
			if (inputFields[i].value != "")
				isValid = true;
		}
	}
	return isValid;
}

function checkMaxLength(field, iMax) {
	isValid = true;
	if (field.type == 'text' ||
        field.type == 'textarea' ||
        field.type == 'password') {
        
        if (field.value.length > iMax) {
            isValid = false;
        }
    }
	return isValid;
}

function checkMinLength(field, iMin) {
	isValid = true;
	if (field.type == 'text' ||
        field.type == 'textarea' ||
        field.type == 'password') {
        
        if (field.value.length < iMin) {
            isValid = false;
        }
    }
	return isValid;
}

function checkMask(field, mask) {
	isValid = true;
	if ((field.type == 'text' || 
        field.type == 'textarea') && 
        (field.value.length > 0)) {
       
       if (!matchPattern(field.value, mask)) {
           isValid = false;
       }
	}
	return isValid;
}

function trim(s) {
    return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
}

function matchPattern(value, mask) {
    return mask.exec(value);
}

function updateDisplay(name) {
    var elements = document.getElementsByName(name)
    if (elements.length > 0) {
    	if (elements[0].type =="select-one")
    		updateSelect(elements[0].options);

    	else if (elements[0].type =="radio")
    		updateRadioGroup(elements);

    	else if (elements[0].type =="hidden")
    		updateHidden(elements);
    }
	
}

function updateRadioGroup(buttons) {
    for (i=0; i < buttons.length; i++) {
        var conditionalDiv = document.getElementById(buttons[i].value);
        if ((conditionalDiv != null) && (conditionalDiv.id == buttons[i].value)) {
            if (buttons[i].checked) {
                conditionalDiv.style.display = 'block';
            } else {
                conditionalDiv.style.display = 'none';
            }
        }
    }
}

function updateSelect(options) {
    for (i=0; i < options.length; i++) {
        var conditionalDiv = document.getElementById(options[i].value);
        if ((conditionalDiv != null) && (conditionalDiv.id == options[i].value)) {
            if (options[i].selected) {
                conditionalDiv.style.display = 'block';
            } else {
                conditionalDiv.style.display = 'none';
            }
        } else {
        	var optionsValue = "Not" + options[i].value;
	        var conditionalDiv = document.getElementById(optionsValue);
	        if ((conditionalDiv != null) && (conditionalDiv.id == optionsValue)) {
	            if (options[i].selected) {
	                conditionalDiv.style.display = 'none';
	            } else {
	                conditionalDiv.style.display = 'block';
	            }
	        }
        }
    }
}

function updateHidden(elements) {
    var conditionalDiv = null;
    if (elements[0].value != "")
	    conditionalDiv = document.getElementById(elements[0].value);
	    
    if ((conditionalDiv != null) && (conditionalDiv.id == elements[0].value)) {
    	if (!elements[0].disabled) {
            conditionalDiv.style.display = 'block';
        } else {
            conditionalDiv.style.display = 'none';
        }
    }
}

function DatVal(Q, J, C) { var Mon, x, Rex, B, Y, S, ND=0
    Q = trim(Q);
    if (J==0) { Rex = /(\d+)(\d{2})(\d{2})$/     // D5+ as Y+MMDD
      Q = Q.search(Rex)==-1 ? '' : Q.replace(Rex, '$1 $2 $3') // split
     } // optional paragraph

//    Rex = new RegExp(Suf[Lx], 'i') // Remove suffix, see * below
//    Q = Q.replace(Rex, ' ')  // optional paragraph

    Rex = /([^A-Z]+)([IVX]{1,4})(.*)/i // Seek Roman (month) : viii IX
    if (Rex.test(Q)) {
      Mon = Q.replace(Rex, '$2').toUpperCase() // 1-4 Chars of month
      x =
       ' I    II   III  IV   V    VI   VII  VIII IX   X    XI   XII '.
        indexOf(' '+Mon)
      Q = Q.replace(Rex, '$1 '+(1+x/5)+' $3') // make numeric
     } // optional paragraph

    Rex = /([^A-Z]*)([A-Z]{1,4})(.*)/i
    // Seek month letters : Au / Aug. Or {3}.
    if (Rex.test(Q)) {
      Mon = Q.replace(Rex, '$2').toUpperCase() // 1-4 Letters of month
      // x = Months[Lx].indexOf(' '+Mon) // or next for English only, *
//      x = ' JAN FEB MAR APR MAY JUN JUL AUG SEP OCT NOV DEC'.indexOf(' '+Mon)
      x = ' JANV FEVR MARS AVRI MAI  JUIN JUIL AOUT SEPT OCTO NOVE DECE'.indexOf(' '+Mon)
      Q = Q.replace(Rex, '$1 '+(1+x/5)+' $3') // to numeric
      } // optional paragraph

    Rex = /^(\d+)\D+(\d+)\D+(\d+)$/ // three digit fields
    // if (J==1) Q = Q                       // ISO
    if (J==2) Q = Q.replace(Rex, '$3 $2 $1') // EU
    if (J==3) Q = Q.replace(Rex, '$3 $1 $2') // NA
    B = Rex.test(Q) // Split into $1 $2 $3
    if (B) with (RegExp) { Y = +$1
      if (Y<100) Y += (Y<C?2000:1900)      // optional century line
    S = $3 +'/' + $2 + '/' + Y
      with (ND = new Date(Y, $2-1, $3))
        B = ((getMonth()==$2-1) && (getDate()==$3))  } // YMD valid ?
    // For true years 00..99, enter as >2 digits, check $1.length;
    // then increase year by 100 and decrease month by 1200.
    return [B, ND, S] // [Valid, DateObject, String]
    // To ban leading zeros in M, D, and Y,
    // alter all \\d+ in last Rex to [1-9]\\d?  untested.
    /* end DatVal */ }
