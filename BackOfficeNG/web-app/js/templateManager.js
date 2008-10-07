
zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.request.templates');

(function() {
  
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrt = zenexity.capdemat.bong.request.templates;
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  
  var yw = YAHOO.widget;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  
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
  
  zcbrt.manager = function() {
    var initTabs = function() {
      
      var tab = yus.query('div#workArea_Tab1')[0];
      var url = ['/loadMailTemplate/',zcbrt.manager.name].join('');
      zcc.doAjaxCall(url,[],function(o){
        zcbrt.manager.wrapper = o.responseText
          .replace(/\n/g,'\uffff')
          .replace(/(.*<body>).*(<\/body>.*)/gi,'$1 \${BODY} $2')
          .replace(/\uffff/g,'\n')
          
        tab.innerHTML = o.responseText
          .replace(/\n/g,'\uffff')
          .replace(/.*<body>(.*)<\/body>.*/gi,'$1')
          .replace(/\uffff/g,'\n');
        
        yus.query('div#trash div#wrapper')[0].innerHTML = ['<!--',zcbrt.manager.wrapper,'-->'].join('');
        YAHOO.util.Dom.setStyle('workArea','display','block');
        zcbrt.manager.tabView = new YAHOO.widget.TabView('workArea');
        
        var divs = yus.query('div#workArea_Tab1 div');
        var editables = zct.grep(divs,function(n){
          return (/editable*/.test(n.id));
        });
        zct.each(editables,function(i){
          yue.addListener(this,'click',zcbrt.manager.edit);
        });
        
      });
      
    };
    var initEditor = function() {
      zcbrt.manager.editor = new YAHOO.widget.SimpleEditor('editor', {
        focusAtStart: true,
        toolbar : zcbet.def,
        width : '600px',
        height: '300px'
      });
      zcbrt.manager.editor.render();
      
      //zcbrt.manager.editor.toolbar.addButtonToGroup(zcbet.vars, 'textstyle');
    };
    var initPanel = function() {
      zcbrt.manager.panel = new YAHOO.widget.Panel("editPanel", {
        width:"620px",
        fixedcenter:true,  
			  draggable:false,
        underlay: 'none',
			  visible:false
      });
      
      zcbrt.manager.panel.beforeShowEvent.subscribe(function(ev){
        YAHOO.util.Dom.setStyle('bd-editor','display','block');
        zcbrt.manager.panel.center();
      });
      zcbrt.manager.panel.beforeHideEvent.subscribe(function(ev){
        YAHOO.util.Dom.setStyle('bd-editor','display','none');
      });
      
      zcbrt.manager.panel.render();
    };
    var initButtons = function() {
      var button = new YAHOO.widget.Button(document.getElementById('submit'));
      button.on('click',function(e){
        zcbrt.manager.save();
      });
    };
    return {
      wrapper : undefined,
      name : undefined,
      editor : undefined,
      overlay: undefined,
      panel : undefined,
      editEl: undefined,
      tabView: undefined,
      init : function() {
        initTabs();
        initPanel();
        initEditor();
        initButtons();
        
        zcbrt.manager.editor.on('afterRender',function(ev){
          if(zcbet.def.buttons.length > 0) {
            var button = zcbet.def.buttons[zcbet.def.buttons.length - 1].buttons[0];
            var select = yus.query('select',button.container)[0];
            
            yue.on(select.options,'click',function(ev){
              if(this.value != '0') {
                zcbrt.manager.editor.execCommand('inserthtml', zct.val(select));
                zct.val(select,'0');
              }
            })
          }
        });
      },
      edit : function() {
        if(zcbrt.manager.panel.cfg.getProperty('visible') != true) {
          zcbrt.manager.editEl = this;
          zcbrt.manager.editor.cleanHTML();
          zcbrt.manager.editor.setEditorHTML(this.innerHTML);
          zcbrt.manager.panel.show();
        }
      },
      save : function() {
        if(zct.stripTags(zcbrt.manager.editor.getEditorHTML()).trim().length == 0) {
          zcc.displayResponseResult('unexpectedError',"Editor value can't be empty !");
          return;
        }
        
        if(!!zcbrt.manager.editEl) {
          yus.query('#form1 input[id=element]')[0].value = zcbrt.manager.editEl.id;
          zcbrt.manager.editor.saveHTML();
          
          zcc.doAjaxFormSubmitCall('form1',[],function(o){
            zcbrt.manager.editEl.innerHTML = zcbrt.manager.editor.getEditorHTML();
            var json = YAHOO.lang.JSON.parse(o.responseText);
            zcc.displayResponseResult('success',json.success_msg);
            return false;
          });
        }
        zcbrt.manager.panel.hide();
      },
      emptyHref : function() {
        return 'javascript:;';
      }
    }
  }();
  
  yue.onDOMReady(zcbrt.manager.init);
  
}());
