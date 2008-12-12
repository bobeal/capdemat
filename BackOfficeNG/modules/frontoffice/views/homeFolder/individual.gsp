<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
    <h2 class="individual-header">${individual.firstName} ${individual.lastName}</h2>
    <div class="main-box individual-detail">
      <g:if test="${isChild}">
        <g:render template="childDetail" 
          model="[child:individual,roles:roles]"/>
      </g:if>
      <g:else>
        <g:render template="adultDetail" 
          model="[adult:individual,ownerRoles:ownerRoles,subjectRoles:subjectRoles]"/>            
      </g:else>
    </div>
  </body>
</html>

