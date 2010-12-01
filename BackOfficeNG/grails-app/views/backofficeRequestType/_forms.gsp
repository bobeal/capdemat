<div id="requestTypeForms" class="yui-navset yellow-yui-tabview" style="display:block;">
  <ul class="yui-nav">
    <li class="selected" title="active">
      <a href="#confArea_Tab1"><em>${message(code:'requestType.header.formsList')}</em></a>
    </li>
  </ul>
  <div class="yui-content">
    <!-- First area -->
    <div id="confArea_Tab1">
      <div id="formsConfiguration">
        <!-- <h2>${message(code:'requestType.configuration.forms')}</h2> -->
        <div class="editableListSwithcher">
          <a id="linkShowDatasheet" href="javascript:;">${message(code:'action.create')}</a>
        </div>
        <div id="insertInList"></div>
        <div id="requestFormList"></div>
        <div class="separator"></div>
      </div>
    </div>
  </div>
</div>
<form method="post" id="templateForm" action="${createLink(action:'mailTemplate')}" class="editor-form">
  <div id="templatePanel">
    <div class="hd"></div>
    <div class="bd" >
      <div id="templateBody" style="display:none">
        <textarea id="templateEditor" rows="15" name="editor"></textarea>
        <input type="hidden" name="requestTypeId" value="${requestType.id}" />
        <input type="hidden" name="requestFormId" value="" />
        <input type="button" id="templateButton" name="submit"
          value="<g:message code='action.save' />" />
      </div>
    </div>
  </div>
</form>
