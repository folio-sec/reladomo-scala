drop table if exists PRODUCT_SYN;

create table PRODUCT_SYN
(
    PROD_ID int not null,
    SYN_TYPE varchar(255) not null,
    SYN_VAL varchar(255)
);

