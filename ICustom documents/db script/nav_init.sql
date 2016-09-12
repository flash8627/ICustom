



insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (1, 'zh_cn=HOME,zh_en=Home', null, 'home', null, 1, null, 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (2, 'Product', 1, null, null, 1, 0, 10001, to_date('13-09-2016 02:50:10', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:50:10', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (3, 'SHOP', 1, null, null, 1, 0, 10001, to_date('13-09-2016 02:50:32', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:50:32', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (6, 'BLOG', 1, null, null, 3, 0, 10001, to_date('13-09-2016 02:53:52', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:46:55', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (5, 'Import Export', 1, null, null, 3, 0, 10001, to_date('13-09-2016 02:53:12', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:46:39', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (7, 'About', 1, null, null, 5, 0, 10001, to_date('13-09-2016 02:51:50', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:47:10', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (8, 'Contact', 1, null, null, 6, 0, 10001, to_date('13-09-2016 02:52:14', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:47:16', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (16, 'System Management', 1, null, null, 4, null, 10001, to_date('28-12-2015 08:06:22', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 11:15:14', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (9, 'zh_cn=国际化,zh_en=international', 16, null, 'international/index.html', 89, 0, 10001, to_date('13-09-2016 02:55:49', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:43:13', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (10, 'zh_cn=System Menu,zh_en=System Menu', 16, 'home', 'NavigationTreeGridManager/NavigationETree.html', 1, null, 10001, to_date('19-12-2015 02:51:49', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 10:54:15', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (11, 'zh_cn=Lookup Manager,zh_en=Lookup Manager', 16, 'home', 'lookup/index.html', 1, 0, 10001, to_date('19-12-2015 02:53:21', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:42:29', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (12, 'zh_cn=数据字典,zh_en=Register', 16, 'home', 'register/index.html', 1, 0, 10001, to_date('19-12-2015 02:55:15', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:42:51', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (18, 'zh_cn=Security Manager,zh_en=Security Manager', 16, null, null, 34, 0, 10001, to_date('13-09-2016 02:59:03', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:59:03', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (19, 'zh_cn=用户管理,zh_en=Users Manager', 18, null, 'security/user/index.html', 1, 0, 10001, to_date('13-09-2016 02:59:33', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:03:03', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (20, 'zh_cn=角色管理,zh_en=Role Manager', 18, null, 'security/role/index.html', 73, 0, 10001, to_date('13-09-2016 02:59:59', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:03:26', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (21, 'zh_cn=资源管理,zh_en=Resources Manager', 18, null, 'security/resources/ResourceTreeGrid.html', 4, 0, 10001, to_date('13-09-2016 03:00:26', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:04:10', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (22, 'zh_cn=权限配置,zh_en=authorities Manager', 18, null, 'security/auth/index.html', 3, 0, 10001, to_date('13-09-2016 03:01:20', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:04:30', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (1, 'zh_cn=HOME,zh_en=Home', null, 'home', null, 1, null, 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:49:35', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (2, 'Product', 1, null, null, 1, 0, 10001, to_date('13-09-2016 02:50:10', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:50:10', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (3, 'SHOP', 1, null, null, 1, 0, 10001, to_date('13-09-2016 02:50:32', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:50:32', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (5, 'Import Export', 1, null, null, 0, 0, 10001, to_date('13-09-2016 02:53:12', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:53:12', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (6, 'BLOG', 1, null, null, 36, 0, 10001, to_date('13-09-2016 02:53:52', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:53:52', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (7, 'About', 1, null, null, 35, 0, 10001, to_date('13-09-2016 02:51:50', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:51:50', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (8, 'Contact', 1, null, null, 16, 0, 10001, to_date('13-09-2016 02:52:14', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:52:14', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (16, 'System Management', 1, null, null, 4, null, 10001, to_date('28-12-2015 08:06:22', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 11:15:14', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (9, 'zh_cn=国际化,zh_en=international', 16, null, null, 89, 0, 10001, to_date('13-09-2016 02:55:49', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:57:48', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (10, 'zh_cn=System Menu,zh_en=System Menu', 16, 'home', 'NavigationTreeGridManager/NavigationETree.html', 1, null, 10001, to_date('19-12-2015 02:51:49', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('04-01-2016 10:54:15', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (11, 'zh_cn=Lookup Manager,zh_en=Lookup Manager', 16, 'home', null, 1, null, 10001, to_date('19-12-2015 02:53:21', 'dd-mm-yyyy hh24:mi:ss'), 10001, to_date('19-12-2015 02:53:21', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (12, 'zh_cn=数据字典,zh_en=Register', 16, 'home', null, 1, 0, 10001, to_date('19-12-2015 02:55:15', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:58:40', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (18, 'zh_cn=Security Manager,zh_en=Security Manager', 16, null, null, 34, 0, 10001, to_date('13-09-2016 02:59:03', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 02:59:03', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (19, 'zh_cn=用户管理,zh_en=Users Manager', 18, null, 'security/user/index.html', 1, 0, 10001, to_date('13-09-2016 02:59:33', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:03:03', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (20, 'zh_cn=角色管理,zh_en=Role Manager', 18, null, 'security/role/index.html', 73, 0, 10001, to_date('13-09-2016 02:59:59', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:03:26', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (21, 'zh_cn=资源管理,zh_en=Resources Manager', 18, null, 'security/resources/ResourceTreeGrid.html', 4, 0, 10001, to_date('13-09-2016 03:00:26', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:04:10', 'dd-mm-yyyy hh24:mi:ss'), null);

insert into sys_navigation_t (ITEM_ID, ITEM_NAME, PARENT_ID, ICON, URL, ORDER_CODE, RESOURCE_TYPE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (22, 'zh_cn=权限配置,zh_en=authorities Manager', 18, null, 'security/auth/index.html', 3, 0, 10001, to_date('13-09-2016 03:01:20', 'dd-mm-yyyy hh24:mi:ss'), 0, to_date('13-09-2016 03:04:30', 'dd-mm-yyyy hh24:mi:ss'), null);

commit;
select * from sys_navigation_t ;

