/**
 * Alterer
 *
 * Methods here highly depends on the DOM (ids, classes, tag orders…)
 */
;(function(alterer) {

  var zct  = zenexity.capdemat.tools
    , zctu = zct.ui
    , yud  = YAHOO.util.Dom
    , yus  = YAHOO.util.Selector
    , yue  = YAHOO.util.Event

  /**
   * `element` to be altered.
   *           E.g.: 'Ligne' for a complex type named 'LigneType'
   *
   * `url`: a function!
   *        It will be evaluated to fill the drop-down from an endpoint.
   *        It must return a full URL.
   *
   * `triggerId`: a field id.
   *            Any time this field change, the drop-down will update.
   */
  alterer.toDropDown = function(element, url, triggerId) {

    var labelInput = yud.get('label' + element)
      , idInput    = yud.get('id' + element)
      , fieldset   = idInput.parentNode
      , labelLabel = yus.query('label[for="' + labelInput.id + '"]'
                              ,fieldset
                              ,true
                              )
      , idLabel    = yus.query('label[for="' + idInput.id + '"]'
                              ,fieldset
                              ,true)
      , legend     = yud.getFirstChild(fieldset)
      , trigger    = yud.get(triggerId)
      , required   = yud.hasClass(idInput, 'required')
      , helpSpan   = yud.getFirstChild(idLabel)
        // Elements added later on.
      , dropDown
      , error

    dropDown = new zctu.DropDown('id' + element
                                ,required ? 'required validate-not-first' : ''
                                )

    // Hide the label input and its label.
    labelInput.type = 'hidden'
    yud.addClass(labelLabel, 'unactive')
    // Hide the legend.
    yud.addClass(legend, 'unactive')

    idLabel.innerHTML = legend.innerHTML + (required ? ' * ' : ' ')
    idLabel.appendChild(helpSpan)

    fieldset.replaceChild(dropDown, idInput)

    if (required) {
      var error = document.createElement('p')
      error.className = 'error unactive'
      error.innerHTML = idInput.title
      fieldset.appendChild(error)
    }

    // Update the label input on change.
    yue.on(dropDown, 'change', function(event) {
      if (this.selectedIndex > 0) {
        labelInput.value = this.options[this.selectedIndex].innerHTML
      } else {
        labelInput.value = ''
      }
    })

    // Called once `.fill` is done.
    //
    // * Reselect last value, if any (when reopening a draft for example).
    // * Display error if there's no option.
    var filled = function() {
      if (dropDown.options.length > 1) {
         dropDown.select(idInput.value)
         if (required) yud.addClass(error, 'unactive')
      } else {
         if (required && error.innerHTML) yud.removeClass(error, 'unactive')
      }
    }

    // Select saved value, if any (when reopening a draft for example).
    if (zct.val(trigger) !== '') {
      dropDown.fill(url(), filled, [])
    }

    yue.on(trigger.id, 'change', function(event) {
      if (zct.val(trigger) !== '') {
        dropDown.fill(url(), filled, [])
      } else {
        dropDown.empty()
        if (required) yud.addClass(error, 'unactive')
      }
    })
  }

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tools.alterer'))
