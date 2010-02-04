-- drop constraints on agent and rename constraint on category (refactoring)
alter table agent_category_roles drop constraint fkbafb98b6fb8d007d;
alter table agent_category_roles drop constraint fkbafb98b6ce4d7137;
alter table agent_category_roles add constraint FKBAFB98B63ED1C7EB foreign key (category_id) references category;

alter table agent_category_roles alter column category_id set not null;

-- rename constraints due to category refactoring
alter table category_emails drop constraint FKB9136EB8CE4D7137;
alter table category_emails add constraint FKB9136EB83ED1C7EB foreign key (category_id) references category;

alter table request_type drop constraint FK4DAE96EACE4D7137;
alter table request_type add constraint FK4DAE96EA3ED1C7EB foreign key (category_id) references category;

-- drop constraints on home folder and requester (payment decoupling)
alter table payment drop constraint FKD11C32061BC4A960;
alter table payment drop constraint FKD11C32068BD77771;
alter table payment add column requester_last_name varchar(38);
update payment set requester_last_name = (select last_name from individual where individual.id = payment.requester_id);
alter table payment alter column requester_last_name set not null;
alter table payment add column requester_first_name varchar(38);
update payment set requester_first_name = (select first_name from individual where individual.id = payment.requester_id);
alter table payment alter column requester_first_name set not null;

-- rename constraints on local_referential_data and place_reservation_data (refactoring)
alter table bulky_waste_collection_request_bulky_waste_type drop constraint FK7E2C4DCB9891C203;
alter table bulky_waste_collection_request_bulky_waste_type drop constraint fk7e2c4dcb617bc383;
alter table bulky_waste_collection_request_bulky_waste_type add constraint FK7E2C4DCB4C319B5C foreign key (bulky_waste_type_id) references local_referential_data;

alter table compostable_waste_collection_request_compostable_waste_type drop constraint FK765E424BC1F23BD7;
alter table compostable_waste_collection_request_compostable_waste_type drop constraint fk765e424b8adc3d57;
alter table compostable_waste_collection_request_compostable_waste_type add constraint FK765E424B75921530 foreign key (compostable_waste_type_id) references local_referential_data;

alter table library_registration_request_subscription drop constraint FK56C4BE0FE383A5FD;
alter table library_registration_request_subscription add constraint FK56C4BE0F97237F56 foreign key (subscription_id) references local_referential_data;

alter table local_referential_association drop constraint FK6B28F6775AC79CA3;
alter table local_referential_association add constraint FK6B28F677E6775FC foreign key (local_referential_child_data_id) references local_referential_data;

alter table local_referential_association drop constraint FK6B28F677DBACE805;
alter table local_referential_association add constraint FK6B28F6778F4CC15E foreign key (local_referential_parent_data_id) references local_referential_data;

alter table local_referential_data drop constraint FK49407E74DBACE805;
alter table local_referential_data add constraint FK49407E748F4CC15E foreign key (local_referential_parent_data_id) references local_referential_data;

alter table music_school_registration_request_activity drop constraint FK6393FFD4696ECB;
alter table music_school_registration_request_activity add constraint FK6393FFD4B4094824 foreign key (activity_id) references local_referential_data;

alter table perischool_activity_registration_request_perischool_activity drop constraint FK2007A4E9D633AA6C;
alter table perischool_activity_registration_request_perischool_activity add constraint FK2007A4E989D383C5 foreign key (perischool_activity_id) references local_referential_data;

alter table place_reservation_request_place_reservation drop constraint FK9493CEF96E5CE64D;
alter table place_reservation_request_place_reservation add constraint FK9493CEF921FCBFA6 foreign key (place_reservation_id) references place_reservation_data;

alter table recreation_activity_registration_request_recreation_activity drop constraint FK54117CA97F2ADC1E;
alter table recreation_activity_registration_request_recreation_activity add constraint FK54117CA932CAB577 foreign key (recreation_activity_id) references local_referential_data;

alter table school_canteen_registration_request_canteen_attending_days drop constraint FK1323D9F9AAB3F7;
alter table school_canteen_registration_request_canteen_attending_days add constraint FK1323D9F9B44A8D50 foreign key (canteen_attending_days_id) references local_referential_data;

alter table school_canteen_registration_request_food_diet drop constraint FK5768CADF9D0BE4E5;
alter table school_canteen_registration_request_food_diet add constraint FK5768CADF50ABBE3E foreign key (food_diet_id) references local_referential_data;

alter table sms_notification_request_interests drop constraint FKCE60DA2B756FB911;
alter table sms_notification_request_interests drop constraint fkce60da2b3e59ba91;
alter table sms_notification_request_interests add constraint FKCE60DA2B290F926A foreign key (interests_id) references local_referential_data;

alter table study_grant_request_current_school_name drop constraint FK49484F674E42238A;
alter table study_grant_request_current_school_name add constraint FK49484F671E1FCE3 foreign key (current_school_name_id) references local_referential_data;

alter table study_grant_request_tax_household_city drop constraint FK1B568948A40092FB;
alter table study_grant_request_tax_household_city add constraint FK1B56894857A06C54 foreign key (tax_household_city_id) references local_referential_data;

alter table technical_intervention_request_intervention_type drop constraint FK5ADF79AC7CF39D58;
alter table technical_intervention_request_intervention_type add constraint FK5ADF79AC309376B1 foreign key (intervention_type_id) references local_referential_data;

alter table ticket_type_selection drop constraint FK3B70C45A6592BACC;
alter table ticket_type_selection add constraint FK3B70C45A19329425 foreign key (place_reservation_data_id) references place_reservation_data;

-- payment services refactoring
alter table purchase_item drop column reference;
alter table purchase_item add column key varchar(255);
alter table purchase_item add column key_owner varchar(255);
update purchase_item set key = request_id, key_owner = 'capdemat' where request_id is not null;
alter table purchase_item drop column request_id;
alter table purchase_item drop constraint FKB113279154BCD4FA;
alter table purchase_item add constraint FKB1132791A8364360 foreign key (payment_id) references payment;
alter table purchase_item_specific_data drop constraint FK455E96692BA69830;
alter table purchase_item_specific_data add constraint FK455E9669669F9D96 foreign key (id) references purchase_item;

alter table request add column has_tied_home_folder bool;
alter table home_folder add column is_temporary bool;
update request set has_tied_home_folder = false;
update request set has_tied_home_folder = true 
    from home_folder
    where request.home_folder_id = home_folder.id
    and home_folder.origin_request_id = request.id
    and home_folder.bound_to_request = true;
update home_folder set is_temporary = false;
update home_folder set is_temporary = true where bound_to_request = true;
alter table home_folder drop column origin_request_id;
alter table home_folder drop column bound_to_request;
