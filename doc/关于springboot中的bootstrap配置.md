## bootstrap.yml

普通的spring boot项目及时配置了`bootstrap.yml`也不会生效,默认只加载`application.properties`文件呢，如果非要用bootstrap作为启动加载文件则需要引入 spring-cloud-context 该依赖。

```
<!--引入springcloud上下文依赖，使bootstrap配置文件生效-->  
<dependency>  
<groupId>org.springframework.cloud</groupId>  
<artifactId>spring-cloud-context</artifactId>  
</dependency>
```

但是spring cloud项目因为引入了`spring-cloud-starter-netflix-eureka-client`依赖，自动引入了上面的依赖，`bootstrap.yml`文件就会生效。
可以通过设置`spring.cloud.bootstrap.enabled=false`来禁用`bootstrap`。
