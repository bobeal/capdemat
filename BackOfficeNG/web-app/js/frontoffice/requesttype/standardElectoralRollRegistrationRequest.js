zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong;
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var yue = YAHOO.util.Event;

  zcfr.StandardElectoralRollRegistrationRequest = function() {

    return {
      init: function() {
        zcf.RequestCreation.requestTypeModule = zcfr.StandardElectoralRollRegistrationRequest;
        zcv.putComplexRules({
          "eighteenInMarch" : new zcv.complexRule(function(){
            for (i = 0; i < 3; i++) {
              if (arguments[i].value === null || arguments[i].value === "") return false;
            }
            var birthdate = new Date(arguments[0].value, arguments[1].value, arguments[2].value);
            var marchdate = new Date(Date.today().getFullYear() + 1, 03, 01)
            var age = marchdate.getFullYear() - birthdate.getFullYear();
            if (birthdate.getMonth() >= marchdate.getMonth()) {
                age --;
            }
            console.log(age);
            return age >= 18;
            
          },"Le sujet doit être âgé d'au moins 18 ans la veille du 1er mars. <br /> Si le sujet atteint l'âge de 18 ans entre le 1er mars et le jour de l'élection, contactez votre mairie.")
        });
        zcv.complexRules["eighteenInMarch"].pushFields("dateNaissance_year", "dateNaissance_month", "dateNaissance_day");
      },

      displayErrorMsg: function() { return true; }
    };

  }();
  yue.onDOMReady(zcfr.StandardElectoralRollRegistrationRequest.init);
}());

