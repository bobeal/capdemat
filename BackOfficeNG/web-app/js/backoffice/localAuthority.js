/**
 * @description This file contains LocalAuthority client class
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong');

(function(){

//  var zct = zenexity.capdemat.tools;
//  var zcc = zenexity.capdemat.common;
  var zcb = zenexity.capdemat.bong;
  
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  
  zcb.LocalAuthority = function() {
    return {
      init : function() {
        (new YAHOO.widget.Button("save"));
        yue.on(yu.Dom.get('save'),'click',zcb.LocalAuthority.save);
      },
      save : function() {
        var form = yu.Dom.get('setupDraftsForm');
        
        if(FIC_checkForm(form,yu.Dom.get('setupDraftsFormErrors')))
          form.submit();
      }
    };
  }();
  
  yue.onDOMReady(zcb.LocalAuthority.init);
}());