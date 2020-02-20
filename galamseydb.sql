
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


create table observatory(
OID bigint auto_increment primary key,
obs_name varchar(20) not null,
country_name varchar(50) not null,
year_started mediumint(4) not null,
area_covered float(6,2) unsigned
);
create table galamsey_observatory(
	OID bigint,
	GID bigint,
	primary key(OID, GID),
    foreign key(OID) references observatory(OID),
    foreign key(GID) references galamsey(GID)

);


insert into galamsey values(1,"Brown",3,16.12345,-35.67890,2016),
(2,"Yellow",2,23.54321,-35.09876,2013),(3,"Green",1,18.34521,45.12390,2007),
(4,"Yellow",2,50.62345,12.65490,2019);

insert into observatory values(1,"Kante","Nigeria",2012,30.52),
(2,"Rolo","Ghana",2006,54.76),(3,"Cholo","Niger",2015,12.97),
(4,"Sanga","Liberia",2008,23.94);
insert into galamsey_observatory values(1,1),(1,2),(2,3),(1,4),(2,2),(4,3);
insert into galamsey_observatory(OID,GID) values(1,11);
insert into galamsey values(4,"Yellow",2,50.62345,12.65490,2019);
insert into galamsey_observatory values(1,4);
SELECT
    galamsey.GID,
    galamsey.veg_col,
    galamsey.col_val,
    galamsey.latitude,
    galamsey.longitude,
    galamsey.latitude,
    galamsey.year_started
FROM
   observatory
INNER JOIN
    galamsey_observatory USING (OID)
INNER JOIN
    galamsey USING (GID)
WHERE
	galamsey.col_val> 1 and
    observatory.obs_name='Kante'
ORDER BY
    galamsey_observatory.OID,
    observatory.obs_name;
