alter table local_authority add column adresses_referential_url varchar(255);

alter table request_action add column external_service varchar(255);

alter table individual add column duplicate_alert bool;
alter table individual add column duplicate_data TEXT;
