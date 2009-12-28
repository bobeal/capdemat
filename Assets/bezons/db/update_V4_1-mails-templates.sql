update request_form set
    template_name = 'Attestation',
    personalized_data = '<p>Votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} est valid\303\251e.</p>\012    <p>#{RQ_OBSERV}</p>'
    where id in (40017, 40018, 40019, 40020);

update request_form set
    template_name = 'Attestation création de compte',
    personalized_data = '<p>Vous avez choisi de cr\303\251\303\251 un compte personnel sur le site de la ville de Bezons et nous vous remercions de votre confiance. Vous pourrez d\303\251sormais acc\303\251der aux services en ligne en vous connectant directement sur le portail des d\303\251marches en ligne de votre collectivit\303\251.</p>\012    <p>Conform\303\251ment \303\240 la loi \302\253 Informatique et Libert\303\251s \302\273 du 06/01/1978, vous disposez d\'un droit d\'acc\303\250s, de rectification et de suppression pour toutes les informations vous concernant. Vous pouvez exercer ce droit directement sur votre espace personnel ou en \303\251crivant directement \303\240 la Mairie.</p>\012    <p>#{RQ_OBSERV}</p>'
    where id = 40016;

update request_form set
    template_name = 'Demande d\'infos',
    personalized_data = '<p>Nous avons bien re\303\247u votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE}. Afin de compl\303\251ter votre dossier, pourriez vous nous faire parvenir les \303\251l\303\251ments suivants :</p>\012    <p>#{RQ_OBSERV}</p>'
    where id in (40021, 40024, 40025, 40028, 40029);

update request_form set
    template_name = 'Dossier déjà traité',
    personalized_data = '<p>Nous avons bien re\303\247u votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE}.</p>\012    <p>Cette demande ne peut etre valid\303\251e, car une autre a \303\251t\303\251 pr\303\251c\303\251demment enregistr\303\251e par nos services.</p>\012    <p>#{RQ_OBSERV}</p>'
    where id in (40022, 40023, 40026, 40027, 40030);
