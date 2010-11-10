<html>
  <head>
    <title>${message(code:'homeFolder.title.individual')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice/common', file:'data-detail.css')}" />
  </head>
  
  <body>
    <div class="main-box data-detail">
      <g:if test="${isChild && !individual.isChildBorn}">
        <h2><g:message code="request.subject.childNoBorn" args="${[individual.fullName]}" /></h2>
      </g:if>
      <g:else>
        <h2>${individual.firstName} ${individual.lastName}</h2>
      </g:else>
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

