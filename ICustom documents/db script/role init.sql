

insert into SYS_ROLES_T (ROLE_ID, ROLE_NAME, ROLE_CODE, ROLE_DESC, ENABLED, ISSYS, MODULE, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (22, '系统管理员', 'admin', '管理系统，超级权限，除了对产品和业务操作，啥都能干', 0, 0, null, null, null, null, null, null, null, null, null, null, null, 1, 1, to_date('16-09-2016 22:22:13', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('16-09-2016 22:22:13', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_ROLES_T (ROLE_ID, ROLE_NAME, ROLE_CODE, ROLE_DESC, ENABLED, ISSYS, MODULE, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (23, 'pro_admin', 'pro_admin', '产品管理员，可以最高权限操作产品，不能维护系统参数', 0, 0, null, null, null, null, null, null, null, null, null, null, null, 1, 1, to_date('16-09-2016 22:25:57', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('16-09-2016 22:25:57', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_ROLES_T (ROLE_ID, ROLE_NAME, ROLE_CODE, ROLE_DESC, ENABLED, ISSYS, MODULE, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (24, 'blog_admin', 'blog_admin', '博客管理员', 0, 0, null, null, null, null, null, null, null, null, null, null, null, 1, 1, to_date('16-09-2016 22:37:22', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('16-09-2016 22:37:22', 'dd-mm-yyyy hh24:mi:ss'), 1);

insert into SYS_ROLES_T (ROLE_ID, ROLE_NAME, ROLE_CODE, ROLE_DESC, ENABLED, ISSYS, MODULE, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (25, 'info_editor', 'info_editor', '站点信息编辑', 0, 0, null, null, null, null, null, null, null, null, null, null, null, 1, 1, to_date('16-09-2016 22:39:00', 'dd-mm-yyyy hh24:mi:ss'), 1, to_date('16-09-2016 22:39:00', 'dd-mm-yyyy hh24:mi:ss'), 1);


commit;
