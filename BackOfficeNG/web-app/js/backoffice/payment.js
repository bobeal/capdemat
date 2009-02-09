(function(){

  var yue = YAHOO.util.Event;
  var yud = YAHOO.util.Dom;
  var yus = YAHOO.util.Selector;
  var zct = zenexity.capdemat.tools;
  zct.namespace("zenexity.capdemat.bong.payment");
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
  
    var initButton = function() {
      var submitSearchPaymentButton = new YAHOO.widget.Button("submitSearchPayment", {type:"submit"});
    };
  
    var initCalendars = function() {
      if (yud.get('mode').value === 'advanced') {
        YAHOO.capdematBo.calendar.cal = new Array(2);
        YAHOO.capdematBo.calendar.init(null, null, {id: 0, label: 'initDateFrom'});
        YAHOO.capdematBo.calendar.init(null, null, {id: 1, label: 'initDateTo'});
      }
    };
  
    var initSwitcher = function() {
        yue.addListener("paymentSearchSwitcher", "click", 
          function(e) {
            var targetEl = yue.getTarget(e);
            if (targetEl.tagName === "A") {
              switchSearchForm(targetEl.className);
            }
          }
        );        
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
      
    var switchSearchForm = function(formType) {
        var url = '/loadSearchForm?formType=' + formType + '&' + zcc.collectSearchFormValues('paymentForm');
        zct.doAjaxCall(url, null,
          function(o) {
            yud.get('head').innerHTML = o.responseText;
            initButton();
            initCalendars();
            initSwitcher();
          }
        );
    };
    
    return {
      init: function() {
        initButton();
        initCalendars();
        initSwitcher();
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

