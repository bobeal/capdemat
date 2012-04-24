<div id="ft">
  <a href="http://www.capwebct.fr/"><img src="${resource(dir:'images', file:'logo_capwebct_small.gif')}" alt="CapWebCT" style="float:left; margin: 0 0 1em;"/></a>
  <a href="http://europa.eu"><img src="${resource(dir:'images', file:'logoUE.png')}" alt="Projet cofinancé par l’Union Européenne (FEDER)" style="float:left; margin: 0 0 1em;"/></a>
  <span>${message(code:'message.capdemat')} ${grailsApplication.metadata['app.version']}</span>
  | <a href="${createLink(controller:'frontofficeHome', action:'browsers')}">${message(code:'home.header.browsers')}</a>
  | <a href="${createLink(controller:'frontofficeHome', action:'accessibilityPolicy')}">${message(code:'home.header.accessibilityPolicy')}</a>
  | <a href="${createLink(controller:'localAuthorityResource', action:'resource', id:'legal')}" target="blank">${message(code:'message.legalInformation')}</a>
</div>
