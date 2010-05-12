zenexity.capdemat.tools.namespace("zenexity.capdemat.fong");

(function() {

  var zcf = zenexity.capdemat.fong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;

  zcf.AddressAutocomplete = function() {

    return {
      init: function() {
        zct.each(yus.query(".address-fieldset"), function() {
          var fieldsetId = this.id;
          if(document.getElementById(fieldsetId + "_streetName")) {
            var streetNameAutocomplete = new zcc.AutoComplete({
              inputId: fieldsetId + "_streetName",
              modalId: fieldsetId + "_streetName_autocomplete",
              url: "/CapDemat/autocomplete/ways",
              idField: "matriculation",
              minimumChars: 2,
              resultText: function(result) {
                return result.name;
              },
              inputValue: function(result) {
                return result.name;
              },
              onSelectedResult: function(result) {
                document.getElementById(fieldsetId + "_streetMatriculation").value = result.matriculation;
              }
            });
          }
          if(document.getElementById(fieldsetId + "_city")) {
            new zcc.AutoComplete({
              inputId: fieldsetId + "_city",
              modalId: fieldsetId + "_city_autocomplete",
              url: "/CapDemat/autocomplete/cities",
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
                document.getElementById(fieldsetId + "_cityInseeCode").value = result.inseeCode;
                document.getElementById(fieldsetId + "_streetName").value = "";
                document.getElementById(fieldsetId + "_streetMatriculation").value = "";
              }
            });
          }
          if(document.getElementById(fieldsetId + "_postalCode")) {
            new zcc.AutoComplete({
              inputId: fieldsetId + "_postalCode",
              modalId: fieldsetId + "_postalCode_autocomplete",
              url: "/CapDemat/autocomplete/cities",
              urlParams: { postalCode: true },
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
                streetNameAutocomplete.urlParams.city = result.inseeCode;
                document.getElementById(fieldsetId + "_cityInseeCode").value = result.inseeCode;
                document.getElementById(fieldsetId + "_streetName").value = "";
                document.getElementById(fieldsetId + "_streetMatriculation").value = "";
              }
            });
          }
        });
      }
    };
  }();

  yue.onDOMReady(zcf.AddressAutocomplete.init);

}());

