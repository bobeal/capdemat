

  <g:set var="listSize" value="${rqt.activiteAssociation.size()}" />
  <h3>
    <a class="addListItem" id="add_activiteAssociation[${listSize}]"></a>
    <span><g:message code="sagr.property.activiteAssociation.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.activiteAssociation.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_activiteAssociation[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required">
    
      <dt class="required"><g:message code="sagr.property.nomActivite.label" /> * : </dt>
      <dd id="activiteAssociation[${listSize - 1 - index}].nomActivite" class="action-editField validate-string required-true i18n-sagr.property.nomActivite" >
        <span>${it?.nomActivite}</span>
      </dd>
    
      <dt class="required"><g:message code="sagr.property.nomFederationSportiveActivite.label" /> * : </dt>
      <dd id="activiteAssociation[${listSize - 1 - index}].nomFederationSportiveActivite" class="action-editField validate-string required-true i18n-sagr.property.nomFederationSportiveActivite" >
        <span>${it?.nomFederationSportiveActivite}</span>
      </dd>
    
      <dt class="required"><g:message code="sagr.property.numeroAffiliationActivite.label" /> * : </dt>
      <dd id="activiteAssociation[${listSize - 1 - index}].numeroAffiliationActivite" class="action-editField validate-string required-true i18n-sagr.property.numeroAffiliationActivite" >
        <span>${it?.numeroAffiliationActivite}</span>
      </dd>
    
      <dt class="required"><g:message code="sagr.property.nombreLicencieMineurActivite.label" /> * : </dt>
      <dd id="activiteAssociation[${listSize - 1 - index}].nombreLicencieMineurActivite" class="action-editField validate-long required-true i18n-sagr.property.nombreLicencieMineurActivite" >
        <span>${it?.nombreLicencieMineurActivite}</span>
      </dd>
    
      <dt class="required"><g:message code="sagr.property.nombreLicencieMajeurActivite.label" /> * : </dt>
      <dd id="activiteAssociation[${listSize - 1 - index}].nombreLicencieMajeurActivite" class="action-editField validate-long required-true i18n-sagr.property.nombreLicencieMajeurActivite" >
        <span>${it?.nombreLicencieMajeurActivite}</span>
      </dd>
    
      <dt class=""><g:message code="sagr.property.totalLicencieActivite.label" />  : </dt>
      <dd id="activiteAssociation[${listSize - 1 - index}].totalLicencieActivite" class="action-editField validate-long i18n-sagr.property.totalLicencieActivite" >
        <span>${it?.totalLicencieActivite}</span>
      </dd>
    
      <dt class=""><g:message code="sagr.property.sommeAlloueeActivite.label" />  : </dt>
      <dd id="activiteAssociation[${listSize - 1 - index}].sommeAlloueeActivite" class="action-editField validate-string i18n-sagr.property.sommeAlloueeActivite" >
        <span>${it?.sommeAlloueeActivite}</span>
      </dd>
    
  </dl>
  </g:each>
