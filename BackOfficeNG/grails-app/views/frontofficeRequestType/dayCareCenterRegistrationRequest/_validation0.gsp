


  
    <h3><g:message code="dccrr.step.subject.label" /></h3>
    
      
      <dl>
        <dt><g:message code="request.property.subject.label" /></dt><dd>${subjects.get(rqt.subjectId)}</dd>

      </dl>
      
    
      
      <h4><g:message code="dccrr.property.informationMere.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.situationActuelleMere.label" /></dt>
          <dd>
            <g:if test="${rqt.situationActuelleMere}">
              <g:capdematEnumToField var="${rqt.situationActuelleMere}" i18nKeyPrefix="dccrr.property.situationActuelleMere" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dccrr.property.precisionAutreSituationActuelleMere.label" /></dt><dd>${rqt.precisionAutreSituationActuelleMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.professionMere.label" /></dt><dd>${rqt.professionMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.estHorairesReguliersMere.label" /></dt>
          <dd><g:message code="message.${rqt.estHorairesReguliersMere ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="dccrr.property.horairesReguliersMere.label" /></dt><dd>${rqt.horairesReguliersMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailLundiMere.label" /></dt><dd>${rqt.horairesTravailLundiMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailMardiMere.label" /></dt><dd>${rqt.horairesTravailMardiMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailMercrediMere.label" /></dt><dd>${rqt.horairesTravailMercrediMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailJeudiMere.label" /></dt><dd>${rqt.horairesTravailJeudiMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailVendrediMere.label" /></dt><dd>${rqt.horairesTravailVendrediMere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.communeLieuTravailMere.label" /></dt><dd>${rqt.communeLieuTravailMere?.toString()}</dd>

        
      </dl>
      
    
      
      <h4><g:message code="dccrr.property.informationPere.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.situationActuellePere.label" /></dt>
          <dd>
            <g:if test="${rqt.situationActuellePere}">
              <g:capdematEnumToField var="${rqt.situationActuellePere}" i18nKeyPrefix="dccrr.property.situationActuellePere" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dccrr.property.precisionAutreSituationActuellePere.label" /></dt><dd>${rqt.precisionAutreSituationActuellePere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.professionPere.label" /></dt><dd>${rqt.professionPere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.estHorairesReguliersPere.label" /></dt>
          <dd><g:message code="message.${rqt.estHorairesReguliersPere ? 'yes' : 'no'}" /></dd>
          

        
          <dt><g:message code="dccrr.property.horairesReguliersPere.label" /></dt><dd>${rqt.horairesReguliersPere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailLundiPere.label" /></dt><dd>${rqt.horairesTravailLundiPere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailMardiPere.label" /></dt><dd>${rqt.horairesTravailMardiPere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailMercrediPere.label" /></dt><dd>${rqt.horairesTravailMercrediPere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailJeudiPere.label" /></dt><dd>${rqt.horairesTravailJeudiPere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.horairesTravailVendrediPere.label" /></dt><dd>${rqt.horairesTravailVendrediPere?.toString()}</dd>

        
          <dt><g:message code="dccrr.property.communeLieuTravailPere.label" /></dt><dd>${rqt.communeLieuTravailPere?.toString()}</dd>

        
      </dl>
      
    
  

  
    <h3><g:message code="dccrr.step.accueil.label" /></h3>
    
      
      <dl>
        <dt><g:message code="dccrr.property.modeAccueil.label" /></dt>
          <dd><g:message code="message.${rqt.modeAccueil ? 'yes' : 'no'}" /></dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="dccrr.property.modeAccueilChoixUn.label" /></dt>
          <dd>
            <g:if test="${rqt.modeAccueilChoixUn}">
              <g:capdematEnumToField var="${rqt.modeAccueilChoixUn}" i18nKeyPrefix="dccrr.property.modeAccueilChoixUn" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="dccrr.property.modeAccueilChoixDeux.label" /></dt>
          <dd>
            <g:if test="${rqt.modeAccueilChoixDeux}">
              <g:capdematEnumToField var="${rqt.modeAccueilChoixDeux}" i18nKeyPrefix="dccrr.property.modeAccueilChoixDeux" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="dccrr.property.accueilAnterieur.label" /></dt><dd>${rqt.accueilAnterieur?.toString()}</dd>

      </dl>
      
    
      
      <h4><g:message code="dccrr.property.datePlacementAccueilRegulier.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.choixTypeDatePlacementAccueilRegulier.label" /></dt>
          <dd>
            <g:if test="${rqt.choixTypeDatePlacementAccueilRegulier}">
              <g:capdematEnumToField var="${rqt.choixTypeDatePlacementAccueilRegulier}" i18nKeyPrefix="dccrr.property.choixTypeDatePlacementAccueilRegulier" />
            </g:if>
          </dd>
          

        
          <dt><g:message code="dccrr.property.datePlacementDebut.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.datePlacementDebut}"/></dd>
          

        
          <dt><g:message code="dccrr.property.datePlacementFin.label" /></dt>
          <dd><g:formatDate formatName="format.date" date="${rqt.datePlacementFin}"/></dd>
          

        
      </dl>
      
    
      
      <dl>
        <dt><g:message code="dccrr.property.choixHorairesAccueil.label" /></dt>
          <dd>
            <g:if test="${rqt.choixHorairesAccueil}">
              <g:capdematEnumToField var="${rqt.choixHorairesAccueil}" i18nKeyPrefix="dccrr.property.choixHorairesAccueil" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <h4><g:message code="dccrr.property.plageHoraireAccueilReguliere.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.horairePlacementMatinDebut.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebut?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebut && rqt.horairePlacementMatinDebut.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebut?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementMatinFin.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFin?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFin && rqt.horairePlacementMatinFin.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFin?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiDebut.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebut?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebut && rqt.horairePlacementApresMidiDebut.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebut?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiFin.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFin?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFin && rqt.horairePlacementApresMidiFin.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFin?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dccrr.property.lundi.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.horairePlacementMatinDebutLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutLundi && rqt.horairePlacementMatinDebutLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutLundi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementMatinFinLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinLundi && rqt.horairePlacementMatinFinLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinLundi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiDebutLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutLundi && rqt.horairePlacementApresMidiDebutLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutLundi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiFinLundi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinLundi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinLundi && rqt.horairePlacementApresMidiFinLundi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinLundi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dccrr.property.mardi.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.horairePlacementMatinDebutMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutMardi && rqt.horairePlacementMatinDebutMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutMardi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementMatinFinMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinMardi && rqt.horairePlacementMatinFinMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinMardi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiDebutMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutMardi && rqt.horairePlacementApresMidiDebutMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutMardi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiFinMardi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinMardi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinMardi && rqt.horairePlacementApresMidiFinMardi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinMardi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dccrr.property.mercredi.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.horairePlacementMatinDebutMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutMercredi && rqt.horairePlacementMatinDebutMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutMercredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementMatinFinMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinMercredi && rqt.horairePlacementMatinFinMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinMercredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiDebutMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutMercredi && rqt.horairePlacementApresMidiDebutMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutMercredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiFinMercredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinMercredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinMercredi && rqt.horairePlacementApresMidiFinMercredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinMercredi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dccrr.property.jeudi.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.horairePlacementMatinDebutJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutJeudi && rqt.horairePlacementMatinDebutJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutJeudi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementMatinFinJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinJeudi && rqt.horairePlacementMatinFinJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinJeudi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiDebutJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutJeudi && rqt.horairePlacementApresMidiDebutJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutJeudi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiFinJeudi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinJeudi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinJeudi && rqt.horairePlacementApresMidiFinJeudi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinJeudi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
      
      <h4><g:message code="dccrr.property.vendredi.label" /></h4>
      <dl>
        
          <dt><g:message code="dccrr.property.horairePlacementMatinDebutVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinDebutVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinDebutVendredi && rqt.horairePlacementMatinDebutVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinDebutVendredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementMatinFinVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementMatinFinVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementMatinFinVendredi && rqt.horairePlacementMatinFinVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementMatinFinVendredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiDebutVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiDebutVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiDebutVendredi && rqt.horairePlacementApresMidiDebutVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiDebutVendredi?.getMinuteOfHour()}
          </dd>
          

        
          <dt><g:message code="dccrr.property.horairePlacementApresMidiFinVendredi.label" /></dt>
          <dd>
            ${rqt.horairePlacementApresMidiFinVendredi?.getHourOfDay()} : 
            <g:if test="${rqt.horairePlacementApresMidiFinVendredi && rqt.horairePlacementApresMidiFinVendredi.getMinuteOfHour() < 10}">
            0</g:if>${rqt.horairePlacementApresMidiFinVendredi?.getMinuteOfHour()}
          </dd>
          

        
      </dl>
      
    
  

  
    <h3><g:message code="dccrr.step.rendezVous.label" /></h3>
    
      
      <dl>
        <dt><g:message code="dccrr.property.choixTypeRendezVous.label" /></dt>
          <dd>
            <g:if test="${rqt.choixTypeRendezVous}">
              <g:capdematEnumToField var="${rqt.choixTypeRendezVous}" i18nKeyPrefix="dccrr.property.choixTypeRendezVous" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="dccrr.property.telephoneContact.label" /></dt><dd>${rqt.telephoneContact?.toString()}</dd>

      </dl>
      
    
      
      <dl>
        <dt><g:message code="dccrr.property.plageHoraireContact.label" /></dt>
          <dd>
            <g:if test="${rqt.plageHoraireContact}">
              <g:capdematEnumToField var="${rqt.plageHoraireContact}" i18nKeyPrefix="dccrr.property.plageHoraireContact" />
            </g:if>
          </dd>
          

      </dl>
      
    
      
      <dl>
        <dt><g:message code="dccrr.property.commentaireCitoyen.label" /></dt><dd>${rqt.commentaireCitoyen?.toString()}</dd>

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
          <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}?isRequestCreation=true" target="blank" title="${message(code:'document.message.preview.longdesc')}">${message(code:'document.message.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        ${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  

  


