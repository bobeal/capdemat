(function() {
	var zcc = zenexity.capdemat.common;
	
	// RequestInstruction TabView Initialization
	function initRequestInstruction() {
		// TabView 1 (Request's History and Notes)
		var requestInformationTabview = new YAHOO.widget.TabView();
			
			requestInformationTabview.addTab( new YAHOO.widget.Tab({
					label: 'Historique',
					dataSrc: YAHOO.capdematBo.baseUrl + '/loadRequestHistory/' + YAHOO.capdematBo.requestId,
					cacheData: true,
					active: true
			}));
			requestInformationTabview.addTab( new YAHOO.widget.Tab({
					label: 'Commentaires',
					dataSrc: YAHOO.capdematBo.baseUrl + '/loadRequestNotes/' + YAHOO.capdematBo.requestId,
					cacheData: false
			}));
			requestInformationTabview.addTab( new YAHOO.widget.Tab({
					label: 'Compte',
					dataSrc: YAHOO.capdematBo.baseUrl + '/loadHomeFolderData',
					cacheData: true
			}));
			requestInformationTabview.addTab( new YAHOO.widget.Tab({
					label: 'Demandes',
					dataSrc: YAHOO.capdematBo.baseUrl + '/loadHomeFolderRequests/' + YAHOO.capdematBo.requestId,
					cacheData: true
			}));
			
			requestInformationTabview.appendTo('requestInformation');
			
			var requestDataTabView = new YAHOO.widget.TabView('requestData');
			
			
			// Instruction State Panel
			YAHOO.capdematBo.instructionStatePanel = new YAHOO.widget.Panel(
					"instructionStatePanel", 
					{ width: "135%", 
						visible: false, 
						constraintoviewport: true,
						draggable: false,
						underlay: "none",
						close: false
					}
			);
			YAHOO.capdematBo.instructionStatePanel.render();
			
			
			// request document panel
			YAHOO.capdematBo.requestDocumentPanel = new YAHOO.widget.Panel(
					"requestDocumentPanel", 
					{ width: "800px",
						y: 120,
						visible: false, 
						constraintoviewport: false,
						draggable: true,
						underlay: "shadow",
						close: true
					}
			);
			YAHOO.capdematBo.requestDocumentPanel.render();
			
			
			// ecitizen contact panel
			YAHOO.capdematBo.ecitizenContactPanel = new YAHOO.widget.Panel(
					"ecitizenContactPanel", 
					{ width: "650px",
						visible: false, 
						constraintoviewport: false,
						draggable: true,
						underlay: "shadow",
						close: true
					}
			);
			YAHOO.capdematBo.ecitizenContactPanel.render();
	}
	
	YAHOO.util.Event.onDOMReady(initRequestInstruction);
	
	
	/*
	 * Request Instruction Worflow managment
	 */
	function submitChangeStateForm(targetEl , formId) {
			// bad strategy to refresh tag state ...
			var nodes = YAHOO.util.Selector.query("input[name=stateType]", formId);
			var oldTagStateEl;
			if (nodes[0].getAttribute("value") != "documentState")
					oldTagStateEl = YAHOO.util.Dom.get(nodes[0].getAttribute("value"));
			else {
					nodes = YAHOO.util.Selector.query("input[name=id]", formId);
					oldTagStateEl = YAHOO.util.Dom.get(
							"documentState_" + nodes[0].getAttribute("value"));
			}
			
			nodes = YAHOO.util.Selector.query("input:checked", formId);
			var newTagStateEl = YAHOO.util.Dom.getNextSibling(nodes[0]);
			
			zcc.doAjaxFormSubmitCall (formId,null, 
					function(o) {
							var response = YAHOO.lang.JSON.parse(o.responseText);
							if (response.status === "ok") {        
									oldTagStateEl.className = newTagStateEl.className;
									oldTagStateEl.innerHTML = newTagStateEl.innerHTML;
									
									YAHOO.capdematBo.instructionStatePanel.hide();
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
					id = YAHOO.capdematBo.requestId
			}
				
			zcc.doAjaxCall(
					'/stateTransitions/' + '?id=' + id 
							+ '&stateCssClass=' + stateCssClass + '&stateType=' + stateType,
					null,
					function(o) {
							YAHOO.capdematBo.instructionStatePanel.setBody(o.responseText);
							YAHOO.capdematBo.instructionStatePanel.show();
					});
	}
	
	function switchStatePanel(targetEl) {
			var targetBgColor = YAHOO.util.Dom.getStyle(targetEl, "background-color");  
			YAHOO.util.Dom.setStyle(YAHOO.capdematBo.instructionStatePanel.id, "border-color", targetBgColor);
			
			YAHOO.capdematBo.instructionStatePanel.cfg.setProperty("context", [targetEl,"tr","br"])
			if (! YAHOO.capdematBo.instructionStatePanel.cfg.getProperty("visible")) {
					getStateTransitions(targetEl.className, targetEl.id);
			}
			else
					YAHOO.capdematBo.instructionStatePanel.hide();
	}
	
	function requestStateEventdispatcher(e) {
			var targetEl = YAHOO.util.Event.getTarget(e);
					 
			if (targetEl.className === "cancelStateChange")
					YAHOO.capdematBo.instructionStatePanel.hide();
			else if (targetEl.className === "submitStateChange")
					submitChangeStateForm(targetEl, "changeStateForm");
			else if (targetEl.className.indexOf("tag-") != -1 && targetEl.className != "tag-not_provided")
					switchStatePanel(targetEl);
	}
	
	YAHOO.util.Event.addListener('narrow', 'click', requestStateEventdispatcher);
	
	
	/*
	 * request document management 
	 */
	
	function submitModifyDocumentForm(formId) {
			zcc.doAjaxFormSubmitCall (formId,null,
					function(o) {
							var response = YAHOO.lang.JSON.parse(o.responseText);
							if (response.status === "ok") {
									YAHOO.util.Dom.setStyle(formId, "background", "#aaffaa");
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
					action,null,
					function(o) {
							YAHOO.capdematBo.requestDocumentPanel.setBody(o.responseText);
							YAHOO.capdematBo.requestDocumentPanel.show();
							// request document tabview
							var requestDocumentDataTabView = new YAHOO.widget.TabView('requestDocumentData');
							YAHOO.capdematBo.calendar.cal = new Array(1);
							YAHOO.util.Event.onDOMReady(
									YAHOO.capdematBo.calendar.init, {id: 0, label: "endValidityDate"} );
					});
	}
	 
	function requestDocumentEventdispatcher(e) {
			YAHOO.util.Event.preventDefault(e);
			
			var targetEl = YAHOO.util.Event.getTarget(e);
			if (targetEl.className === "documentLink")
					getRequestDocument(targetEl);
			else if (targetEl.id === "submitModifyDocumentForm")
					submitModifyDocumentForm("modifyDocumentForm"); 
	}
	
	YAHOO.util.Event.addListener('requestDocument', 'click', requestDocumentEventdispatcher);
	
	
	
	/*
	 * ecitizen contact management 
	 */
	
	function submitContactForm(formId) {
			zcc.doAjaxFormSubmitCall (formId,null, 
					function(o) { 
							YAHOO.capdematBo.ecitizenContactPanel.hide();
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
						 YAHOO.capdematBo.ecitizenContactPanel.setBody(o.responseText);
						 YAHOO.capdematBo.ecitizenContactPanel.show();
					});
	}
	 
	function ecitizenContactEventdispatcher(e) {
			
			var targetEl = YAHOO.util.Event.getTarget(e);
			if (targetEl.id === "ecitizenContactLink") {
					YAHOO.util.Event.preventDefault(e);
					getEcitizenContactPanel(targetEl); 
			} else if (targetEl.id === "submitContactForm") {
					if (FIC_checkForm(e, YAHOO.util.Dom.get("contactFormErrors")))
							submitContactForm("contactForm");
			} else if (targetEl.id === "discardContactForm") {
					YAHOO.capdematBo.ecitizenContactPanel.hide();
			}
	}
	
	YAHOO.util.Event.addListener('ecitizenContact', 'click', ecitizenContactEventdispatcher);
	
	
	/* available  means of contact */
	function changeContactReciepient(e) {
			var targetEl = YAHOO.util.Event.getTarget(e);
	
			if (targetEl.name === "meansOfContact") {
					var contactReciepientEl = YAHOO.util.Dom.get("contactReciepient"); 
					
					if (targetEl.value === "Email") {
							var requesterEmailEl = YAHOO.util.Dom.get("requesterEmail"); 
							contactReciepientEl.value = requesterEmailEl.value;
					}
					else if (targetEl.value === "Sms") {
							var requesterMobilePhoneEl = YAHOO.util.Dom.get("requesterMobilePhone");
							contactReciepientEl.value = requesterMobilePhoneEl.value;
					}
			}
	}
	
	YAHOO.util.Event.addListener('ecitizenContact', 'change', changeContactReciepient);


}());