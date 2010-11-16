zenexity.capdemat.tools.namespace("zenexity.capdemat.bong.external");
(function(){
  var ylj = YAHOO.lang.JSON;
  var yu = YAHOO.util;
  var yue = yu.Event;
  var yud = yu.Dom;
  var yus = yu.Selector;
  var yw = YAHOO.widget;
  var zcb = zenexity.capdemat.bong;
  var zcbe = zcb.external;
  var zct = zenexity.capdemat.tools;
  var zcv = zenexity.capdemat.Validation;
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
        yue.on(yud.get("resendButton"), "click", zcbe.Search.resend);
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
      },
      resend : function(e) {
        yue.stopEvent(e);
        var cont = yud.get("sendRequestsFormErrors");
        cont.innerHTML = "";
        if (zcv.check(yud.get("sendRequestsForm"), cont)) {
          var target = yue.getTarget(e);
          zct.doAjaxFormSubmitCall("sendRequestsForm", [], function(o) {
            var response = ylj.parse(o.responseText);
            if (response.status === "ok") {
              yud.get("resendContainer").innerHTML = ylj.parse(o.responseText).success_msg;
            } else {
              yud.addClass(yud.get("notificationEmail"), "validation-failed");
              cont.innerHTML = response.error_msg;
            }
          });
        }
      }
    };
  }();
  yue.onDOMReady(zcbe.Search.init);
}());
