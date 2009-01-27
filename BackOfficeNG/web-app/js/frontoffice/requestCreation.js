(function() {
  var zcf = zenexity.capdemat.fong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yw = YAHOO.widget;
  
  zcf.RequestCreation = function() {
    
    var viewTab = function(offset) {
      zcf.RequestCreation.requestFormTabView.set(
          'activeIndex',
          zcf.RequestCreation.requestFormTabView.get('activeIndex') + offset
      );
    }

    return {
      clickEvent : undefined,
      requestFormTabView : undefined,
      
      init : function() {
          zcf.RequestCreation.requestFormTabView = new yw.TabView('requestTabView');
          
          zcf.RequestCreation .clickEvent = new zct.Event(zcf.RequestCreation, zcf.RequestCreation.getHandler);
          yue.on('requestTabView','click', zcf.RequestCreation.clickEvent.dispatch, zcf.RequestCreation.clickEvent, true);
      },
      
      getHandler : function(e) {
          var target = yue.getTarget(e);
          tokens = target.id.split('-');
          if (tokens.length > 1)
            return [tokens[0], zct.capitalize(tokens[1])].join('');
          else
            return tokens[0];
      },
      
      submitStep : function(e) {
          yue.preventDefault(e);
          var target = yue.getTarget(e);
          if (!FIC_checkForm(e, yud.get(target.form.id + '-error')))
            return;
          else {
            // -- hack to know current step
            var submitAsTextEl = target.cloneNode(false);
            submitAsTextEl.type = 'hidden'
            var fromYuiEl = new yu.Element(target.form);
            fromYuiEl.appendChild(submitAsTextEl);
            // -- end of hack
            
            target.form.submit();
          }
      },
      
      prevTab : function(e) {
          yue.preventDefault(e);
          viewTab(-1);
      },
      
      nextTab : function(e) {
          yue.preventDefault(e);
          viewTab(1);
      }
    };
    
  }();
  
  yue.onDOMReady(zcf.RequestCreation.init);
  
}());

