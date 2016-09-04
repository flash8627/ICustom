
select table_name from user_tables;

select * FROM SYS_REGISTER_T;

select * FROM SYS_LOOKUP_CLASSIFY_T;

select * FROM SYS_LOOKUP_ITEM_T;

select * from SYS_LANGUAGE_T;

SELECT * FROM SYS_LANGUAGE_T T1 where VALID_FLAG=1 ;

SELECT T1.* ,over(partition by LAN_CODE order by CREATED_DATE) FROM SYS_LANGUAGE_T T1 where VALID_FLAG=1 ;

select 
       LAN_ID lanId, 
		LAN_CODE lanCode, 
    lan_value lanValue,
    LAN_TYPE lanType,
    (decode((LAN_TYPE),1,'Chinese','English')) lanTypeLab,
    (nvl((select TU.USER_NAME userName FROM SYS_USERS_T TU WHERE TU.USER_ID = to_char(T1.CREATED_USER)),T1.CREATED_USER) ) nameCn,
		ORDER_CODE orderCode, 
		CREATED_USER createdUser,
		TO_CHAR(CREATED_DATE,'yyyy/mm/dd HH24:MI') createdDate, 
		UPDATE_LAST_USER updateLastUser,
		UPDATE_LAST_DATE updateLastDate,
       row_number() over(partition by LAN_CODE order by CREATED_DATE) groupIndex
  FROM SYS_LANGUAGE_T T1
 where VALID_FLAG = 1;


SELECT *
  FROM (SELECT TT.*, ROWNUM RN
          FROM (SELECT LAN_ID lanId,
                       LAN_CODE lanCode,
                       lan_value lanValue,
                       LAN_TYPE lanType,
                       (decode((LAN_TYPE),0,0,1)) lanTypeLab,
                       remarks remarks,
                       ATTRIBUTE1 attribute1,
                       ATTRIBUTE2 attribute2,
                       ATTRIBUTE3 attribute3,
                       ATTRIBUTE4 attribute4,
                       ATTRIBUTE5 attribute5,
                       ATTRIBUTE6 attribute6,
                       ATTRIBUTE7 attribute7,
                       ATTRIBUTE8 attribute8,
                       ATTRIBUTE9 attribute9,
                       ATTRIBUTE10 attribute10,
                       (nvl((select TU.USER_NAME userName
                              FROM SYS_USERS_T TU
                             WHERE TU.USER_ID = to_char(T1.CREATED_USER)),
                            T1.CREATED_USER)) nameCn,
                       ORDER_CODE orderCode,
                       CREATED_USER createdUser,
                       CREATED_DATE createdDate,
                       UPDATE_LAST_USER updateLastUser,
                       UPDATE_LAST_DATE updateLastDate,
                       row_number() over(partition by LAN_CODE order by CREATED_DATE) groupIndex
                  FROM SYS_LANGUAGE_T T1
                 where VALID_FLAG = 1) TT)
 WHERE RN <= ?
   AND RN >= ?



insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.conf.delete.info', '确定要删除吗？', 1, '1.2.3组表格测试', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.conf.delete.info', 'Are you sure you want to delete it?', 2, '1.2.3组表格测试', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);


insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.label.save', '保存', 1, '1.2.3组表格测试', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.label.save', 'Save', 2, '1.2.3组表格测试', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.label.save', '저장', 3, '1.2.3组表格测试', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

------

insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.label.reset', '重置', 1, '分组排序测试,这里的ID已经乱了,需要排列在一起', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.label.add', '添加', 1, '分组排序测试,这里的ID已经乱了,需要排列在一起', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.label.reset', 'Reset', 2, '分组排序测试,这里的ID已经乱了,需要排列在一起', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

insert into SYS_LANGUAGE_T (LAN_ID, LAN_CODE, LAN_VALUE, LAN_TYPE, REMARKS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, ORDER_CODE, CREATED_USER, CREATED_DATE, UPDATE_LAST_USER, UPDATE_LAST_DATE, VALID_FLAG)
values (SYS_LANGUAGE_S.NEXTVAL, 'app.global.button.label.add', 'Add', 2, '分组排序测试,这里的ID已经乱了,需要排列在一起', null, null, null, null, null, null, null, null, null, null, null, 10001, sysdate, 10001, sysdate, 1);

commit;




