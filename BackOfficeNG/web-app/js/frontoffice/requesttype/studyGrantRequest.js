zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong;
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yu = YAHOO.util;
  var yw = YAHOO.widget;
  
  zcfr.StudyGrantRequest = function() {
  
  /* -----------------------------------------------------------------------------------------------
   Copy from http://www.codyx.org/snippet_calcul-verification-rib_94.aspx
   function isRibValid()
   calcul/vérification de la validité d'un RIB/RIP (Relevé d'Identité Bancaire/Postale)
   accepte 3 ou 4 arguments
   - 3 arguments : code banque (numérique)
                   code guichet (numérique)
                   numéro de compte (alpha)
                   La fonction retourne alors la clé RIB Calculée
   - 4 arguments : Clé RIB en plus (numérique)
                   La fonction retourne alors un booleen indiquant si le RIB est valide

    Attention : 
                   La validité des arguments (code bqe numérique, numéro de compte à 11 caractères, etc ...) 
                   n'est pas contrôlée par la fonction.
   ---------------------------------------------------------------------------------------------- */
     var isRIBvalid = function() {
      if (isRIBvalid.arguments.length>=3) {
          var bqe=isRIBvalid.arguments[0];
          var gui=isRIBvalid.arguments[1];
          var cpt=isRIBvalid.arguments[2].toUpperCase();
          var tab= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
          var tab1="123456789123456789234567890123456789".split("");
          while (cpt.match(/\D/) != null)
              cpt=cpt.replace(/\D/, tab1[tab.indexOf(cpt.match(/\D/))]);
          var cp=parseInt(cpt, 10);
          
          a=bqe%97;
          a=a*100000+parseInt(gui, 10);
          a=a%97;
          a=a*Math.pow(10, 11) + cp;
          a=a%97
          a=a*100;
          a=a%97
          a=97-a;
          if (isRIBvalid.arguments.length>3)
              return isRIBvalid.arguments[3]==a;
          else
              return a;
          }
      else {
          return false;
      }
    }
    
    /* 
     * TODO - Copy/Paste from requestCreation.js
     * hack to append submit input as hidden
     */
    var addSubmitAsHidden = function (submitEl) {
      var submitAsHiddenEl = submitEl.cloneNode(false);
      submitAsHiddenEl.type = 'hidden'
      var fromYuiEl = new yu.Element(submitEl.form);
      fromYuiEl.appendChild(submitAsHiddenEl);
    }

    return {
      
      init : function() {
        zcf.RequestCreation.submitStep = zcfr.StudyGrantRequest.submitStep;
      },
      
      submitStep : function(e) {
        yue.preventDefault(e);
        var targetEl = yue.getTarget(e);

        var errorEl = yud.get(targetEl.form.id + '-error')
        if (!FIC_checkForm(e, errorEl, false))
          return;

        if (targetEl.name.indexOf('bankReference') > -1) {
          var bankCode = targetEl.form.bankCode.value;
          var counterCode = targetEl.form.counterCode.value;
          var accountNumber = targetEl.form.accountNumber.value;
          var accountKey = targetEl.form.accountKey.value;
          if (!isRIBvalid(bankCode, counterCode, accountNumber, accountKey)) {
            zct.html(errorEl, "Les références bancaires sont invalides");
            return;
          }
        }
        addSubmitAsHidden(targetEl);
        targetEl.form.submit();     
      }
      
    };
    
  }();
  yue.onDOMReady(zcfr.StudyGrantRequest.init);
}());

