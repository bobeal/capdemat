-- ACR - Accusé de réception
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 r\\303\\251ceptionn\\303\\251e par nos services.<br /><br />Vous recevrez votre certificat d''alignement dans un d\\303\\251lai d''un mois par courrier.<br />',
    template_name = 'urbanism'
    where id = 971;

-- ACR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que le document demand\\303\\251 par courrier du #{RQ_OBSERV} ne nous \\303\\251tant pas parvenu dans un d\\303\\251lai de deux mois, votre demande est consid\\303\\251r\\303\\251e sans suite.<br />',
    template_name = 'urbanism'
    where id = 976;

-- ACR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''information compl\\303\\251mentaire pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:droitdessols@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">droitdessols@saint-leu-la-foret.fr</a> ou par courrier \\303\\240 la Direction de l''urbanisme et de l''am\\303\\251nagement. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br /><br />A d\\303\\251faut de r\\303\\251ception de ce document dans un d\\303\\251lai de deux mois, votre demande serait consid\\303\\251r\\303\\251e sans suite.<br />',
    template_name = 'urbanism'
    where id = 975;

-- BDR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dsp@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dsp@saint-leu-la-foret.fr</a> ou par courrier au service \\303\\251tat civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.',
    template_name = 'civil'
    where id = 97;

-- BDR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 164;

-- BDR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Vous recevrez prochainement l''acte par courrier \\303\\240 l''adresse indiqu\\303\\251e dans votre demande.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.',
    template_name = 'civil'
    where id = 163;

-- BDR - Validation copie intégrale
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Vous pouvez retirer cet acte \\303\\240 la mairie de votre domicile sur pr\\303\\251sentation d''une pi\\303\\250ce d''identit\\303\\251, dans un d\\303\\251lai de cinq jours ouvrables.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 585;

-- BDR - Mairie demandeur
update request_form set personalized_data = 'Je vous saurais gr\\303\\251 de bien vouloir transmettre l''acte joint au demandeur, #{RR_TITLE} #{RR_LNAME}, qui viendra le retirer muni d''une pi\\303\\250ce d''identit\\303\\251.<br /><br />Avec mes remerciements, je vous prie d\\342\\200\\231agr\\303\\251er, Madame, Monsieur, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil_local_authority'
    where id = 596;

-- DDR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dsp@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dsp@saint-leu-la-foret.fr</a> ou par courrier au service \\303\\251tat civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.',
    template_name = 'civil'
    where id = 171;

-- DDR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 172;

-- DDR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Vous recevrez prochainement l''acte par courrier \\303\\240 l''adresse indiqu\\303\\251e dans votre demande.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.',
    template_name = 'civil'
    where id = 170;

-- MDR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dsp@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dsp@saint-leu-la-foret.fr</a> ou par courrier au service \\303\\251tat civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.',
    template_name = 'civil'
    where id = 168;

-- MDR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 169;

-- MDR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Vous recevrez prochainement l''acte par courrier \\303\\240 l''adresse indiqu\\303\\251e dans votre demande.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.',
    template_name = 'civil'
    where id = 167;

-- MDR - Validation copie intégrale
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Vous pouvez retirer cet acte \\303\\240 la mairie de votre domicile sur pr\\303\\251sentation d''une pi\\303\\250ce d''identit\\303\\251, dans un d\\303\\251lai de cinq jours ouvrables.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 586;

-- MDR - Mairie demandeur
update request_form set personalized_data = 'Je vous saurais gr\\303\\251 de bien vouloir transmettre l''acte joint au demandeur, #{RR_TITLE} #{RR_LNAME}, qui viendra le retirer muni d''une pi\\303\\250ce d''identit\\303\\251.<br /><br />Avec mes remerciements, je vous prie d\\342\\200\\231agr\\303\\251er, Madame, Monsieur, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil_local_authority'
    where id = 597;

-- ERRR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dsp@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dsp@saint-leu-la-foret.fr</a> ou par courrier au service \\303\\251tat civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.',
    template_name = 'civil'
    where id = 177;

-- ERRR - Refus demande
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 592;

-- ERRR - Demande refusée
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:etatcivil@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">etatcivil@saint-leu-la-foret.fr</a> ou par courrier au service \\303\\251tat civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br /><br />Dans l''attente, je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 178;

-- ERRR - Validation demande
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Je vous contacterai en temps utile pour inviter la personne concern\\303\\251e \\303\\240 venir en mairie avec sa pi\\303\\250ce d''identit\\303\\251 retirer sa carte d''\\303\\251lecteur.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.',
    template_name = 'civil'
    where id = 176;

-- MCR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dsp@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dsp@saint-leu-la-foret.fr</a> ou par courrier au service \\303\\251tat civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.',
    template_name = 'civil'
    where id = 174;

-- MCR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 175;

-- MCR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Pour retirer l''attestation, j''invite la personne concern\\303\\251e \\303\\240 venir en mairie avec une pi\\303\\250ce d''identit\\303\\251, dans un d\\303\\251lai de cinq jours ouvr\\303\\251s.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.',
    template_name = 'civil'
    where id = 594;

-- HFMR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dsp@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dsp@saint-leu-la-foret.fr</a> ou par courrier \\303\\240 la Direction des services \\303\\240 la population. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br />',
    template_name = 'civil'
    where id = 132;

-- HFMR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 133;

-- HFMR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Pour finaliser votre demande, je vous invite \\303\\240 venir en mairie avec les pi\\303\\250ces justificatives suivantes : livret de famille, carte d''identit\\303\\251 et justificatif de domicile.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 131;

-- VCR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dsp@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dsp@saint-leu-la-foret.fr</a> ou par courrier \\303\\240 la Direction des services \\303\\240 la population. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br />',
    template_name = 'civil'
    where id = 129;

-- VCR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 refus\\303\\251e :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 130;

-- VCR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Pour finaliser votre demande, je vous invite \\303\\240 venir en mairie avec les pi\\303\\250ces justificatives suivantes : livret de famille, carte d''identit\\303\\251 et justificatif de domicile.<br /><br/>Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'civil'
    where id = 128;

-- PARR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} de l''enfant, #{SU_FNAME} #{SU_LNAME}, en date du #{RQ_CDATE}, pour vous informer qu''elle est refus\\303\\251e pour la raison suivante :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'school_perischool'
    where id = 584;

-- PARR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} de l''enfant, #{SU_FNAME} #{SU_LNAME}, en date du #{RQ_CDATE}, pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Cette inscription est valable pour toute l''ann\\303\\251e scolaire.<br /><br />Afin de pr\\303\\251voir le personnel d''encadrement n\\303\\251cessaire, toute annulation doit \\303\\252tre signal\\303\\251e le plus rapidement possible en mairie en appelant au 01 30 40 22 00. A d\\303\\251faut, le repas command\\303\\251 vous sera factur\\303\\251 sauf sur production d''un certificat m\\303\\251dical.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.',
    template_name = 'school_perischool'
    where id = 583;

-- SCRR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} de l''enfant, #{SU_FNAME} #{SU_LNAME}, en date du #{RQ_CDATE}, pour vous informer qu''elle est refus\\303\\251e pour la raison suivante :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'school_perischool'
    where id = 582;

-- SCRR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} de l''enfant, #{SU_FNAME} #{SU_LNAME}, en date du #{RQ_CDATE}, pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Cette inscription est valable pour toute l''ann\\303\\251e scolaire.<br /><br />Pour une bonne gestion des commandes de repas, toute annulation doit \\303\\252tre signal\\303\\251e le plus rapidement possible en mairie en appelant au 01 30 40 22 00. A d\\303\\251faut, le repas command\\303\\251 vous sera factur\\303\\251 sauf sur production d''un certificat m\\303\\251dical.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'school_perischool'
    where id = 574;

-- SRR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} de l''enfant, #{SU_FNAME} #{SU_LNAME}, en date du #{RQ_CDATE}, pour vous informer qu''elle est refus\\303\\251e pour la raison suivante :<br /><br />#{RQ_OBSERV}<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'school_perischool'
    where id = 181;

-- SRR - Demande d'infos
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} de l''enfant, #{SU_FNAME} #{SU_LNAME}, en date du #{RQ_CDATE}, pour vous informer j''ai besoin d''informations compl\\303\\251mentaires pour la traiter :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:dej@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">dej@saint-leu-la-foret.fr</a> ou par courrier \\303\\240 la Direction de l''\\303\\251ducation et de la jeunesse, p\\303\\264le scolaire. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'school_perischool'
    where id = 180;

-- SRR - Validation
update request_form set personalized_data = 'Je fais suite \\303\\240 votre #{RQ_TP_LABEL} de l''enfant, #{SU_FNAME} #{SU_LNAME}, en date du #{RQ_CDATE}, pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br />Son \\303\\251cole d''affectation est : #{RQ_OBSERV}.<br /><br />Pour confirmer l''inscription, je vous invite \\303\\240 prendre rendez-vous avec la directrice de l''\\303\\251cole.<br /><br />Je vous prie d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, l''expression de ma consid\\303\\251ration distingu\\303\\251e.<br />',
    template_name = 'school_perischool'
    where id = 179;

