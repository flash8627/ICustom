
select table_name from  user_tables;

SELECT COUNT(1) FROM SYS_LOOKUP_CLASSIFY_T where 1=1 ;

select *
  from (select TP.*, rownum rn
          from (
              select * from SYS_LOOKUP_CLASSIFY_T 
              order by class_id asc
          ) TP
         where rownum <= 5)
 where rn >= 2;

SELECT * 
       FROM ( 
          ) TP
		 
	and rn >= 2
    
  SELECT * FROM (
         SELECT tp.* , ROWNUM RN FROM 
            (
              SELECT 
          CLASS_ID, CLASS_NAME, CLASS_CODE, ORDER_CODE, CREATED_USER,
          CREATED_DATE, UPDATE_LAST_USER,
          UPDATE_LAST_DATE,
          VALID_FLAG 
          FROM SYS_LOOKUP_CLASSIFY_T 
          where 1=1 
          order by class_id asc 
            )tp  where ROWNUM  <= 5 
  ) WHERE rn>=2
            
            
