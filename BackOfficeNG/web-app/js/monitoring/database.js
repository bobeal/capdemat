/**
 *  Main client-side module of database monitoring
 *  
 *  @namespace zenexity.capdemat.monitoring
 *  @author vba@zenexity.fr
 *
 **/

zenexity.capdemat.tools.namespace('zenexity.capdemat.monitoring');

(function() {
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcm = zenexity.capdemat.monitoring;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcm.Database = function(){
    return {
      init : function() {
        var tabView = new YAHOO.widget.TabView('databaseTabView');
        yue.on('apply','click',zcm.Database.applyAuthority);
        dp.SyntaxHighlighter.HighlightAll('code');
      },
      applyAuthority : function(e) {
        var form = yu.Dom.get('pageForm');
        var state = ylj.parse(form.pageState.value);
        state.authorityName = yu.Dom.get('authorityName').value;
        form.pageState.value = ylj.stringify(state);
        form.submit();
      }
    }
  }();
  
  yue.onDOMReady(zcm.Database.init);
  
}());