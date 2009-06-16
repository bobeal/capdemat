  <g:if test="${requestTypeLabel != 'VO Card'}">
    <p>${message(code:'request.step.validation.help.followRequest')}</p>
    <label class="required">${message(code:'request.step.validation.label.followRequest')} * 
    </label>
    <ul class="yes-no required">
      <g:each in="${[true,false]}">
      <li>
        <input type="radio" class="required validate-boolean condition-activeHomeFolder-trigger" title="" value="${it}" 
               name="_requester.activeHomeFolder" ${flash.activeHomeFolder == null ? (!it ? 'checked="checked"' : '') : (flash.activeHomeFolder == it ? 'checked="checked"' : '') } />
        ${message(code:'message.' + (it ? 'yes' : 'no'))}
      </li>
      </g:each>
    </ul>
  </g:if>
  <p class="condition-activeHomeFolder-filled"><strong>${message(code:'request.step.validation.message.choosePassword')}</strong></p>
  <fieldset class="condition-activeHomeFolder-filled">
    <input type="hidden" name="requester" />
    <input type="hidden" name="objectToBind" value="requester" />
    <legend>${message(code:'request.step.validation.label.choosePassword')}</legend>
    <label class="required">${message(code:'homeFolder.adult.property.password')} * <span>(${message(code:'request.step.validation.help.choosePassword')})</span></label>
    <input type="password" name="_requester.password" class="required" value="" title="${message(code:'homeFolder.adult.property.password.validationError')}" />

    <label class="required">${message(code:'request.step.validation.label.confirmPassword')} *</label>
    <input type="password" name="_requester.confirmPassword" class="required" value="" title="${message(code:'vcr.property.confirmPassword.validationError')}" />
  </fieldset>

  <fieldset class="condition-activeHomeFolder-filled">
    <legend>${message(code:'request.step.validation.label.chooseReminder')}</legend>
    <p>${message(code:'request.step.validation.help.chooseReminder')}</p>
    <label class="required">${message(code:'homeFolder.adult.property.question')} *</label>
    <select name="_requester.question" class="required validate-not-first" title="${message(code:'homeFolder.adult.property.question.validationError')}">
      <option value="">${message(code:'message.select.defaultOption')}</option>
      <g:each in="${['q1','q2','q3','q4']}">
        <option value="${message(code:'homeFolder.adult.question.' + it)}">
          ${message(code:'homeFolder.adult.question.' + it)}
        </option>
      </g:each>
    </select>
    <label class="required ">${message(code:'homeFolder.adult.property.answer')} *</label>
    <input type="text" name="_requester.answer" class="required" title="${message(code:'homeFolder.adult.property.answer.validationError')}" />
  </fieldset>

  <label class="required">${message(code:'request.step.validation.label.typeTextInImage')}*</label>
  <div class="captcha">
    <jcaptcha:jpeg name="captchaImage" />
    <input type="text" name="captchaText" class="required" title="${message(code:'request.captcha.validationError')}" />
  </div>
