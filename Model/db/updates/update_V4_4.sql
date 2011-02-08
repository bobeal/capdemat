update home_folder set is_temporary = true where id in (select home_folder_id from request where has_tied_home_folder is true);
alter table request drop column has_tied_home_folder;

alter table home_folder drop constraint FKDB87BBCE6AB1E860;
alter table home_folder add constraint FKDB87BBCEB7531222 foreign key (address_id) references address;

alter table individual drop constraint FKFD3DA2996AB1E860;
alter table individual add constraint FKFD3DA299B7531222 foreign key (address_id) references address;

alter table child alter column child_born rename to born;

alter table document_action rename agent_id to user_id;
alter table document_action rename label to type;
alter table document_action alter column type set not null;
update document_action set type = 'Creation' where type = 'CREATION_ACTION';
update document_action set type = 'StateChange' where type = 'STATE_CHANGE_ACTION';
update document_action set type = 'PageAddition' where type = 'PAGE_ADD_ACTION';
update document_action set type = 'PageEdition' where type = 'PAGE_EDIT_ACTION';
update document_action set type = 'PageDeletion' where type = 'PAGE_DELETE_ACTION';
update document_action set type = 'Merge' where type = 'MERGE_ACTION';

-- New data in external home folder's CSV export files
alter table external_individual add column email varchar(255);
alter table external_individual add column home_phone varchar(255);
