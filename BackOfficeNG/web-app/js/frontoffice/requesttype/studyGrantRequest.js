zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var yue = YAHOO.util.Event;

  zcfr.StudyGrantRequest = function() {

    return {
      init: function() {
        zcv.complexRules['rib'].pushFields('bankCode', 'counterCode', 'accountNumber', 'accountKey');
        zcv.complexRules['atLeastOne'].pushFields('subjectPhone', 'subjectMobilePhone');
      }
    };

  }();
  yue.onDOMReady(zcfr.StudyGrantRequest.init);
}());

