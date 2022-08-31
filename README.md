# lagou_edu_home_parent


## 依赖关系创建原则
    当前项目中用到哪个项目资源，那么当前项目就依赖要用到资源的项目（直接依赖和间接依赖）
    
![alt 模块依赖关系](images/模块依赖关系.PNG "模块依赖关系")



# upload目录部署之后才能访问已上传的文件
![alt 图片文件夹部署.PNG](images/图片文件夹部署.PNG "图片文件夹部署.PNG")

# Integer类型默认null，int类型默认0，在数据库插入默认值时要注意not null字段   

# 分页插件Mybatis-PageHelper新版的使用

https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md

```java
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO) {
        PageHelper.startPage(resourceVO.getCurrentPage(), resourceVO.getPageSize());
        
        List<Resource> resourceList = resourceMapper.findAllResourceByPage(resourceVO);
        PageInfo<Resource> pageInfo = new PageInfo<>(resourceList);
        
        return pageInfo;
    }
```

# 前端整型传的值为 0 dao层当作''处理的解决方式
# Mybatis中mapper.xml参数为0时，参数不能生效
```xml
    <select id="findCourseByCondition" resultType="org.example.domain.Course"
            parameterType="org.example.domain.CourseVO">
        select * from course
        <where>
            <if test="courseName != null and courseName !=''">
                and course_name like concat('%', #{courseName},'%')
            </if>
            <!-- 加 "or status == 0" 解决传入为0时，当作'' -->
            <!--            <if test="status != null and status !='' or status == 0">-->
            <if test="status != null">
                and status = #{status, jdbcType=INTEGER}
            </if>
            <if test="true">
                and is_del != 1
            </if>
        </where>
    </select>
```