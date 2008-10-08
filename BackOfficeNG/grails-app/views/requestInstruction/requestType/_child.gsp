<h3>
  ${child.firstName} ${child.lastName}
</h3>
<div class="yui-g">
  <div class="yui-u first">
    <dl>
      
      <dt><g:message code="homeFolder.individual.property.lastName" /> : </dt> 
      <dd>${child.lastName}</dd>
      
      <dt><g:message code="homeFolder.individual.property.firstName" /> : </dt>
      <dd>${child.firstName}</dd>
      
      <dt><g:message code="homeFolder.individual.property.secondFirstName" /> : </dt>
      <dd>${child.firstName3}</dd>
      
      <dt><g:message code="homeFolder.individual.property.thirdFirstName" /> : </dt>
      <dd>${child.firstName3}</dd>
      
      
      <dt><g:message code="homeFolder.individual.property.birthDate" /> : </dt>
      <dd><g:formatDate format="dd/MM/yyyy" date="${child.birthDate}"/></dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCity" /> : </dt>
      <dd>${child.birthCity}</dd>
      
      <dt><g:message code="homeFolder.individual.property.birthCountry" /> : </dt>
      <dd>${child.birthCountry}</dd>
      
    </dl>
  </div>
  
  <div class="yui-u">
    <dl>
      <dt><g:message code="homeFolder.individual.property.address" /> : </dt>
      <dd>
        <p>${child.adress.streetName}</p>
        <p>
          ${child.adress.postalCode}&nbsp;
          ${child.adress.city}
        </p>
      </dd>
       <dt><g:message code="homeFolder.child.property.legalResponsibles" /> : </dt>
      <dd>
        <ul>
        <g:each var="clr" in="${childLegalResponsibles}">
          <li>
            <g:capdematEnumToFlag var="${clr.role}" i18nKeyPrefix="homeFolder.child.LegalResponsibleRole" /> 
            ${clr.legalResponsible.firstName} ${clr.legalResponsible.lastName}
          </li>
        </g:each>
        </ul>
      </dd>
      
     </dl>
  </div>
</div>
