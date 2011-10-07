<html>
  <head>
    <title>${message(code:'homeFolder.title')}</title>
    <meta name="layout" content="fo_main" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'document.css')}" />
    <link rel="stylesheet" type="text/css" href="${resource(dir:'css/frontoffice', file:'homefolder.css')}" />
  </head>
  <body>
    <g:if test="${flash.successMessage}"><div class="success-box"><p>${flash.successMessage}</p></div></g:if>

    <div class="box-container">
      <!-- Last message sent. -->
      <g:if test="${lastMessage}">
        <div class="information-box">
          <p><strong>Dernier message de votre collectivité :</strong></p>
          <p>${lastMessage}</p>
        </div>
      </g:if>
    </div>

    <div class="box">
      <div class="main">
        <h2>
          ${message(code:'homeFolder.title')}
        </h2>
        <p style="min-height: 2.5em;">${message(code:'property.address')} : 
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
        <g:if test="${documentsByTypes}">
        <!-- Documents -->
        <div id="document">
          <h3>${message(code:'property.documents')}</h3>
          <g:each in="${documentsByTypes}" var="documentType">
            <h4>
              <a href="${createLink(controller:'frontofficeHomeFolderDocument', action:'edit', params:['documentTypeId':documentType.key])}" class="${documentType.value.linked ? '' : 'warn'}">
                ${message(code:'action.attach')}
              </a>
              ${message(code:documentType.value.name)}
            </h4>
            <g:if test="${documentType.value.linked}">
            <dl>
              <g:each in="${documentType.value.linked}" var="document">
              <dt>
                <img src="${resource(dir:'images/icons',file:'mime_' + (document.isPDF() ? 'pdf' : 'img') + '.png')}" />
              </dt>
              <dd>
                <g:if test="${document.ecitizenNote}">
                    <p>${message(code:'document.header.description')} : ${document.ecitizenNote}</p>
                </g:if>
                <p class="help">
                  ${document.datas.size()} ${message(code:'property.pages')}
                  <g:if test="${document.endValidityDate}">
                    -
                    <span>${message(code:'message.expireOn',args:[formatDate(date:document.endValidityDate,formatName:'format.date')])}</span>
                  </g:if>
                </p>
                <p>
                  <g:if test="${document.state.toString() == 'Draft'}">
                    <a href="${createLink(controller:'frontofficeHomeFolderDocument', action:'edit', params:['documentTypeId':documentType.key, 'documentId':document.id])}">
                      ${message(code:'action.modify')}
                    </a>&nbsp;
                    <a href="${createLink(controller:'frontofficeHomeFolderDocument', action:'delete', params:['documentId':document.id])}">
                      ${message(code:'action.delete')}
                    </a>&nbsp;
                  </g:if>
                  <g:else>
                    <a href="${createLink(controller:'frontofficeHomeFolderDocument', action:'unlink', params:['documentId':document.id])}">
                      ${message(code:'action.detach')}
                    </a>&nbsp;
                  </g:else>
                  <a href="${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="${message(code:'document.message.preview.longdesc')}">
                    ${message(code:'document.message.preview')}
                  </a>
                </p>
              </dd>
              </g:each>
            </dl>
            </g:if>
            <g:else>
              <p class="help">${message(code:'document.message.noAttachment')}</p>
            </g:else>
          </g:each>
          </div>
        </g:if>
%{--        <div class="note">--}%
%{--          <h4>Notes de la collectivité</h4>--}%
%{--          <p>l'individu blabla est n'a pas d'identifiant hibernate !</p>--}%
%{--        </div>--}%
      </div>  
    </div>
  </body>
</html>

