
/**
 * @description This file contains document instruction client-side module 
 * @namespace zenexity.capdemat.bong.document
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.document');

(function(){

  var zc = zenexity.capdemat;
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var zcbd = zenexity.capdemat.bong.document;
  
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
      
      _me.overlay = new yw.Overlay('documentStateOverlay',{visible:false});
      _me.overlay.render();
      
      _me.tip = new yw.Overlay('documentCalendarTip',{visible:false});
      _me.tip.render();
      
      _me.calendar = new yw.Calendar("cal1","documentCalendar", {title:" ", close:true });
      _me.calendar.render();
    };
    var initEvents = function() {
      var clicks = yus.query('#requestDocumentPanel .bd')
        .concat([yud.get('documentStateOverlay')])
        .concat(yus.query('ul.document-list'));
      
      var event = new zct.Event(_me,_me.extractHandler);
      yue.on(clicks,'click',event.dispatch,event,true);
      
      _me.calendar.selectEvent.subscribe(_me.selectCalendar, _me.calendar, true);
    };
    return {
      /**
       * @description Document widget panel
       */
      panel : undefined,
      overlay: undefined,
      tip : undefined,
      /**
       * @description Document tab view
       */
      tabView : undefined,
      dataTabView : undefined,
      confirmDialog: undefined,
      /**
       * @description Document href of clicked link
       */
      docUrl : undefined,
      listUrl : undefined,
      calendar : undefined,
      responseText : undefined,
      /**
      * @description Don't forget to comment each of your method
      */
      init : function() {
        _me.listUrl = [zc['contextPath'],'/backoffice/documentInstruction/documentsList?rid=',zcb['requestId']].join('');
        initWidgets();
        initEvents();
      },
      extractHandler : function(e) {
        var target = yue.getTarget(e);
        if(zct.nodeName(target,'img')||!target.id) target = target.parentNode;
        if(target.name) return ['proceed',zct.capitalize(target.name)].join('');
        else return (target.id||'').split('_')[0];
      },
      refreshList : function(shrt) {
        var url = !shrt ? _me.listUrl : [_me.listUrl,'&shortMode=true'].join('');
        var id = [!shrt ? 'full' : 'partial','DocumentList'].join('');
        zct.doAjaxCall(url,[],function(o){yud.get(id).innerHTML = o.responseText;},true);
      },
      displayDocPanel : function(e,json) {
        _me.cancelDocumentState();
        if(e) {
          yue.preventDefault(e);
          var target = yue.getTarget(e);
          _me.docUrl = target.href;
        } else if(!!json['newDocumentId']) {
          _me.docUrl = _me.docUrl.replace('edit/0?',['edit/',json['newDocumentId'],'?'].join(''));
          _me.refreshList();
          _me.refreshList(true);
        } else {
          _me.refreshList();
        }
        
        zct.doAjaxCall(_me.docUrl,[],function(o) {
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
      selectCalendar : function(type,args) {
        var dates = args[0];
        var date = dates[0];
        var year = date[0], month = date[1], day = date[2];
        
        yud.get('endValidityDate').value = [day,'/', month,'/',year].join('');
      },
      confirmDeletePage : function(e) { _me.confirmDialog.show(e);},
      notify : function(json) {zct.Notifier.processMessage(json.status,json.message,'documentMessage');},
      deletePage : function(e,se) {
        var form = _me.getRelatedEl(yue.getTarget(se),'pageDeleteForm_');
        zct.doAjaxFormSubmitCall(form.id,[],function(o){
          _me.displayDocPanel(undefined,ylj.parse(o.responseText));
          
          zct.doAjaxCall([_me.listUrl,'&shortMode=true'].join(''),[],function(o){ 
            yud.get('partialDocumentList').innerHTML = o.responseText;
            _me.refreshList(true);
          },true);
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
      },
      cancelDocumentState: function(){
        _me.overlay.hide();
        _me.calendar.hide();
      },
      changeDocumentState : function() {
        zct.doAjaxFormSubmitCall('documentStateForm',[],function(o){
          var json = ylj.parse(o.responseText);
          _me.displayDocPanel(undefined,json);
        });
      },
      showStateCalendar : function(e) {
        _me.tip.cfg.setProperty('context',[yue.getTarget(e), "tl", "bl"]);
        _me.calendar.show();
        _me.tip.show();
      },
      toggleStateOverlay: function(e) {
        if(_me.overlay.cfg.getProperty('visible')) {
          _me.overlay.hide();
          return false;
        }
        
        var target = yue.getTarget(e).id ? yue.getTarget(e) : yue.getTarget(e).parentNode;
        var id = target.id.split('_')[1];
        var url = [zc['contextPath'],'/backoffice/documentInstruction/states/',id].join('');
        var css= zct.grep(target.className.split(' '),function(n){return /tag-.*/.test(n);})[0];
        
        //if(!yud.hasClass(yud.get('documentStateOverlay'),css.replace('tag-','overlay-')))
        yud.addClass(yud.get('documentStateOverlay'),css.replace('tag-','overlay-'));
        
        zct.doAjaxCall(url,[],function(o){
          _me.overlay.cfg.setProperty('context',[target.id, "tl", "bl"]);
          _me.overlay.setBody(o.responseText);
          _me.overlay.show();
        },true);
      }
    };
  }();
  
  var _me = zcbd.Instruction;
  
  yue.onDOMReady(zcbd.Instruction.init);
  
}());
