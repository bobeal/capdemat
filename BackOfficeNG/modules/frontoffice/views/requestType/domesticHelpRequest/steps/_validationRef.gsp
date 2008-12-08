<h3>
  Contact
  <span>Comment souhaitez-vous être contacté pour cette demande</span>
</h3>

<label>Moyen de contact</label>
<select name="requestMeansOfContactSelect">
  <option>Courriel</option>
  <option>Téléphone</option>
  <option>Courrier</option>
  <option>SMS</option>
  <option>Mobile</option>
</select>
<h3><g:message code='dhr.step.subject.label' /></h3> 
<g:render template="/frontofficeRequestType/domesticHelpRequest/steps/validation/subject" />
<h3><g:message code='dhr.step.dwelling.label' /></h3> 
<g:render template="/frontofficeRequestType/domesticHelpRequest/steps/validation/dwelling" />
<h3><g:message code='dhr.step.resources.label' /></h3> 
<g:render template="/frontofficeRequestType/domesticHelpRequest/steps/validation/resources" />
<h3><g:message code='dhr.step.taxes.label' /></h3> 
<g:render template="/frontofficeRequestType/domesticHelpRequest/steps/validation/taxes" />
