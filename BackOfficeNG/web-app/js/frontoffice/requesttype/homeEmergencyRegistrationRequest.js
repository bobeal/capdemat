zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong;
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var yue = YAHOO.util.Event;

  zcfr.HomeEmergencyRegistrationRequest = function() {

    return {
      init: function() {
        zcf.RequestCreation.requestTypeModule = zcfr.HomeEmergencyRegistrationRequest;
        zcv.putComplexRules({
          "twoDaysAfterToday" : new zcv.complexRule(function(){
            for (i = 0; i < 3; i++) {
              if (arguments[i].value === null || arguments[i].value === "") return false;
            }
            var startdate = new Date(arguments[0].value, arguments[1].value - 1, arguments[2].value);
            var twoDaysAfterToday = Date.today().add({"days" : 3});
            return twoDaysAfterToday.compareTo(startdate) < 0;
          },"La date de début d'accueil doit être dans plus de trois jours à compter de la date d'aujourd'hui")
        });
        zcv.complexRules["twoDaysAfterToday"].pushFields("dateDepart_year", "dateDepart_month", "dateDepart_day");
      },

      displayErrorMsg: function() { return true; }
    };

  }();
  yue.onDOMReady(zcfr.HomeEmergencyRegistrationRequest.init);
}());

