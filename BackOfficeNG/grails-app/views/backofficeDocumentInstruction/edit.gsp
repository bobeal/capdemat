  <h1>
    <span style="${document.id ? '' : 'display:none'}" id="toggleStateOverlay_${document.id}" 
      class="${document.state.cssClass} document-state">
      <span><g:message code="${document.state.i18nKey}" /></span>
      <span class="invisible">${document.endValidityDate}</span>
    </span>
    <g:message code="document.header.document" /> : ${document.name} 
      (${document.id ? document.id : message(code:'header.newDocument')})
    <span id="documentDepositType" class="${document.depositType.cssClass}">
      <g:message code="${document.depositType.i18nKey}" />
    </span>
    
    <span id="documentOrigin" class="${document.depositOrigin.cssClass}">
      <g:message code="${document.depositOrigin.i18nKey}" />
    </span>
    
    <g:if test="${document.endValidityDate}">
      <span id="documentEndValidityDate">
        <g:message code="document.property.endValidityDate" />
        <strong><g:formatDate formatName="format.date" date="${document.endValidityDate}"/></strong>
      </span>
    </g:if>
  </h1>
  <div id="documentMessage" class="invisible"></div>
  <!-- datas bloc-->
  <div id="requestDocumentData" class="yellow-yui-tabview">
  
    <ul class="yui-nav">
      <g:each var="page" in="${document.pages}" status="i">
        <li class="${i == 0 ? 'selected' : ''}">
          <a href="#page${page.pageNumber}">
          <em><g:message code="property.page" /> ${page.pageNumber + 1}</em></a>
        </li>
      </g:each>
      <g:if test="${document.editable}">
        <li class="${!document.id ? 'selected' : ''}">
          <a class="add-link" href="#documentEditPanel"><em><g:message code="action.add" /></em></a>
        </li>
      </g:if>
    </ul>
    
    <div class="yui-content"> 
      <g:each var="page" in="${document.pages}">
        <g:render template="page" model="${[pageNumber:page.pageNumber,document:document]}"/>
      </g:each>
      <g:if test="${document.editable}">
        <div id="pageAddPanel">
          <div class="error" style="display:none"><g:message code="document.message.pageFileCantBeEmpty"/></div>
          <form id="pageAddForm" action="${g.createLink(action:'addPage')}">
            <input type="file" name="pageFile" class="required" />
            <input type="button" name="pageModif" value="${message(code:'action.add')}" />
            <span class="routine-indicator" style="display:none">
              <g:message code="action.loading" /> ...
            </span>
            <input type="hidden" name="requestId" value="${params.requestId}" />
            <input type="hidden" name="documentId" value="${document.id}" />
            <input type="hidden" name="documentTypeId" value="${params.dtid}" />
          </form>
        </div>
      </g:if>
    </div>
    
  </div>

  <!-- editable field bloc -->
  
<g:if test="${document.id}">
  <!-- document action bloc -->
  <div id="documentMetaData" class="blue-yui-tabview">
    <ul class="yui-nav">
      <li class="selected"><a href="#page1"><em><g:message code="document.header.actionHistory" /></em></a></li>
      <li><a href="#page2"><em><g:message code="document.header.information" /></em></a></li>
    </ul>
    <div class="yui-content">
      
      <!-- Page 1 -->
      <div id="page1">
        <ul>
          <g:each var="action" in="${document.actions}">
            <li>
              <dl class="action">
                <dt class="title">
                  <span class="tag ${action.type.cssClass}">
                    <g:message code="${action.type.i18nKey}" />
                  </span>
                </dt>
                <g:if test="${action.resultingState}">
                  <dd class="title">
                    <span class="tag ${action.resultingState.cssClass}">
                      <g:message code="${action.resultingState.i18nKey}" /></span>
                  </dd>
                </g:if>
                <dd class="title">
                  <g:message code="searchResult.actionDate" /> :
                  <strong><g:formatDate formatName="format.fullDate" date="${action.date}"/></strong>
                  <g:if test="${action.username}">
                    <g:message code="layout.by" />
                    <strong>${action.username}</strong>
                  </g:if>
                </dd>
                <g:if test="${action.note}">
                    <dt class="action-note"><g:message code="documentAction.property.note" /> :</dt>
                    <dd class="action-note">${action.note}</dd>
                </g:if>
              </dl>
            </li>
          </g:each>
        </ul>
      </div>

      <!-- Page 2 -->
      <div id="page2">
        <h2><g:message code="document.header.information" /></h2>
        <div id="documentInformationtMsg" class="invisible"></div>
        
        <p class="static-data">
          <span><g:message code="document.property.ecitizenNote" /> :</span>
		      <em>${document.ecitizenNote}</em>
        </p>
        <form method="post" id="agentNoteForm" action="<g:createLink action="agentNote" />">
          <div id="agentNoteFormErrors" class="error"></div> 
          
          <label for="agentNote"><g:message code="document.property.agentNote" /> :</label>
          <input type="text" name="agentNote" size="50" title="" value="${document.agentNote}"  />

          <input type="hidden" name="documentId" value="${document.id}" />
          <input type="button" id="modifyAgentNote" class="form-button" value="<g:message code="action.save" />" />
        </form>
      </div>
        
    </div>
  </div>
</g:if>
