<h1>
  <span class="${request.state.cssClass}">
    <g:message code="${request.state.i18nKey}" />
  </span>
  <span><g:message code="request.property.state" /> :&nbsp;</span>
  <g:message code="contact.header.contactEcitizen" />
</h1>
<div id="contactMsg" style="display:none"></div>
<div class="mainbox mainbox-yellow">
  <h2><g:message code="contact.header.writeMessage" /></h2>
  <form method="post" id="contactForm" action="${createLink(action:'contact')}">
    <div class="error" id="contactFormErrors"></div>
    <p class="field">
      <label for="meansOfContact" class="required">
        <g:message code="contact.property.meansOfContact" /> :
      </label>
      <select id="meansOfContact" name="meansOfContact" class="required">
        <g:each var="moc" in="${requesterMeansOfContacts}">
          <option id="switchMoC_${moc.enumString}" value="${moc.enumString}"
            <g:if test="${moc.enumString == request.meansOfContact.enumString}">
              selected="selected"
            </g:if>
          >
            ${moc.i18nKey}
            <g:if test="${moc.enumString == request.meansOfContact.enumString}">
              (<g:message
                code="contact.message.meansOfContactChosenByCitizen" />)
            </g:if>
          </option>
        </g:each>
      </select>
    </p>
    <div id="recipientField">
      <p id="emailWidget" class="field">
        <label for="email" class="required">
          <g:message code="contact.property.recipient" /> :
        </label>
        <input type="text" id="email" name="email"
          class="required validate-email"
          value="${requester?.email}" />
      </p>
      <p id="homePhoneWidget" class="field">
        <label for="homePhone" class="required">
          <g:message code="contact.property.recipient" /> :
        </label>
        <input type="text" id="homePhone" name="homePhone"
          class="required"
          value="${requester?.homePhone}" />
      </p>
      <p id="officePhoneWidget" class="field">
        <label for="officePhone" class="required">
          <g:message code="contact.property.recipient" /> :
        </label>
        <input type="text" id="officePhone" name="officePhone"
          class="required"
          value="${requester?.officePhone}" />
      </p>
      <p id="mobilePhoneWidget" class="field">
        <label for="mobilePhone" class="required">
          <g:message code="contact.property.recipient" /> :
        </label>
        <input type="text" id="mobilePhone" name="mobilePhone"
          class="required"
          value="${requester?.mobilePhone}" />
      </p>
    </div>
    <div id="messageField">
      <div id="templateWidget" class="field">
        <p class="field">
          <label for="templateMessage">
            <g:message code="contact.property.message" /> :
          </label>
          <textarea id="templateMessage" name="templateMessage"
            rows="5" cols="40"
            title="${message(code:'request.contact.error.messageRequired')}"></textarea>
        </p>
        <p class="field">
          <label for="requestFormId" class="required">
            <g:message code="contact.property.template" /> :
          </label>
          <select id="requestFormId" name="requestFormId" class="required">
            <g:each var="requestForm" in="${requestForms}">
              <option value="${requestForm.id}">
                ${requestForm.shortLabel}
              </option>
            </g:each>
          </select>
        </p>
        <p class="field">
          <label for="previewFormat">
            <g:message code="contact.property.previewFormat" /> :
          </label>
          <select id="previewFormat" name="previewFormat">
            <option value="PDF">PDF</option>
            <option value="HTML">HTML</option>
          </select>
          <input type="button" id="preview_contact"
            value="${message(code:'contact.action.preview')}" />
        </p>
      </div>
      <p id="smsWidget" class="field">
        <span id="smsNotifier"></span>
        <label for="smsMessage" class="required">
          <g:message code="contact.property.message" /> (160)
        </label>
        <textarea id="smsMessage" name="smsMessage" rows="5" cols="40"
          maxlength="160" class="required message"
          title="${message(code:'request.contact.error.messageRequired')}"></textarea>
      </p>
    </div>
    <p class="field">
      <label for="note">
        <g:message code="contact.property.note" /> :
      </label>
      <textarea id="note" name="note" rows="5" cols="40" maxlength="255"></textarea>
    </p>
    <div>
      <input type="hidden" name="requestId" value="${request.id}" />
      <input type="hidden" name="label" value="${traceLabel}" />
    </div>
    <p id="validationField" class="field">
      <span id="sendWidget">
        <input type="button" id="send_contact" class="form-button"
          value="${message(code:'action.send')}" />
      </span>
      <span id="traceWidget">
        <input type="button" id="send_contact_as_trace" class="form-button"
          value="${message(code:'action.trace')}" />
      </span>
      <input type="button" id="hide_contact"
        value="${message(code:'action.close')}" />
    </p>
  </form>
</div>
<div style="display : none;">
  <input type="hidden" id="contactPreviewURL"
    value="${createLink(action:'preview')}" />
</div>