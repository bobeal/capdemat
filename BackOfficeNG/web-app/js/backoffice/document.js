zenexity.capdemat.bong.document = function() {
  var zcbr = zenexity.capdemat.bong.request;
  var zcb = zenexity.capdemat.bong;
  var zca = zenexity.capdemat.aspect;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yuel = YAHOO.util.Element;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  var ywtv = YAHOO.widget.TabView;
  var ywt = YAHOO.widget.Tab;
  var ywp = YAHOO.widget.Panel;
  var yl = YAHOO.lang;
  
  /*
   * request document management 
   */
  
  function submitModifyDocumentForm(formId) {
    zct.doAjaxFormSubmitCall(
        formId,
        null,
        function(o) {
          var json = ylj.parse(o.responseText);
          if (json.status === "ok") {
            zct.Notifier.processMessage('success',json.success_msg,'documentInformationtMsg');
            if (formId === "documentStateForm") {
              yud.setStyle("documentTransitionStates", "display", "none");
              zcb.documentStateUpdateEvent.fire(formId);
            }
            else {
            }
          } else {
//            console.log("submitModifyDocumentForm() ERROR");
          }
        });
  }
  
  function getRequestDocument(targetEl) {
    // hacks for ie6
    var action = targetEl.pathname;
    if (action.indexOf("/") != 0)
      action = "/" + action;
      
    zct.doAjaxCall(
        action,
        null,
        function(o) {
          zcb.requestDocumentPanel.setBody(o.responseText);
          zcb.requestDocumentPanel.show();
         
          // request document tabviews
          var requestDocumentDataTabView = new ywtv("requestDocumentData");
          var requestDocumentMetaDataTabView = new ywtv("documentMetaData");
        });
  }
  
  function switchDocumentStates(targetEl) {
    var statesEl = yud.get("documentTransitionStates");
    
    if (yud.getStyle(statesEl, "display") != "none") {
      yud.setStyle(statesEl, "display", "none");
    }
    else {
      yud.setStyle(statesEl, "display", "block");
      yud.setStyle(statesEl, "border-color", yud.getStyle(targetEl, "background-color"));
      
      var id = targetEl.className.split(' ')[1].replace("documentState_", "");
      var stateCssClass = targetEl.className.split(' ')[0];

      zct.doAjaxCall(
          "/documentStates/" 
              + "?id=" + id 
              + "&stateCssClass=" + stateCssClass 
              + "&endValidityDate=" + yl.trim(yud.getLastChild(targetEl).innerHTML),
          null,
          function(o) {
            statesEl.innerHTML = o.responseText;
            
            YAHOO.capdematBo.calendar.cal = new Array(1);
            yue.onDOMReady(YAHOO.capdematBo.calendar.init, {id: 0, label: "endValidityDate"} );
          });
    }
  }
  
  var requestDocumentHandler = function (e) {
    var targetEl = yue.getTarget(e);
    
    if (yud.hasClass(targetEl, "cancelDocumentStateChange")) {
      switchDocumentStates(targetEl);
    }
    else if (yud.hasClass(targetEl, "submitDocumentStateChange")) {
      if (FIC_checkForm(e, yud.get("documentStateFormErrors")))
        submitModifyDocumentForm("documentStateForm"); 
    }
    else if (targetEl.className === "documentLink") {
      yue.preventDefault(e);
      getRequestDocument(targetEl);
    }
    else if (targetEl.id === "submitModifyDocumentForm") {
      if (FIC_checkForm(e, yud.get("modifyDocumentFormErrors")))
        submitModifyDocumentForm("modifyDocumentForm"); 
    }
    else if (targetEl.id === "documentState") {
      switchDocumentStates(targetEl);
    }
    else if (targetEl.parentNode.id === "documentState") {
      switchDocumentStates(targetEl.parentNode);
    }
  };
  requestDocumentHandler = zca.condition(requestDocumentHandler,zcbr.Permission.validateAgent);
  yue.on("requestDocument","click",requestDocumentHandler);
  
  
  zcb.documentStateUpdateEvent = new YAHOO.util.CustomEvent('documentStateUpdateEvent');
  
  zcb.documentStateUpdateEvent.subscribe (
      function(type, args) {
        var documentId = yud.get(args[0]).documentId.value;
        var newFlagStateEl = yud.getNextSibling(yus.query("input:checked", args[0], true));
       
        zct.each(
            yus.query(".documentState_" + documentId),
            function() {
              if (yud.getFirstChild(this) === null) {
                this.innerHTML = yl.trim(newFlagStateEl.innerHTML);
              } else {
                yud.getFirstChild(this).innerHTML = yl.trim(newFlagStateEl.innerHTML);
              }
              yud.replaceClass(this, this.className.split(" ")[0], newFlagStateEl.className);
            });
      }
  );
  
  zcb.documentStateUpdateEvent.subscribe (
      function(type, args) {
        yud.getFirstChild(yud.get("documentEndValidityDate")).innerHTML = 
            yud.get(args[0]).endValidityDate.value;
      }
  );
  
  return {
    init: function() {
      getRequestDocument = zca.condition(getRequestDocument,zcbr.Permission.validateState);
    },
    getRequestDocument: function(targetEl) { getRequestDocument(targetEl); }
  };
  
}();

YAHOO.util.Event.onDOMReady(zenexity.capdemat.bong.document.init);