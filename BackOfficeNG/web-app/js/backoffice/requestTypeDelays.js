/**
 * @author Jean-Sébastien Bour (jsb@zenexity.com)
 */
zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');
(function(){
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcv = zenexity.capdemat.Validation;
  var zcbrt = zenexity.capdemat.bong.requesttype;
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  zcbrt.Delays = function() {
    return {
      init: function() {
        zcbrt.Conf.saveRequestTypeDelays = zcbrt.Delays.save;
      },
      save : function(e) {
        var form = yud.get('requestTypeDelaysForm');
        var error = yud.get('dialogRequestTypeDelaysFormError');
        if(zcv.check(form,error)) {
          var target = yue.getTarget(e);
          zct.doAjaxFormSubmitCall(form.getAttributeNode("id").value,[],function(o){
            var json = ylj.parse(o.responseText);
            zct.Notifier.processMessage('success',json.success_msg, null, target);
          });
        }
      }
    }
  }();
  YAHOO.util.Event.onDOMReady(zcbrt.Delays.init);
}());
