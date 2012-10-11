CREATE TABLE ru_boards
(
  boardname varchar(128),
  category varchar(128),
  username varchar(128),
  primary key (boardname, username)
)
