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


```
DROP TABLE IF EXISTS gm_user;
CREATE TABLE gm_user
 ( 
 user_id varchar(11) NOT NULL,
mobile_phone varchar(20) DEFAULT NULL,
password varchar(50) DEFAULT NULL,
nick_name varchar(24) DEFAULT NULL,
user_type int(1) DEFAULT NULL,
cre_date timestamp  not NULL DEFAULT CURRENT_TIMESTAMP,
mod_date timestamp NULL,
PRIMARY KEY (user_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table gm_user comment '用户';
alter table gm_user modify column user_id varchar(11) comment '用户ID';
alter table gm_user modify column mobile_phone varchar(20) comment '手机号';
alter table gm_user modify column password varchar(50) comment 'MD5密码';
alter table gm_user modify column nick_name varchar(24) comment '昵称';
alter table gm_user modify column user_type int(1) comment '用户类型0虚拟1注册';
alter table gm_user modify column cre_date timestamp comment '创建时间';
alter table gm_user modify column mod_date timestamp comment '修改时间';
```
---

##### 团 GROUP

字段名 | 含义 | 备注 | 类型
---|---|---|---
GROUP_ID | 团ID | 20000000000序列 | String
NICK_NAME | 昵称 | 显示用的 | String
CREATE_USER | 创建人 | 可以显示为团长 | String
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date

```
DROP TABLE IF EXISTS gm_group;
CREATE TABLE gm_group
( 
group_id varchar(11) NOT NULL,
nick_name varchar(24) DEFAULT NULL,
cre_user varchar(11) not null,
cre_date timestamp  not NULL DEFAULT CURRENT_TIMESTAMP,
mod_date timestamp NULL,
PRIMARY KEY (group_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table gm_group comment '团';
alter table gm_group modify column group_id varchar(11) comment '团ID';
alter table gm_group modify column nick_name varchar(24) comment '昵称';
alter table gm_group modify column cre_user varchar(11) comment '创建人';
alter table gm_group modify column cre_date timestamp comment '创建时间';
alter table gm_group modify column mod_date timestamp comment '修改时间';
```
---

##### 团与团员 GROUP_USER
字段名 | 含义 | 备注 | 类型
---|---|---|---
GROUP_USER_ID | 团-员ID | 30000000000序列 | String
GROUP_ID | 团ID |  | String
USER_ID | 用户ID |  | String
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date
```
DROP TABLE IF EXISTS gm_group_user;
CREATE TABLE gm_group_user
( 
gu_id varchar(11) NOT NULL,
group_id varchar(11) not NULL,
user_id varchar(11) not null,
cre_date timestamp  not NULL DEFAULT CURRENT_TIMESTAMP,
mod_date timestamp NULL,
PRIMARY KEY (gu_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table gm_group_user comment '团';
alter table gm_group_user modify column gu_id varchar(11) comment '团-用户关系ID';
alter table gm_group_user modify column group_id varchar(11) comment '团ID';
alter table gm_group_user modify column user_id varchar(11) comment '用户';
alter table gm_group_user modify column cre_date timestamp comment '创建时间';
alter table gm_group_user modify column mod_date timestamp comment '修改时间';
```
---
#### 消费记录 PURCHASE
字段名 | 含义 | 备注 | 类型
---|---|---|---
PUR_ID | 主键 |  | String
GROUP_ID | 团ID |  | String
CREATE_USER | 创建人 |  | String
AMOUNT | 金额 |  | double
REMARK | 备注 |  | String
STATUS | 状态 | 0:无效1:有效 | int
CLEAR_FLAG | 结算状态 | 0:未结算1:已结算 | int
CRE_DATE | 创建时间 | | Date
MOD_DATE | 修改时间 | | Date

```
DROP TABLE IF EXISTS gm_purchase;
CREATE TABLE gm_purchase
( 
pur_id varchar(11) NOT NULL,
group_id varchar(11) not NULL,
cre_user varchar(11) not null,
amount decimal not null default 0,
remark varchar(50) null,
status int(1) not null default 1,
clear_flag int(1) not null default 1,
cre_date timestamp  not NULL DEFAULT CURRENT_TIMESTAMP,
mod_date timestamp NULL,
PRIMARY KEY (pur_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table gm_purchase comment '团';
alter table gm_purchase modify column pur_id varchar(11) comment '消费记录';
alter table gm_purchase modify column group_id varchar(11) comment '团ID';
alter table gm_purchase modify column cre_user varchar(11) comment '创建用户';
alter table gm_purchase modify column amount decimal comment '消费金额';
alter table gm_purchase modify column remark varchar(50) comment '备注';
alter table gm_purchase modify column status int(1) comment '0:无效1:有效';
alter table gm_purchase modify column clear_flag int(1) comment '0:未结算1:已结算';
alter table gm_purchase modify column cre_date timestamp comment '创建时间';
alter table gm_purchase modify column mod_date timestamp comment '修改时间';

```
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

```
DROP TABLE IF EXISTS gm_cost_user;
CREATE TABLE gm_cost_user
( 
cost_id varchar(11) NOT NULL,
group_id varchar(11) not NULL,
pur_id varchar(11) not null,
user_id varchar(11) not null,
amount decimal not null default 0,
cre_date timestamp  not NULL DEFAULT CURRENT_TIMESTAMP,
mod_date timestamp NULL,
PRIMARY KEY (cost_id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table gm_purchase comment '团';
alter table gm_purchase modify column pur_id varchar(11) comment '消费记录';
alter table gm_purchase modify column group_id varchar(11) comment '团ID';
alter table gm_purchase modify column cre_user varchar(11) comment '创建用户';
alter table gm_purchase modify column amount decimal comment '消费金额';
alter table gm_purchase modify column remark varchar(50) comment '备注';
alter table gm_purchase modify column status int(1) comment '0:无效1:有效';
alter table gm_purchase modify column clear_flag int(1) comment '0:未结算1:已结算';
alter table gm_purchase modify column cre_date timestamp comment '创建时间';
alter table gm_purchase modify column mod_date timestamp comment '修改时间';
```


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
