-- Set email field to 50 instead of 32
create table temp as select * from adult;
alter table adult drop constraint FK58621BA19BC63D4;
alter table adult drop constraint FK58621BAD1B;
alter table vo_card_request drop constraint FKC295D42620FA1B95;
ALTER TABLE request drop constraint fk414ef28f4e01d8be;
ALTER TABLE child_legal_responsible_map drop constraint fk62e1102af806614a;
ALTER TABLE home_folder drop constraint fkdb87bbce20fa1b95;
ALTER TABLE home_folder drop constraint fkdb87bbcec45928cb;
drop table adult;
create table adult (
   id int8 not null,
   title int4,
   maiden_name varchar(255),
   name_of_use varchar(255),
   family_status int4,
   home_phone varchar(32),
   mobile_phone varchar(32),
   office_phone varchar(32),
   email varchar(50),
   ssn int4,
   cfbn int4,
   profession varchar(255),
   company_name varchar(255),
   company_adress varchar(255),
   vo_card_request_id int8,
   primary key (id)
);
insert into adult select * from temp;
drop table temp;
alter table home_folder add constraint FKDB87BBCEC45928CB foreign key (home_folder_financial_responsible_id) references adult;
alter table home_folder add constraint FKDB87BBCE20FA1B95 foreign key (home_folder_responsible_id) references adult;
alter table child_legal_responsible_map add constraint FK62E1102AF806614A foreign key (legal_responsible_id) references adult;
alter table adult add constraint FK58621BA19BC63D4 foreign key (vo_card_request_id) references vo_card_request;
alter table adult add constraint FK58621BAD1B foreign key (id) references individual;
alter table request add constraint FK414EF28F4E01D8BE foreign key (requester_id) references adult;
alter table vo_card_request add constraint FKC295D42620FA1B95 foreign key (home_folder_responsible_id) references adult;
