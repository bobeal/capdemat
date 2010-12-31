create table learning_activities_discovery_registration_request (
    id int8 not null,
    primary key (id)
);

create table learning_activities_discovery_registration_request_atelier_eveil (
    learning_activities_discovery_registration_request_id int8 not null,
    atelier_eveil_id int8 not null,
    atelier_eveil_index int4 not null,
    primary key (learning_activities_discovery_registration_request_id, atelier_eveil_index)
);

alter table learning_activities_discovery_registration_request_atelier_eveil 
    add constraint FK6631159E51ABD2B5 
    foreign key (learning_activities_discovery_registration_request_id) 
    references learning_activities_discovery_registration_request;

alter table learning_activities_discovery_registration_request_atelier_eveil 
    add constraint FK6631159E9AA8EC9F 
    foreign key (atelier_eveil_id) 
    references local_referential_data;

create table home_emergency_registration_request (
    id int8 not null,
    telephone varchar(10),
    date_depart timestamp,
    duree varchar(2),
    primary key (id)
);

create table day_care_center_registration_request (
    id int8 not null,
    est_horaires_reguliers_mere bool,
    est_horaires_reguliers_pere bool,
    profession_pere varchar(255),
    horaire_placement_matin_debut_jeudi bytea,
    horaires_travail_vendredi_pere varchar(255),
    horaires_reguliers_pere varchar(255),
    horaires_travail_mercredi_mere varchar(255),
    situation_actuelle_pere varchar(255),
    plage_horaire_contact varchar(255),
    horaires_travail_lundi_mere varchar(255),
    horaire_placement_matin_fin bytea,
    horaire_placement_apres_midi_debut_mercredi bytea,
    horaires_travail_vendredi_mere varchar(255),
    precision_autre_situation_actuelle_mere varchar(255),
    horaire_placement_apres_midi_debut_vendredi bytea,
    horaire_placement_matin_debut_mercredi bytea,
    horaire_placement_matin_fin_jeudi bytea,
    precision_autre_situation_actuelle_pere varchar(255),
    date_placement_fin timestamp,
    horaire_placement_apres_midi_fin_jeudi bytea,
    horaire_placement_apres_midi_fin_vendredi bytea,
    mode_accueil_choix_deux varchar(255),
    horaires_travail_mardi_pere varchar(255),
    choix_horaires_accueil varchar(255),
    horaire_placement_matin_debut bytea,
    commune_lieu_travail_pere varchar(255),
    horaire_placement_matin_debut_lundi bytea,
    choix_type_date_placement_accueil_regulier varchar(255),
    mode_accueil bool,
    horaires_reguliers_mere varchar(255),
    horaire_placement_apres_midi_fin_mardi bytea,
    horaire_placement_apres_midi_fin_lundi bytea,
    horaire_placement_matin_fin_lundi bytea,
    choix_type_rendez_vous varchar(255),
    dix_huit_mois_enfant timestamp,
    situation_actuelle_mere varchar(255),
    horaire_placement_matin_fin_vendredi bytea,
    date_placement_debut timestamp,
    horaire_placement_matin_debut_vendredi bytea,
    horaire_placement_apres_midi_debut_lundi bytea,
    horaires_travail_mercredi_pere varchar(255),
    horaire_placement_apres_midi_debut_mardi bytea,
    horaires_travail_lundi_pere varchar(255),
    horaire_placement_apres_midi_fin bytea,
    commune_lieu_travail_mere varchar(255),
    horaires_travail_jeudi_pere varchar(255),
    horaires_travail_jeudi_mere varchar(255),
    telephone_contact varchar(10),
    horaires_travail_mardi_mere varchar(255),
    accueil_anterieur varchar(255),
    horaire_placement_apres_midi_fin_mercredi bytea,
    horaire_placement_matin_debut_mardi bytea,
    horaire_placement_matin_fin_mercredi bytea,
    horaire_placement_matin_fin_mardi bytea,
    horaire_placement_apres_midi_debut_jeudi bytea,
    profession_mere varchar(255),
    mode_accueil_choix_un varchar(255),
    commentaire_citoyen varchar(600),
    horaire_placement_apres_midi_debut bytea,
    primary key (id)
);
