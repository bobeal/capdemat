
/**
 * @description This file contains MeanOfContact client-side module 
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.localauthority');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcbl = zenexity.capdemat.bong.localauthority;
  
  var yl = YAHOO.lang;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
//  var ylj = YAHOO.lang.JSON;
  
  
  zcbl.MoC = function() {
    return {
      oposites: {associate:'unassociate',unassociate:'associate'},
      init : function() {
        var event = new zct.Event(zcbl.MoC,zcbl.MoC.extractHandler);
        yue.on('meansOfContactList','click',event.dispatch,event,true);
      },
      extractHandler : function(e) {
        return (yue.getTarget(e).id||'').split('_')[0];
      },
      processMoC : function(e) {
        var target = yue.getTarget(e);
        var id = (target.id||'').split('_')[1];
        var form = yud.get('meanOfContactsForm');
        if(!id) return false;
        
        form['meanId'].value = id;
        form['verb'].value = yl.trim(yus.query('span',target)[0].innerHTML);
        zct.doAjaxFormSubmitCall(form.id,[],function(){
          yud.removeClass(target,target.className.split(' ')[0]);
          yud.addClass(target,zcbl.MoC.oposites[form['verb'].value]);
          yus.query('span',target)[0].innerHTML = zcbl.MoC.oposites[form['verb'].value];
        });
      }
    };
  }();
  
  yue.onDOMReady(zcbl.MoC.init);
  
}());
