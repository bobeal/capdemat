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

