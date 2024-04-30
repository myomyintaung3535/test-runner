create table if not exists Run (
    id int not null,
    title varchar(225) not null,
    started_on timestamp not null,
    complete_on timestamp not null,
    miles int not null,
    location varchar(45) not null,
    primary key (id)
);