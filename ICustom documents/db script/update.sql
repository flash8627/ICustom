
-- Create sequence 
create sequence SYS_USERS_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- Create sequence 
create sequence SYS_NAVIGATION_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

-- 20160814
-- Create sequence 
create sequence SYS_LOOKUP_CLASSIFY_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

-- Create sequence 
create sequence SYS_LOOKUP_ITEM_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

-- Create sequence 
create sequence SYS_REGISTER_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

-- Create sequence 
create sequence SYS_LANGUAGE_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;

-- Create table
create table SYS_REGISTER_T
(
  reg_id           NUMBER(30) not null,
  reg_name         VARCHAR2(60) not null,
  reg_code         VARCHAR2(60),
  reg_desc         VARCHAR2(200),
  reg_value        VARCHAR2(200),
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
  is '数据字典';
-- Add comments to the columns 
comment on column SYS_REGISTER_T.reg_name
  is '名称或label';
comment on column SYS_REGISTER_T.reg_code
  is '编码';
comment on column SYS_REGISTER_T.reg_desc
  is ' 说明';
comment on column SYS_REGISTER_T.parent_id
  is '上一级，这个也是树型结构';
comment on column SYS_REGISTER_T.created_user
  is '创建用户';
comment on column SYS_REGISTER_T.created_date
  is '创建日期';
comment on column SYS_REGISTER_T.update_last_user
  is '最后更新用户';
comment on column SYS_REGISTER_T.update_last_date
  is '最后更新日期';
comment on column SYS_REGISTER_T.valid_flag
  is '启用停用，删除状态';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_REGISTER_T
  add primary key (REG_ID)
  using index;


-- Create table
create table SYS_LOOKUP_ITEM_T
(
  item_id          NUMBER not null,
  item_code        INTEGER,
  item_name        VARCHAR2(40),
  item_lan         VARCHAR2(40),
  class_id         NUMBER,
  item_status      INTEGER default 1,
  REMARKS    VARCHAR2(308),
  order_code  INTEGER default 1,
  created_user NUMBER,
  created_date DATE default SYSDATE,
  update_last_user NUMBER,
  update_last_date DATE default SYSDATE,
  valid_flag       NUMBER(1) default 1,
  CONSTRAINT SYS_LOOKUP_ITEM_NAME_UNIQUE UNIQUE (item_name),
  CONSTRAINT SYS_LOOKUP_ITEM_CODE_UNIQUE UNIQUE (item_code)
);
-- Add comments to the table 
comment on table SYS_LOOKUP_ITEM_T
  is 'lookup条目类,一个分类对应多条　';
-- Add comments to the columns 
comment on column SYS_LOOKUP_ITEM_T.item_id
  is '主键';
comment on column SYS_LOOKUP_ITEM_T.item_name
  is '名称';
comment on column SYS_LOOKUP_ITEM_T.class_id
  is '分类标识';
comment on column SYS_LOOKUP_ITEM_T.created_user
  is '创建用户';
comment on column SYS_LOOKUP_ITEM_T.created_date
  is '创建日期';
comment on column SYS_LOOKUP_ITEM_T.update_last_user
  is '最后更新用户';
comment on column SYS_LOOKUP_ITEM_T.update_last_date
  is '最后更新日期';
comment on column SYS_LOOKUP_ITEM_T.order_code
  is '排序';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOOKUP_ITEM_T
  add primary key (ITEM_ID)
  using index;


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
  is 'lookup分类信息';
-- Add comments to the columns 
comment on column SYS_LOOKUP_CLASSIFY_T.class_id
  is '主键';
comment on column SYS_LOOKUP_CLASSIFY_T.class_name
  is '分类名称';
comment on column SYS_LOOKUP_CLASSIFY_T.created_user
  is '创建用户';
comment on column SYS_LOOKUP_CLASSIFY_T.created_date
  is '创建日期';
comment on column SYS_LOOKUP_CLASSIFY_T.update_last_user
  is '最后更新用户';
comment on column SYS_LOOKUP_CLASSIFY_T.update_last_date
  is '最后更新日期';
comment on column SYS_LOOKUP_CLASSIFY_T.order_code
  is '排序码';
comment on column SYS_LOOKUP_CLASSIFY_T.class_code
  is '编码,icustom.xxx.xxx';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LOOKUP_CLASSIFY_T
  add primary key (CLASS_ID);

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
  is '主键,序列自增';
comment on column SYS_LANGUAGE_T.lan_code
  is '语言编码,带包的风格 icustom.menu.home,也可以做组的作用，一个code可以包括中英法';
comment on column SYS_LANGUAGE_T.lan_value
  is '语言对应值：如：菜单对应英文menu';
comment on column SYS_LANGUAGE_T.lan_type
  is '语言类型,中英法';
comment on column SYS_LANGUAGE_T.remarks
  is '备注';
comment on column SYS_LANGUAGE_T.attribute1
  is '扩展属性1';
comment on column SYS_LANGUAGE_T.attribute2
  is '扩展属性2';
comment on column SYS_LANGUAGE_T.created_user
  is '创建用户';
comment on column SYS_LANGUAGE_T.created_date
  is '创建日期';
comment on column SYS_LANGUAGE_T.update_last_user
  is '最后更新用户';
comment on column SYS_LANGUAGE_T.update_last_date
  is '最后更新日期';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_LANGUAGE_T
  add primary key (LAN_ID)
  using index;
alter table SYS_LANGUAGE_T
  add constraint SYS_LANGUAGE_UNIQUE unique (LAN_VALUE, LAN_TYPE)
  using index;


-- Create table
create table SYS_USERS_T
(
  user_id       VARCHAR2(32) not null,
  user_account  VARCHAR2(30),
  user_name     VARCHAR2(40),
  user_password VARCHAR2(100),
  user_desc     VARCHAR2(100),
  enabled       NUMBER(1),
  issys         NUMBER(1),
  user_dept     VARCHAR2(20),
  user_duty     VARCHAR2(10),
  sub_system    VARCHAR2(30)
);


-- Create table
create table SYS_ROLES_AUTHORITIES_T
(
  id           NUMBER(13) not null,
  role_id      VARCHAR2(32),
  authority_id VARCHAR2(32),
  enabled      NUMBER(1)
);

-- Create table
create table SYS_RESOURCES_T
(
  resource_id     VARCHAR2(32) not null,
  resource_name   VARCHAR2(100),
  resource_desc   VARCHAR2(100),
  resource_type   VARCHAR2(40),
  resource_string VARCHAR2(200),
  priority        NUMBER(1),
  enabled         NUMBER(1),
  issys           NUMBER(1),
  module          VARCHAR2(4)
);


-- Create table
create table SYS_NAVIGATION_T
(
  item_id          NUMBER(30),
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

-- Create table
create table SYS_ROLES_T
(
  role_id   VARCHAR2(32) not null,
  role_name VARCHAR2(40),
  role_desc VARCHAR2(100),
  enabled   NUMBER(1),
  issys     NUMBER(1),
  module    VARCHAR2(4)
);

-- Create table
create table SYS_USERS_ROLES_T
(
  id      NUMBER(13) not null,
  user_id VARCHAR2(32),
  role_id VARCHAR2(32),
  enabled NUMBER(1)
);

-- Create table
create table SYS_AUTHORITIES_T
(
  authority_id   VARCHAR2(32) not null,
  authority_name VARCHAR2(40),
  authority_desc VARCHAR2(100),
  enabled        NUMBER(1),
  issys          NUMBER(1),
  module         VARCHAR2(4)
);


-- Create table
create table SYS_AUTHORITIES_RESOURCES_T
(
  id           NUMBER(13) not null,
  authority_id VARCHAR2(32),
  resource_id  VARCHAR2(32),
  enabled      NUMBER(1)
);

-- Create table
create table SC_DISTRICT
(
  id        NUMBER(10) not null,
  parent_id NUMBER(10),
  name      VARCHAR2(255) not null
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table SC_DISTRICT
  add constraint SC_DISTRICT_PK primary key (ID)
  using index;
alter table SC_DISTRICT
  add constraint SC_DISTRICT_R01 foreign key (PARENT_ID)
  references SC_DISTRICT (ID);

-- Create table
create table PERSISTENT_LOGINS
(
  username  VARCHAR2(40),
  series    VARCHAR2(256),
  token     VARCHAR2(256),
  last_used VARCHAR2(40)
);

