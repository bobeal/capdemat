create table purchase_item_specific_data (
   id int8 not null,
   value varchar(255),
   key varchar(255) not null,
   primary key (id, key)
);
alter table purchase_item_specific_data add constraint FK455E9669D1B foreign key (id) references purchase_item;


