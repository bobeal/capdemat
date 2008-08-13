create table capwebct_association_summary (
	capwebct_family_account_id int8 not null,
    external_application_id int8 not null,
    state varchar(255) not null,
    primary key (capwebct_family_account_id, external_application_id, state)
);

alter table capwebct_association_summary 
	add constraint FKF44375DC338E0F2C 
    foreign key (capwebct_family_account_id) 
    references capwebct_family_account;

-- manual initialization of capwebct_association_summary table and reset of current associations
-- update external_family_account set capwebct_family_account_fk = null;
-- insert into capwebct_association_summary select id, 2, 'not_associated' from capwebct_family_account;

ALTER TABLE capwebct_family_account ADD column responsible_full_name varchar(255);
ALTER TABLE payment add column cfa_id bigint;
ALTER TABLE payment add column broker varchar(255);
