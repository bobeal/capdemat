update local_authority set postal_code = '95620', display_title = 'Parmain', 
    instruction_alerts_enabled = 'false', instruction_alerts_detailed = 'false',
    instruction_default_max_delay = 10, instruction_default_alert_delay = 3;

update request_form set xsl_fo_filename = null, personalized_data = null where type = 'Request Mail Template';

-- vcr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation',  personalized_data = '<p>Votre demande #{RQ_TP_LABEL} du #{RQ_CDATE} est accept\303\251e. Vous pouvez d\303\251s \303\240 pr\303\251sent vous pr\303\251senter \303\240 la Mairie avec vos documents originaux pour retirer votre carte foyer.</p>\012    <p>#{RQ_OBSERV}</p>' where id = 81326;
update request_form set template_name = 'demande_d_information' where id = 81333;
update request_form set template_name = 'dossier_deja_traite' where id = 81342;

-- hmr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 81327;
update request_form set template_name = 'demande_d_information' where id = 81332;
update request_form set template_name = 'dossier_deja_traite' where id = 81343;

-- srr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation',  personalized_data = '<p>Nous vous confirmons #{RQ_TP_LABEL} du #{RQ_CDATE} de votre enfant #{SU_FNAME} #{SU_LNAME}</p>\012    <p>#{RQ_OBSERV}</p>' where id = 81331;
update request_form set template_name = 'demande_d_information' where id = 81337;
update request_form set template_name = 'dossier_deja_traite' where id = 81339;

-- scrr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 81328;
update request_form set template_name = 'demande_d_information' where id = 81334;
update request_form set template_name = 'dossier_deja_traite' where id = 81341;

-- parr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 81330;
update request_form set template_name = 'demande_d_information' where id = 81336;
update request_form set template_name = 'dossier_deja_traite' where id = 81340;

