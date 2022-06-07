### Swagger3

删除了对springfox-swagger2的依赖；
删除所有@EnableSwagger2...注解；
添加了springfox-boot-starter依赖项；
移除了guava等第三方依赖


### 在SpringBoot项目的pom.xml中引入Swagger3依赖：

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>

而swagger的开启与关闭可在application.properties中进行配置：
### 生产环境需设置为false
springfox.documentation.swagger-ui.enabled=true

### 配置类：SwaggerConfig

### 访问地址：http://localhost:8002/spring-security/swagger-ui/index.html

### error: 解决spring2.6.x版本以上兼容swagger: Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER


### 在SpringBoot项目的pom.xml中引入knife4j依赖：
<dependency>
    <groupId>com.github.xiaoymin</groupId>
    <artifactId>knife4j-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>

# 是否停用Knife4j文档
knife4j:
production: false

# 访问地址：http://localhost:8002/spring-security/doc.html#/home
