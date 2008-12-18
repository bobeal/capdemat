<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-Transitional.dtd">
<%@ taglib prefix="g" uri="/BackOfficeNG/web-app/WEB-INF/tld/grails.tld" %>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title><g:layoutTitle default="CapDémat monitoring" /></title>
    <g:render template="/shared/mn_resources" />
    <g:layoutHead />
  </head>
  <body>
  
    <div id="doc4" class="yui-t4 yui-skin-sam">
      
      <!-- header -->
      <div id="hd">
        <g:render template="/shared/mn_menu" />
      </div>
      
      <!-- body -->
      <div id="bd">
        <div id="errorMessages" class="invisible"></div>
        <!-- main content area -->
          <g:layoutBody />
      </div>

      <!-- footer -->
      <div id="ft">
        <a href="http://www.zenexity.fr">Conçu et réalisé par Zenexity R&D</a>
        <p>
          Le contenu de ce site est la propriété intellectuelle exclusive de Zenexity.<br/>
          Toute réutilisation de tout ou partie du contenu de ce site est strictement interdite.
        </p>
      </div>

    </div>
    
  </body>
</html>
