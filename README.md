# xueta
学他项目后端代码

# 学他接口文档 0.1.2版

**统一返回码**

```
0000		一切正常
1000       	用户密码错误
1001		token错误
1002		操作失败
1003		用户注册失败
2000       	用户操作异常
2001		表单参数错误
```



### 用户登录

**url：**/login

**method：**post

| 字段名   | 字段类型 | 是否必填 | 备注 |
| -------- | -------- | -------- | ---- |
| username | string   | 是       |      |
| password | string   | 是       |      |

示例：

```json
{
    "username" : "username",
    "password" : "password"
}
```



**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "token" : "token"
    }
}
```



### 用户注册

##### 获取验证码

**url：**/register/verification

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注       |
| ------ | -------- | -------- | ---------- |
| phone  | string   | 是       | 获取验证码 |

示例：

```json
{
    "phone" : "phone"
}
```

**后端无返回**



##### 注册

**url：**/register/user

**method：**post

| 字段名       | 字段类型 | 是否必填 | 备注       |
| ------------ | -------- | -------- | ---------- |
| username     | string   | 是       |            |
| password     | string   | 是       |            |
| phone        | string   | 是       |            |
| verification | string   | 是       | 手机验证码 |

示例：

```json
{
    "username" : "username",
    "password" : "password",
    "phone" : "phone",
    "verification" : "verification"
    
}
```



**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "token" : "token"
    }
}
```



### 获取名言

**url：**/aphorism

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

```json
{
    "token" : "token"
}
```

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名   | 字段类型 | 是否必填 | 备注 |
| -------- | -------- | -------- | ---- |
| aphorism | string   | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "aphorism" : "aphorism"
    }
}
```



### 用户修改信息

**url：**/modify

**method：**post

| 字段名   | 字段类型 | 是否必填 | 备注                           |
| -------- | -------- | -------- | ------------------------------ |
| token    | string   | 是       | 通过请求参数传输 @RequestParam |
| nickName | string   | 否       | 通过请求参数传输 @RequestParam |
| head     | image    | 否       | 通过请求参数传输 @RequestParam |



**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message"
}
```



### 用户修改信息

**url：**/changePassword

**method：**post

| 字段名      | 字段类型 | 是否必填 | 备注 |
| ----------- | -------- | -------- | ---- |
| token       | string   | 是       |      |
| oldPassword | string   | 是       |      |
| newPassword | string   | 是       |      |

示例：

```json
{
    "token" : "token",
    "oldPassword" : "oldPassword",
    "newPassword" : "newPassword"
}
```



**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |

示例

```json
{
    "code" : "code",
    "message" : "message"
}
```

### 查看用户信息

**url：**/getUserInfo

**method：**post

```json
{
    "token" : "token",
    "username" : "username"
}
```



```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "allTime" : "allTime",
        "allNumber" : "allNumber",
		"avgTime" : "avgTime",
        "time" : "time",
        "number" : "number",
        "info" : [
            {
                "name" : "name",
                "size" : "size"
            },{
                "name" : "name",
                "size" : "size"
            }
        ]
    }
}
```



### 找回密码

##### 第一次

**url：**/forget/getUser

**method：**post

| 字段名   | 字段类型 | 是否必填 | 备注                     |
| -------- | -------- | -------- | ------------------------ |
| username | string   | 是       | 可以填写手机当作username |

示例：

```json
{
    "username" : "username"
}
```



**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注                                     |
| ------ | -------- | -------- | ---------------------------------------- |
| phone  | string   | 是       | 不是完整的手机号，类似于186* * * * * 020 |
| token  | string   | 是       | 用于标记用户与获得短信发送权限token      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "phone" : "phone",
        "token" : "token"
    }
}
```



##### 第二次

**url：**/forget/verification

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注                  |
| ------ | -------- | -------- | --------------------- |
| token  | string   | 是       | 第一次获取的短信token |

示例：

```json
{
    "token" : "token"
}
```



**后端无返回**



##### 第三次

**url：**/forget/checkVerification

**method：**post

| 字段名       | 字段类型 | 是否必填 | 备注                   |
| ------------ | -------- | -------- | ---------------------- |
| token        | string   | 是       | 第一次获取的短信token  |
| verification | string   | 是       | 电话上获得的短信验证码 |

示例：

```json
{
    "token" : "token",
    "verification" : "verification"
}
```



**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注                    |
| ------ | -------- | -------- | ----------------------- |
| token  | string   | 是       | 用户更改密码权限的token |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "token" : "token"
    }
}
```



##### 第四次

**url：**/forget/changePassword

**method：**post

| 字段名   | 字段类型 | 是否必填 | 备注                  |
| -------- | -------- | -------- | --------------------- |
| token    | string   | 是       | 第三次获取的短信token |
| password | string   | 是       | 修改的新密码          |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message"
}
```



**npc交互逻辑图**

![image-20210206214930109](https://hanzoy-picture.oss-cn-chengdu.aliyuncs.com/img/image-20210206214930109.png)

### 铜钱

##### 提交个人时长

**url：**/postPersonTime

**method：**post

```json
{
    "token" : "token",
    "time" : "time",
    "group" : [
        {
            "id" : "id",
            "number" : "number"
        },{
            "id" : "id",
            "number" : "number"
        }...
    ],
    "sign" : "sign",//调用（token+time）
    "label" : "label"
}
```



##### 提交小组学习时长

**url：**/postTeamTime

**method：**post

```json
{
    "token" : "token",
    "time" : "time",
    "group" : [
        {
            "id" : "id",
            "number" : "number"
        },{
            "id" : "id",
            "number" : "number"
        }...
    ],
    "sign" : "sign",//调用（token+time）
    "label" : "label"
}
```





##### 查询铜钱

**url：**/queryMoney

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| money  | int      | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "money" : "money"
    }
}
```



### 获取商店列表

##### 获取商店道具列表

**url：**/story/getPropList

**method：**post

**前端无参数**

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
|        |          |          |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "count" : "count",
        "info" : [
            {
                "id" : "id",
                "name" : "name",
                "picture" : "picture",
                "description" : "description",
                "price" : "price"
            },
            {
                "id" : "id",
                "name" : "name",
                "picture" : "picture",
                "description" : "description",
                "price" : "price"
            }
            ...
        ]
    }
}
```

##### 获取商店角色列表

**url：**/story/getRoleList

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
|        |          |          |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "count" : "count",
        "info" : [
            {
                "id" : "id",
                "name" : "name",
                "picture" : "picture",
                "description" : "description",
                "price" : "price",
                "isHaving" : "true"
            },
            {
                "id" : "id",
                "name" : "name",
                "picture" : "picture",
                "description" : "description",
                "price" : "price",
                "isHaving" : "true"
            }
            ...
        ]
    }
}
```

### 购买物品

##### 购买道具

**url：**/story/buyProps

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |
| id     | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| money  | int      | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "money" : "money"
    }
}
```

##### 购买角色

**url：**/story/buyRoles

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |
| id     | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| money  | int      | 是       |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "money" : "money"
    }
}
```



### NPC互动

##### 获取角色列表

**url：**/role/getInfo

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
|        |          |          |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "count" : "count",
        "info" : [
            {
                "id" : "id",
                "name" : "name",
                "dynasty" : "dynasty",
                "tradename" : "tradename",
                "picture" : "picture",
                "portrait" : "portrait",
                "description" : "description",
                "favor" : "favor",
                "isDialogue" : "true"
            },
            {
                "id" : "id",
                "name" : "name",
                "dynasty" : "dynasty",
                "tradeName" : "tradeName",
                "picture" : "picture",
                "portrait" : "portrait",
                "description" : "description",
                "favor" : "favor",
                "isDialogue" : "false"
            }
            ...
        ]
    }
}
```

##### 获取角色对话

**url：**/role/getDialogue

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |
| id     | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
|        |          |          |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "isContinue" : "true",
        "info" : {
            "Reid" : "Reid",
        	"content" : [
                "content",
                "content",
                "content"
            ],
            "reply" : [
                "xxxx",
                "xxxx",
                "xxxx"
            ]
        } 
    }
}
```

##### 回复角色消息

**url：**/role/reply

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注            |
| ------ | -------- | -------- | --------------- |
| token  | string   | 是       |                 |
| id     | string   | 是       |                 |
| order  | int      | 是       | 选项顺序 0 开始 |
| Reid   | string   | 是       | 剧情交流id      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
|        |          |          |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "isContinue" : "true",
        "info" : {
            "Reid" : "Reid",
        	"content" : [
                "content",
                "content",
                "content"
            ],
            "reply" : [
                "xxxx",
                "xxxx",
                "xxxx"
            ]
        },
        "pyc" : {
            "id" : "id",
            "name" : "name",
            "headPicture" : "headPicture",
            "content" : "content",
            "picture" : "picture"
        }
    }
}
```

### 获取排行榜

##### 获取新晋榜

**url：**/rankingList/getEmerging

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
|        |          |          |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "total" : "total",
    	"info" : [
            {
                "id" : "id",
                "time" : "time"
            },
            {
                "id" : "id",
                "time" : "time"
            }
            ...
        ]
    }
}
```



##### 获取总榜

**url：**/rankingList/getGeneral

**method：**post

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
| token  | string   | 是       |      |

**后端返回**

| 字段名  | 字段类型 | 是否必填 | 备注 |
| ------- | -------- | -------- | ---- |
| code    | string   | 是       |      |
| message | string   | 是       |      |
| data    | object   | 是       |      |

data：

| 字段名 | 字段类型 | 是否必填 | 备注 |
| ------ | -------- | -------- | ---- |
|        |          |          |      |

示例：

```json
{
    "code" : "code",
    "message" : "message",
    "data" : {
        "total" : "total",
    	"info" : [
            {
                "id" : "id",
                "allTime" : "allTime"
            },
            {
                "id" : "id",
                "allTime" : "allTime"
            }
            ...
        ]
    }
}
```

