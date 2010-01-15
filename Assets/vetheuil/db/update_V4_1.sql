update local_authority set postal_code = '95510', display_title = 'Vétheuil', 
    instruction_alerts_enabled = 'false', instruction_alerts_detailed = 'true',
    instruction_default_max_delay = 10, instruction_default_alert_delay = 3;

update request_form set xsl_fo_filename = null, personalized_data = null where type = 'Request Mail Template';

-- vcr - Validation / Demande d'info / Refus
update request_form set template_name = 'validation', personalized_data='<p>Je fais suite \303\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu\'elle a \303\251t\303\251 valid\303\251e.</p>\012    <p>Pour finaliser votre demande, je vous invite \303\240 venir en mairie avec les pi\303\250ces justificatives suivantes : livret de famille, carte d\'identit\303\251 et justificatif de domicile.</p>\012    <p>#{RQ_OBSERV}</p>' where id = 136;
update request_form set template_name = 'demande_d_information' where id = 137;
update request_form set template_name = 'refus' where id = 138;

-- hfmr - Validation / Demande d'info / Refus
update request_form set template_name = 'validation' where id = 139;
update request_form set template_name = 'demande_d_information' where id = 140;
update request_form set template_name = 'refus' where id = 141;

-- ddr - Validation / Demande d'info / Refus
update request_form set template_name = 'validation' where id = 142;
update request_form set template_name = 'demande_d_information' where id = 143;
update request_form set template_name = 'refus' where id = 144;

-- mdr - Validation / Demande d'info / Refus
update request_form set template_name = 'validation' where id = 145;
update request_form set template_name = 'demande_d_information' where id = 146;
update request_form set template_name = 'refus' where id = 146;

-- bdr - Validation / Demande d'info / Refus
update request_form set template_name = 'validation' where id = 148;
update request_form set template_name = 'demande_d_information' where id = 149;
update request_form set template_name = 'refus' where id = 150;

-- mcr - Validation / Demande d'info / Refus
update request_form set template_name = 'validation', personalized_data='<p>Je fais suite \303\240 votre #{RQ_TP_LABEL} du #{RQ_CDATE} pour vous informer qu\'elle a \303\251t\303\251 valid\303\251e.</p>\012    <p>Pour retirer l\'attestation, j\'invite la personne concern\303\251e \303\240 venir en mairie avec une pi\303\250ce d\'identit\303\251, dans un d\303\251lai de cinq jours ouvr\303\251s.</p>\012    <p>#{RQ_OBSERV}</p>' where id = 165;
update request_form set template_name = 'demande_d_information' where id = 164;
update request_form set template_name = 'refus' where id = 166;
