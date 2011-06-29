	alter table recreation_activity_poly_registration_request 
        drop constraint FK376F9FB9D830B2A3;

    alter table recreation_activity_poly_registration_request_recreation_poly_activity 
        drop constraint FK7F62DC7B5A25DABE;

    alter table recreation_activity_poly_registration_request_recreation_poly_activity 
        drop constraint FK7F62DC7B62867E8B;

    alter table recreation_authorized_poly_individual 
        drop constraint FK30626095B7531222;

    alter table recreation_authorized_poly_individual 
        drop constraint FK3062609562867E8B;

    alter table recreation_contact_poly_individual 
        drop constraint FKDB500BA0B7531222;

    alter table recreation_contact_poly_individual 
        drop constraint FKDB500BA062867E8B;

    drop table recreation_activity_poly_registration_request;

    drop table recreation_activity_poly_registration_request_recreation_poly_activity;

    drop table recreation_authorized_poly_individual;
    
    drop table recreation_contact_poly_individual;
    
    create table recreation_activity_poly_registration_request (
        id int8 not null,
        urgency_poly_phone varchar(10),
        recreation_poly_center_id int8,
        hospitalization_poly_permission bool,
        rules_and_regulations_poly_acceptance bool,
        child_photo_exploitation_poly_permission bool,
        class_trip_poly_permission bool,
        primary key (id)
    );

    create table recreation_activity_poly_registration_request_recreation_poly_activity (
        recreation_activity_poly_registration_request_id int8 not null,
        recreation_poly_activity_id int8 not null,
        recreation_poly_activity_index int4 not null,
        primary key (recreation_activity_poly_registration_request_id, recreation_poly_activity_index)
    );
    
    create table recreation_authorized_poly_individual (
        id int8 not null,
        office_phone varchar(10),
        address_id int8,
        first_name varchar(38),
        last_name varchar(38),
        home_phone varchar(10),
        recreation_activity_poly_registration_request_id int8,
        authorized_poly_individuals_index int4,
        primary key (id)
    );

    create table recreation_contact_poly_individual (
        id int8 not null,
        office_phone varchar(10),
        address_id int8,
        first_name varchar(38),
        last_name varchar(38),
        home_phone varchar(10),
        recreation_activity_poly_registration_request_id int8,
        contact_poly_individuals_index int4,
        primary key (id)
    );
    
    alter table recreation_activity_poly_registration_request 
        add constraint FK376F9FB9D830B2A3 
        foreign key (recreation_poly_center_id) 
        references recreation_center;

    alter table recreation_activity_poly_registration_request_recreation_poly_activity 
        add constraint FK7F62DC7B5A25DABE 
        foreign key (recreation_poly_activity_id) 
        references local_referential_data;

    alter table recreation_activity_poly_registration_request_recreation_poly_activity 
        add constraint FK7F62DC7B62867E8B 
        foreign key (recreation_activity_poly_registration_request_id) 
        references recreation_activity_poly_registration_request;
        
    alter table recreation_authorized_poly_individual 
        add constraint FK30626095B7531222 
        foreign key (address_id) 
        references address;

    alter table recreation_authorized_poly_individual 
        add constraint FK3062609562867E8B 
        foreign key (recreation_activity_poly_registration_request_id) 
        references recreation_activity_poly_registration_request;

    alter table recreation_contact_poly_individual 
        add constraint FKDB500BA0B7531222 
        foreign key (address_id) 
        references address;

    alter table recreation_contact_poly_individual 
        add constraint FKDB500BA062867E8B 
        foreign key (recreation_activity_poly_registration_request_id) 
        references recreation_activity_poly_registration_request;
