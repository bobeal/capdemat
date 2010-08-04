create table tbr_ticket (
    id int8 not null,
    event_name varchar(255),
    event_place varchar(255),
    place_category_id int8,
    place_number bytea,
    price numeric(19, 2),
    fare_type varchar(255),
    place_category varchar(255),
    event_date timestamp,
    ticket_booking_request_id int8,
    tbr_ticket_index int4,
    primary key (id)
);

create table ticket_booking_request (
    id int8 not null,
    rules_and_regulations_acceptance bool,
    subscriber_last_name varchar(255),
    total_price numeric(19, 2),
    subscriber_number varchar(255),
    subscriber_first_name varchar(255),
    is_subscriber bool,
    payment_reference varchar(255),
    primary key (id)
);

create table ticket_entertainment (
    id int8 not null,
    external_id varchar(255),
    information varchar(255),
    name varchar(255),
    link varchar(255),
    category varchar(255),
    logo bytea,
    primary key (id)
);

create table ticket_event (
    id int8 not null,
    external_id varchar(255),
    date timestamp,
    booking_start timestamp,
    booking_end timestamp,
    place varchar(255),
    link varchar(255),
    address varchar(255),
    ticket_entertainment_id int8 not null,
    primary key (id)
);

create table ticket_fare (
    id int8 not null,
    external_id varchar(255),
    name varchar(255),
    price float4,
    with_subscriber bool,
    ticket_place_category_id int8,
    fares_index int4,
    primary key (id)
);

create table ticket_place_category (
    id int8 not null,
    external_id varchar(255),
    name varchar(255),
    place_number int4,
    booked_place_number int4,
    ticket_event_id int8,
    place_categories_index int4,
    primary key (id)
);

alter table tbr_ticket add constraint FK231823E7CFCF80C3 
    foreign key (ticket_booking_request_id) references ticket_booking_request;

alter table ticket_event add constraint FK9B59C7A7E386AF5C 
    foreign key (ticket_entertainment_id) references ticket_entertainment;

alter table ticket_fare add constraint FK15872D81914D9745 
    foreign key (ticket_place_category_id) references ticket_place_category;

alter table ticket_place_category add constraint FK228856C92803C01C 
    foreign key (ticket_event_id) references ticket_event;

create table ticket_subscriber (
    id int8 not null,
    number varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
);

create table ticket_subscriber_limits (
    id int8 not null,
    value int4,
    key varchar(255) not null,
    primary key (id, key)
);

alter table ticket_subscriber_limits add constraint FK2A415CAF42EA14 
    foreign key (id) references ticket_subscriber;

-- Remove old PlaceReservationRequest
drop table place_reservation_data;
drop table place_reservation_request;
drop table place_reservation_request_place_reservation;
drop table ticket_type_selection;
