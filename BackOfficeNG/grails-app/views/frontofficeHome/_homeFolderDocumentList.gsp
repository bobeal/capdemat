<g:if test="${documentsByTypes.any { it.value.linked.isEmpty() || it.value.linkedAndInvalid.any() }}">
  <div class="list-box warn">
    <h2><g:message code="homeFolder.header.documents" /></h2>
    <p class="warn documents">${message(code:'homeFolder.message.documents')}</p>
    <ul>
      <g:each var="documentType" in="${documentsByTypes}">
        <g:if test="${documentType.value.linked.isEmpty()}">
          <li>
            <span class="action_and_tag-state">
              <a href="${createLink(controller:'frontofficeHomeFolderDocument', action:'edit', params:['documentTypeId':documentType.key])}">${message(code:'action.attach')}</a>
              <span class="tag-state tag-not_provided">${message(code:'document.state.notProvided')}</span>
            </span>
            <span>${documentType.value.name}</span>
          </li>
        </g:if>
        <g:else>
          <g:each var="document" in="${documentType.value.linkedAndInvalid}">
            <li>
              <span class="action_and_tag-state">
                <a href="${createLink(controller:'frontofficeHomeFolderDocument', action:'edit', params:['documentTypeId':documentType.key])}">${message(code:'action.attach')}</a>
                <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
              </span>
              <a href="${createLink(controller:'frontofficeDocument',action:'details',id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
                ${documentType.value.name}
              </a>
              <p>>
                <g:if test="${document.ecitizenNote}">
                  <span> ${document.ecitizenNote} - </span>
                </g:if> ${document.datas.size()} ${message(code:'property.pages')}
              </p>
                <g:if test="${document.endValidityDate}">
                  <p>> ${message(code:'message.expireOn',args:[formatDate(date:document.endValidityDate,formatName:'format.date')])}</p>
                </g:if>
            </li>
          </g:each>
        </g:else>
      </g:each>
    </ul>
  </div>
</g:if>
