
declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='TEST_CITY';
if v_num > 0 then
execute immediate 'drop table TEST_CITY';
end if;
end;
/


create table TEST_CITY
(
  id      VARCHAR2(32),
  name    VARCHAR2(32),
  country VARCHAR2(32),
  state   VARCHAR2(32)
);

insert into TEST_CITY values(1,'San Francisco','US','0'); 
insert into TEST_CITY values(2,'San Francisco','CN','0'); 
commit;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='TEST_HOTEL';
if v_num > 0 then
execute immediate 'drop table TEST_HOTEL';
end if;
end;
/

create table TEST_HOTEL
(
  name    VARCHAR2(32),
  address VARCHAR2(32),
  zip     VARCHAR2(32),
  city    VARCHAR2(32)
);


insert into TEST_HOTEL (NAME, ADDRESS, ZIP, CITY)
values ('七天', '湖北武汉', '430040', '1');

insert into TEST_HOTEL (NAME, ADDRESS, ZIP, CITY)
values ('华美达', '武汉洪山', '430070', '2');


commit;
