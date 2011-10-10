<g:each in="${documentsByTypes}" var="documentType">
  <h4>
    <a href="${createLink(controller:'frontofficeRequestDocument', action:'edit', params:['requestId':rqt.id, 'documentTypeId':documentType.key])}">
      ${message(code:'action.attach')}
    </a>
    ${message(code:documentType.value.name)}
  </h4>
  <dl>
  <g:if test="${documentType.value.associated}">
    <g:each in="${documentType.value.associated}" var="document">
    <dt>
      <img src="${resource(dir:'images/icons',file:'mime_' + (document.isPDF() ? 'pdf' : 'img') + '.png')}" />
    </dt>
    <dd>
      <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
      <g:if test="${document.ecitizenNote}">
        <p>${message(code:'document.header.description')} : ${document.ecitizenNote}</p>
      </g:if>
      <p class="help">
        ${document.datas.size()} ${message(code:'property.pages')}
        <g:if test="${document.endValidityDate}">
          -
          <span>${message(code:'message.expireOn',args:[formatDate(date:document.endValidityDate,formatName:'format.date')])}</span>
        </g:if>
      </p>
      <p>
        <g:if test="${document.state == fr.cg95.cvq.business.document.DocumentState.DRAFT}">
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'edit', params:['requestId':rqt.id, 'documentTypeId':documentType.key, 'documentId':document.id])}">${message(code:'action.modify')}</a>&nbsp;
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'delete', params:['requestId':rqt.id, 'documentId':document.id])}">${message(code:'action.delete')}</a>&nbsp;
        </g:if>
        <g:else>
          <a href="${createLink(controller:'frontofficeRequestDocument', action:'unassociate', params:['requestId':rqt.id, 'documentId':document.id])}">${message(code:'action.detach')}</a>&nbsp;
        </g:else>
        <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
          ${message(code:'document.message.preview')}
        </a>
      </p>
    </dd>
    </g:each>
  </g:if>
  <g:else>
    <dt></dt>
    <dd>
      <span class="tag-state tag-not_provided">${message(code:'document.state.notProvided')}</span>
      <p class="warn">${message(code:'document.message.noAttachment')}</p>
    </dd>
  </g:else>
  </dl>
</g:each>
<div class="error" id="stepForm-error"> </div>
<input type="submit" id="nextStep" name="nextStep" style="float:right;" value="${message(code:'request.action.nextStep')}" />
<a href="${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'document','previousStep':'previousStep'])}" class="previousStep">
  ${message(code:'request.action.previousStep')}
</a>
