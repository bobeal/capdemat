

  <g:set var="listSize" value="${rqt.familyAssistanceMembers.size()}" />
  <h3>
    <a class="addListItem" id="add_familyAssistanceMembers[${listSize}]"></a>
    <span><g:message code="hcar.property.familyAssistanceMembers.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.familyAssistanceMembers.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_familyAssistanceMembers[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required condition-isFamilyAssistance-filled">
    
      <dt class="required"><g:message code="hcar.property.familyAssistanceMemberRelationship.label" /> * : </dt>
      <dd id="familyAssistanceMembers[${listSize - 1 - index}].familyAssistanceMemberRelationship" class="action-editField validate- required-true i18n-hcar.property.familyAssistanceMemberRelationship maxLength-60" >
        <span>${it?.familyAssistanceMemberRelationship}</span>
      </dd>
    
      <dt class="required"><g:message code="hcar.property.familyAssistanceMemberLastName.label" /> * : </dt>
      <dd id="familyAssistanceMembers[${listSize - 1 - index}].familyAssistanceMemberLastName" class="action-editField validate-lastName required-true i18n-hcar.property.familyAssistanceMemberLastName maxLength-38" >
        <span>${it?.familyAssistanceMemberLastName}</span>
      </dd>
    
      <dt class="required"><g:message code="hcar.property.familyAssistanceMemberFirstName.label" /> * : </dt>
      <dd id="familyAssistanceMembers[${listSize - 1 - index}].familyAssistanceMemberFirstName" class="action-editField validate-firstName required-true i18n-hcar.property.familyAssistanceMemberFirstName maxLength-38" >
        <span>${it?.familyAssistanceMemberFirstName}</span>
      </dd>
    
  </dl>
  </g:each>
