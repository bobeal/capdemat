update local_authority set postal_code = '95510', display_title = 'Vétheuil', 
    instruction_alerts_enabled = 'false', instruction_alerts_detailed = 'true',
    instruction_default_max_delay = 10, instruction_default_alert_delay = 3;

update request_form set xsl_fo_filename = null, personalized_data = null where type = 'Request Mail Template';

