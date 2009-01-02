/**
 *  Main client-side module of runtime monitoring
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
  
  zcm.System = function(){
    return {
      init : function() {
        var tabView = new YAHOO.widget.TabView('systemTabView');
      }
    }
  }();
  
  yue.onDOMReady(zcm.System.init);
  
}());