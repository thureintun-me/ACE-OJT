create table student(
    student_id varchar(10) primary key not null,
    student_name varchar(30) not null,
    class_name varchar(45) not null,
    register_date varchar(45) ,
    status varchar(45) not null
);

create table user(
    user_id varchar(10) primary key not null,
    user_name varchar(30) not null,
    password varchar(30) not null
);

create table class(
    class_id varchar(10) primary key not null,
    class_name varchar(30) not null
);