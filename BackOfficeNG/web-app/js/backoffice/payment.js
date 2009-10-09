(function(){

  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;
  var zct = zenexity.capdemat.tools;
  zct.namespace("zenexity.capdemat.bong.payment");
  var zcb = zenexity.capdemat.bong;
  var zcbp = zenexity.capdemat.bong.payment;

  zcbp.search = function() {

    var zcc = zenexity.capdemat.common;

    var displayPaginator = function() {
      var myPaginator = new YAHOO.widget.Paginator({
        containers: ['pagination-top','pagination-bottom'],
        rowsPerPage : 25,
        totalRecords: parseInt(yud.get('totalRecords').value),
        recordOffset: parseInt(yud.get('recordOffset').value),
        template : "{FirstPageLink} {PreviousPageLink} <span>{CurrentPageReport}</span> {NextPageLink} {LastPageLink}",
        previousPageLinkLabel : '&lt;',
        firstPageLinkLabel : '&lt;&lt;',
        nextPageLinkLabel : '&gt;',
        lastPageLinkLabel : '&gt;&gt;',
        pageReportTemplate : 'R&eacute;sultats {startRecord} &agrave; {endRecord} sur {totalRecords}'
      });

      function handlePaginatorChange(state) {
        yud.get('paginatorChange').value = "true";
        yud.get('recordOffset').value = state.recordOffset;
        yud.get('paymentForm').submit();
      }

      myPaginator.subscribe('changeRequest', handlePaginatorChange);

      myPaginator.render();
    };
  
    var initCalendars = function() {
      if (yud.get('mode').value === 'advanced') {
        zcb.Calendar("initDateFrom");
        zcb.Calendar("initDateTo");
      }
    };
  
    var sortSearchPayment = function(sortType) {
        yud.get('sortBy').value = sortType;
        yud.get('paymentForm').submit();
    };

    var filterSearchPayment = function(filterType) {
        yud.get('filterBy').value = yud.get('filterBy').value + 
        '@' + filterType + '=' + yud.get(filterType).value;                
        yud.get('paymentForm').submit();
    };
      
    return {
      init: function() {
        initCalendars();
        yue.on(yus.query('input[type*=radio]'), 'click', 
          function(e) {
            sortSearchPayment(yue.getTarget(e).id);
          }
        );
        yue.on(yus.query('select[id*=Filter]'), 'change', 
          function(e) {
            filterSearchPayment(yue.getTarget(e).id);
          }
        );
        displayPaginator();
      }
    }; 
  }();

  yue.onDOMReady(zcbp.search.init);
}());

