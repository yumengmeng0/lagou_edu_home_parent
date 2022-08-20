# SSM项目接口文档

## 1.课程模块

### 1.1 查询&条件查询

**接口地址**: http:/http://localhost:8080/ssm_web/course/findAllCourse 

**请求方式**: POST

**接口描述**: 分页获取课程列表数据&多条件查询

**请求参数**:

| 参数名称    | 参数说明 | in   | 是否必须 | 数据类型       | schema |
| ----------- | -------- | ---- | -------- | -------------- | ------ |
| currentPage |          |      | false    | integer(int32) |        |
| pageSize    |          |      | false    | integer(int32) |        |
| courseName  |          |      | false    | string         |        |
| status      |          |      | false    | integer(int32) |        |

**请求示例**:

```json
{
	"currentPage": 1,
	"pageSize": 5,
	"courseName": "Vue.js 3.0 核心源码解析",
	"status": 1
}
```

**响应参数**:

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例**:

```json
{
	"success": true,
	"state": 0,
	"message": "响应成功",
	"content": {课程数据}
}
```

### 1.2 图片上传接口

**接口地址**: http:/http://localhost:8080/ssm_web/course/courseUpload

**请求方式**: POST

**接口描述**: 课程模块图片上传

**请求参数:**

```
file=1597112871741.JPG
```

**响应参数**:

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例:**

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "fileName": "1597112871741.JPG",
        "filePath": "http://localhost:8080/upload/1597112871741.JPG"
    }
}
```

### 1.3 新建&修改课程接口

**接口地址**: http:/http://localhost:8080/ssm_web/course/saveOrUpdateCourse 

**请求方式**: POST

**接口描述**: 新建课程或修改课程

**请求参数**: 

| 字段                         | 说明        | 类型   | 是否必需 | 备注                                 |
| ---------------------------- | ----------- | ------ | -------- | ------------------------------------ |
| id                           | 课程id      | int    | 否       | 添加操作不用携带, 修改操作必须携带ID |
| courseName                   | 课程名称    | String | 是       |                                      |
| brief                        | 课程简介    | String | 是       | 一句话介绍课程                       |
| teacherName                  | 讲师名称    | String | 是       |                                      |
| description                  | 讲师介绍    | String | 是       |                                      |
| position                     | 讲师职位    | String | 是       |                                      |
| previewFirstField            | 课程概述1   | String | 是       | 第一段描述 例如: 课程共15讲          |
| previewSecondField           | 课程概述2   | String | 是       | 第二段描述 例如: 每周五更新          |
| discounts                    | 售卖价格    | double | 是       | 课程的售卖价格                       |
| price                        | 商品原价    | double | 是       | 课程的原销售价                       |
| discountsTag                 | 活动标签    | String | 是       | 例如: 立即抢购                       |
| courseImgUrl                 | 课程图片url | String | 是       |                                      |
| courseListImg                | 封面图url   | String | 是       |                                      |
| sortNum                      | 课程排序    | int    | 是       |                                      |
| course_description_mark_down | 课程描述    | String | 是       |                                      |
| sales                        | 销量        | int    | 是       |                                      |

**请求示例**

```json
//新增
{
    "courseName":"大数据云计算",
    "brief":"海量大数据课程",
    "teacherName":"维尼",
    "description":"多年企业实战经验",
    "position":"高级讲师",
    "previewFirstField":"共10讲",
    "previewSecondField":"每周四更新",
    "discounts":66.6,
    "price":88,
    "discountsTag":"先到先得",
    "courseImgUrl":"http://localhost:8080/upload/1596520226925.jpg",
    "courseListImg":"http://localhost:8080/upload/1596520226925.jpg",
    "sortNum":1,
    "courseDescriptionMarkDown":"介绍当前流行大数据技术，数据技术原理，并介绍其思想，介绍大数据技术培训课程，概要介绍。",
    "sales":100
}

//修改
{
	"id":15,
    "courseName":"全栈工程师",
    "brief":"掌握多种技能，胜任前端与后端",
    "teacherName":"药水哥",
    "description":"多年企业实战经验",
    "position":"高级讲师",
    "previewFirstField":"共10讲",
    "previewSecondField":"每周四更新",
    "discounts":66.6,
    "price":88,
    "discountsTag":"先到先得",
    "courseImgUrl":"http://localhost:8080/upload/1596520226925.jpg",
    "courseListImg":"http://localhost:8080/upload/1596520226925.jpg",
    "sortNum":1,
    "courseDescriptionMarkDown":"介绍当前流行大数据技术，数据技术原理，并介绍其思想，介绍大数据技术培训课程，概要介绍。",
    "sales":100
}
```



**响应参数**:

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例**

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": null
}
```

### 1.4 根据id查询课程信息

- 名称: **findCourseById**
- 描述: 根据id查询课程信息
- URL: http:/http://localhost:8080/ssm_web/course/findCourseById
- 请求方式: GET
- 请求实例：http:/http://localhost:8080/ssm_web/course/findCourseById?id=16
- 请求参数

| 字段 | 说明   | 类型 | 是否必需 | 备注 |
| ---- | ------ | ---- | -------- | ---- |
| id   | 课程id | int  | 是       |      |

- 响应结果示例

```
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": 课程信息
}
```



### 1.5 课程状态管理

**接口地址**: http:/http://localhost:8080/ssm_web/course/updateCourseStatus

**请求方式**: GET

**接口描述**: 修改课程状态

**请求参数**: 

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | 备注         |
| -------- | -------- | ---- | -------- | -------- | ------------ |
| id       | 课程id   |      | true     | int      |              |
| status   | 课程状态 |      | true     | int      | 最新的状态值 |

**请求示例:**

```
http:/http://localhost:8080/ssm_web/course/updateCourseStatus?status=1&id=15
```

**响应参数:**

| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例:**

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "status": 1
    }
}
```



### 1.6 课程内容展示

**接口地址**: http:/http://localhost:8080/ssm_web/courseContent/findSectionAndLesson

**请求方式**: GET

**接口描述**: 根据课程ID查询章节与课时信息

**请求参数**: 

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| courseId | 课程id   |      | true     | int      |        |

- 请求示例

```
http:/http://localhost:8080/ssm_web/courseContent/findSectionAndLesson?courseId=7
```



- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": [
        {
            "id": 7,
            "courseId": 7,
            "sectionName": "开篇词 | 从小白到文案高手，手把手教你写出爆款文案",
            "description": "你好，我是兔妈！第一次见面，我用几句话简单介绍下自己",
            "createTime": null,
            "updateTime": null,
            "isDe": 0,
            "orderNum": 1,
            "status": 2,
            "lessonList": [
                {
                    "id": 9,
                    "courseId": 7,
                    "sectionId": 7,
                    "theme": "手把手教你写出爆款文案",
                    "duration": 0,
                    "isFree": 0,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 1,
                    "status": 2
                },
                {
                    "id": 8,
                    "courseId": 7,
                    "sectionId": 7,
                    "theme": "从小白到文案高手",
                    "duration": 0,
                    "isFree": 1,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 1,
                    "status": 2
                }
            ]
        },
        {
            "id": 8,
            "courseId": 7,
            "sectionName": "重点内容总结",
            "description": "重点内容总结",
            "createTime": null,
            "updateTime": null,
            "isDe": 0,
            "orderNum": 2,
            "status": 2,
            "lessonList": [
                {
                    "id": 11,
                    "courseId": 7,
                    "sectionId": 8,
                    "theme": "内容总结",
                    "duration": 0,
                    "isFree": 0,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 2,
                    "status": 2
                },
                {
                    "id": 10,
                    "courseId": 7,
                    "sectionId": 8,
                    "theme": "重点内容",
                    "duration": 0,
                    "isFree": 0,
                    "createTime": null,
                    "updateTime": null,
                    "isDel": 0,
                    "orderNum": 2,
                    "status": 2
                }
            ]
        }
    ]
}
```

### 1.7 回显章节对应的课程信息

- 名称: **findCourseById**
- 描述:  回显章节对应的课程信息
- URL: http:/http://localhost:8080/ssm_web/courseContent/findCourseByCourseId
- 请求方式: GET
- 请求参数

| 参数名称 | 参数说明 | in   | 是否必须 | 数据类型 | schema |
| -------- | -------- | ---- | -------- | -------- | ------ |
| courseId | 课程id   |      | true     | int      |        |

- 请求示例

```
http:/http://localhost:8080/ssm_web/courseContent/findCourseByCourseId?courseId=15
```

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "id": 19,
        "courseName": "全栈工程师",
    }
}
```

### 1.8 新建&修改章节信息

- 名称: **saveOrUpdateSection**
- 描述: 保存和修改章节信息
- URL: http:/http://localhost:8080/ssm_web/courseContent/saveOrUpdateSection
- 请求方式: POST
- 请求参数

| 字段         | 说明     | 类型   | 是否必需 | 备注                                 |
| ------------ | -------- | ------ | -------- | ------------------------------------ |
| id           | 章节ID   | int    | 否       | 添加操作不携带id, 修改操作必须携带ID |
| course_id    | 课程ID   | int    | 是       |                                      |
| section_name | 章节名称 | String | 是       |                                      |
| description  | 章节描述 | String | 是       |                                      |
| order_num    | 章节排序 | int    | 是       |                                      |

- 请求参数示例

```json
//新增
{
    "courseId":8,
    "sectionName":"Vue脚手架",
    "description":"快速搭建Vue项目",
    "orderNum":2
}

//修改
{
	"id":13,
    "sectionName":"Vue路由",
    "description":"单页面应用导航",
    "orderNum":0
}
```

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": null
}
```

### 1.9 修改章节状态

- 名称: **updateSectionStatus**
- 描述: 修改章节状态
- URL: http:/http://localhost:8080/ssm_web/courseContent/updateSectionStatus
- 请求方式: GET
- 请求参数

| 字段   | 说明     | 类型 | 是否必需 | 备注                               |
| ------ | -------- | ---- | -------- | ---------------------------------- |
| id     | 章节ID   | int  | 是       |                                    |
| status | 章节状态 | int  | 是       | 状态，0:隐藏；1：待更新；2：已发布 |

- 请求示例

```
http:/http://localhost:8080/ssm_web/courseContent/updateSectionStatus?id=7&status=1
```

- 响应结果示例

```json
{
    "success": true,
    "state": 200,
    "message": "响应成功",
    "content": {
        "status": 1
    }
}
```

### 2.0 新建课时信息

- 名称: **saveLesson**
- 描述: 保存课时信息
- URL: http:/http://localhost:8080/ssm_web/courseContent/saveLesson 
- 请求方式: POST
- 请求参数

| 字段      | 说明                   | 类型   | 是否必需 | 备注                                 |
| --------- | ---------------------- | ------ | -------- | ------------------------------------ |
| id        | 课时ID                 | int    | 否       | 添加操作不携带id, 修改操作必须携带ID |
| courseId  | 课程ID                 | int    | 是       |                                      |
| sectionId | 章节ID                 | int    | 是       |                                      |
| theme     | 课时名称               | String | 是       |                                      |
| duration  | 课时时长(分钟)         | int    | 是       |                                      |
| isFree    | 是否免费,0 免费,1 付费 | int    | 是       |                                      |
| orderNum  | 排序字段               | int    | 是       |                                      |

- 请求示例

```json
//新建
{
    "courseId":7,
    "sectionId":7,
    "theme":"文案高手养成",
    "duration":15,
    "isFree":0,
    "orderNu":2
}


```































