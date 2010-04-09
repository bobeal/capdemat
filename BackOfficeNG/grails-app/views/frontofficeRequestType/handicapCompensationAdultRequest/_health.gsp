


  
    <fieldset class="required">
    <legend><g:message code="hcar.property.health.label" /></legend>
    
      <label class="required"><g:message code="hcar.property.healthFollowedByDoctor.label" /> *  <span><g:message code="hcar.property.healthFollowedByDoctor.help" /></span></label>
            <ul class="yes-no required ${invalidFields.contains('healthFollowedByDoctor') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="healthFollowedByDoctor_${it ? 'yes' : 'no'}" class="required condition-isFollowedByDoctor-trigger  validate-one-required boolean" title="" value="${it}" name="healthFollowedByDoctor" ${it == rqt.healthFollowedByDoctor ? 'checked="checked"': ''} />
                <label for="healthFollowedByDoctor_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="healthDoctorLastName" class="required condition-isFollowedByDoctor-filled"><g:message code="hcar.property.healthDoctorLastName.label" /> *  <span><g:message code="hcar.property.healthDoctorLastName.help" /></span></label>
            <input type="text" id="healthDoctorLastName" name="healthDoctorLastName" value="${rqt.healthDoctorLastName?.toString()}" 
                    class="required condition-isFollowedByDoctor-filled  validate-lastName ${invalidFields.contains('healthDoctorLastName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.healthDoctorLastName.validationError" />"  maxlength="38" />
            

    
      <label for="healthDoctorFirstName" class="required condition-isFollowedByDoctor-filled"><g:message code="hcar.property.healthDoctorFirstName.label" /> *  <span><g:message code="hcar.property.healthDoctorFirstName.help" /></span></label>
            <input type="text" id="healthDoctorFirstName" name="healthDoctorFirstName" value="${rqt.healthDoctorFirstName?.toString()}" 
                    class="required condition-isFollowedByDoctor-filled  validate-firstName ${invalidFields.contains('healthDoctorFirstName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.healthDoctorFirstName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="hcar.property.healthFollowedByProfessional.label" /> *  <span><g:message code="hcar.property.healthFollowedByProfessional.help" /></span></label>
            <ul class="yes-no required ${invalidFields.contains('healthFollowedByProfessional') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="healthFollowedByProfessional_${it ? 'yes' : 'no'}" class="required condition-isFollowedByProfessional-trigger  validate-one-required boolean" title="" value="${it}" name="healthFollowedByProfessional" ${it == rqt.healthFollowedByProfessional ? 'checked="checked"': ''} />
                <label for="healthFollowedByProfessional_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="healthProfessionalLastName" class="required condition-isFollowedByProfessional-filled"><g:message code="hcar.property.healthProfessionalLastName.label" /> *  <span><g:message code="hcar.property.healthProfessionalLastName.help" /></span></label>
            <input type="text" id="healthProfessionalLastName" name="healthProfessionalLastName" value="${rqt.healthProfessionalLastName?.toString()}" 
                    class="required condition-isFollowedByProfessional-filled  validate-lastName ${invalidFields.contains('healthProfessionalLastName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.healthProfessionalLastName.validationError" />"  maxlength="38" />
            

    
      <label for="healthProfessionalFirstName" class="required condition-isFollowedByProfessional-filled"><g:message code="hcar.property.healthProfessionalFirstName.label" /> *  <span><g:message code="hcar.property.healthProfessionalFirstName.help" /></span></label>
            <input type="text" id="healthProfessionalFirstName" name="healthProfessionalFirstName" value="${rqt.healthProfessionalFirstName?.toString()}" 
                    class="required condition-isFollowedByProfessional-filled  validate-firstName ${invalidFields.contains('healthProfessionalFirstName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.healthProfessionalFirstName.validationError" />"  maxlength="38" />
            

    
      <label class="required"><g:message code="hcar.property.healthFollowedByHospital.label" /> *  <span><g:message code="hcar.property.healthFollowedByHospital.help" /></span></label>
            <ul class="yes-no required ${invalidFields.contains('healthFollowedByHospital') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="healthFollowedByHospital_${it ? 'yes' : 'no'}" class="required condition-isFollowedByHospital-trigger  validate-one-required boolean" title="" value="${it}" name="healthFollowedByHospital" ${it == rqt.healthFollowedByHospital ? 'checked="checked"': ''} />
                <label for="healthFollowedByHospital_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

    
      <label for="healthHospitalName" class="required condition-isFollowedByHospital-filled"><g:message code="hcar.property.healthHospitalName.label" /> *  <span><g:message code="hcar.property.healthHospitalName.help" /></span></label>
            <input type="text" id="healthHospitalName" name="healthHospitalName" value="${rqt.healthHospitalName?.toString()}" 
                    class="required condition-isFollowedByHospital-filled   ${invalidFields.contains('healthHospitalName') ? 'validation-failed' : ''}" title="<g:message code="hcar.property.healthHospitalName.validationError" />"  maxlength="60" />
            

    
    </fieldset>
  

