update local_authority set
    display_title = 'Louvres';

update request_form set
    xsl_fo_filename = null,
    personalized_data = null
    where type = 'Request Mail Template';
