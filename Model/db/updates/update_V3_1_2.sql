alter table agent add column active bool;
update agent set active = true;

alter table recreation_center add address varchar(255);

alter table school drop column director_name;
alter table school drop column director_title;
alter table school drop column restaurant_price;

alter table recreation_center drop column description;

alter table agent add column last_name varchar(255);
alter table agent add column first_name varchar(255);
