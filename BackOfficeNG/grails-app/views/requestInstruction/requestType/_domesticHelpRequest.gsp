<div id="requestData" class="yellow-yui-tabview">
  <ul class="yui-nav">
    <li class="selected"><a href="#page1"><em><g:message code="property.requester" /></em></a></li>
    <li><a href="#page2"><em><g:message code="request.requester.property.dwelling" /></em></a></li>
    <li><a href="#page3"><em><g:message code="request.requester.property.incomes" /></em></a></li>
    <li><a href="#page4"><em><g:message code="request.requester.property.heritage" /></em></a></li>
    <li><a href="#page4"><em><g:message code="request.requester.property.capital" /></em></a></li>
    <li><a href="#page4"><em><g:message code="request.requester.property.charges" /></em></a></li>
  </ul>
  <div class="yui-content">
    
    <!-- Request Page 1 -->
    <div id="page1">
      <h2><g:message code="request.requester.property.form" />
        <span> - <g:message code="property.requester" /></span>
      </h2>
      <div class="yui-g">
        <div class="yui-u first">
          <dl>
            <dt><g:message code="request.requester.property.lastName" /> :&nbsp;</dt> 
            <dd>${request.requester.lastName}</dd>
            
            <dt><g:message code="request.requester.property.firstName" /> :&nbsp; </dt>
            <dd>${request.requester.firstName}</dd>
            
            <dt><g:message code="request.requester.property.birthDate" /> :&nbsp; </dt>
            <dd><g:formatDate format="dd-MM-yyyy" date="${request.requester.birthDate}"/>&nbsp;</dd>
            
            <dt><g:message code="request.requester.property.adress" /> :&nbsp; </dt>
            <dd>
             ${request.requester.adress.streetName}<br/>
             ${request.requester.adress.postalCode}&nbsp;
             ${request.requester.adress.city}
            </dd>
            
            <dt><g:message code="request.requester.property.mobilePhone" /> :&nbsp; </dt>
            <dd>${request.requester.mobilePhone}</dd>
            
            <dt><g:message code="request.requester.property.eMail" /> &nbsp; </dt>
            <dd>${request.requester.email}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="request.requester.property.socialSecurityNumber" /> :&nbsp;</dt> 
            <dd>${request.socialSecurityNumber}</dd>
            
            <dt><g:message code="request.requester.property.socialSecurityKeyNumber" /> dcdf sfs </dt> 
            <dd>${request.socialSecurityKeyNumber}</dd>
            
            <dt><g:message code="request.requester.property.nationality" /> :&nbsp; </dt> 
            <dd>${request.nationality}ssdsdsd</dd>
            
            <dt><g:message code="request.requester.property.franceArrivalDate" /> :&nbsp; </dt> 
            <dd>${request.franceArrivalDate}sdsdsd</dd>  
          </dl>
        </div>
      </div>
    </div>
    
    <!-- Request Page 2 -->
    <div id="page2">
      <h2><g:message code="request.requester.property.form" />
        <span>-<g:message code="request.requester.property.dwelling" /></span>
      </h2>
      <div class="yui-g">
        <div class="yui-u first">
          <span style="margin: 0 0 0 20px; font-size: 1.2em; font-weight-bold;font-style:italic">
          <g:message code="request.requester.property.current" /></span>
          <dl>
            <dt><g:message code="request.requester.property.adress" /> :&nbsp; </dt> 
             <dd>
             ${request.currentDwellingAddress.streetName}<br/>
             ${request.currentDwellingAddress.postalCode}&nbsp;
             ${request.currentDwellingAddress.city}
            </dd>
            
            <dt><g:message code="request.requester.property.currentDwellingType" /> :&nbsp; </dt> 
            <dd>${request.currentDwellingType}</dd>
            
            <dt><g:message code="request.requester.property.currentDwellingArrivalDate" /> :&nbsp; </dt> 
            <dd><g:formatDate format="dd-MM-yyyy" date="${request.currentDwellingArrivalDate}"/></dd>

            <dt><g:message code="request.requester.property.currentDwellingNetFloorArea" /> :&nbsp; </dt> 
            <dd>${request.currentDwellingNetFloorArea}&nbsp;</dd>

            <dt><g:message code="request.requester.property.currentDwellingRoomNumber" /> :&nbsp; </dt> 
            <dd>${request.currentDwellingRoomNumber}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <g:each status="i" var="previousDwelling" in="${request.previousDwellings}">
            <span style="margin: 0 0 0 20px; font-size: 1.2em; font-weight-bold;font-style:italic">Précédente ${i}</span>
            <dl>
              <dt><g:message code="request.requester.property.adress" /> :&nbsp; </dt> 
              <dd>
                ${previousDwelling.previousDwellingAddress.streetName}<br/>
                ${previousDwelling.previousDwellingAddress.postalCode}&nbsp;
                ${previousDwelling.previousDwellingAddress.city}
              </dd>
              
              <dt><g:message code="request.requester.property.previousDwelling.previousDwellingArrivalDate" />  :&nbsp; </dt> 
              <dd><g:formatDate format="dd-MM-yyyy" date="${previousDwelling.previousDwellingArrivalDate}"/></dd>
              
              <dt><g:message code="request.requester.property.previousDwelling.previousDwellingArrivalDate" /> :&nbsp; </dt> 
              <dd><g:formatDate format="dd-MM-yyyy" date="${previousDwelling.previousDwellingArrivalDate}"/></dd>
            </dl>
            <br />
          </g:each>
        </div>
      </div>
    </div>
    
    <!-- Request Page 3 -->
    <div id="page3">
      <h2><g:message code="request.requester.property.form" />
        <span>- <g:message code="request.requester.property.incomes" /></span>
      </h2>
      <div class="yui-g">
        <div class="yui-u first">
          <dl>
            <dt><g:message code="request.requester.property.lastName" /> :&nbsp; </dt> 
            <dd>${request.requester.lastName}</dd>
          </dl>
        </div>
        <div class="yui-u">
          <dl>
            <dt><g:message code="request.requester.property.socialSecurityNumber" /> :&nbsp; </dt> 
            <dd>${request.socialSecurityNumber}</dd>
          </dl>
        </div>
      </div>
    </div>
    
    <!-- Request Page 3 -->
    <div id="page3">
      <h2><g:message code="request.requester.property.form" />
        <span>- <g:message code="request.requester.property.heritage" /></span>
      </h2>
    </div>
    
    <!-- Request Page 3 -->
    <div id="page3">
      <h2><g:message code="request.requester.property.form" />
        <span>- <g:message code="request.requester.property.charges" /></span>
       </h2>
    </div>
  </div>
  
</div>


