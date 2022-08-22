DROP DATABASE IF EXISTS ssmtest;
CREATE DATABASE ssmtest;
USE ssmtest;
CREATE TABLE test(
	id INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(32) DEFAULT NULL,
	PRIMARY KEY(id) 
) CHARACTER SET = utf8;



SELECT DATABASE();

SHOW CREATE DATABASE ssm_lagou_edu;


# 查看数据库编码
SHOW VARIABLES LIKE 'character%';

-/*
	character_set_client 为客户端编码方式；
	character_set_connection 为建立连接使用的编码；
	character_set_database 为数据库的编码；
	character_set_results 为结果集的编码；
	character_set_server 为数据库服务器的编码；
*/

SELECT LAST_INSERT_ID();

SELECT
  c.*,
  t.teacher_name teacher_name,
  t.position POSITION
FROM
  course c
  LEFT JOIN teacher t
    ON c.id = t.course_id
WHERE c.id = 16;
  
-- 查询课程id为7对应的章节信息及关联的课时信息
 SELECT
  cs.*,
  cl.id lesson_id,
  cl.course_id,
  cl.section_id,
  cl.theme,
  cl.duration,
  cl.create_time,
  cl.update_time,
  cl.is_del lesson_is_del, # cs中有同名字段
  cl.order_num lesson_order_num,
  cl.status lesson_status
FROM
  course_section cs
  LEFT JOIN course_lesson cl
    ON cl.section_id = cs.id
WHERE cs.course_id = 7
ORDER BY cs.order_num;


select * from promotion_space;

