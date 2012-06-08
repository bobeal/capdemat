/**
 * A drop-down augmented with methods:
 * * fill values from an URL
 * * empty values
 *
 * This file is DOM agnostic.
 */
;(function(ui) {

  var zct  = zenexity.capdemat.tools
    , zcte = zct.events
    , ylj  = YAHOO.lang.JSON
    , yud  = YAHOO.util.Dom

  var fill = function(url) {
    zct.doAjaxCall(url, this, function(o) {
      var json = ylj.parse(o.responseText)
        , dropDown = this.argument
        , index = 1
        , previous = dropDown.value

      zct.each(json, function(key, object) {
        var option
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

      dropDown._tail(index)
      dropDown._onfill()
      dropDown._reselect(previous)
    }, true)
  }

  // Keep only n first options.
  var tail = function(n) {
    while (this.options.length > n) {
      this.options[n].parentNode.removeChild(this.options[n])
    }
  }

  var empty = function() {
    var previous = this.value
    this._tail(1)
    this._reselect(previous)
  }

  // If the value is still among the options, select it.
  // Trigger a 'change' event anyway (c.f.: #5162).
  var reselect = function(previous) {
    for (var i = 0; i < this.length; i++) {
      if (this.options[i].value === previous) {
        this.value = previous
        break
      }
    }
    zcte.changed.call(this)
  }

  /**
   * 'options' is an object, e.g.: {
   *   id: 'idLigne'
   *   classes: 'required validate-not-first'
   *   onfill: function() {…}
   *   onchange: function() {…}
   *   selected: new Option('text', 'value')
   * }
   */
  ui.DropDown = function(options) {
    var dropDown = document.createElement('select')
    dropDown.id        = options.id
    dropDown.className = options.classes
    dropDown.name      = options.id
    dropDown.options[0] = new Option('Choisissez…', '')
    if (options.selected) {
      dropDown.options[1] = options.selected
      dropDown.value      = options.selected.value
    }
    // Add methods
    dropDown.fill      = fill
    dropDown.empty     = empty
    dropDown._tail     = tail
    dropDown._reselect = reselect
    dropDown.onchange  = options.onchange
    dropDown._onfill   = options.onfill
    return dropDown
  }

  return ui

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tools.ui'))
