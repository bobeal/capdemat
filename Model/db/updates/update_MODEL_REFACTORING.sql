-- Document related refactorings (DRR)

-- DRR1 : constraint on individual
alter table document 
    drop constraint FK335CD11B59302132;
-- DRR2 : constraint on home folder
alter table document 
    drop constraint FK335CD11B8BD77771;

-- Request related refactorings (RRR)

-- RRR1 : constraint on home folder
alter table request 
    drop constraint FK414EF28F8BD77771;
    
-- RRR2 : constraint on individual (requester)
alter table request
    drop constraint FK414EF28F1BC4A960;

-- RRR3 : contraint on documents
-- TODO REFACTORING : migrate existing data

create table request_document (
    id int8 not null,
    document_id int8,
    request_id int8,
    primary key (id)
);
alter table request_document owner to cvq95;
alter table request_document 
    add constraint FK712980CB848EB249 
    foreign key (request_id) 
    references request;
         
alter table request_document_map 
    drop constraint FKCBC2F7E87A6C6B5B;
alter table request_document_map 
    drop constraint FKCBC2F7E8848EB249;
drop table request_document_map;

-- RRR4 : add requester and subject last name
alter table request add column requester_last_name varchar(255);
alter table request add column subject_last_name varchar(255);

-- Home folder related constraints (HFRC)

-- HFRC1 : object model for roles 
create table individual_roles (
    individual_id int8 not null,
    role varchar(255),
    home_folder_id int8
);

alter table individual_roles 
    add constraint FK532C7D9759302132 
    foreign key (individual_id) 
    references individual;

-- migration existing "home folder responsible" roles

insert into individual_roles select adult.id, 'HomeFolderResponsible', home_folder_id from adult, individual where adult.id = individual.id and (home_folder_roles = 1 or home_folder_roles = 3);

alter table adult drop column home_folder_roles;

