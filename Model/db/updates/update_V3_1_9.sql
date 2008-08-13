alter table perischool_activity_registration_request add column school_id int8;
alter table perischool_activity_registration_request add column section varchar(32);
alter table perischool_activity_registration_request add constraint FK76BAA59A812F1C6 foreign key (school_id) references school;

alter table place_reservation_request add column is_subscriber bool;
update place_reservation_request set is_subscriber = false;
update place_reservation_request set is_subscriber = true where subscriber_number is not null and subscriber_number != '';

