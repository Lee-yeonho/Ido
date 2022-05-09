drop table member if exists
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table member (mbr_no IDENTITY not null, id varchar(255),email varchar(255), age int, primary key(mbr_no))