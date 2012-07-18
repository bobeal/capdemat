


  

    <h3>${message(code:'scssr.step.homeFolder.label')}</h3>

    
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
          


  


  
    <h3><g:message code="scssr.step.subject.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scssr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.subjectBirthDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectBirthDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.subjectDomiciliationDate.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.subjectDomiciliationDate}"/></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.isOtherSituation.label" /></dt>
          <dd>
            <g:if test="${rqt.isOtherSituation}">
              <g:capdematEnumToField var="${rqt.isOtherSituation}" i18nKeyPrefix="scssr.property.isOtherSituation" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenOtherSituationDetails.label" /></dt><dd>${rqt.saintOuenOtherSituationDetails?.toString()}</dd>

      </dl>
      
    
  


  
    <h3><g:message code="scssr.step.schoolingInformation.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenEstablishmentLabel.label" /></dt><dd>${rqt.saintOuenEstablishmentLabel?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenEtablissementTelephone.label" /></dt><dd>${rqt.saintOuenEtablissementTelephone?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenIsInOtherStudies.label" /></dt>
          <dd>
            <g:if test="${rqt.saintOuenIsInOtherStudies}">
              <g:capdematEnumToField var="${rqt.saintOuenIsInOtherStudies}" i18nKeyPrefix="scssr.property.saintOuenIsInOtherStudies" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenOtherStudiesLabel.label" /></dt><dd>${rqt.saintOuenOtherStudiesLabel?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.saintOuenCurrentStudiesLevel.label" /></dt>
          <dd>
            <g:if test="${rqt.saintOuenCurrentStudiesLevel}">
              <g:capdematEnumToField var="${rqt.saintOuenCurrentStudiesLevel}" i18nKeyPrefix="scssr.property.saintOuenCurrentStudiesLevel" />
            </g:if>
          </dd>
          

      </dl>
      
    
  


  
    <h3><g:message code="scssr.step.compositionFamille.label" /></h3>
    
      
      <dl>
        <dt><g:message code="scssr.property.vousVivezAvec.label" /></dt>
          <dd>
            <g:if test="${rqt.vousVivezAvec}">
              <g:capdematEnumToField var="${rqt.vousVivezAvec}" i18nKeyPrefix="scssr.property.vousVivezAvec" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="scssr.property.precisionsCompositionFamille.label" /></dt><dd>${rqt.precisionsCompositionFamille?.toString()}</dd>

      </dl>
      
    
      
      <h4><g:message code="scssr.property.nombreIndividusFoyer.label" /></h4>
      <dl>
        
          <dt><g:message code="scssr.property.nombreAdultesMajeurs.label" /></dt><dd>${rqt.nombreAdultesMajeurs?.toString()}</dd>

        
          <dt><g:message code="scssr.property.nombreEnfantsMineurs.label" /></dt><dd>${rqt.nombreEnfantsMineurs?.toString()}</dd>

        
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
  


  


