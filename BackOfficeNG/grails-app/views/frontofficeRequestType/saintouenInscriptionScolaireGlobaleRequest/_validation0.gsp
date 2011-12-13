


  

    <h3>${message(code:'sisgr.step.homeFolder.label')}</h3>

    
            <dl>
              <dt><g:capdematEnumToFlag var="${requester.title}" i18nKeyPrefix="homeFolder.adult.title" /> ${requester.fullName}</dt>
              <dd>
                <ul>
                  <li>
                    <span class="tag-homefolderresponsible tag-state">${message(code:'homeFolder.role.homeFolderResponsible')}</span>
                  </li>
                  <g:if test="${requester.homePhone}">
                    <li>${requester.homePhone}</li>
                  </g:if>
                  <g:if test="${requester.mobilePhone}">
                    <li>${requester.mobilePhone}</li>
                  </g:if>
                  <g:if test="${requester.email}">
                    <li>${requester.email}</li>
                  </g:if>
                </ul>
              </dd>
            </dl>
          


    
          <g:each in="${requester.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals('Archived') || it.getState().name.equals('Invalid')) && (requester.getId() != it.getId()) }}" var="individual">
            <g:if test="${individual.getClass() == fr.cg95.cvq.business.users.Adult.class}">
              <dl>
                <dt><g:capdematEnumToFlag var="${individual.title}" i18nKeyPrefix="homeFolder.adult.title" /> ${individual.fullName}</dt>
                <dd>
                  <ul>
                    <g:if test="${individual.homePhone}">
                      <li>${individual.homePhone}</li>
                    </g:if>
                    <g:if test="${individual.mobilePhone}">
                      <li>${individual.mobilePhone}</li>
                    </g:if>
                    <g:if test="${individual.email}">
                      <li>${individual.email}</li>
                    </g:if>
                  </ul>
                </dd>
              </dl>
            </g:if>
          </g:each>
          


    
          <g:each in="${requester.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals('Archived') || it.getState().name.equals('Invalid'))}}" var="individual">
            <g:if test="${individual.getClass() == fr.cg95.cvq.business.users.Child.class}">
              <dl class="${individual.state}">
                <dt>
                  <g:if test="${individual.born}">${individual.fullName}</g:if>
                  <g:else>${message(code:'request.subject.childNoBorn', args:[individual.fullName])}</g:else>
                <dd>
                  <g:if test="${individual.born}">${message(code:'homeFolder.header.born')}</g:if>
                  <g:else>${message(code:'homeFolder.header.noBorn')}</g:else>
                  <g:if test="${individual.birthDate}">
                    ${message(code:'homeFolder.header.on')}
                    ${formatDate(date:individual.birthDate,formatName:'format.date')}
                  </g:if>
                </dd>
              </dl>
            </g:if>
          </g:each>
          


  


  
    <h3><g:message code="sisgr.step.enfant.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sisgr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <h4><g:message code="sisgr.property.ecoleSecteur.label" /></h4>
      <dl>
        
          <dt><g:message code="sisgr.property.idEcoleSecteur.label" /></dt><dd>${rqt.idEcoleSecteur?.toString()}</dd>

        
          <dt><g:message code="sisgr.property.labelEcoleSecteur.label" /></dt><dd>${rqt.labelEcoleSecteur?.toString()}</dd>

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="sisgr.property.estAllergique.label" /></dt>
          <dd><g:message code="message.${rqt.estAllergique ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sisgr.property.estHandicapeInvalidant.label" /></dt>
          <dd><g:message code="message.${rqt.estHandicapeInvalidant ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  


  
    <h3><g:message code="sisgr.step.activites.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sisgr.property.estRestauration.label" /></dt>
          <dd><g:message code="message.${rqt.estRestauration ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <h4><g:message code="sisgr.property.inscriptionPeriscolaire.label" /></h4>
      <dl>
        
          <dt><g:message code="sisgr.property.accueilMatin.label" /></dt>
          <dd><g:message code="message.${rqt.accueilMatin ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sisgr.property.accueilSoir.label" /></dt>
          <dd><g:message code="message.${rqt.accueilSoir ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sisgr.property.accueilMercrediEtVacances.label" /></dt>
          <dd><g:message code="message.${rqt.accueilMercrediEtVacances ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sisgr.property.etudesSurveillees.label" /></dt>
          <dd><g:message code="message.${rqt.etudesSurveillees ? 'yes' : 'no'}" /></dd>
          

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="sisgr.property.reglementInterieur.label" /></dt>
          <dd><g:message code="message.${rqt.reglementInterieur ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
  


  
    <h3><g:message code="sisgr.step.paiement.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sisgr.property.modeReglement.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'modeReglement', 'lrEntries': lrTypes.modeReglement.entries, 'depth':0]" />
          </dd>
          

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
  


  


