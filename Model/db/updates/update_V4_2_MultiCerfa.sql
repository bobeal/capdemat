    alter table multi_cerfa_electoral_roll_registration_request 
        drop constraint FK385846F50BB72D;

drop table multi_cerfa_electoral_roll_registration_request;

    create table multi_cerfa_electoral_roll_registration_request (
        id int8 not null,
        old_department varchar(2),
        external_district_a_e_c_t varchar(255),
        motive varchar(255),
        choice_nationality varchar(255),
        registration_city varchar(32),
        subject_choice_birth_date timestamp,
        ambassy_or_consulate_a_f_c_t varchar(255),
        subject_choice_email varchar(255),
        registration_postal_code varchar(2),
        subject_choice_title varchar(255),
        subject_choice_mobil_phone varchar(10),
        subject_choice_pro_phone varchar(10),
        subject_choice_first_name varchar(255),
        european_nationality varchar(255),
        external_city_a_e_c_t varchar(255),
        subject_choice_birth_city varchar(32),
        subject_choice_last_name varchar(255),
        subject_choice_birth_postal_code varchar(5),
        subject_choice_home_phone varchar(10),
        old_city varchar(255),
        external_country_a_e_c_t varchar(255),
        subject_choice_maiden_name varchar(255),
        external_country_a_f_c_t varchar(255),
        election_choice varchar(255),
        old_overseas varchar(255),
        subject_choice_address_id int8,
        subject_choice_birth_country varchar(255),
        primary key (id)
    );

  alter table multi_cerfa_electoral_roll_registration_request 
        add constraint FK385846F50BB72D 
        foreign key (subject_choice_address_id) 
        references address;
