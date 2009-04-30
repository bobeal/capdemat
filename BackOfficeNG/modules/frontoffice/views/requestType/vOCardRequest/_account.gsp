
<fieldset class="account-fieldset-edit">
  <h4><g:message code="homeFolder.property.responsibles" /></h4>

  <label class="required"><g:message code="homeFolder.property.responsible" /><span> (Vous devez choisir un responsable)</span>
  </label>
  <select name="homeFolderResponsible" class="required validate-not-first" title="<g:message code="homeFolder.property.responsible.validationError" />">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each var="it" in="${individuals?.adults}" status="index">
      <option value="${index}">${it.firstName} ${it.lastName}</option>
    </g:each>
  </select>
  
  <label><g:message code="homeFolder.property.tutors" /><span> (Vous pouvez choisir un ou plusieurs tuteurs)</span></label>
  <dl>
    <g:each var="it" in="${individuals?.children}" status="index">
    <dt>${it.fullName}</dt>
    <dd><input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'action.remove')}" /></dd>
    </g:each>
  </dl>
  <select name="homeFolderResponsibleTutor" class="validate-not-first">
  <option value=""><g:message code="message.select.defaultOption" /></option>
  <g:each var="it" in="${individuals?.adults}" status="index">
    <option value="${index}">${it.fullName}</option>
  </g:each>
  </select>

  <input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'action.add')}" />
  ou bien 
  <input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'homeFolder.action.addNewTutor')}" />
   
</fieldset>

<h3><g:message code="homeFolder.property.children" /></h3>
<g:each var="it" in="${individuals?.children}" status="index">
  <fieldset class="account-fieldset-edit">
  <h4>${it.fullName}</h4>
  
  <label><g:message code="homeFolder.child.property.legalResponsibles" /><span> (Vous devez choisir entre 1 et 3 responsables l&eacute;gaux)</span></label>
  <dl>
    <g:each var="tutor" in="${individuals?.children}">
    <dt>${tutor.fullName}</dt>
    <dd><input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'action.remove')}" /></dd>
    </g:each>
  </dl>
  
  <select name="homeFolderResponsibleTutor" class="validate-not-first">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each in="${individuals?.allRoleTypes}">
      <option value="${it}"><g:capdematEnumToField var="${it}" i18nKeyPrefix="homeFolder.role" /></option>
    </g:each>
  </select>
  
  <select name="homeFolderResponsibleTutor" class="validate-not-first">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each var="tutor" in="${individuals?.adults}" status="tutorIndex">
      <option value="${tutorIndex}">${tutor.fullName}</option>
    </g:each>
  </select>

  <input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'action.add')}" />
  ou bien 
  <input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'homeFolder.action.addNewTutor')}" />
        
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
    <g:each var="tutor" in="${individuals?.children}">
    <dt>${tutor.fullName}</dt>
    <dd><input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'action.remove')}" /></dd>
    </g:each>
  </dl>
  <select name="homeFolderResponsibleTutor" class="validate-not-first">
    <option value=""><g:message code="message.select.defaultOption" /></option>
    <g:each var="tutor" in="${individuals?.adults}" status="tutorIndex">
      <option value="${tutorIndex}">${tutor.fullName}</option>
    </g:each>
  </select>

  <input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'action.add')}" />
  ou bien 
  <input type="submit" id="submit-addRole-account-tutor" name="submit-addRole-account-tutor" value="${message(code:'homeFolder.action.addNewTutor')}" />
   
  
  </fieldset>
</g:each>

