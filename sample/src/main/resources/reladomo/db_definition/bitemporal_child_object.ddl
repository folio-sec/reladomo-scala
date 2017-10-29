drop table if exists bitemporal_child_object;

create table bitemporal_child_object
(
    id int not null,
    name varchar(255) not null,
    state int,
    parent_object_id int,
    from_at timestamp not null,
    thru_at timestamp not null,
    in_at timestamp not null,
    out_at timestamp not null
);

