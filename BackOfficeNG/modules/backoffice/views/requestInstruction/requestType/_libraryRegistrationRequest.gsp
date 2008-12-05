<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
    <li class="selected"><a href="#page1"><em><g:message code="request.requester.property.registration" /></em></a></li>
    <li><a href="#page2"><em><g:message code="property.page" /> 2</em></a></li>
  </ul>
  <div class="yui-content">
    
    <!-- Request Page 1 -->
    <div id="page1">
      <h2><g:message code="property.form" /><span> - <g:message code="property.page" /> 2</span></h2>
      <div class="yui-g">
        <div class="yui-u first">
          <dl>
          <dt><g:message code="request.requester.property.lastName" /> :&nbsp; </dt> 
          <dd>${requester.lastName}</dd>
          
          <dt><g:message code="request.requester.property.firstName" /> :&nbsp; </dt>
          <dd>${requester.firstName}</dd>
          
          <dt><g:message code="request.requester.property.birthDate" /> :&nbsp; </dt>
          <dd>${requester.birthDate}&nbsp;</dd>
          
          <dt><g:message code="request.requester.property.adress" /> :&nbsp; </dt>
          <dd>
           ${requester.adress.streetName}&nbsp;
           ${requester.adress.postalCode}&nbsp;
           ${requester.adress.city}
          </dd>
          
          <dt><g:message code="request.requester.property.mobilePhone" /> :&nbsp; </dt>
          <dd>${requester.mobilePhone}</dd>
          
          <dt><g:message code="request.requester.property.eMail" /> &nbsp; </dt>
          <dd>${requester.email}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
          <dt><g:message code="request.requester.property.rulesAndRegulationsAcceptance" /> :&nbsp; </dt>
          <dd>${request.rulesAndRegulationsAcceptance}</dd>
          
          <dt><g:message code="request.requester.property.parentalAuthorization" /> :&nbsp; </dt>
          <dd>${request.parentalAuthorization}</dd>
          
          <dt><g:message code="request.requester.property.registrationNumber" /> :&nbsp; </dt>
          <dd>${request.registrationNumber}</dd>
          
          </dl>
        </div>
        </div>
      </div>
    
      <!-- Request Page 2 -->
      <div id="page2">
        <h2><g:message code="property.form" /><span> - <g:message code="property.page" /> 2</span></h2>
      </div>
      
    </div>
</div>
