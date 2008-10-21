zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.requesttype');

(function() {
  
  var zct = zenexity.capdemat.tools;
  var zcc = zenexity.capdemat.common;
  var zcbrt = zenexity.capdemat.bong.request.templates;
  var zcbet = zenexity.capdemat.bong.editor.toolbars;
  var zcbrp = zenexity.capdemat.bong.requesttype;
  
  var yl = YAHOO.lang;
  var yu = YAHOO.util;
  var yue = YAHOO.util.Event;
  var yus = YAHOO.util.Selector;
  var ylj = YAHOO.lang.JSON;
  
  zcbrp.Conf = function() {
    //var init
    return {
      init : function() {
        var div = document.getElementById('request-type-forms');
        //console.debug(zct.siblings(div,function(n){zct.style(n,{display:'block'})}));
      },
      dispatchEvent : function(el) {
        zct.tryToCall(zcbrp.Conf.handlers[el.id])
      },
      switchView : function(containerId) {
        var el = yu.Dom.get(containerId);
        zct.siblings(div,function(n){zct.style(n,{display:'block'})});
        zcbrp.Conf.dispatchEvent(el);
      },
      handlers : {
        'request-type-forms': function(e){},
        'request-type-alerts': function(e){},
        'request-type-seasons' :function(e){}
      }
    }
  }();
  
  YAHOO.util.Event.onDOMReady(zcbrp.Conf.init);
  
  return;
  
  function initRequestTypeConfigure() {
    
    // Create our custom event and listeners to handle category selection
      YAHOO.capdematBo.requestTypeSubmenuSelectedEvent =
        new YAHOO.util.CustomEvent('requestTypeSubmenuSelectedEvent');
      YAHOO.capdematBo.requestTypeSubmenuSelectedEvent.subscribe(selectRequestTypeSubmenu);
      YAHOO.capdematBo.requestTypeSubmenuSelectedEvent.subscribe(loadRequestTypeSubmenu);
    
    function selectRequestTypeSubmenu(type, args) {
        zcc.switchSelectedItemDisplay(args[0], 'selected');
      }
      
      function switchAreas(currentSubmenu) {
          if (currentSubmenu === 'general') {
              YAHOO.util.Dom.removeClass(document.getElementById('requestTypeAlerts'), 'invisible');
              YAHOO.util.Dom.addClass(document.getElementById('requestTypeSeasons'), 'invisible');
          } else if (currentSubmenu === 'seasons') {
              YAHOO.util.Dom.removeClass(document.getElementById('requestTypeSeasons'), 'invisible');
              YAHOO.util.Dom.addClass(document.getElementById('requestTypeAlerts'), 'invisible');
          }
      }
      
      var handleLoadRequestTypeSubmenuFormSuccess = function(o) {
          
          var element = document.getElementById(o.argument[2]);
          element.innerHTML = o.responseText;
  
          if (o.argument[1] === 'general') {
            if (o.argument[2] === 'requestTypeAlerts') {
                 initRequestTypeAlerts(o.argument[0]);
            }
              switchAreas('general');
          } else if (o.argument [1] === 'seasons') {
            initRequestTypeSeasons(o.argument[0]);
              switchAreas('seasons');
          }   
      };
        
      function loadRequestTypeSubmenu(type, args) {
        var url;
        if (args[1] === 'general') {
          // general submenu is a special case : it contains three templates
          url = '/loadAlertsArea/' + args[2];
          zcc.doAjaxCall(url, [args[2], args[1], 'requestTypeAlerts'], handleLoadRequestTypeSubmenuFormSuccess);
        } else if (args[1] === 'seasons') {
          url = '/loadSeasonsArea/' + args[2];
          zcc.doAjaxCall(url, [args[2], args[1], 'requestTypeSeasons'], handleLoadRequestTypeSubmenuFormSuccess);
        }
      }
      
      // init submenu to general
      YAHOO.capdematBo.requestTypeSubmenuSelectedEvent.fire('requestType-general','general',
          zenexity.capdemat.bong.requesttype.currentId);
  }
  
  YAHOO.util.Event.onDOMReady(initRequestTypeConfigure);
  
  
  function fireRequestTypeSubmenuSelectedEvent(submenuId,menuKey,requestTypeId) {
      YAHOO.capdematBo.requestTypeSubmenuSelectedEvent.fire(submenuId,menuKey,requestTypeId);
  }
  
  
}());