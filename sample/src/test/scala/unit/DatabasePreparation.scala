package unit

trait DatabasePreparation {

  def initializeSimpleBankDatabase() = {
    import scalikejdbc._
    Class.forName("org.h2.Driver")
    ConnectionPool.add('simplebank, "jdbc:h2:mem:simplebank;MODE=MySQL", "user", "pass")
    implicit val session = NamedAutoSession('simplebank)
    sql"""
create table CUSTOMER
(
    CUSTOMER_ID int not null,
    FIRST_NAME varchar(64) not null,
    LAST_NAME varchar(64) not null,
    COUNTRY varchar(48)
);
alter table CUSTOMER add constraint CUSTOMER_PK primary key (CUSTOMER_ID);
create table CUSTOMER_ACCOUNT
(
    ACCOUNT_ID int not null,
    CUSTOMER_ID int not null,
    ACCOUNT_NAME varchar(48) not null,
    ACCOUNT_TYPE varchar(16) not null,
    AREA_ID int,
    BALANCE float8
);
alter table CUSTOMER_ACCOUNT add constraint CUSTOMER_ACCOUNT_fk_0 foreign key (
CUSTOMER_ID
) references CUSTOMER(
CUSTOMER_ID
);
alter table CUSTOMER_ACCOUNT add constraint CUSTOMER_ACCOUNT_PK primary key (ACCOUNT_ID);
create index CUSTOMER_ACCOUNT_IDX0 on CUSTOMER_ACCOUNT(CUSTOMER_ID);
""".execute.apply()
  }

  def initializePeopleDatabase() = {
    import scalikejdbc._
    Class.forName("org.h2.Driver")
    ConnectionPool.add('people, "jdbc:h2:mem:people;MODE=MySQL", "user", "pass")
    implicit val session = NamedAutoSession('people)
    sql"""
create table PERSON
(
    PERSON_ID int not null,
    FIRST_NAME varchar(64) not null,
    LAST_NAME varchar(64) not null,
    COUNTRY varchar(48) not null
);
alter table PERSON add constraint PERSON_PK primary key (PERSON_ID);

create table PET
(
    PET_ID int not null,
    NAME varchar(64) not null,
    OWNER_ID int
);
alter table PET add constraint PET_PK primary key (PET_ID);
""".execute.apply()
  }

  def initializeBiTemporalDatabase() = {
    import scalikejdbc._
    Class.forName("org.h2.Driver")
    ConnectionPool.add('bitemporal, "jdbc:h2:mem:bitemporal;MODE=MySQL", "user", "pass")
    implicit val session = NamedAutoSession('bitemporal)
    sql"""
create table PRODUCT
(
    PROD_ID int not null,
    CODE varchar(255),
    PROD_DESC varchar(255),
    MANUFACTURER_ID int,
    DAILY_PRODUCTION_RATE float4
);
alter table PRODUCT add constraint PRODUCT_PK primary key (PROD_ID);

create table PRODUCT_SYN
(
    PROD_ID int not null,
    SYN_TYPE varchar(255) not null,
    SYN_VAL varchar(255)
);
alter table PRODUCT_SYN add constraint PRODUCT_SYN_fk_0 foreign key (
    PROD_ID
)
references PRODUCT(
    PROD_ID
);
alter table PRODUCT_SYN add constraint PRODUCT_SYN_PK primary key (PROD_ID, SYN_TYPE);

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
alter table BITEMPORAL_ORDER add constraint BITEMPORAL_ORDER_PK primary key (ORDER_ID, THRU_Z, OUT_Z);
create unique index BITEMPORAL_ORDER_IDX0 on BITEMPORAL_ORDER(TRACKING_ID, THRU_Z, OUT_Z);
create index BITEMPORAL_ORDER_IDX1 on BITEMPORAL_ORDER(USER_ID, THRU_Z, OUT_Z);
create index BITEMPORAL_ORDER_IDX2 on BITEMPORAL_ORDER(STATE, THRU_Z, OUT_Z);
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

alter table BITEMPORAL_ORDER_ITEM add constraint BITEMPORAL_ORDER_ITEM_fk_0 foreign key (
    PRODUCT_ID
)
references PRODUCT(
    PROD_ID
);

alter table BITEMPORAL_ORDER_ITEM add constraint BITEMPORAL_ORDER_ITEM_PK primary key (ID, THRU_Z, OUT_Z);
create index BITEMPORAL_ORDER_ITEM_IDX0 on BITEMPORAL_ORDER_ITEM(PRODUCT_ID, THRU_Z, OUT_Z);
create index BITEMPORAL_ORDER_ITEM_IDX1 on BITEMPORAL_ORDER_ITEM(ORDER_ID, THRU_Z, OUT_Z);
create table BITEMPORAL_ORDER_ITEM_STATUS
(
    ORDER_ITEM_ID int not null,
    STATUS int,
    LAST_USER varchar(20),
    LAST_UPDATE_TIME timestamp,
    IN_Z timestamp not null,
    OUT_Z timestamp not null,
    FROM_Z timestamp not null,
    THRU_Z timestamp not null
);
alter table BITEMPORAL_ORDER_ITEM_STATUS add constraint BITEMPORAL_ORDER_ITEM_STATUS_PK primary key (ORDER_ITEM_ID, THRU_Z, OUT_Z);

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

alter table BITEMPORAL_ORDER_STATUS add constraint BITEMPORAL_ORDER_STATUS_PK primary key (ORDER_ID, THRU_Z, OUT_Z);
create index BITEMPORAL_ORDER_STATUS_IDX0 on BITEMPORAL_ORDER_STATUS(ORDER_ID, ORDER_ID, THRU_Z, OUT_Z);

create table BITEMPORAL_ORDER_TO_ORDER_STATUS
(
    ORDER_ID int not null,
    STATUS_ID int not null,
    IN_Z timestamp not null,
    OUT_Z timestamp not null,
    FROM_Z timestamp not null,
    THRU_Z timestamp not null
);
alter table BITEMPORAL_ORDER_TO_ORDER_STATUS add constraint BITEMPORAL_ORDER_TO_ORDER_STATUS_PK primary key (ORDER_ID, STATUS_ID, THRU_Z, OUT_Z);
create index BITEMPORAL_ORDER_TO_ORDER_STATUS_IDX0 on BITEMPORAL_ORDER_TO_ORDER_STATUS(ORDER_ID, THRU_Z, OUT_Z);
create index BITEMPORAL_ORDER_TO_ORDER_STATUS_IDX1 on BITEMPORAL_ORDER_TO_ORDER_STATUS(STATUS_ID, THRU_Z, OUT_Z);

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
alter table FROZEN_POSITION add constraint FROZEN_POSITION_fk_0 foreign key (
    PROD_SEC_ID_I
)
references PRODUCT(
    PROD_ID
);
alter table FROZEN_POSITION add constraint FROZEN_POSITION_PK primary key (ACCT_NBR_C, PROD_SEC_ID_I, POS_TYP_C, THRU_Z, OUT_Z);
create index FROZEN_POSITION_IDX0 on FROZEN_POSITION(PROD_SEC_ID_I, THRU_Z, OUT_Z);
""".execute.apply()

  }
}
