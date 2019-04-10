# high-song

#### 核心依赖 
依赖 | 版本
---|---
Spring Boot |  2.1.3.RELEASE  
Spring Cloud | Greenwich.RELEASE   
Spring Security OAuth2 | 2.3.3
Mybatis Plus | 3.1.0

#### 模块说明
```
├── pig-auth -- 授权服务提供[3000]
└── pig-common -- 系统公共模块 
     ├── pig-common-core -- 公共工具类核心包
     ├── pig-common-log -- 日志服务
     └── pig-common-security -- 安全工具类
├── pig-config -- 配置中心[8888]
├── pig-gateway -- Spring Cloud Gateway网关[9999]
└── pig-upms -- 通用用户权限管理模块
     └── pigx-upms-api -- 通用用户权限管理系统公共api模块
     └── pigx-upms-biz -- 通用用户权限管理系统业务处理模块[4000]
└── pigx-visual  -- 图形化模块 
     ├── pigx-monitor -- Spring Boot Admin监控 [5001]
     └── pigx-codegen -- 图形化代码生成[5003]
	 
```