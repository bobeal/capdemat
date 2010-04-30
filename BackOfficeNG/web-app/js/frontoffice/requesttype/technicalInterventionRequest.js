zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {

  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var zcc = zenexity.capdemat.common;
  var yue = YAHOO.util.Event;

  zcfr.TechnicalInterventionRequest = function() {

    return {
      init: function() {
        var test = new zcc.AutoComplete({
          inputId: "interventionPlace_city",
          modalId: "city_autocomplete",
          url: "http://localhost:9000/cities",
          jsonp: true,
          delay: 200,
          resultText: function(result) {
            return result.postalCode + " " + result.name;
          },
          inputValue: function(result) {
            return result.name;
          },
          offset: {
            left: 0,
            top: 0
          },
          idField: "inseeCode",
          onSelectedResult: function(result) {
            document.getElementById("interventionPlace_postalCode").value = result.postalCode;
          }
        });
      }
    };
  }();

  yue.onDOMReady(zcfr.TechnicalInterventionRequest.init);

}());

