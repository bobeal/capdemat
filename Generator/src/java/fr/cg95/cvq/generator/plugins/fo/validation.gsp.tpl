<% 
  def displayWidget(element, wrapper) {
     
    def widgets = [
      'boolean' : 
          """
          <dd><g:message code="message.\${${wrapper}.${element.javaFieldName} ? 'yes' : 'no'}" /></dd>
          """
      ,'checkbox' :
          """
          <dd><g:message code="message.\${${wrapper}.${element.javaFieldName} ? 'yes' : 'no'}" /></dd>
          """
      ,'radio' :
          """
          <dd>
            <g:if test="\${${wrapper}.${element.javaFieldName}}">
              <g:capdematEnumToField var="\${${wrapper}.${element.javaFieldName}}" i18nKeyPrefix="${element.i18nPrefixCode}" />
            </g:if>
          </dd>
          """
      ,'select' :
          """
          <dd>
            <g:if test="\${${wrapper}.${element.javaFieldName}}">
              <g:capdematEnumToField var="\${${wrapper}.${element.javaFieldName}}" i18nKeyPrefix="${element.i18nPrefixCode}" />
            </g:if>
          </dd>
          """
      ,'address' :
          """
          <dd>
          <g:if test="\${${wrapper}.${element.javaFieldName}}">
              <p>\${${wrapper}.${element.javaFieldName}?.additionalDeliveryInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.additionalGeographicalInformation}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.streetNumber} \${${wrapper}.${element.javaFieldName}?.streetName}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.placeNameOrService}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.postalCode} \${${wrapper}.${element.javaFieldName}?.city}</p>
              <p>\${${wrapper}.${element.javaFieldName}?.countryName}</p>
          </g:if>
          </dd>
          """
      ,'frenchRIB' :
          """
          <dd>
          <g:if test="\${${wrapper}.${element.javaFieldName}}">
            <p>
              \${${wrapper}.${element.javaFieldName}?.bankCode}
              \${${wrapper}.${element.javaFieldName}?.counterCode}
              \${${wrapper}.${element.javaFieldName}?.accountNumber}
              \${${wrapper}.${element.javaFieldName}?.accountKey}
            </p>
          </g:if>
          </dd>
          """
      ,'bankAccount' :
          """
          <dd>
          <g:if test="\${${wrapper}.${element.javaFieldName}}">
            <p>
              \${${wrapper}.${element.javaFieldName}?.BIC}
              \${${wrapper}.${element.javaFieldName}?.IBAN}
            </p>
          </g:if>
          </dd>
          """
      ,'localReferentialData' :
          """
          <dd>
          <g:render template="/frontofficeRequestType/widget/localReferentialDataSummary" 
                    model="['javaName':'${element.javaFieldName}', 'lrEntries': lrTypes.${element.javaFieldName}.entries, 'depth':0]" />
          </dd>
          """
      ,'date' :
          """
          <dd><g:formatDate formatName="format.date" date="\${${wrapper}.${element.javaFieldName}}"/></dd>
          """
      ,'time' :
          """
          <dd>
            \${${wrapper}.${element.javaFieldName}?.getHourOfDay()} : 
            <g:if test="\${${wrapper}.${element.javaFieldName} && ${wrapper}.${element.javaFieldName}.getMinuteOfHour() < 10}">
            0</g:if>\${${wrapper}.${element.javaFieldName}?.getMinuteOfHour()}
          </dd>
          """
      ,'text' :
          """<dd>\${${wrapper}.${element.javaFieldName}?.toString()}</dd>"""
      ,'number' :
          "<dd>\${formatNumber(number: ${wrapper}.${element.javaFieldName}, type: 'number')}</dd>"
      ,'subject' :
          """<dt><g:message code="${requestFo.acronym}.property.subject.label" /></dt>
          <dd>\${subjects.get(rqt.subjectId)}</dd>"""
      ,'requester' :
          """
          <g:render template="/frontofficeRequestType/widget/requesterSummary" model="['requester':requester]" />
          """
      ,'label' :
          """<dt><g:message code="${element.i18nPrefixCode}.label" /></dt>"""
      ,'acceptance' :
          """
          <dd><g:message code="message.\${${wrapper}.${element.javaFieldName} ? 'yes' : 'no'}" /></dd>
          """
      ,'homeFolderResponsible' :
          """
            <dl>
              <dt><g:capdematEnumToFlag var="\${requester.title}" i18nKeyPrefix="homeFolder.adult.title" /> \${requester.fullName}</dt>
              <dd>
                <ul>
                  <li>
                    <span class="tag-homefolderresponsible tag-state">\${message(code:'homeFolder.role.homeFolderResponsible')}</span>
                  </li>
                  <g:if test="\${requester.homePhone}">
                    <li>\${requester.homePhone}</li>
                  </g:if>
                  <g:if test="\${requester.mobilePhone}">
                    <li>\${requester.mobilePhone}</li>
                  </g:if>
                  <g:if test="\${requester.email}">
                    <li>\${requester.email}</li>
                  </g:if>
                </ul>
              </dd>
            </dl>
          """
      ,'adults' :
          """
          <g:each in="\${requester.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals('Archived') || it.getState().name.equals('Invalid')) && (requester.getId() != it.getId()) }}" var="individual">
            <g:if test="\${individual.getClass() == fr.cg95.cvq.business.users.Adult.class}">
              <dl>
                <dt><g:capdematEnumToFlag var="\${individual.title}" i18nKeyPrefix="homeFolder.adult.title" /> \${individual.fullName}</dt>
                <dd>
                  <ul>
                    <g:if test="\${individual.homePhone}">
                      <li>\${individual.homePhone}</li>
                    </g:if>
                    <g:if test="\${individual.mobilePhone}">
                      <li>\${individual.mobilePhone}</li>
                    </g:if>
                    <g:if test="\${individual.email}">
                      <li>\${individual.email}</li>
                    </g:if>
                  </ul>
                </dd>
              </dl>
            </g:if>
          </g:each>
          """
      ,'children' :
          """
          <g:each in="\${requester.getHomeFolder().getIndividuals().findAll{ !(it.getState().name.equals('Archived') || it.getState().name.equals('Invalid'))}}" var="individual">
            <g:if test="\${individual.getClass() == fr.cg95.cvq.business.users.Child.class}">
              <dl class="\${individual.state}">
                <dt>
                  <g:if test="\${individual.born}">\${individual.fullName}</g:if>
                  <g:else>\${message(code:'request.subject.childNoBorn', args:[individual.fullName])}</g:else>
                <dd>
                  <g:if test="\${individual.born}">\${message(code:'homeFolder.header.born')}</g:if>
                  <g:else>\${message(code:'homeFolder.header.noBorn')}</g:else>
                  <g:if test="\${individual.birthDate}">
                    \${message(code:'homeFolder.header.on')}
                    \${formatDate(date:individual.birthDate,formatName:'format.date')}
                  </g:if>
                </dd>
              </dl>
            </g:if>
          </g:each>
          """
    ]

    def output

    switch (element.widget) {
      case ['requester', 'subject', 'adults', 'children', 'homeFolderResponsible']:
        output = widgets[element.widget]
        break
      case ['decimal', 'double', 'float']:
        output = widgets['label'] + widgets['number']
        break
      default:
        output = widgets['label']
        output += (widgets[element.widget] != null) ? widgets[element.widget] : widgets['text']
        break
    }

    println output
  }
%>

<% stepBundle.each { step -> %>
  <% if (step.name == 'document') { %>
  <g:if test="\${!documentsByTypes.isEmpty()}">
    <h3>\${message(code:'request.step.document.label')}</h3>
    <g:each in="\${documentsByTypes}" var="documentType">
      <h4>\${message(code:documentType.value.name)}</h4>
      <g:if test="\${documentType.value.associated}">
      <dl class="document-linked">
        <g:each in="\${documentType.value.associated}" var="document">
        <dt>
          <g:if test="\${document.ecitizenNote}">\${message(code:'document.header.description')} : \${document.ecitizenNote}<br/></g:if>
          <g:if test="\${document.endValidityDate}">\${message(code:'document.header.expireOn')} \${formatDate(date:document.endValidityDate,formatName:'format.date')}</g:if>
        </dt>
        <dd>
          <g:capdematEnumToFlag var="\${document.state}" i18nKeyPrefix="document.state" />
          <a href="\${createLink(controller:'frontofficeDocument',action:'details', id:document.id)}" target="blank" title="\${message(code:'document.message.preview.longdesc')}">\${message(code:'document.message.preview')}</a>
        </dd>
        </g:each>
      </dl>
      </g:if>
      <g:else>
        \${message(code:'document.header.noAttachments')}
      </g:else>
    </g:each>
  </g:if>
  <% }  else if (step.name == 'homeFolder') { %>

    <h3>\${message(code:'${requestFo.acronym}.step.${step.name}.label')}</h3>

    <% displayWidget(['widget':'homeFolderResponsible'], "rqt") %>

    <% displayWidget(['widget':'adults'], "rqt") %>

    <% displayWidget(['widget':'children'], "rqt") %>

  <% } else if (step.name != 'validation') { %>
    <h3><g:message code="${requestFo.acronym}.step.${step.name}.label" /></h3>
    <% requestFo.getElementsByStep(step).each { element -> %>
      <% if (element.typeClass == "COLLECTION") { %>
      <h4><g:message code="${element.i18nPrefixCode}.label" /></h4>
      <g:each var="it" in="\${rqt.${element.javaFieldName}}" status="index">
      <dl>
        <% element.elements.each { subElement -> %>
          <% displayWidget(subElement, "it") %>
        <% } %>
      </dl>
      </g:each>
      <% } else if (element.typeClass == "COMPLEX") { %>
      <h4><g:message code="${element.i18nPrefixCode}.label" /></h4>
      <dl>
        <% element.elements.each { subElement -> %>
          <% displayWidget(subElement, "rqt") %>
        <% } %>
      </dl>
      <% } else { %>
      <dl>
        <% displayWidget(element, "rqt") %>
      </dl>
      <% } %>
    <% } %>
  <% } %>

<% } %>
