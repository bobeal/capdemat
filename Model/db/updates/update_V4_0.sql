alter table request_form add column personalized_data bytea ;
alter table request_form add column template_name varchar(255);

drop table vacations_diary ;
drop table vacations_registration_request_other_individual ;
drop table vacations_registration_request ;
delete from requirement where request_type_id = (select id from request_type where label = 'Vacations Registration');
delete from request_type where label = 'Vacations Registration';

