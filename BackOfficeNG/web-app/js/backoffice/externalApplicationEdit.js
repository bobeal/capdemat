(function(){
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var yud = YAHOO.util.Dom;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;

  zcb.externalApplicationEdit = function() {

    return {
      clickEvent : undefined,

      prepareEvent: function(e) {
        return yue.getTarget(e).id.split('_')[0];
      },

      init: function() {
        zcb.externalApplicationEdit.clickEvent = new zct.Event(zcb.externalApplicationEdit, zcb.externalApplicationEdit.prepareEvent);
        yue.on(yud.get('homeFolders'),'click',zcb.externalApplicationEdit.clickEvent.dispatch,zcb.externalApplicationEdit.clickEvent,true);

        yue.on('applicationForm','submit', zcb.externalApplicationEdit.saveApplication);
        yue.on("changeApplication", "change", zcb.externalApplicationEdit.changeApplication);

        yue.on('importHomeFoldersForm','submit', zcb.externalApplicationEdit.importReferential);
        yue.on('importInvoicesForm','submit', zcb.externalApplicationEdit.importReferential);
        yue.on('importDepositAccountsForm','submit', zcb.externalApplicationEdit.importReferential);
        yue.on('importTicketingContractsForm','submit', zcb.externalApplicationEdit.importReferential);
        yue.on('importInvoicesDetailForm','submit', zcb.externalApplicationEdit.importReferential);
        yue.on('importDepositAccountsDetailForm','submit', zcb.externalApplicationEdit.importReferential);

        if (zcb.externalApplicationEdit.appId != "") {
            zcb.externalApplicationEdit.initHomeFolders('0','');
        }
      },

      changeApplication : function() {
          yud.get("changeApplication").form.submit();
        },

      importReferential: function(e) {
          yue.preventDefault(e);
          var formEl = yue.getTarget(e)
          zct.doAjaxFormSubmitCall(formEl.id,[],function(o){
            var json = ylj.parse(o.responseText);
            zct.Notifier.processMessage(json.status, json.message, null, formEl);
            if (formEl.id === 'importHomeFoldersForm')
              zcb.externalApplicationEdit.initHomeFolders('0','');
          }, true);
      },

      saveApplication: function(e) {
        yue.preventDefault(e);
        if (!zcv.check(e, yud.get('applicationFormErrors')))
          return false;
        var target = yue.getTarget(e);
        zct.doAjaxFormSubmitCall('applicationForm',[],function(o){
          var json = ylj.parse(o.responseText);
          if (json.status === 'success') {
              if (zcb.externalApplicationEdit.editMode === 'create')
                  window.location = zenexity.capdemat.baseUrl + '/editApplication/' + json.id;
              else {
                  zct.Notifier.processMessage(json.status, json.message, null, target);
                  window.location = zenexity.capdemat.baseUrl + '/editApplication/' + json.id;
              }
          } else {
              zct.Notifier.processMessage('modelError',json.message);
          }
        });
      },

      previousHomeFolders: function(e) {
        var startIndex = yud.get('startIndexHomeFolder').value;
        zcb.externalApplicationEdit.initHomeFolders(startIndex, 'prev');
      },

      nextHomeFolders: function(e) {
        var startIndex = yud.get('startIndexHomeFolder').value;
        zcb.externalApplicationEdit.initHomeFolders(startIndex, 'next');
      },

      initHomeFolders : function(startIndex, dir) {
        zct.doAjaxCall(['/homeFolders/','?appId=', zcb.externalApplicationEdit.appId,'&startIndex=', startIndex,
            '&dir=', dir].join(''),[], function(o){
          zct.html(yud.get('homeFolders'),o.responseText);
        });
      },

      matchHomeFolders : function(e) {
        var id = (yue.getTarget(e)||e).id.split('_')[1];
        zct.doAjaxCall('/matchHomeFolders/' + id,[],function(o){
          var wrapperEl = yud.get('matchedHomeFolders_' + id );
          zct.html(wrapperEl, o.responseText);
          zct.style(wrapperEl, {display:'block'});
        });
      },

      bindHomeFolder : function(e) {
        var target = yue.getTarget(e);
        var id = target.id.split('_')[1];
        var localId = target.id.split('_')[2];
        zct.doAjaxCall('/bindHomeFolder/?id=' + id + '&localId=' + localId, [], function(o){
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, target);
          var liEl = yud.getAncestorByTagName(target, 'LI');
          yud.getElementsByClassName('tag-wrapper','span', liEl)[0].innerHTML = json.mappingState;
          zcb.externalApplicationEdit.matchHomeFolders(e);
        });
      },

      freeHomeFolder : function(e) {
        var target = yue.getTarget(e);
        var id = target.id.split('_')[1];
        zct.doAjaxCall('/freeHomeFolder/' + id, [],function(o){
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, target);
          var liEl = yud.getAncestorByTagName(target, 'LI');
          yud.getElementsByClassName('tag-wrapper','span', liEl)[0].innerHTML = json.mappingState;
          zcb.externalApplicationEdit.matchHomeFolders(e);
        });
      },

      ignoreHomeFolder : function(e) {
        var target = yue.getTarget(e);
        var id = target.id.split('_')[1];
        zct.doAjaxCall('/ignoreHomeFolder/?id=' + id, [],function(o){
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, target);
          var liEl = yud.getAncestorByTagName(target, 'LI');
          yud.getElementsByClassName('tag-wrapper','span', liEl)[0].innerHTML = json.mappingState;
          zcb.externalApplicationEdit.matchHomeFolders(e);
        });
      },

      closeMatchHomeFolders : function(e) {
        var id = (yue.getTarget(e)||e).id.split('_')[1];
        zct.style(yud.get('matchedHomeFolders_' + id ), {display:'none'});
      }
    };
  }();

  YAHOO.util.Event.onDOMReady(zcb.externalApplicationEdit.init);

}());
