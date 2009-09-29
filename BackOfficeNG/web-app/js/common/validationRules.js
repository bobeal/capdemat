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

}());
