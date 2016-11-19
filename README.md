### 功能点
* 用户登录,手机号,用户ID,昵称
* 建团,谁创建的,都有谁
* 添加消费,属于哪个团,多少钱,备注,是否已结算,谁消费的
* 团记录,可结算,显示未结算的,总消费的
* 操作记录
* 邀请人,谁邀请了,谁进入某个团

##### 用户表 USER

字段名 | 含义 | 备注 | 类型
---|---|---|---
USER_ID | 用户ID | 10000000000序列 | String
MOBILE_PHONE | 手机号 | 国内的 | String
PASSWORD | 密码 | MD5 | String
NICK_NAME | 昵称 | 显示用的 | String
USER_TYPE | 用户类型 | 0:虚拟用户 1:注册用户 | int
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date

---

##### 团 GROUP

字段名 | 含义 | 备注 | 类型
---|---|---|---
GROUP_ID | 团ID | 20000000000序列 | String
NICK_NAME | 昵称 | 显示用的 | String
CREATE_USER | 创建人 | 可以显示为团长 | String
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date

---

##### 团与团员 GROUP_USER
字段名 | 含义 | 备注 | 类型
---|---|---|---
GROUP_USER_ID | 团-员ID | 30000000000序列 | String
GROUP_ID | 团ID |  | String
USER_ID | 用户ID |  | String
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date

---
#### 消费记录 purchase_history
字段名 | 含义 | 备注 | 类型
---|---|---|---
HIS_ID | 主键 |  | String
GROUP_ID | 团ID |  | String
CREATE_USER | 创建人 |  | String
AMOUNT | 金额 |  | double
REMARK | 备注 |  | String
STATUS | 状态 | 0:无效1:有效 | int
CLEAR_FLAG | 结算状态 | 0:未结算1:已结算 | int
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date

#### 消费谁花的钱COST_USER
字段名 | 含义 | 备注 | 类型
---|---|---|---
COST_ID | 主键 |  | String
GROUP_ID | 团ID | 确定这是哪个团的 | String
HIS_ID | 消费记录主键 | 根据这个查看这条记录是谁花的钱 | String
USER_ID | 用户ID |  | String
AMOUNT | 金额 |  | double
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date

#### 功能点
##### 1: 用户
* 注册
* 登录
* 查找已注册的用户
##### 2: 团
* 建团
* 查看团员
* 添加团员
##### 3: 消费记录
* 添加消费
* 结清

### 问题
1. 长连接问题,客户端用户登录

