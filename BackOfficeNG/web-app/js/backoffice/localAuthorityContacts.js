
/**
 * @description This file contains PUT YOUR DESCRIPTION
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.localauthority');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcl = zenexity.capdemat.localauthority;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  
  zcl.Contacts = function() {
    return {
      oposites: {associate:'unassociate',unassociate:'associate'},
      init : function() {
        var event = new zct.Event(_me,_me.extractHandler);
        yue.on('meansOfContactList','click',event.dispatch,event,true);
      },
      extractHandler : function(e) {
        return (yue.getTarget(e).id||'').split('_')[0];
      },
      processMean : function(e) {
        var target = yue.getTarget(e);
        var id = (target.id||'').split('_')[1];
        var form = yud.get('meanOfContactsForm');
        if(!id) return false;
        
        form['meanId'].value = id;
        form['verb'].value = yl.trim(yus.query('span',target)[0].innerHTML);
        zct.doAjaxFormSubmitCall(form.id,[],function(o){
          yud.removeClass(target,target.className.split(' ')[0]);
          yud.addClass(target,_me.oposites[form['verb'].value]);
          yus.query('span',target)[0].innerHTML = _me.oposites[form['verb'].value];
        });
      }
    };
  }();
  
  var _me = zcl.Contacts;
  yue.onDOMReady(zcl.Contacts.init);
  
}());
