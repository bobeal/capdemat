
/**
 * @description This file contains homefolder details client-module
 * @namespace zenexity.capdemat.backoffice.homeFolder
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.backoffice.homeFolder');

(function(){

  var zc = zenexity.capdemat;
  var zct = zc.tools;
  var zcc = zc.common;
  var zcbh = zenexity.capdemat.backoffice.homeFolder;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yw = YAHOO.widget;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  
  zcbh.Details = function() {
    var initControls = function() {
      zcbh.Details.topTabView = new yw.TabView('homeFolderData');
      
      zcbh.Details.bottomTabView = new yw.TabView();
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Demandes', cacheData: true,active:true,
        dataSrc: [zc.baseUrl,'/requests/',zcbh.id].join('')
      }));
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Payments', cacheData: true,
        dataSrc: [zc.baseUrl,'/payments/',zcbh.id].join('')
      }));
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Aide', cacheData: true,
        dataSrc: [zc.baseUrl,'/help/'].join('')
      }));
      
      zcbh.Details.bottomTabView.appendTo('homeFolderInformation');
    };
    return {
      /**
       * @description Main top tab view control
       */
      topTabView : undefined,
      /**
       * @description Bottom tab view control
       */
      bottomTabView : undefined,
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
