alter table individual add column federation_key varchar(64);
alter table individual add constraint individual_federation_key_key unique(federation_key);

