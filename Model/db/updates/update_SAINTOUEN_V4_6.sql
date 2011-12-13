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

