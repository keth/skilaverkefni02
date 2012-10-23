CREATE TABLE ru_users
(
	id int Identity (1, 1) primary key NOT NULL,
	username varchar(128) unique,
	firstName varchar(128),
	lastName varchar(128),
	email varchar(256),
	password varchar(128),
	gender varchar(128)
)
