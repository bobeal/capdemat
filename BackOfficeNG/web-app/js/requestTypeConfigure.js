(function() {
  var zcc = zenexity.capdemat.common;
  
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
              YAHOO.util.Dom.removeClass(document.getElementById('requestTypeForms'), 'invisible');
              YAHOO.util.Dom.removeClass(document.getElementById('requestTypeAlerts'), 'invisible');
              YAHOO.util.Dom.addClass(document.getElementById('requestTypeSeasons'), 'invisible');
          } else if (currentSubmenu === 'seasons') {
              YAHOO.util.Dom.removeClass(document.getElementById('requestTypeSeasons'), 'invisible');
              YAHOO.util.Dom.addClass(document.getElementById('requestTypeForms'), 'invisible');
              YAHOO.util.Dom.addClass(document.getElementById('requestTypeAlerts'), 'invisible');
          }
      }
      
      var handleLoadRequestTypeSubmenuFormSuccess = function(o) {
          
          var element = document.getElementById(o.argument[2]);
          element.innerHTML = o.responseText;
  
          if (o.argument[1] === 'general') {
            if (o.argument[2] === 'requestTypeForms') {
                 initRequestTypeForms(o.argument[0]);
            } else if (o.argument[2] === 'requestTypeAlerts') {
                 initRequestTypeAlerts(o.argument[0]);
            }
              switchAreas('general');
          } else if (o.argument[1] === 'documents') { 
            initRequestTypeDocuments(o.argument[0]);
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
            url = '/loadFormsArea/' + args[2];
            zcc.doAjaxCall(url, [args[2], args[1], 'requestTypeForms'],handleLoadRequestTypeSubmenuFormSuccess);  			
        } else if (args[1] === 'seasons') {
            url = '/loadSeasonsArea/' + args[2];
            zcc.doAjaxCall(url, [args[2], args[1], 'requestTypeSeasons'], handleLoadRequestTypeSubmenuFormSuccess);
        }
      }
      
      // init submenu to general
      YAHOO.capdematBo.requestTypeSubmenuSelectedEvent.fire('requestType-general','general',
          YAHOO.capdematBo.requestTypeId);
  }
  
  YAHOO.util.Event.onDOMReady(initRequestTypeConfigure);
  
  function fireRequestTypeSubmenuSelectedEvent(submenuId,menuKey,requestTypeId) {
      YAHOO.capdematBo.requestTypeSubmenuSelectedEvent.fire(submenuId,menuKey,requestTypeId);
  }
}());