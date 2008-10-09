-- External services enhancements

create table external_service_identifier_mapping (
    id int8 not null,
    external_service_label varchar(255),
    home_folder_id int8,
    external_capdemat_id varchar(255),
    external_id varchar(255),
    primary key (id)
);
alter table external_service_identifier_mapping owner to cvq95;

create table external_service_individual_mapping (
    mapping_id int8 not null,
    individual_id int8,
    external_capdemat_id varchar(255),
    external_id varchar(255)
);
alter table external_service_individual_mapping owner to cvq95;

alter table external_service_individual_mapping 
   add constraint FK5BC5D7E648C97698 foreign key (mapping_id) 
        references external_service_identifier_mapping;

-- Death details request fixes

alter table death_details_request drop column requester_quality_precision;
alter table death_details_request drop column requester_quality;
alter table death_details_request drop column relationship;
alter table death_details_request drop column father_last_name;
alter table death_details_request drop column mother_first_names;
alter table death_details_request drop column father_first_names;
alter table death_details_request drop column mother_maiden_name;
alter table death_details_request rename column usage to comment;
alter table death_details_request add column motive varchar(255);

alter table birth_details_request rename column usage to comment;
alter table birth_details_request add column motive varchar(255);
alter table birth_details_request drop column relationship;

alter table marriage_details_request rename column usage to comment;
alter table marriage_details_request add column motive varchar(255);


        
