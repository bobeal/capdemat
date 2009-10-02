zenexity.capdemat.tools.namespace('zenexity.capdemat.fong');

(function(){

  var zcf = zenexity.capdemat.fong;
  var zcv = zenexity.capdemat.Validation;  
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;

  zcf.Payment = function() {
    return {
      init : function() {
        zcv.putRules({'money': new zcv.rule('regex', /^\d+(\.\d{1,2})?$/)});
        yue.on('ticketingContracts','submit', zcf.Payment.checkAndSubmit);
        yue.on('depositAccounts','submit', zcf.Payment.checkAndSubmit);
      },
      checkAndSubmit : function(e) {
        yue.stopEvent(e);
        var formEl = yue.getTarget(e);
        var errorEl = yud.getElementsByClassName('error','p', formEl)[0];
        if (zcv.check(formEl, errorEl)) formEl.submit();
      }
    };
  }();
  yue.onDOMReady(zcf.Payment.init);
}());
