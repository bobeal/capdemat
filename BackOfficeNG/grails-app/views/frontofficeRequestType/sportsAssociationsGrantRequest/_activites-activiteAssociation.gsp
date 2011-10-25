
  <g:set var="currentCollectionItem" value="${rqt?.activiteAssociation.size() > collectionIndex ? rqt.activiteAssociation.get(collectionIndex) : null}" />
  <h4>
    ${message(code:'sagr.property.activiteAssociation.label')}
    <span>
      <g:if test="${currentCollectionItem != null}">
        ${message(code:'request.message.editCollectionItem', args:[collectionIndex + 1])}
      </g:if>
      <g:else>
        ${message(code:'request.message.addCollectionItem')}
      </g:else>
    </span>
  </h4>
  
    <label for="activiteAssociation.${collectionIndex}.sportPratique" class="required"><g:message code="sagr.property.sportPratique.label" /> *  <span><g:message code="sagr.property.sportPratique.help" /></span></label>
            <select id="activiteAssociation.${collectionIndex}.sportPratique" name="activiteAssociation[${collectionIndex}].sportPratique" class="required  validate-not-first ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].sportPratique') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.sportPratique.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['AEROMODELISME','AEROSTATION','AIKIDO','ATHLETISME','AVIRON','BADMINTON','BASE_BALL','BASKET_BALL','BILLARD','BOULES_LYONNAISES','BOWLING','BOXE_AMERICAINE','BOXE_ANGLAISE','BOXE_FRANCAISE','BOXE_THAILANDAISE','CANOE_KAYAK','COURSE_ORIENTATION','CYCLISME','CYCLO_TOURISME','CYCLO_VTT','DANSE','ECHECS','EQUITATION','ESCALADE_ET_MONTAGNE','ESCRIME','FOOTBALL','FOOTBALL_AMERICAIN','FUTSAL','GOLF','GYM_RYTHM_SPORTIVE','GYM_VOLONTAIRE','HALTEROPHILIE','HAND_BALL','HOCKEY_SUR_GLACE','JEU_DE_PAUME','JOUTES','JUDO','KARATE','KICKBOXING','LUTTE','MOTO_CYCLISME','NATATION','PARACHUTISME','PATINS_A_ROULETTES','PECHE_A_LA_MOUCHE','PECHE_AU_COUP','PETANQUE','RANDONNEE_PEDESTRE','ROLLER_SKATING_ET_DA','RUGBY','SAMBO','SKATE_BOARD','SKI','SKI_NAUTIQUE','SPELEOLOGIE','SPORTS_DE_GLACE','SPORTS_HANDICAPES','SPORTS_SOUS_MARINS','SQUASH','TAEKWONDO_ET_DA','TAICHI_CHUAN_QI_GONG','TENNIS','TENNIS_DE_TABLE','TIR_A_ARC','TIR_AUX_ARMES','TRAMPOLINE','TRIATHLON','TWIRLING_BATON','VIET_VO_DAO_ET_DA','VOILE','VOL_A_VOILE','VOL_LIBRE','VOLLEY_BALL','AUTRE']}">
                <option value="${it}" ${it == currentCollectionItem?.sportPratique?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sagr.property.sportPratique" /></option>
              </g:each>
            </select>
            

  
    <label for="activiteAssociation.${collectionIndex}.sportPratiquePrecision" class=""><g:message code="sagr.property.sportPratiquePrecision.label" />   <span><g:message code="sagr.property.sportPratiquePrecision.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.sportPratiquePrecision" name="activiteAssociation[${collectionIndex}].sportPratiquePrecision" value="${currentCollectionItem?.sportPratiquePrecision?.toString()}" 
                    class="  validate-string ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].sportPratiquePrecision') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.sportPratiquePrecision.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.federationSportive" class="required"><g:message code="sagr.property.federationSportive.label" /> *  <span><g:message code="sagr.property.federationSportive.help" /></span></label>
            <select id="activiteAssociation.${collectionIndex}.federationSportive" name="activiteAssociation[${collectionIndex}].federationSportive" class="required  validate-not-first ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].federationSportive') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.federationSportive.validationError" />">
              <option value=""><g:message code="message.select.defaultOption" /></option>
              <g:each in="${['AEROMODELISME','AEROSTATION','ATHLETISME','BADMINTON','BALLON_AU_POING','BASE_BALL','BASKET_BALL','BILLARD','BOWLING','BOXE_BOXE_ANGLAISE','CANOE_KAYAK','CHAR_A_VOILE','COURSE_D_ORIENTATION','CYCLISME','EDUCATION_PHYSIQUE_ET_GYMNASTIQUE_VOLONTAIRE','EQUITATION','ESCRIME','ETUDES_ET_SPORTS_SOUS_MARINS','FOOTBALL','FOOTBALL_AMERICAIN','GIRAVIATION','GOLF','GYMNASTIQUE','HALTEROPHILIE','HAND_BALL','HANDISPORT','HOCKEY','JEU_DE_BALLE_AU_TAMBOURIN','JUDO','KARATE','LONGUE_PAUME','LUTTE','MOTO_CYCLISME','MOTONAUTIQUE','MULTISPORTS_OMNISPORTS','NATATION','NATIONALE_AERONAUTIQUE','PARACHUTISME','PECHE_A_LA_MOUCHE','PECHE_EN_EAU_DOUCE','PECHE_EN_MER','PELOTE_BASQUE','PETANQUE','PLANNEUR_ULTRA_LEGER_MOTORISE','RANDONNEE_PEDESTRE','ROLLER_SKATING','RUGBY','RUGBY_A_XIII','SAMBO','SAUVETAGE_ET_SECOURISME','SKI_NAUTIQUE','SOCIETES_D_AVIRON','SPELEOLOGIE','SPORTS_ADAPTES','SPORTS_AUTOMOBILES','SPORTS_BOULES','SPORTS_DE_GLACE','SPORTS_DE_QUILLE','SPORTS_EN_MILIEU_RURAL','SQUASH','SURF_ET_SKATE','TENNIS','TENNIS_DE_TABLE','TIR','TIR_A_L_ARC','TRAMPOLINE','TRIATHLON','TWIRLING_BATON','VOILE','VOL_A_VOILE','VOL_LIBRE','VOLLEY_BALL','AUTRE']}">
                <option value="${it}" ${it == currentCollectionItem?.federationSportive?.toString() ? 'selected="selected"': ''}><g:capdematEnumToText var="${it}" i18nKeyPrefix="sagr.property.federationSportive" /></option>
              </g:each>
            </select>
            

  
    <label for="activiteAssociation.${collectionIndex}.federationSportivePrecision" class=""><g:message code="sagr.property.federationSportivePrecision.label" />   <span><g:message code="sagr.property.federationSportivePrecision.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.federationSportivePrecision" name="activiteAssociation[${collectionIndex}].federationSportivePrecision" value="${currentCollectionItem?.federationSportivePrecision?.toString()}" 
                    class="  validate-string ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].federationSportivePrecision') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.federationSportivePrecision.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.numeroAffiliationActivite" class="required"><g:message code="sagr.property.numeroAffiliationActivite.label" /> *  <span><g:message code="sagr.property.numeroAffiliationActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.numeroAffiliationActivite" name="activiteAssociation[${collectionIndex}].numeroAffiliationActivite" value="${currentCollectionItem?.numeroAffiliationActivite?.toString()}" 
                    class="required  validate-string ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].numeroAffiliationActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.numeroAffiliationActivite.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.nombreLicencieMineurActivite" class="required"><g:message code="sagr.property.nombreLicencieMineurActivite.label" /> *  <span><g:message code="sagr.property.nombreLicencieMineurActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.nombreLicencieMineurActivite" name="activiteAssociation[${collectionIndex}].nombreLicencieMineurActivite" value="${currentCollectionItem?.nombreLicencieMineurActivite?.toString()}" 
                    class="required  validate-long ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].nombreLicencieMineurActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nombreLicencieMineurActivite.validationError" />"   />
            

  
    <label for="activiteAssociation.${collectionIndex}.nombreLicencieMajeurActivite" class="required"><g:message code="sagr.property.nombreLicencieMajeurActivite.label" /> *  <span><g:message code="sagr.property.nombreLicencieMajeurActivite.help" /></span></label>
            <input type="text" id="activiteAssociation.${collectionIndex}.nombreLicencieMajeurActivite" name="activiteAssociation[${collectionIndex}].nombreLicencieMajeurActivite" value="${currentCollectionItem?.nombreLicencieMajeurActivite?.toString()}" 
                    class="required  validate-long ${rqt.stepStates['activites'].invalidFields.contains('activiteAssociation['+collectionIndex+'].nombreLicencieMajeurActivite') ? 'validation-failed' : ''}" title="<g:message code="sagr.property.nombreLicencieMajeurActivite.validationError" />"   />
            

  
  <input type="hidden" name="currentCollection" value="${currentCollection}" />
  <input type="hidden" name="collectionIndex" value="${collectionIndex}" />
  <input type="submit" id="collectionSave" name="collectionSave" value="${message(code:'action.' + (currentCollectionItem != null ? 'save' : 'add'))}" />
  <a href="${createLink(controller : 'frontofficeRequest', action : 'edit', params:['id': rqt.id, 'currentStep': 'activites'])}">
    ${message(code:'request.action.backToMainForm')}
  </a>
  
