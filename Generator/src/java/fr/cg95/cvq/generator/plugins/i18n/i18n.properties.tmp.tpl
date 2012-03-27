${acronym}.duration.value =

${acronym}.property.subject.label = Sujet
<% steps.each { %>
${acronym}.step.${it.name}.label =
${acronym}.step.${it.name}.desc =
<% } %>
<% elements.each { %>
${it.i18nPrefixCode}.help =
${it.i18nPrefixCode}.validationError =
<% if (it.typeClass == "COLLECTION") { %>
${it.i18nPrefixCode}.elementAdditionSuccess =
<% } %>
<% } %>

${acronym}.step.homeFolder.label = Compte famille
${acronym}.step.homeFolder.desc = Composition de votre compte famille

${acronym}.incitationText.desc = <span style="font-weight: bold;">Avant de continuer votre demande, merci de :</span><br /> - vérifier l''exactitude des informations de votre compte et des membres qui le compose<br /> - compléter votre compte en ajoutant tous les membres de votre famille (responsables légaux et enfants).<br /><br /><a href="{0}">Je souhaite accéder à mon compte pour le mettre à jour.</a><br /><span style="font-style: italic; font-size: 0.9em;">(Vous pourrez reprendre votre demande après avoir mis à jour votre compte.)
${acronym}.incitationText.desc2 = <a href="{0}">Je souhaite accéder à mon compte pour le mettre à jour.</a><br /><span style="font-style: italic; font-size: 0.9em;">(Vous pourrez reprendre votre demande après avoir mis à jour votre compte.)</span>
