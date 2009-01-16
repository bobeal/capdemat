
// next Links
var activeNextTabByLink = function(e) {
  YAHOO.util.Event.preventDefault(e);
  var requestFormTabView = new YAHOO.widget.TabView('requestTabView');
  var activeTabIndex = requestFormTabView.get('activeIndex');
  requestFormTabView.set('activeIndex' , activeTabIndex + 1);
}

YAHOO.util.Event.addListener(
    YAHOO.util.Dom.getElementsByClassName("nextTab", "a" ),
    "click", 
    activeNextTabByLink
);

// prev Links
var activePrevTabByLink = function(e) {
  YAHOO.util.Event.preventDefault(e);
  var requestFormTabView = new YAHOO.widget.TabView('requestTabView');
  var activeTabIndex = requestFormTabView.get('activeIndex');
  requestFormTabView.set('activeIndex' , activeTabIndex - 1);
}

YAHOO.util.Event.addListener(
    YAHOO.util.Dom.getElementsByClassName("prevTab", "a" ),
    "click", 
    activePrevTabByLink
);


function onSubmitClick(ev, formId) {
    document.getElementById(formId).submit();
}

function resetFormErrors(formErrors) { 
YAHOO.util.Dom.get(formErrors).innerHTML = '';
}

// Request TabView Initialization
function initRequest() {
  var requestFormTabView = new YAHOO.widget.TabView('requestTabView');
}

YAHOO.util.Event.onDOMReady(initRequest);

