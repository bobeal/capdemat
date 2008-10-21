/**
 * Contains common client-side functions of capdemat project 
 *  
 * @namespace zenexity.capdemat.common
 * 
 **/

(function() {
  
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  
  zcc.messageAreaId = 'errorMessages';
  
  zcc.switchSelectedItemDisplay = function(itemId, className) {
	  // first, deselect any previously selected item
	  var elements = YAHOO.util.Dom.getElementsByClassName(className);
	  var i = 0;
      for (i=0;i < elements.length; i++) {
        YAHOO.util.Dom.removeClass(elements[i], className); 
      }
      // then add the class name to the newly selected item
      var selectedItem = document.getElementById(itemId);
      YAHOO.util.Dom.addClass(selectedItem, className); 
  };
  
  zcc.responseResultAnimation = function(hexaColor) {
    zcc.responseResultAnimation.superclass.constructor.call(this,
      messagesAreaId, {
        backgroundColor: {
          to: hexaColor
        }
      }, 2, YAHOO.util.Easing.easeOut
    );
  };

  zcc.displayResponseResult = function(resultType,message) {
    var newCssClass;
    var responseMessageAnimation
    var bgColor = '#FFFFFF';
    if (resultType === 'unexpectedError' || resultType === 'modelError') {
          errorMessageDialog = new zcc.errorMessageDialog(null, null, message);
          // errorMessageDialog.setBody(confirmMessage);
          errorMessageDialog.show();
    } else if (resultType === 'success') {
        newCssClass = 'success-top';
        bgColor = '#DDFFDD';
    
        var divEl = new YAHOO.util.Element(messagesAreaId);
        divEl.replaceClass('invisible', newCssClass);
        
        var el = document.getElementById(messagesAreaId);
        el.innerHTML = message;
        
        responseMessageAnimation = new zcc.responseResultAnimation(bgColor);
        
        // TODO : customize animation according to type of error
        // errorMessageAnimation.duration = 1;
        // errorMessageAnimation.method = YAHOO.util.Easing.easeOut;
        responseMessageAnimation.animate();
    }
  };

  zcc.handleUnexpectedError = function(o) {
    var errorBody = o.statusText + ' (' + o.status + ')';
    zcc.displayResponseResult('unexpectedError', errorBody);
  };
  
  zcc.validateAndFilterResponse = function(o) {
    var response = YAHOO.lang.JSON.parse(o.responseText);
    if (response.status === 'error') {
      zcc.displayResponseResult('modelError', response.error_msg);
      return false;
    }
    return true;
  };

  zcc.doAjaxCall = function(callUrl,args,callback) {
    var handlers = {
      failure: zcc.handleUnexpectedError
    };
    if (zct.isFunction(callback)) handlers.success = callback;
    if (args) handlers.argument = args;
    
    var url = [zenexity.capdemat.bong.baseUrl, callUrl].join('');
    
    if(zct.browser.msie) {
      var special = ['iemustdie=',Math.random().toString(16).substring(2)].join('');
      if(/.*\&.*/.test(url)) url = [url,'&',special].join('');
      else url = [url,'?',special].join('');
    }
    
    YAHOO.util.Connect.asyncRequest('GET', url, handlers, null);
  };

  zcc.doAjaxFormSubmitCall = function(formId,args,callback,upload) {
    var formElement = new YAHOO.util.Element(formId);
    // to retrieve form values
    if (upload)
      YAHOO.util.Connect.setForm(document.getElementById(formId), true);
    else
      YAHOO.util.Connect.setForm(document.getElementById(formId));
    var handlers = {
      failure: zcc.handleUnexpectedError
    };
    if (zct.isFunction(callback)) handlers.success = callback;
    if (args) handlers.argument = args;
    var url = formElement.get('action');
    YAHOO.util.Connect.asyncRequest('POST', url, handlers, null);
  };
  
  zcc.doAjaxDeleteCall = function(url,params,callback) {
    var handlers = {
      failure: zcc.handleUnexpectedError
    };
    if (zct.isFunction(callback)) handlers.success = callback;
    var url = [zenexity.capdemat.bong.baseUrl,url,'?',params].join('');
    YAHOO.util.Connect.asyncRequest('DELETE', url, handlers);
  };
  
  zcc.collectSearchFormValues = function (formId) {
    
    var queryUrl = '';
    var nodes = YAHOO.util.Selector.query('input', formId);
    for (i=0; i < nodes.length; i++) {
      if (nodes[i].value && nodes[i].value != '')
        queryUrl += nodes[i].name + "=" + nodes[i].value + "&";
    }
    nodes = YAHOO.util.Selector.query('select', formId);
    for (i=0; i < nodes.length; i++) {
      if (nodes[i].value && nodes[i].value != '')
        queryUrl += nodes[i].name + "=" + nodes[i].value + "&";
    }
	
    return queryUrl;
  };
  
  zcc.setMenu = function() {
    zcc.switchSelectedItemDisplay(
      zenexity.capdemat.bong.currentMenu + 'MenuItem',
      'selected-menu-entry');
  };
  
  zcc.deleteConfirmationDialog = function(divId,handleConfirmDelete,body) {
    zcc.deleteConfirmationDialog.superclass.constructor.call(this,
      divId || YAHOO.util.Dom.generateId() ,
      {
        width: "20em",
        effect:{effect:YAHOO.widget.ContainerEffect.FADE, duration:0.25},
        modal:true, visible:false, draggable:false, fixedcenter:true,
        icon:YAHOO.widget.SimpleDialog.ICON_WARN,
        buttons:[{ text:"Oui", handler:handleConfirmDelete, isDefault:true },
                { text:"Non", handler:function() {this.hide();}}]
      }
    );

    this.setHeader("Attention !");
    this.setBody(body);
    this.render("bd");
  };

  zcc.errorMessageDialog = function(divId,handleSendErrorLog,body) {
    zcc.errorMessageDialog.superclass.constructor.call(this,
      divId || YAHOO.util.Dom.generateId() ,
      {
          width: "30em",
          effect:{effect:YAHOO.widget.ContainerEffect.FADE, duration:0.1},
          modal:true, visible:false, draggable:false, fixedcenter:true,
          icon:YAHOO.widget.SimpleDialog.ICON_BLOCK,
          buttons:[
              { text:"Envoyer un rapport", handler:handleSendErrorLog, isDefault:true },
              { text:"Ignorer", handler:function() {this.hide();} }
          ]
      }
    );
      
    this.setHeader("Attention !");
    this.setBody(body);
    this.render("bd");
  };
  
  zcc.ConfirmationDialog = function(content,confirmHandler) {
    this.Id = YAHOO.util.Dom.generateId();
    this.Label = {Ok:'Ok',Cancel:'Cancel'};
    this.showTarget = undefined;
    
    zcc.ConfirmationDialog.superclass.constructor.call(this,
    this.Id,
    { width: "20em",
      effect:{effect:YAHOO.widget.ContainerEffect.FADE, duration:0.25},
      modal:true, visible:false, draggable:false, fixedcenter:true,
      icon:YAHOO.widget.SimpleDialog.ICON_WARN,
      buttons:[{ text:this.Label.Ok,isDefault:true,handler:function(e){
                  zct.tryToCall(confirmHandler,this);
                  this.hide();}},
               { text:this.Label.Cancel, handler:function() {this.hide();}}]
      }
    );
    
    this.setHeader(content.head);
    this.setBody(content.body);
    var el = YAHOO.util.Selector.query("div.yui-skin-sam")[0] || document.body;
    this.render(el);
  };
  
  YAHOO.lang.extend(zcc.ConfirmationDialog,YAHOO.widget.SimpleDialog)
  
  zcc.ConfirmationDialog.prototype.show = function(e) {
    zcc.ConfirmationDialog.superclass.show.call(this);
    if(!!e) this.showTarget = YAHOO.util.Event.getTarget(e);
    else this.showTarget = undefined;
  }
  
  YAHOO.lang.extend(zcc.deleteConfirmationDialog, YAHOO.widget.SimpleDialog);
  YAHOO.lang.extend(zcc.errorMessageDialog, YAHOO.widget.SimpleDialog);
  YAHOO.lang.extend(zcc.responseResultAnimation, YAHOO.util.ColorAnim);
  
  YAHOO.util.Event.onDOMReady(zcc.setMenu);
  
}());


// declare the namespace for our application
YAHOO.namespace("capdematBo");

var messagesAreaId = 'errorMessages';

YAHOO.capdematBo.responseResultAnimation = function(hexaColor) {
    YAHOO.capdematBo.responseResultAnimation.superclass.constructor.call(this,
        messagesAreaId, 
        {
            backgroundColor: { to: hexaColor }
        }, 2, YAHOO.util.Easing.easeOut
    );
};

YAHOO.lang.extend(YAHOO.capdematBo.responseResultAnimation, YAHOO.util.ColorAnim);

// generic method to display the result of an operation
//
// resultType can be one of :
//   * unexpectedError
//   * modelError
//   * success
var responseMessageAnimation;
function displayResponseResult(resultType,message) {
    var newCssClass;
    var bgColor = '#FFFFFF';
    if (resultType === 'unexpectedError' || resultType === 'modelError') {
          errorMessageDialog = new YAHOO.capdematBo.errorMessageDialog(null, null, message);
          // errorMessageDialog.setBody(confirmMessage);
          errorMessageDialog.show();
    } else if (resultType === 'success') {
        newCssClass = 'success-top';
        bgColor = '#DDFFDD';
    
        var divEl = new YAHOO.util.Element(messagesAreaId);
        divEl.replaceClass('invisible', newCssClass);
        
        var el = document.getElementById(messagesAreaId);
        el.innerHTML = message;
        
        responseMessageAnimation = new YAHOO.capdematBo.responseResultAnimation(bgColor);
        
        // TODO : customize animation according to type of error
        // errorMessageAnimation.duration = 1;
        // errorMessageAnimation.method = YAHOO.util.Easing.easeOut;
        responseMessageAnimation.animate();
    }
}

// used to display unexpected (and unhandled) errors
function handleUnexpectedError(o) {
    var errorBody = o.statusText + ' (' + o.status + ')';
    displayResponseResult('unexpectedError', errorBody);
}

function validateAndFilterResponse(o) {
    var response = YAHOO.lang.JSON.parse(o.responseText);
    if (response.status === 'error') {
        displayResponseResult('modelError', response.error_msg);
        return false;
    }
    
    return true;        
};

// issue an AJAX call based on YUI Connection component
function doAjaxCall(callUrl,successCallback,args) {
    var callback = {
        failure: handleUnexpectedError
    };
    if (successCallback)
        callback.success = successCallback;
    if (args)
        callback.argument = args;
    var url = zenexity.capdemat.bong.baseUrl + callUrl;
    var transaction = YAHOO.util.Connect.asyncRequest('GET', url, callback, null);
}

// issue an AJAX form submit call based on YUI Connection component
function doAjaxFormSubmitCall(successCallback,args,formId,withFileUpload) {
    var formElement = new YAHOO.util.Element(formId);
    // to retrieve form values
    if (withFileUpload)
        YAHOO.util.Connect.setForm(document.getElementById(formId), true);
    else
        YAHOO.util.Connect.setForm(document.getElementById(formId));    
    var callback = {
        failure: handleUnexpectedError
    };
    if (successCallback)
        callback.success = successCallback;
    if (args)
        callback.argument = args;
    var url = formElement.get('action');
    var transaction = YAHOO.util.Connect.asyncRequest('POST', url, callback, null);
}

function collectSearchFormValues(formId) {
	var queryUrl = '';
	var nodes = YAHOO.util.Selector.query('input', formId);
	for (i=0; i < nodes.length; i++) {
		if (nodes[i].value && nodes[i].value != '')
			queryUrl += nodes[i].id + "=" + nodes[i].value + "&";
	}
	nodes = YAHOO.util.Selector.query('select', formId);
	for (i=0; i < nodes.length; i++) {
		if (nodes[i].value && nodes[i].value != '')
			queryUrl += nodes[i].id + "=" + nodes[i].value + "&";
	}
	
	return queryUrl;
}

YAHOO.capdematBo.deleteConfirmationDialog = function(divId,handleConfirmDelete,body) {
    YAHOO.capdematBo.deleteConfirmationDialog.superclass.constructor.call(this,
        divId || YAHOO.util.Dom.generateId() , 
        { 
            width: "20em", 
            effect:{effect:YAHOO.widget.ContainerEffect.FADE, duration:0.25}, 
            modal:true, visible:false, draggable:false, fixedcenter:true,
            icon:YAHOO.widget.SimpleDialog.ICON_WARN,
            buttons:[{ text:"Oui", handler:handleConfirmDelete, isDefault:true },
                    { text:"Non", handler:function() {this.hide();}}]
        }
    );
    
    this.setHeader("Attention !");
    this.setBody(body);
    this.render("bd");
};

YAHOO.lang.extend(YAHOO.capdematBo.deleteConfirmationDialog, YAHOO.widget.SimpleDialog);

// Error message Dialog
YAHOO.capdematBo.errorMessageDialog = function(divId,handleSendErrorLog,body) {
    YAHOO.capdematBo.errorMessageDialog.superclass.constructor.call(this,
        divId || YAHOO.util.Dom.generateId() , 
        { 
            width: "30em", 
            effect:{effect:YAHOO.widget.ContainerEffect.FADE, duration:0.1}, 
            modal:true, visible:false, draggable:false, fixedcenter:true,
            icon:YAHOO.widget.SimpleDialog.ICON_BLOCK,
            buttons:[
                { text:"Envoyer un rapport", handler:handleSendErrorLog, isDefault:true },
                { text:"Ignorer", handler:function() {this.hide();} }
            ]
        }
    );
    
    this.setHeader("Attention !");
    this.setBody(body);
    this.render("bd");
};

YAHOO.lang.extend(YAHOO.capdematBo.errorMessageDialog, YAHOO.widget.SimpleDialog);
