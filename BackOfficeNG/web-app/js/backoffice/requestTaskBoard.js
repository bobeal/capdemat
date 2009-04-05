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
  var zcbr = zenexity.capdemat.bong.request;
  
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbr.TaskBoard = function() {
    return {
      event : undefined,
      pageState : undefined,
      init : function() {
        zcbr.TaskBoard.event = new zct.Event(zcbr.TaskBoard,zcbr.TaskBoard.prepareEvent);
        zcbr.TaskBoard.pageState = ylj.parse(yud.get('pageState').value);
        yue.on(yus.query('select[name*=Filter]'),'change',zcbr.TaskBoard.send);
        yue.on(yud.get('doc4'),'click',zcbr.TaskBoard.event.dispatch,zcbr.TaskBoard.event,true);
        if(!!zcbr.TaskBoard.pageState.message) {
          zct.Notifier.displaySuccess(zcbr.TaskBoard.pageState.message);
          zcbr.TaskBoard.pageState.message = undefined;
        }
      },
      prepareEvent : function(e) {
        return (yue.getTarget(e).id||'_').split('_')[0];
      },
      saveDisplay : function(e) {
        zcbr.TaskBoard.pageState.modifyDisplay = true;
        zcbr.TaskBoard.send(e);
      },
      defaultDisplay : function(e) {
        zct.each(yus.query('input[type=checkbox]'),function(i,n){
          var adapted = n.name.replace('display','').replace('Requests','');
          var checked = undefined;
          if(zct.inArray(adapted,zcbr.TaskBoard.pageState.defaultDisplay) > -1) {
            checked = 'checked';
          }
          n.checked = checked;
        });
        zcbr.TaskBoard.send(e);
      },
      refreshDisplay : function(e) {
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
      },
      buildFilterUri : function(o) {
        var cat = zct.val(yud.get('categoryFilter'));
        var req = zct.val(yud.get('requestTypeFilter'));
        var q = encodeURIComponent(['@categoryIdFilter=',cat,'@requestTypeFilter=',req].join(''));
        zct.each(o,function(k,v){
          q = q + encodeURIComponent(['@',k,'=',v].join(''));
        });
        return q;
      },
      showAllRed : function(e) {},
      showAllOrange : function(e) {},
      showAllValidated : function(e) {},
      showAllPending : function(e) {},
      showAllLast : function(e) {
        var target = yue.getTarget(e);
        var f = zcbr.TaskBoard.buildFilterUri({lastInterveningAgentIdFilter:target.id.split('_')[1]});
        target.href = [target.href,'?filterBy=',f].join('');
      }
    }
  }();
  
  zct.each(['Red','Orange'],function(i,n){
    zcbr.TaskBoard[['showAll',n].join('')] = function(e) {
      var target = yue.getTarget(e);
      var f = zcbr.TaskBoard.buildFilterUri({qualityFilter:target.id.replace('showAll','')});
      target.href = [target.href,'?filterBy=',f].join('');
    }
  });
  
  zct.each(['Pending','Validated'],function(i,n){
    zcbr.TaskBoard[['showAll',n].join('')] = function(e) {
      var target = yue.getTarget(e);
      var f = zcbr.TaskBoard.buildFilterUri({stateFilter:target.id.replace('showAll','')});
      target.href = [target.href,'?filterBy=',f].join('');
    }
  });
  
  YAHOO.util.Event.onDOMReady(zcbr.TaskBoard.init);
  
}());