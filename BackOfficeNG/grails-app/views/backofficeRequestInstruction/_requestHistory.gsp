<div class="txt-right">
  <a id="contactLink">
    <g:message code="contact.header.contactEcitizen" />
  </a>
  /
  <a id="noteLink">
    <g:message code="request.note.addLabel" />
  </a>
</div>
<ul id="requestHistory">
  <g:each var="action" in="${actions}">
    <li>
      <g:render template="${action.template}" model="['action' : action]" />
    </li>
  </g:each>
</ul>
