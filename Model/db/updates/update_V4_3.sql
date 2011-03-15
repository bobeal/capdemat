alter table document_binary add column content_type varchar(255);
alter table document_binary add column preview bytea;

alter table agent add column email varchar(255);

alter table address add column street_matriculation varchar(8);
alter table address add column street_rivoli_code varchar(10);
alter table address add column city_insee_code varchar(5);
alter table local_authority add column token varchar(32);

-- Start MPG Fusion

alter table external_service_individual_mapping drop constraint FK5BC5D7E648C97698;
alter table external_service_identifier_mapping rename to home_folder_mapping;
alter table external_service_individual_mapping rename to individual_mapping;

alter table individual_mapping add constraint FK19DDB92881C62393 foreign key (home_folder_mapping_id) references home_folder_mapping;
alter table individual_mapping rename column mapping_id to home_folder_mapping_id;
alter table individual_mapping add column home_folder_mapping_index int8;
alter table individual_mapping add column id int8 not null;
update individual_mapping set id = nextval('hibernate_sequence');

-- Add an int hibernate list index
CREATE FUNCTION init_hibernate_list_index(table_name text, foreign_id_col_name text, id_col_name text, index_col_name text) RETURNS void AS $$
 DECLARE
    current_index integer := 0;
    current_foreign_id integer := -1;
    current_rec record;
    select_cmd text := 'SELECT ' || quote_ident(id_col_name) || ' AS id, '
                       || quote_ident(foreign_id_col_name) || ' AS foreign_id'
                       || ' FROM ' || quote_ident(table_name)
                       || ' ORDER BY ' || quote_ident(foreign_id_col_name);
    update_cmd text ;
  BEGIN
    FOR current_rec IN EXECUTE select_cmd LOOP
      IF current_foreign_id <> current_rec.foreign_id THEN
        current_foreign_id := current_rec.foreign_id;
        current_index := 0;
      ELSE
        current_index := current_index + 1;
      END IF;

      update_cmd := 'UPDATE ' || quote_ident(table_name)
                    || ' SET ' || quote_ident(index_col_name) || ' = ' || current_index
                    || ' WHERE ' || quote_ident(id_col_name) || ' = ' || current_rec.id;
      EXECUTE update_cmd;

    END LOOP;
    RETURN;
  END;
$$ LANGUAGE plpgsql;
select init_hibernate_list_index('individual_mapping', 'home_folder_mapping_id', 'id', 'home_folder_mapping_index');
drop function init_hibernate_list_index(text,text,text,text);

create table external_application (
    id int8 not null,
    label varchar(255),
    description varchar(255),
    primary key (id)
);

create table external_application_broker (
    external_application_id int8 not null,
    broker varchar(255)
);

create table external_home_folder (
    id int8 not null,
    mapping_state varchar(255) not null,
    external_id varchar(255),
    external_application_id int8,
    address varchar(255),
    external_home_application_index int4,
    primary key (id)
);

create table external_individual (
    id int8 not null,
    first_name varchar(255),
    external_id varchar(255),
    last_name varchar(255),
    responsible bool,
    external_home_folder_id int8,
    external_home_folder_index int4,
    primary key (id)
);

alter table external_application_broker add constraint FK839CD69C2C94FF5A foreign key (external_application_id) references external_application;
alter table external_home_folder add constraint FKA9D7255A2C94FF5A foreign key (external_application_id) references external_application;
alter table external_individual add constraint FKC1D4D78DF1C1B621 foreign key (external_home_folder_id) references external_home_folder;

create table external_deposit_account_item_detail (
    id int8 not null,
    date timestamp,
    holder_name varchar(255),
    holder_surname varchar(255),
    payment_id varchar(255),
    payment_type varchar(255),
    value int4,
    bank_reference varchar(255),
    external_deposit_account_item_id int8 not null,
    primary key (id)
);

create table external_invoice_item_detail (
    id int8 not null,
    subject_name varchar(255),
    label varchar(255),
    quatity numeric(19, 2),
    subject_surname varchar(255),
    unit_price int4,
    value int4,
    external_invoice_item_id int8 not null,
    primary key (id)
);

alter table external_deposit_account_item_detail add constraint FK4A90965670F56907 foreign key (external_deposit_account_item_id) references purchase_item;
alter table external_invoice_item_detail add constraint FKFB8FF2772062B3BC foreign key (external_invoice_item_id) references purchase_item;


alter table purchase_item add column external_application_id varchar(255);
alter table purchase_item add column external_home_folder_id varchar(255);
alter table purchase_item add column external_individual_id varchar(255);
alter table purchase_item add column supported_broker varchar(255);
alter table purchase_item add column is_paid bool;
update purchase_item SET is_paid = false where item_type='EXTERNAL_INVOICE_ITEM';
alter table purchase_item add column payment_date timestamp;

alter table external_service_traces rename to request_external_action;
alter table request_external_action drop constraint external_service_traces_pkey;
alter table request_external_action add constraint request_external_action_pkey primary key (id);

-- End MPG Fusion

-- Start PESSAC contributions by Zenexity

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

ALTER TABLE child ADD column child_born bool;
UPDATE child set child_born = true;

-- End PESSAC contributions by Zenexity

ALTER TABLE library_registration_request ADD COLUMN adult_content_authorization bool;

ALTER TABLE school_canteen_registration_request ADD COLUMN which_food_allergy varchar(255);
