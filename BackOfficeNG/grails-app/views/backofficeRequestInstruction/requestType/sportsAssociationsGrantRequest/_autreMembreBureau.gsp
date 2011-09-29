

  <g:set var="listSize" value="${rqt.autreMembreBureau.size()}" />
  <h3>
    <a class="addListItem" id="add_autreMembreBureau[${listSize}]"></a>
    <span><g:message code="sagr.property.autreMembreBureau.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.autreMembreBureau.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_autreMembreBureau[${listSize - 1 - index}]"></a>
  </div>
  <dl class="">
    
      <dt class="required"><g:message code="sagr.property.roleMembre.label" /> * : </dt>
      <dd id="autreMembreBureau[${listSize - 1 - index}].roleMembre" class="action-editField validate-capdematEnum required-true i18n-sagr.property.roleMembre javatype-fr.cg95.cvq.business.request.social.SagrRoleAssociationType" >
        <g:capdematEnumToField var="${it?.roleMembre}" i18nKeyPrefix="sagr.property.roleMembre" />
      </dd>
    
      <dt class="required"><g:message code="sagr.property.nomMembre.label" /> * : </dt>
      <dd id="autreMembreBureau[${listSize - 1 - index}].nomMembre" class="action-editField validate-lastName required-true i18n-sagr.property.nomMembre maxLength-38" >
        <span>${it?.nomMembre}</span>
      </dd>
    
      <dt class="required"><g:message code="sagr.property.prenomMembre.label" /> * : </dt>
      <dd id="autreMembreBureau[${listSize - 1 - index}].prenomMembre" class="action-editField validate-firstName required-true i18n-sagr.property.prenomMembre maxLength-38" >
        <span>${it?.prenomMembre}</span>
      </dd>
    
      <dt class=""><g:message code="sagr.property.telephoneMembre.label" />  : </dt>
      <dd id="autreMembreBureau[${listSize - 1 - index}].telephoneMembre" class="action-editField validate-phone i18n-sagr.property.telephoneMembre maxLength-10" >
        <span>${it?.telephoneMembre}</span>
      </dd>
    
      <dt class=""><g:message code="sagr.property.emailMembre.label" />  : </dt>
      <dd id="autreMembreBureau[${listSize - 1 - index}].emailMembre" class="action-editField validate-email i18n-sagr.property.emailMembre" >
        <span>${it?.emailMembre}</span>
      </dd>
    
  </dl>
  </g:each>
