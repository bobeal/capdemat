<html>
  <head>
    <meta name="layout" content="fong_main" />
  </head>
  
  <body>
    <div class="main-box individual-detail">
      <h2>${individual.firstName} ${individual.lastName}</h2>
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

