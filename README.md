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

# bug
## 1. 查询课时列表为空时会有一个只有id的对象
## 2. 资源分类修改后没有页面立即更新
Promise函数内部获取数据的问题
    
    
# 巧妙mybatis避免Where 空条件的尴尬 

https://blog.csdn.net/qq_43842093/article/details/121728251  
    
# GET请求多个参数，在web层处理（参数多了用VO，参数少了直接多个变量接收）
    1. 参数是映射到VO对象，向dao层传VO对象
    2. 直接接收参数，dao层使用@Param映射到对应字段
    
    
# Circular placeholder reference 'jdbc.url' in property definitions

https://blog.csdn.net/xiaoyaotan_111/article/details/76422923



