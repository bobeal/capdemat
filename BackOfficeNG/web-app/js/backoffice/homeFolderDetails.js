
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

  var isSavingAdult = false;
  var isSavingChild = false;
  var isCreateUserAccount = false;

  zcbh.Details = function() {
    var initControls = function() {
      zcbh.Details.bottomTabView = new yw.TabView();
      zcbh.Details.bottomTabView.addTab( new yw.Tab({
        label: 'Historique', cacheData: true,active:true,
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
      zcbh.Details.bottomTabView.appendTo('homeFolderInformation');
    };

    return {

      bottomTabView : undefined,

      init : function() {
        if (!!zcbh.Details.homeFolderId) {
          initControls();
          zcb.Contact.init(yud.get("contactLink"), yud.get("contactPanel"), zcb.contactPanelUrl);
          zca.advise("notify", new zca.Advice("afterReturn", zcbh.Details.refreshActions), zcb.Contact);
        }
        if (!zcbh.Details.homeFolderId && !!zcc.AddressAutocomplete) {
          zcc.AddressAutocomplete.bind("address");
        }
        zcbh.Details.inlineEditEvent = new zct.Event(zcbh.Details, zcbh.Details.getHandler);
        yue.on(yud.get("homeFolder"), "click", zcbh.Details.inlineEditEvent.dispatch,zcbh.Details.inlineEditEvent,true);

        zcbh.Details.confirmRemoveDialog = new zct.ConfirmationDialog(
          { head : 'Attention',
            body : 'Voulez-vous supprimer cet individu ?' },
          zcbh.Details.removeIndividual);

        zcbh.Details.initSecurityRule(zcbh.Details.agentCanWrite);
      },

      initSecurityRule : function(canWrite) {
        if (!canWrite) {
          zct.each(yus.query('.edit', 'homeFolder'),function(){
            yud.removeClass(this, 'edit');
          });
          zct.each(yus.query('.add', 'homeFolder'),function(){
            this.parentNode.removeChild(this);
          });
          zct.each(yus.query('.confirmRemoveIndividual', 'homeFolder'),function(){
            this.parentNode.removeChild(this);
          });
        }
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
        var div = yud.getAncestorByClassName(dl, 'individual');
        var id = div.id.split('_')[1];
        var urlElems = atom.slice(1, atom.length)
        var urlElemsString = ""
        for(i = 0; i < urlElems.length; i ++) {
        	urlElemsString = urlElemsString+"/"+urlElems[i].replace(/#/g,' ')
        }
        zct.doAjaxCall(
            '/' + atom[0]
            + '/' + id
            + urlElemsString
            + '?mode=' + mode
          , null,
          function(o) {
            dl.innerHTML = o.responseText;
            if (atom[1] === "address" && mode === "edit" && !!zcc.AddressAutocomplete) {
                zcc.AddressAutocomplete.bind("address_" + id);
            }
          });
      },
      edit : function(e) {
        if (yud.getAncestorByTagName(yue.getTarget(e), 'form')) return;
        zcbh.Details.individual(e,'edit');
      },
      cancel : function(e) { zcbh.Details.individual(e,'static'); },

      // TODO : refactor individual and atom refresh policy after creation or modification
      save : function(e) {
        yue.preventDefault(e);
        var target = yue.getTarget(e);
        var dl = yud.getAncestorByTagName(target, 'dl');
        if((target.form.getAttribute('id') == 'addChild' && !isSavingChild)||(target.form.getAttribute('id') == 'addAdult' && !isSavingAdult)
          || (!isSavingChild && !isSavingAdult)){
          isSavingChild = true;
          isSavingAdult = true;
          zct.doAjaxFormSubmitCall(target.form.getAttribute('id'), [], function(o) {
            if (!zcbh.Details.isValid(o, target.form)) {
              isSavingChild = false;
              isSavingAdult = false;
              return;
            }
            if (target.form['mode'].value === 'modify') {
              dl.innerHTML = o.responseText;
              // hack : refresh clr (hibernate problem)
              var formId = target.form.getAttribute('id').split('_');
              if (formId[0] === 'responsibles') {
                zct.doAjaxCall('/child/' + formId[1] + '/responsibles?mode=static', null,function(o) {
                  dl.innerHTML = o.responseText;
                });
              }
              isSavingChild = false;
              isSavingAdult = false;
            } else {
              json = ylj.parse(o.responseText);
              zct.doAjaxCall('/' + json.type + '/' + json.id + '/?mode=static' , null,function(o) {
                var individual = yud.getAncestorByClassName(dl, 'individual');
                var div = individual.parentNode;
                div.removeChild(individual);
                div.innerHTML += o.responseText;
                isSavingChild = false;
                isSavingAdult = false;
              });
            }
            zcbh.Details.refreshActions();

          });
        }
      },

      create : function(e) {
        yue.preventDefault(e);
        var target = yue.getTarget(e);
        if(!isCreateUserAccount){
        isCreateUserAccount = true;
          zct.doAjaxFormSubmitCall(target.form.getAttribute('id'), [], function(o) {
            if (!zcbh.Details.isValid(o, target.form)){
              isCreateUserAccount = false;
              return;
            } else {
              var json = ylj.parse(o.responseText);
              window.location = zenexity.capdemat.baseUrl + '/details/' + json.id;
              isCreateUserAccount = false;
            }
          });
        }
      },

      // TODO : It would be better to use JSON wrapper for all response
      isValid : function(o, form) {
        // hack : if response type is JSON, some fields are invalid
        if (!ylj.isValid(o.responseText)) return true;
        json = ylj.parse(o.responseText)
        if (!json.invalidFields) return true;
        zct.each(form.elements, function(){
          yud.removeClass(this,'validation-failed');
        });
        zct.each(json.invalidFields, function(){
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
        this.refreshHomeFolderState();
      },

      add : function(e) {
        var target = yue.getTarget(e);
        var type = target.className.split(' ')[1];
        if (yud.get('add' + zct.capitalize(type))) return;
        zct.doAjaxCall(
          '/' + type
          +'?mode=edit'
          + '&homeFolderId=' + zcbh.Details.homeFolderId
          , null,
          function(o) {
            var div = yud.getNextSibling(target.parentNode)
            div.innerHTML = o.responseText + div.innerHTML;
            if (type === "adult" && !!zcc.AddressAutocomplete) {
              zcc.AddressAutocomplete.bind("adultAddress");
            }
          });
      },

      cancelAdd : function(e) {
        var div = yud.getAncestorByTagName(yue.getTarget(e), 'div');
        yud.getAncestorByTagName(div, 'div').removeChild(div);
      },

      confirmRemoveIndividual : function(e) { zcbh.Details.confirmRemoveDialog.show(e); },
      removeIndividual : function(e, se) {
        var target = (yue.getTarget(se)||se);
        var individual = yud.getAncestorByTagName(target, 'div');
        zct.doAjaxCall('/removeIndividual?id=' + individual.id.split('_')[1], null, function(o) {
          var json = ylj.parse(o.responseText);
          if (json.status === 'success') {
            individual.parentNode.removeChild(individual);
            zcbh.Details.refreshActions();
            //Children should be refreshed too… to reflect any change on their responsibles.
          } else {
            zct.Notifier.processMessage('error', json.message, null, target);
          }
        });
      },
      
      refreshHomeFolderState : function() {
          zct.doAjaxCall('/currentHomeFolderState/'+zenexity.capdemat.bong.homeFolder.Details.homeFolderId, null, function(o) {
            var state = document.getElementById('homeFolderState');
            var parentNode=state.parentNode;
            parentNode.innerHTML = o.responseText;
          });
      }
    };
  }();

  yue.onDOMReady(zcbh.Details.init);

}());
