drop table if exists CUSTOMER_ACCOUNT;

create table CUSTOMER_ACCOUNT
(
    ACCOUNT_ID int not null,
    CUSTOMER_ID int not null,
    ACCOUNT_NAME varchar(48) not null,
    ACCOUNT_TYPE varchar(16) not null,
    BALANCE float8
);

