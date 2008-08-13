alter table personal_details_request rename column precision to requester_quality_precision;
alter table personal_details_request rename column quality to requester_quality;

alter table birth_details_request rename column precision to requester_quality_precision;
alter table birth_details_request rename column quality to requester_quality;

alter table death_details_request rename column precision to requester_quality_precision;
alter table death_details_request rename column quality to requester_quality;

alter table marriage_details_request rename column precision to requester_quality_precision;
alter table marriage_details_request rename column quality to requester_quality;

-- update for request form types
update request_form set type = 'Request Certificate';

-- update for request actions labels
update request_action set label = 'CREATION_ACTION' where label = 'Creation';
update request_action set label = 'STATE_CHANGE_ACTION' where label = 'State\'s change';
-- some historic (?) requests actions have no label
update request_action set label = 'CREATION_ACTION' where label = '';

-- reset red and orange alerts for CTs that don't want them
-- UPDATE request set orange_alert = null;
-- UPDATE request set red_alert = null;

-- update for document actions labels
update document_action set label = 'CREATION_ACTION' where label = 'Creation';
update document_action set label = 'STATE_CHANGE_ACTION' where label = 'State\'s change';

-- many emails by category
create table category_emails (
   category_id int8 not null,
   email varchar(255)
);
alter table category_emails owner to cvq95;
alter table category_emails add constraint FKB9136EB85BA8ABFC foreign key (category_id) references category;

-- migrate existing emails to the new table
-- insert into category_emails (category_id, emails) select id, email from category where email != '';
alter table category rename column email to primary_email;

-- remove useless migration functions
DROP FUNCTION migrate_food_diet(boolean, boolean, boolean, boolean, boolean);
DROP FUNCTION migrate_canteen_attending_days(boolean, boolean, boolean, boolean, boolean);
DROP FUNCTION initialize_request_creation_notification();
