  <label class="required">${message(code:'request.step.validation.label.activeHomeFolder')} * </label>
  <ul class="required">
    <g:each in="${[true,false]}">
    <li>
      <input type="radio" class="required validate-boolean condition-activeHomeFolder-trigger" title="" value="${it}" 
             name="_requester.activeHomeFolder" ${flash.activeHomeFolder == null ? (!it ? 'checked="checked"' : '') : (flash.activeHomeFolder == it ? 'checked="checked"' : '') } />
      ${message(code:'message.' + (it ? 'yes' : 'no'))}
    </li>
    </g:each>
  </ul>
          
  <fieldset class="condition-activeHomeFolder-filled">
  <input type="hidden" name="requester" />
  <legend>${message(code:'request.step.validation.label.choosePassword')}</legend>
    <label class="required">${message(code:'homeFolder.adult.property.password')} *</label>
    <input type="password" name="_requester.password" class="required" value="" title="${message(code:'homeFolder.adult.property.password.validationError')}" />

    <label class="required">${message(code:'request.step.validation.label.confirmPassword')} *</label>
    <input type="password" name="_requester.confirmPassword" class="required" value="" title="${message(code:'vcr.property.confirmPassword.validationError')}" />
  </fieldset>

  <fieldset class="condition-activeHomeFolder-filled">
    <legend>${message(code:'request.step.validation.label.chooseReminder')}</legend>
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
