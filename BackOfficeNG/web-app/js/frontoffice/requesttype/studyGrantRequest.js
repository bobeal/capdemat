zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var yue = YAHOO.util.Event;

  zcfr.StudyGrantRequest = function() {

    return {
      init: function() {
        zcv.complexRules['rib'].pushFields('frenchRIB.bankCode', 'frenchRIB.counterCode', 'frenchRIB.accountNumber', 'frenchRIB.accountKey');
        zcv.putComplexRules({
          "sgrBirthDate" : new zcv.complexRule(function(){
            for (i = 0; i < 3; i++) {
              if (arguments[i].value === null || arguments[i].value === "") return false;
            }
            var birthday = new Date(arguments[0].value, arguments[1].value - 1, arguments[2].value).add({"years" : 26});
            var lastJuly = new Date().set({"day" : 15, "month" : 6});
            if (Date.today().compareTo(lastJuly) < 0) {
              lastJuly.addYears(-1);
            }
            return birthday.compareTo(lastJuly) > 0;
          })
        });
        zcv.complexRules["sgrBirthDate"].pushFields("subjectBirthDate_year", "subjectBirthDate_month", "subjectBirthDate_day");
      }
    };

  }();
}());

