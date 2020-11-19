--schoolpj관련
CREATE TABLE schoolpj(
 Name varchar2(20),
 Age number(3),
 Value varchar2(20),
 Code number(1) constraint code_person references person(Code)
)


drop table schoolpj
select * from schoolpj
insert into person values(2,'교수')


--Person관련
CREATE TABLE person(
	Code number(1) primary key,
	dept varchar2(20)
)
drop table person 
select * from person