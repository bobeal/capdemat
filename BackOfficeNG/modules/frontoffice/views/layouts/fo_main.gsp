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
       <div id="hd-menu">
        <g:if test="${session.currentEcitizen}">
          <strong>${session.currentEcitizenName} &nbsp;</strong>
          <a href="${createLink(controller:'frontofficeHome',action:'logout')}" class="menu"><g:message code="action.logout" /></a>
        </g:if>
        <g:elseif test="${isLogin}">
          <form action="/BackOfficeNG/frontoffice/home/login" method="post" id="loginForm">
            <label for="login"><g:message code="account.property.login"/></label>
            <input type="text" class="text" name="login" id="login"/>
            <label for="password"><g:message code="account.property.password"/></label>
            <input type="password" class="text" name="password" id="password"/>
            <input type="submit" class="button" value="${message(code:'action.login')}"/>
            <a href="${createLink(controller : 'frontofficeHomeFolder', action:'resetPassword')}">
            <g:message code="account.message.forgottenPassword" />
            </a>
          </form>
        </g:elseif>
        <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'helpFo')}" class="menu" target="blank">Aide</a>
        <a href="${createLink(controller:'localAuthorityResource',action:'resource',id:'faqFo')}" class="menu" target="blank">FAQ</a>
       </div>
       <h1>
         <img src="${createLink(controller : 'localAuthorityResource', action : 'resource', id : 'logoFo')}"
              alt="Logo Collectivité" />
         <!-- <span>Vos démarches - ${session.currentSiteDisplayTitle}</span> -->
       </h1>
       <g:if test="${isLogin}">
       <div class="information-box outOfAccount-login-box">
            <div class="yui-gc">
              <div class="yui-u first">
                <p>En créant un compte, vous avez la possibilité de:</p>
                <ul>
                  <li>gérer vos données administratives et déclarer les membres de votre foyer,</li>
                  <li>accéder à des démarches en ligne pour vous ou un membre de votre foyer,</li>
                  <li>suivre l'avancement de vos demandes.</li>
                </ul>
              </div>
              <div class="yui-u">
                <a href="${createLink(controller:'frontofficeRequestCreation',params:['label':'VO Card'])}"
                   style="font-size: 1.7em;" />
                  Je souhaite créer mon compte
                </a>
              </div>
            </div>
          </div>
       </g:if>
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
