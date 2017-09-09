drop table if exists BITEMPORAL_ORDER;

create table BITEMPORAL_ORDER
(
    ORDER_ID int not null,
    ORDER_DATE timestamp,
    USER_ID int,
    DESCRIPTION varchar(50),
    STATE varchar(20),
    TRACKING_ID varchar(15),
    FROM_Z timestamp not null,
    THRU_Z timestamp not null,
    IN_Z timestamp not null,
    OUT_Z timestamp not null
);

