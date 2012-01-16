


  

    <h3>${message(code:'sdccrr.step.homeFolder.label')}</h3>

    
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
          


  


  
    <h3><g:message code="sdccrr.step.subject.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sdccrr.property.subject.label" /></dt>
          <dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.informationMere.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.situationActuelleMere.label" /></dt>
          <dd>
            <g:if test="${rqt.situationActuelleMere}">
              <g:capdematEnumToField var="${rqt.situationActuelleMere}" i18nKeyPrefix="sdccrr.property.situationActuelleMere" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sdccrr.property.precisionAutreSituationActuelleMere.label" /></dt><dd>${rqt.precisionAutreSituationActuelleMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.professionMere.label" /></dt><dd>${rqt.professionMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.employeurMere.label" /></dt><dd>${rqt.employeurMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.estHorairesReguliersMere.label" /></dt>
          <dd><g:message code="message.${rqt.estHorairesReguliersMere ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sdccrr.property.horairesReguliersMere.label" /></dt><dd>${rqt.horairesReguliersMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailLundiMere.label" /></dt><dd>${rqt.horairesTravailLundiMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailMardiMere.label" /></dt><dd>${rqt.horairesTravailMardiMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailMercrediMere.label" /></dt><dd>${rqt.horairesTravailMercrediMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailJeudiMere.label" /></dt><dd>${rqt.horairesTravailJeudiMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailVendrediMere.label" /></dt><dd>${rqt.horairesTravailVendrediMere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.communeLieuTravailMere.label" /></dt><dd>${rqt.communeLieuTravailMere?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.informationPere.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.situationActuellePere.label" /></dt>
          <dd>
            <g:if test="${rqt.situationActuellePere}">
              <g:capdematEnumToField var="${rqt.situationActuellePere}" i18nKeyPrefix="sdccrr.property.situationActuellePere" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sdccrr.property.precisionAutreSituationActuellePere.label" /></dt><dd>${rqt.precisionAutreSituationActuellePere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.professionPere.label" /></dt><dd>${rqt.professionPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.employeurPere.label" /></dt><dd>${rqt.employeurPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.estHorairesReguliersPere.label" /></dt>
          <dd><g:message code="message.${rqt.estHorairesReguliersPere ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="sdccrr.property.horairesReguliersPere.label" /></dt><dd>${rqt.horairesReguliersPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailLundiPere.label" /></dt><dd>${rqt.horairesTravailLundiPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailMardiPere.label" /></dt><dd>${rqt.horairesTravailMardiPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailMercrediPere.label" /></dt><dd>${rqt.horairesTravailMercrediPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailJeudiPere.label" /></dt><dd>${rqt.horairesTravailJeudiPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.horairesTravailVendrediPere.label" /></dt><dd>${rqt.horairesTravailVendrediPere?.toString()}</dd>

        
          <dt><g:message code="sdccrr.property.communeLieuTravailPere.label" /></dt><dd>${rqt.communeLieuTravailPere?.toString()}</dd>

        
      </dl>
      
    
  


  
    <h3><g:message code="sdccrr.step.accueil.label" /></h3>
    
      
      <h4><g:message code="sdccrr.property.datePlacementAccueilRegulier.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.choixTypeDatePlacementAccueilRegulier.label" /></dt>
          <dd>
            <g:if test="${rqt.choixTypeDatePlacementAccueilRegulier}">
              <g:capdematEnumToField var="${rqt.choixTypeDatePlacementAccueilRegulier}" i18nKeyPrefix="sdccrr.property.choixTypeDatePlacementAccueilRegulier" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="sdccrr.property.datePlacementDebut.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.datePlacementDebut}"/></dd>
          

        
          <dt><g:message code="sdccrr.property.datePlacementFin.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.datePlacementFin}"/></dd>
          

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="sdccrr.property.choixHorairesAccueil.label" /></dt>
          <dd>
            <g:if test="${rqt.choixHorairesAccueil}">
              <g:capdematEnumToField var="${rqt.choixHorairesAccueil}" i18nKeyPrefix="sdccrr.property.choixHorairesAccueil" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.plageHoraireAccueilReguliere.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.horairePlacementMatinDebut.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebut?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebut && rqt.horairePlacementMatinDebut.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebut?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementMatinFin.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFin?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFin && rqt.horairePlacementMatinFin.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFin?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiDebut.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebut?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebut && rqt.horairePlacementApresMidiDebut.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebut?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiFin.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFin?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFin && rqt.horairePlacementApresMidiFin.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFin?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.lundi.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.horairePlacementMatinDebutLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutLundi && rqt.horairePlacementMatinDebutLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutLundi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementMatinFinLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinLundi && rqt.horairePlacementMatinFinLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinLundi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiDebutLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutLundi && rqt.horairePlacementApresMidiDebutLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutLundi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiFinLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinLundi && rqt.horairePlacementApresMidiFinLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinLundi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.mardi.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.horairePlacementMatinDebutMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutMardi && rqt.horairePlacementMatinDebutMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutMardi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementMatinFinMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinMardi && rqt.horairePlacementMatinFinMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinMardi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiDebutMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutMardi && rqt.horairePlacementApresMidiDebutMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutMardi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiFinMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinMardi && rqt.horairePlacementApresMidiFinMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinMardi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.mercredi.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.horairePlacementMatinDebutMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutMercredi && rqt.horairePlacementMatinDebutMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutMercredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementMatinFinMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinMercredi && rqt.horairePlacementMatinFinMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinMercredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiDebutMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutMercredi && rqt.horairePlacementApresMidiDebutMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutMercredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiFinMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinMercredi && rqt.horairePlacementApresMidiFinMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinMercredi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.jeudi.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.horairePlacementMatinDebutJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutJeudi && rqt.horairePlacementMatinDebutJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutJeudi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementMatinFinJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinJeudi && rqt.horairePlacementMatinFinJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinJeudi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiDebutJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutJeudi && rqt.horairePlacementApresMidiDebutJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutJeudi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiFinJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinJeudi && rqt.horairePlacementApresMidiFinJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinJeudi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="sdccrr.property.vendredi.label" /></h4>
      <dl>
        
          <dt><g:message code="sdccrr.property.horairePlacementMatinDebutVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutVendredi && rqt.horairePlacementMatinDebutVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutVendredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementMatinFinVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinVendredi && rqt.horairePlacementMatinFinVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinVendredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiDebutVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutVendredi && rqt.horairePlacementApresMidiDebutVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutVendredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="sdccrr.property.horairePlacementApresMidiFinVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinVendredi && rqt.horairePlacementApresMidiFinVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinVendredi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
  


  
    <h3><g:message code="sdccrr.step.rendezVous.label" /></h3>
    
      
      <dl>
        <dt><g:message code="sdccrr.property.choixTypeRendezVous.label" /></dt>
          <dd>
            <g:if test="${rqt.choixTypeRendezVous}">
              <g:capdematEnumToField var="${rqt.choixTypeRendezVous}" i18nKeyPrefix="sdccrr.property.choixTypeRendezVous" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sdccrr.property.telephoneContact.label" /></dt><dd>${rqt.telephoneContact?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sdccrr.property.plageHoraireContact.label" /></dt>
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'plageHoraireContact', 'lrEntries': lrTypes.plageHoraireContact.entries, 'depth':0]" />
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="sdccrr.property.commentaireCitoyen.label" /></dt><dd>${rqt.commentaireCitoyen?.toString()}</dd>

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
  


  


