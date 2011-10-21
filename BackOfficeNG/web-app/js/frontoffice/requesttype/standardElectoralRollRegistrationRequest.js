zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zct = zenexity.capdemat.tools;
  var zcf = zenexity.capdemat.fong;
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yud = YAHOO.util.Dom;

  zcfr.StandardElectoralRollRegistrationRequest = function() {

    /**
     * Conditions on 2 levels only work if the conditional fields are included in a complex type (fieldset).
     * But it sucks in terms of UX.
     * So "move" the fieldset around the 2 levels to the 2nd level only.
     */
    var moveFieldset = function() {
      //Return if we aren't on step 1.
      if (yud.get('subjectId') === null)
        return;

      //Hide original fieldset.
      var originalFieldset = yus.query('fieldset.condition-estUnionEuropenne-filled', yus.document, true);
      originalFieldset.style.border = 'none';
      originalFieldset.style.padding = '0';
      originalFieldset.style.margin = '0';

      //Create new fieldset.
      var newFieldset = document.createElement('fieldset');
      originalFieldset.appendChild(newFieldset);
      var legend = document.createElement('legend');
      legend.innerHTML = "Indiquez le lieu de votre dernière inscription sur une liste électorale d'un autre pays de l'Union Européenne";
      newFieldset.appendChild(legend);

      //Fill new fieldset.
      zct.each(yus.query('.condition-estElectionEuropenne-filled', originalFieldset), function() {
          newFieldset.appendChild(this);
      });
      newFieldset.className = "condition-estElectionEuropenne-filled";
    };

    return {
      init: function() {
        moveFieldset();

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

}());
