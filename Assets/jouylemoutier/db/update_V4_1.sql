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

update request_form set
    xsl_fo_filename = null,
    template_name = 'Demande d\'informations',
    personalized_data = '<p>J\342\200\231ai bien re\303\247u votre lettre relative \303\240 une #{RQ_TP_LABEL}.</p>\012   <p>Afin de vous adresser cette pi\303\250ce, je vous remercie de bien vouloir fournir les \303\251l\303\251ments suivants :</p>\012   <p>#{RQ_OBSERV}</p>'
    where id in (18746, 18751, 18752, 18753, 18755);

update request_form set
    xsl_fo_filename = null,
    template_name = 'Attestation',
    personalized_data = '<p>En r\303\251ponse \303\240 votre demande du #{RQ_CDATE}, veuillez trouver sous ce pli, votre #{RQ_TP_LABEL}.</p>\012   <p>#{RQ_OBSERV}</p>'
    where id in (18748, 18749, 18750);

update request_form set
    xsl_fo_filename = null,
    template_name = 'Attestation création de compte',
    personalized_data = '<p>Votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} a \303\251t\303\251 trait\303\251e par nos services.</p>\012   <p>Vous recevrez dans les plus brefs d\303\251lais les \303\251l\303\251ments relatifs \303\240 celle-ci.</p>\012   <p>Nous restons \303\240 votre dispostion pour toute information compl\303\251mentaire qui vous serait utile.</p>\012   <p>#{RQ_OBSERV}</p>'
    where id = 18745;

update request_form set
    xsl_fo_filename = null,
    template_name = 'Dossier déjà traité',
    personalized_data = '<p>Votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} ne peut etre valid\303\251e, car une autre a \303\251t\303\251 pr\303\251c\303\251demment enregistr\303\251e par nos services.</p>\012   <p>#{RQ_OBSERV}</p>'
    where id in (18747, 18756);

update request_form set
    xsl_fo_filename = null,
    template_name = 'Attestation place de spectacle',
    personalized_data = '<p>Votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} a \303\251t\303\251 trait\303\251e par nos services.</p>\012   <p>Votre ou vos billet(s) est (sont) \303\240 retirer \303\240 l\'accueil du Th\303\251\303\242tre de Jouy aux heures d\'ouverture, sur pr\303\251sentation de ce courrier imprim\303\251 ou, le cas \303\251ch\303\251ant, du num\303\251ro de transaction.</p>\012   <p>#{RQ_OBSERV}</p>\012   <p>Nous restons \303\240 votre dispostion pour toute information compl\303\251mentaire qui vous serait utile.</p>'
    where id = 18754;
