drop table if exists PRODUCT;

create table PRODUCT
(
    PROD_ID int not null,
    CODE varchar(255),
    PROD_DESC varchar(255),
    MANUFACTURER_ID int,
    DAILY_PRODUCTION_RATE float4
);

