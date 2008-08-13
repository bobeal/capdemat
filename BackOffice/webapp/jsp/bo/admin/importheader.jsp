<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/cartevaloise.tld" prefix="cvq" %>

<html:form action="/importAction.do?action=load" enctype="multipart/form-data" styleClass="form_block">

  <fieldset class="fieldset001">
    <div class="form_cell form_cell001">
      <label for="dataType" class="label">Type de données :</label>
      <span class="input">
        <html:select name="ImportForm" property="dataType" styleId="dataType" styleClass="input_select">
          <option value="">Choisissez un type de donnée</option>
          <option value="XmlRequests">Demandes sous forme xml</option>
          <option value="Concerto">Export Concerto</option>
          <option value="SubscribersList">Liste d'abonnés spectacles</option>
          <option value="LetterLayout">Mise en page courrier type</option>
          <option value="FrontOfficeInformation">Information pour les habitants</option>
        </html:select>
      </span>
    </div>
    <div class="form_cell form_cell002">
      <label for="file" class="label">Fichier à importer :</label>
      <span class="input"><html:file name="ImportForm" property="file" styleId="file" styleClass="input_file"/></span>
    </div>
  </fieldset>

  <fieldset class="fieldset002">
    <div class="form_cell">
      <input type="submit" name="load" id="load" class="input_submit" value="Charger"/>
    </div>
  </fieldset></html:form><%-- BUG MSIE6 --%>
