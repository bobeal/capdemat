<%
    fr.cg95.cvq.generator.common.CommonStep.metaClass.i18nPrefix = {
        return "request"
    }

    fr.cg95.cvq.generator.common.CustomStep.metaClass.i18nPrefix = {
        return requestFo.acronym
    }
%>
<html>
  <head>
     <title>\${message(code:'${requestFo.acronym}.description')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="\${resource(dir:'css/frontoffice', file:'request.css')}" />
    <link rel="stylesheet" type="text/css" href="\${resource(dir:'css/frontoffice', file:'document.css')}" />
    <g:if test="\${flash.addressesReferentialEnabled}">
        <link rel="stylesheet" type="text/css" href="\${resource(dir:'css/common', file:'autocomplete.css')}" />
    </g:if>
    <script type="text/javascript" src="\${resource(dir:'js/frontoffice',file:'homeFolder.js')}"></script>
    <script type="text/javascript" src="\${resource(dir:'js/frontoffice',file:'requestCreation.js')}"></script>
    <script type="text/javascript" src="\${resource(dir:'js/frontoffice',file:'condition.js')}"></script>
    <script type="text/javascript" src="\${resource(dir:'js/frontoffice',file:'autofill.js')}"></script>
    <g:if test="\${flash.addressesReferentialEnabled}">
        <script type="text/javascript" src="\${resource(dir:'js/common',file:'addressAutocomplete.js')}"></script>
        <script type="text/javascript" src="\${resource(dir:'js/common',file:'autocomplete.js')}"></script>
    </g:if>
    <g:if test="\${customJS}">
      <script type="text/javascript" src="\${resource(dir:customJS.dir,file:customJS.file)}"></script>
    </g:if>
    <script type="text/javascript">
        zenexity.capdemat.contextPath = "\${request.contextPath}";
    </script>
  </head>
  <body>
    <form action="\${createLink(controller:'frontofficeRequest',action:'condition')}"
      method="post" id="conditionsForm">
      <input type="hidden" id="conditionsContainer" name="conditionsContainer" value="" />
      <input type="hidden" name="requestTypeLabel" value="\${rqt.requestType.label}" />
    </form>
    <form action="\${createLink(controller:'frontofficeRequest',action:'autofill')}"
      method="post" id="autofillForm">
      <input type="hidden" id="autofillContainer" name="autofillContainer" value="" />
      <input type="hidden" id="triggerName" name="triggerName" value="" />
      <input type="hidden" id="triggerValue" name="triggerValue" value="" />
    </form>
    <g:if test="\${flash.confirmationMessage}">
      <div class="information-box">
      	<p>\${flash.confirmationMessage}</p>
      	<g:if test="\${flash.confirmationMessageNotice}">
      	  <strong>\${flash.confirmationMessageNotice}</strong>
      	</g:if>
      </div>
    </g:if>
    <g:if test="\${flash.errorMessage}">
      <div class="error-box">
        <p>\${flash.errorMessage}</p>
        <g:if test="\${flash.errorMessageNotice}">
          <strong>\${flash.errorMessageNotice}</strong>
        </g:if>
      </div>
    </g:if>
    
    <div id="request" class="main-box">
      <h2>
        <g:if test="\${temporary}">
          <a href="\${createLink(controller : 'frontofficeHome', action : 'logout')}" class="button">
            <g:message code="request.action.discard"/>
          </a>
        </g:if>
        <g:else>
          <a href="\${createLink(controller:'frontofficeHome')}" class="button">
            <g:message code="request.action.continueLater"/>
          </a>
          <g:if test="\${!isEdition}">
            <a href="\${createLink(action:'deleteDraft', controller:'frontofficeRequest', params : ['id' : rqt.id, 'from' : 'edition'])}" class="button">
              <g:message code="request.action.discardDarft"/>
            </a>
          </g:if>
        </g:else>
        <g:message code="${requestFo.acronym}.label" /> <g:message code="message.number" args="[rqt.id]" />
      </h2>
      <p><g:message code="request.duration.label" /><strong> : <g:message code="${requestFo.acronym}.duration.value" /></strong></p>
      <p>
        <g:message code="request.requiredDocuments.header" /> :
        <g:if test="\${!documentTypes.isEmpty()}">
          <g:each var="documentType" in="\${documentTypes}" status="index">
            <strong>\${documentType?.name}\${index < documentTypes.size() - 1 ? ', ' : ''}</strong>
          </g:each>
        </g:if>
        <g:else>
          <g:message code="message.none" />
        </g:else>
      </p>
      <div class="datas">
         <g:set var="requestTypeAcronym" value="${requestFo.acronym}" scope="request" />
         <g:render template="/frontofficeRequestType/step" /> 
      </div>
      
      <div  class="steps">
      <ul>
<% requestFo.steps.eachWithIndex { step, i -> %>
  <% if (step.name == 'document') { %>
        <g:if test="\${!documentTypes.isEmpty()}">
  <% } %>
        <li class="\${currentStep == '${step.name}' ? 'current ' : ''}
          <% if (i == 0) { %>
            \${individual ? rqt.stepStates['${step.name}-' + params.type].state : rqt.stepStates['${step.name}'].state}
          <% } else { %>
            \${rqt.stepStates['${step.name}'].state}
          <% } %>
          ">
          <span class="number">${step.name != 'validation' ? i+1 : ''}</span>
          <a
            <g:if test="\${currentStep != '${step.name}' && rqt.stepStates['${step.name}'].state != 'unavailable'}">
              href="\${createLink(controller:'frontofficeRequest', action : 'edit', params:['id':rqt.id,'currentStep':'${step.name}'])}"
            </g:if>
          >
            <% if (i == 0) { %>
              <g:message code="\${individual ? 'homeFolder.action.add' + org.apache.commons.lang.StringUtils.capitalize(params.type) : '${step.i18nPrefix()}.step.${step.name}.label'}" />
              ${step.required ? "\${individual ? '' : '*'" : ''}}
              <span class="help">
                <g:message code="request.step.message.\${rqt.stepStates['${step.name}' + (individual ? '-' + params.type : '')].state}" />
              </span>
            <% } else { %>
              <g:message code="${step.i18nPrefix()}.step.${step.name}.label" />${step.required ? ' *' :''}
              <span class="help">
                <% if (step.name == 'validation') { %>
                <g:if test="\${rqt.stepStates.validation.state == 'unavailable'}">
                  <g:message code="request.step.validation.allRequiredSteps" />
                </g:if>
                <g:else>
                  <g:message code="request.step.message.\${rqt.stepStates['${step.name}'].state}" />
                </g:else>
                <% } else { %>
                  <g:message code="request.step.message.\${rqt.stepStates['${step.name}'].state}" />
                <% } %>
              </span>
            <% } %>
          </a>
        </li>    
  <% if (step.name == 'document') { %>
        </g:if>
  <% } %>
<% } %>
		 </ul>
	  </div>
  </div>

  </body>
</html>
