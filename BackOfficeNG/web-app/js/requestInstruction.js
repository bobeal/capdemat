zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.request');


(function() {

  var zcbr = zenexity.capdemat.bong.request;
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yuel = YAHOO.util.Element;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yud = YAHOO.util.Dom;
  var ylj = YAHOO.lang.JSON;
  var ywtv = YAHOO.widget.TabView;
  var ywt = YAHOO.widget.Tab;
  var ywp = YAHOO.widget.Panel;
  var yl = YAHOO.lang;
  var yw = YAHOO.widget;
  var yu = YAHOO.util;

  zcbr.Instruction = function() {

    function init() {
      /* tabiews */
      var requestInformationTabview = new ywtv();
      requestInformationTabview.addTab( new ywt({
          label: 'Historique', dataSrc: zcb.baseUrl + "/requestActions/" + zcb.requestId,
          cacheData: true, active: true }));
      requestInformationTabview.addTab( new ywt({
          label: 'Commentaires', dataSrc: zcb.baseUrl + "/requestNotes/" + zcb.requestId,
          cacheData: false }));
      requestInformationTabview.addTab( new ywt({
          label: 'Compte', dataSrc: zcb.baseUrl + "/homeFolder",
          cacheData: true }));
      requestInformationTabview.addTab( new ywt({
          label: 'Demandes', dataSrc: zcb.baseUrl + "/homeFolderRequests/" + zcb.requestId,
          cacheData: true }));

      requestInformationTabview.appendTo("requestInformation");

      zcbr.Instruction.dataTabView = new yw.TabView("requestData");
      //var requestDataTabView = new ywtv("requestData");

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
              zcc.Notifier.processMessage('modelError',response.success_msg);
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

          if (yud.hasClass(targetEl, "cancelStateChange")) {
            zcb.instructionStatePanel.hide();
          }
          else if (yud.hasClass(targetEl, "submitStateChange")) {
            if (FIC_checkForm(e, yud.get("changeStateFormErrors")))
              submitChangeStateForm(targetEl, "changeStateForm");
          }
          else if (yud.hasClass(targetEl, "documentLink")) {
            yue.preventDefault(e);
            zenexity.capdemat.bong.document.getRequestDocument(targetEl);
          }
          else if (/tag-/.test(targetEl.className) && !yud.hasClass(targetEl, "documentLink")) {
            switchStatePanel(targetEl);
          }
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

      zcb.ecitizenContactPanel.show();

//      zcc.doAjaxCall(
//          action,
//          null,
//          function(o) {
//           zcb.ecitizenContactPanel.setBody(o.responseText);
//           zcb.ecitizenContactPanel.show();
//          });
    }

    yue.addListener(
        "ecitizenContact",
        "click",
        function(e) {
          var targetEl = yue.getTarget(e);
          if (targetEl.id === "ecitizenContactLink") {
            yue.preventDefault(e);
            getEcitizenContactPanel(targetEl);
          }
        });
//          else if (targetEl.id === "submitContactForm") {
//            if (FIC_checkForm(e, yud.get("contactFormErrors")))
//              submitContactForm("contactForm");
//          }
//          else if (targetEl.id === "discardContactForm") {
//            zcb.ecitizenContactPanel.hide();
//          }
//        });

    /* ecitizen means of contact default  */
//    yue.addListener(
//        "ecitizenContact",
//        "change",
//        function(e) {
//          var targetEl = yue.getTarget(e);
//
//          if (targetEl.name === "meansOfContact") {
//            var contactReciepientEl = yud.get("contactReciepient");
//
//            if (targetEl.value === "Email")
//              contactReciepientEl.value = yud.get("requesterEmail").value;
//            else if (targetEl.value === "Sms")
//              contactReciepientEl.value = yud.get("requesterMobilePhone").value;
//          }
//        });


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
              modifyPropertyForm(targetEl, true);
              yud.setStyle(formId.replace("_Form", ""), "background", "#aaffaa");
            }
            else {
              yud.get(formId + "Error").innerHTML = response.error_msg;
            }
          });
    }

    function modifyPropertyForm(targetEl, isSubmit) {
      var formEl = yud.getAncestorByTagName(targetEl, "form");
      var propertyValue;

      var ddEl = yud.getAncestorByTagName(targetEl, "dd");
      var wrapperPropertyValueEl = yud.getFirstChild(ddEl);

      if (isSubmit && yud.hasClass(ddEl, "capdematEnum")) {
        zct.each(
            yud.get(formEl.id.replace("_Form", "") + "_Field").options,
            function() {
              if (this.selected === true)
               propertyValue = this.text;
            });
        wrapperPropertyValueEl.innerHTML = propertyValue;
      }
      else if (isSubmit && yud.hasClass(ddEl, "address")) {
        var addressFields = yud.getChildren(wrapperPropertyValueEl);
        var newAddressFields = yus.query("fieldset input", formEl);
        zct.each(
            newAddressFields,
            function(i) {
              addressFields[i].innerHTML = this.value ;
            });
      }
      else if (isSubmit) {
        var elName = formEl.id.replace("_Form", "") + "_Field";
        propertyValue = yud.get(elName).value;
        wrapperPropertyValueEl.innerHTML = propertyValue;
      }
      yud.removeClass(wrapperPropertyValueEl, "invisible");

      new yuel(ddEl).removeChild(formEl);
      yud.removeClass(ddEl, "currentEditProperty");
    }

    function showEditProperty(targetEl) {
      var propertyValue;
      var wrapperPropertyValueEl = yud.getFirstChild(targetEl);

      if (yud.hasClass(targetEl, "address")) {
        var addressFields = yud.getChildren(wrapperPropertyValueEl);

        var jsonAddress = {
          "additionalDeliveryInformation": addressFields[0].innerHTML,
          "additionalGeographicalInformation": addressFields[1].innerHTML,
          "streetNumber": addressFields[2].innerHTML,
          "streetName": addressFields[3].innerHTML,
          "placeNameOrService": addressFields[4].innerHTML,
          "postalCode": addressFields[5].innerHTML,
          "city": addressFields[6].innerHTML,
          "countryName": addressFields[7].innerHTML
        }
        propertyValue = ylj.stringify(jsonAddress);

      }
      else if (yud.hasClass(targetEl, "capdematEnum")) {
        propertyValue = wrapperPropertyValueEl.className;
      }
      else {
        propertyValue = wrapperPropertyValueEl.innerHTML;
      }

      zcc.doAjaxCall(
          "/widget/?"
            + "id=" + zenexity.capdemat.bong.requestId
            + "&propertyType=" + targetEl.className
            + "&propertyName=" + targetEl.id
            + "&propertyValue=" + propertyValue,
          null,
          function(o) {
            yud.addClass(targetEl, "currentEditProperty");
            yud.addClass(yud.getFirstChild(targetEl), "invisible");
            targetEl.innerHTML += o.responseText;

            if (yud.hasClass(targetEl, "date")) {
              YAHOO.capdematBo.calendar.cal = new Array(1);
              yue.onDOMReady(YAHOO.capdematBo.calendar.init, {id: 0, label: targetEl.id + "_Field"} );
            }
          });
    }

    yue.addListener(
        "requestData",
        "click",
        function(e) {
            var targetEl = yue.getTarget(e);

            if (targetEl.tagName != "DD" && targetEl.tagName != "INPUT") {
              targetEl = yud.getAncestorByTagName(targetEl, "dd");
            }

            if (yud.hasClass(targetEl, "currentEditProperty"))   {
              return;
            }
            else if (yud.hasClass(targetEl, "string")
                || yud.hasClass(targetEl, "email")
                || yud.hasClass(targetEl, "address")
                || yud.hasClass(targetEl, "number")
                || yud.hasClass(targetEl, "date")
                || yud.hasClass(targetEl, "capdematEnum")
               ) {
              showEditProperty(targetEl);
            }
            else if (yud.hasClass(targetEl, "submit")) {
              var formEl = yud.getAncestorByTagName(targetEl, "form");
              if (FIC_checkForm(e, yud.get(formEl.id + "Errors")))
                submitEditProperty(targetEl, formEl.id);
            }
            else if (yud.hasClass(targetEl, "discard")) {
              modifyPropertyForm(targetEl, false);
            }
        });

    var d = zcc.debug;
    //var c = console;
    var initContact = function() {
      var url = ["/contactInformation/",zcb.requestId].join('');
      zcc.doAjaxCall(url,'',function(o){
        zcb.ecitizenContactPanel.setBody(o.responseText);
        var select = yud.get('meansOfContact');
        yue.on(select,'change',zcbr.Instruction.showPanels);
        zcbr.Instruction.showPanels(select[select.selectedIndex]);
        yue.on(yus.query('textarea[name=smsMessage]')[0],'keyup',function(e){
          zcc.limitArea(yue.getTarget(e),160,'smsNotifier');
        });
        zcbr.Instruction.changeType(yus.query('select.mails option')[0]);
      });
    };
    var toggleState = function(el,state) {
      var ls = yud.getChildrenBy(el,function(n){
        var nn = zct.nodeName;
        return(nn(n,'input')||nn(n,'select')||nn(n,'textarea'));
      });
      zct.each(ls,function(i,n){
        n.disabled = state;
      });
    }
    return {
      messageBox : undefined,
      dataTabView: undefined,
      formEvent: undefined,
      init: function() {
        //d.dir(window.opener);
        //d.print(self.location);
        init();
        initContact();

        zcbr.Instruction.formEvent = new zcc.Event(zcbr.Instruction,zcbr.Instruction.getHandler);
        yue.on('contactForm','click',zcbr.Instruction.formEvent.dispatch,zcbr.Instruction.formEvent,true);
        yue.on('requestForms','change',zcbr.Instruction.changeType);
      },
      notify : function(o) {
        var json = ylj.parse(o.responseText);
        zcc.Notifier.processMessage('success',json.success_msg,'contactMsg');
      },
      previewRequestForm : function(e) {
        zcbr.Instruction.prepareLink()
      },
      getHandler : function(e) {
        var target = yue.getTarget(e);
        return target.id.split('_')[0];
      },
      changeType : function(e) {
        if(!!e) {
          var target = (zct.nodeName(e,'option'))?e:yue.getTarget(e);
          var link = yud.get('previewRequestForm');
          if(target.value > -1)zct.style(link,{display:'inline'});
          else zct.style(link,{display:'none'});
          zcbr.Instruction.prepareLink();
        } else {
          zct.style(yud.get('previewError'),{display:'inline'});
          zct.style(yus.query('fieldset#emailButtons')[0],{display:'none'});
          zct.style(yus.query('fieldset#defaultButtons')[0],{display:'block'});
        }

      },
      getByGroup : function(group) {
        var result = yud.getElementsByClassName(group,undefined,'contactForm');
        return zct.grep(result,function(n){return (!n.disabled);})[0];
      },
      prepareLink: function() {
        var link = yud.get('previewRequestForm');
        var url = zenexity.capdemat.bong.baseUrl;
        var id = zct.val(yud.get('requestForms'));
        var message = encodeURIComponent(zct.val(zcbr.Instruction.messageBox));
        link.href = [url,'/preview/?fid=',id,'&rid=',zcb.requestId,'&msg=',message].join('');
      },
      prepareForm : function() {
        form = yud.get('contactForm');
        elements = zct.grep(yus.query('*',form),function(n){
          var nn = zct.nodeName;
          return((nn(n,'input')||nn(n,'select')||nn(n,'textarea'))&&(!n.disabled));
        });

        //TODO make this part of script more flexible
        var message = yus.query('input[name=message]',form,true);
        var recipient = yus.query('input[name=recipient]',form,true);
        var meansOfContact = yus.query('input[name=meansOfContact]',form,true);

        zct.each(elements,function(i,n){
          var el = new yu.Element(n);
          if(el.hasClass('message')) message.value = zct.val(n);
          if(el.hasClass('recipient')) recipient.value = zct.val(n);
          if(el.hasClass('means-of-contact')) meansOfContact.value = zct.val(n);
        });
      },
      discardChanges: function(e) {
        zcb.ecitizenContactPanel.hide();
      },
      showPanels : function(e) {
        if(!e) return;

        var target = (zct.nodeName(e,'option'))?e:yue.getTarget(e);
        var value = zct.val(target);
        var container = yud.getAncestorByTagName(target,'form');
        var rules = [];
        zct.each(zcbr.Instruction.showRules,function(k,v){
          var regex = new RegExp(['^',k,'$'].join(''),'i');
          if(regex.test(value))rules = zct.merge(rules,v);
        });
        var fieldsets = yus.query('fieldset',container);
        zct.each(fieldsets,function(i,el){
          if(zct.inArray(el.id,rules)>-1){
            zct.style(el,{display:'block'});
            toggleState(el,undefined);
          } else {
            zct.style(el,{display:'none'});
            toggleState(el,'disabled');
          }
        });
        zct.each(yus.query('#contactForm input[type=hidden]'),function(i,el){
          if(/^(message|recipient|meansOfContact)$/i.test(el.name))el.value = "";
        });
        zcbr.Instruction.messageBox = zcbr.Instruction.getByGroup('message');
      },
      validate : function(form) {
        var container = yud.get('contactFormErrors');
        if(zct.isFunction(FIC_checkForm))
          return FIC_checkForm(form,container);
        return true;
      },
      showRules : {
        'Sms' : ['meansOfContactForm','mobilePhoneForm','smsMessageForm','smsButtons'],
        'OfficePhone':['meansOfContactForm','officePhoneForm','messageForm','defaultButtons'],
        'MobilePhone':['meansOfContactForm','mobilePhoneForm','messageForm','defaultButtons'],
        'HomePhone':['meansOfContactForm','homePhoneForm','messageForm','defaultButtons'],
        'Email':['meansOfContactForm','mailForm','messageForm','mailTemplateForm','emailButtons'],
        'Mail':['meansOfContactForm','messageForm','mailTemplateForm','defaultButtons'],
        '.*Office':['meansOfContactForm','messageForm','mailTemplateForm','defaultButtons']
      }
    };

  }();

  zct.each(['sendSms','sendEmail','trace'],function(i,name){
    zcbr.Instruction[name] = function(e){
      zcbr.Instruction.prepareForm(e);
      form = yud.get('contactForm');
      form.action = [zcb.baseUrl,'/',name].join('');
      zct.text(yud.get('contactFormErrors'),'');
      
      if(zcbr.Instruction.validate(form)) {
        zcc.doAjaxFormSubmitCall(form.id,[],zcbr.Instruction.notify);
      }
    };
  });

  YAHOO.util.Event.onDOMReady(zcbr.Instruction.init);


}());
