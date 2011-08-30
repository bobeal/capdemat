<div class="tracker ${flat ? 'flat' : ''}">
  <g:if test="${homeFolder?.responsibleStepState?.name() != 'UNNEEDED'}">
    <a ${clickable && (step != 'general') ? 'href="' + createLink(controller : 'frontofficeHomeFolder', action : 'index') + '"' : ''}>
      <span class="info">
        ${message(code:'homeFolder.tracker.label.general')}
        <span class="state">${message(code:'homeFolder.tracker.state.' + homeFolder?.responsibleStepState?.name())}</span>
      </span>
      <span class="step ${step == 'general' ? 'current' : ''} general ${homeFolder?.responsibleStepState?.name()}"></span>
    </a>
  </g:if>
  <g:if test="${homeFolder?.familyStepState?.name() != 'UNNEEDED'}">
      <a ${clickable && (step != 'family') ? 'href="' + createLink(controller : 'frontofficeHomeFolder', action : 'index') + '"' : ''}>
        <span class="info">
          ${message(code:'homeFolder.tracker.label.family')}
          <span class="state">${message(code:'homeFolder.tracker.state.' + homeFolder?.familyStepState?.name())}</span>
        </span>
        <span class="step ${step == 'family' ? 'current' : ''} family ${homeFolder?.familyStepState?.name()}"></span>
      </a>
  </g:if>
  <g:if test="${homeFolder?.documentsStepState?.name() != 'UNNEEDED'}">
    <a ${clickable && (step != 'documents') ? 'href="' + createLink(controller : 'frontofficeHomeFolder', action : 'index') + '"' : ''}>
      <span class="info">
        ${message(code:'homeFolder.tracker.label.document')}
        <span class="state">${message(code:'homeFolder.tracker.state.' + homeFolder?.documentsStepState?.name())}</span>
      </span>
      <span class="step ${step == 'documents' ? 'current' : ''} document ${homeFolder?.documentsStepState?.name()}"></span>
    </a>
  </g:if>
</div>

<g:if test="${step}">
  <div class="note">
    ${message(code:'homeFolder.tracker.help.' + step)}
  </div>
</g:if>
