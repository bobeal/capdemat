var valid = null;
	
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
        alert(x);
        var field = form[x];
        if (!checkField(field, data[x])) {
            errors = errors + field.name + 'une teste de \' de\n';
        }
    }
    return errors;
}

function validateField(field) {
	if (valid == null)
		valid = new validationData();

	data = valid[field.id];
	if (!checkField(field,data)) {
        alert('error');
        field.focus();
    }
}	
	
function checkField(field, data) {

	required = data("required");
	mask = data("mask");
	maxLength = data("maxlength");
	transform = data("transform");

	if ((transform != null) && transform)
		field.value = field.value.toUpperCase();

	if (required && !checkRequired(field)) {
		alert("Required " + field.name);
		return false;
	}

	if ((mask != null) && !checkMask(field,mask))
		alert("error check mask");

	if ((maxLength != null) && !checkMaxLength(field,maxLength))
		alert("error check maxLength");
			
	return true;
}

function checkRequired(field) {
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
    }
	return isValid;
}

function checkMaxLength(field, iMax) {
	isValid = true;
	if (field.type == 'text' ||
        field.type == 'textarea') {
        
        if (field.value.length > iMax) {
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
