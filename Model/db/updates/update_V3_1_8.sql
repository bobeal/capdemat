-- updates for remote support request 

create table remote_support_request (
   id int8 not null,
   contact_name varchar(255),
   emergency bool,
   trustee_first_name varchar(255),
   senior_assitance_beneficiary bool,
   appartment_number bytea,
   trustee_name varchar(255),
   floor bytea,
   taxable bool,
   contact_first_name varchar(255),
   contact varchar(255),
   trustee_phone varchar(10),
   trustee varchar(255),
   dwelling varchar(255),
   contact_phone varchar(10),
   primary key (id)
);

alter table remote_support_request add constraint FKEAA6DC26D1B foreign key (id) references request;
alter table remote_support_request owner to cvq95;

-- updates for domestic help request


create table dhr_personal_estate_and_saving (
   id int8 not null,
   paybook_number varchar(30),
   paybook_amount bytea,
   domestic_help_request_id int8,
   primary key (id)
);
alter table dhr_personal_estate_and_saving owner to cvq95;

create table domestic_help_request (
   id int8 not null,
   current_dwelling_status varchar(255),
   tutor_name varchar(38),
   spouse_france_arrival_date timestamp,
   spouse_social_security_key_number varchar(2),
   social_security_number varchar(13),
   taxes_total bytea,
   capital_amount_total bytea,
   rent bytea,
   requester_incomes_annual_total bytea,
   spouse_pensionner bool,
   tutor_address_id int8,
   expenses_total bytea,
   spouse_employer_address_id int8,
   current_dwelling_room_number bytea,
   spouse_information_id int8,
   spouse_pensions bytea,
   tutor_first_name varchar(38),
   current_dwelling_arrival_date timestamp,
   current_dwelling_net_floor_area bytea,
   spouse_nationality varchar(255),
   savings_total bytea,
   current_dwelling varchar(255),
   current_dwelling_address_id int8,
   spouse_incomes_annual_total bytea,
   requester_allowances bytea,
   requester_pension_plan varchar(255),
   spouse_allowances bytea,
   income_tax bytea,
   requester_investment_income bytea,
   nationality varchar(32),
   requester_pensions bytea,
   property_taxes bytea,
   spouse_employer varchar(50),
   tutor varchar(255),
   donations_values_total bytea,
   spouse_pension_plan varchar(255),
   alimonies bytea,
   spouse_occupation varchar(50),
   bonds_amount bytea,
   spouse_investment_income bytea,
   social_security_key_number varchar(2),
   spouse_net_income bytea,
   france_arrival_date timestamp,
   requester_net_income bytea,
   professional_taxes bytea,
   shares_amount bytea,
   tutor_presence bool,
   local_rate bytea,
   real_assets_values_total bytea,
   spouse_social_security_number varchar(13),
   primary key (id)
);
alter table domestic_help_request owner to cvq95;

create table dhr_previous_dwelling (
   id int8 not null,
   previous_dwelling_arrival_date timestamp,
   previous_dwelling_address_id int8,
   previous_dwelling_departure_date timestamp,
   domestic_help_request_id int8,
   primary key (id)
);
alter table dhr_previous_dwelling owner to cvq95;

create table dhr_real_asset (
   id int8 not null,
   real_asset_value bytea,
   real_asset_address_id int8,
   real_asset_net_floor_area bytea,
   real_asset_cadastre varchar(255),
   domestic_help_request_id int8,
   primary key (id)
);
alter table dhr_real_asset owner to cvq95;

create table dhr_donation (
   id int8 not null,
   donation_date timestamp,
   donation_notary_first_name varchar(38),
   donation_beneficiary_name varchar(38),
   donation_beneficiary_first_name varchar(38),
   donation_value bytea,
   donation_notary_name varchar(38),
   donation_notary_address_id int8,
   donation_asset_place varchar(200),
   donation_asset varchar(255),
   domestic_help_request_id int8,
   primary key (id)
);
alter table dhr_donation owner to cvq95;

alter table dhr_personal_estate_and_saving add constraint FK5EFB37677EAD7F68 foreign key (domestic_help_request_id) references domestic_help_request;
alter table domestic_help_request add constraint FK3C00811289821EF foreign key (tutor_address_id) references adress;
alter table domestic_help_request add constraint FK3C0081123B4E61AF foreign key (current_dwelling_address_id) references adress;
alter table domestic_help_request add constraint FK3C0081124E875BF8 foreign key (spouse_information_id) references adult;
alter table domestic_help_request add constraint FK3C008112D1B foreign key (id) references request;
alter table domestic_help_request add constraint FK3C0081124C56A0A0 foreign key (spouse_employer_address_id) references adress;
alter table dhr_previous_dwelling add constraint FKB0B96E277EAD7F68 foreign key (domestic_help_request_id) references domestic_help_request;
alter table dhr_previous_dwelling add constraint FKB0B96E27909EB42D foreign key (previous_dwelling_address_id) references adress;
alter table dhr_real_asset add constraint FK6AA7D9807EAD7F68 foreign key (domestic_help_request_id) references domestic_help_request;
alter table dhr_real_asset add constraint FK6AA7D9803C8FCE76 foreign key (real_asset_address_id) references adress;
alter table dhr_donation add constraint FK917250437CF5D9A3 foreign key (donation_notary_address_id) references adress;
alter table dhr_donation add constraint FK917250437EAD7F68 foreign key (domestic_help_request_id) references domestic_help_request;


-- update handicap allowance request

create table handicap_allowance_request (
   id int8 not null,
   legal_representative_address_id int8,
   needs varchar(255),
   writing_help bool,
   legal_representative bool,
   hopes_and_needs bool,
   helper_responsability varchar(255),
   legal_representative_family_relationship varchar(255),
   helper_name varchar(38),
   legal_representative_name varchar(38),
   comments varchar(255),
   legal_representative_firstame varchar(38),
   hopes varchar(255),
   legal_representative_phone varchar(10),
   primary key (id)
);
alter table handicap_allowance_request owner to cvq95;
   
alter table handicap_allowance_request add constraint FKF20630A1D1B foreign key (id) references request;
alter table handicap_allowance_request add constraint FKF20630A15C37F22 foreign key (legal_representative_address_id) references adress;

-- some columns size updates

alter table domestic_help_request alter column spouse_nationality type varchar(32);

alter table remote_support_request alter column trustee_first_name type varchar(38);
alter table remote_support_request alter column trustee_name type varchar(38);
alter table remote_support_request alter column contact_first_name type varchar(38);
alter table remote_support_request alter column contact_name type varchar(38);

alter table domestic_help_request rename column current_dwelling to current_dwelling_type ;

-- fix for requests who have orphan local referential data
update local_referential_data set name = 'Unknown' where name = '';
alter table local_referential_data alter column name set not null;

-- removed unused field in place reservation request
alter table place_reservation_request drop column authorized_number_of_places_per_reservation;
