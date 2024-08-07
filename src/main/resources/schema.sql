
-- use testdb;
-- show full columns from todo;

drop table if exists todo;
drop table if exists member;

create table todo
    ( id bigint not null auto_increment COMMENT 'TODO 번호',
      userid varchar(255) not null COMMENT 'TODO 아이디',
      description varchar(255) not null COMMENT 'TODO 목록',
      targetDate date  COMMENT 'TODO 목표날짜',
      done boolean   COMMENT 'TODO 완료여부',
      primary key(id)
     );

create table member
( userid    varchar(255) not null COMMENT '아이디',
  password  varchar(255) not null COMMENT '비밀번호',
  username varchar(255) not null COMMENT 'TODO 작성자',
  role varchar(255) default 'USER' not null COMMENT '역할',
  primary key(userid)
);