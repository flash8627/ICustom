prompt Importing table SYS_LOOKUP_CLASSIFY_T...
set feedback off
set define off
insert into SYS_LOOKUP_CLASSIFY_T (CLASS_ID, CLASS_NAME, CLASS_CODE, CLASS_DESC, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values ('1', '国际化语言类型', 'LANGUAGE_TYPE', null, 1, null, to_date('14-02-2016 07:36:38', 'dd-mm-yyyy hh24:mi:ss'), null, to_date('14-02-2016 07:36:38', 'dd-mm-yyyy hh24:mi:ss'), 1);

prompt Done.
