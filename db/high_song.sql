drop table if exists dept;

/*==============================================================*/
/* Table: dept                                                  */
/*==============================================================*/
create table dept
(
   id                   varchar(32) comment '主键',
   parent_id            varchar(32) comment '父id',
   name                 varchar(64) comment '名称',
   sort                 int comment '排序',
   status               tinyint default 1 comment '状态 0-停用 1-启用 2-锁定 3-删除',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间'
);

alter table dept comment '部门表';

drop table if exists sys_dic;

/*==============================================================*/
/* Table: sys_dic                                               */
/*==============================================================*/
create table sys_dic
(
   id                   varchar(32) comment '主键id',
   value                varchar(64) comment '数据值',
   label              varchar(64) comment '标签名',
   type                 tinyint comment '类型',
   description          varchar(128) comment '描述',
   sort                 int comment '排序',
   remark               varchar(128) comment '备注信息',
   create_time          datetime  comment '创建时间',
   update_time          datetime  comment '更新时间'
);

alter table sys_dic comment '数据字典表';



drop table if exists oauth_client_details;

/*==============================================================*/
/* Table: oauth_client_details                                  */
/*==============================================================*/
create table oauth_client_details
(
   client_id            varchar(128) not null comment '客户端ID',
   resource_ids         varchar(256) comment '资源ID',
   client_secret        varchar(256) comment '客户端密钥',
   scope                varchar(256) comment '范围',
   authorized_grant_types varchar(256) comment '授权方式',
   web_server_redirect_uri varchar(256) comment 'WEB服务器重定向URI',
   authorities          varchar(256) comment '授权',
   access_token_validity int(11) comment 'access_token校验',
   refresh_token_validity int(11) comment 'refresh_token校验',
   additional_information varchar(4096) comment '附加信息',
   autoapprove          varchar(256) comment '自动批准',
   primary key (client_id)
);

alter table oauth_client_details comment 'oauth客户端详情';

drop table if exists sys_log;

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   id                   varchar(32) comment '主键ID',
   type                 tinyint default 1 comment '类型',
   title                varchar(64) comment '标题',
   service_id           varchar(64) comment '服务ID',
   create_visitor_id    varchar(32) comment '访问者ID',
   remote_addr          varchar(32) comment '操作IP地址',
   user_agent           varchar(128) comment '用户代理',
   request_uri          varchar(64) comment '请求URI',
   method               varchar(64) comment '操作方式',
   params               varchar(64) comment '操作提交的数据',
   execute_start_time   timestamp comment '执行开始时间',
   execute_end_time     timestamp comment '执行结束时间',
   exception            text comment '异常信息',
   status               tinyint default 1 comment '状态 0-删除 1-正常'
);

alter table sys_log comment '系统日志表';


drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(32) comment '主键ID',
   dept_id              varchar(32) comment '部门ID',
   username             varchar(64) comment '用户名',
   password             varchar(128) comment '密码',
   phone                varchar(11) comment '手机号码',
   email                varchar(64) comment '电子邮箱',
   nick_name            varchar(128) comment '昵称',
   online_status        tinyint comment '在线状态 0-下线 1-在线',
   avatar               varchar(256) comment '头像',
   status               tinyint default 1 comment '状态 0-停用 1-正常 2-锁定 3-删除',
   wx_open_id           varchar(64) comment '微信openid',
   qq_open_id           varchar(64) comment 'QQ openid',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间'
);

alter table user comment '用户表';


drop table if exists role;

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   varchar(32) comment '主键ID',
   name                 varchar(64) comment '名称',
   code                 varchar(32) comment '代码值',
   description          varchar(128) comment '描述',
   状态                   tinyint comment '状态 0-删除 1-正常',
   创建时间                 datetime comment '创建时间',
   更新时间                 datetime comment '更新时间'
);

alter table role comment '角色表';


drop table if exists resource;

/*==============================================================*/
/* Table: resource                                              */
/*==============================================================*/
create table resource
(
   id                   varchar(32) comment '主键id',
   name                 varchar(512) comment '名称',
   parent_id            varchar(32) comment '父id',
   url                  varchar(256) comment '链接地址',
   type                 tinyint comment '类型 0-菜单 1-按钮',
   icon                 longtext comment '图标',
   permission           varchar(64) comment '菜单权限标识',
   component            varchar(128) comment '前端组件',
   status               tinyint comment '状态 0-停用 1-启用',
   sort                 int comment '排序',
   keepAlive            tinyint comment '路由缓冲 0-否 1-是',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间'
);

alter table resource comment '资源菜单表';


drop table if exists user_role;

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   id                   varchar(32) comment '主键id',
   user_id              varchar(32) comment '用户id',
   role_id              varchar(32) comment '角色id'
);

alter table user_role comment '用户角色表';


drop table if exists role_resource;

/*==============================================================*/
/* Table: role_resource                                         */
/*==============================================================*/
create table role_resource
(
   id                   varchar(32) comment '主键id',
   role_id              varchar(32) comment '角色id',
   resource_id          varchar(32) comment '资源id'
);

alter table role_resource comment '角色菜单表';




