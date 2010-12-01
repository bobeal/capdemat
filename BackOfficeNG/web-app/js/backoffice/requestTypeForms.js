/**
 * @description This file contains requestType configuration depended classes
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zca = zenexity.capdemat.aspect;
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcv = zenexity.capdemat.Validation;
  var zcb = zenexity.capdemat.bong;
  var zcbrt = zcb.requesttype;

  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcb.Editor.options.toolbar.buttons.push({
    group: 'textstyle', label: 'Variables',
    buttons: [
      { type: 'select', label: '...', value: 'insertvars', disabled: false,
        menu: [
          { text: '...', value:'0', checked: true },
          { text: '(TS) Identifiant', value:'#{RQ_ID}' },
          { text: '(TS) Label', value:'#{RQ_TP_LABEL}' },
          { text: '(TS) Date de création', value:'#{RQ_CDATE}' },
          { text: '(TS) Date de validation', value:'#{RQ_DVAL}' },
          { text: '(TS) Observations', value:'#{RQ_OBSERV}' },
          { text: '(TS) Catégorie', value: '#{RQ_CAT}' },
          { text: '(TS) Email  de la catégorie', value: '#{RQ_CAT_EMAIL}' },
          { text: '(CP) Identifiant', value:'#{HF_ID}' },
          { text: '(DM) Prénom', value:'#{RR_FNAME}' },
          { text: '(DM) Nom', value:'#{RR_LNAME}' },
          { text: '(DM) Civilité', value:'#{RR_TITLE}' },
          { text: '(DM) Login', value:'#{RR_LOGIN}' },
          { text: '(DM) Question', value:'#{RR_QUESTION}' },
          { text: '(DM) Réponse', value:'#{RR_ANSWER}' },
          { text: '(SU) Prénom', value:'#{SU_FNAME}' },
          { text: '(SU) Nom', value:'#{SU_LNAME}' },
          { text: '(SU) Civilité', value:'#{SU_TITLE}' },
          { text: '(AR) Nom de l\'agent', value: '#{LAST_AGENT_NAME}' }        ]
      }]
  });

  zcbrt.Manager = function() {
    var initPanel = function() {
      zcbrt.Manager.panel = new YAHOO.widget.Panel("templatePanel", {
        width:"620px",
        fixedcenter : "contained",
        modal: true,
        underlay: 'none',
        visible:false
      });
      zcbrt.Manager.panel.beforeShowEvent.subscribe(function(ev){
        zct.style("templateBody",{display:'block'});
        zcbrt.Manager.panel.center();
      });
      zcbrt.Manager.panel.beforeHideEvent.subscribe(function(ev){
        zct.style("templateBody",{display:'none'});
      });
      zcbrt.Manager.panel.render();
    };
    return {
      editor : undefined,
      panel : undefined,
      editEl: undefined,
      tabView: undefined,
      init : function() {
        //initTabs();
        initPanel();
        zca.advise("save", new zca.Advice("before", zcbrt.Manager.validate), zcb.Editor);
        zca.advise("notify", new zca.Advice("before", zcbrt.Manager.update), zcb.Editor);
        zcbrt.Manager.editor = zcb.Editor.init("template", null, "workArea_Tab1Notifier");
        zcbrt.Manager.editor.on('afterRender',function(ev){
          if(zcb.Editor.options.toolbar.buttons.length > 0) {
            var button = zcb.Editor.options.toolbar.buttons[zcb.Editor.options.toolbar.buttons.length - 1].buttons[0];
            var select = yus.query('select',button.container)[0];
            yue.on(select,'change',function(ev){
              if(zct.val(select) != '0') {
                zcbrt.Manager.editor.execCommand('inserthtml', zct.val(select));
                zct.val(select,'0');
              }
            })
          }
        });
      },
      edit : function() {
        if(zcbrt.Manager.panel.cfg.getProperty('visible') != true) {
          zcbrt.Manager.editEl = this;
          zcbrt.Manager.editor.cleanHTML();
          zcbrt.Manager.editor.setEditorHTML(this.innerHTML);
          zcbrt.Manager.panel.show();
        }
      },
      validate : function(e) {
        zcbrt.Manager.editor.saveHTML();
        if (yl.trim(zct.stripTags(zcbrt.Manager.editor.getEditorHTML())).length == 0) {
          zct.Notifier.processMessage("unexpectedError","Editor value can't be empty !");
          yue.stopEvent(e);
        }
      },
      update : function(e) {
        zcbrt.Manager.editEl.innerHTML = zcbrt.Manager.editor.getEditorHTML();
        zcbrt.Manager.panel.hide();
      },
      emptyHref : function() {
        return 'javascript:;';
      }
    }
  }();

  zcbrt.Forms = function() {
    var initPanels = function() {
      //Are you sure that you want to perform this action ?
      var content = {
        head:'Attention !',
        body: 'Confirmez-vous la suppression du courrier type ?'
      }
      zcbrt.Forms.confirmationDialog = new zct.ConfirmationDialog(
        content,zcbrt.Forms.deleteForm);
    };
    var initButtons = function() {
    };
    var initPersLink = function(scope) {
      var links = yu.Dom.getChildrenBy(scope,function(n){
        return (zct.nodeName(n,'a') && n.id == 'a-personalize');
      });
    };
    var initTabs = function() {
      zcbrt.Manager.tabView = new YAHOO.widget.TabView('requestTypeForms');
      zcbrt.Manager.tabView.set('activeIndex', 0);
    };
    var initLinks = function() {
      var showLink = new yu.Element('linkShowDatasheet');
      showLink.on('click',function(){
        zcbrt.Forms.loadEditForm(document.getElementById('insertInList'));
      });
    };
    return {
      confirmationDialog : undefined,
      containers : [],
      init : function() {
        zcbrt.Manager.init();
        initButtons();
        initPanels();
        initLinks();
        initTabs();
        zcbrt.Forms.reloadList();
        
      },
      loadEditForm : function(container) {
        if(!!zcbrt.Forms.containers[container.id]) return;
        var url = ['/form/',container.id.split('_')[1]].join('');
        zcbrt.Forms.containers[container.id] = container;
        zct.doAjaxCall(url,[],function(o){
          container.innerHTML = [container.innerHTML,o.responseText].join('');
        });
      },
      spiritUpWorkTab : function(target) {
        var eform = yu.Dom.get("templateForm");
        var tform = yu.Dom.getAncestorByTagName(target,'form');
        var params = {
          typeId : zcbrt.currentId,
          formId : tform.requestFormId.value,
          file : yu.Dom.getAncestorByTagName(target,'form').templateName.value //currentTemplateName.value
        };
        var url = ['/loadMailTemplate/?', zct.param(params)].join('');
        zct.doAjaxCall(url,[],function(o){
          var content = o.responseText
            .replace(/\n/g,'\uffff')
            //.replace(/.*<body[^>]*>(.*)<\/body>.*/gi,'$1') // We know it's bad to load header content in DOM
            .replace(/\uffff/g,'\n');
          
          var close = [
            '<div id="templatePanel" class="template-panel" style="display:none">',
            '<a id="closeWorkTab" href="javascript:;">','Retour aux courriers types',
            '</a>','</div>'
          ].join('');
          
          var tname = yus.query('input[name=label]',tform,!0).value;
          var label = ['Personnalisation de <strong>',tname,'</strong> <span class="close">X</span>'].join('');
          var newTab = new YAHOO.widget.Tab({
            label: label,
            active: true,
            content: ['<div id="workArea_Tab1Notifier"></div><div id="workArea_Tab1" class="editable-work-area">',content,close,'</div>'].join('')
          });
          
          zcbrt.Manager.tabView.addTab(newTab);
          zcbrt.Manager.tabView.get('tabs')[0].set('disabled', true);
          var templatePanel = new yu.Element('templatePanel');
          templatePanel.appendTo(yu.Dom.get('workArea_Tab1').parentNode);
          zct.style(templatePanel.get('element'),{'display':'block'});
          
          var divs = yus.query('div#workArea_Tab1 div');
          var editables = zct.grep(divs,function(n){
            return (/editable*/i.test(n.id));
          });
          zct.each(editables,function(i){
            yue.addListener(this,'click',zcbrt.Manager.edit);
          });
          yue.on(newTab.getElementsByClassName('close')[0], 'click', zcbrt.Forms.closeWorkTab,newTab);
          yue.on(yu.Dom.get('closeWorkTab'),'click',zcbrt.Forms.closeWorkTab,newTab);
          eform.requestTypeId.value = zcbrt.currentId;
          eform.requestFormId.value = tform.requestFormId.value;
        });
      },
      closeWorkTab : function(e,t) {
        YAHOO.util.Event.preventDefault(e);
        zcbrt.Manager.tabView.removeTab(t);
        zcbrt.Manager.tabView.get('tabs')[0].set('disabled', false);
        zcbrt.Manager.tabView.set('activeIndex', 0);
      },
      modifyForm : function(target) {
        var form = yu.Dom.getAncestorByTagName(target,'form');
        var hidden = yus.query('input[name=requestTypeId]',form)[0];
        hidden.value = zcbrt.currentId;
        if(zcbrt.Forms.validateForm(target,form)) {
          zct.doAjaxFormSubmitCall(form.getAttribute("id"),[],function(o){
            var li = new yu.Element(form.parentNode.parentNode);
            var json = YAHOO.lang.JSON.parse(o.responseText);
            
            zct.Notifier.processMessage('success',json.success_msg);
            zcbrt.Forms.detachContainer(target);
            li.removeChild(form.parentNode);
            zcbrt.Forms.reloadList(json.id);
          });
        }
      },
      validateForm : function(target,form) {
        var container = yus.query('div.error',form,true);
        return zcv.check(target,container);
      },
      deleteForm : function(e) {
        var li = yu.Dom.getAncestorByTagName(zcbrt.Forms.confirmationDialog.showTarget ,'li');
        var id = li.id.split('_')[1];
        if(yl.isNumber(parseInt(id))) {
          zct.doAjaxDeleteCall('/form/',zct.param({id:id}),function(o){
            var cn = new yu.Element(li.parentNode);
            var json = YAHOO.lang.JSON.parse(o.responseText);
            zct.Notifier.processMessage('success',json.success_msg);
            cn.removeChild(li);
          });
        }
      },
      reloadList : function(id) {
        var url = ["/formList/",(zcbrt.currentId||0)].join('');
        var formsEl = yus.query('div#requestFormList')[0];
        zct.doAjaxCall(url,[],function(o){
          formsEl.innerHTML = o.responseText;
          var container = yu.Dom.get('formsConfiguration');
          yue.purgeElement(container,false);
          yue.on(container,'click',zcbrt.Forms.dispatchEvent);
          
          var el = yu.Dom.get(['formItem_',(id||0)].join(''));
          if(!!el)  zcbrt.Forms.loadEditForm(el);
          
        });
      },
      dispatchEvent : function(e) {
        var target = yue.getTarget(e);
        var elId = target.id.split('_')[0];
        var h = zcbrt.Forms.getEventHandler(elId);
        if(!!zcbrt.Forms.handlers[elId]) h.call(target,e);
      },
      getEventHandler : function(key) {
        var handler = zcbrt.Forms.handlers[key];
        if(!!handler && zct.isFunction(handler)) return handler;
        else return zcbrt.Forms.handlers['default'];
      },
      hideEditForm : function(target) {
        var div = yu.Dom.getAncestorByTagName(target,'form').parentNode;
        var button = yus.query('span#button-cancel',div)[0];
        var el = new yu.Element(div.parentNode);
        zcbrt.Forms.detachContainer(target);
        el.removeChild(div);
      },
      detachContainer : function(actor) {
        var o = yu.Dom.getAncestorByTagName(actor,'form').parentNode.parentNode;
        delete zcbrt.Forms.containers[o.getAttribute('id')];
      },
      handlers : {
        'save': function(e){zcbrt.Forms.modifyForm(yue.getTarget(e));},
        'cancel': function(e){zcbrt.Forms.hideEditForm(yue.getTarget(e));},
        'personalize' :function(e){zcbrt.Forms.spiritUpWorkTab(yue.getTarget(e));},
        'editItem' : function(e){zcbrt.Forms.loadEditForm(yu.Dom.getAncestorByTagName(this,'li'));},
        'deleteItem' : function(e){zcbrt.Forms.confirmationDialog.show(e);},
        'default': function(){return false;}
      }
    };
  }();
  
  yue.onDOMReady(zcbrt.Forms.init);
}());
