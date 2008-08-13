alter table consumption drop constraint FKCD71F39B6038353E;
drop table consumption;
alter table agent add column password varchar(255);
alter table individual add column public_key varchar(50) unique;
