/**
 * A drop-down augmented with methods:
 * * fill values from an URL
 * * select one
 * * empty values
 *
 * This file is DOM agnostic.
 */
;(function(ui) {

  var zct = zenexity.capdemat.tools
    , ylj = YAHOO.lang.JSON
    , yud = YAHOO.util.Dom

  var fill = function(url, callback, callbackParams) {
    var dropDown = this
    zct.doAjaxCall(url, null, function(o) {
      var json = ylj.parse(o.responseText)
      var index = 1
      for (var key in json) {
        dropDown.options[index++] = new Option(json[key], key)
      }
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
    this.selectedIndex = 0
    var i = 0
    for (i; i<this.length; i++){
      if (this.options[i].value === value) {
        if (this.selectedIndex !== i) {
          this.selectedIndex = i
        }
        break
      }
    }
    this.changed()
  }


  /**
   * Fire a 'change' event.
   */
  var changed = function() {
    if (document.createEventObject) {
      // IE
      this.fireEvent('onchange', document.createEventObject())
    } else {
      // Others
      var event = document.createEvent('HTMLEvents')
      event.initEvent('change', true, true)
      this.dispatchEvent(event)
    }
  }

  /**
   * Create the drop-down with:
   * * id, e.g. 'idLignes'
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
    dropDown.changed = changed
    return dropDown
  }

  return ui

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tools.ui'))
