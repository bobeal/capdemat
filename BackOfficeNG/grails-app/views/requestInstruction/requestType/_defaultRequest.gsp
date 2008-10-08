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
          <dd>${request.requester.lastName}</dd>
          
          <dt><g:message code="request.requester.property.firstName" /> : </dt>
          <dd>${request.requester.firstName}</dd>
          
          <dt><g:message code="request.requester.property.birthDate" /> : </dt>
          <dd>${request.requester.birthDate}</dd>
          
          <dt><g:message code="request.requester.property.adress" /> : </dt>
          <dd>
           ${request.requester.adress.streetName}&nbsp;
           ${request.requester.adress.postalCode}&nbsp;
           ${request.requester.adress.city}
          </dd>
          
          <dt><g:message code="request.requester.property.mobilePhone" /> : </dt>
          <dd>${request.requester.mobilePhone}</dd>
          
          <dt><g:message code="request.requester.property.eMail" /> : </dt>
          <dd>${request.requester.email}</dd>
          </dl>
        </div>
        <div class="yui-u"></div>
      </div>
    </div>
      
  </div>
</div>


