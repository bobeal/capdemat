zenexity.capdemat.tools.namespace("zenexity.capdemat.bong.external");
(function(){
  var yu = YAHOO.util;
  var yue = yu.Event;
  var yud = yu.Dom;
  var yus = yu.Selector;
  var yw = YAHOO.widget;
  var zcb = zenexity.capdemat.bong;
  var zcbe = zcb.external;
  zcbe.Search = function() {
    return {
      init: function() {
        zcb.Calendar("dateFrom");
        zcb.Calendar("dateTo");
        var myPaginator = new yw.Paginator({
          containers : ["pagination-top", "pagination-bottom"],
          rowsPerPage : 15,
          totalRecords : parseInt(yud.get("totalRecords").value),
          recordOffset : parseInt(yud.get("offset").value),
          template : "{FirstPageLink} {PreviousPageLink} <span>{CurrentPageReport}</span> {NextPageLink} {LastPageLink}",
          previousPageLinkLabel : "&lt;",
          firstPageLinkLabel : "&lt;&lt;",
          nextPageLinkLabel : "&gt;",
          lastPageLinkLabel : "&gt;&gt;",
          pageReportTemplate : "R&eacute;sultats {startRecord} &agrave; {endRecord} sur {totalRecords}"
        });
        myPaginator.subscribe("changeRequest", zcbe.Search.handlePaginatorChange);
        myPaginator.render();
        yue.on(yus.query("input[type*=radio]"), "click",  zcbe.Search.sortSearch);
        yue.on(yus.query("select[id*=Filter]"), "change", zcbe.Search.filterSearch);
      },
      sortSearch : function(e) {
        yud.get("sortBy").value = yue.getTarget(e).getAttribute("name");
        yud.get("searchForm").submit();
      },
      filterSearch : function(e) {
        var filterBy = yue.getTarget(e).getAttribute("id");
        yud.get("filterBy").value = [
          yud.get("filterBy").value, "@", filterBy, "=", yud.get(filterBy).value
        ].join('');
        yud.get("searchForm").submit();
      },
      handlePaginatorChange : function(state) {
        yud.get("offset").value = state.recordOffset;
        yud.get("searchForm").submit();
      }
    };
  }();
  yue.onDOMReady(zcbe.Search.init);
}());
