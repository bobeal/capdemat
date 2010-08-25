<html>
  <head>
    <title><g:message code="payment.header.details" args="${[params.id]}"/></title>
    <meta name="layout" content="main" />
    <script type="text/javascript" src="${resource(dir:'js/backoffice',file:'paymentDetails.js')}"></script>
    <link rel="stylesheet" href="${resource(dir:'css/backoffice/common/yui-skin/',file:'container.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css/backoffice',file:'payment.css')}" />
    <script type="text/javascript">
      zenexity.capdemat.bong.payment.id = '${payment.id}';
    </script>
  </head>
  <body>
  
  <div id="yui-main">
      <div class="yui-b">
        <div class="head">
          <h1>
            <g:message code="payment.header.details" args="${[params.id]}"/>
          </h1>
        </div>
        
        <div id="paymentData" class="yellow-yui-tabview">
            <ul class="yui-nav">
              <li class="selected"><a href="#page1"><em><g:message code="payment.property.details" /></em></a></li>
            </ul>
            <div class="yui-content">
              <!-- Page 1 -->
              <div id="page1">
                <h2><g:message code="payment.property.details" /></h2>
                <g:render template="detailsPayment" />
                <h2><g:message code="payment.property.items.details" /></h2>
                <g:each in="${items}" var="item">
                  <g:render template="detailsItem" model="['item':item]" />
                </g:each>
              </div>
            </div>
        
            <div id="paymentInformation" ><!-- Payment TabView --></div>
        </div>
    </div>
    
    <div id="narrow" class="yui-b">
        <!-- payment state -->
        <div class="nobox taskstate">
            <h3><g:message code="property.paymentState" /></h3>
            <div class="body">
                <span id="paymentState" class="tagged tag-${state}">
                    <g:message code="payment.state.${state}" />
                </span>
            </div>
        </div>
      
    </div>
  
  </body>
</html>