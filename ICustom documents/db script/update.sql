


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_ROLES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_ROLES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_ROLES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_AUTHORITIES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_AUTHORITIES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_AUTHORITIES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_RESOURCES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_RESOURCES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_RESOURCES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;



-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_AUTHORITIES_RESOURCES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_AUTHORITIES_RESOURCES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_AUTHORITIES_RESOURCES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_USERS_ROLES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_USERS_ROLES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_USERS_ROLES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_ROLES_AUTHORITIES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_ROLES_AUTHORITIES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_ROLES_AUTHORITIES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_USERS_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_USERS_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_USERS_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_NAVIGATION_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_NAVIGATION_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_NAVIGATION_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_LOOKUP_CLASSIFY_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_LOOKUP_CLASSIFY_S';
end if;
end;
/
-- 20160814
-- Create sequence 
create sequence SYS_LOOKUP_CLASSIFY_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_LOOKUP_ITEM_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_LOOKUP_ITEM_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_LOOKUP_ITEM_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_REGISTER_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_REGISTER_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_REGISTER_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_LANGUAGE_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_LANGUAGE_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_LANGUAGE_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_REGISTER_T';
if v_num > 0 then
execute immediate 'drop table SYS_REGISTER_T';
end if;
end;
/
-- Create table
create table SYS_REGISTER_T
(
  reg_id           NUMBER(30) not null,
  reg_name         VARCHAR2(60) not null,
  reg_code         VARCHAR2(60),
  reg_desc         VARCHAR2(200),
  reg_value        VARCHAR2(200),
  reg_status       INTEGER default 1,
  parent_path      VARCHAR2(200),
  parent_id        NUMBER(30),
  order_code  INTEGER default 1,
  created_user NUMBER,
  created_date DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1) default 1,
  CONSTRAINT SYS_REGISTER_T_PPATH_UNIQUE UNIQUE (parent_path)
);
-- Add comments to the table 
comment on table SYS_REGISTER_T
  is '�����ֵ�';
-- Add comments to the columns 
comment on column SYS_REGISTER_T.reg_name
  is '���ƻ�label';
comment on column SYS_REGISTER_T.reg_code
  is '����';
comment on column SYS_REGISTER_T.reg_desc
  is ' ˵��';
comment on column SYS_REGISTER_T.parent_id
  is '��һ�������Ҳ�����ͽṹ';
comment on column SYS_REGISTER_T.created_user
  is '�����û�';
comment on column SYS_REGISTER_T.created_date
  is '��������';
comment on column SYS_REGISTER_T.update_last_user
  is '�������û�';
comment on column SYS_REGISTER_T.update_last_date
  is '����������';
comment on column SYS_REGISTER_T.valid_flag
  is '����ͣ�ã�ɾ��״̬';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_REGISTER_T
  add primary key (REG_ID)
  using index;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_LOOKUP_ITEM_T';
if v_num > 0 then
execute immediate 'drop table SYS_LOOKUP_ITEM_T';
end if;
end;
/
-- Create table
create table SYS_LOOKUP_ITEM_T
(
  item_id          VARCHAR2(32) not null,
  item_code        INTEGER,
  item_name        VARCHAR2(40),
  item_lan         INTEGER,
  class_id         VARCHAR2(32) not null,
  item_status      INTEGER default 1,
  remarks          VARCHAR2(308),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1) default 1
);
-- Add comments to the table 
comment on table SYS_LOOKUP_ITEM_T
  is 'lookup��Ŀ��,һ�������Ӧ������';
-- Add comments to the columns 
comment on column SYS_LOOKUP_ITEM_T.item_id
  is '����';
comment on column SYS_LOOKUP_ITEM_T.item_name
  is '����';
comment on column SYS_LOOKUP_ITEM_T.class_id
  is '�����ʶ';
comment on column SYS_LOOKUP_ITEM_T.order_code
  is '����';
comment on column SYS_LOOKUP_ITEM_T.created_user
  is '�����û�';
comment on column SYS_LOOKUP_ITEM_T.created_date
  is '��������';
comment on column SYS_LOOKUP_ITEM_T.update_last_user
  is '�������û�';
comment on column SYS_LOOKUP_ITEM_T.update_last_date
  is '����������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOOKUP_ITEM_T
  add primary key (ITEM_ID)
  using index;
alter table SYS_LOOKUP_ITEM_T
  add constraint SYS_LOOKUP_ITEM_CODE_UNIQUE unique (class_id,ITEM_CODE)
  using index;
alter table SYS_LOOKUP_ITEM_T
  add constraint SYS_LOOKUP_ITEM_NAME_UNIQUE unique (class_id,ITEM_NAME)
  using index;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_LOOKUP_CLASSIFY_T';
if v_num > 0 then
execute immediate 'drop table SYS_LOOKUP_CLASSIFY_T';
end if;
end;
/
-- Create table
create table SYS_LOOKUP_CLASSIFY_T
(
  class_id         NUMBER not null,
  class_name       VARCHAR2(40),
  class_code       VARCHAR2(100),
  class_desc       VARCHAR2(300),
  order_code  INTEGER default 1,
  created_user NUMBER,
  created_date DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1) default 1,
  CONSTRAINT SYS_LOOKUP_CLASS_NAME_UNIQUE UNIQUE (class_name),
  CONSTRAINT SYS_LOOKUP_CLASS_CODE_UNIQUE UNIQUE (class_code)
);
-- Add comments to the table 
comment on table SYS_LOOKUP_CLASSIFY_T
  is 'lookup������Ϣ';
-- Add comments to the columns 
comment on column SYS_LOOKUP_CLASSIFY_T.class_id
  is '����';
comment on column SYS_LOOKUP_CLASSIFY_T.class_name
  is '��������';
comment on column SYS_LOOKUP_CLASSIFY_T.created_user
  is '�����û�';
comment on column SYS_LOOKUP_CLASSIFY_T.created_date
  is '��������';
comment on column SYS_LOOKUP_CLASSIFY_T.update_last_user
  is '�������û�';
comment on column SYS_LOOKUP_CLASSIFY_T.update_last_date
  is '����������';
comment on column SYS_LOOKUP_CLASSIFY_T.order_code
  is '������';
comment on column SYS_LOOKUP_CLASSIFY_T.class_code
  is '����,icustom.xxx.xxx';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOOKUP_CLASSIFY_T
  add primary key (CLASS_ID);

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_LANGUAGE_T';
if v_num > 0 then
execute immediate 'drop table SYS_LANGUAGE_T';
end if;
end;
/
-- Create table
create table SYS_LANGUAGE_T
(
  lan_id           NUMBER not null,
  lan_code         VARCHAR2(68) not null,
  lan_value        VARCHAR2(68) not null,
  lan_type         INTEGER default 1,
  remarks          VARCHAR2(308),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1) default 1
);
-- Add comments to the columns 
comment on column SYS_LANGUAGE_T.lan_id
  is '����,��������';
comment on column SYS_LANGUAGE_T.lan_code
  is '���Ա���,�����ķ�� icustom.menu.home,Ҳ������������ã�һ��code���԰�����Ӣ��';
comment on column SYS_LANGUAGE_T.lan_value
  is '���Զ�Ӧֵ���磺�˵���ӦӢ��menu';
comment on column SYS_LANGUAGE_T.lan_type
  is '��������,��Ӣ��';
comment on column SYS_LANGUAGE_T.remarks
  is '��ע';
comment on column SYS_LANGUAGE_T.attribute1
  is '��չ����1';
comment on column SYS_LANGUAGE_T.attribute2
  is '��չ����2';
comment on column SYS_LANGUAGE_T.created_user
  is '�����û�';
comment on column SYS_LANGUAGE_T.created_date
  is '��������';
comment on column SYS_LANGUAGE_T.update_last_user
  is '�������û�';
comment on column SYS_LANGUAGE_T.update_last_date
  is '����������';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LANGUAGE_T
  add primary key (LAN_ID)
  using index;
alter table SYS_LANGUAGE_T
  add constraint SYS_LANGUAGE_UNIQUE unique (LAN_VALUE, LAN_TYPE)
  using index;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_NAVIGATION_T';
if v_num > 0 then
execute immediate 'drop table SYS_NAVIGATION_T';
end if;
end;
/
-- Create table
create table SYS_NAVIGATION_T
(
  item_id          NUMBER(30) not null PRIMARY KEY ,
  item_name        VARCHAR2(60) not null,
  parent_id        NUMBER(30),
  icon             VARCHAR2(30),
  url              VARCHAR2(200),
  order_code       NUMBER(20),
  resource_type    NUMBER(1),
  created_user     NUMBER(30),
  created_date     DATE default SYSDATE,
  update_last_user NUMBER(30),
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1)
);
alter table SYS_NAVIGATION_T
  add constraint SYS_NAVIGATION_T_UNIQUE unique (parent_id, item_name)
  using index;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_USERS_T';
if v_num > 0 then
execute immediate 'drop table SYS_USERS_T';
end if;
end;
/
/* Ȩ�ޱ� ��ʼ�� */
-- Create table
create table SYS_USERS_T
(
  user_id          NUMBER(32) not null,
  user_account     VARCHAR2(30),
  user_name        VARCHAR2(40),
  user_password    VARCHAR2(100),
  user_desc        VARCHAR2(998),
  valid_start      DATE,
  valid_end        DATE,
  enabled        INTEGER default 1,
  issys          INTEGER default 0,
  user_dept        VARCHAR2(20),
  user_duty        VARCHAR2(10),
  sub_system       VARCHAR2(30),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
);
-- Add comments to the table 
comment on table SYS_USERS_T
  is 'ϵͳ�û���';
-- Add comments to the columns 
comment on column SYS_USERS_T.user_id
  is '�û�id';
comment on column SYS_USERS_T.user_account
  is '�û��˻�';
comment on column SYS_USERS_T.user_name
  is '�û���';
comment on column SYS_USERS_T.user_password
  is '�û�����';
comment on column SYS_USERS_T.user_desc
  is '�û���������';
comment on column SYS_USERS_T.enabled
  is '�û��Ƿ�����';
comment on column SYS_USERS_T.issys
  is '�Ƿ񳬼��û�-����ֶ�ûʲô��';
comment on column SYS_USERS_T.user_dept
  is '�����ĵ�λ';
comment on column SYS_USERS_T.user_duty
  is '�û�ְλ';
comment on column SYS_USERS_T.sub_system
  is '�û��ֹܵ���ϵͳ';
comment on column SYS_USERS_T.order_code
  is '������';
comment on column SYS_USERS_T.created_user
  is '�����û�';
comment on column SYS_USERS_T.created_date
  is '��������';
comment on column SYS_USERS_T.update_last_user
  is '�������û�';
comment on column SYS_USERS_T.update_last_date
  is '����������';
comment on column SYS_USERS_T.valid_flag
  is 'ɾ��״̬';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_USERS_T
  add primary key (USER_ID)
  using index;
create unique index USER_ACCOUNT_UNIQUE on SYS_USERS_T (USER_ACCOUNT);

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_RESOURCES_T';
if v_num > 0 then
execute immediate 'drop table SYS_RESOURCES_T';
end if;
end;
/
-- Create table
create table SYS_RESOURCES_T
(
  resource_id      NUMBER(32) not null,
  resource_name    VARCHAR2(100),
  resource_desc    VARCHAR2(1008),
  resource_type    VARCHAR2(40),
  resource_string  VARCHAR2(200),
  icon             VARCHAR2(30),
  parent_id        NUMBER(32) default 0,
  res_url          VARCHAR2(1200),
  priority         NUMBER(1) default 1,
  enabled        INTEGER default 1,
  issys          INTEGER default 0,
  use_status       INTEGER default 1,
  module           VARCHAR2(4),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_RESOURCES_T
  add primary key (RESOURCE_ID)
  using index;
alter table SYS_RESOURCES_T
  add constraint SYS_RESOURCE_TREE_UNIQUE unique (RESOURCE_NAME, PARENT_ID)
  using index;
comment on table SYS_RESOURCES_T
   is '��Դ��';
 comment on column SYS_RESOURCES_T.PRIORITY
   is '���ݲ��ã�������';
 comment on column SYS_RESOURCES_T.MODULE
   is '��������ϵͳ������ƽ̨�������10��ϵͳ���ֱ�Ϊ�ɱ�����ҵ������ȡ� ���ݲ��ã�������';
 comment on column SYS_RESOURCES_T.use_status
  is '�Ƿ���ã�0Ϊ�����ã�1Ϊ����';
  

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_AUTHORITIES_T';
if v_num > 0 then
execute immediate 'drop table SYS_AUTHORITIES_T';
end if;
end;
/
-- Create table
create table SYS_AUTHORITIES_T
(
  auth_id          NUMBER(32) not null primary key,
  auth_name        VARCHAR2(60),
  auth_desc        VARCHAR2(1008),
  PARENT_ID        NUMBER(32),
  auth_code        VARCHAR2(60),
  enabled        INTEGER default 1,
  issys          INTEGER default 0,
  module         VARCHAR2(4),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
);
comment on table SYS_AUTHORITIES_T
   is 'Ȩ�ޱ�';
comment on column SYS_AUTHORITIES_T.MODULE
   is '��������ϵͳ������ƽ̨�������10��ϵͳ���ֱ�Ϊ�ɱ�����ҵ������ȡ�';
alter table SYS_AUTHORITIES_T
  add constraint AUTH_NAME_UNIQUE unique (PARENT_ID, AUTH_NAME, AUTH_CODE)
  using index;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_ROLES_T';
if v_num > 0 then
execute immediate 'drop table SYS_ROLES_T';
end if;
end;
/
create table SYS_ROLES_T
(
  role_id          NUMBER(32) not null primary key,
  role_name        VARCHAR2(40) unique,
  role_code        VARCHAR2(100) unique,
  role_desc        VARCHAR2(1008),
  enabled        INTEGER default 1,
  issys          INTEGER default 0,
  module           VARCHAR2(4),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
);
 comment on table SYS_ROLES_T
   is '��ɫ��';
 comment on column SYS_ROLES_T.MODULE
   is '��������ϵͳ������ƽ̨�������10��ϵͳ���ֱ�Ϊ�ɱ�����ҵ������ȡ�';

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_ROLES_AUTHORITIES_T';
if v_num > 0 then
execute immediate 'drop table SYS_ROLES_AUTHORITIES_T';
end if;
end;
/
--�м�� ���ϵ�� Create table
create table SYS_ROLES_AUTHORITIES_T
(
  id           NUMBER(32) not null primary key,
  role_id      NUMBER(32),
  auth_id      NUMBER(32),
  enabled        INTEGER default 1
);
comment on table SYS_ROLES_AUTHORITIES_T
   is '��ɫȨ�ޱ�';

 alter table SYS_ROLES_AUTHORITIES_T
   add constraint FK_PUB_ROLES_AUTHORITIES_AU foreign key (AUTH_ID)
   references SYS_AUTHORITIES_T (AUTH_ID);
 alter table SYS_ROLES_AUTHORITIES_T
   add constraint FK_PUB_ROLES_AUTHORITIES_ROLES foreign key (ROLE_ID)
   references SYS_ROLES_T (ROLE_ID);
 alter table SYS_ROLES_AUTHORITIES_T
  add constraint FK_ROLES_AUTH_UNIQUE unique (ROLE_ID, AUTH_ID);
  

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_USERS_ROLES_T';
if v_num > 0 then
execute immediate 'drop table SYS_USERS_ROLES_T';
end if;
end;
/
-- Create table
create table SYS_USERS_ROLES_T
(
  id                      NUMBER(32) not null primary key,
  user_id                 VARCHAR2(32),
  role_id                 VARCHAR2(32),
  enabled                 INTEGER default 1,
  remarks          VARCHAR2(308),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
);
alter table SYS_USERS_ROLES_T
  add constraint USER_ROLE_UNIQUE unique (USER_ID, ROLE_ID)
  using index ;

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='SYS_AUTHORITIES_RESOURCES_T';
if v_num > 0 then
execute immediate 'drop table SYS_AUTHORITIES_RESOURCES_T';
end if;
end;
/
-- Create table
create table SYS_AUTHORITIES_RESOURCES_T
(
  id               NUMBER(32) not null primary key,
  AUTH_ID          NUMBER(32),
  RESOURCE_ID      NUMBER(32),
  enabled        INTEGER default 1,
  remarks          VARCHAR2(308),
  attribute1       VARCHAR2(100),
  attribute2       VARCHAR2(100),
  attribute3       VARCHAR2(100),
  attribute4       VARCHAR2(100),
  attribute5       VARCHAR2(100),
  attribute6       VARCHAR2(100),
  attribute7       VARCHAR2(100),
  attribute8       VARCHAR2(100),
  attribute9       VARCHAR2(100),
  attribute10      VARCHAR2(100),
  order_code       INTEGER default 1,
  created_user     NUMBER,
  created_date     DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       INTEGER default 1
);
comment on table SYS_AUTHORITIES_RESOURCES_T
   is 'Ȩ����Դ��';
alter table SYS_AUTHORITIES_RESOURCES_T
   add constraint FK_PUB_AUTHORITIES_RE_AU foreign key (AUTH_ID) 
   references SYS_AUTHORITIES_T (AUTH_ID);
 alter table SYS_AUTHORITIES_RESOURCES_T
   add constraint FK_PUB_AUTHORITIES_RE_RE foreign key (RESOURCE_ID)
   references SYS_RESOURCES_T (RESOURCE_ID);

alter table SYS_AUTHORITIES_RESOURCES_T
  add constraint FK_PUB_AUTHORITIES_RE_UQ unique (AUTH_ID, RESOURCE_ID);

declare
v_num number;
begin
select count(*) into v_num from user_tables where table_name='PERSISTENT_LOGINS';
if v_num > 0 then
execute immediate 'drop table PERSISTENT_LOGINS';
end if;
end;
/
-- Create table��
create table PERSISTENT_LOGINS
(
  username  VARCHAR2(40),
  series    VARCHAR2(256),
  token     VARCHAR2(256),
  last_used VARCHAR2(40)
);
comment on table PERSISTENT_LOGINS
   is '�û���½��־��';
