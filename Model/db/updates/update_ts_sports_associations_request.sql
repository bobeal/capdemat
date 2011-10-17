create table sagr_activite_association (
    id int8 not null,
    nom_activite varchar(255),
    nom_federation_sportive_activite varchar(255),
    nombre_licencie_majeur_activite int8,
    nombre_licencie_mineur_activite int8,
    numero_affiliation_activite varchar(255),
    somme_allouee_activite varchar(255),
    total_licencie_activite int8,
    sports_associations_grant_request_id int8,
    activite_association_index int4,
    primary key (id)
);

create table sagr_membre_bureau (
    id int8 not null,
    email_membre varchar(255),
    nom_membre varchar(38),
    prenom_membre varchar(38),
    role_membre varchar(255),
    telephone_membre varchar(10),
    sports_associations_grant_request_id int8,
    autre_membre_bureau_index int4,
    primary key (id)
);

create table sports_associations_grant_request (
    id int8 not null,
    cnds_annee_n varchar(255),
    cnds_annee_n_plus_un varchar(255),
    commune_annee_n varchar(255),
    commune_annee_n_plus_un varchar(255),
    email_club_ou_correspondant varchar(255),
    est_adresse_correspondant_principal bool,
    montant_subvention varchar(255),
    nom_association varchar(255),
    nom_complet_correspondant_principal varchar(255),
    numero_agrement_jeunesse_sport_association varchar(255),
    numero_enregistrement_association varchar(255),
    numero_enregistrement_prefecture_association varchar(9),
    numero_siret_association varchar(14),
    region_annee_n varchar(255),
    region_annee_n_plus_un varchar(255),
    role_demandeur varchar(255),
    subvention_sollicite_conseil_general varchar(255),
    adresse_correspondant_principal_id int8,
    compte_bancaire_id int8,
    siege_social_association_id int8,
    primary key (id)
);

alter table sagr_activite_association 
    add constraint FKDDAC2603CB99EC99 
    foreign key (sports_associations_grant_request_id) 
    references sports_associations_grant_request;

alter table sagr_membre_bureau 
    add constraint FK4697AB73CB99EC99 
    foreign key (sports_associations_grant_request_id) 
    references sports_associations_grant_request;

alter table sports_associations_grant_request 
    add constraint FKB93535BFC11E2C05 
    foreign key (compte_bancaire_id) 
    references bank_account;

alter table sports_associations_grant_request 
    add constraint FKB93535BF6AEB0ADF 
    foreign key (adresse_correspondant_principal_id) 
    references address;

alter table sports_associations_grant_request 
    add constraint FKB93535BFD370CB5 
    foreign key (siege_social_association_id) 
    references address;