drop table if exists CUSTOMER;

create table CUSTOMER
(
    CUSTOMER_ID int not null,
    FIRST_NAME varchar(64) not null,
    LAST_NAME varchar(64) not null,
    COUNTRY varchar(48)
);

