zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong
  var zcfr = zcf.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;

  zcfr.VOCardRequest = function() {

    return {
      init: function() {
        var phonesEl = yud.getChildrenBy(
            yud.get('adultPhones'), function(el){return el.nodeName === 'INPUT'});  
        zcv.complexRules['atLeastOne'].pushFields(phonesEl[0].name, phonesEl[1].name, phonesEl[2].name);

        if (!!yud.get('foreignAdultPhones')) {
          phonesEl = yud.getChildrenBy(
              yud.get('foreignAdultPhones'), function(el){return el.nodeName === 'INPUT'});
          zcv.complexRules['atLeastOne'].pushFields(phonesEl[0].name, phonesEl[1].name, phonesEl[2].name);
        }
        
        zcf.RequestCreation.computeScope = function(form) {
          return zcv.scope.OUTSIDE;
        };
      }
    };

  }();

}());

