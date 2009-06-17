<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>CapDémat - FrontOffice</title>
    <g:render template="/shared/fo_resources" />
    <g:layoutHead />
  </head>
  <body>
  
   <div id="doc4" class="yui-t4 yui-skin-fong">
   
     <!-- header -->
     <div id="hd">
       <h1>
         <img src="${createLink(controller : 'localAuthorityResource', action : 'resource', id : 'logoFo')}"
              alt="Logo Collectivité" />
         <!-- <span>Vos démarches - ${session.currentSiteDisplayTitle}</span> -->
       </h1>
       <map id="hd-menu">
        <g:if test="${session.currentEcitizen}">
          <strong>${session.currentEcitizenName} &nbsp;</strong>
          <a href="${createLink(controller:'frontofficeHome',action:'logout')}"><g:message code="action.logout" /></a>
        </g:if>
        <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'helpFo')}"
           target="blank">Aide</a>
        <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'faqFo')}"
           target="blank">FAQ</a>
       </map>
     </div>
     <g:render template="/shared/menus/menu_${session.frontContext ? session.frontContext.value.toLowerCase() : 'unauth_ecitizen' }"/>
     
     <!-- header -->
     <div id="bd">
       <g:layoutBody />
     </div> <!-- end bd  -->
     
   <!-- footer -->
   <div id="ft">
     <a href="http://www.capwebct.fr/">
       <img src="${createLinkTo(dir:'images',file:'logo_capwebct_small.gif')}"
            alt="CapWebCT"
            style="float:left; margin: 0 0 1em;" />
     </a>
     <a href="http://europa.eu">
       <img src="${createLinkTo(dir:'images',file:'logoUE.png')}"
            alt="Projet cofinancé par l’Union Européenne (FEDER)"
            style="float:left; margin: 0 0 1em;" />
     </a>
     <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'legal')}"
        target="blank">Mentions légales</a>
   </div>
   
   <!-- hack to avoid seeing zct.notifier div -->
   <div class="yui-skin-sam"></div>
   
   </div> <!-- end doc -->
 
  </body>
</html>
