-- 自连接查询（一张表当两张表）
-- 基于mybatis嵌套查询完成
-- 先查询顶级（父级）菜单 （parent_id = -1）
SELECT * FROM menu WHERE parent_id = -1;
-- 顶级菜单所关联的子级菜单 select = "namespace.id" column="id"
SELECT * FROM menu WHERE parent_id = 1;


-- 根据角色id查询该角色关联菜单信息的id
SELECT
  m.id
FROM
  roles r
  INNER JOIN role_menu_relation rm
    ON r.id = rm.role_id
  INNER JOIN menu m
    ON m.id = rm.menu_id
WHERE r.id = 2;

