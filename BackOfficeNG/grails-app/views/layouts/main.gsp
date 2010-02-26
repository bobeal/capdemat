<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-Transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title><g:layoutTitle default="Back Office CapDémat" /></title>
    <g:render template="/shared/resources" />
    <g:layoutHead />
  </head>
  <body>
  
    <div id="doc4" class="yui-t4 yui-skin-sam">
    
      <!-- header -->
      <div id="hd">
        <g:render template="/shared/menu" />
      </div>
      
      <!-- body -->
      <div id="bd">
        <div id="errorMessages" class="invisible"></div>
          <!-- main content area -->
          <g:layoutBody />
      </div>

      <!-- footer -->
      <div id="ft"></div>

    </div>
    
  </body>
</html>
