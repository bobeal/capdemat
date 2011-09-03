alter table local_authority add column adresses_referential_url varchar(255);

alter table request_action add column external_service varchar(255);

alter table individual add column duplicate_alert bool;
alter table individual add column duplicate_data TEXT;

update individual set duplicate_alert = false;

-- an old state found in old DB
DELETE FROM request_action where resulting_state = 'Active';

-- clean existing DBs : remove crap left by HFMRs
delete from individual_role where owner_id is null;
delete from individual_role where owner_id in (select id from individual where home_folder_id is null);

