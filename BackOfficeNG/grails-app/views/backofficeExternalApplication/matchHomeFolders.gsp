<form class="listItem mainbox"> <!-- FIXME : use form elem just inherit 'listItem' style and 'mainbox' marker for notification zone. change that -->
  <div class="yui-g">
    <div class="yui-u first">
      <dl class="card ${mapping?.externalId == homeFolder.externalId ? 'bind' : ''}">
        <dt>
          <p>${message(code:'external.label.account')} : ${homeFolder.externalId}</p>
          ${homeFolder.responsible?.firstName}
          ${homeFolder.responsible?.lastName}
        </dt>
        <dd>${homeFolder?.address}</dd>
        <dd>
          <g:if test="${mapping}">
            <a id="freeHomeFolder_${homeFolder.id}">${message(code:'action.free')}</a>
          </g:if>
        </dd>
        <dd>
          <g:if test="${!mapping}">
            <a id="ignoreHomeFolder_${homeFolder.id}">${message(code:'action.ignore')}</a>
          </g:if>
        </dd>
      </dl>
    </div>
    <div class="yui-u">
      <g:if test="${matchedAdults.size() == 0}">
        <p>${message(code:'external.message.noMatchedHomeFolder')}</p>
      </g:if>
      <g:else>
        <g:each var="adult" in="${matchedAdults}">
          <dl class="card ${mapping?.homeFolderId == adult.homeFolder.id ? 'bind' : ''}">
            <dt>
              <span>${message(code:'external.label.localAccount')} : ${adult.homeFolder.id}</span>
              <span class="stars s${adult.rank(homeFolder)}"></span>
              <span ${adult.firstName?.toLowerCase() == homeFolder.responsible.firstName?.toLowerCase() ? 'class="match"' : ''}>${adult.firstName}<span>
              <span ${adult.lastName?.toLowerCase() == homeFolder.responsible.lastName?.toLowerCase() ? 'class="match"' : ''}>${adult.lastName}<span>
            </dt>
            <dd>
            <dd>
              ${message(code:'homeFolder.individual.property.address')}: 
              ${adult.adress.streetNumber} <span ${homeFolder.address.indexOf(adult.adress.streetName) > 0 ? 'class="match"' : ''}>${adult.adress.streetName}</span>
              ${adult.adress.postalCode} ${adult.adress.city}
            </dd>
            <dd>
              <g:if test="${!mapping}">
                <a id="bindHomeFolder_${homeFolder.id}_${adult.homeFolder.id}" >${message(code:'action.bind')}</a>
              </g:if>
            </dd>
          </dl>
        </g:each>
      </g:else>
    </div>
  </div>
  <p class="button">
    <input type="button" id="closeMatchHomeFolders_${homeFolder.id}" value="${message(code:'action.close')}" />
  </p>
</form>
