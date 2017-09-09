drop table if exists BITEMPORAL_ORDER_ITEM;

create table BITEMPORAL_ORDER_ITEM
(
    ID int not null,
    ORDER_ID int,
    PRODUCT_ID int,
    QUANTITY float8,
    ORIGINAL_PRICE float8,
    DISCOUNT_PRICE float8,
    STATE varchar(20),
    IN_Z timestamp not null,
    OUT_Z timestamp not null,
    FROM_Z timestamp not null,
    THRU_Z timestamp not null
);

