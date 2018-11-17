core是项目的核心模块，结构初步规划如下：

base是项目的基础核心，定义一些基础类，如BaseController、BaseService等；

cache是缓存相关；

config是配置中心，模块所有的配置放到config里统一管理；

constants里定义系统的常量。

exception里封装一些基础的异常类；

system是系统模块；

util里则是一些通用工具类；