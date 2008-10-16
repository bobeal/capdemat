/**
 * @description This file contains requestType configuration depended classes
 * 
 * @author vba@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrt = zenexity.capdemat.bong.request.templates;
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  var zcbrp = zenexity.capdemat.bong.requesttype;
  
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  
  zcbrp.Config = function() {
    var initButtons = function() {
      zcbrp.Config.makeYuiButtons();
    };
    var initLinks = function() {
      var showLink = new yu.Element('linkShowDatasheet');
      showLink.on('click',function(){
        zcc.doAjaxCall('/requestFormDatasheet/',[],function(o){
          var li = document.getElementById('insert-in-list');
          var fadeIn = new YAHOO.util.Anim(li,{ opacity: { to: 1 } }, 0.6);
          zct.style(li,{opacity:'0.1'});
          li.innerHTML = o.responseText;
          zcbrp.Config.makeYuiButtons();
          yue.on(yus.query('span#button-ok')[0],'click',zcbrp.Config.createForm);
          fadeIn.animate();
        });
      });
    };
    return {
      init : function() {
        initButtons();
        initLinks();
        
        var url = ["/requestFormList/",(zcbrp.currentId||0)].join('');
        var formsEl = yus.query('div#requestFormList')[0];
        zcc.doAjaxCall(url,[],function(o){
          // YAHOO.util.Dom.insertAfter(o.responseText,formsEl);
          formsEl.innerHTML = o.responseText;
          YAHOO.util.Dom.removeClass(formsEl, 'invisible');
          });
      },
      createForm : function() {
      },
      makeYuiButtons : function() {
        buttons = zct.grep(yus.query('input[type=button]'),function(n){
          return (/^button.*/i.test(yl.trim(n.name)))
        });
        zct.each(buttons,function(i){
          var button = new YAHOO.widget.Button(this);
        });
      }
    }
  }();
  
  yue.onDOMReady(zcbrp.Config.init);
}());


//var fadeOut = new YAHOO.util.Anim(connectID, { opacity: { to: 0 } }, 0.5);
