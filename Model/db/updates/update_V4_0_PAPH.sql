-- Domestic help request

alter table dhr_donation 
    drop constraint FK91725043E45A0A7F;

alter table dhr_donation 
    drop constraint FK9172504366C81F29;

alter table dhr_personal_estate_and_saving 
    drop constraint FK5EFB376766C81F29;

alter table dhr_previous_dwelling 
    drop constraint FKB0B96E27F802E509;

alter table dhr_previous_dwelling 
    drop constraint FKB0B96E2766C81F29;

alter table dhr_real_asset 
    drop constraint FK6AA7D980A3F3FF52;

alter table dhr_real_asset 
    drop constraint FK6AA7D98066C81F29;

alter table domestic_help_request 
    drop constraint FK3C0081121C4A2C9A;

alter table domestic_help_request 
    drop constraint FK3C008112A2B2928B;

alter table domestic_help_request 
    drop constraint FK3C008112B3BAD17C;

alter table domestic_help_request 
    drop constraint FK3C0081126FFC52CB;

alter table domestic_help_request 
    drop constraint FK3C008112ED1B9492;

drop table dhr_donation;

drop table dhr_personal_estate_and_saving;

drop table dhr_previous_dwelling;

drop table dhr_real_asset;

drop table domestic_help_request;

create table dhr_not_real_asset (
    id int8 not null,
    asset_date timestamp,
    asset_beneficiary_first_name varchar(38),
    asset_notary_name varchar(38),
    asset_notary_address_id int8,
    asset_address_id int8,
    asset_value bytea,
    asset_beneficiary_address_id int8,
    asset_beneficiary_name varchar(38),
    asset_kind varchar(255),
    asset_type varchar(255),
    domestic_help_request_id int8,
    primary key (id)
);

create table dhr_real_asset (
    id int8 not null,
    real_asset_value bytea,
    real_asset_address_id int8,
    real_asset_net_floor_area bytea,
    domestic_help_request_id int8,
    primary key (id)
);

create table domestic_help_request (
    id int8 not null,
    current_dwelling_status varchar(255),
    tutor_name varchar(38),
    more_than15_years_in_france bool,
    spouse_france_arrival_date timestamp,
    family_referent_name varchar(38),
    taxes_total bytea,
    requester_incomes_annual_total bytea,
    spouse_pensionner bool,
    tutor_address_id int8,
    family_referent_designated bool,
    previous_dwelling_address_id int8,
    requester_furniture_investment_income bytea,
    not_real_assets_values_total bytea,
    complementary_pension_plan_precision varchar(50),
    spouse_employer_address_id int8,
    current_dwelling_room_number bytea,
    previous_dwelling_departure_date timestamp,
    spouse_information_id int8,
    spouse_pensions bytea,
    previous_dwelling_arrival_date timestamp,
    family_referent_address_id int8,
    requester_request_kind varchar(255),
    current_dwelling_arrival_date timestamp,
    current_dwelling_net_floor_area bytea,
    spouse_nationality varchar(32),
    current_dwelling_address_id int8,
    spouse_incomes_annual_total bytea,
    requester_allowances bytea,
    spouse_pension_plan_precision varchar(50),
    requester_pension_plan varchar(255),
    spouse_allowances bytea,
    spouse_real_estate_investment_income bytea,
    income_tax bytea,
    property_taxes bytea,
    nationality varchar(32),
    requester_pensions bytea,
    spouse_employer varchar(50),
    requester_has_spouse varchar(255),
    spouse_complementary_pension_plan_precision varchar(50),
    tutor varchar(255),
    family_referent_first_name varchar(38),
    requester_real_estate_investment_income bytea,
    spouse_more_than15_years_in_france bool,
    spouse_pension_plan varchar(255),
    spouse_occupation varchar(50),
    current_dwelling_type varchar(255),
    pension_plan_precision varchar(50),
    current_dwelling_personal_phone varchar(10),
    spouse_net_income bytea,
    france_arrival_date timestamp,
    requester_net_income bytea,
    professional_taxes bytea,
    spouse_furniture_investment_income bytea,
    tutor_presence bool,
    local_rate bytea,
    real_assets_values_total bytea,
    primary key (id)
);

alter table dhr_not_real_asset 
    add constraint FK2BA9F1ECBB7505EB 
    foreign key (asset_beneficiary_address_id) 
    references address;

alter table dhr_not_real_asset 
    add constraint FK2BA9F1EC4EF8925D 
    foreign key (asset_notary_address_id) 
    references address;

alter table dhr_not_real_asset 
    add constraint FK2BA9F1EC66C81F29 
    foreign key (domestic_help_request_id) 
    references domestic_help_request;

alter table dhr_not_real_asset 
    add constraint FK2BA9F1ECDAD946D1 
    foreign key (asset_address_id) 
    references address;

alter table dhr_real_asset 
    add constraint FK6AA7D980A3F3FF52 
    foreign key (real_asset_address_id) 
    references address;

alter table dhr_real_asset 
    add constraint FK6AA7D98066C81F29 
    foreign key (domestic_help_request_id) 
    references domestic_help_request;


alter table domestic_help_request 
    add constraint FK3C008112F802E509 
    foreign key (previous_dwelling_address_id) 
    references address;

alter table domestic_help_request 
    add constraint FK3C0081121C4A2C9A 
    foreign key (spouse_information_id) 
    references adult;

alter table domestic_help_request 
    add constraint FK3C008112A2B2928B 
    foreign key (current_dwelling_address_id) 
    references address;

alter table domestic_help_request 
    add constraint FK3C008112B3BAD17C 
    foreign key (spouse_employer_address_id) 
    references address;

alter table domestic_help_request 
    add constraint FK3C0081128E87091B 
    foreign key (family_referent_address_id) 
    references address;

alter table domestic_help_request 
    add constraint FK3C0081126FFC52CB 
    foreign key (tutor_address_id) 
    references address;

alter table domestic_help_request 
    add constraint FK3C008112ED1B9492 
    foreign key (id) 
    references request;
    
-- handicap allowance request

alter table handicap_allowance_request 
    drop constraint FKF20630A1EEEA103C;

alter table handicap_allowance_request 
    drop constraint FKF20630A1A933FB6F;

alter table handicap_allowance_request 
    drop constraint FKF20630A182587E99;

alter table handicap_allowance_request 
    drop constraint FKF20630A1A82C7464;

alter table handicap_allowance_request 
    drop constraint FKF20630A12AF072D5;

alter table handicap_allowance_request 
    drop constraint FKF20630A15AB58CC4;

alter table handicap_allowance_request 
    drop constraint FKF20630A15447DA69;

alter table handicap_allowance_request 
    drop constraint FKF20630A12633BF01;

alter table handicap_allowance_request 
    drop constraint FKF20630A1F813ECA3;

alter table handicap_allowance_request 
    drop constraint FKF20630A11D8D402B;

alter table handicap_allowance_request 
    drop constraint FKF20630A19121BC2A;

alter table handicap_allowance_request 
    drop constraint FKF20630A1B02B91D4;

alter table har_family_dependent 
    drop constraint FK6EEA28CAE3200797;

drop table handicap_allowance_request;

drop table har_family_dependent;

create table handicap_allowance_request (
    id int8 not null,
    adult_requester_first_name varchar(38),
    less_than20_referent_birth_place_city varchar(32),
    less_than20_father_mobile_phone varchar(10),
    less_than20_referent_home_phone varchar(10),
    less_than20_referent_address_id int8,
    writing_help bool,
    family_has_family_dependents bool,
    less_than20_parental_authority_department varchar(255),
    less_than20_legal_representative_home_phone varchar(10),
    adult_requester_last_name varchar(38),
    helper_responsability varchar(255),
    payment_agency_beneficiary varchar(255),
    less_than20_father_job varchar(255),
    adult_requester_birth_date timestamp,
    request_information_requester_profile varchar(255),
    request_information_kind varchar(255),
    payment_agency_address_id int8,
    less_than20_father_address_id int8,
    adult_requester_birth_place_city varchar(32),
    comments varchar(255),
    adult_requester_email varchar(255),
    social_security_agency_address_id int8,
    dwelling_reception_address_id int8,
    adult_requester_mobile_phone varchar(10),
    less_than20_referent_mobile_phone varchar(10),
    adult_legal_access_representative_last_name varchar(38),
    adult_legal_access_kind varchar(255),
    less_than20_referent_first_name varchar(38),
    less_than20_legal_representative_first_name varchar(38),
    less_than20_father_first_name varchar(38),
    adult_legal_access_representative_mobile_phone varchar(10),
    less_than20_mother_reduction_ratio varchar(255),
    less_than20_requester_mobile_phone varchar(10),
    less_than20_father_home_phone varchar(10),
    dwelling_reception_type varchar(255),
    less_than20_father_reduction_ratio varchar(255),
    adult_requester_address_id int8,
    payment_agency_name varchar(255),
    dwelling_social_reception_naming varchar(255),
    family_status varchar(255),
    less_than20_mother_address_id int8,
    less_than20_requester_id int8,
    less_than20_parental_authority_name varchar(38),
    adult_legal_access_representative_precision varchar(50),
    less_than20_legal_representative_address_id int8,
    social_security_agency_name varchar(255),
    dwelling_reception_naming varchar(255),
    less_than20_mother_first_name varchar(38),
    social_security_number varchar(13),
    less_than20_mother_mobile_phone varchar(10),
    less_than20_mother_activity_reduction bool,
    less_than20_referent_last_name varchar(38),
    adult_legal_access_representative_email varchar(255),
    less_than20_referent_birth_place_country varchar(255),
    payment_agency_beneficiary_number varchar(255),
    less_than20_legal_representative bool,
    adult_legal_access_representative_home_phone varchar(10),
    adult_requester_birth_place_country varchar(255),
    dwelling_social_reception_address_id int8,
    request_information_expiration_date timestamp,
    adult_requester_title varchar(255),
    adult_legal_access_representative_address_id int8,
    less_than20_requester_home_phone varchar(10),
    adult_legal_access_representative_kind varchar(255),
    less_than20_referent_birth_date timestamp,
    adult_legal_access_presence bool,
    dwelling_establishment_reception bool,
    less_than20_requester_email varchar(255),
    dwelling_social_reception bool,
    hopes_and_needs bool,
    less_than20_father_activity_reduction bool,
    less_than20_father_last_name varchar(38),
    less_than20_mother_last_name varchar(38),
    less_than20_mother_home_phone varchar(10),
    dwelling_precision varchar(255),
    less_than20_parental_authority_holder varchar(255),
    less_than20_legal_representative_mobile_phone varchar(10),
    social_security_member_ship_kind varchar(255),
    less_than20_referent_title varchar(255),
    needs varchar(255),
    less_than20_referent_email varchar(255),
    less_than20_mother_job varchar(255),
    adult_legal_access_representative_first_name varchar(38),
    less_than20_legal_representative_last_name varchar(38),
    helper_name varchar(38),
    dwelling_kind varchar(255),
    adult_requester_home_phone varchar(10),
    hopes varchar(255),
    primary key (id)
);

create table har_family_dependent (
    id int8 not null,
    family_dependent_actual_situation varchar(255),
    family_dependent_last_name varchar(38),
    family_dependent_first_name varchar(38),
    family_dependent_birth_date timestamp,
    handicap_allowance_request_id int8,
    primary key (id)
);

alter table handicap_allowance_request 
    add constraint FKF20630A1EEEA103C 
    foreign key (less_than20_referent_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A1A933FB6F 
    foreign key (social_security_agency_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A182587E99 
    foreign key (id) 
    references request;

alter table handicap_allowance_request 
    add constraint FKF20630A1A82C7464 
    foreign key (less_than20_mother_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A12AF072D5 
    foreign key (dwelling_social_reception_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A15AB58CC4 
    foreign key (less_than20_legal_representative_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A15447DA69 
    foreign key (less_than20_requester_id) 
    references individual;

alter table handicap_allowance_request 
    add constraint FKF20630A12633BF01 
    foreign key (dwelling_reception_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A1F813ECA3 
    foreign key (payment_agency_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A11D8D402B 
    foreign key (less_than20_father_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A19121BC2A 
    foreign key (adult_requester_address_id) 
    references address;

alter table handicap_allowance_request 
    add constraint FKF20630A1B02B91D4 
    foreign key (adult_legal_access_representative_address_id) 
    references address;

alter table har_family_dependent 
    add constraint FK6EEA28CAE3200797 
    foreign key (handicap_allowance_request_id) 
    references handicap_allowance_request;


