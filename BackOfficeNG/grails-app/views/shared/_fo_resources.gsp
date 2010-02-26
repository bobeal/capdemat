<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" />
<!-- yui -->
<link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/yui/reset-fonts-grids', file:'reset-fonts-grids.css')}" />
<link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/yui/tabview', file:'tabview.css')}" />
<link rel="stylesheet" type="text/css" href="${resource(dir:'css/backoffice/yui/container',file:'container.css')}" />
<link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common/yui-skin', file:'tabview.css')}" />
<link rel="stylesheet" type="text/css" href="${resource(dir:'css/common',file:'tag.css')}" />
<link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'layout.css')}" />
<link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'box.css')}" />
<link rel="stylesheet" type="text/css" href="${createLink(controller : 'localAuthorityResource', action : 'resource', id : 'cssFo')}" />
<!--[if IE 6]>
<link rel="stylesheet" href="${resource(dir:'css/frontoffice/hacks',file:'ie6.css')}" />
<![endif]-->
<!--[if IE 7]>
<link rel="stylesheet" href="${resource(dir:'css/frontoffice/hacks',file:'ie7.css')}" />
<![endif]-->
<!-- Dependencies for tabview and button and probably our own scripts -->
<script type="text/javascript" src="${resource(dir:'js/yui/utilities',file:'utilities.js')}"></script>
<!-- Dependency for tools / FIXME : should not be required for FO -->
<script type="text/javascript" src="${resource(dir:'js/yui/container',file:'container-min.js')}"></script>
<!-- Selector -->
<script type="text/javascript" src="${resource(dir:'js/yui/selector',file:'selector-min.js')}"></script>
<!-- Json -->
<script type="text/javascript" src="${resource(dir:'js/yui/json',file:'json-min.js')}"></script>
<!-- Directly used scripts -->
<script type="text/javascript" src="${resource(dir:'js/yui/tabview', file:'tabview-min.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/common', file:'tools.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/common', file:'validation.js')}"></script>
<script type="text/javascript" src="${resource(dir:'js/common', file:'validationRules.js')}"></script>
<g:if test="${Locale.FRENCH.getLanguage().equals(request.locale.getLanguage())}">
  <script type="text/javascript" src="${resource(dir:'js/common', file:'date-fr-FR.js')}"></script>
</g:if>
<g:else>
  <script type="text/javascript" src="${resource(dir:'js/common', file:'date-en-US.js')}"></script>
</g:else>
<script type="text/javascript">
  zenexity.capdemat.tools.namespace('zenexity.capdemat.fong');
  zenexity.capdemat.baseUrl = '<g:createLink controller="${webRequest.controllerName}" />';
</script>
