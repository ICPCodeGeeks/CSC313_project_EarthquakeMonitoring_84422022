create schema galamseydb;
use galamseydb;

create table galamsey(
GID bigint auto_increment,
veg_col varchar(7) not null,
col_val tinyint not null,
latitude double(10,8) not null,
longitude double(10,8) not null,
year_started mediumint(4) not null,
primary key(GID)
);
drop table galamsey;

create table observatory(
OID bigint auto_increment primary key,
obs_name varchar(20) not null,
country_name varchar(50) not null,
year_started mediumint(4) not null,
area_covered float(6,2) unsigned
);
create table galamsey_observatory(
	GID bigint,
    OID bigint,
	primary key(GID, OID),
    foreign key(GID) references galamsey(GID),
    foreign key(OID) references observatory(OID)
);
drop table observatory;

insert into galamsey values(6,"Yellow",2,16.12345,-35.67890,2016),
(7,"Yellow",2,23.54321,-35.09876,2013),(8,"Yellow",2,18.34521,45.12390,2007),
(9,"Yellow",2,50.62345,12.65490,2019);

insert into observatory values(1,"X35","Nigeria",2012,30.52),
(2,"X35","Ghana",2006,54.76),(3,"X35","Niger",2015,12.97),
(4,"X35","Liberia",2008,23.94);

insert into galamsey_observatory values(3,1),(4,1),(2,2),(6,1),(4,2),(1,4),(9,1),(7,1);

select avg(col_val) from galamsey;
select max(( 
select count(col_val) from galamsey where col_val=1)and
(select count(col_val) from galamsey where col_val=2) and
(select count(col_val) from galamsey where col_val=3)) as 'Max color value' from galamsey;
delete from galamsey where GID = 9;
select max(count(col_val)) from galamsey;