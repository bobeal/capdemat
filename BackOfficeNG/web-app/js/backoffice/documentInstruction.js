
/**
 * @description This file contains PUT YOUR DESCRIPTION
 * @namespace zenexity.capdemat.bong.document
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.document');

(function(){

  var zc = zenexity.capdemat;
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var zcbd = zenexity.capdemat.bong.document;
  
  var yl = YAHOO.lang;
  var yw = YAHOO.widget;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbd.Instruction = function() {
    var initWidgets = function() {
      _me.panel = new yw.Panel(
        'requestDocumentPanel',{
          width: '800px', y: 120,visible: false,
          constraintoviewport: false, draggable: true,
          underlay: 'shadow', close: true
        });
      _me.panel.render();
      _me.confirmDialog = new zct.ConfirmationDialog({
        head : 'Attention',
        body : 'Voullez vous supprimer la page courrante ?'
      },_me.deletePage);
    };
    var initEvents = function() {
      var event = new zct.Event(_me,_me.extractHandler);
      yue.on(yus.query('ul.document-list'),'click',event.dispatch,event,true);
      
      event = new zct.Event(_me,_me.extractHandler);
      yue.on(yus.query('#requestDocumentPanel .bd'),'click',event.dispatch,event,true);
    };
    return {
      /**
       * @description Document widget panel
       */
      panel : undefined,
      /**
       * @description Document tab view
       */
      tabView : undefined,
      dataTabView : undefined,
      confirmDialog: undefined,
      /**
       * @description Document href of clicked link
       */
      lastLink : undefined,
      responseText : undefined,
      /**
      * @description Don't forget to comment each of your method
      */
      init : function() {
        initWidgets();
        initEvents();
      },
      notify : function(json) {
        zct.Notifier.processMessage(json.status,json.message,'documentMessage');
      },
      extractHandler : function(e) {
        var target = yue.getTarget(e);
        if(zct.nodeName(target,'img')) target = target.parentNode;
        if(target.name) return ['proceed',zct.capitalize(target.name)].join('');
        else return (target.id||'').split('_')[0];
      },
      displayDocPanel : function(e,json) {
        var url = undefined;
        if(e) {
          yue.preventDefault(e);
          var target = yue.getTarget(e);
          url = target.href;
          _me.lastLink = target;
        } else if(!!json['newDocumentId']) {
          url = _me.lastLink.href.replace('edit/0?',['edit/',json['newDocumentId'],'?'].join(''));
          var url2 = [zc['contextPath'],'/backoffice/documentInstruction/documentList?rid=',zcb['requestId']].join('');
          zct.doAjaxCall(url2,[],function(o){
            yud.get('fullDocumentList').innerHTML = o.responseText;
          },true);
        } else {
          url = _me.lastLink.href;
        }
        
        zct.doAjaxCall(url,[],function(o) {
          _me.panel.setBody(o.responseText);
          _me.panel.show();
          
          _me.tabView = new yw.TabView("requestDocumentData");
          _me.dataTabView = new yw.TabView("documentMetaData");
          
          if(json) {
            _me.notify(json);
            if(json['pageNumber']) _me.tabView.set('activeIndex', parseInt(json['pageNumber']));
          }
        },true);
      },
      displayEditPanel : function(e) {
        var panel = _me.getRelatedEl(yue.getTarget(e),'pageFormPanel_'),style = {}, val = '';
        val = zct.style(panel,'display').display;
        style.display = val != 'none' ? 'none' : 'block';
        zct.style(panel,style);
      },
      confirmDeletePage : function(e) { _me.confirmDialog.show(e);},
      deletePage : function(e,se) {
        var form = _me.getRelatedEl(yue.getTarget(se),'pageDeleteForm_');
        zct.doAjaxFormSubmitCall(form.id,[],function(o){
          _me.displayDocPanel(undefined,ylj.parse(o.responseText));
        });
      },
      getRelatedEl : function(t,prefix) {
        var target = zct.nodeName(t,'img') ? t.parentNode : t;
        return yud.get([prefix,target.id.split('_')[1]].join(''));
      },
      disableUploadPanel :function (form) {
        form['pageModif'].disabled = 'disabled';
        zct.style(yus.query('.routine-indicator',form,true),{'display':'inline'});
      },
      validate : function(form) {
        zct.style(yus.query('.error',form.parentNode)[0],{display:'none'});
        var factor = form['pageFile'].value.length > 0;
        if(!factor) zct.style(yus.query('.error',form.parentNode)[0],{display:'block'});
        return factor;
      },
      proceedPageModif : function(e) {
        var form = yud.getAncestorByTagName(yue.getTarget(e),'form');
        if(_me.validate(form)) {
          _me.disableUploadPanel(form);
          zct.doAjaxFormSubmitCall(form.id,[],function(o){
            var json = ylj.parse(o.responseText);
            if(!json.pageNumber) json.pageNumber = _me.tabView.get('activeIndex');
            _me.displayDocPanel(undefined,json);
          },true);
        }
      }
    };
  }();
  
  var _me = zcbd.Instruction;
  
  yue.onDOMReady(zcbd.Instruction.init);
  
}());
