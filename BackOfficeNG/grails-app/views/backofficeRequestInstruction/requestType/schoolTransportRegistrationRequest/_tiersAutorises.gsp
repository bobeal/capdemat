

  <g:set var="listSize" value="${rqt.tiersAutorises.size()}" />
  <h3>
    <a class="addListItem" id="add_tiersAutorises[${listSize}]"></a>
    <span><g:message code="strr.property.tiersAutorises.label" /></span>
  </h3>
  <g:each var="it" in="${rqt.tiersAutorises.reverse()}" status="index">
  <div class="collection-action">
    <a class="deleteListItem" id="delete_tiersAutorises[${listSize - 1 - index}]"></a>
  </div>
  <dl class="required condition-autoriseTiers-filled">
    
      <dt class="required"><g:message code="strr.property.tiersNom.label" /> * : </dt>
      <dd id="tiersAutorises[${listSize - 1 - index}].tiersNom" class="action-editField validate-lastName required-true i18n-strr.property.tiersNom maxLength-38" >
        <span>${it?.tiersNom}</span>
      </dd>
    
      <dt class="required"><g:message code="strr.property.tiersPrenom.label" /> * : </dt>
      <dd id="tiersAutorises[${listSize - 1 - index}].tiersPrenom" class="action-editField validate-firstName required-true i18n-strr.property.tiersPrenom maxLength-38" >
        <span>${it?.tiersPrenom}</span>
      </dd>
    
      <dt class="required"><g:message code="strr.property.tiersTelephone.label" /> * : </dt>
      <dd id="tiersAutorises[${listSize - 1 - index}].tiersTelephone" class="action-editField validate-phone required-true i18n-strr.property.tiersTelephone maxLength-10" >
        <span>${it?.tiersTelephone}</span>
      </dd>
    
  </dl>
  </g:each>
