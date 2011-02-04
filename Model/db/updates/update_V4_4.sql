update home_folder set is_temporary = true where id in (select home_folder_id from request where has_tied_home_folder is true);
alter table request drop column has_tied_home_folder;

alter table home_folder drop constraint FKDB87BBCE6AB1E860;
alter table home_folder add constraint FKDB87BBCEB7531222 foreign key (address_id) references address;

alter table individual drop constraint FKFD3DA2996AB1E860;
alter table individual add constraint FKFD3DA299B7531222 foreign key (address_id) references address;

alter table child alter column child_born rename to born;
