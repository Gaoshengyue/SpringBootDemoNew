# SpringBoot框架Demo
##背景
使用springboot框架搭建后台服务demo，用于基础通用框架搭建及学习
##目录结构
```shell script

├── core
│   ├── core.iml
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   └── resources
│       └── test
│           └── java
├── pom.xml
├── README.md
├── service
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── springBootDemo
│   │   │   │           ├── ApplicationClass.java
│   │   │   │           ├── common
│   │   │   │           │   ├── advice
│   │   │   │           │   │   ├── 说明.md
│   │   │   │           │   │   └── ControllerResponseAdvice.java
│   │   │   │           │   ├── annotation
│   │   │   │           │   │   └── IgnoreResponseAdvice.java
│   │   │   │           │   ├── Constants.java
│   │   │   │           │   ├── exception
│   │   │   │           │   │   └── PublicException.java
│   │   │   │           │   └── ExceptionDto.java
│   │   │   │           ├── config
│   │   │   │           │   └── CommonConfig.java
│   │   │   │           ├── dto
│   │   │   │           │   └── CommonRespDto.java
│   │   │   │           └── framework
│   │   │   │               ├── controller
│   │   │   │               │   └── auth
│   │   │   │               │       └── AuthController.java
│   │   │   │               ├── dto
│   │   │   │               │   └── auth
│   │   │   │               │       └── LoginDto.java
│   │   │   │               ├── entity
│   │   │   │               ├── enums
│   │   │   │               ├── exception
│   │   │   │               │   └── ExceptionType.java
│   │   │   │               ├── mapper
│   │   │   │               │   └── AuthMapper.java
│   │   │   │               ├── product
│   │   │   │               ├── service
│   │   │   │               │   └── auth
│   │   │   │               │       ├── AuthService.java
│   │   │   │               │       └── impl
│   │   │   │               │           └── LoginServiceImpl.java
│   │   │   │               ├── utils
│   │   │   │               └── vo
│   │   │   │                   └── auth
│   │   │   │                       ├── AntLoginRequestVo.java
│   │   │   │                       └── LoginVo.java
│   │   │   └── resources
│   │   │       ├── application.yml
│   │   │       └── mapper
│   │   └── test
│   │       └── java
└── SpringBootDemo.iml

```
core用于自主包的引用
service用于服务逻辑

