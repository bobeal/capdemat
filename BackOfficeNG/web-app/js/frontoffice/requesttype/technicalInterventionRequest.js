zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var yue = YAHOO.util.Event;

  zcfr.TechnicalInterventionRequest = function() {

    return {
      init: function() {
        new zzc.AutoComplete({
          input: input,
          modalId: "interventionPlace_city",
          url: "http://localhost:9001/cities",
          delay: 200,
          tpl_result: function(result) {
            return "<li>" + result.name + "</li>";
          },
          tpl_valInput: function(result) {
            return membership.inseeCode;
          },
          offset: {
            left: 0,
            top: 0
          },
          idField: "inseeCode"
        });
      }
    };
  }();

  yue.onDOMReady(zcfr.TechnicalInterventionRequest.init);

}());

