/*zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {

  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var zcc = zenexity.capdemat.common;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;

  zcfr.TechnicalInterventionRequest = function() {

    return {
      init: function() {
        zct.each(yus.query(".address-fieldset"), function() {
          var fieldsetId = this.id;
          var streetNameAutocomplete = new zcc.AutoComplete({
            inputId: fieldsetId + "_streetName",
            modalId: fieldsetId + "_streetName_autocomplete",
            url: "http://localhost:9000/ways",
            urlParams: {},
            jsonp: true,
            idField: "matriculation",
            minimumChars: 2,
            resultText: function(result) {
              return result.name;
            },
            inputValue: function(result) {
              return result.name;
            }
          });
          new zcc.AutoComplete({
            inputId: fieldsetId + "city",
            modalId: fieldsetId + "city_autocomplete",
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
              document.getElementById(fieldsetId + "_postalCode").value = result.postalCode;
              streetNameAutocomplete.urlParams.city = result.inseeCode;
              document.getElementById(fieldsetId + "_streetName").value = "";
              document.getElementById(fieldsetId + "_streetMatriculation").value = "";
            },
            onTyping: function(value) {
            }
          });
          new zcc.AutoComplete({
            inputId: fieldsetId + "_postalCode",
            modalId: fieldsetId + "_postalCode_autocomplete",
            url: "http://localhost:9000/cities",
            urlParams: { postalCode: true },
            jsonp: true,
            idField: "inseeCode",
            minimumChars: 2,
            resultText: function(result) {
              return result.postalCode + " " + result.name;
            },
            inputValue: function(result) {
              return result.postalCode;
            },
            onSelectedResult: function(result) {
              document.getElementById(fieldsetId + "_city").value = result.name;
              streetNameAucocomplete.urlParams.city = result.inseeCode;
              document.getElementById(fieldsetId + "_streetName").value = "";
              document.getElementById(fieldsetId + "_streetMatriculation").value = "";
            }
          });
        });
      }
    };
  }();

  yue.onDOMReady(zcfr.TechnicalInterventionRequest.init);

}());
*/
