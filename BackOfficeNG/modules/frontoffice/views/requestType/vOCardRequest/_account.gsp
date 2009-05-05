
<fieldset class="account-fieldset-edit">
  <h4><g:message code="homeFolder.property.responsibles" /></h4>

  <label class="required"><g:message code="homeFolder.property.responsible" /> * <span> (Vous devez choisir un responsable)</span></label>
  <input type="hidden" name="role-homeFolderResponsible" value="HomeFolderResponsible" />
  <select name="owner-homeFolderResponsible" class="required validate-not-first" title="<g:message code="homeFolder.property.responsible.validationError" />">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each var="owner" in="${individuals?.adults}" status="index">
      <option value="${index}" ${individuals.isLegalsResponsible(owner) ? 'selected="selected"' : ''}>
        ${owner.fullName}
      </option>
    </g:each>
  </select>
  <input type="submit" name="submit-addRole-account-homeFolderResponsible" value="${message(code:'action.save')}" />

  <label><g:message code="homeFolder.property.tutors" /><span> (Vous pouvez choisir un ou plusieurs tuteurs)</span></label>
  <dl>
    <g:each var="owner" in="${individuals.getRoleOwnersOnHomeFolder()}">
   <dt>
      <g:capdematEnumToFlag var="${owner.value.role}" i18nKeyPrefix="homeFolder.role" /> 
      ${owner.value.owner.fullName}
    </dt>
    <dd><input type="submit" name="submit-removeRole-account-ownerIndex:${owner.key}_role:${owner.value.role}" value="${message(code:'action.remove')}" /></dd>
    </g:each>
  </dl>
  <input type="hidden" name="role-homeFolderTutor" value="Tutor" />
  <select name="owner-homeFolderTutor" class="validate-not-first">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each var="owner" in="${individuals?.adults}" status="ownerIndex">
      <option value="${ownerIndex}">${owner.fullName}</option>
    </g:each>
  </select>
  <input type="submit" name="submit-addRole-account-homeFolderTutor" value="${message(code:'action.add')}" />
  <p>
    Vous pouvez créer un nouveau tuteur
    <input type="submit" name="submit-addRole-account-tutor" value="${message(code:'homeFolder.action.addNewTutor')}" />
  </p>
</fieldset>

<h3><g:message code="homeFolder.property.children" /></h3>
<g:each var="it" in="${individuals?.children}" status="index">
  <fieldset class="account-fieldset-edit">
  <h4>${it.fullName}</h4>
  
  <label><g:message code="homeFolder.child.property.legalResponsibles" /><span> (Vous devez choisir entre 1 et 3 responsables l&eacute;gaux)</span></label>
  <dl>
    <g:each var="owner" in="${individuals.getRoleOwnersOnIndividual(it.fullName)}">
    <dt>
      <g:capdematEnumToFlag var="${owner.value.role}" i18nKeyPrefix="homeFolder.role" /> 
      ${owner.value.owner.fullName}
    </dt>
    <dd><input type="submit" name="submit-removeRole-account-ownerIndex:${owner.key}_role:${owner.value.role}_individualIndex:${index}_individualType:children" value="${message(code:'action.remove')}" /></dd>
    </g:each>
  </dl>
  
  <select name="role-individualIndex:${index}_individualType:children" class="validate-not-first">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each in="${individuals?.childRoleTypes}">
      <option value="${it}"><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.role" /></option>
    </g:each>
  </select>
  
  <select name="owner-individualIndex:${index}_individualType:children" class="validate-not-first">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each var="owner" in="${individuals?.adults}" status="ownerIndex">
      <option value="${ownerIndex}">${owner.fullName}</option>
    </g:each>
  </select>

  <input type="submit" name="submit-addRole-account-individualIndex:${index}_individualType:children" value="${message(code:'action.add')}" />
  <p>
    Vous pouvez créer un nouveau tuteur
    <input type="submit" name="submit-addRole-account-tutor" value="${message(code:'homeFolder.action.addNewTutor')}" />
  </p>      
  </fieldset>
</g:each>

<h3><g:message code="homeFolder.property.adults" /></h3>
<g:each var="it" in="${individuals?.adults}" status="index">
  <fieldset class="account-fieldset-edit">
  <h4>
    <g:capdematEnumToField var="${it.title}" i18nKeyPrefix="homeFolder.adult.title" /> ${it.fullName}
  </h4>
  
  <label><g:message code="homeFolder.adult.property.tutors" /><span> (Vous pouvez choisir un ou plusieurs tuteurs)</span></label>
  <dl>
    <g:each var="owner" in="${individuals.getRoleOwnersOnIndividual(it.fullName)}">
    <dt>
      <g:capdematEnumToFlag var="${owner.value.role}" i18nKeyPrefix="homeFolder.role" /> 
      ${owner.value.owner.fullName}
    </dt>
    <dd><input type="submit" name="submit-removeRole-account-ownerIndex:${owner.key}_role:${owner.value.role}_individualIndex:${index}_individualType:adults" value="${message(code:'action.remove')}" /></dd>
    </g:each>
  </dl>
  
  <input type="hidden" name="role-individualIndex:${index}_individualType:adults" value="Tutor" />
  <select name="owner-individualIndex:${index}_individualType:adults" class="validate-not-first">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each var="owner" in="${individuals?.adults}" status="ownerIndex">
      <option value="${ownerIndex}">${owner.fullName}</option>
    </g:each>
  </select>

  <input type="submit" name="submit-addRole-account-individualIndex:${index}_individualType:adults" value="${message(code:'action.add')}" />
  <p>
    Vous pouvez créer un nouveau tuteur
    <input type="submit" name="submit-addRole-account-" value="${message(code:'homeFolder.action.addNewTutor')}" />
  </p> 
  
  </fieldset>
</g:each>

