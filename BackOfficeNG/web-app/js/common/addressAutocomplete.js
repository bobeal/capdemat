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

    var reorderAddressFields = function(fieldsetId) {
      if (zc.baseUrl.indexOf('backoffice') > 0)
        return;
      var addressEl = yud.get(fieldsetId);
      if (!addressEl) return;
      var fieldNamesToOrder = ['city', 'postalCode', 'streetName', 'streetNumber'];
      var addressFields = yud.getChildren(addressEl.cloneNode(true));
      addressEl.innerHTML = '';
      var divAutoComplete = document.createElement("div");
      yud.addClass(divAutoComplete, 'autocompleteZone');
      addressEl.appendChild(divAutoComplete);
      for (var i=0; i<fieldNamesToOrder.length; i++) {
        for (var j=0; j<addressFields.length; j++) {
          var it = addressFields[j];
          if (!it) continue;
          if ((it.getAttribute('id') + '').indexOf(fieldNamesToOrder[i]) > 0
              || (it.getAttribute('for') + '').indexOf(fieldNamesToOrder[i]) > 0) {
            yud.removeClass(it, 'line1');
            yud.removeClass(it, 'line2');
            divAutoComplete.appendChild(it);
            addressFields[j] = undefined; // hack !
          }
        }
      }
      for (var i=0; i<addressFields.length; i++)
        if (!!addressFields[i] && addressFields[i].nodeName != 'BR')
          addressEl.appendChild(addressFields[i]);
    }

    var autocompleteBindFieldset = function(fieldsetId) {
      autocompletes[fieldsetId] = {
        streetName:{},
        postalCode:{},
        city: {}
      };
      reorderAddressFields(fieldsetId);
      var streetNameAutocomplete;
      if(document.getElementById(fieldsetId + "_streetName")) {
        autocompletes[fieldsetId].streetName = new zcc.AutoComplete({
          inputId: fieldsetId + "_streetName",
          modalId: fieldsetId + "_streetName_autocomplete",
          url: zc.contextPath + "/autocomplete/ways",
          idField: "id",
          minimumChars: 2,
          urlParams : {
            city : yus.query("#"+fieldsetId + "_cityInseeCode")[0].value
          },
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
          }
        });
      }
    };

    var autocompleteBind = function(fieldsetId) {
      if(fieldsetId) {
        fieldsetId = fieldsetId.replace(".", "_").replace("[","_").replace("]","_");
        autocompleteBindFieldset(fieldsetId);
      }
      else {
        zct.each(yus.query(".address"), function() {
          autocompleteBindFieldset(this.id);
        });
      }
    };

    var autocompleteUnbindFieldset = function(fieldsetId) {
      fieldsetId = fieldsetId.replace(".", "_").replace("[","_").replace("]","_");
      delete autocompletes[fieldsetId].streetName;
      delete autocompletes[fieldsetId].postalCode;
      delete autocompletes[fieldsetId].city;
    }

    var autocompleteUnbind = function(fieldsetId) {
      if(fieldsetId) {
        fieldsetId = fieldsetId.replace(".", "_").replace("[","_").replace("]","_");
        autocompleteUnbindFieldset(fieldsetId);
      }
      else {
        zct.each(yus.query(".address"), function() {
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

