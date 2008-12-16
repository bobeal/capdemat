/**
 * @description This file contains requestType configuration depended classes
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrt = zenexity.capdemat.bong.request.templates;
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  var zcbrp = zenexity.capdemat.bong.requesttype;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  
  zcbrp.Forms = function() {
    var initPanels = function() {
      //Are you sure that you want to perform this action ?
      var content = {
        head:'Attention !',
        body: 'Confirmez la suppression ?'}
      zcbrp.Forms.confirmationDialog = new zct.ConfirmationDialog(
        content,zcbrp.Forms.deleteForm);
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
        zcbrp.Forms.loadEditForm(document.getElementById('insertInList'));
      });
    };
    return {
      confirmationDialog : undefined,
      containers : [],
      init : function() {
        initButtons();
        initPanels();
        initLinks();
        initTabs();
        zcbrp.Forms.reloadList();
        
      },
      loadEditForm : function(container) {
        if(!!zcbrp.Forms.containers[container.id]) return;
        var url = ['/form/',container.id.split('_')[1]].join('');
        zcbrp.Forms.containers[container.id] = container;
        zct.doAjaxCall(url,[],function(o){
          container.innerHTML = [container.innerHTML,o.responseText].join('');
        });
      },
      spiritUpWorkTab : function(target) {
        var eform = yu.Dom.get('editorForm');
        var tform = yu.Dom.getAncestorByTagName(target,'form');
        var params = {
          typeId : zcbrp.currentId,
          formId : tform.requestFormId.value,
          file : yu.Dom.getAncestorByTagName(target,'form').templateName.value //currentTemplateName.value
        };
        var url = ['/loadMailTemplate/?', zct.param(params)].join('');
        zct.doAjaxCall(url,[],function(o){
          var content = o.responseText
            .replace(/\n/g,'\uffff')
            .replace(/.*<body>(.*)<\/body>.*/gi,'$1')
            .replace(/\uffff/g,'\n');
          
          var tname = yus.query('input[name=label]',tform,!0).value;
          var label = ['Personnalisation de <strong>',tname,'</strong> <span class="close">X</span>'].join('');
          var newTab = new YAHOO.widget.Tab({
            label: label,
            active: true,
            content: ['<div id="workArea_Tab1" class="editable-work-area">',content,'</div>'].join('')
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
          yue.on(newTab.getElementsByClassName('close')[0], 'click', zcbrp.Forms.closeWorkTab,newTab);
          yue.on(yu.Dom.get('closeWorkTab'),'click',zcbrp.Forms.closeWorkTab,newTab);
          eform.requestTypeId.value = zcbrp.currentId;
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
        hidden.value = zcbrp.currentId;
        if(zcbrp.Forms.validateForm(target,form)) {
          zct.doAjaxFormSubmitCall(form.getAttribute("id"),[],function(o){
            var li = new yu.Element(form.parentNode.parentNode);
            var json = YAHOO.lang.JSON.parse(o.responseText);
            
            zct.Notifier.processMessage('success',json.success_msg);
            zcbrp.Forms.detachContainer(target);
            li.removeChild(form.parentNode);
            zcbrp.Forms.reloadList(json.id);
          });
        }
      },
      validateForm : function(target,form) {
        var container = yus.query('div.error',form,true);
        if(zct.isFunction(FIC_checkForm)) 
          return FIC_checkForm(target,container);
        return true;
      },
      deleteForm : function(e) {
        var li = yu.Dom.getAncestorByTagName(zcbrp.Forms.confirmationDialog.showTarget ,'li');
        var id = li.id.split('_')[1];
        if(yl.isNumber(parseInt(id))) {
          zct.doAjaxDeleteCall('/form/',zct.param({id:id}),function(o){
            var cn = new yu.Element(li.parentNode);
            var json = YAHOO.lang.JSON.parse(o.responseText);
            zct.Notifier.processMessage('success',json.success_msg);
            cn.removeChild(li);
          })
        }
      },
      reloadList : function(id) {
        var url = ["/formList/",(zcbrp.currentId||0)].join('');
        var formsEl = yus.query('div#requestFormList')[0];
        zct.doAjaxCall(url,[],function(o){
          formsEl.innerHTML = o.responseText;
          var container = yu.Dom.get('formsConfiguration');
          yue.purgeElement(container,false);
          yue.on(container,'click',zcbrp.Forms.dispatchEvent);
          
          var el = yu.Dom.get(['formItem_',(id||0)].join(''));
          if(!!el)  zcbrp.Forms.loadEditForm(el);
          
        });
      },
      dispatchEvent : function(e) {
        var target = yue.getTarget(e);
        var elId = target.id.split('_')[0];
        var h = zcbrp.Forms.getEventHandler(elId);
        if(!!zcbrp.Forms.handlers[elId]) h.call(target,e);
      },
      getEventHandler : function(key) {
        var handler = zcbrp.Forms.handlers[key];
        if(!!handler && zct.isFunction(handler)) return handler;
        else return zcbrp.Forms.handlers['default'];
      },
      hideEditForm : function(target) {
        var div = yu.Dom.getAncestorByTagName(target,'form').parentNode;
        var button = yus.query('span#button-cancel',div)[0];
        var el = new yu.Element(div.parentNode);
        zcbrp.Forms.detachContainer(target);
        el.removeChild(div);
      },
      detachContainer : function(actor) {
        var o = yu.Dom.getAncestorByTagName(actor,'form').parentNode.parentNode;
        delete zcbrp.Forms.containers[o.getAttribute('id')];
      },
      handlers : {
        'save': function(e){zcbrp.Forms.modifyForm(yue.getTarget(e));},
        'cancel': function(e){zcbrp.Forms.hideEditForm(yue.getTarget(e));},
        'personalize' :function(e){zcbrp.Forms.spiritUpWorkTab(yue.getTarget(e));},
        'editItem' : function(e){zcbrp.Forms.loadEditForm(yu.Dom.getAncestorByTagName(this,'li'));},
        'deleteItem' : function(e){zcbrp.Forms.confirmationDialog.show(e);},
        'default': function(){return false;}
      }
    }
  }();
  
  yue.onDOMReady(zcbrp.Forms.init);
}());
