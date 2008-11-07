/**
 *  Provides request document type client-side helper
 *  
 *  @namespace - zenexity.capdemat.bong.requesttype
 *  @author vba@zenexity.fr
 *
 **/

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrp = zenexity.capdemat.bong.requesttype;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbrp.Documents = function() {
    return {
      init: function() {
        
      },
      reloadList : function() {
        var url = ["/docsList/",(zcbrp.currentId||0)].join('');
        zcc.doAjaxCall(url,[],function(o){
          var div = yu.Dom.get('documentList');
          zct.html(div,o.responseText);
        });
      }
    }
  }()
  
}());




