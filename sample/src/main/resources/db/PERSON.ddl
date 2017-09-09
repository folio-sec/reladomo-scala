drop table if exists PERSON;

create table PERSON
(
    PERSON_ID int not null,
    FIRST_NAME varchar(64) not null,
    LAST_NAME varchar(64) not null,
    COUNTRY varchar(48) not null
);

