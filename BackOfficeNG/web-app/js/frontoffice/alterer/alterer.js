/**
 * Alterer
 *
 * Methods here highly depends on the DOM (ids, classes, tag orders…)
 */
;(function(alterer) {

  var zct  = zenexity.capdemat.tools
    , zcte = zct.events
    , zctu = zct.ui
    , ylj  = YAHOO.lang.JSON
    , yud  = YAHOO.util.Dom
    , yue  = YAHOO.util.Event
    , yus  = YAHOO.util.Selector

  /**
   * 'element' to be altered.
   *           E.g.: 'Ligne' for a complex type named 'LigneType'
   *
   * 'url': a function!
   *        It will be evaluated to fill the drop-down from an endpoint.
   *        It must return a full URL.
   *
   * 'triggerId': a field id.
   *              Any time this field changes, the drop-down will update.
   */
  alterer.toDropDown = function(element, url, triggerId) {

    var fieldset = yud.get('id' + element).parentNode
      , fields   = {}
      , labels   = {}
      , legend
      , trigger  = yud.get(triggerId)
      , required
      , help
        // Elements added later on.
      , dropDown
      , error

    // Collect inputs composing the complex type,
    zct.each( yus.query('input', fieldset)
            , function(i, field) {
                field.changed = zcte.changed
                fields[field.id.replace(element, '')] = field
              }
            )
    // …and associated labels.
    zct.each( yus.query('label', fieldset)
            , function(i, label) {
                labels[label.getAttribute('for').replace(element, '')] = label
              }
            )

    legend   = yud.getFirstChild(fieldset)
    required = yud.hasClass(fields.id, 'required')
    help     = yud.getFirstChild(labels.id)

    dropDown = new zctu.DropDown( 'id' + element
                                , required ? 'required validate-not-first' : ''
                                )

    labels.id.innerHTML = legend.innerHTML + (required ? ' * ' : ' ')
    labels.id.appendChild(help)

    // Hide all fields but 'id'.
    fields.hide = function() {
      zct.each( this
              , function(key, field) {
                  if (key !== 'id' &&
                      key !== 'hide' &&
                      key !== 'changed') {
                    yud.addClass(field, 'unactive')
                  }
                }
              )
    }
    // Hide all labels but 'id'.
    labels.hide = function() {
      zct.each( this
              , function(key, label) {
                  if (key !== 'id' && key !== 'hide') {
                    yud.addClass(label, 'unactive')
                  }
                }
              )
    }
    // Trick to hide the legend on all browsers (including IE8)
    legend.hide = function() {
      var text = this.innerHTML
      this.innerHTML = '<span class="unactive">' + text + '</span>'
      yud.setStyle(this, 'padding', '0')
    }

    labels.hide()
    fields.hide()
    legend.hide()

    fieldset.replaceChild(dropDown, fields.id)

    if (required) {
      var error = document.createElement('p')
      error.className = 'error unactive'
      error.innerHTML = fields.id.title
      fieldset.appendChild(error)
    }

    // Update hidden fields on 'change'.
    yue.on(dropDown, 'change', function(event) {
      zct.each( fields
              , function(key, field) {
                  if (key !== 'id' &&
                      key !== 'hide' &&
                      key !== 'changed') {
                     var previous = field.value
                     if (dropDown.selectedIndex > 0) {
                       var option = dropDown.options[dropDown.selectedIndex]
                         , json = ylj.parse(option.getAttribute('data-json'))
                       field.value = json[key]
                     } else {
                       field.value = ''
                     }
                     if (field.value !== previous) {
                       field.changed()
                     }
                  }
                }
              )
    })

    // Called once '.fill' is done.
    //
    // * Reselect last value, if any (when reopening a draft for example).
    // * Display error if there's no option.
    var filled = function() {
      if (dropDown.options.length > 1) {
         dropDown.select(fields.id.value)
         if (required) {
           yud.addClass(error, 'unactive')
         }
      } else {
         if (required && error.innerHTML) {
           yud.removeClass(error, 'unactive')
         }
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
        if (required) {
          yud.addClass(error, 'unactive')
        }
      }
    })
  }

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tools.alterer'))
