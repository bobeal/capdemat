update local_authority set
    display_title = 'Louvres';

update request_form set
    xsl_fo_filename = null,
    personalized_data = null
    where type = 'Request Mail Template';

update request_form set
    template_name = 'Demande d\'info',
    personalized_data = '<p>Nous avons bien re\303\247u votre demande #{RQ_TP_LABEL} du #{RQ_CDATE}.</p>\012    <p>Afin de compl\303\251ter votre dossier, pourriez vous nous faire parvenir les \303\251l\303\251ments suivants :</p>\012    <p>#{RQ_OBSERV}</p>'
    where id in (2758, 2759, 2760, 2761, 2762, 2763, 2764, 2765, 2772);

update request_form set
    template_name = 'Dossier déja traité',
    personalized_data = '<p>Nous avons bien re\303\247u votre demande #{RQ_TP_LABEL} du #{RQ_CDATE}.</p>\012    <p>Cette demande ne peut \303\252tre valid\303\251e, car une autre a \303\251t\303\251 pr\303\251c\303\251demment enregistr\303\251e par nos services.</p>'
    where id in (2766, 2767, 2768, 2769, 2770, 2773);

update request_form set
    template_name = 'Attestation',
    personalized_data = '<p>Votre demande de #{RQ_TP_LABEL} du #{RQ_CDATE} est valid\303\251e.</p>\012    <p>#{RQ_OBSERV}</p>'
    where id in (2751, 2752, 2753, 2754, 2755, 2757, 2771);

update request_form set
    template_name = 'Attestation école',
    personalized_data = '<p>Nous vous confirmons l\'#{RQ_TP_LABEL} du #{RQ_CDATE} de votre enfant #{SU_FNAME} #{SU_LNAME}.</p>\012    <p>#{RQ_OBSERV}</p>'
    where id = 2756;

update request_form set
    template_name = 'Attestation création de compte',
    personalized_data = '<p>Votre demande de cr\303\251ation de compte foyer du #{RQ_CDATE} est accept\303\251e.</p>\012    <p>Nous vous confirmons avoir valid\303\251 votre demande n\302\260#{RQ_ID} et, vous pouvez, de ce fait, vous connecter \303\240 nouveau pour vos d\303\251marches.</p>'
    where id = 2750;
