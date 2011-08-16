-- only needed for CG77's platform
--alter table bafa_grant_request
--    add constraint FK50AFA827A4AB2F89
--    foreign key (bank_account_id)
--    references bank_account;
--alter table bafa_grant_request drop constraint FK50AFA8271EE1CD99;
--delete from french_r_i_b where id in (select french_r_i_b_id from bafa_grant_request);
--alter table bafa_grant_request drop column french_r_i_b_id;

alter table study_grant_request
    add constraint FK7D2F0A76A4AB2F89
    foreign key (bank_account_id)
    references bank_account;
alter table study_grant_request drop constraint FK7D2F0A761EE1CD99;
delete from french_r_i_b where id in (select french_r_i_b_id from study_grant_request);
alter table study_grant_request drop column french_r_i_b_id;

alter table document_binary drop column data;
alter table document_binary drop column preview;
alter table document_binary alter column zdb_id set not null;

alter table study_grant_request drop column current_school_postal_code;
alter table study_grant_request drop column current_school_city;
alter table study_grant_request drop column current_school_country;
