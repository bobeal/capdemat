/**
 * @description Client side draft tools implementation.
 * 
 * @author (Victor Bartel) vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.fong');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcf = zenexity.capdemat.fong;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcf.Draft = function(){
    return {
      init : function() {
        setInterval(zcf.Draft.saveDraft,10000);
      },
      saveDraft : function() {
        
      }
    }
  }();

  zct.curry = function (fn, scope) {
    var scp = scope || window;
    var args = [];
    for (var i=2, len = arguments.length; i < len; ++i) {
      args.push(arguments[i]);
    };
    return function() {
      fn.apply(scp, args);
    };
  };
  
  zct.functors = {}
  
  yue.onDOMReady(zcf.Draft.init);
  
}());