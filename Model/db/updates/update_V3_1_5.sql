-- modifications related to bug fixes in home folder modification request
alter table history_entry add column object_id bigint;

update history_entry 
set object_id = (select adress_id from adress_history 
				 where adress_history.history_id = history_entry.id) 
where clazz = 'fr.cg95.cvq.business.users.Address';

update history_entry 
set object_id = (select individual_id from individual_history 
 				 where individual_history.history_id = history_entry.id) 
where clazz = 'fr.cg95.cvq.business.users.Adult'
or clazz = 'fr.cg95.cvq.business.users.Child';
 
update history_entry 
set object_id = (select child_legal_responsible_id from child_legal_responsible_history 
				 where child_legal_responsible_history.history_id = history_entry.id) 
where clazz = 'fr.cg95.cvq.business.users.ChildLegalResponsible';

update history_entry 
set object_id = (select home_folder_id from home_folder_history 
				 where home_folder_history.history_id = history_entry.id) 
where clazz = 'fr.cg95.cvq.business.users.HomeFolder';

alter table child_legal_responsible_history drop constraint FKF3B138624541108D;
alter table child_legal_responsible_history drop constraint FKF3B13862744A54A6;
alter table adress_history drop constraint FK71953CB34DB784;
alter table adress_history drop constraint FK71953CB744A54A6;
alter table individual_history drop constraint FK1F3184EE744A54A6;
alter table individual_history drop constraint FK1F3184EEE78E1C81;

drop table home_folder_history;
drop table child_legal_responsible_history;
drop table adress_history;
drop table individual_history;

-- new requests

create table birth_details_request (
   id int8 not null,
   birth_first_names varchar(255),
   copies bytea,
   mother_first_names varchar(255),
   birth_last_name varchar(38),
   relationship varchar(255),
   usage varchar(255),
   precision varchar(255),
   father_last_name varchar(38),
   quality varchar(255),
   birth_postal_code varchar(2),
   birth_city varchar(32),
   birth_date timestamp,
   mother_maiden_name varchar(38),
   father_first_names varchar(255),
   format varchar(255),
   primary key (id)
);
alter table birth_details_request owner to cvq95;

INSERT INTO request_type (id, label, xml_config_file, active) VALUES (nextval('hibernate_sequence'), 'Birth Details', NULL, false);
INSERT INTO request_form (id, type, xsl_fo_filename) VALUES (nextval('hibernate_sequence'), 'Birth Details Request Certificat', 'birthDetailsRequest.xsl');
INSERT INTO forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Birth Details Request Certificat' and request_type.label = 'Birth Details';

create table marriage_details_request (
   id int8 not null,
   copies bytea,
   mother_first_names varchar(255),
   marriage_city varchar(32),
   relationship varchar(255),
   marriage_postal_code varchar(2),
   usage varchar(255),
   precision varchar(255),
   father_last_name varchar(38),
   quality varchar(255),
   mother_maiden_name varchar(38),
   marriage_wife_first_names varchar(255),
   marriage_date timestamp,
   marriage_wife_last_name varchar(38),
   marriage_husband_last_name varchar(38),
   father_first_names varchar(255),
   marriage_husband_first_names varchar(255),
   format varchar(255),
   primary key (id)
);
alter table marriage_details_request owner to cvq95;

INSERT INTO request_type (id, label, xml_config_file, active) VALUES (nextval('hibernate_sequence'), 'Marriage Details', NULL, false);
INSERT INTO request_form (id, type, xsl_fo_filename) VALUES (nextval('hibernate_sequence'), 'Marriage Details Request Certificat', 'marriageDetailsRequest.xsl');
INSERT INTO forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Marriage Details Request Certificat' and request_type.label = 'Marriage Details';

create table death_details_request (
   id int8 not null,
   copies bytea,
   mother_first_names varchar(255),
   death_first_names varchar(255),
   relationship varchar(255),
   usage varchar(255),
   precision varchar(255),
   father_last_name varchar(38),
   quality varchar(255),
   death_date timestamp,
   death_city varchar(32),
   death_postal_code varchar(2),
   mother_maiden_name varchar(38),
   death_last_name varchar(38),
   father_first_names varchar(255),
   format varchar(255),
   primary key (id)
);
alter table death_details_request owner to cvq95;

INSERT INTO request_type (id, label, xml_config_file, active) VALUES (nextval('hibernate_sequence'), 'Death Details', NULL, false);
INSERT INTO request_form (id, type, xsl_fo_filename) VALUES (nextval('hibernate_sequence'), 'Death Details Request Certificat', 'deathDetailsRequest.xsl');
INSERT INTO forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Death Details Request Certificat' and request_type.label = 'Death Details';

create table recreation_activity_registration_request (
   id int8 not null,
   class_trip_permission bool,
   end_date timestamp,
   child_photo_exploitation_permission bool,
   rules_and_regulations_acceptance bool,
   urgency_phone varchar(10),
   child_id int8,
   start_date timestamp,
   recreation_center_id int8,
   hospitalization_permission bool,
   primary key (id)
);
alter table recreation_activity_registration_request owner to cvq95;

create table recreation_activity_registration_request_recreation_activity (
   recreation_activity_registration_request_id int8 not null,
   recreation_activity_id int8 not null,
   primary key (recreation_activity_registration_request_id, recreation_activity_id)
);
alter table recreation_activity_registration_request_recreation_activity owner to cvq95;

create table recreation_activity_registration_request_other_individual (
   recreation_activity_registration_request_id int8 not null,
   other_individual_id int8 not null,
   primary key (recreation_activity_registration_request_id, other_individual_id)
);
alter table recreation_activity_registration_request_other_individual owner to cvq95;

INSERT INTO request_type (id, label, xml_config_file, active) VALUES (nextval('hibernate_sequence'), 'Recreation Activity Registration', NULL, false);
INSERT INTO request_form (id, type, xsl_fo_filename) VALUES (nextval('hibernate_sequence'), 'Recreation Activity Registration Request Certificat', 'recreationActivityRegistrationRequest.xsl');
INSERT INTO forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Recreation Activity Registration Request Certificat' and request_type.label = 'Recreation Activity Registration';

alter table birth_details_request add constraint FKB3569612D1B foreign key (id) references request;
alter table recreation_activity_registration_request add constraint FKD1F8ECC41C46F58 foreign key (recreation_center_id) references recreation_center;
alter table recreation_activity_registration_request add constraint FKD1F8ECCD1B foreign key (id) references request;
alter table recreation_activity_registration_request add constraint FKD1F8ECC62EA171E foreign key (child_id) references child;
alter table death_details_request add constraint FK85B0A9C7D1B foreign key (id) references request;
alter table recreation_activity_registration_request_recreation_activity add constraint FK54117CA92B6BDF6E foreign key (recreation_activity_registration_request_id) references recreation_activity_registration_request;
alter table recreation_activity_registration_request_recreation_activity add constraint FK54117CA94814DD9E foreign key (recreation_activity_id) references local_referential_data;
alter table recreation_activity_registration_request_other_individual add constraint FK8026343B2B6BDF6E foreign key (recreation_activity_registration_request_id) references recreation_activity_registration_request;
alter table recreation_activity_registration_request_other_individual add constraint FK8026343BBF1AD192 foreign key (other_individual_id) references other_individual;
alter table marriage_details_request add constraint FK38315C1DD1B foreign key (id) references request;

-- update for subscribers management in place reservation requests
alter table place_reservation_request drop column is_subscribed;
alter table place_reservation_request add column authorized_number_of_places_per_reservation bytea;
alter table ticket_type_selection drop column subscriber_number;

-- added validation date for conformance to XML schema
alter table request add column validation_date timestamp without time zone;
