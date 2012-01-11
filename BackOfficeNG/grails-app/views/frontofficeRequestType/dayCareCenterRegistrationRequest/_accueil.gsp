


  
    <label class="required"><g:message code="dccrr.property.modeAccueil.label" /> *  <span><g:message code="dccrr.property.modeAccueil.help" /></span></label>
            <ul class="yes-no required ${rqt.stepStates['accueil'].invalidFields.contains('modeAccueil') ? 'validation-failed' : ''}">
              <g:each in="${[true,false]}">
              <li>
                <input type="radio" id="modeAccueil_${it ? 'yes' : 'no'}" class="required condition-estIndifferent-trigger  validate-one-required boolean" title="" value="${it}" name="modeAccueil" ${it == rqt.modeAccueil ? 'checked="checked"': ''} />
                <label for="modeAccueil_${it ? 'yes' : 'no'}"><g:message code="message.${it ? 'yes' : 'no'}" /></label>
              </li>
              </g:each>
            </ul>
            

  

  
    <label for="modeAccueilChoixUn" class="required condition-estIndifferent-filled"><g:message code="dccrr.property.modeAccueilChoixUn.label" /> *  <span><g:message code="dccrr.property.modeAccueilChoixUn.help" /></span></label>
            <select id="modeAccueilChoixUn" name="modeAccueilChoixUn" class="required condition-estIndifferent-filled  validate-not-first ${rqt.stepStates['accueil'].invalidFields.contains('modeAccueilChoixUn') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.modeAccueilChoixUn.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['COLLECTIF','FAMILIAL']}">
                <option value="${it}" ${it == rqt.modeAccueilChoixUn?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.modeAccueilChoixUn" /></option>
              </g:each>
            </select>
            

  

  
    <label for="modeAccueilChoixDeux" class="condition-estIndifferent-filled"><g:message code="dccrr.property.modeAccueilChoixDeux.label" />   <span><g:message code="dccrr.property.modeAccueilChoixDeux.help" /></span></label>
            <select id="modeAccueilChoixDeux" name="modeAccueilChoixDeux" class="condition-estIndifferent-filled  validate-select ${rqt.stepStates['accueil'].invalidFields.contains('modeAccueilChoixDeux') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.modeAccueilChoixDeux.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['COLLECTIF','FAMILIAL']}">
                <option value="${it}" ${it == rqt.modeAccueilChoixDeux?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.modeAccueilChoixDeux" /></option>
              </g:each>
            </select>
            

  

  
    <label for="accueilAnterieur" class=""><g:message code="dccrr.property.accueilAnterieur.label" />   <span><g:message code="dccrr.property.accueilAnterieur.help" /></span></label>
            <input type="text" id="accueilAnterieur" name="accueilAnterieur" value="${rqt.accueilAnterieur?.toString()}" 
                    class="  validate-string ${rqt.stepStates['accueil'].invalidFields.contains('accueilAnterieur') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.accueilAnterieur.validationError" />"   />
            

  

  
    <fieldset class="required">
    <legend><g:message code="dccrr.property.datePlacementAccueilRegulier.label" /></legend>
    
      <label for="choixTypeDatePlacementAccueilRegulier" class="required"><g:message code="dccrr.property.choixTypeDatePlacementAccueilRegulier.label" /> *  <span><g:message code="dccrr.property.choixTypeDatePlacementAccueilRegulier.help" /></span></label>
            <select id="choixTypeDatePlacementAccueilRegulier" name="choixTypeDatePlacementAccueilRegulier" class="required condition-dateConnue-trigger  validate-not-first ${rqt.stepStates['accueil'].invalidFields.contains('choixTypeDatePlacementAccueilRegulier') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.choixTypeDatePlacementAccueilRegulier.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['CONNUE','POSSIBLE']}">
                <option value="${it}" ${it == rqt.choixTypeDatePlacementAccueilRegulier?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.choixTypeDatePlacementAccueilRegulier" /></option>
              </g:each>
            </select>
            

    
      <label class="required condition-dateConnue-filled"><g:message code="dccrr.property.datePlacementDebut.label" /> *  <span><g:message code="dccrr.property.datePlacementDebut.help" /></span></label>
            <div class="date required condition-dateConnue-filled  validate-date required condition-dateConnue-filled ">
              <select class="day ${rqt.stepStates['accueil'].invalidFields.contains('datePlacementDebut') ? 'validation-failed' : ''}"
                id="datePlacementDebut_day"
                name="datePlacementDebut_day">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..31}">
                  <option value="${it}"
                    <g:if test="${rqt.datePlacementDebut?.date == it
                      || (rqt.datePlacementDebut == null && params['datePlacementDebut_day'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <select class="month ${rqt.stepStates['accueil'].invalidFields.contains('datePlacementDebut') ? 'validation-failed' : ''}"
                id="datePlacementDebut_month"
                name="datePlacementDebut_month">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${1..12}">
                  <option value="${it}"
                    <g:if test="${rqt.datePlacementDebut?.month == (it - 1)
                      || (rqt.datePlacementDebut == null && params['datePlacementDebut_month'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    <g:message code="month.${it}" />
                  </option>
                </g:each>
              </select>
              <input type="text" maxlength="4" size="3"
                class="year ${rqt.stepStates['accueil'].invalidFields.contains('datePlacementDebut') ? 'validation-failed' : ''}"
                id="datePlacementDebut_year"
                name="datePlacementDebut_year"
                value="${rqt.datePlacementDebut ? rqt.datePlacementDebut.year + 1900 : params['datePlacementDebut_year']}"
                title="<g:message code="dccrr.property.datePlacementDebut.validationError" />" />
            </div>
            

    
    </fieldset>
  

  
    <label for="choixHorairesAccueil" class="required"><g:message code="dccrr.property.choixHorairesAccueil.label" /> *  <span><g:message code="dccrr.property.choixHorairesAccueil.help" /></span></label>
            <select id="choixHorairesAccueil" name="choixHorairesAccueil" class="required condition-estHorairesAccueilRegulier-trigger condition-estHorairesAccueilIrregulier-trigger  validate-not-first ${rqt.stepStates['accueil'].invalidFields.contains('choixHorairesAccueil') ? 'validation-failed' : ''}" title="<g:message code="dccrr.property.choixHorairesAccueil.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['INDIFFERENT','REGULIER','IRREGULIER']}">
                <option value="${it}" ${it == rqt.choixHorairesAccueil?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="dccrr.property.choixHorairesAccueil" /></option>
              </g:each>
            </select>
            

  

  
    <fieldset class="required condition-estHorairesAccueilRegulier-filled">
    <legend><g:message code="dccrr.property.plageHoraireAccueilReguliere.label" /></legend>
    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinDebut.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinDebut.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebut') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebut_hour"
                name="horairePlacementMatinDebut_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebut?.hourOfDay == it
                      || (rqt.horairePlacementMatinDebut == null && params['horairePlacementMatinDebut_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebut') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebut_minute"
                name="horairePlacementMatinDebut_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebut?.minuteOfHour == it
                      || (rqt.horairePlacementMatinDebut == null && params['horairePlacementMatinDebut_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinFin.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinFin.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFin') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFin_hour"
                name="horairePlacementMatinFin_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFin?.hourOfDay == it
                      || (rqt.horairePlacementMatinFin == null && params['horairePlacementMatinFin_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFin') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFin_minute"
                name="horairePlacementMatinFin_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFin?.minuteOfHour == it
                      || (rqt.horairePlacementMatinFin == null && params['horairePlacementMatinFin_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiDebut.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiDebut.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebut') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebut_hour"
                name="horairePlacementApresMidiDebut_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebut?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiDebut == null && params['horairePlacementApresMidiDebut_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebut') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebut_minute"
                name="horairePlacementApresMidiDebut_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebut?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiDebut == null && params['horairePlacementApresMidiDebut_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiFin.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiFin.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFin') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFin_hour"
                name="horairePlacementApresMidiFin_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFin?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiFin == null && params['horairePlacementApresMidiFin_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFin') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFin_minute"
                name="horairePlacementApresMidiFin_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFin?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiFin == null && params['horairePlacementApresMidiFin_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-estHorairesAccueilIrregulier-filled">
    <legend><g:message code="dccrr.property.lundi.label" /></legend>
    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinDebutLundi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinDebutLundi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutLundi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutLundi_hour"
                name="horairePlacementMatinDebutLundi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutLundi?.hourOfDay == it
                      || (rqt.horairePlacementMatinDebutLundi == null && params['horairePlacementMatinDebutLundi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutLundi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutLundi_minute"
                name="horairePlacementMatinDebutLundi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutLundi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinDebutLundi == null && params['horairePlacementMatinDebutLundi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinFinLundi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinFinLundi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinLundi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinLundi_hour"
                name="horairePlacementMatinFinLundi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinLundi?.hourOfDay == it
                      || (rqt.horairePlacementMatinFinLundi == null && params['horairePlacementMatinFinLundi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinLundi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinLundi_minute"
                name="horairePlacementMatinFinLundi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinLundi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinFinLundi == null && params['horairePlacementMatinFinLundi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiDebutLundi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiDebutLundi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutLundi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutLundi_hour"
                name="horairePlacementApresMidiDebutLundi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutLundi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiDebutLundi == null && params['horairePlacementApresMidiDebutLundi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutLundi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutLundi_minute"
                name="horairePlacementApresMidiDebutLundi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutLundi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiDebutLundi == null && params['horairePlacementApresMidiDebutLundi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiFinLundi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiFinLundi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinLundi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinLundi_hour"
                name="horairePlacementApresMidiFinLundi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinLundi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiFinLundi == null && params['horairePlacementApresMidiFinLundi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinLundi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinLundi_minute"
                name="horairePlacementApresMidiFinLundi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinLundi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiFinLundi == null && params['horairePlacementApresMidiFinLundi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-estHorairesAccueilIrregulier-filled">
    <legend><g:message code="dccrr.property.mardi.label" /></legend>
    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinDebutMardi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinDebutMardi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutMardi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutMardi_hour"
                name="horairePlacementMatinDebutMardi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutMardi?.hourOfDay == it
                      || (rqt.horairePlacementMatinDebutMardi == null && params['horairePlacementMatinDebutMardi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutMardi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutMardi_minute"
                name="horairePlacementMatinDebutMardi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutMardi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinDebutMardi == null && params['horairePlacementMatinDebutMardi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinFinMardi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinFinMardi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinMardi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinMardi_hour"
                name="horairePlacementMatinFinMardi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinMardi?.hourOfDay == it
                      || (rqt.horairePlacementMatinFinMardi == null && params['horairePlacementMatinFinMardi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinMardi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinMardi_minute"
                name="horairePlacementMatinFinMardi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinMardi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinFinMardi == null && params['horairePlacementMatinFinMardi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiDebutMardi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiDebutMardi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutMardi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutMardi_hour"
                name="horairePlacementApresMidiDebutMardi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutMardi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiDebutMardi == null && params['horairePlacementApresMidiDebutMardi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutMardi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutMardi_minute"
                name="horairePlacementApresMidiDebutMardi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutMardi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiDebutMardi == null && params['horairePlacementApresMidiDebutMardi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiFinMardi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiFinMardi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinMardi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinMardi_hour"
                name="horairePlacementApresMidiFinMardi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinMardi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiFinMardi == null && params['horairePlacementApresMidiFinMardi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinMardi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinMardi_minute"
                name="horairePlacementApresMidiFinMardi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinMardi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiFinMardi == null && params['horairePlacementApresMidiFinMardi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-estHorairesAccueilIrregulier-filled">
    <legend><g:message code="dccrr.property.mercredi.label" /></legend>
    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinDebutMercredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinDebutMercredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutMercredi_hour"
                name="horairePlacementMatinDebutMercredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutMercredi?.hourOfDay == it
                      || (rqt.horairePlacementMatinDebutMercredi == null && params['horairePlacementMatinDebutMercredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutMercredi_minute"
                name="horairePlacementMatinDebutMercredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutMercredi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinDebutMercredi == null && params['horairePlacementMatinDebutMercredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinFinMercredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinFinMercredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinMercredi_hour"
                name="horairePlacementMatinFinMercredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinMercredi?.hourOfDay == it
                      || (rqt.horairePlacementMatinFinMercredi == null && params['horairePlacementMatinFinMercredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinMercredi_minute"
                name="horairePlacementMatinFinMercredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinMercredi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinFinMercredi == null && params['horairePlacementMatinFinMercredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiDebutMercredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiDebutMercredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutMercredi_hour"
                name="horairePlacementApresMidiDebutMercredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutMercredi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiDebutMercredi == null && params['horairePlacementApresMidiDebutMercredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutMercredi_minute"
                name="horairePlacementApresMidiDebutMercredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutMercredi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiDebutMercredi == null && params['horairePlacementApresMidiDebutMercredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiFinMercredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiFinMercredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinMercredi_hour"
                name="horairePlacementApresMidiFinMercredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinMercredi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiFinMercredi == null && params['horairePlacementApresMidiFinMercredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinMercredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinMercredi_minute"
                name="horairePlacementApresMidiFinMercredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinMercredi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiFinMercredi == null && params['horairePlacementApresMidiFinMercredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-estHorairesAccueilIrregulier-filled">
    <legend><g:message code="dccrr.property.jeudi.label" /></legend>
    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinDebutJeudi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinDebutJeudi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutJeudi_hour"
                name="horairePlacementMatinDebutJeudi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutJeudi?.hourOfDay == it
                      || (rqt.horairePlacementMatinDebutJeudi == null && params['horairePlacementMatinDebutJeudi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutJeudi_minute"
                name="horairePlacementMatinDebutJeudi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutJeudi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinDebutJeudi == null && params['horairePlacementMatinDebutJeudi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinFinJeudi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinFinJeudi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinJeudi_hour"
                name="horairePlacementMatinFinJeudi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinJeudi?.hourOfDay == it
                      || (rqt.horairePlacementMatinFinJeudi == null && params['horairePlacementMatinFinJeudi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinJeudi_minute"
                name="horairePlacementMatinFinJeudi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinJeudi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinFinJeudi == null && params['horairePlacementMatinFinJeudi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiDebutJeudi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiDebutJeudi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutJeudi_hour"
                name="horairePlacementApresMidiDebutJeudi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutJeudi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiDebutJeudi == null && params['horairePlacementApresMidiDebutJeudi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutJeudi_minute"
                name="horairePlacementApresMidiDebutJeudi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutJeudi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiDebutJeudi == null && params['horairePlacementApresMidiDebutJeudi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiFinJeudi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiFinJeudi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinJeudi_hour"
                name="horairePlacementApresMidiFinJeudi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinJeudi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiFinJeudi == null && params['horairePlacementApresMidiFinJeudi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinJeudi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinJeudi_minute"
                name="horairePlacementApresMidiFinJeudi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinJeudi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiFinJeudi == null && params['horairePlacementApresMidiFinJeudi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
    </fieldset>
  

  
    <fieldset class="required condition-estHorairesAccueilIrregulier-filled">
    <legend><g:message code="dccrr.property.vendredi.label" /></legend>
    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinDebutVendredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinDebutVendredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutVendredi_hour"
                name="horairePlacementMatinDebutVendredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutVendredi?.hourOfDay == it
                      || (rqt.horairePlacementMatinDebutVendredi == null && params['horairePlacementMatinDebutVendredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinDebutVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinDebutVendredi_minute"
                name="horairePlacementMatinDebutVendredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinDebutVendredi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinDebutVendredi == null && params['horairePlacementMatinDebutVendredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementMatinFinVendredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementMatinFinVendredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinVendredi_hour"
                name="horairePlacementMatinFinVendredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinVendredi?.hourOfDay == it
                      || (rqt.horairePlacementMatinFinVendredi == null && params['horairePlacementMatinFinVendredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementMatinFinVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementMatinFinVendredi_minute"
                name="horairePlacementMatinFinVendredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementMatinFinVendredi?.minuteOfHour == it
                      || (rqt.horairePlacementMatinFinVendredi == null && params['horairePlacementMatinFinVendredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiDebutVendredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiDebutVendredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutVendredi_hour"
                name="horairePlacementApresMidiDebutVendredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutVendredi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiDebutVendredi == null && params['horairePlacementApresMidiDebutVendredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiDebutVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiDebutVendredi_minute"
                name="horairePlacementApresMidiDebutVendredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiDebutVendredi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiDebutVendredi == null && params['horairePlacementApresMidiDebutVendredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
      
            <div class="time   validate-time  ">
              <label class=""><g:message code="dccrr.property.horairePlacementApresMidiFinVendredi.label" />   
                <span><g:message code="dccrr.property.horairePlacementApresMidiFinVendredi.help" /></span>
              </label>
              <select class="hour ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinVendredi_hour"
                name="horairePlacementApresMidiFinVendredi_hour">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..23}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinVendredi?.hourOfDay == it
                      || (rqt.horairePlacementApresMidiFinVendredi == null && params['horairePlacementApresMidiFinVendredi_hour'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                    ${it}
                  </option>
                </g:each>
              </select>
              <g:message code="time.hour" />
              <select class="minute ${rqt.stepStates['accueil'].invalidFields.contains('horairePlacementApresMidiFinVendredi') ? 'validation-failed' : ''}"
                id="horairePlacementApresMidiFinVendredi_minute"
                name="horairePlacementApresMidiFinVendredi_minute">
                <option value=""><g:message code="message.select.defaultOption" /></option>
                <g:each in="${0..59}">
                 <g:if test="${(it % 5) == 0}">
                  <option value="${it}"
                    <g:if test="${rqt.horairePlacementApresMidiFinVendredi?.minuteOfHour == it
                      || (rqt.horairePlacementApresMidiFinVendredi == null && params['horairePlacementApresMidiFinVendredi_minute'] == it.toString())}">
                      selected="selected"
                    </g:if>>
                        <g:if test="${it < 10}">
                           0${it}
                        </g:if>
                        <g:else>
                            ${it}
                        </g:else>
                  </option>
                 </g:if>
                </g:each>
              </select>
              <g:message code="time.minute" />
            </div>
            

    
    </fieldset>
  

