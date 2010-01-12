delete from forms where request_type_id = 9;

delete from request_type where id = 9;

update local_authority set
    postal_code = '95280',
    display_title = 'Jouy-le-Moutier',
    server_names = null,
    instruction_alerts_enabled = 'false',
    instruction_alerts_detailed = 'false',
    instruction_default_max_delay = 10,
    instruction_default_alert_delay = 3;

update request_form set
    xsl_fo_filename = null,
    personalized_data = null
    where type = 'Request Mail Template';
