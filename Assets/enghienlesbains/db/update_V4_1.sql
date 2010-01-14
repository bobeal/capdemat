update local_authority set postal_code = '95880', display_title = 'Enghien-les-Bains', 
    instruction_alerts_enabled = 'false', instruction_alerts_detailed = 'true',
    instruction_default_max_delay = 10, instruction_default_alert_delay = 3;

update request_form set xsl_fo_filename = null, template_name = 'general', personalized_data = '' where type = 'Request Mail Template';

-- BDR - Attestation
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /></p><p>Vous recevrez prochainement l\\342\\200\\231acte par courrier \\303\\240 l\\342\\200\\231adresse indiqu\\303\\251e dans votre demande.</p><p>Nous vous rappelons qu''un seul acte est n\\303\\251cessaire pour \\303\\251tablir une pi\\303\\250ce d''identit\\303\\251 (passeport, carte d''identit\\303\\251, etc.).</p>'
    where id = 116;

-- BDR - Demande d'info
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que nous avons besoin d\\342\\200\\231informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :</p><p>#{RQ_OBSERV}</p><br />Vous avez la possibilit\\303\\251 de nous retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:etatcivil@enghien95.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">etatcivil@enghien95.fr</a> ou par courrier au service \\303\\251tat-civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br /><br />Dans l\\342\\200\\231attente, nous vous prions d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, nos salutations les plus distingu\\303\\251es.'
    where id = 115;

-- BDR - Demande refusée
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que nous ne pouvons pas le d\\303\\251livrer pour la raison suivante :</p><p>#{RQ_OBSERV}</p><br />Nous vous prions d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, nos salutations les plus distingu\\303\\251es.<br />'
    where id = 117;

-- DDR - Attestation
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br /></p><p>Vous recevrez prochainement l\\342\\200\\231acte par courrier \\303\\240 l\\342\\200\\231adresse indiqu\\303\\251e dans votre demande.</p>'
    where id = 105;
    
-- DDR - Demande d'info
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que nous avons besoin d\\342\\200\\231informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :</p><p>#{RQ_OBSERV}</p><br />Vous avez la possibilit\\303\\251 de nous retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:etatcivil@enghien95.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">etatcivil@enghien95.fr</a> ou par courrier au service \\303\\251tat-civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br /><br />Dans l\\342\\200\\231attente, nous vous prions d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, nos salutations les plus distingu\\303\\251es.'
    where id = 104;

-- DDR - Demande refusée
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que nous ne pouvons pas le d\\303\\251livrer pour la raison suivante :</p><p>#{RQ_OBSERV}</p><br />Nous vous prions d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, nos salutations les plus distingu\\303\\251es.<br />'
    where id = 106;

-- MDR - Attestation
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu''elle a \\303\\251t\\303\\251 valid\\303\\251e.<br /><br /></p><p>Vous recevrez prochainement l\\342\\200\\231acte par courrier \\303\\240 l\\342\\200\\231adresse indiqu\\303\\251e dans votre demande.</p>'
    where id = 108;

-- MDR - Demande d'info
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que nous avons besoin d\\342\\200\\231informations compl\\303\\251mentaires pour traiter votre requ\\303\\252te :</p><p>#{RQ_OBSERV}</p><br />Vous avez la possibilit\\303\\251 de nous retourner les informations par courriel \\303\\240 l\\342\\200\\231adresse <a href="mailto:etatcivil@enghien95.fr?subject=#{RQ_TP_LABEL} - #{RQ_ID}">etatcivil@enghien95.fr</a> ou par courrier au service \\303\\251tat-civil de la mairie. Dans tous les cas, veuillez rappeler le num\\303\\251ro de votre demande.<br /><br />Dans l\\342\\200\\231attente, nous vous prions d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, nos salutations les plus distingu\\303\\251es.'
    where id = 107;

-- MDR - Demande refusée
update request_form set personalized_data = '<p>Nous faisons suite \\303\\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer que nous ne pouvons pas le d\\303\\251livrer pour la raison suivante :</p><p>#{RQ_OBSERV}</p><br />Nous vous prions d\\342\\200\\231agr\\303\\251er, #{RR_TITLE}, nos salutations les plus distingu\\303\\251es.<br />'
    where id = 109;


