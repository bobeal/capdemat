
zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.homeFolder');

(function(){

  var zc = zenexity.capdemat;
  var zca = zc.aspect;
  var zcb = zc.bong;
  var zcc = zc.common;
  var zcbh = zcb.homeFolder;
  var zct = zc.tools;

  var y = YAHOO;
  var yl = y.lang;
  var ylj = yl.JSON;
  var yw = y.widget;
  var yu = y.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;

  zcbh.Details = function() {
    var initControls = function() {
      zcbh.Details.bottomTabView = new yw.TabView();
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Journal', cacheData: true,active:true,
        dataSrc: [zc.baseUrl,'/actions/',zcbh.Details.homeFolderId].join('')
      }));
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Demandes', cacheData: true,
        dataSrc: [zc.baseUrl,'/requests/',zcbh.Details.homeFolderId].join('')
      }));
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Paiements', cacheData: true,
        dataSrc: [zc.baseUrl,'/payments/',zcbh.Details.homeFolderId].join('')
      }));
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Aide', cacheData: true,
        dataSrc: [zc.baseUrl,'/help/'].join('')
      }));
      zcbh.Details.bottomTabView.appendTo('homeFolderInformation');
    };

    return {

      bottomTabView : undefined,

      init : function() {
        initControls();
        zcbh.Details.inlineEditEvent = new zct.Event(zcbh.Details, zcbh.Details.getHandler);
        yue.on(yud.get("homeFolder"), "click", zcbh.Details.inlineEditEvent.dispatch,zcbh.Details.inlineEditEvent,true)
        zcb.Contact.init(yud.get("contactLink"), yud.get("contactPanel"), zcb.contactPanelUrl);
        zca.advise("notify", new zca.Advice("afterReturn", zcbh.Details.refreshActions), zcb.Contact);
      },

      inlineEditEvent : undefined,

      getTarget : function(e) {
        var target = yue.getTarget(e);
        // FIXME : bad
        if (zct.isIn(target.tagName, ['DT', 'DD','P', 'LI', 'SPAN']))
          target = yud.getAncestorByTagName(target, 'dl');
        if (target.tagName === 'DL' && yud.hasClass(target, 'collapse'))
          return null;
        return target;
      },

      getHandler : function(e) {
        var target = zcbh.Details.getTarget(e);
        if (yl.isNull(target))
          return undefined;
        return target.className.split(' ')[0];
      },

      toggle : function(e) {
        var target = yue.getTarget(e);
        var wrapper = yud.getAncestorByTagName(target, 'div');
        if (yus.query('form', wrapper.id).length > 0)
          return;
        zct.toggleClass(wrapper, 'collapse');
        zct.each(yus.query('dl', wrapper.id),function(){
          zct.toggleClass(this, 'collapse');
        });
      },

      individual : function(e , mode) {
        yue.preventDefault(e);
        var dl = zcbh.Details.getTarget(e);
        if (dl.tagName != 'DL') dl = yud.getAncestorByTagName(dl, 'dl');
        var atom = dl.className.split(' ')[1].split('-');
        var div = yud.getAncestorByClassName(dl, 'account');
        var id = div.id.split('_')[1];
        zct.doAjaxCall(
            '/' + atom[0]
            + '/' + id
            + '/' + atom[1]
            + '?mode=' + mode
          , null,
          function(o) {
            dl.innerHTML = o.responseText;
            if (atom[1] === "address" && mode === "edit") {
                zcc.AddressAutocomplete.bind("address_" + id);
            }
          });
      },
      edit : function(e) {
        if (yud.getAncestorByTagName(yue.getTarget(e), 'form')) return;
        zcbh.Details.individual(e,'edit');
      },
      cancel : function(e) { zcbh.Details.individual(e,'static'); },

      save : function(e) {
        yue.preventDefault(e);
        var target = yue.getTarget(e);
        var dl = yud.getAncestorByTagName(target, 'dl');
        zct.doAjaxFormSubmitCall(target.form.getAttribute('id'), [], function(o) {
          if (!zcbh.Details.isValid(o, target.form)) return;
          if (target.form['mode'].value === 'modify') {
            dl.innerHTML = o.responseText;
            // hack : refresh clr (hibernate problem)
            var formId = target.form.getAttribute('id').split('_');
            if (formId[0] === 'responsibles') {
              zct.doAjaxCall('/child/' + formId[1] + '/responsibles?mode=static', null,function(o) {
                dl.innerHTML = o.responseText;
              });
            }
          } else {
            var individual = yud.getAncestorByClassName(dl, 'account');
            var div = individual.parentNode;
            div.removeChild(individual);
            div.innerHTML += o.responseText;
          }
          zcbh.Details.refreshActions();
        });
      },

      isValid : function(o, form) {
        // hack : if response type is JSON, some fields are invalid
        if (!ylj.isValid(o.responseText)) return true;
        zct.each(form.elements, function(){
          yud.removeClass(this,'validation-failed');
        });
        zct.each(ylj.parse(o.responseText).invalidFields, function(){
          yud.addClass(form[this], 'validation-failed');
        });
        return false;
      },

      refreshActions : function() {
        zct.each(zcbh.Details.bottomTabView.get("tabs"), function() {
            if (this.get("label") === "Historique") {
              var cacheData = this.get("cacheData");
              var contentVisible = this.get("contentVisible");
              this.set("cacheData", false);
              this.set("contentVisible", false);
              this.set("contentVisible", true);
              this.set("contentVisible", contentVisible);
              this.set("cacheData", cacheData);
            }
          }, null);
      },

      add : function(e) {
        var target = yue.getTarget(e);
        var div = yud.getAncestorByTagName(target, 'div');
        var type = target.className.split(' ')[1];
        zct.doAjaxCall(
          '/' + type
          +'?mode=edit'
          + '&homeFolderId=' + zcbh.Details.homeFolderId
          , null,
          function(o) {
            div.innerHTML += o.responseText;
            if (type === "adult") {
              zcc.AddressAutocomplete.bind("adultAddress");
            }
          });
      },

      cancelAdd : function(e) {
        var div = yud.getAncestorByTagName(yue.getTarget(e), 'div');
        yud.getAncestorByTagName(div, 'div').removeChild(div);
      },

// --> legacy code

      editField : function(e) {
        var form = yue.getTarget(e);
        if (form.tagName != "FORM")
          form = yud.getAncestorByTagName(form, "form");
        var dd = yud.getAncestorByTagName(form, "dd");
        zct.doAjaxFormSubmitCall(form.getAttribute("id"), null, function(o) {
          yud.addClass(dd, "current-editField");
          yud.addClass(form, "invisible");
          dd.innerHTML += o.responseText;
        });
      },
      revertField : function(e) {
        var form = yue.getTarget(e).form;
        var dd = yud.getAncestorByTagName(form, "dd");
        new yu.Element(dd).removeChild(form);
        yud.removeClass(dd, "current-editField");
        yud.removeClass(
          yud.getFirstChildBy(dd, function(child){ return child.tagName === "FORM" }),
          "invisible"
        );
      },
      submitField : function(e) {
        var form = yue.getTarget(e).form;
        var dd = yud.getAncestorByTagName(form, "dd");
        zct.doAjaxFormSubmitCall(form.getAttribute("id"), null, function(o) {
          zcbh.Details.revertField(e);
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage('success', json.success_msg, null, e);
          yud.getFirstChildBy(
            yud.getFirstChildBy(dd, function(child){ return child.tagName === "FORM" }),
            function(child){ return child.tagName === "SPAN" })
            .innerHTML = json.id;
        });
      }

// legacy code <--
    };
  }();

  yue.onDOMReady(zcbh.Details.init);

}());
