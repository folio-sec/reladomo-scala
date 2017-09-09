drop table if exists BITEMPORAL_ORDER_STATUS;

create table BITEMPORAL_ORDER_STATUS
(
    ORDER_ID int not null,
    STATUS int,
    LAST_USER varchar(20),
    LAST_UPDATE_TIME timestamp,
    IN_Z timestamp not null,
    OUT_Z timestamp not null,
    FROM_Z timestamp not null,
    THRU_Z timestamp not null
);

