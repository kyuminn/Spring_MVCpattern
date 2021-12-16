create sequence member_seq start with 1 increment by 1 minvalue 1 maxvalue 99999;

create table member(
	id primary key,
	email varchar2(255) unique,
	password varchar2(100),
	name varchar2(100),
	regdate date);
	
insert into member (id,email,password,name,regdate) values (member_seq.nextval,'garnet2929@naver.com','1234',sysdate);