<div id="entertainmentsReferential" class="mainbox mainbox-yellow">
  <g:render template="entertainments" model="['entertainments': entertainments]" />
</div>

<div class="mainbox mainbox-yellow">
  <h2>${message(code:'entertainments.header.import')}</h2>
  <form method="post" id="importEntertainmentsForm" class="localResourceUpload" action="${createLink(action : 'importEntertainments')}">
    <label for="csvFile">${message(code:'entertainments.label.chooseFile')}:</label>
    <input type="file" name="csvFile" />
    <input type="submit" name="save" value="${message(code:'action.save')}" />
  </form>
</div>

<div id="subscribersReferential" class="mainbox mainbox-yellow">
</div>

<div class="mainbox mainbox-yellow">
  <h2>${message(code:'subscriber.header.import')}</h2>
  <form method="post" id="importSubscribersForm" class="localResourceUpload" action="${createLink(action : 'importSubscribers')}">
    <label for="csvFile">${message(code:'subscriber.label.chooseFile')}:</label>
    <input type="file" name="csvFile" />
    <input type="submit" name="save" value="${message(code:'action.save')}" />
  </form>
</div>

<div class="mainbox mainbox-yellow">
  <h2>${message(code:'entertainment.header.logo')}</h2>
  <form method="post" id="defaultLogoForm" class="localResourceUpload" action="${createLink(action : 'defaultLogo')}">
    <p>(${message(code:'entertainment.message.logoInformation')})</p>
    <p>
      <img id="defaultLogoImg" src="${createLink(controller:'localAuthorityResource', action:'resource',  params:[type:'IMAGE',filename:'ticketBookingNoLogo'])}" />
    </p>
    <label for="logo">${message(code:'entertainment.message.newLogo')} :</label>
    <input type="file" name="logo" id="logo" />
    <input name="save" type="submit" value="${message(code:'action.save')}" />
  </form>
</div>
