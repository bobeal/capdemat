


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="sdccrr.step.subject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="sdccrr.step.accueil.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="sdccrr.step.rendezVous.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="sdccrr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sdccrr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.informationMere.label" /></h3>
              <dl class="required">
                
                  <dt class="condition-estAutreSituationActuelleMere-trigger"><g:message code="sdccrr.property.situationActuelleMere.label" />  : </dt><dd id="situationActuelleMere" class="action-editField validate-capdematEnum i18n-sdccrr.property.situationActuelleMere javatype-fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle" ><g:capdematEnumToField var="${rqt?.situationActuelleMere}" i18nKeyPrefix="sdccrr.property.situationActuelleMere" /></dd>
                
                  <dt class="required condition-estAutreSituationActuelleMere-filled"><g:message code="sdccrr.property.precisionAutreSituationActuelleMere.label" /> * : </dt><dd id="precisionAutreSituationActuelleMere" class="action-editField validate-string required-true i18n-sdccrr.property.precisionAutreSituationActuelleMere" ><span>${rqt?.precisionAutreSituationActuelleMere}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.professionMere.label" />  : </dt><dd id="professionMere" class="action-editField validate-string i18n-sdccrr.property.professionMere" ><span>${rqt?.professionMere}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.employeurMere.label" />  : </dt><dd id="employeurMere" class="action-editField validate-string i18n-sdccrr.property.employeurMere" ><span>${rqt?.employeurMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-trigger"><g:message code="sdccrr.property.estHorairesReguliersMere.label" />  : </dt><dd id="estHorairesReguliersMere" class="action-editField validate-boolean i18n-sdccrr.property.estHorairesReguliersMere" ><span class="value-${rqt?.estHorairesReguliersMere}"><g:message code="message.${rqt?.estHorairesReguliersMere ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-filled"><g:message code="sdccrr.property.horairesReguliersMere.label" />  : </dt><dd id="horairesReguliersMere" class="action-editField validate-string i18n-sdccrr.property.horairesReguliersMere" ><span>${rqt?.horairesReguliersMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailLundiMere.label" />  : </dt><dd id="horairesTravailLundiMere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailLundiMere" ><span>${rqt?.horairesTravailLundiMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailMardiMere.label" />  : </dt><dd id="horairesTravailMardiMere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailMardiMere" ><span>${rqt?.horairesTravailMardiMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailMercrediMere.label" />  : </dt><dd id="horairesTravailMercrediMere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailMercrediMere" ><span>${rqt?.horairesTravailMercrediMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailJeudiMere.label" />  : </dt><dd id="horairesTravailJeudiMere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailJeudiMere" ><span>${rqt?.horairesTravailJeudiMere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersMere-unfilled"><g:message code="sdccrr.property.horairesTravailVendrediMere.label" />  : </dt><dd id="horairesTravailVendrediMere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailVendrediMere" ><span>${rqt?.horairesTravailVendrediMere}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.communeLieuTravailMere.label" />  : </dt><dd id="communeLieuTravailMere" class="action-editField validate-string i18n-sdccrr.property.communeLieuTravailMere" ><span>${rqt?.communeLieuTravailMere}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="sdccrr.property.dixHuitMoisEnfant.label" />  : </dt><dd id="dixHuitMoisEnfant" class="action-editField validate-date i18n-sdccrr.property.dixHuitMoisEnfant" ><span><g:formatDate formatName="format.date" date="${rqt?.dixHuitMoisEnfant}"/></span></dd>
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.informationPere.label" /></h3>
              <dl class="">
                
                  <dt class="condition-estAutreSituationActuellePere-trigger"><g:message code="sdccrr.property.situationActuellePere.label" />  : </dt><dd id="situationActuellePere" class="action-editField validate-capdematEnum i18n-sdccrr.property.situationActuellePere javatype-fr.cg95.cvq.business.request.babyhood.SdccrrChoixSituationActuelle" ><g:capdematEnumToField var="${rqt?.situationActuellePere}" i18nKeyPrefix="sdccrr.property.situationActuellePere" /></dd>
                
                  <dt class="required condition-estAutreSituationActuellePere-filled"><g:message code="sdccrr.property.precisionAutreSituationActuellePere.label" /> * : </dt><dd id="precisionAutreSituationActuellePere" class="action-editField validate-string required-true i18n-sdccrr.property.precisionAutreSituationActuellePere" ><span>${rqt?.precisionAutreSituationActuellePere}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.professionPere.label" />  : </dt><dd id="professionPere" class="action-editField validate-string i18n-sdccrr.property.professionPere" ><span>${rqt?.professionPere}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.employeurPere.label" />  : </dt><dd id="employeurPere" class="action-editField validate-string i18n-sdccrr.property.employeurPere" ><span>${rqt?.employeurPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-trigger"><g:message code="sdccrr.property.estHorairesReguliersPere.label" />  : </dt><dd id="estHorairesReguliersPere" class="action-editField validate-boolean i18n-sdccrr.property.estHorairesReguliersPere" ><span class="value-${rqt?.estHorairesReguliersPere}"><g:message code="message.${rqt?.estHorairesReguliersPere ? 'yes' : 'no'}" /></span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-filled"><g:message code="sdccrr.property.horairesReguliersPere.label" />  : </dt><dd id="horairesReguliersPere" class="action-editField validate-string i18n-sdccrr.property.horairesReguliersPere" ><span>${rqt?.horairesReguliersPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailLundiPere.label" />  : </dt><dd id="horairesTravailLundiPere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailLundiPere" ><span>${rqt?.horairesTravailLundiPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailMardiPere.label" />  : </dt><dd id="horairesTravailMardiPere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailMardiPere" ><span>${rqt?.horairesTravailMardiPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailMercrediPere.label" />  : </dt><dd id="horairesTravailMercrediPere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailMercrediPere" ><span>${rqt?.horairesTravailMercrediPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailJeudiPere.label" />  : </dt><dd id="horairesTravailJeudiPere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailJeudiPere" ><span>${rqt?.horairesTravailJeudiPere}</span></dd>
                
                  <dt class="condition-estHorairesReguliersPere-unfilled"><g:message code="sdccrr.property.horairesTravailVendrediPere.label" />  : </dt><dd id="horairesTravailVendrediPere" class="action-editField validate-string i18n-sdccrr.property.horairesTravailVendrediPere" ><span>${rqt?.horairesTravailVendrediPere}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.communeLieuTravailPere.label" />  : </dt><dd id="communeLieuTravailPere" class="action-editField validate-string i18n-sdccrr.property.communeLieuTravailPere" ><span>${rqt?.communeLieuTravailPere}</span></dd>
                
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
          <span><g:message code="sdccrr.step.accueil.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <h3><g:message code="sdccrr.property.datePlacementAccueilRegulier.label" /></h3>
              <dl class="required">
                
                  <dt class="required condition-dateConnue-trigger"><g:message code="sdccrr.property.choixTypeDatePlacementAccueilRegulier.label" /> * : </dt><dd id="choixTypeDatePlacementAccueilRegulier" class="action-editField validate-capdematEnum required-true i18n-sdccrr.property.choixTypeDatePlacementAccueilRegulier javatype-fr.cg95.cvq.business.request.babyhood.SdccrrChoixDatePlacement" ><g:capdematEnumToField var="${rqt?.choixTypeDatePlacementAccueilRegulier}" i18nKeyPrefix="sdccrr.property.choixTypeDatePlacementAccueilRegulier" /></dd>
                
                  <dt class="required condition-dateConnue-filled"><g:message code="sdccrr.property.datePlacementDebut.label" /> * : </dt><dd id="datePlacementDebut" class="action-editField validate-date required-true i18n-sdccrr.property.datePlacementDebut" ><span><g:formatDate formatName="format.date" date="${rqt?.datePlacementDebut}"/></span></dd>
                
                  <dt class="condition-dateConnue-filled"><g:message code="sdccrr.property.datePlacementFin.label" />  : </dt><dd id="datePlacementFin" class="action-editField validate-date i18n-sdccrr.property.datePlacementFin" ><span><g:formatDate formatName="format.date" date="${rqt?.datePlacementFin}"/></span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-estHorairesAccueilRegulier-trigger condition-estHorairesAccueilIrregulier-trigger"><g:message code="sdccrr.property.choixHorairesAccueil.label" /> * : </dt><dd id="choixHorairesAccueil" class="action-editField validate-capdematEnum required-true i18n-sdccrr.property.choixHorairesAccueil javatype-fr.cg95.cvq.business.request.babyhood.SdccrrChoixHorairesAccueilType" ><g:capdematEnumToField var="${rqt?.choixHorairesAccueil}" i18nKeyPrefix="sdccrr.property.choixHorairesAccueil" /></dd>
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.plageHoraireAccueilReguliere.label" /></h3>
              <dl class="required condition-estHorairesAccueilRegulier-filled">
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinDebut.label" />  : </dt><dd id="horairePlacementMatinDebut" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinDebut" ><span>${rqt.horairePlacementMatinDebut?.getHourOfDay()} : ${rqt.horairePlacementMatinDebut && rqt.horairePlacementMatinDebut.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebut?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinFin.label" />  : </dt><dd id="horairePlacementMatinFin" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinFin" ><span>${rqt.horairePlacementMatinFin?.getHourOfDay()} : ${rqt.horairePlacementMatinFin && rqt.horairePlacementMatinFin.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFin?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiDebut.label" />  : </dt><dd id="horairePlacementApresMidiDebut" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiDebut" ><span>${rqt.horairePlacementApresMidiDebut?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebut && rqt.horairePlacementApresMidiDebut.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebut?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiFin.label" />  : </dt><dd id="horairePlacementApresMidiFin" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiFin" ><span>${rqt.horairePlacementApresMidiFin?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFin && rqt.horairePlacementApresMidiFin.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFin?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.lundi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinDebutLundi.label" />  : </dt><dd id="horairePlacementMatinDebutLundi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinDebutLundi" ><span>${rqt.horairePlacementMatinDebutLundi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutLundi && rqt.horairePlacementMatinDebutLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutLundi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinFinLundi.label" />  : </dt><dd id="horairePlacementMatinFinLundi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinFinLundi" ><span>${rqt.horairePlacementMatinFinLundi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinLundi && rqt.horairePlacementMatinFinLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinLundi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiDebutLundi.label" />  : </dt><dd id="horairePlacementApresMidiDebutLundi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiDebutLundi" ><span>${rqt.horairePlacementApresMidiDebutLundi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutLundi && rqt.horairePlacementApresMidiDebutLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutLundi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiFinLundi.label" />  : </dt><dd id="horairePlacementApresMidiFinLundi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiFinLundi" ><span>${rqt.horairePlacementApresMidiFinLundi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinLundi && rqt.horairePlacementApresMidiFinLundi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinLundi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.mardi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinDebutMardi.label" />  : </dt><dd id="horairePlacementMatinDebutMardi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinDebutMardi" ><span>${rqt.horairePlacementMatinDebutMardi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutMardi && rqt.horairePlacementMatinDebutMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutMardi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinFinMardi.label" />  : </dt><dd id="horairePlacementMatinFinMardi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinFinMardi" ><span>${rqt.horairePlacementMatinFinMardi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinMardi && rqt.horairePlacementMatinFinMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinMardi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiDebutMardi.label" />  : </dt><dd id="horairePlacementApresMidiDebutMardi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiDebutMardi" ><span>${rqt.horairePlacementApresMidiDebutMardi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutMardi && rqt.horairePlacementApresMidiDebutMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutMardi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiFinMardi.label" />  : </dt><dd id="horairePlacementApresMidiFinMardi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiFinMardi" ><span>${rqt.horairePlacementApresMidiFinMardi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinMardi && rqt.horairePlacementApresMidiFinMardi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinMardi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.mercredi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinDebutMercredi.label" />  : </dt><dd id="horairePlacementMatinDebutMercredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinDebutMercredi" ><span>${rqt.horairePlacementMatinDebutMercredi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutMercredi && rqt.horairePlacementMatinDebutMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutMercredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinFinMercredi.label" />  : </dt><dd id="horairePlacementMatinFinMercredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinFinMercredi" ><span>${rqt.horairePlacementMatinFinMercredi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinMercredi && rqt.horairePlacementMatinFinMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinMercredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiDebutMercredi.label" />  : </dt><dd id="horairePlacementApresMidiDebutMercredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiDebutMercredi" ><span>${rqt.horairePlacementApresMidiDebutMercredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutMercredi && rqt.horairePlacementApresMidiDebutMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutMercredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiFinMercredi.label" />  : </dt><dd id="horairePlacementApresMidiFinMercredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiFinMercredi" ><span>${rqt.horairePlacementApresMidiFinMercredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinMercredi && rqt.horairePlacementApresMidiFinMercredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinMercredi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.jeudi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinDebutJeudi.label" />  : </dt><dd id="horairePlacementMatinDebutJeudi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinDebutJeudi" ><span>${rqt.horairePlacementMatinDebutJeudi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutJeudi && rqt.horairePlacementMatinDebutJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutJeudi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinFinJeudi.label" />  : </dt><dd id="horairePlacementMatinFinJeudi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinFinJeudi" ><span>${rqt.horairePlacementMatinFinJeudi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinJeudi && rqt.horairePlacementMatinFinJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinJeudi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiDebutJeudi.label" />  : </dt><dd id="horairePlacementApresMidiDebutJeudi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiDebutJeudi" ><span>${rqt.horairePlacementApresMidiDebutJeudi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutJeudi && rqt.horairePlacementApresMidiDebutJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutJeudi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiFinJeudi.label" />  : </dt><dd id="horairePlacementApresMidiFinJeudi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiFinJeudi" ><span>${rqt.horairePlacementApresMidiFinJeudi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinJeudi && rqt.horairePlacementApresMidiFinJeudi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinJeudi?.getMinuteOfHour()}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="sdccrr.property.vendredi.label" /></h3>
              <dl class="required condition-estHorairesAccueilIrregulier-filled">
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinDebutVendredi.label" />  : </dt><dd id="horairePlacementMatinDebutVendredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinDebutVendredi" ><span>${rqt.horairePlacementMatinDebutVendredi?.getHourOfDay()} : ${rqt.horairePlacementMatinDebutVendredi && rqt.horairePlacementMatinDebutVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinDebutVendredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementMatinFinVendredi.label" />  : </dt><dd id="horairePlacementMatinFinVendredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementMatinFinVendredi" ><span>${rqt.horairePlacementMatinFinVendredi?.getHourOfDay()} : ${rqt.horairePlacementMatinFinVendredi && rqt.horairePlacementMatinFinVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementMatinFinVendredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiDebutVendredi.label" />  : </dt><dd id="horairePlacementApresMidiDebutVendredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiDebutVendredi" ><span>${rqt.horairePlacementApresMidiDebutVendredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiDebutVendredi && rqt.horairePlacementApresMidiDebutVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiDebutVendredi?.getMinuteOfHour()}</span></dd>
                
                  <dt class=""><g:message code="sdccrr.property.horairePlacementApresMidiFinVendredi.label" />  : </dt><dd id="horairePlacementApresMidiFinVendredi" class="action-editField validate-time i18n-sdccrr.property.horairePlacementApresMidiFinVendredi" ><span>${rqt.horairePlacementApresMidiFinVendredi?.getHourOfDay()} : ${rqt.horairePlacementApresMidiFinVendredi && rqt.horairePlacementApresMidiFinVendredi.getMinuteOfHour() < 10 ? '0' : ''}${rqt.horairePlacementApresMidiFinVendredi?.getMinuteOfHour()}</span></dd>
                
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
          <span><g:message code="sdccrr.step.rendezVous.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="sdccrr.property.choixTypeRendezVous.label" /> * : </dt><dd id="choixTypeRendezVous" class="action-editField validate-capdematEnum required-true i18n-sdccrr.property.choixTypeRendezVous javatype-fr.cg95.cvq.business.request.babyhood.SdccrrRendezVousType" ><g:capdematEnumToField var="${rqt?.choixTypeRendezVous}" i18nKeyPrefix="sdccrr.property.choixTypeRendezVous" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sdccrr.property.telephoneContact.label" /> * : </dt><dd id="telephoneContact" class="action-editField validate-phone required-true i18n-sdccrr.property.telephoneContact maxLength-10" ><span>${rqt?.telephoneContact}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="sdccrr.property.plageHoraireContact.label" /> * : </dt><dd id="plageHoraireContact" class="action-editField validate-localReferentialData required-true i18n-sdccrr.property.plageHoraireContact data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'plageHoraireContact', 'lrEntries': lrTypes.plageHoraireContact?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.plageHoraireContact?.isMultiple(), 'depth':0]" />
 
          </dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class=""><g:message code="sdccrr.property.commentaireCitoyen.label" />  : </dt><dd id="commentaireCitoyen" class="action-editField validate-textarea i18n-sdccrr.property.commentaireCitoyen rows-10 maxLength-600" ><span>${rqt?.commentaireCitoyen}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
