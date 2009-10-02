zenexity.capdemat.tools.namespace("zenexity.capdemat.fong.requesttype");

(function() {
  var zcfr = zenexity.capdemat.fong.requesttype;
  var zcv = zenexity.capdemat.Validation;
  var zct = zenexity.capdemat.tools;
  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  
  /* FIXME - copy/paste from vOCardRequest.js (Jetty disallow serving symlink)
  */
  zcfr.homeFolderModificationRequest = function() {

    return {
      init: function() {
        var homePhone, mobilePhone, officePhone;
        zct.each(yud.getElementsByClassName('validate-phone', 'input', 'stepForm-adults'), function(){
          if (this.name.indexOf('homePhone') > 0) homePhone = this.name;
          if (this.name.indexOf('mobilePhone') > 0) mobilePhone = this.name;
          if (this.name.indexOf('officePhone') > 0) officePhone = this.	name;
        });
        zcv.complexRules['atLeastOne'].pushFields(homePhone, mobilePhone, officePhone);
      }
    };

  }();
  yue.onDOMReady(zcfr.homeFolderModificationRequest.init);
}());

