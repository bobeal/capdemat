

  <g:set var="listSize" value="${request.familyDependents.size()}" />
  <h3>
    <a class="addListItem" id="add_familyDependents[${listSize}]"></a>
    <span><g:message code="hccr.property.familyDependents.label" /></span>
  </h3>
  <g:each var="it" in="${request.familyDependents.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_familyDependents[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required condition-isReferentFamilyDependents-filled">
    
      <dt class="required"><g:message code="hccr.property.referentFamilyDependentLastName.label" /> * : </dt>
      <dd id="familyDependents[${listSize - 1 - index}].referentFamilyDependentLastName" class="action-editField validate-lastName required-true i18n-hccr.property.referentFamilyDependentLastName maxLength-38" >
        <span>${it?.referentFamilyDependentLastName}</span>
      </dd>
    
      <dt class="required"><g:message code="hccr.property.referentFamilyDependentFirstName.label" /> * : </dt>
      <dd id="familyDependents[${listSize - 1 - index}].referentFamilyDependentFirstName" class="action-editField validate-firstName required-true i18n-hccr.property.referentFamilyDependentFirstName maxLength-38" >
        <span>${it?.referentFamilyDependentFirstName}</span>
      </dd>
    
      <dt class="required"><g:message code="hccr.property.referentFamilyDependentBirthDate.label" /> * : </dt>
      <dd id="familyDependents[${listSize - 1 - index}].referentFamilyDependentBirthDate" class="action-editField validate-date required-true i18n-hccr.property.referentFamilyDependentBirthDate" >
        <span><g:formatDate formatName="format.date" date="${it?.referentFamilyDependentBirthDate}"/></span>
      </dd>
    
      <dt class="required"><g:message code="hccr.property.referentFamilyDependentActualSituation.label" /> * : </dt>
      <dd id="familyDependents[${listSize - 1 - index}].referentFamilyDependentActualSituation" class="action-editField validate-capdematEnum required-true i18n-hccr.property.referentFamilyDependentActualSituation javatype-fr.cg95.cvq.business.request.social.HccrReferentFamilyDependentActualSituationType" >
        <g:capdematEnumToField var="${it?.referentFamilyDependentActualSituation}" i18nKeyPrefix="hccr.property.referentFamilyDependentActualSituation" />
      </dd>
    
  </dl>
  </g:each>
