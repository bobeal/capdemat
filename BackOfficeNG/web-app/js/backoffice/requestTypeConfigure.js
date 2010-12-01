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
  var zcbrt = zenexity.capdemat.bong.requesttype;
  var zcb = zenexity.capdemat.bong;
  
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yud = YAHOO.util.Dom;
  var ylj = YAHOO.lang.JSON;
  
  zcbrt.Conf = function() {
    return {
      overlay : undefined,
      event : undefined,
      init : function() {
        zcbrt.Conf.event = new zct.Event(zcbrt.Conf,zcbrt.Conf.prepareSimpleClick);
        zcbrt.Conf.overlay = new YAHOO.widget.Overlay('requestStatePanel',{
          visible:false,
          context : ["requestState", "tl", "bl"]
        });
        
        zcbrt.Conf.overlay.render();
        yue.on(yud.get('mainPanel'),'click',zcbrt.Conf.event.dispatch,zcbrt.Conf.event,true);
        yue.on(yud.get('requestState'),'click',zcbrt.Conf.displayStateForm,zcbrt.Conf,true);
        yue.on("requestTypeId", "change", zcbrt.Conf.changeRequestType);
      },
      prepareSimpleClick : function(e) {
        return (yue.getTarget(e).getAttribute('id') || '').split('_')[0];
      },
      displayStateForm : function() {
        var url = ['/state/',zcbrt['currentId'] ].join('');
        zct.doAjaxCall(url,'',function(o){
          var panel = yud.get('requestStatePanel')
          yus.query('.bd',panel)[0].innerHTML = o.responseText;
          yue.on(yud.get('cancelButton'),'click',function(){zcbrt.Conf.overlay.hide();});
          yue.on(yud.get('saveButton'),'click',function(){
            zcbrt.Conf.overlay.hide();
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
          
          zcbrt.Conf.overlay.show();
        });
      },
      changeRequestType : function() {
        yud.get("requestTypeId").form.submit();
      }
    }
  }();
  YAHOO.util.Event.onDOMReady(zcbrt.Conf.init);
}());
