/**
 * A drop-down augmented with methods:
 * * fill values from an URL
 * * select one
 * * empty values
 *
 * This file is DOM agnostic.
 */
;(function(ui) {

  var zct  = zenexity.capdemat.tools
    , zcte = zct.events
    , ylj  = YAHOO.lang.JSON
    , yud  = YAHOO.util.Dom

  var fill = function(url, callback, callbackParams) {
    var dropDown = this
    zct.doAjaxCall(url, null, function(o) {
      var json = ylj.parse(o.responseText)
        , index = 1
        , option

      zct.each(json, function(key, object) {
        if (Object.prototype.toString.call(object) == '[object String]') {
          var value = key
            , text = object
          option = new Option(text, value)
          option.setAttribute( 'data-json'
                             , '{"id":"' + value + '", "label":"' + text + '"}')
        } else {
          option = new Option(object.label, object.id)
          option.setAttribute('data-json', ylj.stringify(object))
        }
        dropDown.options[index++] = option
      })

      dropDown.tail(index)
      if (zct.isFunction(callback)) {
        callback.apply(dropDown, callbackParams)
      }
    }, true)
  }

  // Keep only n first options.
  var tail = function(n) {
    this.selectedIndex = 0
    while (this.options.length > n) {
      this.options[n].parentNode.removeChild(this.options[n])
    }
    this.changed()
  }

  var empty = function() {
    this.tail(1)
  }

  var select = function(value) {
    var previous = this.selectedIndex,
        i = 0
    this.selectedIndex = 0
    for (i; i<this.length; i++){
      if (this.options[i].value === value) {
        if (this.selectedIndex !== i) {
          this.selectedIndex = i
        }
        break
      }
    }
    if (this.selectedIndex !== previous) {
      this.changed()
    }
  }

  /**
   * Create the drop-down with:
   * * an id, e.g. 'idLigne'
   * * classes, e.g. 'required validate-not-first'
   */
  ui.DropDown = function(id, classes) {
    var dropDown = document.createElement('select')
    dropDown.id = id
    dropDown.className = classes
    dropDown.name = id
    dropDown.options[0] = new Option('Choisissez…', '')
    // Add methods
    dropDown.fill    = fill
    dropDown.tail    = tail
    dropDown.empty   = empty
    dropDown.select  = select
    dropDown.changed = zcte.changed
    return dropDown
  }

  return ui

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tools.ui'))
