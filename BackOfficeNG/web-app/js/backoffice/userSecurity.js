(function(){
  var zcb = zenexity.capdemat.bong;
  var zcc = zenexity.capdemat.common;
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  var yue = YAHOO.util.Event;

  zcb.UserSecurity = function() {

    return {
      clickEvent : undefined,

      init: function() {
        zcb.UserSecurity.clickEvent = new zct.Event(zcb.UserSecurity, zcb.UserSecurity.getHandler);
        yue.on('agents','click', zcb.UserSecurity.clickEvent.dispatch, zcb.UserSecurity.clickEvent, true);
      },

      getHandler: function(e) {
        return yue.getTarget(e).className.split(' ')[0]; 
      },

      view: function(e) {
        var target = yue.getTarget(e);
        zct.doAjaxCall('/agents?view=' + target.className.split(' ')[1],[],function(o){
          yud.get('agents').innerHTML = o.responseText;
        });
      },

      configure: function(e) {
        var target = yue.getTarget(e);
        var li = yud.getAncestorByTagName(target, 'li');
        if (yud.getLastChild(li).nodeName === 'FORM') return;
        zct.doAjaxCall('/agent/' + li.id.split('_')[1],[],function(o){
          li.innerHTML += o.responseText;
        });
      },

      cancel: function(e) {
        var target = yue.getTarget(e);
        var form = yud.getAncestorByTagName(target, 'form');
        form.parentNode.removeChild(form);
      },

      allow: function(e) {
        var target = yue.getTarget(e);
        var form = yud.getAncestorByTagName(target, 'form');
        zct.doAjaxFormSubmitCall (form.getAttribute('id'), [], function(o) {
          var newProfile = yud.getPreviousSibling(yus.query('input:checked', form)[0]).innerHTML;
          var li = form.parentNode;
          li.removeChild(form);
          li.removeChild(yud.getLastChild(li));
          li.innerHTML += newProfile;
          yud.removeClass(li, 'notBelong');
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, li);
        });
      },

      disallow: function(e) {
        var target = yue.getTarget(e);
        var li = yud.getAncestorByTagName(target, 'li');
        zct.doAjaxCall('/disallow/' + li.id.split('_')[1], [], function(o){
          yud.addClass(yud.getLastChild(li), 'invisible');
          yud.addClass(li, 'notBelong');
          var json = ylj.parse(o.responseText);
          zct.Notifier.processMessage(json.status, json.message, null, li);  
        });
      }

    };

  }();

  YAHOO.util.Event.onDOMReady(zcb.UserSecurity.init);

}());
