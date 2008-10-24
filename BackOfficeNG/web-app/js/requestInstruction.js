zenexity.capdemat.bong.requestIntruction = function() {
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var yud = YAHOO.util.Dom;
  var yuel = YAHOO.util.Element;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  var ywtv = YAHOO.widget.TabView;
  var ywt = YAHOO.widget.Tab;
  var ywp = YAHOO.widget.Panel;
  var yl = YAHOO.lang;
  
  function init() {
    /* tabiews */
    var requestInformationTabview = new ywtv();
    requestInformationTabview.addTab( new ywt({
        label: 'Historique', dataSrc: zcb.baseUrl + '/requestActions/' + zcb.requestId,
        cacheData: true, active: true }));
    requestInformationTabview.addTab( new ywt({
        label: 'Commentaires', dataSrc: zcb.baseUrl + '/requestNotes/' + zcb.requestId,
        cacheData: false }));
    requestInformationTabview.addTab( new ywt({
        label: 'Compte', dataSrc: zcb.baseUrl + '/homeFolder',
        cacheData: true }));
    requestInformationTabview.addTab( new ywt({
        label: 'Demandes', dataSrc: zcb.baseUrl + '/homeFolderRequests/' + zcb.requestId,
        cacheData: true }));
    
    requestInformationTabview.appendTo('requestInformation');
    
    var requestDataTabView = new ywtv('requestData');
      
    /* panels */
    zcb.instructionStatePanel = new ywp(
      "instructionStatePanel", 
      { width: "135%", 
        visible: false, 
        constraintoviewport: true, draggable: false,
        underlay: "none", close: false
      });
    zcb.instructionStatePanel.render();
    
    zcb.requestDocumentPanel = new ywp(
      "requestDocumentPanel", 
      { width: "800px", y: 120,
        visible: false, 
        constraintoviewport: false, draggable: true,
        underlay: "shadow", close: true
      });
    zcb.requestDocumentPanel.render();
    
    zcb.ecitizenContactPanel = new ywp(
      "ecitizenContactPanel", 
      { width: "650px",
        visible: false, 
        constraintoviewport: false, draggable: true,
        underlay: "shadow", close: true
      });
    zcb.ecitizenContactPanel.render();
  }
  
  /*
   * Request Instruction Worflow managment
   */
   
  function submitChangeStateForm(targetEl , formId) {
    // bad strategy to refresh tag state ...
    var nodes = yus.query("input[name=stateType]", formId);
    var oldTagStateEl;
    if (nodes[0].getAttribute("value") != "documentState")
      oldTagStateEl = yud.get(nodes[0].getAttribute("value"));
    else {
      nodes = yus.query("input[name=id]", formId);
      oldTagStateEl = yud.get( "documentState_" + nodes[0].getAttribute("value"));
    }
    
    nodes = yus.query("input:checked", formId);
    var newTagStateEl = yud.getNextSibling(nodes[0]);
    
    zcc.doAjaxFormSubmitCall(
        formId,
        null, 
        function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === "ok") {
            oldTagStateEl.className = newTagStateEl.className;
            oldTagStateEl.innerHTML = newTagStateEl.innerHTML;
            
            zcb.instructionStatePanel.hide();
          } else {
            zcc.displayResponseResult('modelError', response.error_msg);
          }
        });
  }
  
  function getStateTransitions(stateCssClass, stateType) {   
    var id;
    if (stateType.indexOf("documentState_") != -1) {
      id = stateType.replace("documentState_", "");
      stateType = "documentState";
    } else {
      id = zcb.requestId
    }
    
    zcc.doAjaxCall(
        '/stateTransitions/' + '?id=' + id 
          + '&stateCssClass=' + stateCssClass + '&stateType=' + stateType,
        null,
        function(o) {
          zcb.instructionStatePanel.setBody(o.responseText);
          zcb.instructionStatePanel.show();
        });
  }
  
  function switchStatePanel(targetEl) {
    yud.setStyle(
        zcb.instructionStatePanel.id,
        "border-color", 
        yud.getStyle(targetEl, "background-color"));
    
    zcb.instructionStatePanel.cfg.setProperty("context", [targetEl,"tr","br"])
    
    if (! zcb.instructionStatePanel.cfg.getProperty("visible"))
      getStateTransitions(targetEl.className, targetEl.id);
    else
      zcb.instructionStatePanel.hide();
  }
  
  yue.addListener(
      "narrow", 
      "click", 
      function (e) {
        var targetEl = yue.getTarget(e);
           
        if (targetEl.className === "cancelStateChange") {
          zcb.instructionStatePanel.hide();
        } else if (targetEl.className === "submitStateChange") {
          if (FIC_checkForm(e, yud.get("changeStateFormErrors")))
            submitChangeStateForm(targetEl, "changeStateForm");
        } else if ( targetEl.className.indexOf("tag-") 
                    != -1 && targetEl.className != "tag-not_provided") {
          switchStatePanel(targetEl);
        }
      });
   
  /*
   * request document management 
   */
  
  function submitModifyDocumentForm(formId) {
    zcc.doAjaxFormSubmitCall(
        formId,
        null,
        function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === "ok") {
            yud.setStyle(formId, "background", "#aaffaa");
          } else {
            zcc.displayResponseResult('modelError', response.error_msg);
          }
        });
  }
  
  function getRequestDocument(targetEl) {
    // hacks for ie6
    var action = targetEl.pathname;
    if (action.indexOf("/") != 0)
      action = "/" + action;
      
    zcc.doAjaxCall(
        action,
        null,
        function(o) {
          zcb.requestDocumentPanel.setBody(o.responseText);
          zcb.requestDocumentPanel.show();
          // request document tabview
          var requestDocumentDataTabView = new ywtv('requestDocumentData');
          YAHOO.capdematBo.calendar.cal = new Array(1);
          yue.onDOMReady(
            YAHOO.capdematBo.calendar.init, {id: 0, label: "endValidityDate"} );
        });
  }
  
  yue.addListener(
      "requestDocument",
      "click", 
      function (e) {
        yue.preventDefault(e);
        
        var targetEl = yue.getTarget(e);
        if (targetEl.className === "documentLink")
          getRequestDocument(targetEl);
        else if (targetEl.id === "submitModifyDocumentForm")
          submitModifyDocumentForm("modifyDocumentForm"); 
      });
  
  /*
   * ecitizen contact management 
   */
  
  function submitContactForm(formId) {
    zcc.doAjaxFormSubmitCall (formId,null, 
      function(o) { 
        zcb.ecitizenContactPanel.hide();
      });
  }
  
  function getEcitizenContactPanel(targetEl) {
    // hacks for ie6
    var action = targetEl.pathname;
    if (action.indexOf("/") != 0)
      action = "/" + action;
      
    zcc.doAjaxCall(
        action,
        null,
        function(o) {
         zcb.ecitizenContactPanel.setBody(o.responseText);
         zcb.ecitizenContactPanel.show();
        });
  }
  
  yue.addListener(
      "ecitizenContact", 
      "click",
      function(e) { 
        var targetEl = yue.getTarget(e);
        if (targetEl.id === "ecitizenContactLink") {
          yue.preventDefault(e);
          getEcitizenContactPanel(targetEl); 
        } else if (targetEl.id === "submitContactForm") {
          if (FIC_checkForm(e, yud.get("contactFormErrors")))
            submitContactForm("contactForm");
        } else if (targetEl.id === "discardContactForm") {
          zcb.ecitizenContactPanel.hide();
        }
      });
  
  /* ecitizen means of contact default  */
  yue.addListener(
      "ecitizenContact", 
      "change",
      function(e) {
        var targetEl = yue.getTarget(e);
      
        if (targetEl.name === "meansOfContact") {
          var contactReciepientEl = yud.get("contactReciepient"); 
          
          if (targetEl.value === "Email")
            contactReciepientEl.value = yud.get("requesterEmail").value;
          else if (targetEl.value === "Sms")
            contactReciepientEl.value = yud.get("requesterMobilePhone").value;
        } 
      });
      
  
  /*
   * request data inline edition managment
   */
  
  function submitEditProperty(targetEl, formId) {
    zcc.doAjaxFormSubmitCall(
        formId,
        null, 
        function(o) {
          var response = ylj.parse(o.responseText);
          if (response.status === "ok") {
            hideEditProperty(targetEl, true);
            yud.setStyle(formId.replace("_Form", ""), "background", "#aaffaa");
          }
          else {
            yud.get(formId + "Error").innerHTML = response.error_msg;
//            zcc.displayResponseResult('modelError', response.error_msg);
          }
        });
  }
  
  function hideEditProperty(targetEl, isSubmit) {
    var formEl = yud.getAncestorByTagName(targetEl, "form");
    var oldPropertyValue;
    if (!isSubmit)
      oldPropertyValue = yus.query("input[name=oldPropertyValue]", formEl, true).value;
    else {
      var elName = formEl.id.replace("_Form", "") + "_tp";
      oldPropertyValue = yud.get(elName).value;
//      var elName = formEl.id.replace("_Form", "");
//      oldPropertyValue = yus.query("input[name=" + elName + "]", formEl, true).value;
    }
    
    var ddEl = yud.getAncestorByTagName(targetEl, "dd");
    new yuel(ddEl).removeChild(yud.getAncestorByTagName(targetEl, "form"));
    yud.removeClass(ddEl, "currentEditProperty");
    ddEl.innerHTML = oldPropertyValue;
  }
  
  function showEditProperty(targetEl, widgetType) {
    zcc.doAjaxCall(
        "/widget/?"
          + "id=" + zenexity.capdemat.bong.requestId
          + "&widget=" + widgetType
          + "&propertyName=" + targetEl.id
          + "&propertyValue=" + yl.trim(targetEl.innerHTML),  
        null,
        function(o) {
          yud.addClass(targetEl, "currentEditProperty");
          targetEl.innerHTML = o.responseText;   
        });
  }
  
  yue.addListener(
      "requestData", 
      "click",
      function(e) {
        var targetEl = yue.getTarget(e);
        
        switch(targetEl.className) {
          case "string" :
            showEditProperty(targetEl, "string");
            break;
          case "submit" :
            var formEl = yud.getAncestorByTagName(targetEl, "form");
            if (FIC_checkForm(e, yud.get(formEl.id + "Errors")))
              submitEditProperty(targetEl, formEl.id);
            break;
          case "discard" :
            hideEditProperty(targetEl, false);
            break;
        }
      });
   
  return {
    init: function() { init(); }
  };
  
}();

YAHOO.util.Event.onDOMReady(zenexity.capdemat.bong.requestIntruction.init);


