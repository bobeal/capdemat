zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.localauthority');

(function(){

  var zc = zenexity.capdemat;
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var zcbl = zenexity.capdemat.bong.localauthority;

  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var ylj = YAHOO.lang.JSON;
  var yuc = YAHOO.util.Connect;

  zcbl.AddressesReferential = function() {
    return {
      clickEv : undefined,
      init : function() {
        zcbl.AddressesReferential.clickEv = new zct.Event(zcbl.AddressesReferential,zcbl.AddressesReferential.processClick);
        yue.on(yud.get('addressesReferentialBox'),'click',zcbl.AddressesReferential.clickEv.dispatch,zcbl.AddressesReferential.clickEv,true);
      },
      /**
      * @description The name of the method to call is the first part of the clicked item's ID, except for new season creation
      */
      processClick : function(e) {
        var target  = yue.getTarget(e);
        return (target.id||'_').split('_')[0];
      },
      /**
      * @description Save addressesReferential modifications
      */
      save : function(e) {
        var cont = yud.get("addressesReferentialFormErrors");
        cont.innerHTML = "";
        if (zcv.check(yud.get("addressesReferentialForm"), cont)) {
          var target = yue.getTarget(e);
          zct.doAjaxFormSubmitCall("addressesReferentialForm", [], function(o){
            var currentBaseUrl = zenexity.capdemat.baseUrl;
            zenexity.capdemat.baseUrl = [zc['contextPath'],'/autocomplete'].join('');
            yuc.asyncRequest("GET", zc.contextPath + "/autocomplete/tokenValidity", {
              success: function() {
                zct.Notifier.processMessage('success', ylj.parse(o.responseText).success_msg, null, target);
              },
              failure : function() {
                zct.Notifier.processMessage('error', "Configuration incorrecte, veuillez vérifier le token ou l'url", null, target);
              }
            })
            zenexity.capdemat.baseUrl = currentBaseUrl;
          });
          
        }
      }
    }
  }();
  yue.onDOMReady(zcbl.AddressesReferential.init);
}());
