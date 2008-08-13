update request_type set label = 'Home Folder Modification' where label = 'Home Folder Modification Request';

-- create generic tables for places reservation logic
create table place_reservation_data (
   id int8 not null,
   name varchar(255),
   primary key (id)
);
alter table place_reservation_data owner to cvq95;

create table ticket_type_selection (
   id int8 not null,
   name varchar(255),
   number int8,
   subscriber_number varchar(255),
   place_reservation_data_id int8,
   primary key (id)
);
alter table ticket_type_selection owner to cvq95;

-- create tables for place reservation request
create table place_reservation_request (
   id int8 not null,
   subscriber_number varchar(255),
   is_subscribed bool,
   primary key (id)
);
alter table place_reservation_request owner to cvq95;

create table place_reservation_request_place_reservation (
   place_reservation_request_id int8 not null,
   place_reservation_id int8 not null,
   primary key (place_reservation_request_id, place_reservation_id)
);
alter table place_reservation_request_place_reservation owner to cvq95;

insert into request_type (id, label, xml_config_file, active) values (nextval('hibernate_sequence'), 'Place Reservation', NULL, false);
insert into request_form (id, type, xsl_fo_filename) values (nextval('hibernate_sequence'), 'Place Reservation Request Certificat', 'placeReservationRequest.xsl');
insert into forms (request_form_id, request_type_id) select request_form.id, request_type.id from request_form, request_type where request_form.type = 'Place Reservation Request Certificat' and request_type.label = 'Place Reservation';
