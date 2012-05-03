


<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
  
    <li class="selected ">
      <a href="#page0"><em><g:message code="cccrr.step.registrationSubject.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page1"><em><g:message code="cccrr.step.registrationParams.label" /></em></a>
    </li>
  
    <li class="">
      <a href="#page2"><em><g:message code="cccrr.step.welcoming.label" /></em></a>
    </li>
  
  </ul>
   
  <div class="yui-content">
    
      
      <!-- step start -->
      <div id="page0">
        <h2><g:message code="property.form" />
          <span><g:message code="cccrr.step.registrationSubject.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="request.property.subject.label" /> : </dt>
              <dd><span>${rqt?.subjectFirstName} ${rqt?.subjectLastName}</span></dd>
              <g:if test="${rqt?.subjectChoiceBirthDate != null}">
	              <dt class=""><g:message code="cccrr.property.subjectChoiceBirthDate.label" /> : </dt>
	              <dd><span><g:formatDate format="dd-MM-yyyy" date="${rqt?.subjectChoiceBirthDate}"/></span></dd>
	              
	              <dt class=""><g:message code="cccrr.property.subjectChoiceGender.label" /> : </dt>
	              <dd><g:message code="homeFolder.child.property.sex.${rqt?.subjectChoiceGender.toString().toLowerCase()}" /></dd>
          	  </g:if>
          	  
          	  
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
          <span><g:message code="cccrr.step.registrationParams.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="cccrr.property.registrationDate.label" /> * : </dt><dd id="registrationDate" class="action-editField validate-date required-true i18n-cccrr.property.registrationDate" ><span><g:formatDate formatName="format.date" date="${rqt?.registrationDate}"/></span></dd>
              </dl>
              
            
              
              <h3><g:message code="cccrr.property.mondayRegistrationParam.label" /></h3>
              <dl class="">
                
                  <dt class="condition-isMondayPeriodeChoice-trigger"><g:message code="cccrr.property.mondayPeriod.label" />  : </dt><dd id="mondayPeriod" class="action-editField validate-capdematEnum i18n-cccrr.property.mondayPeriod javatype-fr.cg95.cvq.business.request.school.DayPeriodType" ><g:capdematEnumToField var="${rqt?.mondayPeriod}" i18nKeyPrefix="cccrr.property.mondayPeriod" /></dd>
                
                  <dt class=""><g:message code="cccrr.property.mondayFirstPeriodBegining.label" />  : </dt><dd id="mondayFirstPeriodBegining" class="action-editField validate-string i18n-cccrr.property.mondayFirstPeriodBegining" ><span>${rqt?.mondayFirstPeriodBegining}</span></dd>
                
                  <dt class=""><g:message code="cccrr.property.mondayFirstPeriodEnding.label" />  : </dt><dd id="mondayFirstPeriodEnding" class="action-editField validate-string i18n-cccrr.property.mondayFirstPeriodEnding" ><span>${rqt?.mondayFirstPeriodEnding}</span></dd>
                
                  <dt class="condition-isMondayPeriodeChoice-filled"><g:message code="cccrr.property.mondaySecondPeriodBegining.label" />  : </dt><dd id="mondaySecondPeriodBegining" class="action-editField validate-string i18n-cccrr.property.mondaySecondPeriodBegining" ><span>${rqt?.mondaySecondPeriodBegining}</span></dd>
                
                  <dt class="condition-isMondayPeriodeChoice-filled"><g:message code="cccrr.property.mondaySecondPeriodEnding.label" />  : </dt><dd id="mondaySecondPeriodEnding" class="action-editField validate-string i18n-cccrr.property.mondaySecondPeriodEnding" ><span>${rqt?.mondaySecondPeriodEnding}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="cccrr.property.tuesdayRegistrationParam.label" /></h3>
              <dl class="required">
                
                  <dt class="condition-isTuesdayPeriodeChoice-trigger"><g:message code="cccrr.property.tuesdayPeriod.label" />  : </dt><dd id="tuesdayPeriod" class="action-editField validate-capdematEnum i18n-cccrr.property.tuesdayPeriod javatype-fr.cg95.cvq.business.request.school.DayPeriodType" ><g:capdematEnumToField var="${rqt?.tuesdayPeriod}" i18nKeyPrefix="cccrr.property.tuesdayPeriod" /></dd>
                
                  <dt class=""><g:message code="cccrr.property.tuesdayFirstPeriodBegining.label" />  : </dt><dd id="tuesdayFirstPeriodBegining" class="action-editField validate-string i18n-cccrr.property.tuesdayFirstPeriodBegining" ><span>${rqt?.tuesdayFirstPeriodBegining}</span></dd>
                
                  <dt class=""><g:message code="cccrr.property.tuesdayFirstPeriodEnding.label" />  : </dt><dd id="tuesdayFirstPeriodEnding" class="action-editField validate-string i18n-cccrr.property.tuesdayFirstPeriodEnding" ><span>${rqt?.tuesdayFirstPeriodEnding}</span></dd>
                
                  <dt class="condition-isTuesdayPeriodeChoice-filled"><g:message code="cccrr.property.tuesdaySecondPeriodBegining.label" />  : </dt><dd id="tuesdaySecondPeriodBegining" class="action-editField validate-string i18n-cccrr.property.tuesdaySecondPeriodBegining" ><span>${rqt?.tuesdaySecondPeriodBegining}</span></dd>
                
                  <dt class="condition-isTuesdayPeriodeChoice-filled"><g:message code="cccrr.property.tuesdaySecondPeriodEnding.label" />  : </dt><dd id="tuesdaySecondPeriodEnding" class="action-editField validate-string i18n-cccrr.property.tuesdaySecondPeriodEnding" ><span>${rqt?.tuesdaySecondPeriodEnding}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="cccrr.property.wednesdayRegistrationParam.label" /></h3>
              <dl class="required">
                
                  <dt class="condition-isWednesdayPeriodeChoice-trigger"><g:message code="cccrr.property.wednesdayPeriod.label" />  : </dt><dd id="wednesdayPeriod" class="action-editField validate-capdematEnum i18n-cccrr.property.wednesdayPeriod javatype-fr.cg95.cvq.business.request.school.DayPeriodType" ><g:capdematEnumToField var="${rqt?.wednesdayPeriod}" i18nKeyPrefix="cccrr.property.wednesdayPeriod" /></dd>
                
                  <dt class=""><g:message code="cccrr.property.wednesdayFirstPeriodBegining.label" />  : </dt><dd id="wednesdayFirstPeriodBegining" class="action-editField validate-string i18n-cccrr.property.wednesdayFirstPeriodBegining" ><span>${rqt?.wednesdayFirstPeriodBegining}</span></dd>
                
                  <dt class=""><g:message code="cccrr.property.wednesdayFirstPeriodEnding.label" />  : </dt><dd id="wednesdayFirstPeriodEnding" class="action-editField validate-string i18n-cccrr.property.wednesdayFirstPeriodEnding" ><span>${rqt?.wednesdayFirstPeriodEnding}</span></dd>
                
                  <dt class="condition-isWednesdayPeriodeChoice-filled"><g:message code="cccrr.property.wednesdaySecondPeriodBegining.label" />  : </dt><dd id="wednesdaySecondPeriodBegining" class="action-editField validate-string i18n-cccrr.property.wednesdaySecondPeriodBegining" ><span>${rqt?.wednesdaySecondPeriodBegining}</span></dd>
                
                  <dt class="condition-isWednesdayPeriodeChoice-filled"><g:message code="cccrr.property.wednesdaySecondPeriodEnding.label" />  : </dt><dd id="wednesdaySecondPeriodEnding" class="action-editField validate-string i18n-cccrr.property.wednesdaySecondPeriodEnding" ><span>${rqt?.wednesdaySecondPeriodEnding}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="cccrr.property.thursdayRegistrationParam.label" /></h3>
              <dl class="required">
                
                  <dt class="condition-isThursdayPeriodeChoice-trigger"><g:message code="cccrr.property.thursdayPeriod.label" />  : </dt><dd id="thursdayPeriod" class="action-editField validate-capdematEnum i18n-cccrr.property.thursdayPeriod javatype-fr.cg95.cvq.business.request.school.DayPeriodType" ><g:capdematEnumToField var="${rqt?.thursdayPeriod}" i18nKeyPrefix="cccrr.property.thursdayPeriod" /></dd>
                
                  <dt class=""><g:message code="cccrr.property.thursdayFirstPeriodBegining.label" />  : </dt><dd id="thursdayFirstPeriodBegining" class="action-editField validate-string i18n-cccrr.property.thursdayFirstPeriodBegining" ><span>${rqt?.thursdayFirstPeriodBegining}</span></dd>
                
                  <dt class=""><g:message code="cccrr.property.thursdayFirstPeriodEnding.label" />  : </dt><dd id="thursdayFirstPeriodEnding" class="action-editField validate-string i18n-cccrr.property.thursdayFirstPeriodEnding" ><span>${rqt?.thursdayFirstPeriodEnding}</span></dd>
                
                  <dt class="condition-isThursdayPeriodeChoice-filled"><g:message code="cccrr.property.thursdaySecondPeriodBegining.label" />  : </dt><dd id="thursdaySecondPeriodBegining" class="action-editField validate-string i18n-cccrr.property.thursdaySecondPeriodBegining" ><span>${rqt?.thursdaySecondPeriodBegining}</span></dd>
                
                  <dt class="condition-isThursdayPeriodeChoice-filled"><g:message code="cccrr.property.thursdaySecondPeriodEnding.label" />  : </dt><dd id="thursdaySecondPeriodEnding" class="action-editField validate-string i18n-cccrr.property.thursdaySecondPeriodEnding" ><span>${rqt?.thursdaySecondPeriodEnding}</span></dd>
                
              </dl>
              
            
              
              <h3><g:message code="cccrr.property.fridayRegistrationParam.label" /></h3>
              <dl class="required">
                
                  <dt class="condition-isFridayPeriodeChoice-trigger"><g:message code="cccrr.property.fridayPeriod.label" />  : </dt><dd id="fridayPeriod" class="action-editField validate-capdematEnum i18n-cccrr.property.fridayPeriod javatype-fr.cg95.cvq.business.request.school.DayPeriodType" ><g:capdematEnumToField var="${rqt?.fridayPeriod}" i18nKeyPrefix="cccrr.property.fridayPeriod" /></dd>
                
                  <dt class=""><g:message code="cccrr.property.fridayFirstPeriodBegining.label" />  : </dt><dd id="fridayFirstPeriodBegining" class="action-editField validate-string i18n-cccrr.property.fridayFirstPeriodBegining" ><span>${rqt?.fridayFirstPeriodBegining}</span></dd>
                
                  <dt class=""><g:message code="cccrr.property.fridayFirstPeriodEnding.label" />  : </dt><dd id="fridayFirstPeriodEnding" class="action-editField validate-string i18n-cccrr.property.fridayFirstPeriodEnding" ><span>${rqt?.fridayFirstPeriodEnding}</span></dd>
                
                  <dt class="condition-isFridayPeriodeChoice-filled"><g:message code="cccrr.property.fridaySecondPeriodBegining.label" />  : </dt><dd id="fridaySecondPeriodBegining" class="action-editField validate-string i18n-cccrr.property.fridaySecondPeriodBegining" ><span>${rqt?.fridaySecondPeriodBegining}</span></dd>
                
                  <dt class="condition-isFridayPeriodeChoice-filled"><g:message code="cccrr.property.fridaySecondPeriodEnding.label" />  : </dt><dd id="fridaySecondPeriodEnding" class="action-editField validate-string i18n-cccrr.property.fridaySecondPeriodEnding" ><span>${rqt?.fridaySecondPeriodEnding}</span></dd>
                
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
      <div id="page2">
        <h2><g:message code="property.form" />
          <span><g:message code="cccrr.step.welcoming.label" /></span>
        </h2>
        <div class="yui-g">
          
          
          <!-- column start -->
          <div class="yui-u first">
            
              
              <dl>
                <dt class="required"><g:message code="cccrr.property.welcomingChoice.label" /> * : </dt><dd id="welcomingChoice" class="action-editField validate-localReferentialData required-true i18n-cccrr.property.welcomingChoice data-localReferentialData" >
           <g:render template="/backofficeRequestInstruction/widget/localReferentialDataStatic" 
                     model="['javaName':'welcomingChoice', 'lrEntries': lrTypes.welcomingChoice?.entries, 
                             'rqt':rqt, 'isMultiple':lrTypes.welcomingChoice?.entriesSupportMultiple, 'depth':0]" />
 
          </dd>
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
