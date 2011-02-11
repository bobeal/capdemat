<html>
  <head>
    <title>${message(code:'homeFolder.title')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <g:if test="${flash.successMessage}"><div class="success-box"><p>${flash.successMessage}</p></div></g:if>
    <div class="box">
      <div class="main">
        <h2>
          ${message(code:'homeFolder.title')}
        </h2>
        <p>${message(code:'property.address')} : 
          <strong>
            ${homeFolder.address.streetNumber} ${homeFolder.address.streetName}
            ${homeFolder.address.postalCode} ${homeFolder.address.city}
          </strong>
        </p>
        <div class="individuals">
          <!-- Adults -->
          <div class="adults">
            <h3>
              ${message(code:'homeFolder.property.adults')}
              <a href="${createLink(action:'adult')}">${message(code:'action.add')}</a>
            </h3>
            <g:if test="${!adults.isEmpty()}">
              <g:each var="adult" in="${adults}">
                <dl class="${adult.id == flash.idToDelete ? 'delete' : adult.state}">
                  <dt>
                    ${g.tag(var:adult.state, i18n:'user.state')}
                    ${g.capdematEnumToFlag(var:adult.title, i18nKeyPrefix:'homeFolder.adult.title')} ${adult.fullName}
                  </dt>
                  <g:if test="${adult.homeFolderResponsible()}">
                    <dd>${g.capdematEnumToFlag(var:adult.homeFolderResponsible(), i18nKeyPrefix:'homeFolder.role')}</dd>
                  </g:if>
                  <g:if test="${adult.homePhone}">
                    <dd>${adult.homePhone}</dd>
                  </g:if>
                  <g:if test="${adult.mobilePhone}">
                    <dd>${adult.mobilePhone}</dd>
                  </g:if>
                  <g:if test="${adult.email}">
                    <dd>${adult.email}</dd>
                  </g:if>
                  <g:render template="indexActions" model="['individual': adult]" />
                </dl>
              </g:each>
            </g:if>
          </div>
          <!-- Children -->
          <div class="children">
            <h3>
              ${message(code:'homeFolder.property.children')}
              <a href="${createLink(action:'child')}">${message(code:'action.add')}</a>
            </h3>
            <g:if test="${!children.isEmpty()}">
              <g:each var="child" in="${children}">
                <dl class="${child.id == flash.idToDelete ? 'delete' : child.state}">
                  <dt>
                    ${g.tag(var:child.state, i18n:'user.state')}
                    <g:if test="${child.born}">${child.fullName}</g:if>
                    <g:else>${message(code:'request.subject.childNoBorn', args:[child.fullName])}</g:else>
                  <dd>
                    <g:if test="${child.born}">${message(code:'homeFolder.header.born')}</g:if>
                    <g:else>${message(code:'homeFolder.header.noBorn')}</g:else>
                    <g:if test="${child.birthDate}">
                      ${message(code:'homeFolder.header.on')}
                      ${formatDate(date:child.birthDate,formatName:'format.date')}
                    </g:if>
                  </dd>
                  <g:if test="${childResponsibles[child.id] != null}">
                    <dd>
                      ${message(code:'homeFolder.child.property.legalResponsibles')} :
                      <ul>
                        <g:each var="roleOwner" in="${childResponsibles[child.id]}">
                          <li>
                            <g:each in="${roleOwner.getIndividualRoles(child.id)}">
                              ${g.capdematEnumToFlag(var:it.role, i18nKeyPrefix:'homeFolder.role')}
                            </g:each>
                            ${roleOwner.fullName}
                          </li>
                        </g:each>
                      </ul>
                    </dd>
                  </g:if>
                  <g:render template="indexActions" model="['individual': child]" />
                </dl> 
              </g:each>
            </g:if>
          </div>
        </div>
      </div>
      <div class="side">
        <div class="action">
          <a href="${createLink(action:'editPassword')}">${message(code:'account.action.editPassword')}</a>
          <a href="${createLink(action:'editQuestion')}">${message(code:'account.action.editQuestion')}</a>
        </div>
%{--        <div class="note">--}%
%{--          <h4>Notes de la collectivité</h4>--}%
%{--          <p>l'individu blabla est n'a pas d'identifiant hibernate !</p>--}%
%{--        </div>--}%
      </div>  
    </div>
  </body>
</html>

