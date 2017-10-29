drop table if exists OBJECT_SEQUENCE;

create table OBJECT_SEQUENCE
(
    SEQUENCE_NAME varchar(64) not null,
    NEXT_VALUE bigint
);

