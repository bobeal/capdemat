


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="dccrr.step.subject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="dccrr.step.accueil.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="dccrr.step.rendezVous.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="dccrr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="dccrr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'dccrr.property.dixHuitMoisEnfant.label')}&nbsp;:</dt><dd id="dixHuitMoisEnfant" class="action-editField validate-date i18n-dccrr.property.dixHuitMoisEnfant" ><span><g:formatDate formatName="format.date" date="${rqt?.dixHuitMoisEnfant}"/></span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="dccrr.property.informationMere.label" /></h3>
              <dl class="required">
                
                  <dt class="condition-estAutreSituationActuelleMere-trigger">${message(code:'dccrr.property.situationActuelleMere.label')}&nbsp;:</dt><dd id="situationActuelleMere" class="action-editField validate-capdematEnum i18n-dccrr.property.situationActuelleMere javatype-fr.cg95.cvq.business.request.school.ChoixSituationActuelle" ><g:capdematEnumToField var="${rqt?.situationActuelleMere}" i18nKeyPrefix="dccrr.property.situationActuelleMere" /></dd>
                
                  <dt class="required condition-estAutreSituationActuelleMere-filled">${message(code:'dccrr.property.precisionAutreSituationActuelleMere.label')}&nbsp;*&nbsp;:</dt><dd id="precisionAutreSituationActuelleMere" class="action-editField validate-string required-true i18n-dccrr.property.precisionAutreSituationActuelleMere" ><span>${rqt?.precisionAutreSituationActuelleMere}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.professionMere.label')}&nbsp;:</dt><dd id="professionMere" class="action-editField validate-string i18n-dccrr.property.professionMere" ><span>${rqt?.professionMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-trigger">${message(code:'dccrr.property.estHorairesReguliersMere.label')}&nbsp;:</dt><dd id="estHorairesReguliersMere" class="action-editField validate-boolean i18n-dccrr.property.estHorairesReguliersMere" ><span class="value-${rqt?.estHorairesReguliersMere}"><g:message code="${rqt?.estHorairesReguliersMere ? 'message.yes' : rqt?.estHorairesReguliersMere==null ? '' : 'message.no'}" /></span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-filled">${message(code:'dccrr.property.horairesReguliersMere.label')}&nbsp;:</dt><dd id="horairesReguliersMere" class="action-editField validate-string i18n-dccrr.property.horairesReguliersMere" ><span>${rqt?.horairesReguliersMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled">${message(code:'dccrr.property.horairesTravailLundiMere.label')}&nbsp;:</dt><dd id="horairesTravailLundiMere" class="action-editField validate-string i18n-dccrr.property.horairesTravailLundiMere" ><span>${rqt?.horairesTravailLundiMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled">${message(code:'dccrr.property.horairesTravailMardiMere.label')}&nbsp;:</dt><dd id="horairesTravailMardiMere" class="action-editField validate-string i18n-dccrr.property.horairesTravailMardiMere" ><span>${rqt?.horairesTravailMardiMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled">${message(code:'dccrr.property.horairesTravailMercrediMere.label')}&nbsp;:</dt><dd id="horairesTravailMercrediMere" class="action-editField validate-string i18n-dccrr.property.horairesTravailMercrediMere" ><span>${rqt?.horairesTravailMercrediMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled">${message(code:'dccrr.property.horairesTravailJeudiMere.label')}&nbsp;:</dt><dd id="horairesTravailJeudiMere" class="action-editField validate-string i18n-dccrr.property.horairesTravailJeudiMere" ><span>${rqt?.horairesTravailJeudiMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled">${message(code:'dccrr.property.horairesTravailVendrediMere.label')}&nbsp;:</dt><dd id="horairesTravailVendrediMere" class="action-editField validate-string i18n-dccrr.property.horairesTravailVendrediMere" ><span>${rqt?.horairesTravailVendrediMere}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.communeLieuTravailMere.label')}&nbsp;:</dt><dd id="communeLieuTravailMere" class="action-editField validate-string i18n-dccrr.property.communeLieuTravailMere" ><span>${rqt?.communeLieuTravailMere}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.informationPere.label" /></h3>
              <dl class="">
                
                  <dt class="condition-estAutreSituationActuellePere-trigger">${message(code:'dccrr.property.situationActuellePere.label')}&nbsp;:</dt><dd id="situationActuellePere" class="action-editField validate-capdematEnum i18n-dccrr.property.situationActuellePere javatype-fr.cg95.cvq.business.request.school.ChoixSituationActuelle" ><g:capdematEnumToField var="${rqt?.situationActuellePere}" i18nKeyPrefix="dccrr.property.situationActuellePere" /></dd>
                
                  <dt class="required condition-estAutreSituationActuellePere-filled">${message(code:'dccrr.property.precisionAutreSituationActuellePere.label')}&nbsp;*&nbsp;:</dt><dd id="precisionAutreSituationActuellePere" class="action-editField validate-string required-true i18n-dccrr.property.precisionAutreSituationActuellePere" ><span>${rqt?.precisionAutreSituationActuellePere}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.professionPere.label')}&nbsp;:</dt><dd id="professionPere" class="action-editField validate-string i18n-dccrr.property.professionPere" ><span>${rqt?.professionPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-trigger">${message(code:'dccrr.property.estHorairesReguliersPere.label')}&nbsp;:</dt><dd id="estHorairesReguliersPere" class="action-editField validate-boolean i18n-dccrr.property.estHorairesReguliersPere" ><span class="value-${rqt?.estHorairesReguliersPere}"><g:message code="${rqt?.estHorairesReguliersPere ? 'message.yes' : rqt?.estHorairesReguliersPere==null ? '' : 'message.no'}" /></span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-filled">${message(code:'dccrr.property.horairesReguliersPere.label')}&nbsp;:</dt><dd id="horairesReguliersPere" class="action-editField validate-string i18n-dccrr.property.horairesReguliersPere" ><span>${rqt?.horairesReguliersPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled">${message(code:'dccrr.property.horairesTravailLundiPere.label')}&nbsp;:</dt><dd id="horairesTravailLundiPere" class="action-editField validate-string i18n-dccrr.property.horairesTravailLundiPere" ><span>${rqt?.horairesTravailLundiPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled">${message(code:'dccrr.property.horairesTravailMardiPere.label')}&nbsp;:</dt><dd id="horairesTravailMardiPere" class="action-editField validate-string i18n-dccrr.property.horairesTravailMardiPere" ><span>${rqt?.horairesTravailMardiPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled">${message(code:'dccrr.property.horairesTravailMercrediPere.label')}&nbsp;:</dt><dd id="horairesTravailMercrediPere" class="action-editField validate-string i18n-dccrr.property.horairesTravailMercrediPere" ><span>${rqt?.horairesTravailMercrediPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled">${message(code:'dccrr.property.horairesTravailJeudiPere.label')}&nbsp;:</dt><dd id="horairesTravailJeudiPere" class="action-editField validate-string i18n-dccrr.property.horairesTravailJeudiPere" ><span>${rqt?.horairesTravailJeudiPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled">${message(code:'dccrr.property.horairesTravailVendrediPere.label')}&nbsp;:</dt><dd id="horairesTravailVendrediPere" class="action-editField validate-string i18n-dccrr.property.horairesTravailVendrediPere" ><span>${rqt?.horairesTravailVendrediPere}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.communeLieuTravailPere.label')}&nbsp;:</dt><dd id="communeLieuTravailPere" class="action-editField validate-string i18n-dccrr.property.communeLieuTravailPere" ><span>${rqt?.communeLieuTravailPere}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="dccrr.step.accueil.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-estIndifferent-trigger">${message(code:'dccrr.property.modeAccueil.label')}&nbsp;*&nbsp;:</dt><dd id="modeAccueil" class="action-editField validate-boolean required-true i18n-dccrr.property.modeAccueil" ><span class="value-${rqt?.modeAccueil}"><g:message code="${rqt?.modeAccueil ? 'message.yes' : rqt?.modeAccueil==null ? '' : 'message.no'}" /></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-estIndifferent-filled">${message(code:'dccrr.property.modeAccueilChoixUn.label')}&nbsp;*&nbsp;:</dt><dd id="modeAccueilChoixUn" class="action-editField validate-capdematEnum required-true i18n-dccrr.property.modeAccueilChoixUn javatype-fr.cg95.cvq.business.request.school.ModeAccueilType" ><g:capdematEnumToField var="${rqt?.modeAccueilChoixUn}" i18nKeyPrefix="dccrr.property.modeAccueilChoixUn" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="condition-estIndifferent-filled">${message(code:'dccrr.property.modeAccueilChoixDeux.label')}&nbsp;:</dt><dd id="modeAccueilChoixDeux" class="action-editField validate-capdematEnum i18n-dccrr.property.modeAccueilChoixDeux javatype-fr.cg95.cvq.business.request.school.ModeAccueilType" ><g:capdematEnumToField var="${rqt?.modeAccueilChoixDeux}" i18nKeyPrefix="dccrr.property.modeAccueilChoixDeux" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'dccrr.property.accueilAnterieur.label')}&nbsp;:</dt><dd id="accueilAnterieur" class="action-editField validate-string i18n-dccrr.property.accueilAnterieur" ><span>${rqt?.accueilAnterieur}</span></dd>
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.datePlacementAccueilRegulier.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-dateConnue-trigger">${message(code:'dccrr.property.choixTypeDatePlacementAccueilRegulier.label')}&nbsp;*&nbsp;:</dt><dd id="choixTypeDatePlacementAccueilRegulier" class="action-editField validate-capdematEnum required-true i18n-dccrr.property.choixTypeDatePlacementAccueilRegulier javatype-fr.cg95.cvq.business.request.school.ChoixDatePlacement" ><g:capdematEnumToField var="${rqt?.choixTypeDatePlacementAccueilRegulier}" i18nKeyPrefix="dccrr.property.choixTypeDatePlacementAccueilRegulier" /></dd>
                
                  <dt class="required condition-dateConnue-filled">${message(code:'dccrr.property.datePlacementDebut.label')}&nbsp;*&nbsp;:</dt><dd id="datePlacementDebut" class="action-editField validate-date required-true i18n-dccrr.property.datePlacementDebut" ><span><g:formatDate formatName="format.date" date="${rqt?.datePlacementDebut}"/></span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-estHorairesAccueilRegulier-trigger condition-estHorairesAccueilIrregulier-trigger">${message(code:'dccrr.property.choixHorairesAccueil.label')}&nbsp;*&nbsp;:</dt><dd id="choixHorairesAccueil" class="action-editField validate-capdematEnum required-true i18n-dccrr.property.choixHorairesAccueil javatype-fr.cg95.cvq.business.request.school.ChoixHorairesAccueilType" ><g:capdematEnumToField var="${rqt?.choixHorairesAccueil}" i18nKeyPrefix="dccrr.property.choixHorairesAccueil" /></dd>
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.plageHoraireAccueilReguliere.label" /></h3>
              <dl class="required condition-estHorairesAccueilRegulier-filled">
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinDebut.label')}&nbsp;:</dt><dd id="horairePlacementMatinDebut" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinDebut" ><span>${rqt.horairePlacementMatinDebut?.getHourOfDay()} : ${rqt.horairePlacementMatinDebut && rqt.horairePlacementMatinDebut.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebut?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinFin.label')}&nbsp;:</dt><dd id="horairePlacementMatinFin" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinFin" ><span>${rqt.horairePlacementMatinFin?.getHourOfDay()} : ${rqt.horairePlacementMatinFin && rqt.horairePlacementMatinFin.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFin?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiDebut.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiDebut" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiDebut" ><span>${rqt.horairePlacementApresMidiDebut?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebut && rqt.horairePlacementApresMidiDebut.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebut?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiFin.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiFin" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiFin" ><span>${rqt.horairePlacementApresMidiFin?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFin && rqt.horairePlacementApresMidiFin.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFin?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.lundi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinDebutLundi.label')}&nbsp;:</dt><dd id="horairePlacementMatinDebutLundi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinDebutLundi" ><span>${rqt.horairePlacementMatinDebutLundi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutLundi && rqt.horairePlacementMatinDebutLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutLundi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinFinLundi.label')}&nbsp;:</dt><dd id="horairePlacementMatinFinLundi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinFinLundi" ><span>${rqt.horairePlacementMatinFinLundi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinLundi && rqt.horairePlacementMatinFinLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinLundi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiDebutLundi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiDebutLundi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiDebutLundi" ><span>${rqt.horairePlacementApresMidiDebutLundi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutLundi && rqt.horairePlacementApresMidiDebutLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutLundi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiFinLundi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiFinLundi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiFinLundi" ><span>${rqt.horairePlacementApresMidiFinLundi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinLundi && rqt.horairePlacementApresMidiFinLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinLundi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.mardi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinDebutMardi.label')}&nbsp;:</dt><dd id="horairePlacementMatinDebutMardi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinDebutMardi" ><span>${rqt.horairePlacementMatinDebutMardi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutMardi && rqt.horairePlacementMatinDebutMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutMardi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinFinMardi.label')}&nbsp;:</dt><dd id="horairePlacementMatinFinMardi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinFinMardi" ><span>${rqt.horairePlacementMatinFinMardi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinMardi && rqt.horairePlacementMatinFinMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinMardi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiDebutMardi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiDebutMardi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiDebutMardi" ><span>${rqt.horairePlacementApresMidiDebutMardi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutMardi && rqt.horairePlacementApresMidiDebutMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutMardi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiFinMardi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiFinMardi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiFinMardi" ><span>${rqt.horairePlacementApresMidiFinMardi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinMardi && rqt.horairePlacementApresMidiFinMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinMardi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.mercredi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinDebutMercredi.label')}&nbsp;:</dt><dd id="horairePlacementMatinDebutMercredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinDebutMercredi" ><span>${rqt.horairePlacementMatinDebutMercredi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutMercredi && rqt.horairePlacementMatinDebutMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutMercredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinFinMercredi.label')}&nbsp;:</dt><dd id="horairePlacementMatinFinMercredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinFinMercredi" ><span>${rqt.horairePlacementMatinFinMercredi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinMercredi && rqt.horairePlacementMatinFinMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinMercredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiDebutMercredi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiDebutMercredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiDebutMercredi" ><span>${rqt.horairePlacementApresMidiDebutMercredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutMercredi && rqt.horairePlacementApresMidiDebutMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutMercredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiFinMercredi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiFinMercredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiFinMercredi" ><span>${rqt.horairePlacementApresMidiFinMercredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinMercredi && rqt.horairePlacementApresMidiFinMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinMercredi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.jeudi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinDebutJeudi.label')}&nbsp;:</dt><dd id="horairePlacementMatinDebutJeudi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinDebutJeudi" ><span>${rqt.horairePlacementMatinDebutJeudi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutJeudi && rqt.horairePlacementMatinDebutJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutJeudi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinFinJeudi.label')}&nbsp;:</dt><dd id="horairePlacementMatinFinJeudi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinFinJeudi" ><span>${rqt.horairePlacementMatinFinJeudi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinJeudi && rqt.horairePlacementMatinFinJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinJeudi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiDebutJeudi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiDebutJeudi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiDebutJeudi" ><span>${rqt.horairePlacementApresMidiDebutJeudi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutJeudi && rqt.horairePlacementApresMidiDebutJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutJeudi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiFinJeudi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiFinJeudi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiFinJeudi" ><span>${rqt.horairePlacementApresMidiFinJeudi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinJeudi && rqt.horairePlacementApresMidiFinJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinJeudi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="dccrr.property.vendredi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinDebutVendredi.label')}&nbsp;:</dt><dd id="horairePlacementMatinDebutVendredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinDebutVendredi" ><span>${rqt.horairePlacementMatinDebutVendredi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutVendredi && rqt.horairePlacementMatinDebutVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutVendredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementMatinFinVendredi.label')}&nbsp;:</dt><dd id="horairePlacementMatinFinVendredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementMatinFinVendredi" ><span>${rqt.horairePlacementMatinFinVendredi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinVendredi && rqt.horairePlacementMatinFinVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinVendredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiDebutVendredi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiDebutVendredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiDebutVendredi" ><span>${rqt.horairePlacementApresMidiDebutVendredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutVendredi && rqt.horairePlacementApresMidiDebutVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutVendredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class="">${message(code:'dccrr.property.horairePlacementApresMidiFinVendredi.label')}&nbsp;:</dt><dd id="horairePlacementApresMidiFinVendredi" class="action-editField validate-time i18n-dccrr.property.horairePlacementApresMidiFinVendredi" ><span>${rqt.horairePlacementApresMidiFinVendredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinVendredi && rqt.horairePlacementApresMidiFinVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinVendredi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="dccrr.step.rendezVous.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required">${message(code:'dccrr.property.choixTypeRendezVous.label')}&nbsp;*&nbsp;:</dt><dd id="choixTypeRendezVous" class="action-editField validate-capdematEnum required-true i18n-dccrr.property.choixTypeRendezVous javatype-fr.cg95.cvq.business.request.school.RendezVousType" ><g:capdematEnumToField var="${rqt?.choixTypeRendezVous}" i18nKeyPrefix="dccrr.property.choixTypeRendezVous" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'dccrr.property.telephoneContact.label')}&nbsp;*&nbsp;:</dt><dd id="telephoneContact" class="action-editField validate-phone required-true i18n-dccrr.property.telephoneContact maxLength-10" ><span>${rqt?.telephoneContact}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'dccrr.property.plageHoraireContact.label')}&nbsp;*&nbsp;:</dt><dd id="plageHoraireContact" class="action-editField validate-capdematEnum required-true i18n-dccrr.property.plageHoraireContact javatype-fr.cg95.cvq.business.request.school.PlageHoraireContactType" ><g:capdematEnumToField var="${rqt?.plageHoraireContact}" i18nKeyPrefix="dccrr.property.plageHoraireContact" /></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="">${message(code:'dccrr.property.commentaireCitoyen.label')}&nbsp;:</dt><dd id="commentaireCitoyen" class="action-editField validate-textarea i18n-dccrr.property.commentaireCitoyen rows-10 maxLength-600" ><span>${rqt?.commentaireCitoyen}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
