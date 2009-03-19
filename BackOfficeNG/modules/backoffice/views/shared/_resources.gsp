
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" />
  <!-- Grid and common settings CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/backoffice/yui/reset-fonts-grids',file:'reset-fonts-grids.css')}" />
  <!-- Button CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/backoffice/yui/button',file:'button.css')}" />
  <!-- Dialog Container CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/backoffice/yui/container',file:'container.css')}" />
  <!-- Tabview CSS -->
  <link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/yui/tabview',file:'tabview.css')}" /> 
  <!-- Calendar CSS -->
  <link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css/backoffice/yui/calendar',file:'calendar.css')}" />

  <!-- BONG CSS -->
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common',file:'layout.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common',file:'box.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/common',file:'tag.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common',file:'form.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common',file:'list.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common',file:'panel.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common/yui-skin',file:'tabview.css')}" />
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/common/yui-skin',file:'button.css')}" />
  
  <!--[if IE 6]>
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/hacks',file:'ie6.css')}" />
  <![endif]-->
  <!--[if IE 7]>
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/hacks',file:'ie6.css')}" />  
  <link rel="stylesheet" href="${createLinkTo(dir:'css/backoffice/hacks',file:'ie7.css')}" />
  <![endif]-->

  <!-- Utilities --> 
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/utilities',file:'utilities.js')}"></script>
  <!-- Button -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/button',file:'button-min.js')}"></script>
  <!-- Dialog Container -->
  <script type="text/javascript" src="${createLinkTo(dir:'js/yui/container',file:'container-min.js')}"></script> 
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
  <script type="text/javascript" src="${createLinkTo(dir:'js/common', file:'aspect.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'common.js')}"></script>
  <script type="text/javascript" src="${createLinkTo(dir:'js/common',file:'validation.js')}"></script>
  
  <script type="text/javascript">
    zenexity.capdemat.tools.namespace('zenexity.capdemat.bong');
    zenexity.capdemat.bong.currentMenu = "${session['currentMenu']}";
    zenexity.capdemat.baseUrl = '<g:createLink controller="${webRequest.controllerName}" />';
    zenexity.capdemat.contextPath = '${request.contextPath}';
  </script>
  
  
  
