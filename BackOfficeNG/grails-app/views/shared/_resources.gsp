  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" />
  <!-- Grid and common settings CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/yui/reset-fonts-grids',file:'reset-fonts-grids.css')}" />
  <!-- Button CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/yui/button',file:'button.css')}" />
  <!-- Dialog Container CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/yui/container',file:'container.css')}" />
  <!-- Datatable CSS -->
  <link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css/yui/datatable',file:'datatable.css')}" />
  <!-- Tabview CSS -->
  <link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css/yui/tabview',file:'tabview.css')}" /> 
  <!-- Calendar CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/yui/calendar',file:'calendar.css')}" />

  <!-- BONG CSS -->
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common',file:'layout.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common',file:'box.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common',file:'tag.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common',file:'form.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common',file:'list.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common',file:'panel.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common/yui-skin',file:'tabview.css')}" />
  
  <!--[if IE 6]>
  <link rel="stylesheet" href="${createLinkTo(dir:'css/hacks',file:'ie6.css')}" />
  <![endif]-->

  <!-- Dependency for Connection Manager / Also provides YAHOO Global Object -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/yahoo',file:'yahoo-min.js')}"></script>
  <!-- Dependencies for Dialog Container, Button, Menu, Datatable, Tabview -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/yahoo-dom-event',file:'yahoo-dom-event.js')}"></script>
  <!-- Dependencie for Dialog Container, Drag and Drop -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/dragdrop',file:'dragdrop-min.js')}"></script>
  <!-- Dependencies for Button, Datatable, Tabview -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/element',file:'element-beta-min.js')}"></script>
  <!-- Used for Custom Events and event listener bindings (Connection Manager) -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/event',file:'event-min.js')}"></script>
  <!-- Used for asynchronous submissions (Connection Manager) -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/connection',file:'connection-min.js')}"></script>
  <!-- Button -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/button',file:'button-min.js')}"></script>
  <!-- Dependency for Container (Animation of simple dialogs) --> 
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/animation',file:'animation-min.js')}"></script>
  <!-- Dialog Container -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/container',file:'container-min.js')}"></script>
  <!-- Utilities --> 
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/utilities',file:'utilities.js')}"></script> 
  <!-- Depedency for Datatable -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/datasource',file:'datasource-beta-min.js')}"></script>
  <!-- Datatable -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/datatable',file:'datatable-beta-min.js')}"></script>
  <!-- safe JSON parsing -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/json',file:'json-min.js')}"></script> 
  <!-- Tabview -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/tabview',file:'tabview-min.js')}"></script> 
  <!-- Calendar -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/calendar',file:'calendar-min.js')}"></script>
  <!-- Selector -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/selector',file:'selector-beta-min.js')}"></script>

  <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'tools.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'common.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'validation.js')}"></script>
  
  <script type="text/javascript">
    zenexity.capdemat.tools.namespace('zenexity.capdemat.bong');
    zenexity.capdemat.bong.currentMenu = "${session['currentMenu']}";
    zenexity.capdemat.bong.baseUrl = '<g:createLink controller="${webRequest.controllerName}" />';
  </script>
