create table electoral_roll_registration_request (
   id int8 not null,
   subject_address_outside_city_id int8,
   polling_school_name varchar(255),
   subject_id int8,
   subject_old_city varchar(32),
   motive varchar(255),
   electoral_number int8,
   subject_nationality varchar(255),
   polling_station int8,
   primary key (id)
);

alter table electoral_roll_registration_request add constraint FK45625529D1B foreign key (id) references request;
alter table electoral_roll_registration_request add constraint FK45625529DDCEFD0E foreign key (subject_id) references adult;
alter table electoral_roll_registration_request add constraint FK4562552988B16377 foreign key (subject_address_outside_city_id) references adress;
alter table electoral_roll_registration_request owner to cvq95;

insert into request_type (id, label, xml_config_file, active) values (nextval('hibernate_sequence'), 'Electoral Roll Registration', NULL, false);
insert into request_form (id, type, xsl_fo_filename) values (nextval('hibernate_sequence'), 'Electoral Roll Registration Request Certificat', 'electoralRollRegistrationRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Electoral Roll Registration Request Certificat' and request_type.label = 'Electoral Roll Registration';

create table alignment_certificate_request (
   id int8 not null,
   owner_address_id int8,
   owner_last_name varchar(38),
   owner_first_names varchar(255),
   section varchar(255),
   transportation_route varchar(255),
   locality varchar(255),
   number bytea,
   requester_quality varchar(255),
   primary key (id)
);

alter table alignment_certificate_request add constraint FK9EBFB38BD1B foreign key (id) references request;
alter table alignment_certificate_request add constraint FK9EBFB38BB824A652 foreign key (owner_address_id) references adress;
alter table alignment_certificate_request owner to cvq95;

insert into request_type (id, label, xml_config_file, active) values (nextval('hibernate_sequence'), 'Alignment Certificate', NULL, false);
insert into request_form (id, type, xsl_fo_filename) values (nextval('hibernate_sequence'), 'Alignment Certificate Request Certificat', 'alignmentCertificateRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Alignment Certificate Request Certificat' and request_type.label = 'Alignment Certificate';

create table sewer_connection_request (
   id int8 not null,
   owner_address_id int8,
   section varchar(255),
   transportation_route varchar(255),
   locality varchar(255),
   owner_last_name varchar(38),
   number bytea,
   owner_first_names varchar(255),
   requester_quality varchar(255),
   primary key (id)
);

-- alter table sewer_connection_request add column more_than_two_years boolean;
alter table sewer_connection_request add constraint FK50B057BBD1B foreign key (id) references request;
alter table sewer_connection_request add constraint FK50B057BBB824A652 foreign key (owner_address_id) references adress;
alter table sewer_connection_request owner to cvq95;

insert into request_type (id, label, xml_config_file, active) values (nextval('hibernate_sequence'), 'Sewer Connection', NULL, false);
insert into request_form (id, type, xsl_fo_filename) values (nextval('hibernate_sequence'), 'Sewer Connection Request Certificat', 'sewerConnectionRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Sewer Connection Request Certificat' and request_type.label = 'Sewer Connection';

