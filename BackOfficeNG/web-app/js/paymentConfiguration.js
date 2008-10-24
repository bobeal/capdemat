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
        zcc.doAjaxFormSubmitCall('form1',[],function(r){
          var json = YAHOO.lang.JSON.parse(r.responseText);
          zcc.displayResponseResult('success',json.success_msg);
          return false;
        });
      });
    };
    var getToolbar = function() {
      return {
        titlebar: "Text editor",
        buttons: [
          {
            group: 'textstyle', label: 'Font name & size',
            buttons: [
              { type: 'select', label: 'Arial', value: 'fontname', disabled: true,
                menu: [
                  { text: 'Arial', checked: true },
                  { text: 'Arial Black' },
                  { text: 'Comic Sans MS' },
                  { text: 'Courier New' },
                  { text: 'Lucida Console' },
                  { text: 'Tahoma' },
                  { text: 'Times New Roman' },
                  { text: 'Trebuchet MS' },
                  { text: 'Verdana' }
                ]},
              { type: 'spin', label: '13', value: 'fontsize', range: [ 9, 75 ], disabled: true },
              { type: 'separator' }
              ]
          },
          {
            group: 'textstyle', label: 'Font style',
            buttons: [
              { type: 'push', label: 'Bold', value: 'bold' },
              { type: 'push', label: 'Italic', value: 'italic' },
              { type: 'push', label: 'Underline', value: 'underline' },
              { type: 'separator' }
            ]
          },
          {
            group: 'textstyle', label: 'Colors',
            buttons: [
              { type: 'color', label: 'Font Color', value: 'forecolor', disabled: true },
              { type: 'color', label: 'Background Color', value: 'backcolor', disabled: true },
              { type: 'separator' }
            ]
          },
          {
            group: 'textstyle', label: 'Lists',
            buttons: [
              { type: 'push', label: 'Ordered list', value: 'insertorderedlist' },
              { type: 'push', label: 'Unordered list', value: 'insertunorderedlist' }                  
            ]
          }
        ]
      }
    };
    return {
      editor : undefined,
      init : function() {
        var conf = zenexity.capdemat.bong.payment.Config;
        var ta = yus.query('textarea[id=editor]')[0];
        
        conf.editor = new YAHOO.widget.SimpleEditor('editor', {
          focusAtStart: true,
          toolbar : getToolbar(),
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
