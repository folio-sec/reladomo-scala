drop table if exists parent_object;

create table parent_object
(
    id int not null,
    name varchar(255) not null,
    in_at timestamp not null,
    out_at timestamp not null
);

