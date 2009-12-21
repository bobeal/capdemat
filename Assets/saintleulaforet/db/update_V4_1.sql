update local_authority set postal_code = '95320', display_title = 'Saint-Leu-la-Forêt', 
    instruction_alerts_enabled = 'false', instruction_alerts_detailed = 'false',
    instruction_default_max_delay = 10, instruction_default_alert_delay = 3;

update request_form set xsl_fo_filename = null, template_name = 'general', personalized_data = '' where type = 'Request Mail Template';

-- ACR - Accusé de réception
update request_form set personalized_data = 'Je fais suite \\303\\240 votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 r\\303\\251ceptionn\\303\\251e par nos services.<br /><br />Vous recevrez votre certificat d''alignement dans un d\\303\\251lai d''un mois par courrier.<br />'
    where id = 971;

-- ACR - Refus
update request_form set personalized_data = 'Je fais suite \\303\\240 votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que le document demand\\303\\251 par courrier du #{RQ_OBSERV} ne nous \\303\\251tant pas parvenu dans un d\\303\\251lai de deux mois, votre demande est consid\\303\\251r\\303\\251e sans suite.<br />'
    where id = 976;

-- ACR - Demande d'info
update request_form set personalized_data = 'Je fais suite \\303\\240 votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que j''ai besoin d''information compl\\303\\251mentaire pour traiter votre requ\\303\\252te :<br /><br />#{RQ_OBSERV}<br /><br />Vous avez la possibilit\\303\\251 de me retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:droitdessols@saint-leu-la-foret.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">droitdessols@saint-leu-la-foret.fr</a> ou par courrier \\303\\240 la Direction de l''urbanisme et de l''am\\303\\251nagement. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br /><br />A d\\303\\251faut de r\\303\\251ception de ce document dans un d\\303\\251lai de deux mois, votre demande serait consid\\303\\251r\\303\\251e sans suite.<br />'
    where id = 975;

