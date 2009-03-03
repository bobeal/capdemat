(function() {
  var zcf = zenexity.capdemat.fong;
  var zct = zenexity.capdemat.tools;
  var yud = YAHOO.util.Dom;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var yu = YAHOO.util;
  var yw = YAHOO.widget;
  
  zcf.RequestCreation = function() {
    
    var viewTab = function(offset) {
      zcf.RequestCreation.requestFormTabView.set(
          'activeIndex',
          zcf.RequestCreation.requestFormTabView.get('activeIndex') + offset
      );
    }
    
    // hack to append submit input as hidden
    var addSubmitAsHidden = function (submitEl) {
      var submitAsHiddenEl = submitEl.cloneNode(false);
      submitAsHiddenEl.type = 'hidden'
      var fromYuiEl = new yu.Element(submitEl.form);
      fromYuiEl.appendChild(submitAsHiddenEl);
    }

    var validateAndSubmit = function (e, includeScope) {
      yue.preventDefault(e);
      var targetEl = yue.getTarget(e);
      if (!FIC_checkForm(e, yud.get(targetEl.form.id + '-error'), includeScope))
        return;
      else {
        // -- hack to know current step
        addSubmitAsHidden(targetEl);
        
        targetEl.form.submit();
      }
    }
    
    return {
      clickEvent : undefined,
      requestFormTabView : undefined,
      
      init : function() {
        zcf.RequestCreation.requestFormTabView = new yw.TabView('requestTabView');
        
        zcf.RequestCreation.clickEvent =
            new zct.Event(zcf.RequestCreation, zcf.RequestCreation.getHandler);
        yue.on('requestTabView','click', zcf.RequestCreation.clickEvent.dispatch,
            zcf.RequestCreation.clickEvent, true);
        
        yue.on('draftForm','submit',zcf.RequestCreation.submitDraft);
        
        var index = zct.getElementsByName('currentTabIndex','input',yud.get('draftForm'))[0].value;
        if (!!index) zcf.RequestCreation.requestFormTabView.set('activeIndex',index);
      },
      
      getHandler : function(e) {
          var targetEl = yue.getTarget(e);
          tokens = targetEl.id.split('-');
          if (tokens.length > 1)
            return [tokens[0], zct.capitalize(tokens[1])].join('');
          else
            return tokens[0];
      },
      
      submitStep : function(e) { validateAndSubmit(e, false); },
      
      submitCollectionAdd : function(e) { validateAndSubmit(e, true); },
      
      submitCollectionModify : function(e) { validateAndSubmit(e, true); },
      
      submitDraft : function(e) {
        yue.stopEvent(e);
        var hd = zct.getElementsByName('currentTabIndex','input',yud.get('draftForm'))[0];
        hd.value = zcf.RequestCreation.requestFormTabView.get('activeIndex');
        yud.get('draftForm').submit();
      },
      
      prevTab : function(e) {
          yue.preventDefault(e);
          viewTab(-1);
      },
      
      nextTab : function(e) {
          yue.preventDefault(e);
          viewTab(1);
      }
    };
    
  }();
  
  yue.onDOMReady(zcf.RequestCreation.init);
  
}());

