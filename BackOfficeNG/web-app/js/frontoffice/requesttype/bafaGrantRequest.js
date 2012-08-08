zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong;
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var yue = YAHOO.util.Event;

  zcfr.BafaGrantRequest = function() {
    return {
      init: function() {
        zcf.RequestCreation.requestTypeModule = zcfr.BafaGrantRequest;
        zcv.putComplexRules({
          "endAfterBegin" : new zcv.complexRule(function(){
            for (i = 0; i < 6; i++) {
              if (arguments[i].value === null || arguments[i].value === "") return false;
            }
            var startdate = new Date(arguments[0].value, arguments[1].value-1, arguments[2].value);
            var enddate = new Date(arguments[3].value, arguments[4].value-1, arguments[5].value);
            return startdate < enddate;
          },"La date de début du stage doit être antérieure à la date de fin.")
        });
        zcv.complexRules["endAfterBegin"].pushFields("internshipStartDate_year", "internshipStartDate_month", "internshipStartDate_day", "internshipEndDate_year", "internshipEndDate_month", "internshipEndDate_day");
      },

      displayErrorMsg: function() { return true; }
    };

  }();
  yue.onDOMReady(zcfr.BafaGrantRequest.init);
}());

