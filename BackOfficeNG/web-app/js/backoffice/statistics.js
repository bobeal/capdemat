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

    var handleSelect = function() {
        if (yud.get('startDate').value != '' && yud.get('endDate').value != '')
            zcbs.Statistics.doFilter();
    };

    var initCalendars = function() {
      YAHOO.capdematBo.calendar.cal = new Array(2);
      YAHOO.capdematBo.calendar.init(null, null, {id: 0, label: 'startDate'});
      YAHOO.capdematBo.calendar.init(null, null, {id: 1, label: 'endDate'});
      YAHOO.capdematBo.calendar.cal[0].selectEvent.subscribe(handleSelect);
      YAHOO.capdematBo.calendar.cal[1].selectEvent.subscribe(handleSelect);
    };

    return {
      /**
       * @description Page state descriptor
       */
      pageState : undefined,
      calendars : undefined,
      init : function() {
        initCalendars();
        zcbs.Statistics.pageState = ylj.parse(yud.get('pageState').value);
        yue.on(yus.query('.filter'),'change',zcbs.Statistics.doFilter);
        yue.on(yus.query('.filter'),'blur',zcbs.Statistics.doFilter);
      },
      /**
       * @description Perform statistics display filters
       */
      doFilter : function(e) {
        zcbs.Statistics.saveState();
        if(!e || yue.getTarget(e).nodeName != 'form') yud.get('filterForm').submit();
      },
      /**
       * @description Retrieve and save page state to input element
       */
      saveState : function() {
        zct.each(yus.query('.persistent'),function(){zcbs.Statistics.pageState[this.name] = zct.val(this);});
        yud.get("pageState").value = ylj.stringify(zcbs.Statistics.pageState);
      }
    }
  }();
  
  yue.onDOMReady(zcbs.Statistics.init);
  
}());
