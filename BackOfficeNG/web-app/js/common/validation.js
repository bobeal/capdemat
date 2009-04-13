//
// +----------------------------------------------------------------------+
// | Unobtrusive Javascript Validation for YUI v2.0 (2007-03-04)          |
// | http://blog.jc21.com                                                 |
// +----------------------------------------------------------------------+
// | Attaches Events to all forms on a page and checks their form         |
// | elements classes to provide some validation.                         |
// +----------------------------------------------------------------------+
// | Copyright: jc21.com 2008                                             |
// +----------------------------------------------------------------------+
// | Licence: Absolutely free. Don't mention it.                          |
// +----------------------------------------------------------------------+
// | Author: Jamie Curnow <jc@jc21.com>                                   |
// +----------------------------------------------------------------------+
//
//



//==================================================================================================================
//  Trim Whitespace
//------------------------------------------------------------------------------------------------------------------
String.prototype.trim=function(){
	return this.replace(/^\s*|\s*$/g,'');
}
String.prototype.ltrim=function(){
	return this.replace(/^\s*/g,'');
}
String.prototype.rtrim=function(){
	return this.replace(/\s*$/g,'');
}

//==================================================================================================================
//  FIC_checkForm
//  Form Input Checking by JC
/*
		Apply these class names to form elements:
		* required (not blank)
		* validate-number (a valid number)
		* validate-digits (digits only, spaces allowed.)
		* validate-alpha (letters only)
		* validate-alphanum (only letters and numbers)
		* validate-date (a valid date value)
		* validate-email (a valid email address)
		* validate-url (a valid URL)
		* validate-date-au (a date formatted as; dd/mm/yyyy or d/m/yyyy)
		* validate-currency-dollar (a valid dollar value)
		* validate-one-required (At least one checkbox/radio element must be selected in a group)
		* validate-not-first (Selects only, must choose an option other than the first)
		* validate-not-empty (Selects only, must choose an option with a value that is not empty)
		* validate-regex (requires the element to have a 'regex=' attribute applied)

		Also, you can specify this attribute for text, passwird and textarea elements:
		* minlength="x" (where x is the minimum number of characters)
*/
//------------------------------------------------------------------------------------------------------------------
function FIC_checkForm(e, el, includeScope) {
	var errs = new Array();
	//this function is called when a form is submitted.
	if (typeof(e) == "string") {
		//the id was supplied, get the object reference
		e = xGetElementById(e);
		if (!e) {
			return true;
		}
	}
	
	FIC_cleanForm(e);
	var fields = FIC_fetchField(e, includeScope);
	var all_valid = true;
	
	var f_in = fields.input;
	var f_sl = fields.select;
	var f_ta = fields.textarea;
	
	//check inputs
	for (i=0;i<f_in.length;i++) {
		if (f_in[i].type.toLowerCase() != 'submit' && f_in[i].type.toLowerCase() != 'button' && f_in[i].type.toLowerCase() != 'hidden') {
			if (isVisible(f_in[i])) {
				var cname = ' '+f_in[i].className.replace(/^\s*|\s*$/g,'')+' ';
				cname = cname.toLowerCase();
				var inv = f_in[i].value.trim();
				var t = f_in[i].type.toLowerCase();
				var cext = '';
				if (t == 'text' || t == 'password') {
					//text box
					var valid = FIC_checkField(cname,f_in[i]);
				} else if(t == 'radio' || t == 'checkbox'){
					// radio or checkbox
					var valid = FIC_checkRadCbx(cname,f_in[i],f_in);
					valid = FIC_checkLocalReferentialDataTree(cname,f_in[i],f_in, valid);
					cext = '-cr';
				} else {
					var valid = true;
				}
				
				FIC_toggleValidationClass (f_in[i], valid, 'validation-passed'+cext, 'validation-failed'+cext);
			  if (!valid) {
					//try to get title
					if (f_in[i].getAttribute('title')){
						errs[errs.length] = f_in[i].getAttribute('title');
					}
					all_valid = false;
				}
			}
		}
	} //end for i
	
	//check textareas
	for (i=0;i<f_ta.length;i++) {
		if (isVisible(f_ta[i])) {
			var cname = ' '+f_ta[i].className.replace(/^\s*|\s*$/g,'')+' ';
			cname = cname.toLowerCase();
			var valid = FIC_checkField(cname,f_ta[i]);
			
			if (valid) {
				removeClassName(f_ta[i],'validation-failed');
				addClassName(f_ta[i],'validation-passed');
			} else {
				removeClassName(f_ta[i],'validation-passed');
				addClassName(f_ta[i],'validation-failed');
				//try to get title
				if (f_ta[i].getAttribute('title')){
					errs[errs.length] = f_ta[i].getAttribute('title');
				}
				all_valid = false;
			}
		}
	} //end for i
	
	//check selects
	for (i=0;i<f_sl.length;i++) {
		if (isVisible(f_sl[i])) {
			var cname = ' '+f_sl[i].className.replace(/^\s*|\s*$/g,'')+' ';
			cname = cname.toLowerCase();
			var valid = FIC_checkSel(cname,f_sl[i]);
			if (valid) {
				removeClassName(f_sl[i],'validation-failed-sel');
				addClassName(f_sl[i],'validation-passed-sel');
			} else {
				removeClassName(f_sl[i],'validation-passed-sel');
				addClassName(f_sl[i],'validation-failed-sel');
				//try to get title
				if (f_sl[i].getAttribute('title')){
					errs[errs.length] = f_sl[i].getAttribute('title');
				}
				all_valid = false;
			}
		}
	} //end for i
	if (!all_valid) {
		if (errs.length > 0){
			//alert("We have found the following error(s):\n\n  * "+errs.join("\n  * ")+"\n\nPlease check the fields and try again");
			el.innerHTML = errs.join("<br/>");
		} else {
			//alert('Some required values are not correct. Please check the items in red.');
			el.innerHTML = 'Des champs obligatoires ne sont pas correctement remplis, merci de v&eacute;rifier les champs en rouge';
		}
		YAHOO.util.Event.stopEvent(e);
	}
	return all_valid;
} // end FIC_checkForm

/* FIC_fetchField
 * responsible of fetching field to test by scope
 * ------------------------------------------- */
function FIC_fetchField(e, includeScope) {
  var fields = {'input':[],'select':[],'texterea':[]};
	var elm = e.nodeName ? e : YAHOO.util.Event.getTarget(e);
	
	if (includeScope == undefined) {
	  if (elm.nodeName != 'form'.toUpperCase()) {
		  elm = YAHOO.util.Dom.getAncestorByTagName(elm,'form');
	  }
	  fields.input = elm.getElementsByTagName('input');
	  fields.select = elm.getElementsByTagName('select');
	  fields.textarea = elm.getElementsByTagName('textarea');
	} else if (includeScope) {
	  if (!YAHOO.util.Dom.hasClass(elm, 'validation-scope')) {
		  elm = YAHOO.util.Dom.getAncestorByClassName(elm,'validation-scope');
	  }
	  fields.input = elm.getElementsByTagName('input');
	  fields.select = elm.getElementsByTagName('select');
	  fields.textarea = elm.getElementsByTagName('textarea');
	}  else if (!includeScope) {
	  if (elm.nodeName != 'form'.toUpperCase()) {
		  elm = YAHOO.util.Dom.getAncestorByTagName(elm,'form');
	  }
	  var notBelongToScope = function(el) {
	    if (YAHOO.util.Dom.getAncestorByClassName(el, 'validation-scope') === null)
	      return true;
	    else
	      return false;
	  };
	  fields.input = YAHOO.util.Dom.getElementsBy(notBelongToScope, 'input', elm);
	  fields.select = YAHOO.util.Dom.getElementsBy(notBelongToScope, 'select', elm);
	  fields.textarea = YAHOO.util.Dom.getElementsBy(notBelongToScope, 'textarea', elm);
	}
	
	return fields
}

/* FIC_cleanForm
 * remove all css marker of the previous validation check
 * ------------------------------------------- */
function FIC_cleanForm(e) {
  var fields = FIC_fetchField(e);
  for (i=0; i<fields.input.length; i++) {
    var fieldType = fields.input[i].type.toLowerCase();
    if (fieldType === 'radio' || fieldType === 'checkbox')
      YAHOO.util.Dom.removeClass(fields.input[i], 'validation-failed-cr');
    else
      YAHOO.util.Dom.removeClass(fields.input[i], 'validation-failed');
  }
  for (i=0; i<fields.select.length; i++) {
      YAHOO.util.Dom.removeClass(fields.select[i], 'validation-failed-sel');
  }
  for (i=0; i<fields.textarea.length; i++) {
      YAHOO.util.Dom.removeClass(fields.textarea[i], 'validation-failed');
  }
}
 
//==================================================================================================================
//  FIC_checkField
//	c = className
//	e = the element
//------------------------------------------------------------------------------------------------------------------
function FIC_checkField(c,e) {
	var valid = true;
	var t = e.value.trim();
	
	
	// capdematTest extends validation class with capdemat type
	// each entry must return the negation of the final result.
	var capdematTest = {
		'validate-string' : function(t) {
				return false;
		},
		'validate-token' : function(t) {
				return false;
		},
		'validate-positiveinteger' : function(t) {
				if (isNaN(t) && t.match(/\D/)) return true;
		},
		'validate-long' : function(t) {
				if (isNaN(t) && t.match(/\D/)) return true;
		},
		'validate-postalcode' : function(t) {
				if (t.match(/^[0-9]{5}$/)) return false;
				return true;
		},
		'validate-departmentcode' : function(t) {
				if (t.match(/^[0-9]{2}$/)) return false;
				return true;
		},
		'validate-phone' : function(t) {
				if (t.match(/^0[1-9][0-9]{8}$/)) return false;
				return true;
		},
		'validate-city' : function(t) {
				if (t.match(/^.{0,32}$/)) return false;
				return true;
		},
		'validate-firstname' : function(t) {
				if (t.match(/^\D{0,38}$/)) return false;
				return true;
		},
		'validate-lastname' : function(t) {
				if (t.match(/^\D{0,38}$/)) return false;
				return true;
		},
		'validate-cfbn' : function(t) {
				if (t.match(/^[0-9]{7}[A-Z]{0,1}$/)) return false; //TODO - verify test
				return true;
		}
	}
	
	// Extract 'validate-type' from html class 
	var validateClass = zenexity.capdemat.tools.grep(c.split(' '), function(elem, i){
			return (elem.indexOf('validate-') != -1);
	})[0];
	
	if (t.length > 0) {
	  valid = !(zenexity.capdemat.tools.tryToCall(capdematTest[validateClass], capdematTest, t));
	}
	
	//search for required
	if (c.indexOf(' required ') != -1 && t.length == 0) {
		//required found, and not filled in
		valid = false;
	}
	if (t.length > 0) {
		//check for minlength.
		var m = e.getAttribute('minlength');
		if (m && Math.abs(m) > 0){
			if (e.value.length < Math.abs(m)){
				valid = false;
			}
		}
		// check for maxlength (usefull, just for <textarea>. This tag has no maxlength attribute in HTML 4.01 ).
	  m = e.getAttribute('maxlength');
		if (m && Math.abs(m) > 0){
			if (e.value.length > Math.abs(m)){
				valid = false;
			}
		}
	}
	
	//search for validate-
	if (c.indexOf(' validate-number ') != -1 && isNaN(t) && t.match(/[^\d]/)) {
		//number bad
		valid = false;
	} else if (c.indexOf(' validate-digits ') != -1 && t.replace(/ /,'').match(/[^\d]/)) {
		//digit bad
		valid = false;
	}else if (c.indexOf(' validate-label ') != -1 && t.length == 0) {
		//label false
		valid = false;
	}else if (c.indexOf(' validate-alpha ') != -1 && !t.match(/^[a-zA-Z]+$/)) {
		//alpha bad
		valid = false;
	} else if (c.indexOf(' validate-alphanum ') != -1 && t.match(/\W/)) {
		//alpha bad
		valid = false;
	} else if (c.indexOf(' validate-date ') != -1) {
		var d = new Date(t);
		if (isNaN(d)) {
			//date bad
			valid = false;
		}
	} else if (c.indexOf(' validate-email ') != -1 && !t.match(/\w{1,}[@][\w\-]{1,}([.]([\w\-]{1,})){1,3}$/)) {
		//email bad
		valid = false;
		if (c.indexOf(' required ') == -1 && t.length == 0) {
			valid = true;
		}
	} else if (c.indexOf(' validate-url ') != -1 && !t.match(/^(http|https|ftp):\/\/(([A-Z0-9][A-Z0-9_-]*)(\.[A-Z0-9][A-Z0-9_-]*)+)(:(\d+))?\/?/i)) {
		//url bad
		valid = false;
	} else if (c.indexOf(' validate-date-au ') != -1 && !t.match(/^(\d{1}|\d{2})\/(\d{1}|\d{2})\/(\d{4})$/)) {
		valid = false;
		if (c.indexOf(' required ') == -1 && t.length == 0) {
            valid = true;
        }
	} else if (c.indexOf(' validate-currency-dollar ') != -1 && !t.match(/^\$?\-?([1-9]{1}[0-9]{0,2}(\,[0-9]{3})*(\.[0-9]{0,2})?|[1-9]{1}\d*(\.[0-9]{0,2})?|0(\.[0-9]{0,2})?|(\.[0-9]{1,2})?)$/)) {
		valid = false;
	} else if (c.indexOf(' validate-regex ') != -1) {
		var r = RegExp(e.getAttribute('regex'));
		if (r && ! t.match(r)) {
				valid = false;
		}
	}

	return valid;
}

//==================================================================================================================
//  FIC_checkRadCbx
//	c = className
//	e = this element, radio or checkbox
//	f = input fields dom element
//------------------------------------------------------------------------------------------------------------------
function FIC_checkRadCbx(c,e,f){
	var valid = true;
	//search for required
	if (c.indexOf(' validate-one-required ') != -1) {
		//required found
		//check if other checkboxes or radios have been selected.
		valid = false;
		for (var i=0;i<f.length;i++){
			if(f[i].name.toLowerCase() == e.name.toLowerCase() && f[i].checked){
				valid = true;
				break;
			}
		}
	}
	return valid;
}

function FIC_checkLocalReferentialDataTree(c,e,f, valid){
	//search for required
	if (c.indexOf(' validate-localreferentialdata ') != -1) {
		//required found
		//check if other checkboxes or radios have been selected.
		valid = false;
		for (var i=0;i<f.length;i++){
			if(f[i].name.split('[')[0].toLowerCase() == e.name.split('[')[0].toLowerCase() && f[i].checked){
				valid = true;
				break;
			}
		}
	}
	return valid;
}

function FIC_toggleValidationClass(inputEl, isValid, passedClassName, failedClassName) {
  if (!(/validate-(\w+)/i.exec(inputEl.className)) 
      && !YAHOO.util.Dom.hasClass(inputEl,'required'))
    return;
  
  var type = inputEl.type.toLowerCase();
  var el;
  
  if (type == 'radio' || type == 'checkbox') el = YAHOO.util.Dom.getAncestorByTagName(inputEl,'ul');
  el = !el ? inputEl : el;
  
  if (isValid) {
	  removeClassName(el, failedClassName);
	  addClassName(el, passedClassName);
  } else {
	  removeClassName(el, passedClassName);
	  addClassName(el, failedClassName);
	}
}

//==================================================================================================================
//  FIC_checkSel
//	c = className
//	e = this select element
//------------------------------------------------------------------------------------------------------------------
function FIC_checkSel(c,e){
	var valid = true;
	//search for validate-  
	if (c.indexOf(' validate-not-first ') != -1 && e.selectedIndex == 0) {
		//bad
		valid = false;
	} else if (c.indexOf(' validate-not-empty ') != -1 && e.options[e.selectedIndex].value.length == 0) {
		//bad
		valid = false;
	}
	return valid;
}

//==================================================================================================================
//  addClassName
//------------------------------------------------------------------------------------------------------------------
function addClassName(e,t) {
	if (typeof e == "string") {
		e = xGetElementById(e);
	}
	//code to change and replace strings
	var ec = ' ' + e.className.replace(/^\s*|\s*$/g,'') + ' ';
	var nc = ec;
	t = t.replace(/^\s*|\s*$/g,'');
	//check if not already there
	if (ec.indexOf(' '+t+' ') == -1) {
		//not found, add it
		nc = ec + t;
	}
	//return the changed text!
	e.className = nc.replace(/^\s*|\s*$/g,''); //trimmed whitespace
	return true;
}

//==================================================================================================================
//  removeClassName
//------------------------------------------------------------------------------------------------------------------
function removeClassName(e,t) {
	if (typeof e == "string") {
		e = xGetElementById(e);
	}
	//code to change and replace strings
	var ec = ' ' + e.className.replace(/^\s*|\s*$/g,'') + ' ';
	var nc = ec;
	t = t.replace(/^\s*|\s*$/g,'');
	//check if not already there
	if (ec.indexOf(' '+t+' ') != -1) {
		//found, so lets remove it
		nc = ec.replace(' ' + t.replace(/^\s*|\s*$/g,'') + ' ',' ');
	}
	//return the changed text!
	e.className = nc.replace(/^\s*|\s*$/g,''); //trimmed whitespace
	return true;
}

//==================================================================================================================
//  attachToForms
//------------------------------------------------------------------------------------------------------------------
function attachToForms(e) {
	//search dom for all forms
	var frms = document.getElementsByTagName('form');
	for(var i=0;i<frms.length;i++) {
		YAHOO.util.Event.addListener(frms[i], "submit", FIC_checkForm);
	}
}

//==================================================================================================================
//  isVisible
//------------------------------------------------------------------------------------------------------------------
function isVisible(e) {
	//returns true is should be visible to user.
	if (typeof e == "string") {
		e = xGetElementById(e);
	}
	while (e.nodeName.toLowerCase() != 'body' && e.style.display.toLowerCase() != 'none' && e.style.visibility.toLowerCase() != 'hidden'  && !YAHOO.util.Dom.hasClass(e, 'unactive')) {
		e = e.parentNode;
	}
	if (e.nodeName.toLowerCase() == 'body') {
		return true;
	} else{
		return false;
	}
}


//YAHOO.util.Event.addListener(window, "load", attachToForms);

