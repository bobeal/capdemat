create table learning_activities_discovery_registration_request (
    id int8 not null,
    primary key (id)
);

create table learning_activities_discovery_registration_request_atelier_eveil (
    learning_activities_discovery_registration_request_id int8 not null,
    atelier_eveil_id int8 not null,
    atelier_eveil_index int4 not null,
    primary key (learning_activities_discovery_registration_request_id, atelier_eveil_index)
);

alter table learning_activities_discovery_registration_request_atelier_eveil 
    add constraint FK6631159E51ABD2B5 
    foreign key (learning_activities_discovery_registration_request_id) 
    references learning_activities_discovery_registration_request;

alter table learning_activities_discovery_registration_request_atelier_eveil 
    add constraint FK6631159E9AA8EC9F 
    foreign key (atelier_eveil_id) 
    references local_referential_data;

