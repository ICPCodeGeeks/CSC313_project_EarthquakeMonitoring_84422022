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
area_covered float(6,2) unsigned,
GID bigint,
foreign key(GID) references galamsey(GID)
);
drop table observatory;