drop table if exists BITEMPORAL_ORDER_TO_ORDER_STATUS;

create table BITEMPORAL_ORDER_TO_ORDER_STATUS
(
    ORDER_ID int not null,
    STATUS_ID int not null,
    IN_Z timestamp not null,
    OUT_Z timestamp not null,
    FROM_Z timestamp not null,
    THRU_Z timestamp not null
);

