/**
 *  Main client-side module of request type conficguration
 *  
 *  @namespace zenexity.capdemat.bong.requesttype
 *  @author vba@zenexity.fr
 *
 **/

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function() {
  
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
  
  zcbrp.Conf = function() {
    return {
      overlay : undefined,
      event : undefined,
      init : function() {
        zcbrp.Conf.event = new zct.Event(zcbrp.Conf,zcbrp.Conf.prepareSimpleClick);
        zcbrp.Conf.overlay = new YAHOO.widget.Overlay('requestStatePanel',{
          visible:false,
          context : ["requestState", "tl", "bl"]
        });
        
        zcbrp.Conf.overlay.render();
        //zcbrp.Conf.overlay.cfg.setProperty('context', ["requestState", "tr", "tl", ["beforeShow", "windowResize"]]);
        yue.on(yu.Dom.get('secondMenu'),'click',zcbrp.Conf.dispatchEvent);
        yue.on(yu.Dom.get('mainPanel'),'click',zcbrp.Conf.event.dispatch,zcbrp.Conf.event,true);
        yue.on(yu.Dom.get('requestState'),'click',zcbrp.Conf.displayStateForm,zcbrp.Conf,true);
      },
      prepareSimpleClick : function(e) {
        return (yue.getTarget(e).id||'').split('_')[0];
      },
      saveRequestTypeAlerts: function(e) {
        var target = yue.getTarget(e);
        var form = yu.Dom.get('requestTypeAlertsForm');
        var error = yu.Dom.get('dialogRequestTypeAlertsFormError');
        
        if(FIC_checkForm(form,error)) {
          zct.each(yus.query('input[type=text]',form),function(i,n){
            n.value = parseInt(n.value);
            if(n.value < 0) n.value = n.value * -1;
          });
          zct.doAjaxFormSubmitCall(form.id,[],function(o){
            var json = ylj.parse(o.responseText);
            zct.Notifier.processMessage('success',json.success_msg);
          });
        }
      },
      displayStateForm : function() {
        var url = ['/state/',zcbrp['currentId'] ].join('');
        zct.doAjaxCall(url,'',function(o){
          var panel = yu.Dom.get('requestStatePanel')
          yus.query('.bd',panel)[0].innerHTML = o.responseText;
          yue.on(yu.Dom.get('cancelButton'),'click',function(){zcbrp.Conf.overlay.hide();});
          yue.on(yu.Dom.get('saveButton'),'click',function(){
            zcbrp.Conf.overlay.hide();
            zct.doAjaxFormSubmitCall('requestStateForm',[],function(o){
              var json = ylj.parse(o.responseText);
              var span = yu.Dom.get('requestState');
              
              zct.Notifier.processMessage('success',json.success_msg);
              yu.Dom.removeClass(span,'tag-enable');
              yu.Dom.removeClass(span,'tag-disable');
              yu.Dom.addClass(span,['tag-',json.state].join(''));
              zct.text(span,json.label);
            });
          });
          var state = yu.Dom.get('initRequestState').value;
          
          if(state == 'active') zct.style(panel,{'border-color': '#20cc20'});
          else if(state == 'inactive') zct.style(panel,{'border-color': '#AA2020'});
          
          zcbrp.Conf.overlay.show();
        });
      },
      dispatchEvent : function(e) {
        var method = zct.capitalize(yue.getTarget(e).id.split('_')[1]);
        var el = yu.Dom.get(['requestType',method].join(''));
        zct.siblings(el,function(n){zct.style(n,{'display':'none'})});
        zct.tryToCall(zcbrp.Conf[['display',method].join('')],zcbrp.Conf);
      },
      switchView : function(containerId) {
        var el = yu.Dom.get(containerId);
        var method = zct.capitalize(containerId.split('-')[2]);
        zct.siblings(el,function(n){zct.style(n,{'display':'none'})});
        zct.tryToCall(zcbrp.Conf[['display',method].join('')],zcbrp.Conf);
      },
      displayForms : function(e) {
        var el = yu.Dom.get('requestTypeForms');
        zct.style(el,{'display':'block'});
      },
      displayDocuments : function(e) {
        zct.style(yu.Dom.get('requestTypeDocuments'),{display:'block'});
        zcbrp.Documents.init();
      },
      dispalyAlerts : function(e) {},
      displaySeasons: function(e) {},
      displayLocalReferential : function(e) {
        zct.style(yu.Dom.get('requestTypeLocalReferential'),{display:'block'});
        zcbrp.LocalReferential.init();
      },
    }
  }();

  zct.each(['Alerts','Seasons'],function(i,name){
    zcbrp.Conf[['display',name].join('')] = function(e) {
      var url = ['/load',name,'Area/',zcbrp.currentId].join('');
      zct.doAjaxCall(url,'',function(o){
        var el = yu.Dom.get(['requestType',name].join(''));
        el.innerHTML = o.responseText;
        zct.style(el,{'display':'block'});
      });
    };
  });
  
  YAHOO.util.Event.onDOMReady(zcbrp.Conf.init);  
  
}());
