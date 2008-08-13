-- Subject generalization updates

alter table request add column subject_table_name varchar(255);
alter table request add column subject_id int8;

update request 
  set subject_table_name = 'fr.cg95.cvq.business.users.Individual', 
      subject_id = (select subject_id from music_school_registration_request where request.id = music_school_registration_request.id)
  where request.id in (select id from music_school_registration_request);

update request 
  set subject_table_name = 'fr.cg95.cvq.business.users.Individual', 
      subject_id = (select subject_id from library_registration_request where request.id = library_registration_request.id)
  where request.id in (select id from library_registration_request);

update request 
  set subject_table_name = 'fr.cg95.cvq.business.users.Individual', 
      subject_id = (select subject_id from electoral_roll_registration_request where request.id = electoral_roll_registration_request.id)
  where request.id in (select id from electoral_roll_registration_request);

update request
  set subject_table_name = 'fr.cg95.cvq.business.users.Adult'
  where subject_id in (select id from adult);

update request
  set subject_table_name = 'fr.cg95.cvq.business.users.Child'
  where subject_id in (select id from child);

update request 
  set subject_table_name = 'fr.cg95.cvq.business.users.Child', 
      subject_id = (select child_id from school_registration_request where request.id = school_registration_request.id)
  where request.id in (select id from school_registration_request);

update request 
  set subject_table_name = 'fr.cg95.cvq.business.users.Child', 
      subject_id = (select child_id from school_canteen_registration_request where request.id = school_canteen_registration_request.id)
  where request.id in (select id from school_canteen_registration_request);

update request 
  set subject_table_name = 'fr.cg95.cvq.business.users.Child',
      subject_id = (select child_id from perischool_activity_registration_request where request.id = perischool_activity_registration_request.id)
  where request.id in (select id from perischool_activity_registration_request);
  
update request 
  set subject_table_name = 'fr.cg95.cvq.business.users.Child', 
      subject_id = (select child_id from recreation_activity_registration_request where request.id = recreation_activity_registration_request.id)
  where request.id in (select id from recreation_activity_registration_request);

alter table library_registration_request drop constraint FKEA37820DDDCEFD0E;
alter table recreation_activity_registration_request drop constraint FKD1F8ECC62EA171E;
alter table music_school_registration_request drop constraint FK51A399DADDCEFD0E;
alter table electoral_roll_registration_request drop constraint FK45625529DDCEFD0E;
alter table perischool_activity_registration_request drop constraint FK76BAA59A62EA171E;
alter table school_canteen_registration_request drop constraint FKDC4CBC6962EA171E;
alter table school_registration_request drop constraint FK7BDFE8F462EA171E;

alter table music_school_registration_request drop column subject_id;
alter table library_registration_request drop column subject_id;
alter table electoral_roll_registration_request drop column subject_id;
alter table school_registration_request drop column child_id;
alter table school_canteen_registration_request drop column child_id;
alter table perischool_activity_registration_request drop column child_id;
alter table recreation_activity_registration_request drop column child_id;

-- Home folder updates

alter table home_folder add column enabled bool;
update home_folder set enabled = 'true';

-- Extended payment updates

alter table bill rename to payment;
alter table payment add column broker varchar(255);
alter table payment rename column reference to cvq_reference;
alter table payment rename column tx_identifier to bank_reference;
alter table payment drop column name;
alter table payment add column initialization_date timestamp;
alter table payment rename column creation_date to commit_date;
alter table payment rename column value to amount;
alter table payment add column state varchar(15);
update payment set state = 'Validated';
update payment set initialization_date = commit_date where initialization_date is null;

alter table payment add column requester_id int8;
update payment set requester_id = adult.id from adult, individual 
						where adult.id = individual.id
	and (adult.home_folder_roles = 1 or adult.home_folder_roles = 3)
	and individual.home_folder_id = payment.home_folder_id;
alter table payment alter column requester_id set not null;

create table purchase_item (
   id int8 not null,
   item_type varchar(64) not null,
   label varchar(255),
   amount float8,
   request_id int8,
   payment_id int8,
   external_item_id varchar(255),
   external_service_label varchar(255),
   issue_date timestamp,
   old_value float8,
   old_value_date timestamp,
   creation_date timestamp,
   max_buy int4,
   min_buy int4,
   quantity int4,
   old_quantity int4,
   subject_id int8,
   unit_price float8,
   reference varchar(255),
   primary key (id)
);
alter table purchase_item add constraint FKB113279123640CB foreign key (request_id) references request;
alter table purchase_item add constraint FKB11327916022B9F4 foreign key (payment_id) references payment;
alter table purchase_item owner to cvq95;


-- create internal request purchase items from existing payments
CREATE OR REPLACE FUNCTION create_iri_items() RETURNS void AS $$
DECLARE
  myrec RECORD;
  purchase_item_id integer;
BEGIN
  FOR myrec IN SELECT payment.amount AS pamount, payment.id AS pid, place_reservation_request.id AS prrid 
  				FROM payment, place_reservation_request 
  				WHERE payment.bank_reference = place_reservation_request.payment_reference LOOP
    purchase_item_id := nextval('hibernate_sequence');
    INSERT INTO purchase_item (id, item_type, label, amount, request_id, payment_id, quantity, unit_price) 
    	VALUES ( purchase_item_id, 'INTERNAL_REQUEST_ITEM', 'Billetterie', myrec.pamount, myrec.prrid, 
    			myrec.pid, 1, myrec.pamount);
  END LOOP;
  RETURN;   
END;
$$ LANGUAGE plpgsql;

select create_iri_items();
drop function create_iri_items();

alter table payment add constraint FKD11C32064E01D8BE foreign key (requester_id) references adult;
alter table payment add constraint FKD11C3206F8797B2C foreign key (home_folder_id) references home_folder;

-- TODO :
--  Manual broker's initialization

-- Family quotient updates
alter table home_folder add column family_quotient varchar(255);

-- HoraNet extensions for Poitiers
alter table purchase_item add column expiration_date timestamp;

-- Requests seasons updates
create table seasons (
   request_type_id int8 not null,
   effect_end timestamp,
   effect_start timestamp,
   label varchar(255),
   registration_end timestamp,
   registration_start timestamp,
   validation_authorization_start timestamp
);
alter table seasons add constraint FK7552F1F0F02D7A90 foreign key (request_type_id) references request_type;
alter table seasons owner to cvq95;

alter table request_type add column authorize_multiple_registrations_per_season bool;

-- Bug fix : there were still some non-normalized request action labels (from VoCardRequestService)
update request_action set label = 'CREATION_ACTION' where label = 'Creation';

-- Other requests seasons updates
alter table request_type add column has_automatic_activation bool;
alter table request_type add column is_of_registration_kind bool;
alter table seasons add column uuid varchar(255);
alter table request add column season_uuid varchar(255);

-- Initialize some values related to requests seasons update
update request_type set is_of_registration_kind = 'true' where label like '%Registration';
update request_type set has_automatic_activation = 'true' where label like '%Registration';
update request_type set authorize_multiple_registrations_per_season = 'false';

alter table request_type drop column is_of_registration_kind;

-- Extended payment updates
alter table payment add column commit_alert bool;

-- Remove obsolete information in registrations requests (due to introduction of seasons)
alter table vacations_registration_request drop column start_date;
alter table vacations_registration_request drop column end_date;

alter table recreation_activity_registration_request drop column start_date;
alter table recreation_activity_registration_request drop column end_date;

alter table music_school_registration_request drop column start_date;
alter table music_school_registration_request drop column end_date;

alter table perischool_activity_registration_request drop column start_date;
alter table perischool_activity_registration_request drop column end_date;

alter table school_canteen_registration_request drop column start_date;
alter table school_canteen_registration_request drop column end_date;

alter table school_registration_request drop column start_date;
alter table school_registration_request drop column end_date;

update request_form set xsl_fo_filename = 'homeFolderModificationRequest.xsl' 
	where id = (select forms.request_form_id from forms, request_type
					where forms.request_type_id = request_type.id
					and request_type.label = 'Home Folder Modification');

update payment set commit_alert = false;

update adult set family_status = 'Other' where family_status = 'Unknown';
update adult set family_status = 'Other' where family_status is null;

-- bug fixes related to the 3.1.7 
-- also reported on update script for 3.1.8
update local_referential_data set name = 'Unknown' where name = '';
alter table local_referential_data alter column name set not null;

