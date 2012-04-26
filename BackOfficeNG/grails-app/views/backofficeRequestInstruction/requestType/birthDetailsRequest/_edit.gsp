


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="bdr.step.nature.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="bdr.step.type.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="bdr.step.nature.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isOtherRequesterQuality-trigger">${message(code:'bdr.property.requesterQuality.label')} * :</dt><dd id="requesterQuality" class="action-editField validate-capdematEnum required-true i18n-bdr.property.requesterQuality javatype-fr.cg95.cvq.business.request.civil.BirthRequesterQualityType" ><g:capdematEnumToField var="${rqt?.requesterQuality}" i18nKeyPrefix="bdr.property.requesterQuality" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="condition-isOtherRequesterQuality-filled">${message(code:'bdr.property.requesterQualityPrecision.label')} :</dt><dd id="requesterQualityPrecision" class="action-editField validate-string i18n-bdr.property.requesterQualityPrecision" ><span>${rqt?.requesterQualityPrecision}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required">${message(code:'bdr.property.birthLastName.label')} * :</dt><dd id="birthLastName" class="action-editField validate-lastName required-true i18n-bdr.property.birthLastName maxLength-38" ><span>${rqt?.birthLastName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'bdr.property.birthMarriageName.label')} :</dt><dd id="birthMarriageName" class="action-editField validate-lastName i18n-bdr.property.birthMarriageName maxLength-38" ><span>${rqt?.birthMarriageName}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'bdr.property.birthFirstNames.label')} * :</dt><dd id="birthFirstNames" class="action-editField validate-string required-true i18n-bdr.property.birthFirstNames" ><span>${rqt?.birthFirstNames}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'bdr.property.birthDate.label')} * :</dt><dd id="birthDate" class="action-editField validate-date required-true i18n-bdr.property.birthDate" ><span><g:formatDate formatName="format.date" date="${rqt?.birthDate}"/></span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'bdr.property.birthCity.label')} * :</dt><dd id="birthCity" class="action-editField validate-city required-true i18n-bdr.property.birthCity maxLength-32" ><span>${rqt?.birthCity}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'bdr.property.birthPostalCode.label')} * :</dt><dd id="birthPostalCode" class="action-editField validate-departmentCode required-true i18n-bdr.property.birthPostalCode maxLength-2" ><span>${rqt?.birthPostalCode}</span></dd>
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
          <span><g:message code="bdr.step.type.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required condition-isWithRelationship-trigger">${message(code:'bdr.property.format.label')} * :</dt><dd id="format" class="action-editField validate-capdematEnum required-true i18n-bdr.property.format javatype-fr.cg95.cvq.business.request.civil.BirthCertificateFormatType" ><g:capdematEnumToField var="${rqt?.format}" i18nKeyPrefix="bdr.property.format" /></dd>
              </dl>
              
            
              
              <h3><g:message code="bdr.property.fatherInformation.label" /></h3>
              <dl class="condition-isWithRelationship-filled">
                
                  <dt class="required">${message(code:'bdr.property.fatherLastName.label')} * :</dt><dd id="fatherLastName" class="action-editField validate-lastName required-true i18n-bdr.property.fatherLastName maxLength-38" ><span>${rqt?.fatherLastName}</span></dd>
                
                  <dt class="required">${message(code:'bdr.property.fatherFirstNames.label')} * :</dt><dd id="fatherFirstNames" class="action-editField validate-string required-true i18n-bdr.property.fatherFirstNames" ><span>${rqt?.fatherFirstNames}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="bdr.property.motherInformation.label" /></h3>
              <dl class="condition-isWithRelationship-filled">
                
                  <dt class="required">${message(code:'bdr.property.motherMaidenName.label')} * :</dt><dd id="motherMaidenName" class="action-editField validate-lastName required-true i18n-bdr.property.motherMaidenName maxLength-38" ><span>${rqt?.motherMaidenName}</span></dd>
                
                  <dt class="required">${message(code:'bdr.property.motherFirstNames.label')} * :</dt><dd id="motherFirstNames" class="action-editField validate-string required-true i18n-bdr.property.motherFirstNames" ><span>${rqt?.motherFirstNames}</span></dd>
                
              </dl>
              
            
          </div>
          <!-- column end -->
          
          <!-- column start -->
          <div class="yui-u">
            
              
              <dl>
                <dt class="required">${message(code:'bdr.property.copies.label')} * :</dt><dd id="copies" class="action-editField validate-positiveInteger required-true i18n-bdr.property.copies" ><span>${rqt?.copies}</span></dd>
              </dl>
              
            
              
              <dl>
                <dt class="required">${message(code:'bdr.property.motive.label')} * :</dt><dd id="motive" class="action-editField validate-capdematEnum required-true i18n-bdr.property.motive javatype-fr.cg95.cvq.business.request.civil.BirthCertificateMotiveType" ><g:capdematEnumToField var="${rqt?.motive}" i18nKeyPrefix="bdr.property.motive" /></dd>
              </dl>
              
            
              
              <dl>
                <dt class="">${message(code:'bdr.property.comment.label')} :</dt><dd id="comment" class="action-editField validate-regex i18n-bdr.property.comment maxLength-255" regex="^[\w\W]{0,255}$"><span>${rqt?.comment}</span></dd>
              </dl>
              
            
          </div>
          <!-- column end -->
          
        </div>
        <!-- data step  end -->
      </div>
      <!-- step end -->
      
    
    
  </div>
  
</div>
