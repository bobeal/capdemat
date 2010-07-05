zenexity.capdemat.tools.namespace("zenexity.capdemat.common");

(function() {

  var zc = zenexity.capdemat;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yuc = YAHOO.util.Connect;
  var yud = YAHOO.util.Dom;

  zcc.AddressAutocomplete = function() {
    var isActive = false;
    var autocompletes = {};

    var enableStreetName = function(fieldsetId) {
      var fieldset = document.getElementById(fieldsetId);
      var inputAssistance = document.getElementById("inputAssistance")
      if(fieldset && inputAssistance) fieldset.removeChild(inputAssistance);
      document.getElementById(fieldsetId + "_streetName").disabled = false;
      document.getElementById(fieldsetId + "_streetNumber").disabled = false;
    };

    var disableStreetName = function(fieldsetId) {
      var inputAssistance = document.createElement("span");
      inputAssistance.id = "inputAssistance";
      inputAssistance.innerHTML = "Renseigner la ville en premier";
      yud.insertBefore(inputAssistance, yus.query("label[for=interventionPlace_streetNumber]")[0]);
      document.getElementById(fieldsetId + "_streetName").disabled = true;
      document.getElementById(fieldsetId + "_streetNumber").disabled = true;
    };

    var autocompleteBindFieldset = function(fieldsetId) {
      autocompletes[fieldsetId] = {
        streetName:{},
        postalCode:{},
        city: {}
      };
      disableStreetName(fieldsetId);
      var streetNameAutocomplete;
      if(document.getElementById(fieldsetId + "_streetName")) {
        autocompletes[fieldsetId].streetName = new zcc.AutoComplete({
          inputId: fieldsetId + "_streetName",
          modalId: fieldsetId + "_streetName_autocomplete",
          url: zc.contextPath + "/autocomplete/ways",
          idField: "id",
          minimumChars: 2,
          resultText: function(result) {
            return result.name;
          },
          inputValue: function(result) {
            return result.name;
          },
          onSelectedResult: function(result) {
            document.getElementById(fieldsetId + "_streetMatriculation").value = result.matriculation || "";
            document.getElementById(fieldsetId + "_streetRivoliCode").value = result.rivoliCode || "";
          }
        });
      }
      if(document.getElementById(fieldsetId + "_city")) {
        autocompletes[fieldsetId].city = new zcc.AutoComplete({
          inputId: fieldsetId + "_city",
          modalId: fieldsetId + "_city_autocomplete",
          url: zc.contextPath + "/autocomplete/cities",
          idField: "inseeCode",
          resultText: function(result) {
            return result.postalCode + " " + result.name;
          },
          inputValue: function(result) {
            return result.name;
          },
          onSelectedResult: function(result) {
            document.getElementById(fieldsetId + "_postalCode").value = result.postalCode;
            autocompletes[fieldsetId].streetName.urlParams.city = result.inseeCode;
            document.getElementById(fieldsetId + "_cityInseeCode").value = result.inseeCode;
            document.getElementById(fieldsetId + "_streetName").value = "";
            document.getElementById(fieldsetId + "_streetNumber").value = "";
            document.getElementById(fieldsetId + "_streetMatriculation").value = "";
            document.getElementById(fieldsetId + "_streetRivoliCode").value = "";
            enableStreetName(fieldsetId);
          }
        });
      }
      if(document.getElementById(fieldsetId + "_postalCode")) {
        autocompletes[fieldsetId].postalCode = new zcc.AutoComplete({
          inputId: fieldsetId + "_postalCode",
          modalId: fieldsetId + "_postalCode_autocomplete",
          url: zc.contextPath + "/autocomplete/cities",
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
            autocompletes[fieldsetId].streetName.urlParams.city = result.inseeCode;
            document.getElementById(fieldsetId + "_cityInseeCode").value = result.inseeCode;
            document.getElementById(fieldsetId + "_streetName").value = "";
            document.getElementById(fieldsetId + "_streetNumber").value = "";
            document.getElementById(fieldsetId + "_streetMatriculation").value = "";
            document.getElementById(fieldsetId + "_streetRivoliCode").value = "";
            enableStreetName(fieldsetId);
          }
        });
      }
    };

    var autocompleteBind = function(fieldsetId) {
      if(fieldsetId) {
        autocompleteBindFieldset(fieldsetId);
      }
      else {
        zct.each(yus.query(".address-fieldset"), function() {
          autocompleteBindFieldset(this.id);
        });
      }
    };

    var autocompleteUnbindFieldset = function(fieldsetId) {
      delete autocompletes[fieldsetId].streetName;
      delete autocompletes[fieldsetId].postalCode;
      delete autocompletes[fieldsetId].city;
    }

    var autocompleteUnbind = function(fieldsetId) {
      if(fieldsetId) {
        autocompleteUnbindFieldset(fieldsetId);
      }
      else {
        zct.each(yus.query(".address-fieldset"), function() {
          autocompleteUnbindFieldset(this.id);
        });
      }
    };

    return {
      bind: autocompleteBind,
      unbind: autocompleteUnbind,
      init: function() {
        yuc.asyncRequest("GET", zc.contextPath + "/autocomplete/tokenValidity", {
          success: function() {
            isActive = true;
            autocompleteBind();
          }
        })
      }
    };
  }();

  yue.onDOMReady(zcc.AddressAutocomplete.init);

}());

