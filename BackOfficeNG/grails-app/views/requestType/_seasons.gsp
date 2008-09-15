<div id="requestTypeSeasonsConfigurationList" class="central-content-area">
<div id="requestTypeSeasonsMessages"></div>
<h2><g:message code="requestType.configuration.seasons" /></h2>
<form method="POST" id="requestTypeSeasonsList" action="<g:createLink action="addSeasons"/>">
  <div id="seasonsList">
    <g:if test="${listSeasons.size() == 0}">
      <b><g:message code="requestSeason.message.noSeasonDefined" /></b><br>
    </g:if>
    <g:else>
      <ul id="seasonListContainer">
      <g:each in="${listSeasons}">
        <li id="${it.uuid}">
          <span class="second-level-menu-item">
          <span style="font-size:1.2em;font-weight:bold;">${it.label}</span><br/>
            <g:message code="requestSeason.property.registrationStart" /> 
            <g:formatDate format="dd-MM-yyyy" date="${it.registrationStart}"/> 
            <g:message code="requestSeason.property.registrationEnd" /> 
            <g:formatDate format="dd-MM-yyyy" date="${it.registrationEnd}"/><br/>

            <g:message code="requestSeason.property.effectStart" /> 
            <g:formatDate format="dd-MM-yyyy" date="${it.effectStart}"/> 
            <g:message code="requestSeason.property.effectEnd" />
            <g:formatDate format="dd-MM-yyyy" date="${it.effectEnd}"/><br/>

            <g:message code="requestSeason.property.validationAuthorizationStart" /> 
            <g:formatDate format="dd-MM-yyyy" date="${it.validationAuthorizationStart}"/>
          </span>
          <!-- BOR : il peut y avoir des apostrophes dans le label d'une saison ... -->
          <span  onclick="askSeasonDeleteConfirmation('${requestType?.id}', '${it.uuid}','${it.label}');">
            <img src="${createLinkTo(dir:'images',file:'delete.png')}" alt="Supprimer la saison"><br/>
          </span>
        </li>
      </g:each>
      </ul>
    </g:else>
  </div>
  <g:if test="${listSeasons.size() < 2}">
    <span class="add-button" style ="visibility:Visible">
    <button id="addSeason"><g:message code="requestSeason.action.addSeason" /></button>
    </span>   
  </g:if>
  <g:else>
    <span style="font-style:italic;padding-left:10px;">
      Le nombre maximum de saisons est atteint. Si vous désirez en ajouter une autre, veuillez d'abord en supprimer une de la liste.   
    </span>
    <span style ="visibility:hidden">
      <button id="addSeason"><g:message code="requestSeason.action.addSeason" /></button>
    </span>  
  </g:else>
</form>
</div>

<div  id="requestTypeSeasonsConfiguration" style ="visibility:hidden; clear: both;">
  <h3><g:message code="requestSeason.action.addSeason" /></h3>
  <form class="edit" method="POST" id="requestTypeSeasonsForm"   action="<g:createLink action="saveSeasons" />">
    <div class="error" id="dialogRequestTypeSeasonsFormError"></div>

      <label for="label" class="required"><g:message code="requestSeason.property.label" /> * :</label>
      <input type="text" id="label" name="label" size="42" class="validate-label"
          title="Le label d'une saison ne doit pas contenir de caractères spéciaux"/>
      <br/>

      <label for="registrationStart" class="required">
      <g:message code="request.requester.property.registration" />
      <g:message code="layout.from" /> * : </label>
      <input type="text" id="registrationStart" name="registrationStart" 
          class="validate-date-au" size="12"
          title="la date de début d'enregistrement doit être sous la forme JJ/MM/AAAA"/>
      <a onclick="showCalendar('registrationStartShow', 2);">
        <img id="registrationStartShow" 
            src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="registrationStartCalContainer" style="position:absolute; display:none;"></div>
      <b><g:message code="layout.to" /> *:</b>
      <input type="text" id="registrationEnd" name="registrationEnd" 
          class="validate-date-au" size="12"
          title="la date de fin d'enregistrement doit être sous la forme JJ/MM/AAAA"/> 
      <a onclick="showCalendar('registrationEndShow', 3);">    
        <img id="registrationEndShow" 
            src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="registrationEndCalContainer" style="position:absolute; display:none;"></div>
      <br/>
      <label for="effectStart"  class="required">
      <g:message code="requestType.configuration.season" />
      <g:message code="layout.from" />* : </label>
      <input type="text" id="effectStart" name="effectStart"
          class="validate-date-au" size="12"
          title="la date de début de saison doit être sous la forme JJ/MM/AAAA"/>
      <a onclick="showCalendar('effectStartShow', 4);">
        <img id="effectStartShow" 
          src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="effectStartCalContainer" style="position:absolute; display:none;"></div>
      <b><g:message code="layout.to" /> *:</b> 
      <input type="text" id="effectEnd" name="effectEnd"
          class="validate-date-au" size="12"
          title="la date de fin de saison doit être sous la forme JJ/MM/AAAA"/> 
      <a onclick="showCalendar('effectEndShow', 5);">    
        <img id="effectEndShow" 
            src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="effectEndCalContainer" style="position:absolute; display:none;"></div>
      <br/>
      <label for="validationAuthorizationStart" class="required" >
      <g:message code="requestSeason.property.validationDate" /> * : </label>
      <input type="text" id="validationAuthorizationStart" name="validationAuthorizationStart" 
          class="validate-date-au" size="12"
          title="la date de validation doit être sous la forme JJ/MM/AAAA"/>
      <a onclick="showCalendar('validationAuthorizationStartShow', 6);">
        <img id="validationAuthorizationStartShow"
          src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
      </a>
      <div id="validationAuthorizationStartCalContainer" style="position:absolute; display:none;"></div> 
      <div class="form-button">
        <input type="hidden" id="id" name="id" value="${requestType?.id}" />
        <input type="button" id="submitSaveSeason" name="submitSaveSeason" value="<g:message code="action.save" />" />
        <input type="button" id="submitCancelSeason" name="submitCancelSeason" value="<g:message code="action.cancel" />" />
    </div>
  </form>
</div>

