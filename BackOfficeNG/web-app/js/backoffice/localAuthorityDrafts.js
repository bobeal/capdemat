/**
 * @description This file contains Drafts client-side module
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.localauthority');

(function(){

//  var zct = zenexity.capdemat.tools;
//  var zcc = zenexity.capdemat.common;
  var zcbl = zenexity.capdemat.bong.localauthority;
  
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  
  zcbl.Drafts = function() {
    return {
      init : function() {
        (new YAHOO.widget.Button("save"));
        yue.on(yu.Dom.get('save'),'click',zcbl.Drafts.save);
      },
      save : function() {
        var form = yu.Dom.get('setupDraftsForm');
        
        if(FIC_checkForm(form,yu.Dom.get('setupDraftsFormErrors')))
          form.submit();
      }
    };
  }();
  
  yue.onDOMReady(zcbl.Drafts.init);
}());