prompt Importing table SYS_REGISTER_T...
set feedback off
set define off
insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, REG_STATUS, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (107, '版本号', 'version', null, '1.0', 1, 'app', 102, null, 10001, to_date('18-03-2017 02:52:17', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('18-03-2017 02:52:17', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, REG_STATUS, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (102, '应用', 'app', '系统应用', null, 1, null, 0, null, 10001, to_date('18-03-2017 02:43:35', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('18-03-2017 02:43:35', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, REG_STATUS, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (103, 'icustom', 'icustom', null, null, 1, null, 0, null, 10001, to_date('18-03-2017 02:44:22', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('18-03-2017 02:44:22', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, REG_STATUS, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (104, 'system', 'system', '系统', null, 1, null, 0, null, 10001, to_date('18-03-2017 02:44:50', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('18-03-2017 02:45:41', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, REG_STATUS, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (105, '资源', 'resources', null, null, 1, 'system', 104, null, 10001, to_date('18-03-2017 02:46:01', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('18-03-2017 02:46:01', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, REG_STATUS, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (106, '资源时间参数', 'timeStamp', null, null, 1, 'system.resources', 105, null, 10001, to_date('18-03-2017 02:47:23', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('18-03-2017 02:47:23', 'dd-mm-yyyy hh24:mi:ss'), 1);

prompt Done.
