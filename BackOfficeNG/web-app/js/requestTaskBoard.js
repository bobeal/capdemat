/**
 *  Provides request taskboard client-side helper
 *  
 *  @namespace - zenexity.capdemat.bong.request
 *  @author vba@zenexity.fr
 *
 **/

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.request');

(function(){
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbr = zenexity.capdemat.bong.request;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbr.TaskBoard = function() {
    return {
      pageState : undefined,
      init : function() {
        zcbr.TaskBoard.pageState = ylj.parse(yud.get('pageState').value);
        yue.on(yus.query('select[name*=Filter]'),'change',zcbr.TaskBoard.send);
        yue.on(yud.get('saveDisplay'),'click',zcbr.TaskBoard.sendPreferences);
        if(!!zcbr.TaskBoard.pageState.message) {
          zcc.Notifier.displaySuccess(zcbr.TaskBoard.pageState.message);
          zcbr.TaskBoard.pageState.message = undefined;
          
        }
      },
      sendPreferences : function(e) {
        zcbr.TaskBoard.pageState.modifyDisplay = true;
        zcbr.TaskBoard.send(e);
      },
      saveState : function(e) {
        zct.each(yus.query('select[name*=Filter]'),function(i,n){
          zcbr.TaskBoard.pageState.filters[n.name] = zct.val(n);
        });
        zcbr.TaskBoard.pageState.displayForm = [];
        zct.each(yus.query('input.display'),function(i,n){
          if(!!n.checked) {
            zcbr.TaskBoard.pageState.displayForm.push(
              n.name.replace('display','').replace('Requests','')
            );
          }
        });
        yud.get("pageState").value = ylj.stringify(zcbr.TaskBoard.pageState);
      },
      send : function() {
        zcbr.TaskBoard.saveState();
        yud.get('pageForm').submit();
      }
    }
  }();
  
  YAHOO.util.Event.onDOMReady(zcbr.TaskBoard.init);
  
}());