delete from study_grant_request_current_school_name where study_grant_request_id in (4545, 534260, 714030, 1163513, 1593570, 4672671);
delete from study_grant_request_tax_household_city where study_grant_request_id in (4545, 534260, 714030, 1163513, 1593570, 4672671);
delete from study_grant_request where id in (4545, 534260, 714030, 1163513, 1593570, 4672671);
delete from local_referential_data where id in (4547, 534263, 714034, 1163516, 1593572, 4672673);
delete from local_referential_data where id in (4548, 534262, 714033, 1163515, 1593573, 4672674);
delete from external_service_traces where key in ('4545', '534260', '714030', '1163513', '1593570', '4672671');
delete from request_action where request_id in (4545, 534260, 714030, 1163513, 1593570, 4672671);
delete from request_note where request_id in (4545, 534260, 714030, 1163513, 1593570, 4672671);
delete from request_document where request_id in (4545, 534260, 714030, 1163513, 1593570, 4672671);
delete from request where id in (4545, 534260, 714030, 1163513, 1593570, 4672671);

update request set subject_id = 6673862 where id = 47495;
update request set requester_id = 6673862 where id = 47495;
update study_grant_request set current_school_name_precision = 'Texas A&amp;M University' where id = 2750;
update study_grant_request set current_school_name_precision = 'CFA Utec I&amp;NT' where id = 14185;

insert into local_referential_data (id, name) values (nextval('hibernate_sequence'), '121');
update study_grant_request_tax_household_city set tax_household_city_id = currval('hibernate_sequence') where study_grant_request_id = 26300;

insert into local_referential_data (id, name) values (nextval('hibernate_sequence'), '322');
update study_grant_request_tax_household_city set tax_household_city_id = currval('hibernate_sequence') where study_grant_request_id = 20932;

insert into local_referential_data (id, name) values (nextval('hibernate_sequence'), '333');
update study_grant_request_tax_household_city set tax_household_city_id = currval('hibernate_sequence') where study_grant_request_id = 46485;
