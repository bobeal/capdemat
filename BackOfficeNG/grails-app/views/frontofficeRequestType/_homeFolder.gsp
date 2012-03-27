<style type="text/css" medial="all">
  @import "${resource(dir:'css/frontoffice/',file:'homefolder.css')}";
  .box .main.columns
  {
    padding-top:0;
  }
  .box .main.columns .adults,
  .box .main.columns .children
  {
    width:90%;
  }
</style>

<div class="information-box">
  <p>
    ${message(code:requestTypeAcronym+'.incitationText.desc', args : [createLink(controller:'frontofficeHomeFolder', action:'index', params : [ 'inRequestId' : rqt.id])])}
  </p>
</div>

<div class="box">
  <div class="main columns">

    <div class="individuals">
      <g:if test="${!homeFolderResponsible.getHomeFolder().getIndividuals().isEmpty()}">
        <!-- Adults -->
        <div class="adults">
          <h3>
            ${message(code:'homeFolder.property.adults')}
          </h3>

          <!-- Home folder responsible -->
            <dl class="${homeFolderResponsible.state} ">
              <dt>
                ${g.capdematEnumToFlag(var:homeFolderResponsible.title, i18nKeyPrefix:'homeFolder.adult.title')} ${homeFolderResponsible.fullName}
              </dt>
              <dd>
                <span class="tag-homefolderresponsible tag-state">${message(code:'homeFolder.role.homeFolderResponsible')}</span>
              </dd>
              <g:if test="${homeFolderResponsible.homePhone}">
                <dd>${homeFolderResponsible.homePhone}</dd>
              </g:if>
              <g:if test="${homeFolderResponsible.mobilePhone}">
                <dd>${homeFolderResponsible.mobilePhone}</dd>
              </g:if>
              <g:if test="${homeFolderResponsible.email}">
                <dd>${homeFolderResponsible.email}</dd>
              </g:if>
            </dl>

          <!-- Adults valid without home folder responsible -->
          <g:each in="${homeFolderResponsible.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals('Archived') || it.getState().name.equals('Invalid')) && (homeFolderResponsible.getId() != it.getId()) }}" var="individual">
            <g:if test="${individual.getClass() == fr.cg95.cvq.business.users.Adult.class}">
              <dl class="${individual.state}">
                <dt>
                  ${g.capdematEnumToFlag(var:individual.title, i18nKeyPrefix:'homeFolder.adult.title')} ${individual.fullName}
                </dt>
                <g:if test="${individual.homePhone}">
                  <dd>${individual.homePhone}</dd>
                </g:if>
                <g:if test="${individual.mobilePhone}">
                  <dd>${individual.mobilePhone}</dd>
                </g:if>
                <g:if test="${individual.email}">
                  <dd>${individual.email}</dd>
                </g:if>
              </dl>
            </g:if>
          </g:each>
        </div>

        <!-- Children valid -->
        <div class="children">
          <h3>
            ${message(code:'homeFolder.property.children')}
          </h3>
          <g:each in="${homeFolderResponsible.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals('Archived') || it.getState().name.equals('Invalid'))}}" var="individual">
            <g:if test="${individual.getClass() == fr.cg95.cvq.business.users.Child.class}">
              <dl class="${individual.state}">
                <dt>
                  <g:if test="${individual.born}">${individual.fullName}</g:if>
                  <g:else>${message(code:'request.subject.childNoBorn', args:[individual.fullName])}</g:else>
                </dt>
                <dd>
                  <g:if test="${individual.born}">${message(code:'homeFolder.header.born')}</g:if>
                  <g:else>${message(code:'homeFolder.header.noBorn')}</g:else>
                  <g:if test="${individual.birthDate}">
                    ${message(code:'homeFolder.header.on')}
                    ${formatDate(date:individual.birthDate,formatName:'format.date')}
                  </g:if>
                </dd>

                <dd>
                  ${g.capdematEnumToText(var:individual.getSex(), i18nKeyPrefix:'homeFolder.child.property.sex')}
                </dd>

                <g:each in="${homeFolderResponsible.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals('Archived') || it.getState().name.equals('Invalid'))}}" var="indiv_2">
                  <g:if test="${indiv_2.getClass() == fr.cg95.cvq.business.users.Adult.class}">
                    <g:each in="${indiv_2.getIndividualRoles()}" var="indRole">
                      <g:if test="${((indRole.getRole().getLegacyLabel().equals('ClrMother') || indRole.getRole().getLegacyLabel().equals('ClrFather') || indRole.getRole().getLegacyLabel().equals('ClrTutor') || indRole.getRole().getLegacyLabel().equals('Tutor')) && indRole.getIndividualId() == individual.getId())}">
                        <dd>
                          <g:capdematEnumToFlag var="${indRole.getRole()}" i18nKeyPrefix="homeFolder.role" />
                          ${indiv_2.fullName}
                        </dd>
                      </g:if>
                    </g:each>
                  </g:if>
                </g:each>

              </dl>
            </g:if>
          </g:each>
        </div>
      </g:if>
    </div>

  </div>


  <div class="information-box">
    <p>
      ${message(code:requestTypeAcronym+'.incitationText.desc2', args : [createLink(controller:'frontofficeHomeFolder', action:'index', params : [ 'inRequestId' : rqt.id])])}
    </p>
  </div>
</div>