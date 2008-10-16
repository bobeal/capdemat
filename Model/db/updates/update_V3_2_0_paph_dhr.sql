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
