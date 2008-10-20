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
  
  
  zcbrp.Config = function() {
    var initPanels = function() {
      var content = {
        head:'Attention !',
        body: 'Supprimer ?'}
      zcbrp.Config.confirmationDialog = new zcc.ConfirmationDialog(
        content,zcbrp.Config.deleteForm);
    };
    var initButtons = function() {
      zcbrp.Config.makeYuiButtons();
    };
    var initPersLink = function(scope) {
      var links = yu.Dom.getChildrenBy(scope,function(n){
        return (zct.nodeName(n,'a') && n.id == 'a-personalize')
      });
      
      if(links.length>0) {
        
      }
    };
    var initTabs = function() {
      zcbrt.Manager.tabView = new YAHOO.widget.TabView('workArea');
      zcbrt.Manager.tabView.set('activeIndex', 0);
    };
    var initLinks = function() {
      var showLink = new yu.Element('linkShowDatasheet');
      showLink.on('click',function(){
        zcbrp.Config.loadEditForm(document.getElementById('insert-in-list'));
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
        zcbrp.Config.reloadList();
      },
      loadEditForm : function(container) {
        if(!!zcbrp.Config.containers[container.id]) return false;
        var url = ['/form/',container.id.split(':')[1]].join('');
        zcbrp.Config.containers[container.id] = container;
        zcc.doAjaxCall(url,[],function(o){
          var trash = document.getElementById('trash');
          trash.innerHTML = o.responseText;
          
          var el = new yu.Element(container);
          var fadeIn = new YAHOO.util.Anim(trash.firstChild,{opacity:{to:1}},0.6);
          
          zct.style(trash.firstChild,{opacity:'0.1'});
          trash.innerHTML = o.responseText;
          el.appendChild(trash.firstChild);
          
          zcbrp.Config.makeYuiButtons();
          fadeIn.animate();
          trash.innerHTML = "";
        });
      },
      spiritUpWorkTab : function(target) {
        var eform = document.getElementById('editor-form');
        var tform = yu.Dom.getAncestorByTagName(target,'form');
        var params = {
          typeId : zcbrp.currentId,
          formId : tform.requestFormId.value,
          file : yu.Dom.getAncestorByTagName(target,'form')
            .currentTemplateName.value
        };
        var url = ['/loadMailTemplate/?', zct.param(params)].join('');
        zcc.doAjaxCall(url,[],function(o){
          var content = o.responseText
            .replace(/\n/g,'\uffff')
            .replace(/.*<body>(.*)<\/body>.*/gi,'$1')
            .replace(/\uffff/g,'\n');
          //zct.style('workArea',{display:'block'});
          
          var newTab = new YAHOO.widget.Tab({
            label: 'New Tab  <span class="close">X</span>',
            active: true,
            content: ['<div id="workArea_Tab1" class="editable-work-area">',content,'</div>'].join('')
          });
          
          zcbrt.Manager.tabView.addTab(newTab);
          zcbrt.Manager.tabView.get('tabs')[0].set('disabled', true);
          
          var divs = yus.query('div#workArea_Tab1 div');
          var editables = zct.grep(divs,function(n){
            return (/editable*/i.test(n.id));
          });
          zct.each(editables,function(i){
            yue.addListener(this,'click',zcbrt.Manager.edit);
          });
          yue.on(newTab.getElementsByClassName('close')[0], 'click', function(e,t){
            YAHOO.util.Event.preventDefault(e);
            zcbrt.Manager.tabView.removeTab(t);
            zcbrt.Manager.tabView.get('tabs')[0].set('disabled', false);
            zcbrt.Manager.tabView.set('activeIndex', 0);
          }, newTab);
          eform.requestTypeId.value = zcbrp.currentId;
          eform.requestFormId.value = tform.requestFormId.value;
        });
      },
      modifyForm : function(target) {
        // TODO add validation here !!!
        var form = yu.Dom.getAncestorByTagName(target,'form');
        var hidden = yus.query('input[name=requestTypeId]',form)[0];
        hidden.value = zcbrp.currentId;
        if(zcbrp.Config.validateForm(target,form)) {
          zcc.doAjaxFormSubmitCall(form.getAttribute("id"),[],function(o){
            var li = new yu.Element(form.parentNode.parentNode);
            var json = YAHOO.lang.JSON.parse(o.responseText);
            var id = zct.val(yus.query('input[name=id]',form)[0]);
            zcbrp.Config.detachContainer(target);
            
            li.removeChild(form.parentNode);
            zcc.displayResponseResult('success',json.success_msg);
            zcbrp.Config.reloadList();
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
        var li = yu.Dom.getAncestorByTagName(zcbrp.Config.confirmationDialog.showTarget ,'li');
        var id = li.id.split(':')[1];
        if(yl.isNumber(parseInt(id))) {
          zcc.doAjaxDeleteCall('/form/',zct.param({id:id}),function(o){
            var cn = new yu.Element(li.parentNode);
            var json = YAHOO.lang.JSON.parse(o.responseText);
            zcc.displayResponseResult('success',json.success_msg);
            cn.removeChild(li);
          })
        }
        //console.debug(zcbrp.Config.confirmationDialog.showTarget);
      },
      reloadList : function() {
        var url = ["/formList/",(zcbrp.currentId||0)].join('');
        var formsEl = yus.query('div#requestFormList')[0];
        zcc.doAjaxCall(url,[],function(o){
          //alert(o.responseText);
          formsEl.innerHTML = o.responseText;
          YAHOO.util.Dom.removeClass(formsEl, 'invisible');
          var container = document.getElementById('requestFormList');
          yue.purgeElement(container,false);
          yue.on(container,'click',zcbrp.Config.dispatchEvent);
        });
      },
      dispatchEvent : function(e) {
        var target = yue.getTarget(e);
        var elId = target.id.split(':')[0];
        var h = zcbrp.Config.getEventHandler(elId);
        if(!!zcbrp.Config.handlers[elId]) h.call(target,e);
      },
      getEventHandler : function(key) {
        var handler = zcbrp.Config.handlers[key];
        if(!!handler && zct.isFunction(handler)) return handler;
        else return zcbrp.Config.handlers['default'];
      },
      hideEditForm : function(target) {
        var div = yu.Dom.getAncestorByTagName(target,'form').parentNode;
        var button = yus.query('span#button-cancel',div)[0];
        var el = new yu.Element(div.parentNode);
        zcbrp.Config.detachContainer(target);
        el.removeChild(div);
      },
      detachContainer : function(actor) {
        o = yu.Dom.getAncestorByTagName(actor,'form')
          .parentNode.parentNode;
        delete zcbrp.Config.containers[o.getAttribute('id')];
      },
      makeYuiButtons : function() {
        buttons = zct.grep(yus.query('input[type=button]'),function(n){
          return (/^button.*/i.test(yl.trim(n.name)));
        });
        zct.each(buttons,function(i){
          var oldId = this.id;
          this.id = [this.id,yu.Dom.generateId()].join(':');
          var button = new YAHOO.widget.Button(this);
          
          if(!!zcbrp.Config.handlers[oldId])
            button.on("click",zcbrp.Config.handlers[oldId]);
        });
      },
      handlers : {
        'button-ok': function(e){zcbrp.Config.modifyForm(yue.getTarget(e));},
        'button-cancel': function(e){zcbrp.Config.hideEditForm(yue.getTarget(e));},
        'a-personalize' :function(e){zcbrp.Config.spiritUpWorkTab(yue.getTarget(e));},
        'editItem' : function(e){zcbrp.Config.loadEditForm(yu.Dom.getAncestorByTagName(this,'li'));},
        'unassociate' : function(e){zcbrp.Config.confirmationDialog.show(e);},
        'default': function(){return false;}
      }
    }
  }();
  
  yue.onDOMReady(zcbrp.Config.init);
}());
