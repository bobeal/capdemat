/**
 * @description Client-side module for statistics features
 *
 * @namespace zenexity.capdemat.bong.statistics
 * @author bor@zenexity.fr
 */

zenexity.capdemat.tools.namespace('zenexity.capdemat.bong.statistics');

(function(){

  var zct = zenexity.capdemat.tools;
  var zcbs = zenexity.capdemat.bong.statistics;
  
  var yu = YAHOO.util;
  var yud = yu.Dom;
  var yue = yu.Event;
  var yus = yu.Selector;
  var ylj = YAHOO.lang.JSON;

  zcbs.Statistics = function() {

    var initCalendars = function() {
      YAHOO.capdematBo.calendar.cal = new Array(2);
      YAHOO.capdematBo.calendar.init(null, null, {id: 0, label: 'startDate'});
      YAHOO.capdematBo.calendar.init(null, null, {id: 1, label: 'endDate'});
    };

    return {
      /**
       * @description Page state descriptor
       */
      pageState : undefined,
      init : function() {
        initCalendars();
        zcbs.Statistics.pageState = ylj.parse(yud.get('pageState').value);
        yue.on(yud.get('filterDisplay'),'click',zcbs.Statistics.filterDisplay);
      },
      /**
       * @description Perform statistics display filters
       */
      filterDisplay : function(e) {
        zcbs.Statistics.saveState();
        yud.get('filterForm').submit();
      },
      /**
       * @description Retrieve and save page state to input element
       */
      saveState : function() {
        zct.each(yus.query('.persistent'), function() {
            zcbs.Statistics.pageState[this.name] = zct.val(this);
        });
        yud.get('pageState').value = ylj.stringify(zcbs.Statistics.pageState);
      }
    }
  }();
  
  yue.onDOMReady(zcbs.Statistics.init);
  
}());
