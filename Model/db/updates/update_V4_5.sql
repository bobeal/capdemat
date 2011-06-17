create table bank_account (
    id int8 not null,
    bic varchar(255) not null,
    iban varchar(255) not null,
    primary key (id)
);

alter table bafa_grant_request add column bank_account_id int8;
alter table study_grant_request add column bank_account_id int8;
