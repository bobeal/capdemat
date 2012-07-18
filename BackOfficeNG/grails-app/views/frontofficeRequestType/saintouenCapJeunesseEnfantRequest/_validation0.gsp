


  
    <h3><g:message code="scjer.step.sujet.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scjer.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.telephonePortable.label" /></dt><dd>${rqt.telephonePortable?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.email.label" /></dt><dd>${rqt.email?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="scjer.step.renseignements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scjer.property.typeInscription.label" /></dt>
          <dd>
            <g:if test="${rqt.typeInscription}">
              <g:capdematEnumToField var="${rqt.typeInscription}" i18nKeyPrefix="scjer.property.typeInscription" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.secteurHabitation.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'secteurHabitation', 'lrEntries': lrTypes.secteurHabitation.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.typeEtablissementScolaireFrenquente.label" /></dt>
          <dd>
            <g:if test="${rqt.typeEtablissementScolaireFrenquente}">
              <g:capdematEnumToField var="${rqt.typeEtablissementScolaireFrenquente}" i18nKeyPrefix="scjer.property.typeEtablissementScolaireFrenquente" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.etablissementScolaireCollege.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'etablissementScolaireCollege', 'lrEntries': lrTypes.etablissementScolaireCollege.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.etablissementScolaireLycee.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'etablissementScolaireLycee', 'lrEntries': lrTypes.etablissementScolaireLycee.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.etablissementScolaireAutre.label" /></dt><dd>${rqt.etablissementScolaireAutre?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.etablissementScolaireAutreNom.label" /></dt><dd>${rqt.etablissementScolaireAutreNom?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.etablissementScolaireAutreAdresse.label" /></dt><dd>${rqt.etablissementScolaireAutreAdresse?.toString()}</dd>

      </dl>
      
    
  

  
    <h3><g:message code="scjer.step.reglements.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scjer.property.autorisationMedicale.label" /></dt>
          <dd><g:message code="message.${rqt.autorisationMedicale ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.autorisationImage.label" /></dt>
          <dd><g:message code="message.${rqt.autorisationImage ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scjer.property.acceptationReglement.label" /></dt>
          <dd><g:message code="message.${rqt.acceptationReglement ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  

  
  <g:if test="${!documentsByTypes.isEmpty()}">
    <h3>${message(code:'request.step.document.label')}</h3>
    <g:each in="${documentsByTypes}" var="documentType">
      <h4>${message(code:documentType.value.name)}</h4>
      <g:if test="${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="${documentType.value.associated}" var="document">
        <dt>
          <g:if test="${document.ecitizenNote}">${message(code:'document.header.description')} : ${document.ecitizenNote}<br/></g:if>
          <g:if test="${document.endValidityDate}">${message(code:'document.header.expireOn')} ${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:capdematEnumToFlag var="${document.state}" i18nKeyPrefix="document.state" />
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">${message(code:'document.message.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


