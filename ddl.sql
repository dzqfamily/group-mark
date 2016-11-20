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

