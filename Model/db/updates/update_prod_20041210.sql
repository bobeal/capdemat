-- Some SQL to update Parmain requirements
-- Don't run it on another DB !
delete from requirement where document_type_id = (select id from document_type where name = 'Health Notebook') and request_type_id = request_type.id and request_type.label = 'Perischool Activity Registration';

update requirement set document_type_id = (select id from document_type where name = 'Health Notebook') where document_type_id = (select id from document_type where name = 'Medical Certificate') and request_type_id = request_type.id and request_type.label = 'School Registration';
 
update requirement set document_type_id = (select id from document_type where name = 'Health Notebook') where document_type_id = (select id from document_type where name = 'Medical Certificate') and request_type_id = request_type.id and request_type.label = 'Perischool Activity Registration';

update requirement set document_type_id = (select id from document_type where name = 'Taxes Notification') where document_type_id = (select id from document_type where name = 'Adoption Judgment') and request_type_id = request_type.id and request_type.label = 'Perischool Activity Registration';
