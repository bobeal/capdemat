/**
 *  Client-side configuration module
 *  Creates richtext editor & button and interacts with the server
 * 
 *
 *  @author vba@zenexity.fr
 *
 **/

(function(){
  
  var yus = YAHOO.util.Selector;
  var yue = YAHOO.util.Event;
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  
  zct.namespace("zenexity.capdemat.bong.payment");
  var zcbp = zenexity.capdemat.bong.payment;
  
  zcbp.Config = function() {
    var yus = YAHOO.util.Selector;
    var zct = zenexity.capdemat.tools;
    var zcc = zenexity.capdemat.common;
    
    var initButtons = function() {
      var button = new YAHOO.widget.Button(document.getElementById('submit'));
      button.on('click',function(e){
        zenexity.capdemat.bong.payment.Config.editor.saveHTML();
        var form = yus.query('#form1')[0];
        zct.doAjaxFormSubmitCall('form1',[],function(r){
          var json = YAHOO.lang.JSON.parse(r.responseText);
          zct.Notifier.processMessage('success',json.success_msg);
          return false;
        });
      });
    };
    return {
      editor : undefined,
      init : function() {
        var conf = zenexity.capdemat.bong.payment.Config;
        var ta = yus.query('textarea[id=editor]')[0];
        
        conf.editor = new YAHOO.widget.SimpleEditor('editor', {
          focusAtStart: true,
          toolbar : zcbet.def,
          width: zct.width(ta.parentNode)+'px',
          height : '400px'
        });
        conf.editor.render();
        initButtons();
      }
    }
  }();
  
  yue.onDOMReady(zcbp.Config.init);
  
}());
