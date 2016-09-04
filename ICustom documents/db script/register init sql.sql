insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (1, '系统', 'system', '系统', 'regValue', null, 0, 1, 1, to_date(sysdate, 'dd-mm-yyyy hh24:mi:ss'), 1, to_date(sysdate, 'dd-mm-yyyy hh24:mi:ss'), 1);
insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (2, '应用', 'app', '应用', 'regValue', null, 0, 1, 1, to_date(sysdate, 'dd-mm-yyyy hh24:mi:ss'), 1, to_date(sysdate, 'dd-mm-yyyy hh24:mi:ss'), 1);
insert into SYS_REGISTER_T (REG_ID, REG_NAME, REG_CODE, REG_DESC, REG_VALUE, PARENT_PATH, PARENT_ID, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (3, '测试', 'config', '测试', 'regValue', null, 0, 1, 1, to_date(sysdate, 'dd-mm-yyyy hh24:mi:ss'), 1, to_date(sysdate, 'dd-mm-yyyy hh24:mi:ss'), 1);

commit;
