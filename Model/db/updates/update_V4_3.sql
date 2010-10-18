alter table address add column street_matriculation varchar(8);
alter table address add column street_rivoli_code varchar(10);
alter table address add column city_insee_code varchar(5);
alter table local_authority add column token varchar(32);

-- MPG Fusion
alter table external_service_individual_mapping drop constraint FK5BC5D7E648C97698;

alter table external_service_identifier_mapping rename to home_folder_mapping;
alter table external_service_individual_mapping rename to individual_mapping;

alter table individual_mapping add constraint FK19DDB928D20F5682 foreign key (mapping_id) references home_folder_mapping;
