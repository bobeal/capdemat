zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcf = zenexity.capdemat.fong
  var zcfr = zcf.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;

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

        yue.on(yus.query("#children .born"), "change", zcfr.VOCardRequest.isChildBornChange);
        zcfr.VOCardRequest.initChildBorn();

        zcf.RequestCreation.computeScope = function(form) {
          return zcv.scope.OUTSIDE;
        };
      },

      initChildBorn : function() {
        var checkedEl;
        zct.each(yus.query("#children .born"), function() {
            if (this.checked) checkedEl = this;
        });
        zcfr.VOCardRequest.toogleChildFields(checkedEl);
      },

      isChildBornChange : function(e) {
        var targetEl = yue.getTarget(e);
        zcfr.VOCardRequest.toogleChildFields(targetEl);
      },

      toogleChildFields : function(checkedEl) {
        var formEl = yud.getAncestorByTagName(checkedEl, "form");
        var namePrefix = checkedEl.name.split(']')[0] + '].';
        var fields = ['firstName', 'sex'];
        var toogleClass = (checkedEl.value === 'true' ? 'add' : 'remove') + 'Class';
        for (i in fields) {
          yud[toogleClass](yud.getPreviousSibling(formEl[namePrefix + fields[i]]), 'required');
          yud[toogleClass](formEl[namePrefix + fields[i]], 'required');
        }
        yud.getNextSibling(formEl[namePrefix + 'sex']).innerHTML =
          checkedEl.value === 'true' ? zcf.i18n['child.birthDate'] : zcf.i18n['child.expectedBirthDate'];
      }
  };

  }();

  yue.onDOMReady(zcfr.VOCardRequest.init);
}());

