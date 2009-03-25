
/**
 * @description This file contains payment client-side module
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.fong');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcf = zenexity.capdemat.fong;
  
  var yl = YAHOO.lang;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  
  
  zcf.Payment = function() {
    return {
      init : function() {
        yue.on(yus.query('form.list-form'),'submit',zcf.Payment.validate,zcf.Payment,true);
      },
      validate : function(e) {
        yue.stopEvent(e);
        var form = yue.getTarget(e), valid = true;
        var l = zct.grep(yus.query('input',form),function(n){ return n.className.indexOf('validate-')>-1;});
        zct.each(l,function(){
          var that = this;
          zct.each(that.className.split(' '),function(){
            if(/^validate-.*/.test(this+'')){
              var validator = zcf.Payment[['test',zct.capitalize((this+'').replace('validate-',''))].join('')];
              if(!zct.tryToCall(validator,zcf.Payment,that)) {
                zct.style(yus.query('.error',form)[0],{display:'block'});
                yud.addClass(that,'validation-failed');
                valid = false;
              }
            }
          });
        });
        
        if(valid) form.submit();
      },
      testMandatory : function(el) { return yl.trim(el.value) != '';},
      testNumber : function(el) { return /^\d+$/i.test(el.value);},
      testMoney : function(el) { return /^\d+(\.\d{1,2})?$/i.test(el.value);}
    };
  }();
  
  yue.onDOMReady(zcf.Payment.init);
  
}());
