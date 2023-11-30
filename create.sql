create table bill_sequence
(
    next_val bigint null
);

create table student_sequence
(
    next_val bigint null
);

create table studentpayment_sequence
(
    next_val bigint null
);

create table students
(
    student_id      bigint       not null
        primary key,
    cgpa            float        null,
    total_credits   int          null,
    domain          varchar(255) null,
    email           varchar(255) null,
    first_name      varchar(255) null,
    graduation_year int          null,
    last_name       varchar(255) null,
    password        varchar(255) null,
    photograph_path varchar(255) null,
    placement_id    bigint       null,
    roll_number     int          null,
    specialisation  varchar(255) null
);

create table bills
(
    id          bigint       not null
        primary key,
    amount      float        not null,
    bill_date   date         not null,
    deadline    date         null,
    description varchar(255) null,
    student_id  bigint       null,
    paid        bit          null,
    constraint FK50pgvyni32dj5bi4wdj6lh0vu
        foreign key (student_id) references students (student_id)
);

create table student_payment
(
    id           bigint       not null
        primary key,
    amount       float        not null,
    description  varchar(255) null,
    payment_date date         not null,
    bill_id      bigint       null,
    student_id   bigint       null,
    constraint FK89o422fd8lxotfgx7q3ruu58
        foreign key (bill_id) references bills (id),
    constraint FKt2px4t3p1ovu0ta2w64ptofvp
        foreign key (student_id) references students (student_id)
);


