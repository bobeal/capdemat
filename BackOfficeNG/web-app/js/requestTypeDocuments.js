/**
 *  Provides request document type client-side helper
 *  
 *  @namespace - zenexity.capdemat.bong.requesttype
 *  @author vba@zenexity.fr
 *
 **/

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrp = zenexity.capdemat.bong.requesttype;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbrp.Documents = function() {
    return {
      event: undefined,
      init: function() {
        zcbrp.Documents.event = new zcc.Event(zcbrp.Documents,zcbrp.Documents.prepareEvent);
        yue.on(yud.get('requestTypeDocuments'),'click',zcbrp.Documents.event.dispatch,zcbrp.Documents.event,true);
        zcc.doAjaxCall(["/documentList/",(zcbrp.currentId||0)].join(''),[],function(o){
          zct.html(yud.get('documentList'),o.responseText);
          zcbrp.Documents.showAssociatedDocuments(yud.get('showAssociatedDocuments'));
        });
      },
      getScope : function() {
        return ['associate','unassociate'];
      },
      prepareEvent : function(e) {
        var target = yue.getTarget(e);
        return target.id.split('_')[0];
      },
      adaptFilterPanel : function(e) {
        var target = (yue.getTarget(e)||e);
        zct.siblings(target,function(n){yud.removeClass(n,'current')});
        yud.addClass(target,'current');
      },
      showAssociatedDocuments : function(e) {},
      showUnassociatedDocuments : function(e) {},
      showAllDocuments : function(e) {
        var elements = yus.query('#documentTypeFormList li');
        zct.each(elements,function(i,n){zct.style(n,{display:'block'});});
        zcbrp.Documents.adaptFilterPanel(e);
      },
      reloadList : function() {
        var url = ["/documentList/",(zcbrp.currentId||0)].join('');
        zcc.doAjaxCall(url,[],function(o){
          var div = yud.get('documentList');
          zct.html(div,o.responseText);
        });
      }
    }
  }()
  
  zct.each(zcbrp.Documents.getScope(),function(i,name){
    var method = ['show',zct.capitalize(name),'dDocuments'].join('');
    zcbrp.Documents[method] = function(e) {
      var elements = yus.query('#documentTypeFormList li');
      zct.each(elements,function(i,n){zct.style(n,{display:'block'});});
      elements = zct.grep(elements,function(n){ return (yus.query('.'+name,n).length > 0);});
      zct.each(elements,function(i,n){zct.style(n,{display:'none'});});
      
      zcbrp.Documents.adaptFilterPanel(e);
    };
    
    method = [name,'Item'].join('');
    zcbrp.Documents[method] = function(e) {
      var target = (yue.getTarget(e)||e);
      var dtid = target.id.split('_')[1];
      var rtid = zcbrp.currentId;
      
      var classes = zcbrp.Documents.getScope();
      var clss = yud.hasClass(target,'associate') ? 'associate':'unassociate';
      var index1 = zct.inArray(clss,classes);
      var index2 = !!index1 === true ? 0 : 1 ;
      
      var url = ['/',classes[index1],'Document/?rtid=',rtid,'&dtid=',dtid].join('');
      zcc.doAjaxCall(url,[],function(o){
        var json = ylj.parse(o.responseText);
        yud.replaceClass(target,classes[index1],classes[index2]);
        zct.toggleClass(yud.getAncestorByTagName(target,'li'),'notBelong');
      });
    }
  });
}());

