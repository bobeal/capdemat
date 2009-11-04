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
  var zcv = zenexity.capdemat.Validation;
  var zcbrp = zenexity.capdemat.bong.requesttype;
  
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yud = YAHOO.util.Dom;
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
        yue.on(yud.get('secondMenu'),'click',zcbrp.Conf.dispatchEvent);
        yue.on(yud.get('mainPanel'),'click',zcbrp.Conf.event.dispatch,zcbrp.Conf.event,true);
        yue.on(yud.get('requestState'),'click',zcbrp.Conf.displayStateForm,zcbrp.Conf,true);
        yue.on("requestTypeId", "change", zcbrp.Conf.changeRequestType);
      },
      prepareSimpleClick : function(e) {
        return (yue.getTarget(e).id||'').split('_')[0];
      },
      saveRequestTypeAlerts: function(e) {
        var form = yud.get('requestTypeAlertsForm');
        var error = yud.get('dialogRequestTypeAlertsFormError');
        
        if(zcv.check(form,error)) {
          zct.each(yus.query('input[type=text]',form),function(i,n){
            n.value = parseInt(n.value);
            if(n.value < 0) n.value = n.value * -1;
          });
          zct.doAjaxFormSubmitCall(form.id,[],function(o){
            var json = ylj.parse(o.responseText);
            zct.Notifier.processMessage('success',json.success_msg, null, e);
          });
        }
      },
      displayStateForm : function() {
        var url = ['/state/',zcbrp['currentId'] ].join('');
        zct.doAjaxCall(url,'',function(o){
          var panel = yud.get('requestStatePanel')
          yus.query('.bd',panel)[0].innerHTML = o.responseText;
          yue.on(yud.get('cancelButton'),'click',function(){zcbrp.Conf.overlay.hide();});
          yue.on(yud.get('saveButton'),'click',function(){
            zcbrp.Conf.overlay.hide();
            zct.doAjaxFormSubmitCall('requestStateForm',[],function(o){
              var json = ylj.parse(o.responseText);
              var span = yud.get('requestState');
              
              zct.Notifier.processMessage(json.status,json.message);
              yud.removeClass(span,'tag-enable');
              yud.removeClass(span,'tag-disable');
              yud.addClass(span,['tag-',json.state].join(''));
              zct.text(span,json.label);
            });
          });
          var state = yud.get('initRequestState').value;
          
          if(state == 'active') zct.style(panel,{'border-color': '#20cc20'});
          else if(state == 'inactive') zct.style(panel,{'border-color': '#AA2020'});
          
          zcbrp.Conf.overlay.show();
        });
      },
      dispatchEvent : function(e) {
        var method = zct.capitalize(yue.getTarget(e).id.split('_')[1]);
        var el = yud.get(['requestType',method].join(''));
        zct.siblings(el,function(n){zct.style(n,{'display':'none'})});
        zct.style(el,{'display':'block'});
        zct.tryToCall(zcbrp.Conf[['display',method].join('')],zcbrp.Conf);
      },
      displayDocuments : function(e) {
        zcbrp.Documents.init();
      },
      displayAlerts : function(e) {},
      displaySeasons: function(e) {
        zcbrp.Seasons.loadSeasons();
      },
      displayLocalReferential : function(e) {
        zcbrp.LocalReferential.init();
      },
      changeRequestType : function() {
        yud.get("requestTypeId").form.submit();
      }
    }
  }();

  /**
   * Build default "display area" functions.
   */
  zct.each(['Alerts'],function(i,name){
    zcbrp.Conf[['display',name].join('')] = function(e) {
      var url = ['/load',name,'Area/',zcbrp.currentId].join('');
      zct.doAjaxCall(url,'',function(o){
        var el = yud.get(['requestType',name].join(''));
        el.innerHTML = o.responseText;
      });
    };
  });
  
  YAHOO.util.Event.onDOMReady(zcbrp.Conf.init);  
  
}());
