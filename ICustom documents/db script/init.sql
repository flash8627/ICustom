prompt Importing table SYS_NAVIGATION_T...
set feedback off
set define off
insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (43, 'A222', 28, '111', '222', 81, 10001, to_date('22-12-2015 18:06:43', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('22-12-2015 18:06:43', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (41, '222', 8, '33', '333', 72, 10001, to_date('22-12-2015 18:04:29', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('22-12-2015 18:04:29', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (42, 'A2211', 28, '2211', '2211', 14, 10001, to_date('22-12-2015 18:05:35', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('22-12-2015 18:05:35', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (44, 'B1', 43, '111', '11', 40, 10001, to_date('22-12-2015 18:07:52', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('22-12-2015 18:07:52', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (61, 'System Management', 4, null, null, 4, 10001, to_date('28-12-2015 08:06:22', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 11:15:14', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (40, '321', 8, '11', '1212', 86, 10001, to_date('22-12-2015 09:35:44', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('22-12-2015 09:35:44', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (27, '11111', 8, '11', '1111', 14, 10001, to_date('21-12-2015 23:33:29', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('21-12-2015 23:33:29', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (4, 'zh_cn=HOME,zh_en=Home', null, 'home', null, 1, 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (5, 'zh_cn=System Menu,zh_en=System Menu', 61, 'home', 'NavigationTreeGridManager/NavigationETree.html', 1, 10001, to_date('19-12-2015 02:51:49', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 10:54:15', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (6, 'zh_cn=System User,zh_en=System User', 81, 'home', null, 1, 10001, to_date('19-12-2015 02:52:14', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:52:14', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (7, 'zh_cn=System Role,zh_en=System Role', 81, '111', 'role/mgr.html', 1, 10001, to_date('19-12-2015 02:52:36', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('22-12-2015 02:37:07', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (8, 'zh_cn=Lookup Manager,zh_en=Lookup Manager', 61, 'home', null, 1, 10001, to_date('19-12-2015 02:53:21', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:53:21', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (10, 'zh_cn=Data Dictionary,zh_en=Data Dictionary', 61, 'home', null, 1, 10001, to_date('19-12-2015 02:55:15', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:55:15', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into SYS_NAVIGATION_T (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (23, 'U_23', 6, 'icon', 'url', 10, null, null, null, null, null, null);

commit;


prompt Done.
