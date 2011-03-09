
/**
 * @description This file contains payment details client-module
 * @namespace zenexity.capdemat.bong.payment
 * 
 * @author vsi@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.payment');

(function(){

  var zc = zenexity.capdemat;
  var zcbh = zc.bong.payment;
  var zct = zc.tools;

  var y = YAHOO;
  var yl = y.lang;
  var ylj = yl.JSON;
  var yw = y.widget;
  var yu = y.util;
  var yud = yu.Dom;
  var yue = yu.Event;

  zcbh.Details = function() {
    var initControls = function() {
      zcbh.Details.infoTabView = new yw.TabView();
      
      zcbh.Details.infoTabView = new yw.TabView();
      zcbh.Details.infoTabView.addTab( new yw.Tab({
        label: 'Paiements liés au compte', cacheData: true,active:true,
        dataSrc: [zc.baseUrl ,'/homeFolder/',zcbh.id].join('')
      }));
      
      zcbh.Details.infoTabView.appendTo('paymentInformation');
    };
    return {
      /**
       * @description Bottom tab view control
       */
      infoTabView : undefined,
      /**
      * @description Initialize current module
      */
      
      init : function() {
        initControls();
      }
    };
  }();
  
  yue.onDOMReady(zcbh.Details.init);
  
}());
