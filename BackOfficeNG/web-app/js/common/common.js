/**
 * Contains common client-side functions of capdemat project
 *
 * @namespace zenexity.capdemat.common
 *
 **/

(function() {

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var yus = YAHOO.util.Selector;
  var yue = YAHOO.util.Event;
  var yuc = YAHOO.util.Connect;
  var yud = YAHOO.util.Dom;
  var yu = YAHOO.util;

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
      zcc.Notifier.getMessageZone(), {
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
    zcc.Notifier.processMessage('unexpectedError', errorBody);
  };

  zcc.validateAndFilterResponse = function(o) {
    var response = YAHOO.lang.JSON.parse(o.responseText);
    if (response.status === 'error') {
      zcc.Notifier.processMessage('modelError', errorBody);
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
      //((url.indexOf('?') == -1)?'?':'&')
      url = [url,((url.indexOf('?') == -1)?'?':'&'),special].join('');
      //else url = [url,'?',special].join('');
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

  /**
   * @description Confirmation dialog class, extends base functionality of YUI SimpleDialog.
   * @param {Object} content JSON describer of dialog content.
   * @param {Function} confirmHandler function called after confirmaton
   * @author vba@zenexity.fr
   */
  zcc.ConfirmationDialog = function(content,confirmHandler) {
    this.Id = YAHOO.util.Dom.generateId();
    this.Label = {
      first:  content.button1 || 'Ok',
      second: content.button2 || 'Annuler'
    };
    this.showTarget = undefined;

    zcc.ConfirmationDialog.superclass.constructor.call(this,
    this.Id,
    { width: "20em",
      effect:{effect:YAHOO.widget.ContainerEffect.FADE, duration:0.25},
      modal:true, visible:false, draggable:false, fixedcenter:true,
      icon:YAHOO.widget.SimpleDialog.ICON_WARN ,
      buttons:[{ text: this.Label.first,isDefault:true,
        handler:function(e){zct.tryToCall(confirmHandler,this);this.hide();}},
               { text:this.Label.second, handler:function() {this.hide();}}]
      }
    );
    this.setHeader(content.head || 'Warning');
    this.setBody(content.body || 'Confirm ?');
    var el = yus.query("div.yui-skin-sam")[0] || document.body;
    this.render(el);
  };

  YAHOO.lang.extend(zcc.ConfirmationDialog,YAHOO.widget.SimpleDialog)

  zcc.ConfirmationDialog.prototype.show = function(e) {
    zcc.ConfirmationDialog.superclass.show.call(this);
    if(!!e) this.showTarget = YAHOO.util.Event.getTarget(e);
    else this.showTarget = undefined;
  };

  YAHOO.lang.extend(zcc.deleteConfirmationDialog, YAHOO.widget.SimpleDialog);
  YAHOO.lang.extend(zcc.errorMessageDialog, YAHOO.widget.SimpleDialog);
  YAHOO.lang.extend(zcc.responseResultAnimation, YAHOO.util.ColorAnim);


  zcc.limitArea = function(targetId, limit, infodiv) {
    var textarea = yud.get(targetId);
    var text = textarea.value;
    var textlength = text.length;
    var info = yud.get(infodiv);

    if(textlength > limit) {
      info.innerHTML = 'Ce champ est limité à '+limit+' caractères!';
      textarea.value = text.substr(0,limit);
      return false;
    } else {
      info.innerHTML = 'Il vous reste '+ (limit - textlength) +' caractères.';
      return true;
    }
  };

  zcc.Notifier = function() {
    return {
      confirmationDialog : undefined,
      getMessageZone : function() {
        return "errorMessages";
      },
      init : function(o) {
        var content = {
          head : "Attention !",
          button2: "Ignorer",
          button1 : "Envoyer un rapport"
        };
        zcc.Notifier.confirmationDialog = new zcc.ConfirmationDialog(
        content,zcc.Notifier.confirmHandler);
      },
      processMessage : function(type,message) {
        var method = ['display',zct.capitalize(type)].join('');
        zct.tryToCall(zcc.Notifier[method],zcc.Notifier,message);
      },
      displaySuccess : function(message) {
        //TODO Reorganize & optimize this method
        newCssClass = 'success-top';
        bgColor = '#DDFFDD';

        var divEl = new YAHOO.util.Element(zcc.Notifier.getMessageZone());
        divEl.replaceClass('invisible', newCssClass);

        var el = document.getElementById(zcc.Notifier.getMessageZone());
        el.innerHTML = message;

        responseMessageAnimation = new zcc.responseResultAnimation(bgColor);
        responseMessageAnimation.animate();
      },
      displayUnexpectedError : function(message) {},
      displayModelError : function(message) {},
      confirmHandler : function() {}
    }
  }();

  zct.each(['UnexpectedError','ModelError'],function(i,name){
    zcc.Notifier[['display',name].join('')] = function(message) {
      zcc.Notifier.confirmationDialog.setBody(message);
      zcc.Notifier.confirmationDialog.show();
      console.debug(name);
    }
  });

  /**
   * @description Provides advanced support for firebug-lite console.
   * @author vba@zenexity.fr
   */
  zcc.debug = {
    injectFirebug : function(name,scope) {
      var src = 'http://getfirebug.com/releases/lite/1.2/firebug-lite-compressed.js';
      var head = document.getElementsByTagName("head")[0];
      var scripts = zct.grep(yud.getChildren(head),function(n){
        return(n['src']==src);
      });

      if(scripts.length == 0) {
        var newscript = document.createElement('script');
        newscript.type = 'text/javascript';
        newscript.src = src;

        newscript.onload = newscript.onreadystatechange = function(){
          if (!this.readyState || this.readyState == "loaded" || this.readyState == "complete") {
            firebug.init();
            zcc.debug.initXHR();
            firebug.d.console[name](scope);
            zcc.debug.loading = false;
          }
        };

        head.appendChild(newscript);
      }
      return undefined;
    },
    initXHR : function() {
      if(!!firebug && !yuc.oldAsyncRequest) {
        yuc.oldAsyncRequest = yuc.asyncRequest;

        yuc.asyncRequest = function(method, uri, callback, postData) {
          var log = {
            'method' : method,
            'uri' : uri,
            'callback' : callback,
            'postData' : postData
          };
          var local = {
            success : callback.success,
            failure :  callback.faulure
          };

          zct.each(local,function(k,v){
            callback[k] = function(o) {
              if(zct.isFunction(v))v(o);
              log.status = o.status;
              log.statusText = o.statusText;
              log.response = o.responseText;
              zcc.debug.log(log);
            }
          });

          var res = yuc.oldAsyncRequest(method, uri, callback, postData);
          return res;
        }
      }
    }
  }

  zct.each(['log','print','dir'],function(i,name){
    zcc.debug[name] = function(o) {
      if(!o)o=o+'';
      if(typeof firebug == 'undefined') zcc.debug.injectFirebug(name,o);
      else firebug.d.console[name](o);
    }
  });

  zcc.Event = function(context,rule) {
    this.context = context;
    this.rule = rule;
  }

  zcc.Event.prototype.dispatch = function(e) {
    var method = zct.tryToCall(this.rule,this.context,e);
    zct.tryToCall(this.context[method],this.context,e);
  }


  YAHOO.util.Event.onDOMReady(function(){
    zcc.setMenu();
    zcc.Notifier.init();
  });

}());

