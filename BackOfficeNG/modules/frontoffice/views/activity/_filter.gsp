<div class="narrow-box">
  <h3>
    <g:message code="header.filterBy" />
  </h3>
  <div class="body">
    <form action="" method="get">
      <label class="title"><g:message code="property.date" /> :</label>
      <select name="month" class="month-filter">
        <g:each in="${(1 .. 12)}">
          <option value="${it}" ${(month == null && currentMonth == it) || month.equals(it.toString()) ? 'selected="selected"':''}>
            ${monthsNames[it]}
          </option>
        </g:each>
      </select>
      <select name="year" class="year-filter">
        <g:each in="${(2004 .. (currentYear - 1))}">
          <option value="${it}" ${year.equals(it.toString()) ? 'selected="selected"':''}>
            ${it}
          </option>
        </g:each>
        <option value="${currentYear}" ${year == null || year.equals(currentYear.toString()) ? 'selected="selected"':''}>
          ${currentYear}
        </option>
      </select>
      <input type="hidden" name="name" value="${individual}" />
      <input type="hidden" name="label" value="${label}" />
      <input type="submit" value="${message(code:'action.filter')}"/>
    </form>
  </div>
</div>
