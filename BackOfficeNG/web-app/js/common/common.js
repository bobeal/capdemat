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


  zcc.validateAndFilterResponse = function(o) {
    var response = YAHOO.lang.JSON.parse(o.responseText);
    if (response.status === 'error') {
      zct.Notifier.processMessage('modelError', errorBody);
      return false;
    }
    return true;
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
  
  YAHOO.lang.extend(zcc.deleteConfirmationDialog, YAHOO.widget.SimpleDialog);
  YAHOO.lang.extend(zcc.errorMessageDialog, YAHOO.widget.SimpleDialog);
  YAHOO.lang.extend(zcc.responseResultAnimation, YAHOO.util.ColorAnim);


  YAHOO.util.Event.onDOMReady(function(){
    zcc.setMenu();
  });

}());

