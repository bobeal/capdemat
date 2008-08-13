-- Enumerated types representation changes
alter table document_type add column validity_duration_type_temp varchar(16);
update document_type set validity_duration_type_temp = 'Unlimited' where validity_duration_type = 0;
update document_type set validity_duration_type_temp = 'Year' where validity_duration_type = 1;
update document_type set validity_duration_type_temp = 'Month' where validity_duration_type = 2;
update document_type set validity_duration_type_temp = 'End Year' where validity_duration_type = 3;
update document_type set validity_duration_type_temp = 'End School Year' where validity_duration_type = 4;
alter table document_type drop column validity_duration_type;
alter table document_type rename column validity_duration_type_temp to validity_duration_type;
alter table document_type alter column validity_duration_type set not null;

alter table document_type add column usage_type_temp varchar(16);
update document_type set usage_type_temp = 'Single Use' where usage_type = 0;
update document_type set usage_type_temp = 'Reusable' where usage_type = 1;
alter table document_type drop column usage_type;
alter table document_type rename column usage_type_temp to usage_type;
alter table document_type alter column usage_type set not null;

alter table request_form add column type_temp varchar(255);
update request_form set type_temp = 'Generic Request Certificat' where type =0;
update request_form set type_temp = 'VO Card Request Certificat' where type =1;
update request_form set type_temp = 'School Registration Request Certificat' where type =2;
update request_form set type_temp = 'School Canteen Registration Request Certificat' where type =3;
update request_form set type_temp = 'Perischool Activity Registration Request Certificat' where type =4;
update request_form set type_temp = 'Vacations Registration Request Certificat' where type =5;
update request_form set type_temp = 'Home Folder Modification Request Certificat' where type =6;
alter table request_form drop column type;
alter table request_form rename type_temp to type;
alter table request_form alter column type set not null;

alter table school_registration add column section_temp varchar(32);
update school_registration set section_temp = 'First Section' where section = 0;
update school_registration set section_temp = 'Second Section' where section = 1;
update school_registration set section_temp = 'Third Section' where section = 2;
update school_registration set section_temp = 'CP' where section = 3;
update school_registration set section_temp = 'CE1' where section = 4;
update school_registration set section_temp = 'CE2' where section = 5;
update school_registration set section_temp = 'CM1' where section = 6;
update school_registration set section_temp = 'CM2' where section = 7;
update school_registration set section_temp = 'Unknown' where section = 8;
alter table school_registration drop column section;
alter table school_registration rename section_temp to section;

alter table agent_service_roles add column profile_temp varchar(16);
update agent_service_roles set profile_temp = 'None' where profile_id = 0;
update agent_service_roles set profile_temp = 'R/O' where profile_id = 1;
update agent_service_roles set profile_temp = 'R/W' where profile_id = 2;
alter table agent_service_roles drop column profile_id;
alter table agent_service_roles rename profile_temp to profile;

alter table agent_site_roles add column profile_temp varchar(16);
update agent_site_roles set profile_temp = 'None' where profile_id = 0;
update agent_site_roles set profile_temp = 'Admin' where profile_id = 1;
update agent_site_roles set profile_temp = 'Manage' where profile_id = 2;
alter table agent_site_roles drop column profile_id;
alter table agent_site_roles rename profile_temp to profile;

alter table other_individual add column type_temp varchar(16);
update other_individual set type_temp = 'Contact Person' where type = 0;
update other_individual set type_temp = 'Pickup Person' where type = 1;
alter table other_individual drop column type;
alter table other_individual rename column type_temp to type;

-- those are not needed since XDoclet porting
alter table agent drop column password;
alter table agent drop column lastname;
alter table agent drop column firstname;
alter table agent drop column title;
alter table agent drop column personaltitle;
alter table agent drop column phonenumber;

-- change length of local authority name
alter table local_authority add column name_temp varchar(32);
update local_authority set name_temp = name;
alter table local_authority drop column name;
alter table local_authority rename column name_temp to name;

-- addition of some not-null constraints
-- good idea or not ?
-- ALTER TABLE recreation_center ALTER COLUMN name SET NOT NULL;
-- ALTER TABLE perischool_activity ALTER COLUMN name SET NOT NULL;
-- ALTER TABLE service ALTER COLUMN local_authority_id SET NOT NULL;
-- ALTER TABLE local_authority ALTER COLUMN name SET NOT NULL;
-- ALTER TABLE local_authority ALTER COLUMN postal_code SET NOT NULL;
-- ALTER TABLE school ALTER COLUMN local_authority_id SET NOT NULL;
-- ALTER TABLE document_type ALTER COLUMN name SET NOT NULL;
-- ALTER TABLE document_type ADD CONSTRAINT document_type_name_idx UNIQUE(name);
-- ALTER TABLE document_type ALTER COLUMN type SET NOT NULL;
-- ALTER TABLE document_type ALTER COLUMN validity_duration SET NOT NULL;
-- ALTER TABLE agent_site_roles ALTER COLUMN local_authority_id SET NOT NULL;
-- ALTER TABLE vacations ALTER COLUMN local_authority_id SET NOT NULL;
