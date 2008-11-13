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
        //alert(zcbr.TaskBoard.pageState);
      },
      send : function() {
        
      }
    }
  }()
  
  YAHOO.util.Event.onDOMReady(zcbr.TaskBoard.init);
  
}());