DROP DATABASE IF EXISTS InterfaceTest;
CREATE DATABASE InterfaceTest;
USE InterfaceTest;
set SQL_SAFE_UPDATES = 0;

create table test(
	name varchar(20),
    age int    
);

insert into test values
	( '유재석', 10 ),
    ( '강호동', 20 ),
    ( '박명수', 30 ),
    ( '신동엽', 40 );
    
select * from test;