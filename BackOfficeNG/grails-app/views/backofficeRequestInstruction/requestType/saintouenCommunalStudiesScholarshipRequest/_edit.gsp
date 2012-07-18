


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="scssr.step.subject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="scssr.step.schoolingInformation.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="scssr.step.compositionFamille.label" /></em></a>
    </li>
  
    <li class="administration ">
      <a href="#page5"><em><g:message code="request.step.administration.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="scssr.step.subject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.subject.label" /> : </dt>
              <dd><span>${subjectIsChild && !subject?.born ? message(code:'request.subject.childNoBorn', args:[subject?.getFullName()]) : subject?.fullName}</span></dd>
          
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.subjectBirthDate.label" /> * : </dt><dd id="subjectBirthDate" class="action-editField validate-date required-true i18n-scssr.property.subjectBirthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectBirthDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.subjectDomiciliationDate.label" /> * : </dt><dd id="subjectDomiciliationDate" class="action-editField validate-date required-true i18n-scssr.property.subjectDomiciliationDate" ><span><g:formatDate formatName="format.date" date="${rqt?.subjectDomiciliationDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isOtherSituation-trigger"><g:message code="scssr.property.isOtherSituation.label" /> * : </dt><dd id="isOtherSituation" class="action-editField validate-capdematEnum required-true i18n-scssr.property.isOtherSituation javatype-fr.cg95.cvq.business.request.school.SaintOuenSituationLogementType" ><g:capdematEnumToField var="${rqt?.isOtherSituation}" i18nKeyPrefix="scssr.property.isOtherSituation" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-isOtherSituation-filled"><g:message code="scssr.property.saintOuenOtherSituationDetails.label" /> * : </dt><dd id="saintOuenOtherSituationDetails" class="action-editField validate-string required-true i18n-scssr.property.saintOuenOtherSituationDetails" ><span>${rqt?.saintOuenOtherSituationDetails}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page1">
        <h2><g:message code="property.form" />
          <span><g:message code="scssr.step.schoolingInformation.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.saintOuenEstablishmentLabel.label" /> * : </dt><dd id="saintOuenEstablishmentLabel" class="action-editField validate-string required-true i18n-scssr.property.saintOuenEstablishmentLabel" ><span>${rqt?.saintOuenEstablishmentLabel}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.saintOuenEtablissementTelephone.label" /> * : </dt><dd id="saintOuenEtablissementTelephone" class="action-editField validate-phone required-true i18n-scssr.property.saintOuenEtablissementTelephone maxLength-10" ><span>${rqt?.saintOuenEtablissementTelephone}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-saintOuenIsInOtherStudies-trigger"><g:message code="scssr.property.saintOuenIsInOtherStudies.label" /> * : </dt><dd id="saintOuenIsInOtherStudies" class="action-editField validate-capdematEnum required-true i18n-scssr.property.saintOuenIsInOtherStudies javatype-fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesType" ><g:capdematEnumToField var="${rqt?.saintOuenIsInOtherStudies}" i18nKeyPrefix="scssr.property.saintOuenIsInOtherStudies" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.saintOuenCurrentStudiesLevel.label" /> * : </dt><dd id="saintOuenCurrentStudiesLevel" class="action-editField validate-capdematEnum required-true i18n-scssr.property.saintOuenCurrentStudiesLevel javatype-fr.cg95.cvq.business.request.school.SaintOuenCurrentStudiesLevelType" ><g:capdematEnumToField var="${rqt?.saintOuenCurrentStudiesLevel}" i18nKeyPrefix="scssr.property.saintOuenCurrentStudiesLevel" /></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required condition-saintOuenIsInOtherStudies-filled"><g:message code="scssr.property.saintOuenOtherStudiesLabel.label" /> * : </dt><dd id="saintOuenOtherStudiesLabel" class="action-editField validate-string required-true i18n-scssr.property.saintOuenOtherStudiesLabel" ><span>${rqt?.saintOuenOtherStudiesLabel}</span></dd>
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
          <span><g:message code="scssr.step.compositionFamille.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-vousVivezAvecAutre-trigger"><g:message code="scssr.property.vousVivezAvec.label" /> * : </dt><dd id="vousVivezAvec" class="action-editField validate-capdematEnum required-true i18n-scssr.property.vousVivezAvec javatype-fr.cg95.cvq.business.request.school.ScssrVousVivezAvezType" ><g:capdematEnumToField var="${rqt?.vousVivezAvec}" i18nKeyPrefix="scssr.property.vousVivezAvec" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required condition-vousVivezAvecAutre-filled"><g:message code="scssr.property.precisionsCompositionFamille.label" /> * : </dt><dd id="precisionsCompositionFamille" class="action-editField validate-textarea required-true i18n-scssr.property.precisionsCompositionFamille rows-5 maxLength-1024" ><span>${rqt?.precisionsCompositionFamille}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <h3><g:message code="scssr.property.nombreIndividusFoyer.label" /></h3>
              <dl class="required">
                
                  <dt class="required"><g:message code="scssr.property.nombreAdultesMajeurs.label" /> * : </dt><dd id="nombreAdultesMajeurs" class="action-editField validate-long required-true i18n-scssr.property.nombreAdultesMajeurs" ><span>${rqt?.nombreAdultesMajeurs}</span></dd>
                
                  <dt class="required"><g:message code="scssr.property.nombreEnfantsMineurs.label" /> * : </dt><dd id="nombreEnfantsMineurs" class="action-editField validate-long required-true i18n-scssr.property.nombreEnfantsMineurs" ><span>${rqt?.nombreEnfantsMineurs}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
      <!-- step start -->
      <div id="page5">
        <h2><g:message code="property.form" />
          <span><g:message code="request.step.administration.label" /></span>
        </h2>
        <div class="yui-g">
          
            <div class="administration information-message">
              <g:message code="request.step.administration.desc" />
            </div>
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="scssr.property.montantBourse.label" /> * : </dt><dd id="montantBourse" class="action-editField validate-string required-true i18n-scssr.property.montantBourse" ><span>${rqt?.montantBourse}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
