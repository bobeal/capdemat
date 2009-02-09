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
  var ylj = YAHOO.lang.JSON;
  var yl = YAHOO.lang;
  var yw = YAHOO.widget;
  var yu = YAHOO.util;

  zcbr.Instruction = function() {

    function init() {
      /* tabview */
      zcbr.Instruction.dataTabView = new yw.TabView('requestData');

      /* panels */
      zcb.instructionStatePanel = new yw.Panel(
        'instructionStatePanel',
        { width: '135%',
          visible: false,
          constraintoviewport: true, draggable: false,
          underlay: 'none', close: false
        });
      zcb.instructionStatePanel.render();

      zcb.requestDocumentPanel = new yw.Panel(
        'requestDocumentPanel',
        { width: '800px', y: 120,
          visible: false,
          constraintoviewport: false, draggable: true,
          underlay: 'shadow', close: true
        });
      zcb.requestDocumentPanel.render();

      zcb.ecitizenContactPanel = new yw.Panel(
        'ecitizenContactPanel',
        { width: '650px',
          visible: false,
          constraintoviewport: false, draggable: true,
          underlay: 'shadow', close: true
        });
      zcb.ecitizenContactPanel.render();

    }

    /*
     * Request Instruction Worflow managment
     * ------------------------------------------------------------------------------------------ */

    function submitChangeStateForm(targetEl , formId) {
      // bad strategy to refresh tag state ...
      var nodes = yus.query('input[name=stateType]', formId);
      var oldTagStateEl;
      if (nodes[0].getAttribute('value') != 'documentState')
        oldTagStateEl = yud.get(nodes[0].getAttribute('value'));
      else {
        nodes = yus.query('input[name=id]', formId);
        oldTagStateEl = yud.get( 'documentState_' + nodes[0].getAttribute('value'));
      }

      nodes = yus.query('input:checked', formId);
      var newTagStateEl = yud.getNextSibling(nodes[0]);

      zct.doAjaxFormSubmitCall(
          formId,
          null,
          function(o) {
            var response = ylj.parse(o.responseText);
            if (response.status === 'ok') {
              oldTagStateEl.className = newTagStateEl.className;
              oldTagStateEl.innerHTML = newTagStateEl.innerHTML;

              zcb.instructionStatePanel.hide();
            } else {
              zct.Notifier.processMessage('modelError',response.success_msg);
            }
          });
    }

    function getStateTransitions(stateCssClass, stateType) {
      var id;
      if (stateType.indexOf('documentState_') != -1) {
        id = stateType.replace('documentState_', '');
        stateType = 'documentState';
      } else {
        id = zcb.requestId
      }

      zct.doAjaxCall(
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
          'border-color',
          yud.getStyle(targetEl, 'background-color'));

      zcb.instructionStatePanel.cfg.setProperty('context', [targetEl,'tr','br'])

      if (! zcb.instructionStatePanel.cfg.getProperty('visible'))
        getStateTransitions(targetEl.className, targetEl.id);
      else
        zcb.instructionStatePanel.hide();
    }

    yue.addListener(
        'narrow',
        'click',
        function (e) {
          var targetEl = yue.getTarget(e);

          if (yud.hasClass(targetEl, 'cancelStateChange')) {
            zcb.instructionStatePanel.hide();
          }
          else if (yud.hasClass(targetEl, 'submitStateChange')) {
            if (FIC_checkForm(e, yud.get('changeStateFormErrors')))
              submitChangeStateForm(targetEl, 'changeStateForm');
          }
          else if (yud.hasClass(targetEl, 'documentLink')) {
            yue.preventDefault(e);
            zenexity.capdemat.bong.document.getRequestDocument(targetEl);
          }
          else if (/tag-/.test(targetEl.className) && !yud.hasClass(targetEl, 'documentLink')) {
            switchStatePanel(targetEl);
          }
        });

    /*
     * request data inline edition managment
     * ------------------------------------------------------------------------------------------ */
    
    var modifyField = function (targetEl, isSubmit) {
      var formEl = yud.getAncestorByTagName(targetEl, 'form');
      var propertyValue;

      var ddEl = yud.getAncestorByTagName(targetEl, 'dd');
      var propertyWrapperEl = yud.getFirstChild(ddEl);

      if (isSubmit && yud.hasClass(ddEl, 'validate-capdematEnum')) {
        zct.each (yud.get(formEl.id.replace('_Form', '') + '_Field').options, function() {
            if (this.selected === true)
              propertyValue = this;
        });
        propertyWrapperEl.innerHTML = propertyValue.text;
        // FIXME - normalize propertyValue class like class="value<MY_VAL> i18n-<MY_I18n>)"
        var classNameArray = propertyWrapperEl.className.split(' ');
        if (classNameArray.length > 1)
          classNameArray[0] = propertyValue.value.split('_')[1];
        else
          classNameArray.unshift(propertyValue.value.split('_')[1]);
        propertyWrapperEl.className = classNameArray.join(' ');   
      }
      else if (isSubmit && yud.hasClass(ddEl, 'validate-address')) {
        var addressFields = yud.getChildren(propertyWrapperEl);
        var newAddressFields = yus.query('fieldset input', formEl);
        zct.each (newAddressFields, function(i) {
            addressFields[i].innerHTML = this.value ;
        });
      }
      else if (isSubmit && yud.hasClass(ddEl, 'validate-boolean')) {
        var checkedEl = yus.query("input:checked", formEl, true);
        propertyWrapperEl.innerHTML = yl.trim(yud.getNextSibling(checkedEl).innerHTML);
        propertyWrapperEl.className = 'value-' + checkedEl.value; 
      }
      else if (isSubmit) {
        var elName = formEl.id.replace('_Form', '') + '_Field';
        propertyValue = yud.get(elName).value;
        propertyWrapperEl.innerHTML = propertyValue;
      }
      yud.removeClass(propertyWrapperEl, 'invisible');

      new yuel(ddEl).removeChild(formEl);
      yud.removeClass(ddEl, 'current-editField');
      
       // FIXME - poor solution to manage condition chaining
      zcb.Condition.reInit();
    }
    
    return { 
      inlineEditEvent : undefined,
      
      init : function() { 
          init();
          zcbr.Instruction.inlineEditEvent = new zct.Event(zcbr.Instruction, zcbr.Instruction.getHandler);
          yue.on('requestData','click', 
              zcbr.Instruction.inlineEditEvent.dispatch, zcbr.Instruction.inlineEditEvent, true
          );
      },
      
      // TODO - refactor dispatch policy
      getTarget : function (e) {
          var targetEl = yue.getTarget(e);
          if (targetEl.tagName != 'DD' && targetEl.tagName != 'INPUT'  && targetEl.tagName != 'A')
            targetEl = yud.getAncestorByTagName(targetEl, 'dd');
          return targetEl;
      },
      getHandler : function(e) {
        var targetEl = zcbr.Instruction.getTarget(e);
        if (yl.isNull(targetEl) || yud.hasClass(targetEl, 'current-editField'))
          return undefined;
        else if (targetEl.tagName === 'A')
          return targetEl.className;
        else if (targetEl.tagName === 'DD')
          return targetEl.className.split(' ')[0].split('-')[1];
        else
          return targetEl.className.split(' ')[0];
      },
      
      editField : function(e) {
          var targetEl = zcbr.Instruction.getTarget(e);
          var propertyValue;
          var propertyWrapperEl = yud.getFirstChild(targetEl);
          var jsonPropertyType = {}
          zct.each(targetEl.className.split(' '), function(i) {
            var entry = this.split('-');
            jsonPropertyType[entry[0]] = entry[1];
          });
          
          if (jsonPropertyType['validate'] === 'address') {
            var jsonAddress = {};     
            zct.each(yud.getChildren(propertyWrapperEl), function(i) {
                jsonAddress[this.className] = this.innerHTML;
            });
            propertyValue = ylj.stringify(jsonAddress);
          }
          else if (jsonPropertyType['validate'] ===  'capdematEnum') {
            propertyValue = propertyWrapperEl.className;
          }
          else if (jsonPropertyType['validate'] ===  'boolean') {
            propertyValue = propertyWrapperEl.className.split('-')[1];
          }
          else {
            propertyValue = propertyWrapperEl.innerHTML;
          }

          zct.doAjaxCall(
            '/widget/?id=' + zenexity.capdemat.bong.requestId
            + '&propertyType=' + ylj.stringify(jsonPropertyType)
            + '&propertyName=' + targetEl.id
            + '&propertyValue=' + propertyValue
            + '&propertyRegex=' + (yl.isUndefined(targetEl.attributes.regex) ? '' : targetEl.attributes.regex.value),
            null, 
            function(o) {
              yud.addClass(targetEl, 'current-editField');
              yud.addClass(yud.getFirstChild(targetEl), 'invisible');
              targetEl.innerHTML += o.responseText;

              if (yud.hasClass(targetEl, 'validate-date')) {
                YAHOO.capdematBo.calendar.cal = new Array(1);
                yue.onDOMReady(YAHOO.capdematBo.calendar.init, {id: 0, label: targetEl.id + '_Field'} );
              }
          });
      },
      
      submitField : function (e) {
          var targetEl = zcbr.Instruction.getTarget(e);
          var formEl = yud.getAncestorByTagName(targetEl, 'form');
          
          if (!FIC_checkForm(e, yud.get(formEl.id + 'Errors')))
            return;
          
          zct.doAjaxFormSubmitCall(formEl.id, null, function(o) {
              var response = ylj.parse(o.responseText);
              if (response.status === 'ok') {
                zcb.Condition.run(e);
                modifyField(targetEl, true);
                yud.setStyle(formEl.id.replace('_Form', ''), 'background', '#aaffaa');
              }
              else {
                yud.get(formId + 'Error').innerHTML = response.error_msg;
              }
          });
      },
      
      revertField : function (e) {
          modifyField(zcbr.Instruction.getTarget(e), false);
      },
      
      addListItem : function (e) {    
          var idRegex = /(\w+)_(\w+)\[(\d+)\]/i.exec(yue.getTarget(e).id);
          zct.doAjaxCall(
            '/modifyList/?requestId=' + zcb.requestId + '&listAction=' + yue.getTarget(e).id
            , null,
            function(o) { zct.html(yud.get('widget-' + idRegex[2]), o.responseText); }
          ); 
      },
      
      deleteListItem : function (e) {
          var idRegex = /(\w+)_(\w+)\[(\d+)\]/i.exec(yue.getTarget(e).id);
          zct.doAjaxCall(
            '/modifyList/?requestId=' + zcb.requestId + '&listAction=' + yue.getTarget(e).id
            , null,
            function(o) { zct.html(yud.get('widget-' + idRegex[2]), o.responseText); }
          );
      }
    };
    
  }();
  
  YAHOO.util.Event.onDOMReady(zcbr.Instruction.init);
  
  /*
   * ecitizen contact management
   * ------------------------------------------------------------------------------------------ */
  
  zcbr.Contact = function() {

    function submitContactForm(formId) {
      zct.doAjaxFormSubmitCall (formId,null,
        function(o) {
          zcb.ecitizenContactPanel.hide();
        });
    }

    function getEcitizenContactPanel(targetEl) {
      // hacks for ie6
      var action = targetEl.pathname;
      if (action.indexOf('/') != 0)
        action = '/' + action;

      zcb.ecitizenContactPanel.show();
    }

    yue.addListener(
        'ecitizenContact',
        'click',
        function(e) {
          var targetEl = yue.getTarget(e);
          if (targetEl.id === 'ecitizenContactLink') {
            yue.preventDefault(e);
            getEcitizenContactPanel(targetEl);
          }
        });
    
    var initContact = function() {
      var url = ['/contactInformation/',zcb.requestId].join('');
      zct.doAjaxCall(url,'',function(o){
        zcb.ecitizenContactPanel.setBody(o.responseText);
        var select = yud.get('meansOfContact');
        yue.on(select,'change',zcbr.Contact.showPanels);
        zcbr.Contact.showPanels(select[select.selectedIndex]);
        yue.on(yus.query('textarea[name=smsMessage]')[0],'keyup',function(e){
          zct.limitArea(yue.getTarget(e),130,'smsNotifier');
        });
        zcbr.Contact.changeType(yus.query('select.mails option')[0]);
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
        initContact();
        zcbr.Contact.formEvent = new zct.Event(zcbr.Contact,zcbr.Contact.getHandler);
        yue.on('contactForm','click',zcbr.Contact.formEvent.dispatch,zcbr.Contact.formEvent,true);
        yue.on('requestForms','change',zcbr.Contact.changeType);
      },
      notify : function(o) {
        var json = ylj.parse(o.responseText);
        zct.Notifier.processMessage('success',json.success_msg,'contactMsg');
      },
      previewRequestForm : function(e) {
        zcbr.Contact.prepareLink()
      },
      getHandler : function(e) {
        var target = yue.getTarget(e);
        return target.id.split('_')[0];
      },
      changeType : function(e) {
        if(!!e) {
          var target = (zct.nodeName(e,'option'))?e:yue.getTarget(e);
          var link = yud.get('previewRequestForm');
          var linkPdf = yud.get('previewRequestFormPdf');
          if(target.value > -1) {
            zct.style(link,{display:'inline'});
            zct.style(linkPdf,{display:'inline'});
          } else {
            zct.style(link,{display:'none'});
            zct.style(linkPdf,{display:'none'});
          } 
          zcbr.Contact.prepareLink();
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
        var linkPdf = yud.get('previewRequestFormPdf');
        var url = zenexity.capdemat.baseUrl;
        var id = zct.val(yud.get('requestForms'));
        var message = encodeURIComponent(zct.val(zcbr.Contact.messageBox));
        link.href = [url,'/preview/?type=html&fid=',id,'&rid=',zcb.requestId,'&msg=',message].join('');
        linkPdf.href = [url,'/preview/?type=pdf&fid=',id,'&rid=',zcb.requestId,'&msg=',message].join('');
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
        zct.each(zcbr.Contact.showRules,function(k,v){
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
        zcbr.Contact.messageBox = zcbr.Contact.getByGroup('message');
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
    zcbr.Contact[name] = function(e){
      zcbr.Contact.prepareForm(e);
      form = yud.get('contactForm');
      form.action = [zenexity.capdemat.baseUrl,'/',name].join('');
      zct.text(yud.get('contactFormErrors'),'');
      
      if(zcbr.Contact.validate(form)) {
        zct.doAjaxFormSubmitCall(form.id,[],zcbr.Contact.notify);
      }
    };
  });

  YAHOO.util.Event.onDOMReady(zcbr.Contact.init);
  
  
  /*
   * request Instruction Information
   * ------------------------------------------------------------------------------------------ */
  
  zcbr.Information = function() {

    return {
      clickEvent : undefined,
      
      init: function() {
          var infoTabView = new yw.TabView();
          infoTabView.addTab( new yw.Tab({
              label: 'Historique', dataSrc: zenexity.capdemat.baseUrl + '/requestActions/' + zcb.requestId,
              cacheData: true, active: true }));
          infoTabView.addTab( new yw.Tab({
              label: 'Commentaires', dataSrc: zenexity.capdemat.baseUrl + '/requestNotes/' + zcb.requestId
              }));
          infoTabView.addTab( new yw.Tab({
              label: 'Compte', dataSrc: zenexity.capdemat.baseUrl + '/homeFolder',
              cacheData: true }));
          infoTabView.addTab( new yw.Tab({
              label: 'Demandes', dataSrc: zenexity.capdemat.baseUrl + '/homeFolderRequests/' + zcb.requestId,
              cacheData: true }));
          infoTabView.addTab( new yw.Tab({
              label: 'Aide', dataSrc: zenexity.capdemat.baseUrl + '/help',
              cacheData: true }));

          infoTabView.appendTo('requestInformation');
          
          // TODO - disable 'enter' key event in 'note' input
//          yue.onAvailable('note', function() {
//            var noteKl = new yu.KeyListener ('note', {key: 13}, null);
//            noteKl.disable();
//          });
          
          zcbr.Information.clickEvent = new zct.Event(zcbr.Information, zcbr.Information.getHandler);
          yue.on('requestInformation','click', zcbr.Information.clickEvent.dispatch,
            zcbr.Information.clickEvent, true
          );
      },
      
      getHandler : function(e) {
          var target = yue.getTarget(e);
          return target.id;
      },
      
      submitNote : function(e) {
          var formEl = yud.getAncestorByTagName(yue.getTarget(e), 'form');
          
          zct.doAjaxFormSubmitCall(formEl.id, null, function(o) {
              var json = ylj.parse(o.responseText);
              if (json.status === 'ok') {
                zcbr.Information.refreshNotes(yud.getAncestorBy(formEl), json.success_msg);
              }
              else {
                //
                // zct.Notifier.processMessage('error',json.error_msg,'noteMsg');
              }
          });
      },
      
      refreshNotes : function(el, msg) {
          zct.doAjaxCall('/requestNotes/' + zcb.requestId, null, function(o) {
              zct.html(el, o.responseText);     
              zct.Notifier.processMessage('success',msg,'noteMsg');      
          });
      }
    };

  }();
  YAHOO.util.Event.onDOMReady(zcbr.Information.init);

}()

);
