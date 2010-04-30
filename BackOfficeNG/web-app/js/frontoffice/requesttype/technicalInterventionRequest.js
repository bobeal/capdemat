zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {

  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var zcc = zenexity.capdemat.common;
  var yue = YAHOO.util.Event;

  zcfr.TechnicalInterventionRequest = function() {

    return {
      init: function() {
        var streetNameAucocomplete = new zcc.AutoComplete({
          inputId: "interventionPlace_streetName",
          modalId: "streetName_autocomplete",
          url: "http://localhost:9000/ways",
          urlParams: {},
          jsonp: true,
          idField: "matriculation",
          resultText: function(result) {
            return result.name;
          },
          inputValue: function(result) {
            return result.name;
          }
        });
        new zcc.AutoComplete({
          inputId: "interventionPlace_city",
          modalId: "city_autocomplete",
          url: "http://localhost:9000/cities",
          jsonp: true,
          idField: "inseeCode",
          resultText: function(result) {
            return result.postalCode + " " + result.name;
          },
          inputValue: function(result) {
            return result.name;
          },
          onSelectedResult: function(result) {
            document.getElementById("interventionPlace_postalCode").value = result.postalCode;
            streetNameAucocomplete.urlParams.city = result.inseeCode;
          }
        });
        new zcc.AutoComplete({
          inputId: "interventionPlace_postalCode",
          modalId: "postalCode_autocomplete",
          url: "http://localhost:9000/cities",
          urlParams: { postalCode: true },
          jsonp: true,
          idField: "inseeCode",
          resultText: function(result) {
            return result.postalCode + " " + result.name;
          },
          inputValue: function(result) {
            return result.postalCode;
          },
          onSelectedResult: function(result) {
            document.getElementById("interventionPlace_city").value = result.name;
            streetNameAucocomplete.urlParams.city = result.inseeCode;
          }
        });
      }
    };
  }();

  yue.onDOMReady(zcfr.TechnicalInterventionRequest.init);

}());

