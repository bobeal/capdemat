(function() {
  var zcc = zenexity.capdemat.common;

  function initPayment() {
    
    var submitSearchPaymentButton = new YAHOO.widget.Button("submitSearchPayment");
    submitSearchPaymentButton.on("click", onSubmitSearchPayment);
    
    function onSubmitSearchPayment(ev) {
        doSearchPayment();
    }
  }
  YAHOO.util.Event.onDOMReady(initPayment);	
    
  function displayPaginator() {
    var myPaginator = new YAHOO.widget.Paginator({
      containers: ['pagination-top','pagination-bottom'],
      rowsPerPage : 25,
      template : "{FirstPageLink} {PreviousPageLink} <span>{CurrentPageReport}</span> {NextPageLink} {LastPageLink}",
      previousPageLinkLabel : '&lt;',
      firstPageLinkLabel : '&lt;&lt;',
      nextPageLinkLabel : '&gt;',
      lastPageLinkLabel : '&gt;&gt;',
      pageReportTemplate : 'R&eacute;sultats {startRecord} &agrave; {endRecord} sur {totalRecords}'
    });
  
    myPaginator.render();
  }
  
  function doSearchPayment(filter, sort) {
    var queryUrl = YAHOO.capdematBo.baseUrl + "/loadPayments?" +  zcc.collectSearchFormValues('paymentForm');	
    if (filter) {
      var el = document.getElementById(filter);
      queryUrl += '&' + filter + '=' + el.value;
    }
      zcc.doAjaxFormSubmitCall('paymentForm',['search-results'],handleSearchPaymentSuccess);	
  }
  
  function handleSearchPaymentSuccess(o) {
    document.getElementById(o.argument[0]).innerHTML = o.responseText;
    displayPaginator();
  }

}());