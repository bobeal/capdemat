


  
    <fieldset class="required">
    <legend><g:message code="hccr.property.health.label" /></legend>
    
      <label class="required"><g:message code="hccr.property.healthFollowedByDoctor.label" /> *  <span><g:message code="hccr.property.healthFollowedByDoctor.help" /></span></label>
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isFollowedByDoctor-trigger validate-boolean" title="" value="${it}" name="healthFollowedByDoctor" ${it == rqt.healthFollowedByDoctor ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isFollowedByDoctor-filled"><g:message code="hccr.property.healthDoctorLastName.label" /> *  <span><g:message code="hccr.property.healthDoctorLastName.help" /></span></label>
            <input type="text" name="healthDoctorLastName" value="${rqt.healthDoctorLastName}" 
                    class="required condition-isFollowedByDoctor-filled validate-lastName" title="<g:message code="hccr.property.healthDoctorLastName.validationError" />"  maxLength="38"/>
            

    
      <label class="required condition-isFollowedByDoctor-filled"><g:message code="hccr.property.healthDoctorFirstName.label" /> *  <span><g:message code="hccr.property.healthDoctorFirstName.help" /></span></label>
            <input type="text" name="healthDoctorFirstName" value="${rqt.healthDoctorFirstName}" 
                    class="required condition-isFollowedByDoctor-filled validate-firstName" title="<g:message code="hccr.property.healthDoctorFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class="required"><g:message code="hccr.property.healthFollowedByProfessional.label" /> *  <span><g:message code="hccr.property.healthFollowedByProfessional.help" /></span></label>
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isFollowedByProfessional-trigger validate-boolean" title="" value="${it}" name="healthFollowedByProfessional" ${it == rqt.healthFollowedByProfessional ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isFollowedByProfessional-filled"><g:message code="hccr.property.healthProfessionalLastName.label" /> *  <span><g:message code="hccr.property.healthProfessionalLastName.help" /></span></label>
            <input type="text" name="healthProfessionalLastName" value="${rqt.healthProfessionalLastName}" 
                    class="required condition-isFollowedByProfessional-filled validate-lastName" title="<g:message code="hccr.property.healthProfessionalLastName.validationError" />"  maxLength="38"/>
            

    
      <label class="required condition-isFollowedByProfessional-filled"><g:message code="hccr.property.healthProfessionalFirstName.label" /> *  <span><g:message code="hccr.property.healthProfessionalFirstName.help" /></span></label>
            <input type="text" name="healthProfessionalFirstName" value="${rqt.healthProfessionalFirstName}" 
                    class="required condition-isFollowedByProfessional-filled validate-firstName" title="<g:message code="hccr.property.healthProfessionalFirstName.validationError" />"  maxLength="38"/>
            

    
      <label class="required"><g:message code="hccr.property.healthFollowedByHospital.label" /> *  <span><g:message code="hccr.property.healthFollowedByHospital.help" /></span></label>
            <ul class="required">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" class="required condition-isFollowedByHospital-trigger validate-boolean" title="" value="${it}" name="healthFollowedByHospital" ${it == rqt.healthFollowedByHospital ? 'checked="checked"': ''} />
                <g:message code="message.${it ? 'yes' : 'no'}" />
              </li>
              </g:each>
            </ul>
            

    
      <label class="required condition-isFollowedByHospital-filled"><g:message code="hccr.property.healthHospitalName.label" /> *  <span><g:message code="hccr.property.healthHospitalName.help" /></span></label>
            <input type="text" name="healthHospitalName" value="${rqt.healthHospitalName}" 
                    class="required condition-isFollowedByHospital-filled " title="<g:message code="hccr.property.healthHospitalName.validationError" />"  maxLength="60"/>
            

    
    </fieldset>
  

