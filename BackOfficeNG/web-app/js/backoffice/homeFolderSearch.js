
/**
 * @description This file contains homefolder search client-module
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.backoffice.homeFolder');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbh = zenexity.capdemat.backoffice.homeFolder;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = yl.JSON;
  
  
  zcbh.Search = function() {
    return {
      /**
       * @description Page state descriptor
       */
      pageState : undefined,
      /**
      * @description Initialize current module
      */
      init : function() {
        zcbh.Search.pageState = ylj.parse(yud.get('pageState').value);
        yue.on('submitSearch','click',zcbh.Search.doSearch);
      },
      /**
       * @description Retrives and save page state to input element
       */
      saveState : function() {
        zct.each(yus.query('.persistent'),function(){
          zcbh.Search.pageState[this.name] = zct.val(this);
        });
        yud.get("pageState").value = ylj.stringify(zcbh.Search.pageState);
      },
      /**
       * @description Produce home folder search
       */
      doSearch : function() {
        zcbh.Search.saveState();
        yud.get('searchForm').submit();
      }
    }
  }();
  
  yue.onDOMReady(zcbh.Search.init);
  
}());
