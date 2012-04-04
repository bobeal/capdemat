-- TS Saintouen Inscription Scolaire Globale : création
create table saintouen_inscription_scolaire_globale_request (
    id int8 not null,
    est_allergique bool,
    est_handicape_invalidant bool,
    accueil_matin bool,
    accueil_mercredi_et_vacances bool,
    accueil_soir bool,
    id_ecole_secteur varchar(255),
    label_ecole_secteur varchar(255),
    est_restauration bool,
    etudes_surveillees bool,
    reglement_interieur bool,
    mode_reglement varchar(255),
    primary key (id)
);

-- mise à jour du 11 avril 2012
alter table saintouen_inscription_scolaire_globale_request drop column mode_reglement;

create table saintouen_inscription_scolaire_globale_request_mode_reglement (
    saintouen_inscription_scolaire_globale_request_id int8 not null,
    mode_reglement_id int8 not null,
    mode_reglement_index int4 not null,
    primary key (saintouen_inscription_scolaire_globale_request_id, mode_reglement_index)
);

alter table saintouen_inscription_scolaire_globale_request_mode_reglement 
    add constraint FKF3C59C1D4F54D979 
    foreign key (saintouen_inscription_scolaire_globale_request_id) 
    references saintouen_inscription_scolaire_globale_request;

alter table saintouen_inscription_scolaire_globale_request_mode_reglement 
    add constraint FKF3C59C1D5B36E4 
    foreign key (mode_reglement_id) 
    references local_referential_data;

-- maj du ??/04/2012
alter table saintouen_inscription_scolaire_globale_request add column id_ecole_secteur varchar(255);
alter table saintouen_inscription_scolaire_globale_request add column label_ecole_secteur varchar(255);

-- TS Saintouen Day Care Center Registration : création
create table saintouen_day_care_center_registration_request (
    id int8 not null,
    choix_horaires_accueil varchar(255),
    choix_type_date_placement_accueil_regulier varchar(255),
    choix_type_rendez_vous varchar(255),
    commentaire_citoyen varchar(600),
    commune_lieu_travail_mere varchar(255),
    commune_lieu_travail_pere varchar(255),
    date_placement_debut timestamp,
    date_placement_fin timestamp,
    dix_huit_mois_enfant timestamp,
    employeur_mere varchar(255),
    employeur_pere varchar(255),
    est_horaires_reguliers_mere bool,
    est_horaires_reguliers_pere bool,
    horaire_placement_apres_midi_debut bytea,
    horaire_placement_apres_midi_debut_jeudi bytea,
    horaire_placement_apres_midi_debut_lundi bytea,
    horaire_placement_apres_midi_debut_mardi bytea,
    horaire_placement_apres_midi_debut_mercredi bytea,
    horaire_placement_apres_midi_debut_vendredi bytea,
    horaire_placement_apres_midi_fin bytea,
    horaire_placement_apres_midi_fin_jeudi bytea,
    horaire_placement_apres_midi_fin_lundi bytea,
    horaire_placement_apres_midi_fin_mardi bytea,
    horaire_placement_apres_midi_fin_mercredi bytea,
    horaire_placement_apres_midi_fin_vendredi bytea,
    horaire_placement_matin_debut bytea,
    horaire_placement_matin_debut_jeudi bytea,
    horaire_placement_matin_debut_lundi bytea,
    horaire_placement_matin_debut_mardi bytea,
    horaire_placement_matin_debut_mercredi bytea,
    horaire_placement_matin_debut_vendredi bytea,
    horaire_placement_matin_fin bytea,
    horaire_placement_matin_fin_jeudi bytea,
    horaire_placement_matin_fin_lundi bytea,
    horaire_placement_matin_fin_mardi bytea,
    horaire_placement_matin_fin_mercredi bytea,
    horaire_placement_matin_fin_vendredi bytea,
    horaires_reguliers_mere varchar(255),
    horaires_reguliers_pere varchar(255),
    horaires_travail_jeudi_mere varchar(255),
    horaires_travail_jeudi_pere varchar(255),
    horaires_travail_lundi_mere varchar(255),
    horaires_travail_lundi_pere varchar(255),
    horaires_travail_mardi_mere varchar(255),
    horaires_travail_mardi_pere varchar(255),
    horaires_travail_mercredi_mere varchar(255),
    horaires_travail_mercredi_pere varchar(255),
    horaires_travail_vendredi_mere varchar(255),
    horaires_travail_vendredi_pere varchar(255),
    precision_autre_situation_actuelle_mere varchar(255),
    precision_autre_situation_actuelle_pere varchar(255),
    profession_mere varchar(255),
    profession_pere varchar(255),
    situation_actuelle_mere varchar(255),
    situation_actuelle_pere varchar(255),
    telephone_contact varchar(10),
    primary key (id)
);

create table saintouen_day_care_center_registration_request_plage_horaire_contact (
    saintouen_day_care_center_registration_request_id int8 not null,
    plage_horaire_contact_id int8 not null,
    plage_horaire_contact_index int4 not null,
    primary key (saintouen_day_care_center_registration_request_id, plage_horaire_contact_index)
);

alter table saintouen_day_care_center_registration_request_plage_horaire_contact 
    add constraint FK2FBFAD43B83A0C68 
    foreign key (plage_horaire_contact_id) 
    references local_referential_data;

alter table saintouen_day_care_center_registration_request_plage_horaire_contact 
    add constraint FK2FBFAD434A067126 
    foreign key (saintouen_day_care_center_registration_request_id) 
    references saintouen_day_care_center_registration_request;

-- TS Saintouen Cap Jeunesse Enfant : création
create table saintouen_cap_jeunesse_enfant_request (
    id int8 not null,
    acceptation_reglement bool,
    autorisation_image bool,
    autorisation_medicale bool,
    email varchar(255),
    etablissement_scolaire_autre varchar(255),
    etablissement_scolaire_autre_nom varchar(255),
    signature_adolescent varchar(255),
    signature_elu varchar(255),
    signature_responsable_legal varchar(255),
    telephone_portable varchar(10),
    type_etablissement_scolaire_frenquente varchar(255),
    type_inscription varchar(255),
    etablissement_scolaire_autre_adresse_id int8,
    primary key (id)
);

create table saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_college (
    saintouen_cap_jeunesse_enfant_request_id int8 not null,
    etablissement_scolaire_college_id int8 not null,
    etablissement_scolaire_college_index int4 not null,
    primary key (saintouen_cap_jeunesse_enfant_request_id, etablissement_scolaire_college_index)
);

create table saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_lycee (
    saintouen_cap_jeunesse_enfant_request_id int8 not null,
    etablissement_scolaire_lycee_id int8 not null,
    etablissement_scolaire_lycee_index int4 not null,
    primary key (saintouen_cap_jeunesse_enfant_request_id, etablissement_scolaire_lycee_index)
);

create table saintouen_cap_jeunesse_enfant_request_secteur_habitation (
    saintouen_cap_jeunesse_enfant_request_id int8 not null,
    secteur_habitation_id int8 not null,
    secteur_habitation_index int4 not null,
    primary key (saintouen_cap_jeunesse_enfant_request_id, secteur_habitation_index)
);

alter table saintouen_cap_jeunesse_enfant_request 
    add constraint FKAFD6B68948ED1E61 
    foreign key (etablissement_scolaire_autre_adresse_id) 
    references address;

alter table saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_college 
    add constraint FK5AF0DA3FC18B372A 
    foreign key (etablissement_scolaire_college_id) 
    references local_referential_data;

alter table saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_college 
    add constraint FK5AF0DA3F9F7CE201 
    foreign key (saintouen_cap_jeunesse_enfant_request_id) 
    references saintouen_cap_jeunesse_enfant_request;

alter table saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_lycee 
    add constraint FK7659EE3E7C30C44B 
    foreign key (etablissement_scolaire_lycee_id) 
    references local_referential_data;

alter table saintouen_cap_jeunesse_enfant_request_etablissement_scolaire_lycee 
    add constraint FK7659EE3E9F7CE201 
    foreign key (saintouen_cap_jeunesse_enfant_request_id) 
    references saintouen_cap_jeunesse_enfant_request;

alter table saintouen_cap_jeunesse_enfant_request_secteur_habitation 
    add constraint FK84B07178F4FDC52 
    foreign key (secteur_habitation_id) 
    references local_referential_data;

alter table saintouen_cap_jeunesse_enfant_request_secteur_habitation 
    add constraint FK84B07179F7CE201 
    foreign key (saintouen_cap_jeunesse_enfant_request_id) 
    references saintouen_cap_jeunesse_enfant_request;

-- TS Saintouen Cap Jeunesse Adulte : création
create table saintouen_cap_jeunesse_adulte_request (
    id int8 not null,
    acceptation_reglement bool,
    autorisation_image bool,
    autorisation_medicale bool,
    date_naissance timestamp,
    etudiant_type_etablissement varchar(255),
    nom_etablissement_scolaire_autre varchar(255),
    participe_activite bool,
    precision_activite varchar(255),
    precision_etablissement_scolaire_autre varchar(255),
    profession varchar(255),
    sexe varchar(255),
    signature_adolescent varchar(255),
    signature_elu varchar(255),
    situation_actuelle varchar(255),
    type_activite varchar(255),
    type_inscription varchar(255),
    adresse_etablissement_scolaire_autre_id int8,
    primary key (id)
);

create table saintouen_cap_jeunesse_adulte_request_secteur_habitation (
    saintouen_cap_jeunesse_adulte_request_id int8 not null,
    secteur_habitation_id int8 not null,
    secteur_habitation_index int4 not null,
    primary key (saintouen_cap_jeunesse_adulte_request_id, secteur_habitation_index)
);

alter table saintouen_cap_jeunesse_adulte_request 
    add constraint FKBA33D38A704B3F41 
    foreign key (adresse_etablissement_scolaire_autre_id) 
    references address;

alter table saintouen_cap_jeunesse_adulte_request_secteur_habitation 
    add constraint FKDBB8A076B2E150BF 
    foreign key (saintouen_cap_jeunesse_adulte_request_id) 
    references saintouen_cap_jeunesse_adulte_request;

alter table saintouen_cap_jeunesse_adulte_request_secteur_habitation 
    add constraint FKDBB8A0768F4FDC52 
    foreign key (secteur_habitation_id) 
    references local_referential_data;

-- Ts Saintouen Communal Studies Scholarship
create table saintouen_communal_studies_scholarship_request (
    id int8 not null,
    account_holder_birth_date timestamp,
    account_holder_first_name varchar(38),
    account_holder_last_name varchar(38),
    account_holder_title varchar(255),
    is_other_situation varchar(255),
    is_subject_account_holder bool,
    montant_bourse varchar(255),
    saint_ouen_current_studies_level varchar(255),
    saint_ouen_establishment_label varchar(255),
    saint_ouen_is_in_other_studies varchar(255),
    saint_ouen_other_situation_details varchar(255),
    saint_ouen_other_studies_label varchar(255),
    subject_birth_date timestamp,
    subject_domiciliation_date timestamp,
    bank_account_id int8,
    primary key (id)
);

alter table saintouen_communal_studies_scholarship_request
    add constraint FK67AF029AA4AB2F89
    foreign key (bank_account_id)
    references bank_account;
