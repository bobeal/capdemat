
    alter table account 
        drop constraint FKB9D38A2D1EC32CFC;

    alter table account 
        drop constraint FKB9D38A2D3575AFD6;

    alter table account_detail 
        drop constraint FK196C2EA3F624C47E;

    alter table account_detail 
        drop constraint FK196C2EA35EA1AD4A;

    alter table capwebct_association_summary 
        drop constraint FKF44375DC338E0F2C;

    alter table capwebct_individual 
        drop constraint FKB084425A4B95144;

    alter table contract 
        drop constraint FKDE351112674D4DEA;

    alter table contract 
        drop constraint FKDE3511121EC32CFC;

    alter table contract 
        drop constraint FKDE3511123575AFD6;

    alter table contract_detail 
        drop constraint FK3FD50C1EF624C47E;

    alter table contract_detail 
        drop constraint FK3FD50C1E28AA4E0;

    alter table external_application_broker 
        drop constraint FK839CD69CC0CF33BD;

    alter table external_family_account 
        drop constraint FKAB778346338E0ED6;

    alter table external_family_account 
        drop constraint FKAB778346C0CF3367;

    alter table external_import_audit 
        drop constraint FK94EB2AB54F731E9E;

    alter table external_individual 
        drop constraint FKC1D4D78D3575AFD6;

    alter table external_individual 
        drop constraint FKC1D4D78D4B60FB31;

    alter table invoice 
        drop constraint FK74D6432DF624C47E;

    alter table invoice 
        drop constraint FK74D6432D1EC32CFC;

    alter table invoice 
        drop constraint FK74D6432D3575AFD6;

    alter table invoice_detail 
        drop constraint FK119755A36BF85F4A;

    drop table account;

    drop table account_detail;

    drop table agent;

    drop table capwebct_association_summary;

    drop table capwebct_family_account;

    drop table capwebct_individual;

    drop table contract;

    drop table contract_detail;

    drop table external_application;

    drop table external_application_broker;

    drop table external_family_account;

    drop table external_import_audit;

    drop table external_individual;

    drop table invoice;

    drop table invoice_detail;

    drop table payment;

    drop sequence hibernate_sequence;

    create table account (
        id int8 not null,
        account_id varchar(255),
        account_value int4,
        account_label varchar(255),
        account_date timestamp,
        broker varchar(255),
        efa_fk int8 not null,
        external_family_account_fk int8 not null,
        primary key (id)
    );

    create table account_detail (
        id int8 not null,
        holder_name varchar(255),
        holder_surname varchar(255),
        value int4,
        payment_fk int8,
        account_fk_id int8,
        account_detail_index int4,
        primary key (id)
    );

    create table agent (
        id int8 not null,
        login varchar(255) unique,
        first_name varchar(255),
        last_name varchar(255),
        is_admin bool,
        primary key (id)
    );

    create table capwebct_association_summary (
        capwebct_family_account_id int8 not null,
        external_application_id int8 not null,
        state varchar(255) not null,
        primary key (capwebct_family_account_id, external_application_id, state)
    );

    create table capwebct_family_account (
        id int8 not null,
        capwebct_family_account_id int8,
        address varchar(255),
        responsible_full_name varchar(255),
        primary key (id)
    );

    create table capwebct_individual (
        id int8 not null,
        capwebct_individual_id int8,
        first_name varchar(255),
        last_name varchar(255),
        child bool,
        responsible bool,
        capwebct_family_account_fk_id int8 not null,
        primary key (id)
    );

    create table contract (
        id int8 not null,
        contract_id varchar(255),
        contract_label varchar(255),
        contract_value int4,
        contract_date timestamp,
        buy_price int4,
        buy_min int4,
        buy_max int4,
        broker varchar(255),
        efa_fk int8 not null,
        ei_fk int8,
        external_family_account_fk int8 not null,
        primary key (id)
    );

    create table contract_detail (
        id int8 not null,
        quantity int4,
        price int4,
        amount int4,
        payment_fk int8,
        contract_fk_id int8,
        contract_detail_index int4,
        primary key (id)
    );

    create table external_application (
        id int8 not null,
        label varchar(255) not null,
        description varchar(255),
        primary key (id)
    );

    create table external_application_broker (
        external_application_id int8 not null,
        broker varchar(255) not null,
        primary key (external_application_id, broker)
    );

    create table external_family_account (
        id int8 not null,
        external_family_account_id varchar(255),
        address varchar(255),
        external_application_fk int8 not null,
        capwebct_family_account_fk int8,
        primary key (id)
    );

    create table external_import_audit (
        id int8 not null,
        import_type varchar(255),
        external_data_type bytea,
        external_application_label varchar(255),
        broker varchar(255),
        date timestamp,
        agent_fk int8,
        primary key (id)
    );

    create table external_individual (
        id int8 not null,
        external_individual_id varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        responsible bool,
        capwebct_individual_fk int8,
        external_family_account_fk int8 not null,
        primary key (id)
    );

    create table invoice (
        id int8 not null,
        invoice_id varchar(255),
        invoice_value int4,
        invoice_label varchar(255),
        invoice_date timestamp,
        invoice_expiration_date timestamp,
        invoice_payment_date timestamp,
        invoice_payed bool,
        broker varchar(255),
        efa_fk int8 not null,
        payment_fk int8,
        external_family_account_fk int8 not null,
        primary key (id)
    );

    create table invoice_detail (
        id int8 not null,
        child_name varchar(255),
        child_surname varchar(255),
        label varchar(255),
        unit_price int4,
        quantity int4,
        value int4,
        invoice_fk_id int8,
        invoice_detail_index int4,
        primary key (id)
    );

    create table payment (
        id int8 not null,
        payment_type varchar(255),
        payment_date timestamp,
        payment_amount int4,
        payment_ack varchar(255),
        cvq_ack varchar(255),
        cfa_id int8,
        broker varchar(255),
        exported bool,
        primary key (id)
    );

    alter table account 
        add constraint FKB9D38A2D1EC32CFC 
        foreign key (efa_fk) 
        references external_family_account;

    alter table account 
        add constraint FKB9D38A2D3575AFD6 
        foreign key (external_family_account_fk) 
        references external_family_account;

    alter table account_detail 
        add constraint FK196C2EA3F624C47E 
        foreign key (payment_fk) 
        references payment;

    alter table account_detail 
        add constraint FK196C2EA35EA1AD4A 
        foreign key (account_fk_id) 
        references account;

    alter table capwebct_association_summary 
        add constraint FKF44375DC338E0F2C 
        foreign key (capwebct_family_account_id) 
        references capwebct_family_account;

    alter table capwebct_individual 
        add constraint FKB084425A4B95144 
        foreign key (capwebct_family_account_fk_id) 
        references capwebct_family_account;

    alter table contract 
        add constraint FKDE351112674D4DEA 
        foreign key (ei_fk) 
        references external_individual;

    alter table contract 
        add constraint FKDE3511121EC32CFC 
        foreign key (efa_fk) 
        references external_family_account;

    alter table contract 
        add constraint FKDE3511123575AFD6 
        foreign key (external_family_account_fk) 
        references external_family_account;

    alter table contract_detail 
        add constraint FK3FD50C1EF624C47E 
        foreign key (payment_fk) 
        references payment;

    alter table contract_detail 
        add constraint FK3FD50C1E28AA4E0 
        foreign key (contract_fk_id) 
        references contract;

    alter table external_application_broker 
        add constraint FK839CD69CC0CF33BD 
        foreign key (external_application_id) 
        references external_application;

    alter table external_family_account 
        add constraint FKAB778346338E0ED6 
        foreign key (capwebct_family_account_fk) 
        references capwebct_family_account;

    alter table external_family_account 
        add constraint FKAB778346C0CF3367 
        foreign key (external_application_fk) 
        references external_application;

    alter table external_import_audit 
        add constraint FK94EB2AB54F731E9E 
        foreign key (agent_fk) 
        references agent;

    alter table external_individual 
        add constraint FKC1D4D78D3575AFD6 
        foreign key (external_family_account_fk) 
        references external_family_account;

    alter table external_individual 
        add constraint FKC1D4D78D4B60FB31 
        foreign key (capwebct_individual_fk) 
        references capwebct_individual;

    alter table invoice 
        add constraint FK74D6432DF624C47E 
        foreign key (payment_fk) 
        references payment;

    alter table invoice 
        add constraint FK74D6432D1EC32CFC 
        foreign key (efa_fk) 
        references external_family_account;

    alter table invoice 
        add constraint FK74D6432D3575AFD6 
        foreign key (external_family_account_fk) 
        references external_family_account;

    alter table invoice_detail 
        add constraint FK119755A36BF85F4A 
        foreign key (invoice_fk_id) 
        references invoice;

    create sequence hibernate_sequence;
