-- 根据用户id查询关联的角色信息
-- 用户和角色多对多
SELECT * FROM roles r INNER JOIN user_role_relation ur ON r.id = ur.role_id WHERE ur.user_id = 100030011;

-- 根据角色id，查询角色拥有的顶级菜单 -1
 SELECT
  DISTINCT m.*
FROM
  roles r
  INNER JOIN role_menu_relation rm
    ON r.id = rm.role_id
    INNER JOIN menu m ON m.id = rm.menu_id
    WHERE m.parent_id = -1 AND r.id IN (1,2);
    
-- 取用户拥有的资源权限信息
 SELECT DISTINCT
  r.*
FROM
  resource r
  INNER JOIN role_resource_relation rr
    ON r.id = rr.resource_id
  INNER JOIN roles ro
    ON ro.id = rr.role_id
WHERE ro.id IN (1, 2);

