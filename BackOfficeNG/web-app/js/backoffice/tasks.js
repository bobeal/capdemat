(function(){
  var zct = zenexity.capdemat.tools;
  var zcb = zenexity.capdemat.bong;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;

  zcb.Tasks = function() {
    return {
      event : undefined,
      init : function() {
        zcb.Tasks.event = new zct.Event(zcb.Tasks, zcb.Tasks.prepareEvent);
        yue.on(yud.get('yui-main'),'click', zcb.Tasks.event.dispatch, zcb.Tasks.event, true);
      },
      prepareEvent : function(e) {
        return (yue.getTarget(e).className||' ').split(' ')[0];
      },
      toggle : function(e) {
        var target = yue.getTarget(e);
        zct.toggleClass(yud.getNextSibling(target.parentNode), 'collapse');
      }
    }
  }();
  YAHOO.util.Event.onDOMReady(zcb.Tasks.init);
}());