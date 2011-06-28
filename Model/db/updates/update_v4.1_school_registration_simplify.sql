    alter table school_registration_simplify_request 
        drop constraint FKD79D949482587E99;

    alter table school_registration_simplify_request_section 
        drop constraint FK3458E63AC54FD696;

    alter table school_registration_simplify_request_section 
        drop constraint FK3458E63A50F74B35;


    drop table school_registration_simplify_request;

    drop table school_registration_simplify_request_section;


    create table school_registration_simplify_request (
        id int8 not null,
        current_school_level varchar(255),
        derogation bool,
        current_school_address varchar(255),
        emergency_phone varchar(255),
        current_school_name varchar(255),
        exist_registration bool,
        emergency_contact_name varchar(255),
        primary key (id)
    );

    create table school_registration_simplify_request_section (
        school_registration_simplify_request_id int8 not null,
        section_id int8 not null,
        section_index int4 not null,
        primary key (school_registration_simplify_request_id, section_index)
    );


    alter table school_registration_simplify_request 
        add constraint FKD79D949482587E99 
        foreign key (id) 
        references request;

    alter table school_registration_simplify_request_section 
        add constraint FK3458E63AC54FD696 
        foreign key (school_registration_simplify_request_id) 
        references school_registration_simplify_request;

    alter table school_registration_simplify_request_section 
        add constraint FK3458E63A50F74B35 
        foreign key (section_id) 
        references local_referential_data;



