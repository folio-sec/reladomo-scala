drop table if exists FROZEN_POSITION;

create table FROZEN_POSITION
(
    ACCT_NBR_C varchar(20) not null,
    PROD_SEC_ID_I int not null,
    POS_TYP_C int not null,
    POS_QUANTITY_M float8,
    FROM_Z timestamp not null,
    THRU_Z timestamp not null,
    IN_Z timestamp not null,
    OUT_Z timestamp not null
);

