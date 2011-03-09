<h1>
  <g:if test="${rqt}">
    <span class="${rqt.state.cssClass}">
      <g:message code="${rqt.state.i18nKey}" />
    </span>
    <span><g:message code="request.property.state" /> :&nbsp;</span>
  </g:if>
  <g:message code="contact.header.contactEcitizen" />
</h1>
<div class="mainbox mainbox-yellow">
  <h2><g:message code="contact.header.writeMessage" /></h2>
  <form method="post" id="contactForm" action="${createLink(action:'contact')}">
    <div class="error" id="contactFormErrors"></div>
    <p class="field">
      <label for="meansOfContact" class="required">
        <g:message code="contact.property.meansOfContact" /> :
      </label>
      <select id="meansOfContact" name="meansOfContact" class="required">
        <g:each var="moc" in="${meansOfContacts}">
          <option id="switchMoC_${moc.enumString}" value="${moc.enumString}"
            <g:if test="${moc.enumString == defaultMeansOfContact.enumString}">
              selected="selected"
            </g:if>
          >
            ${moc.i18nKey}
            <g:if test="${moc.enumString == defaultMeansOfContact.enumString}">
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
          value="${user.email}" />
      </p>
      <p id="homePhoneWidget" class="field">
        <label for="homePhone" class="required">
          <g:message code="contact.property.recipient" /> :
        </label>
        <input type="text" id="homePhone" name="homePhone"
          class="required"
          value="${user.homePhone}" />
      </p>
      <p id="officePhoneWidget" class="field">
        <label for="officePhone" class="required">
          <g:message code="contact.property.recipient" /> :
        </label>
        <input type="text" id="officePhone" name="officePhone"
          class="required"
          value="${user.officePhone}" />
      </p>
      <p id="mobilePhoneWidget" class="field">
        <label for="mobilePhone" class="required">
          <g:message code="contact.property.recipient" /> :
        </label>
        <input type="text" id="mobilePhone" name="mobilePhone"
          class="required"
          value="${user.mobilePhone}" />
      </p>
    </div>
    <div id="messageField">
      <div id="templateWidget" class="field">
        <p class="field">
          <label id="templateMessageLabel" for="templateMessage" class="required">
            <g:message code="contact.property.message" /> :
            <span id="templateMessageNotifier"></span>
          </label>
          <textarea id="templateMessage" name="templateMessage" class="required"
            rows="5" cols="40" maxlength="1024"></textarea>
        </p>
        <g:if test="${rqt && !requestForms.isEmpty()}">
          <p class="field">
            <span class="block">
              <label for="requestFormId">
                <g:message code="contact.property.template" /> :
              </label>
              <select id="requestFormId" name="requestFormId">
                <option value="">
                  <g:message code="contact.message.noTemplate" />
                </option>
                <g:each var="requestForm" in="${requestForms}">
                  <option value="${requestForm.id}">
                    ${requestForm.shortLabel}
                  </option>
                </g:each>
              </select>
            </span>
            <span id="templatePreview" class="block">
              <label for="previewFormat">
                <g:message code="contact.property.previewFormat" /> :
              </label>
              <select id="previewFormat" name="previewFormat">
                <option value="PDF">PDF</option>
                <option value="HTML">HTML</option>
              </select>
              <input type="button" id="preview_contact"
                value="${message(code:'contact.action.preview')}" />
            </span>
          </p>
        </g:if>
      </div>
      <p id="smsWidget" class="field">
        <label for="smsMessage" class="required">
          <g:message code="contact.property.message" /> :
          <span id="smsMessageNotifier"></span>
        </label>
        <textarea id="smsMessage" name="smsMessage" rows="5" cols="40"
          maxlength="130" class="required message"></textarea>
      </p>
    </div>
    <p class="field">
      <label for="contactNote">
        <g:message code="contact.property.note" /> :
        <span id="contactNoteNotifier"></span>
      </label>
      <textarea id="contactNote" name="note"
        rows="5" cols="40" maxlength="1024"></textarea>
    </p>
    <div>
      <g:if test="${rqt}">
        <input type="hidden" name="requestId" value="${rqt.id}" />
      </g:if>
      <g:else>
        <input type="hidden" name="id" value="${user.id}" />
      </g:else>
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