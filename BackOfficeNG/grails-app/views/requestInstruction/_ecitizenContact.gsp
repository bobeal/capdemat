  <h1>
    <span class="${request.state.cssClass}">
      <g:message code="${request.state.i18nKey}" />
    </span>
    <span><g:message code="request.property.state" /> :&nbsp;</span>
    <g:message code="request.contact.header.contactEcitzen" />
  </h1>
  <div id="contactMsg" style="display:none"></div>
  <div class="mainbox mainbox-yellow">
    <h2><g:message code="request.contact.header.writeMessage" /> </h2>

    <form method="POST" id="contactForm" action="${createLink(action:'notifyContact')}">
      <div class="error" id="contactFormErrors"></div>
      <div>
        <g:message code="request.contact.contactMeanChoosenByCitizen" /> :
        ${message(code:request.meansOfContact.i18nKey)}
      </div>
      <!-- Contact facilities -->
      <fieldset id="contactMeansForm">
        <label for="meansOfContact" >
          <g:message code="request.contact.meansOfContact" /> :
        </label>

        <g:select class="contactMean"
          optionKey="enumString"
          optionValue="i18nKey"
          id="meansOfContact"
          name="meansOfContact"
          from="${requesterMeansOfContacts}"
          value="${request.meansOfContact.enumString}" />

      </fieldset>

      <!-- Mail field -->
      <fieldset id="mailForm">
        <label for="mail" class="required">
          <g:message code="request.contact.contactRecipient" /> :
        </label>
        <input type="text" id="email" name="email" size="55"
            class="required validate-email recipient" title="${message(code:'request.contact.error.contactRecipientRequired')}"
            value="${requester?.email}" />
      </fieldset>

      <!--Home phone field -->
      <fieldset id="homePhoneForm">
        <label for="homePhone" class="required">
          <g:message code="request.contact.contactRecipient" /> :
        </label>
        <input type="text" id="homePhone" name="homePhone" size="55"
            class="required recipient" title="${message(code:'request.contact.error.contactRecipientRequired')}"
            value="${requester?.homePhone}" />
      </fieldset>

      <!--Office phone field -->
      <fieldset id="officePhoneForm">
        <label for="officePhone" class="required">
          <g:message code="request.contact.contactRecipient" /> :
        </label>
        <input type="text" id="officePhone" name="officePhone" size="55"
            class="required recipient" title="${message(code:'request.contact.error.contactRecipientRequired')}"
            value="${requester?.officePhone}" />
      </fieldset>

      <!--Mobile phone field -->
      <fieldset id="mobilePhoneForm">
        <label for="mobilePhone" class="required">
          <g:message code="request.contact.contactRecipient" /> :
        </label>
        <input type="text" id="mobilePhone" name="mobilePhone" size="55"
            class="required recipient" title="${message(code:'request.contact.error.contactRecipientRequired')}"
            value="${requester?.mobilePhone}" />
      </fieldset>

      <!-- Simple message field -->
      <fieldset id="messageForm">
        <label for="simpleMessage" class="required"><g:message code="request.contact.message" /></label>
        <textarea name="simpleMessage" rows="5" cols="53" id="simpleMessage"
          class="required message"  title="${message(code:'request.contact.error.messageRequired')}"></textarea>
      </fieldset>

      <!-- Sms message field -->
      <fieldset id="smsMessageForm">
        <div id="smsNotifier"></div>
        <label for="smsMessage" class="required"><g:message code="request.contact.message" /> (160)</label>
        <textarea name="smsMessage" rows="5" cols="53" maxlength="160"
          class="required message"  title="${message(code:'request.contact.error.messageRequired')}"></textarea>
      </fieldset>

      <!-- Mail template field -->
      <fieldset id="mailTemplateForm">
        <label for="requestForm"><g:message code="request.contact.template" />:</label>

        <g:select
          optionKey="id"
          optionValue="shortLabel"
          name="requestForms"
          id="requestForms"
          class="mails"
          from="${requestForms}"
          value="-1" />

        <a id="previewRequestForm"
           target="_blank"
           title="preview"
           href="javascript:;"
           style="display:none"><g:message code="request.contact.preview" /></a>
           
      </fieldset>

      <input type="hidden" name="recipient" value="" />
      <input type="hidden" name="message" value="" />
      <input type="hidden" name="contactMean" value="" />
      <input type="hidden" name="requestId" value="${request.id}" />
      <input type="hidden" name="traceLabel" value="REQUEST_CONTACT_CITIZEN" />
      
      <!-- Sms buttons -->
      <fieldset id="smsButtons">
        <input type="button" id="sendSms" name="sendSms"
               class="form-button" value="${message(code:'action.send')}" />
        <input type="button" id="trace_sms" name="trace_sms"
            value="${message(code:'action.trace')}" />
        <input type="button" id="discardChanges_Sms" name="discardChanges_Sms"
            value="${message(code:'action.discard')}" />
      </fieldset>
      
      <!-- Mail buttons -->
      <fieldset id="emailButtons">
        <input type="button" id="sendEmail" name="sendEmail"
               class="form-button" value="${message(code:'action.send')}" />
        <input type="button" id="trace_email" name="trace_email"
            value="${message(code:'action.trace')}" />
        <input type="button" id="discardChanges_mail" name="discardChanges_mail"
            value="${message(code:'action.discard')}" />
      </fieldset>
      
      <!-- Default buttons -->
      <fieldset id="defaultButtons">
        <input type="button" id="trace_default" name="trace_default"
            value="${message(code:'action.trace')}" class="form-button" />
        <input type="button" id="discardChanges_default" name="discardChanges_default"
            value="${message(code:'action.discard')}" />
      </fieldset>

    </form>
  </div>
