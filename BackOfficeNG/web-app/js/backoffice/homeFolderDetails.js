
/**
 * @description This file contains homefolder details client-module
 * @namespace zenexity.capdemat.backoffice.homeFolder
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
  var yw = YAHOO.widget;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  
  zcbh.Details = function() {
    var initControls = function() {
      zcbh.Details.tabView = new yw.TabView('homeFolderData');
    };
    return {
      /**
       * @description Main tab view control
       */
      tabView : undefined,
      /**
      * @description Initialize current module
      */
      init : function() {
        initControls();
      }
    }
  }();
  
  yue.onDOMReady(zcbh.Details.init);
  
}());
