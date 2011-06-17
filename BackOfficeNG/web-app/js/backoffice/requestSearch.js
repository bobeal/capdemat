(function(){

  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;
  var zct = zenexity.capdemat.tools;
  zct.namespace("zenexity.capdemat.bong.request");
  var zcb = zenexity.capdemat.bong;
  var zcbr = zenexity.capdemat.bong.request;

  zcbr.search = function() {

    var zcc = zenexity.capdemat.common;

    var displayPaginator = function() {
      var myPaginator = new YAHOO.widget.Paginator({
        containers: ['pagination-top','pagination-bottom'],
        rowsPerPage : parseInt(yud.get('rowsPerPage').value),
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
        yud.get('recordOffset').value = state.recordOffset;
        yud.get('requestForm').submit();
      }
      myPaginator.subscribe('changeRequest', handlePaginatorChange);
      /* 
      myPaginator.subscribe('rendered', function () { 
        var pageReport, pageReportNode, report, sortBy; 

        report = yud.get('pagination-top');
        var el = new YAHOO.util.Element("span");
        el.addClass("test");
        sortBy = yud.get('sortBy').value;
        el.appendChild(sortBy);
        
        yud.insertAfter(el, yud.getLastChild(report));
      });
      */ 
      myPaginator.render();
    };
  
    var initCalendars = function() {
      zcb.Calendar("creationDateFrom");
      zcb.Calendar("creationDateTo");
    };

    var sortSearchRequest = function(sortType) {
      yud.get('sortBy').value = sortType;
      yud.get('requestForm').submit();
    };

    var filterSearchRequest = function(filterType) {
      yud.get('filterBy').value = [yud.get('filterBy').value, 
        '@', filterType, '=', yud.get(filterType).value].join('');
      // hack to reset request season filter when we change request type
      if (filterType === "requestTypeIdFilter") {
        yud.get("filterBy").value += "@requestSeasonIdFilter=";
      }
      yud.get('requestForm').submit();
    };

    return {
      init: function() {
        initCalendars();
        //initSwitcher();
        displayPaginator();
        yue.on(yus.query('input[type*=radio]'), 'click', 
          function(e) {
            sortSearchRequest(yue.getTarget(e).id);
          }
        );
        yue.on(yus.query('select[id*=Filter]'), 'change', 
          function(e) {
            filterSearchRequest(yue.getTarget(e).id);
          }
        );
      }
    }; 
  }();

  yue.onDOMReady(zcbr.search.init);
}());
