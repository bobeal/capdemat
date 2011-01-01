
  <input type="hidden" name="homeFolderId" value="${individuals?.homeFolderId}" />
  <fieldset class="individual edit summary-box validation-scope">
    <g:if test="${individuals.getHomeFolderResponsibles(individuals?.adults).size() > 0}">
      <dl>
      <g:each var="roleOwner" in="${individuals.getHomeFolderResponsibles(individuals?.adults)}">
        <dt>
          <g:capdematEnumToFlag var="${roleOwner.role}" i18nKeyPrefix="homeFolder.role" /> 
          ${roleOwner.owner.fullName}
        </dt>
        <dd><input type="submit" name="submit-removeRole-account-ownerType:adults_ownerIndex:${roleOwner.index}_role:${roleOwner.role}" value="${message(code:'action.remove')}" /></dd>
      </g:each>
      </dl>
    </g:if>
    
    <p>${message(code:'homeFolder.property.responsible.help')}</p>
    <dl class="role-add">
      <dt>
        <label for="owner-homeFolderResponsible_ownerType:adults" class="required"><g:message code="homeFolder.property.responsible" /> * </label>
      </dt>
      <dd> 
        <input type="hidden" name="role-homeFolderResponsible_ownerType:adults" value="HomeFolderResponsible" />
        <select id="owner-homeFolderResponsible_ownerType:adults" name="owner-homeFolderResponsible_ownerType:adults" class="required validate-not-first" title="<g:message code="homeFolder.property.responsible.validationError" />">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each var="owner" in="${individuals?.adults}" status="index">
            <option value="${index}" ${individuals.isLegalsResponsible(owner) ? 'selected="selected"' : ''}>
              ${owner.fullName}
            </option>
          </g:each>
        </select>
        <input type="submit" name="submit-addRole-account-homeFolderResponsible_ownerType:adults" value="${message(code:'action.add')}" />
      </dd>
    </dl>
  </fieldset>
  
  <g:if test="${displayTutorsInAccountCreation}">
  <fieldset class="individual edit  summary-box validation-scope">
    <g:if test="${individuals.getHomeFolderTutors(individuals?.adults).size() + individuals.getHomeFolderTutors(individuals?.foreignAdults).size() > 0}">
      <dl>
      <g:each var="roleOwner" in="${individuals.getHomeFolderTutors(individuals?.adults)}">
        <dt>
          <g:capdematEnumToFlag var="${roleOwner.role}" i18nKeyPrefix="homeFolder.role" /> 
          ${roleOwner.owner.fullName}
        </dt>
        <dd><input type="submit" name="submit-removeRole-account-ownerType:adults_ownerIndex:${roleOwner.index}_role:${roleOwner.role}" value="${message(code:'action.remove')}" /></dd>
      </g:each>
      <g:each var="roleOwner" in="${individuals.getHomeFolderTutors(individuals?.foreignAdults)}">
        <dt>
          <span class="tag-foreigner tag-state"><g:message code="homeFolder.property.foreign" /></span>
          <g:capdematEnumToFlag var="${roleOwner.role}" i18nKeyPrefix="homeFolder.role" /> 
          ${roleOwner.owner.fullName}
        </dt>
        <dd><input type="submit" name="submit-removeRole-account-ownerType:foreignAdults_ownerIndex:${roleOwner.index}_role:${roleOwner.role}" value="${message(code:'action.remove')}" /></dd>
      </g:each>
      </dl>
    </g:if>
    <p>${message(code:'homeFolder.property.accountTutors.help')}</p>
    <dl class="role-add">
      <dt> 
        <label for="owner-homeFolderTutor_ownerType:adults"><g:message code="homeFolder.property.tutors" /></label>
      </dt>
      <dd>
        <input type="hidden" name="role-homeFolderTutor_ownerType:adults" value="Tutor" />
        <select id="owner-homeFolderTutor_ownerType:adults" name="owner-homeFolderTutor_ownerType:adults" class="validate-not-first">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each var="owner" in="${individuals?.adults}" status="ownerIndex">
            <option value="${ownerIndex}">${owner.fullName}</option>
          </g:each>
        </select>
        <input type="submit" name="submit-addRole-account-homeFolderTutor_ownerType:adults" value="${message(code:'action.add')}" />
      </dd>
      <dt>
        <label for="owner-homeFolderTutor_ownerType:foreignAdults">
          <g:message code="homeFolder.property.foreignTutors" />
        </label>
        <g:if test="${flash?.isTutorAvailable}">
          <span class="message">${message(code:'homeFolder.message.tutorIsAvailable')}</span>
        </g:if>
      </dt>
      <dd>
        <input type="hidden" name="role-homeFolderTutor_ownerType:foreignAdults" value="Tutor" />
        <select id="owner-homeFolderTutor_ownerType:foreignAdults" name="owner-homeFolderTutor_ownerType:foreignAdults" class="validate-not-first">
          <option value=""><g:message code="message.select.defaultOption" /></option>
          <g:each var="owner" in="${individuals?.foreignAdults}" status="ownerIndex">
            <option value="${ownerIndex}">${owner.fullName}</option>
          </g:each>
        </select>
        <input type="submit" name="submit-addRole-account-homeFolderTutor_ownerType:foreignAdults" value="${message(code:'action.add')}" />
        <br /><a id="active-tab-${UUID.randomUUID()}" href="#foreignAdults"><g:message code="homeFolder.action.editForeignAdults" /></a>
      </dd>
    </dl>
  </fieldset>
  </g:if>
  
  <g:if test="${${individuals?.children?.size()}}">
    <h3>
      <g:message code="homeFolder.header.rolesOnChildren" />
      <span><g:message code="homeFolder.header.rolesOnChildren.desc" /></span>
    </h3>
  </g:if>
  <g:each var="it" in="${individuals?.children}" status="index">
    <fieldset class="individual edit  summary-box validation-scope">
      <h4>
      <g:if test="${it.isChildBorn}">${it.fullName}</g:if>
      <g:else><g:message code="request.subject.childNoBorn" args="${[it.fullName]}" /></g:else>
      </h4>
      <g:if test="${individuals.getRoleOwnersOnIndividual(it, individuals?.adults).size()  + individuals.getRoleOwnersOnIndividual(it, individuals?.foreignAdults).size() > 0}">
        <dl>
        <g:each var="roleOwner" in="${individuals.getRoleOwnersOnIndividual(it, individuals?.adults)}">
          <dt>
            <g:capdematEnumToFlag var="${roleOwner.role}" i18nKeyPrefix="homeFolder.role" /> 
            ${roleOwner.owner.fullName}
          </dt>
          <dd><input type="submit" name="submit-removeRole-account-ownerType:adults_ownerIndex:${roleOwner.index}_role:${roleOwner.role}_individualIndex:${index}_individualType:children" value="${message(code:'action.remove')}" /></dd>
        </g:each>
         <g:each var="roleOwner" in="${individuals.getRoleOwnersOnIndividual(it, individuals?.foreignAdults)}">
          <dt>
            <span class="tag-foreigner tag-state"><g:message code="homeFolder.property.foreign" /></span>
            <g:capdematEnumToFlag var="${roleOwner.role}" i18nKeyPrefix="homeFolder.role" /> 
            ${roleOwner.owner.fullName}
          </dt>
          <dd><input type="submit" name="submit-removeRole-account-ownerType:foreignAdults_ownerIndex:${roleOwner.index}_role:${roleOwner.role}_individualIndex:${index}_individualType:children" value="${message(code:'action.remove')}" /></dd>
        </g:each>
        </dl>
      </g:if>
      <p>${message(code:'homeFolder.child.property.legalResponsibles.help')}</p>
      <dl class="role-add">
        <dt>
          <label for="role-ownerType:adults_individualIndex:${index}_individualType:children" class="required"><g:message code="homeFolder.child.property.legalResponsibles" /> *</label>
        </dt>
        <dd>
          <select id="role-ownerType:adults_individualIndex:${index}_individualType:children" name="role-ownerType:adults_individualIndex:${index}_individualType:children" class="validate-not-first">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${individuals?.childRoleTypes}">
              <option value="${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.role" /></option>
            </g:each>
          </select>
          <select name="owner-ownerType:adults_individualIndex:${index}_individualType:children" class="validate-not-first">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each var="owner" in="${individuals?.adults}" status="ownerIndex">
              <option value="${ownerIndex}">${owner.fullName}</option>
            </g:each>
          </select>
          <input type="submit" name="submit-addRole-account-ownerType:adults_individualIndex:${index}_individualType:children" value="${message(code:'action.add')}" />
        </dd>
        <g:if test="${displayTutorsInAccountCreation}">
        <dt>
          <label for="role-ownerType:foreignAdults_individualIndex:${index}_individualType:children">
            <g:message code="homeFolder.child.property.foreignLegalResponsibles" />
          </label>
          <g:if test="${flash?.isTutorAvailable}">
            <span class="message">${message(code:'homeFolder.message.tutorIsAvailable')}</span>
          </g:if>
        </dt>
        <dd>
          <select id="role-ownerType:foreignAdults_individualIndex:${index}_individualType:children" name="role-ownerType:foreignAdults_individualIndex:${index}_individualType:children" class="validate-not-first">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each in="${individuals?.childRoleTypes}">
              <option value="${it}"><g:capdematEnumToText var="${it}" i18nKeyPrefix="homeFolder.role" /></option>
            </g:each>
          </select>
          <select name="owner-ownerType:foreignAdults_individualIndex:${index}_individualType:children" class="validate-not-first">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each var="owner" in="${individuals?.foreignAdults}" status="ownerIndex">
              <option value="${ownerIndex}">${owner.fullName}</option>
            </g:each>
          </select>
          <input type="submit" name="submit-addRole-account-ownerType:foreignAdults_individualIndex:${index}_individualType:children" value="${message(code:'action.add')}" />
          <br /><a id="active-tab-${UUID.randomUUID()}" href="#foreignAdults"><g:message code="homeFolder.action.editForeignAdults" /></a>
        </dd>
        </g:if>
      </dl>
    </fieldset>
  </g:each>
  
  <g:if test="${displayTutorsInAccountCreation}">
  <g:if test="${${individuals?.adults?.size()}}">
    <h3>
      <g:message code="homeFolder.header.rolesOnAdults" />
      <span><g:message code="homeFolder.header.rolesOnAdults.desc" /></span>
    </h3>
  </g:if>
  <g:each var="it" in="${individuals?.adults}" status="index">
    <fieldset class="individual edit  summary-box validation-scope">
      <h4>
        <g:capdematEnumToField var="${it.title}" i18nKeyPrefix="homeFolder.adult.title" /> ${it.fullName}
      </h4>
      <g:if test="${individuals.getRoleOwnersOnIndividual(it, individuals?.adults).size() + individuals.getRoleOwnersOnIndividual(it, individuals?.foreignAdults).size() > 0}">
        <dl>
        <g:each var="roleOwner" in="${individuals.getRoleOwnersOnIndividual(it, individuals?.adults)}">
          <dt>
            <g:capdematEnumToFlag var="${roleOwner.role}" i18nKeyPrefix="homeFolder.role" /> ${roleOwner.owner.fullName}
          </dt>
          <dd><input type="submit" name="submit-removeRole-account-ownerType:adults_ownerIndex:${roleOwner.index}_role:${roleOwner.role}_individualIndex:${index}_individualType:adults" value="${message(code:'action.remove')}" /></dd>
        </g:each>
        <g:each var="roleOwner" in="${individuals.getRoleOwnersOnIndividual(it, individuals?.foreignAdults)}">
          <dt>
            <span class="tag-foreigner tag-state"><g:message code="homeFolder.property.foreign" /></span>
            <g:capdematEnumToFlag var="${roleOwner.role}" i18nKeyPrefix="homeFolder.role" /> ${roleOwner.owner.fullName}
          </dt>
          <dd><input type="submit" name="submit-removeRole-account-ownerType:foreignAdults_ownerIndex:${roleOwner.index}_role:${roleOwner.role}_individualIndex:${index}_individualType:adults" value="${message(code:'action.remove')}" /></dd>
        </g:each>
        </dl>
      </g:if>
      
      <p>${message(code:'homeFolder.property.adultTutors.help')}</p>
      <dl class="role-add">
        <dt>
          <label for="owner-ownerType:adults_individualIndex:${index}_individualType:adults"><g:message code="homeFolder.adult.property.tutors" /></label>
        </dt>
        <dd>
          <input type="hidden" name="role-ownerType:adults_individualIndex:${index}_individualType:adults" value="Tutor" />
          <select id="owner-ownerType:adults_individualIndex:${index}_individualType:adults" name="owner-ownerType:adults_individualIndex:${index}_individualType:adults" class="validate-not-first">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each var="owner" in="${individuals?.adults}" status="ownerIndex">
              <option value="${ownerIndex}">${owner.fullName}</option>
            </g:each>
          </select>
          <input type="submit" name="submit-addRole-account-ownerType:adults_individualIndex:${index}_individualType:adults" value="${message(code:'action.add')}" />
        </dd>
        <dt>
          <label for="owner-ownerType:foreignAdults_individualIndex:${index}_individualType:adults">
            <g:message code="homeFolder.adult.property.foreignTutors" />
          </label>
          <g:if test="${flash?.isTutorAvailable}">
            <span class="message">${message(code:'homeFolder.message.tutorIsAvailable')}</span>
          </g:if>
        </dt>
        <dd>
          <input type="hidden" name="role-ownerType:foreignAdults_individualIndex:${index}_individualType:adults" value="Tutor" />
          <select id="owner-ownerType:foreignAdults_individualIndex:${index}_individualType:adults" name="owner-ownerType:foreignAdults_individualIndex:${index}_individualType:adults" class="validate-not-first">
            <option value=""><g:message code="message.select.defaultOption" /></option>
            <g:each var="owner" in="${individuals?.foreignAdults}" status="ownerIndex">
              <option value="${ownerIndex}">${owner.fullName}</option>
            </g:each>
          </select>
          <input type="submit" name="submit-addRole-account-ownerType:foreignAdults_individualIndex:${index}_individualType:adults" value="${message(code:'action.add')}" />
          <br /><a id="active-tab-${UUID.randomUUID()}" href="#foreignAdults"><g:message code="homeFolder.action.editForeignAdults" /></a>
        </dd>
      </dl>
    </fieldset>
  </g:each>
  </g:if>

