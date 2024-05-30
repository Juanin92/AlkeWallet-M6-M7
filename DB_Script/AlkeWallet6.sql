create database if not exists alkewallet6;
use alkewallet6;

create table users(
	user_id int primary key not null auto_increment,
	user_name varchar(20) not null,
    user_surname varchar(40) not null,
    email varchar(50) not null unique,
    pass varchar(6) not null
);

INSERT INTO users (user_name, user_surname, email, pass)
VALUES('admin', 'admin', 'admin@admin', '123456');

SELECT * FROM users;

create table accounts(
	account_id int not null auto_increment primary key,
    balance decimal(10,2) not null,
    balance_foreign decimal(10,2) not null,
    user_id int not null,
    foreign key (user_id) references users(user_id)
);
