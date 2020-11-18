CREATE TABLE board(
no int AUTO_INCREMENT,
title VARCHAR(100),
content VARCHAR(200),
author VARCHAR(100),
nal VARCHAR(100),
readcount int,
primary key(no)
)

select * from board

insert into board (title,content,author,nal,readcount) values('title','content','author','2020-11-17',0);

drop table board