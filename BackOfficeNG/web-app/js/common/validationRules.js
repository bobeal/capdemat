(function() {
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var yl = YAHOO.lang;

  zcv.putRules({
    'cfbn': new zcv.rule('regex', /^[0-9]{7}[A-Z]{0,1}$/),
    'localReferentialData': new zcv.rule('func', function(f, key){
      for (name in zcv.fields)
        if (key.split('[')[0] === name.split('[')[0] && zcv.fields[name].checked)
          return true;
      return false;
    })
  });
  
  zcv.putComplexRules({
    'rib': new zcv.complexRule(function(){
        // 'Les références bancaires sont invalides'
        // Copy from http://www.codyx.org/snippet_calcul-verification-rib_94.aspx
        if (arguments.length>=3) {
          var bqe= zcv.fields[arguments[0]].value;
          var gui= zcv.fields[arguments[1]].value;
          var cpt= zcv.fields[arguments[2]].value.toUpperCase();
          var tab= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
          var tab1="123456789123456789234567890123456789".split("");
          while (cpt.match(/\D/) != null)
              cpt=cpt.replace(/\D/, tab1[tab.indexOf(cpt.match(/\D/))]);
          var cp=parseInt(cpt, 10);
          
          a=bqe%97;
          a=a*100000+parseInt(gui, 10);
          a=a%97;
          a=a*Math.pow(10, 11) + cp;
          a=a%97;
          a=a*100;
          a=a%97;
          a=97-a;
          if (arguments.length>3) {
              return zcv.fields[arguments[3]].value==a;
          } else {
              return a;
          }
      } else {
          return false;
      }
    })
  });

}());
