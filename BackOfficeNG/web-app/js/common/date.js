/**
 * For date widgets a la CapDémat (<select day> <select month> <input text year>).
 * Adapt the day <select> depending on the month and year.
 * E.g.: 30 days in april and 31 in may.
 */
;(function(date) {

  var yus = YAHOO.util.Selector
    , yue = YAHOO.util.Event
    , yud = YAHOO.util.Dom
    , zct = zenexity.capdemat.tools

  var changed = function(div) {
    var yearInput = yus.query('.year', div, true)
      , year = yearInput.value === '' ? Date.today().getFullYear() : yearInput.value
      , monthInput = yus.query('.month', div, true)
      , month = monthInput.value === '' ? 0 : monthInput.value - 1
      , dayInput = yus.query('.day', div, true)
      , days = Date.getDaysInMonth(year, month)
    if (dayInput.length > days + 1) {
      while (dayInput.length > days + 1) {
        dayInput.remove(dayInput.length - 1)
      }
    } else if (days + 1 > dayInput.length) {
      for (i = dayInput.length; i <= days; i++) {
        var option = new Option(i, i)
        dayInput.add(option, null)
      }
    }
  }

  date.init = function() {
    yue.on(yus.query('form .date .month, form .date .year')
          ,'change'
          ,function(event) {
             changed(yud.getAncestorByTagName(yue.getTarget(event), 'div'))
           }
          )
    zct.each(yus.query('form .date'), function() {
      changed(this)
    })
  }

  yue.onDOMReady(date.init)

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tool.ui.date'))
