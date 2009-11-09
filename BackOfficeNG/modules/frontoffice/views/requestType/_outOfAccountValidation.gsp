  <g:if test="${!['VO Card','Home Folder Modification'].contains(requestTypeLabel)}">
    <p>${message(code:'request.step.validation.help.followRequest')}</p>
    <label class="required">${message(code:'request.step.validation.label.followRequest')} * </label>
    <ul class="yes-no required">
      <g:each in="${[true,false]}">
      <li>
        <input type="radio" class="required validate-boolean condition-activeHomeFolder-trigger" title="" value="${it}" 
               id="_homeFolderResponsible.activeHomeFolder" name="_homeFolderResponsible.activeHomeFolder" ${flash.activeHomeFolder == null ? (!it ? 'checked="checked"' : '') : (flash.activeHomeFolder == it ? 'checked="checked"' : '') } />
        <label for="_homeFolderResponsible.activeHomeFolder_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
      </li>
      </g:each>
    </ul>
  </g:if>
  <p class="condition-activeHomeFolder-filled"><strong>${message(code:'request.step.validation.message.choosePassword')}</strong></p>
  <fieldset class="condition-activeHomeFolder-filled">
    <input type="hidden" name="homeFolderResponsible" />
    <input type="hidden" name="objectToBind" value="homeFolderResponsible" />
    <legend>${message(code:'request.step.validation.label.choosePassword')}</legend>
    <label for="_homeFolderResponsible.password" class="required">${message(code:'homeFolder.adult.property.password')} * <span>(${message(code:'request.step.validation.help.choosePassword')})</span></label>
    <input type="password" id="_homeFolderResponsible.password" name="_homeFolderResponsible.password" class="required" value="" title="${message(code:'homeFolder.adult.property.password.validationError')}" />

    <label for="_homeFolderResponsible.confirmPassword" class="required">${message(code:'request.step.validation.label.confirmPassword')} *</label>
    <input type="password" id="_homeFolderResponsible.confirmPassword" name="_homeFolderResponsible.confirmPassword" class="required" value="" title="${message(code:'vcr.property.confirmPassword.validationError')}" />
  </fieldset>

  <fieldset class="condition-activeHomeFolder-filled">
    <legend>${message(code:'request.step.validation.label.chooseReminder')}</legend>
    <p>${message(code:'request.step.validation.help.chooseReminder')}</p>
    <label for="_homeFolderResponsible.question" class="required">${message(code:'homeFolder.adult.property.question')} *</label>
    <select id="_homeFolderResponsible.question" name="_homeFolderResponsible.question" class="required validate-not-first" title="${message(code:'homeFolder.adult.property.question.validationError')}">
      <option value="">${message(code:'message.select.defaultOption')}</option>
      <g:each in="${['q1','q2','q3','q4']}">
        <option value="${message(code:'homeFolder.adult.question.' + it)}">
          ${message(code:'homeFolder.adult.question.' + it)}
        </option>
      </g:each>
    </select>
    <label for="_homeFolderResponsible.answer" class="required ">${message(code:'homeFolder.adult.property.answer')} *</label>
    <input type="text" id="_homeFolderResponsible.answer" name="_homeFolderResponsible.answer" class="required" title="${message(code:'homeFolder.adult.property.answer.validationError')}" />
  </fieldset>

  <label for="captchaText" class="required">${message(code:'request.step.validation.label.typeTextInImage')}*</label>
  <div class="captcha">
    <jcaptcha:jpeg name="captchaImage" alt="captcha" />
    <input type="text" id="captchaText" name="captchaText" class="required" title="${message(code:'request.step.validation.error.captcha')}" />
  </div>
