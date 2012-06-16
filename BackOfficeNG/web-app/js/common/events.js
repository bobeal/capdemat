/**
 * Expose functions used to trigger DOM events.
 */
;(function(events) {

  /**
   * Fire a 'change' event.
   */
  events.changed = function() {
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

  return events

})(zenexity.capdemat.tools.namespace('zenexity.capdemat.tools.events'))
