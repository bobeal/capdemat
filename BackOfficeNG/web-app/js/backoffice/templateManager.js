/**
 * Mail template client-side manager. Builds internal infrastructure of server-side collaboration.
 * Produce some useful browser-depended hacks. Manages client events.
 *
 * @author vba@zenexity.fr
 **/


zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.request.templates');

(function() {

  var zca = zenexity.capdemat.aspect;
  var zcb = zenexity.capdemat.bong;
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrt = zenexity.capdemat.bong.request.templates;

  var yw = YAHOO.widget;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yul = YAHOO.lang;

  zcb.Editor.options.toolbar.buttons.push({
    group: 'textstyle', label: 'Variables',
    buttons: [
      { type: 'select', label: '...', value: 'insertvars', disabled: false,
        menu: [
          { text: '...', value:'0', checked: true },
          { text: '(TS) Identifiant', value:'#{RQ_ID}' },
          { text: '(TS) Label', value:'#{RQ_TP_LABEL}' },
          { text: '(TS) Date de création', value:'#{RQ_CDATE}' },
          { text: '(TS) Date de validation', value:'#{RQ_DVAL}' },
          { text: '(TS) Observations', value:'#{RQ_OBSERV}' },
          { text: '(TS) Catégorie', value: '#{RQ_CAT}' },
          { text: '(TS) Email  de la catégorie', value: '#{RQ_CAT_EMAIL}' },
          { text: '(CP) Identifiant', value:'#{HF_ID}' },
          { text: '(DM) Prénom', value:'#{RR_FNAME}' },
          { text: '(DM) Nom', value:'#{RR_LNAME}' },
          { text: '(DM) Civilité', value:'#{RR_TITLE}' },
          { text: '(DM) Login', value:'#{RR_LOGIN}' },
          { text: '(DM) Question', value:'#{RR_QUESTION}' },
          { text: '(DM) Réponse', value:'#{RR_ANSWER}' },
          { text: '(SU) Prénom', value:'#{SU_FNAME}' },
          { text: '(SU) Nom', value:'#{SU_LNAME}' },
          { text: '(SU) Civilité', value:'#{SU_TITLE}' },
          { text: '(AR) Nom de l\'agent', value: '#{LAST_AGENT_NAME}' }        ]
      }]
  });

  zcbrt.Manager = function() {
    var initPanel = function() {
      zcbrt.Manager.panel = new YAHOO.widget.Panel("templatePanel", {
        width:"620px",
        fixedcenter : "contained",
        modal: true,
        underlay: 'none',
			  visible:false
      });

      zcbrt.Manager.panel.beforeShowEvent.subscribe(function(ev){
        zct.style("templateBody",{display:'block'});
        zcbrt.Manager.panel.center();
      });
      zcbrt.Manager.panel.beforeHideEvent.subscribe(function(ev){
        zct.style("templateBody",{display:'none'});
      });

      zcbrt.Manager.panel.render();
    };
    return {
      editor : undefined,
      panel : undefined,
      editEl: undefined,
      tabView: undefined,
      init : function() {
        //initTabs();
        initPanel();
        zca.advise("save", new zca.Advice("before", zcbrt.Manager.validate), zcb.Editor);
        zca.advise("notify", new zca.Advice("before", zcbrt.Manager.update), zcb.Editor);
        zcbrt.Manager.editor = zcb.Editor.init("template", null, "workArea_Tab1Notifier");
        zcbrt.Manager.editor.on('afterRender',function(ev){
          if(zcb.Editor.options.toolbar.buttons.length > 0) {
            var button = zcb.Editor.options.toolbar.buttons[zcb.Editor.options.toolbar.buttons.length - 1].buttons[0];
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
      validate : function(e) {
        zcbrt.Manager.editor.saveHTML();
        if (yul.trim(zct.stripTags(zcbrt.Manager.editor.getEditorHTML())).length == 0) {
          zct.Notifier.processMessage("unexpectedError","Editor value can't be empty !");
          yue.stopEvent(e);
        }
      },
      update : function(e) {
        zcbrt.Manager.editEl.innerHTML = zcbrt.Manager.editor.getEditorHTML();
        zcbrt.Manager.panel.hide();
      },
      emptyHref : function() {
        return 'javascript:;';
      }
    }
  }();

  yue.onDOMReady(zcbrt.Manager.init);

}());
