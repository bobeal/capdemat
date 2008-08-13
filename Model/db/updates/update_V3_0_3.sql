alter table sewer_connection_request add column more_than_two_years boolean;

create table library_registration_request (
   id int8 not null,
   registration_number varchar(255),
   rules_and_regulations_acceptance bool,
   subject_id int8,
   subscription_price int2,
   parental_authorization bool,
   subscription_type varchar(255),
   primary key (id)
);

alter table library_registration_request add constraint FKEA37820DDDCEFD0E foreign key (subject_id) references individual;
alter table library_registration_request add constraint FKEA37820DD1B foreign key (id) references request;
alter table library_registration_request owner to cvq95;

insert into request_type (id, label, xml_config_file, active) values (nextval('hibernate_sequence'), 'Library Registration', NULL, false);
insert into request_form (id, type, xsl_fo_filename) values (nextval('hibernate_sequence'), 'Library Registration Request Certificat', 'libraryRegistrationRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Library Registration Request Certificat' and request_type.label = 'Library Registration';

-- ajout des nouveaux types de pièces justificatives
insert into document_type (id, name, type,  validity_duration_type,  validity_duration, usage_type) values (nextval('hibernate_sequence'), 'Individual Alignment Certificate', 23, 'Unlimited', 0, 'Reusable');
insert into document_type (id, name, type,  validity_duration_type,  validity_duration, usage_type) values (nextval('hibernate_sequence'), 'Building Situation Plan', 24, 'Unlimited', 0, 'Reusable');
insert into document_type (id, name, type,  validity_duration_type,  validity_duration, usage_type) values (nextval('hibernate_sequence'), 'Ground Situation Plan', 25, 'Unlimited', 0, 'Reusable');
insert into document_type (id, name, type,  validity_duration_type,  validity_duration, usage_type) values (nextval('hibernate_sequence'), 'Mass Plan', 26, 'Unlimited', 0, 'Reusable');

-- modifications on data types in XML Schema
alter table library_registration_request rename subscription_type to subscription;

alter table personal_details_request add column marriage_postal_code_temp varchar(2);
update personal_details_request set marriage_postal_code_temp = marriage_postal_code;
alter table personal_details_request drop column marriage_postal_code;
alter table personal_details_request rename column marriage_postal_code_temp to marriage_postal_code;

alter table personal_details_request add column birth_postal_code_temp varchar(2);
update personal_details_request set birth_postal_code_temp = birth_postal_code;
alter table personal_details_request drop column birth_postal_code;
alter table personal_details_request rename column birth_postal_code_temp to birth_postal_code;

alter table personal_details_request add column death_postal_code_temp varchar(2);
update personal_details_request set death_postal_code_temp = death_postal_code;
alter table personal_details_request drop column death_postal_code;
alter table personal_details_request rename column death_postal_code_temp to death_postal_code;

-- electoral roll registration requests can be made for a child
alter table electoral_roll_registration_request drop constraint FK45625529DDCEFD0E;
alter table electoral_roll_registration_request add constraint FK45625529DDCEFD0E foreign key (subject_id) references individual;
