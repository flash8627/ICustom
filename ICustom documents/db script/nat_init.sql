prompt Importing table sys_navigation_t...
set feedback off
set define off
insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (61, 'System Management', 4, null, null, 4, 10001, to_date('28-12-2015 08:06:22', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 11:15:14', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (4, 'zh_cn=HOME,zh_en=Home', null, 'home', null, 1, 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (5, 'zh_cn=System Menu,zh_en=System Menu', 61, 'home', 'NavigationTreeGridManager/NavigationETree.html', 1, 10001, to_date('19-12-2015 02:51:49', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 10:54:15', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (6, 'zh_cn=System User,zh_en=System User', 81, 'home', null, 1, 10001, to_date('19-12-2015 02:52:14', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:52:14', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (7, 'zh_cn=System Role,zh_en=System Role', 81, '111', 'role/mgr.html', 1, 10001, to_date('19-12-2015 02:52:36', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('22-12-2015 02:37:07', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (8, 'zh_cn=Lookup Manager,zh_en=Lookup Manager', 61, 'home', null, 1, 10001, to_date('19-12-2015 02:53:21', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:53:21', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (10, 'zh_cn=Data Dictionary,zh_en=Data Dictionary', 61, 'home', null, 1, 10001, to_date('19-12-2015 02:55:15', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:55:15', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (141, 'internationalized', 61, null, 'international/index.html', 40, 10001, to_date('20-01-2016 12:12:10', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('20-01-2016 12:12:10', 'dd-mm-yyyy hh24:mi:ss'), null, 0);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (142, 'Resources Manager', 81, null, null, 4, 10001, to_date('20-01-2016 12:12:58', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('20-01-2016 12:12:58', 'dd-mm-yyyy hh24:mi:ss'), null, 0);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (81, 'Security Management', 61, 'secur', null, 61, 10001, to_date('04-01-2016 10:57:35', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 10:57:35', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (84, 'SHOP', 4, null, null, 1, 10001, to_date('04-01-2016 11:12:16', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('11-01-2016 08:30:29', 'dd-mm-yyyy hh24:mi:ss'), null, 0);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (85, 'FAQ', 4, null, 'faq.html', 2, 10001, to_date('04-01-2016 11:13:01', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 11:14:59', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (86, 'BLOG', 4, null, 'blog.html', 3, 10001, to_date('04-01-2016 11:13:59', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 11:14:32', 'dd-mm-yyyy hh24:mi:ss'), null, null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG, RESOURCE_TYPE)
values (87, 'CONTACT US', 4, null, 'contact-us.html', 5, 10001, to_date('04-01-2016 11:16:01', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 11:16:01', 'dd-mm-yyyy hh24:mi:ss'), null, null);

prompt Done.
