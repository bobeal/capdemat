<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>CapDémat Lab - FrontOfficeNG</title>
    <g:render template="/shared/fong_resources" />
    <g:layoutHead />
  </head>
  <body>
  
   <div id="doc4" class="yui-t4 yui-skin-fong">
   
     <!-- header -->
     <div id="hd">
       <h1>
         <img src="${createLinkTo(dir:'images/frontoffice',file:'logo_zen_200.png')}" alt="Zenexity Lab" />
         <span>CapDémat - FrontOffice NG</span>
       </h1>
       <map id="hd-menu">
        <g:if test="${!login}">
        <a href="#">se déconnecter</a>
        </g:if>
        <a href="#">aide</a>
        <a href="#">f.a.q</a> 
       </map>
     </div>

     <g:if test="${!login}">
       <div id="main-menu">
         <a href="${createLink(controller:'frontofficeHome')}" 
            class="${menu.current(elem:'home')}" >
            <span>
              <g:message code="menu.home" />
            </span>
         </a>
         <a href="${createLink(controller:'frontofficeRequestType')}" 
            class="${menu.current(elem:'requesttype')}" >
            <span>
              <g:message code="menu.services" />
            </span>
         </a>
         <a href="${createLink(controller:'frontofficeHomeFolder')}" 
            class="${menu.current(elem:'homefolder')}" >
            <span>
              <g:message code="menu.accounts" />
            </span>
         </a>
         <a href="${createLink(controller:'frontofficeRequest')}" 
           class="${menu.current(elem:'request')}">
           <span>
             <g:message code="menu.requests" />
           </span>
         </a>
         <a href="${createLink(controller:'frontofficeDocument')}" 
            class="${menu.current(elem:'document')}">
            <span>
              <g:message code="menu.documents" />
            </span>
         </a>
         <a href="${createLink(controller:'frontofficeActivity')}" 
            class="${menu.current(elem:'activity')}">
            <span>
              <g:message code="menu.activities" />
            </span>
         </a>
         <a href="${createLink(controller:'frontofficePayment')}" 
            class="${menu.current(elem:'payment')}" >
            <span>
              <g:message code="menu.payments" />
            </span>
         </a>
       </div>
     </g:if>
     
     <!-- header -->
     <div id="bd">
       <g:layoutBody />
     </div> <!-- end bd  -->
     
   <!-- footer -->
   <div id="ft">
     <a href="http://www.zenexity.fr">Conçu et réalisé par Zenexity</a>
   </div>
   
   <!-- hack to avoid seeing zct.notifier div -->
   <div class="yui-skin-sam"></div>
   
   </div> <!-- end doc -->
 
  </body>
</html>


