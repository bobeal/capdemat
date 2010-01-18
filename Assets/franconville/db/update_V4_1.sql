update local_authority set postal_code = '95130', display_title = 'Franconville', 
    instruction_alerts_enabled = 'false', instruction_alerts_detailed = 'false',
    instruction_default_max_delay = 10, instruction_default_alert_delay = 3,
    document_digitalization_enabled = 'false';

update request_form set xsl_fo_filename = null, personalized_data = null where type = 'Request Mail Template';

-- vcr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation',  personalized_data = '<p>Madame, Monsieur,</p>\012    <p>Votre demande cr\303\251ation de compte personnel du #{RQ_CDATE} est accept\303\251e et valid\303\251e.</p><p>Vous pouvez donc, d\303\250s \303\240 pr\303\251sent, poursuivre les d\303\251marches en ligne pour les inscriptions qui vous concernent.</p>\012    <p>#{RQ_OBSERV}</p>' where id = 34333;
update request_form set template_name = 'demande_d_information' where id = 34334;
update request_form set template_name = 'dossier_deja_traite' where id = 34337;

-- hmr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 34335;
update request_form set template_name = 'demande_d_information' where id = 34336;

-- ddr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 34339;
update request_form set template_name = 'demande_d_information' where id = 34338;

-- bdr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 34341;
update request_form set template_name = 'demande_d_information' where id = 34347;

-- mdr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 34340;
update request_form set template_name = 'demande_d_information' where id = 34346;

-- acr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 34344;
update request_form set template_name = 'demande_d_information' where id = 34350;
update request_form set template_name = 'dossier_deja_traite' where id = 34354;

-- scr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation' where id = 34345;
update request_form set template_name = 'demande_d_information' where id = 34351;
update request_form set template_name = 'dossier_deja_traite' where id = 34355;

-- scrr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation',  personalized_data = '<p>Madame, Monsieur,</p>\012    <p>Nous avons le plaisir de vous confirmer l\342\200\231 #{RQ_TP_LABEL} du #{RQ_CDATE} de votre enfant #{SU_FNAME} #{SU_LNAME}.</p>\012    <p>#{RQ_OBSERV}</p>' where id = 34342;
update request_form set template_name = 'demande_d_information' where id = 34348;
update request_form set template_name = 'dossier_deja_traite' where id = 34352;

-- parr - Attestation / Demande d'info / Dossier déjà traité
update request_form set template_name = 'attestation',  personalized_data = '<p>Madame, Monsieur,</p>\012    <p>Nous avons le plaisir de vous confirmer l\342\200\231 #{RQ_TP_LABEL} du #{RQ_CDATE} de votre enfant #{SU_FNAME} #{SU_LNAME}.</p>\012    <p>#{RQ_OBSERV}</p>' where id = 34343;
update request_form set template_name = 'demande_d_information' where id = 34349;
update request_form set template_name = 'dossier_deja_traite' where id = 34353;

