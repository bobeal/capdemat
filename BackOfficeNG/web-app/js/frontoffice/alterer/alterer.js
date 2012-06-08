/**
 * Alterer
 *
 * Methods here highly depends on the DOM (IDs, classes, tag order…)
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

    var onfill = function() {
      if (required) {
        if (dropDown.options.length === 1 && error.innerHTML) {
          yud.removeClass(error, 'unactive')
        } else {
          yud.addClass(error, 'unactive')
        }
      }
    }

    var onchange = function(event) {
      var updated = []
      zct.each( fields
              , function(key, field) {
                  if (key !== 'id') {
                    var previous = field.value

                    if (dropDown.selectedIndex > 0) {
                      var option = dropDown.options[dropDown.selectedIndex]
                        , json = ylj.parse(option.getAttribute('data-json'))
                      field.value = json[key]
                    } else {
                      field.value = ''
                    }

                    if (field.value !== previous) {
                      updated.push(field)
                    }
                  }
                }
              )
      zct.each( updated
              , function(i, field) {
                  zcte.changed.call(field)
                }
              )
    }

    var options = { id: 'id' + element
                  , classes: required ? 'required validate-not-first' : ''
                  , onfill: onfill
                  , onchange: onchange
                  , selected: new Option( fields.label.value
                                        , fields.id.value
                                        )
                  }
    dropDown = new zctu.DropDown(options)

    labels.id.innerHTML = legend.innerHTML + (required ? ' * ' : ' ')
    labels.id.appendChild(help)

    // Hide elements in the map, except the 'id' element.
    var hide = function(map) {
      zct.each( map
              , function(key, element) {
                  if (key !== 'id') {
                    yud.addClass(element, 'unactive')
                  }
                }
              )
    }
    hide(fields)
    hide(labels)
    // Trick to hide the legend on all browsers (including IE8)
    legend.hide = function() {
      var text = this.innerHTML
      this.innerHTML = '<span class="unactive">' + text + '</span>'
      yud.setStyle(this, 'padding', '0')
    }
    legend.hide()

    fieldset.replaceChild(dropDown, fields.id)

    if (required) {
      var error = document.createElement('p')
      error.className = 'error unactive'
      error.innerHTML = fields.id.title
      fieldset.appendChild(error)
    }

    if (zct.val(trigger) !== '') {
      dropDown.fill(url())
    }

    yue.on(trigger.id, 'change', function(event) {
      if (zct.val(trigger) !== '') {
        dropDown.fill(url())
      } else {
        dropDown.empty()
        if (required) {
          yud.addClass(error, 'unactive')
        }
      }
    })
  }

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tools.alterer'))
