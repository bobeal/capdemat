
/**
 * @description This file contains homefolder details client-module
 * @namespace zenexity.capdemat.backoffice.homeFolder
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.backoffice.homeFolder');

(function(){

  var zc = zenexity.capdemat;
  var zcbh = zc.backoffice.homeFolder;
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
      zcbh.Details.topTabView = new yw.TabView('homeFolderData');
      
      zcbh.Details.bottomTabView = new yw.TabView();
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Demandes', cacheData: true,active:true,
        dataSrc: [zc.baseUrl,'/requests/',zcbh.id].join('')
      }));
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Paiements', cacheData: true,
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
        zcbh.Details.inlineEditEvent = new zct.Event(zcbh.Details, zcbh.Details.getHandler);
        yue.on(yud.get("page3"), "click", zcbh.Details.inlineEditEvent.dispatch,zcbh.Details.inlineEditEvent,true)
      },
      inlineEditEvent : undefined,
      getTarget : function (e) {
        var targetEl = yue.getTarget(e);
        if (targetEl.tagName != 'DD' && targetEl.tagName != 'INPUT' && targetEl.tagName != 'A')
          targetEl = yud.getAncestorByTagName(targetEl, 'dd');
        return targetEl;
      },
      getHandler : function(e) {
        var targetEl = zcbh.Details.getTarget(e);
        if (yl.isNull(targetEl) || yud.hasClass(targetEl, 'current-editField'))
          return undefined;
        else if (targetEl.tagName === 'A')
          return targetEl.className;
        else if (targetEl.tagName === 'DD')
          return targetEl.className.split(' ')[0].split('-')[1];
        else
          return targetEl.className.split(' ')[0];
      },
      editField : function(e) {
        var form = yue.getTarget(e);
        if (form.tagName != "FORM")
          form = yud.getAncestorByTagName(form, "form");
        var dd = yud.getAncestorByTagName(form, "dd");
        zct.doAjaxFormSubmitCall(form.getAttribute("id"), null, function(o) {
          yud.addClass(dd, "current-editField");
          yud.addClass(form, "invisible");
          dd.innerHTML += o.responseText;
        });
      },
      revertField : function(e) {
        var form = yue.getTarget(e).form;
        var dd = yud.getAncestorByTagName(form, "dd");
        new yu.Element(dd).removeChild(form);
        yud.removeClass(dd, "current-editField");
        yud.removeClass(
          yud.getFirstChildBy(dd, function(child){ return child.tagName === "FORM" }),
          "invisible"
        );
      },
      submitField : function(e) {
        var form = yue.getTarget(e).form;
        var dd = yud.getAncestorByTagName(form, "dd");
        zct.doAjaxFormSubmitCall(form.getAttribute("id"), null, function(o) {
          zcbh.Details.revertField(e);
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage('success', json.success_msg, null, e);
          yud.getFirstChildBy(
            yud.getFirstChildBy(dd, function(child){ return child.tagName === "FORM" }),
            function(child){ return child.tagName === "SPAN" })
            .innerHTML = json.id;
        });
      }
    }
  }();
  
  yue.onDOMReady(zcbh.Details.init);
  
}());
