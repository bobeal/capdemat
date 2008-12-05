<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
    <li class="selected"><a href="#page1"><em><g:message code="request.property.requester" /></em></a></li>
  </ul>
  <div class="yui-content">
    
    <!-- Page 1 -->
    <div id="page1">
      <h2><g:message code="request.requester.property.form" /><span> - <g:message code="request.property.requester" /></span></h2>
      <div class="yui-g">
        <div class="yui-u first">
          <dl>
           <dt><g:message code="request.requester.property.lastName" /> : </dt> 
          <dd>${request.requesterLastName}</dd>
          
          <dt><g:message code="request.requester.property.firstName" /> : </dt>
          <dd>${request.requesterFirstName}</dd>
          
          <dt><g:message code="request.requester.property.birthDate" /> : </dt>
          <dd>${requester.birthDate}</dd>
          
          <dt><g:message code="request.requester.property.adress" /> : </dt>
          <dd>
           ${requester.adress.streetName}&nbsp;
           ${requester.adress.postalCode}&nbsp;
           ${requester.adress.city}
          </dd>
          
          <dt><g:message code="request.requester.property.mobilePhone" /> : </dt>
          <dd>${requester.mobilePhone}</dd>
          
          <dt><g:message code="request.requester.property.eMail" /> : </dt>
          <dd>${requester.email}</dd>
          </dl>
        </div>
        <div class="yui-u"></div>
      </div>
    </div>
      
  </div>
</div>


