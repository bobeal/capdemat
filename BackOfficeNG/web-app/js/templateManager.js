/**
 * Mail template client-side manager. Builds internal infrastructure of server-side collaboration.
 * Produce some useful browser-depended hacks. Manages client events.
 * 
 * @author vba@zenexity.fr
 **/


zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.request.templates');

(function() {
  
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrt = zenexity.capdemat.bong.request.templates;
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  
  var yw = YAHOO.widget;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yul = YAHOO.lang;
  
  zcbet.def.buttons.push({
    group: 'textstyle', label: 'Variables',
    buttons: [
      { type: 'select', label: '...', value: 'insertvars', disabled: false,
        menu: [
          { text: '...', value:'0', checked: true },
          { text: 'Name', value:'${NAME}' },
          { text: 'Nick', value:'${NICK}' },
          { text: 'Phone', value:'${PHONE}' }
        ]
      }]
  });
  
  zcbrt.Manager = function() {
    var initEditor = function() {
      zcbrt.Manager.editor = new YAHOO.widget.SimpleEditor('editor', {
        focusAtStart: true,
        toolbar : zcbet.def,
        width : '600px',
        height: '300px'
      });
      zcbrt.Manager.editor.render();
    };
    var initPanel = function() {
      zcbrt.Manager.panel = new YAHOO.widget.Panel("editPanel", {
        width:"620px",
        fixedcenter:true,  
			  draggable:false,
        underlay: 'none',
			  visible:false
      });
      
      zcbrt.Manager.panel.beforeShowEvent.subscribe(function(ev){
        zct.style('bd-editor',{display:'block'});
        zcbrt.Manager.panel.center();
      });
      zcbrt.Manager.panel.beforeHideEvent.subscribe(function(ev){
        zct.style('bd-editor',{display:'none'});
      });
      
      zcbrt.Manager.panel.render();
    };
    var initButtons = function() {
      var button = new YAHOO.widget.Button(document.getElementById('submit'));
      button.on('click',function(e){
        zcbrt.Manager.save();
      });
    };
    return {
      //wrapper : undefined,
      name : undefined,
      editor : undefined,
      panel : undefined,
      editEl: undefined,
      tabView: undefined,
      init : function() {
        //initTabs();
        initPanel();
        initEditor();
        initButtons();
        
        zcbrt.Manager.editor.on('afterRender',function(ev){
          if(zcbet.def.buttons.length > 0) {
            var button = zcbet.def.buttons[zcbet.def.buttons.length - 1].buttons[0];
            var select = yus.query('select',button.container)[0];
            
            yue.on(select,'change',function(ev){
              if(zct.val(select) != '0') {
                zcbrt.Manager.editor.execCommand('inserthtml', zct.val(select));
                zct.val(select,'0');
              }
            })
            
            
          }
        });
      },
      edit : function() {
        if(zcbrt.Manager.panel.cfg.getProperty('visible') != true) {
          zcbrt.Manager.editEl = this;
          zcbrt.Manager.editor.cleanHTML();
          zcbrt.Manager.editor.setEditorHTML(this.innerHTML);
          zcbrt.Manager.panel.show();
        }
      },
      save : function() {
        var editorValue = zcbrt.Manager.editor.getEditorHTML();
        if(yul.trim(zct.stripTags(editorValue)).length == 0) {
          zcc.displayResponseResult('unexpectedError',"Editor value can't be empty !");
          return;
        }
        
        if(!!zcbrt.Manager.editEl) {
          yus.query('#editor-form input[id=element]')[0].value = zcbrt.Manager.editEl.id;
          zcbrt.Manager.editor.saveHTML();
          
          zcc.doAjaxFormSubmitCall('editor-form',[],function(o){
            zcbrt.Manager.editEl.innerHTML = zcbrt.Manager.editor.getEditorHTML();
            var json = YAHOO.lang.JSON.parse(o.responseText);
            zcc.displayResponseResult('success',json.success_msg);
            return false;
          });
        }
        zcbrt.Manager.panel.hide();
      },
      emptyHref : function() {
        return 'javascript:;';
      }
    }
  }();
  
  yue.onDOMReady(zcbrt.Manager.init);
  
}());
