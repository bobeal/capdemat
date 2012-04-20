;(function(request) {
  var zct = zenexity.capdemat.tools
    , yud = YAHOO.util.Dom
    , yue = YAHOO.util.Event
    , yus = YAHOO.util.Selector

  var initTransports = function() {
    var prefix = zenexity.capdemat.contextPath + '/frontoffice/technocarte'

    var linesURL = function() {
      return prefix
           + '/transportLines/?requestTypeLabel=School Transport Registration'
           + '&requestId='
           + yud.get('stepForm').id.value
           + '&childId='
           + yud.get('subjectId').value
    }
    var stopsURL = function() {
      return prefix
           + '/stops/?requestTypeLabel=School Transport Registration'
           + '&requestId='
           + yud.get('stepForm').id.value
           + '&childId='
           + yud.get('subjectId').value
           + '&lineId='
           + yud.get('idLigne').value
    }
    zct.alterer.toDropDown('Ligne', linesURL, 'subjectId')
    zct.alterer.toDropDown('Arret', stopsURL, 'idLigne')
  }

  /**
   * Problem:
   * If we choose "no" in the checkbox, then authorize someone to pick up the child,
   * and finally change "no" to "yes".
   * > The authorized person remains visible on screen.
   *
   * Solution:
   * It would work if authorized persons were in a complex type.
   * Unfortunately we don't support collections in complex types. So this JS.
   */
  var initConditions = function() {
    yue.on(yud.get('estMaternelleElementaireAutorisations_no')
          ,'click'
          ,hideAllAuthorizationListeners
          )
    yue.on(yud.get('estMaternelleElementaireAutorisations_yes')
           ,'click'
           ,displaySelectedAuthorizationListener
          )
  }

  var hideAllAuthorizationListeners = function() {
    zct.each(
      yus.query(
        '.condition-autoriseTiers-filled,.condition-autoriseFrereOuSoeur-filled'
      )
    , function() {this.className += ' unactive'}
    )
  }

  var displaySelectedAuthorizationListener = function() {
    var selector = yud.get('autorisation')
      , value = selector.options.item(selector.selectedIndex).value

    switch (value) {
      case 'AVEC_FRERE_SOEUR':
        yud.removeClass(
          yus.query('.condition-autoriseFrereOuSoeur-filled')
        , 'unactive'
        )
        break
      case 'AVEC_TIERS':
        yud.removeClass(yus.query('.condition-autoriseTiers-filled'), 'unactive')
        break
    }
  }

  request.init = function() {
    // Switch on step name.
    switch (yus.query('div.form', 'request', true).id) {
      case 'enfant':
        initTransports()
        break
      case 'autorisations':
        initConditions()
        break
    }
  }

}(zenexity.capdemat.tools.namespace('zenexity.capdemat.fong.requesttype.SchoolTransportRegistrationRequest')))
