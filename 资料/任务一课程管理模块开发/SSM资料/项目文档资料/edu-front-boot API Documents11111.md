# edu-front-boot API Documents


**简介**:edu-front-boot API Documents

**HOST**: edufront.lagou.com

**联系人**:子慕

**Version**:0.0.1

**接口路径**: /v2/api-docs?group=edu-front-boot



# 用户接口

## 用户基本信息

**接口地址**:`/front/user/findAllUser`

**请求方式**:`GET`

**请求数据类型**:`*`

**响应数据类型**:`*/*,application/json`

**接口描述**:获取所有用户基本信息，进行分页展示

**请求参数**:

| 参数名称              | 参数说明                 | in    | 是否必须 | 数据类型 | schema |
| --------------------- | ------------------------ | ----- | -------- | -------- | ------ |
| pageNum<br />PageSize | 当前页<br />每页显示条数 | query | false    | string   |        |

**响应状态**:


| 状态码 | 说明         | schema                          |
| ------ | ------------ | ------------------------------- |
| 1      | success      |                                 |
| 200    | OK           | ResponseDTO«Map«string,object»» |
| 401    | Unauthorized |                                 |
| 403    | Forbidden    |                                 |
| 404    | Not Found    |                                 |
| -1     | login fail   |                                 |

**响应参数**:


| 参数名称 | 参数说明 | 类型           | schema         |
| -------- | -------- | -------------- | -------------- |
| success  |          | boolean        |                |
| state    |          | integer(int32) | integer(int32) |
| message  |          | string         |                |
| content  |          | object         |                |

**响应示例**:

```javascript
{
	"success": true,
	"state": 200,
	"message": "",
	"content": {}
}
```





























