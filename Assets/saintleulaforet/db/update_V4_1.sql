update local_authority set postal_code = '95320', display_title = 'Saint-Leu-la-Forêt', 
    instruction_alerts_enabled = 'false', instruction_alerts_detailed = 'false',
    instruction_default_max_delay = 10, instruction_default_alert_delay = 3;

update request_form set xsl_fo_filename = null, template_name = 'general', personalized_data = '' where type = 'Request Mail Template';

