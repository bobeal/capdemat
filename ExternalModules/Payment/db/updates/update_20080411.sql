alter table capwebct_family_account add column address varchar(255);
alter table external_family_account add column address varchar(255);

alter table external_individual add column responsible boolean;
