# Spring Security - Basic Authentication

## Build Project

1. Import Spring Boot Web Starter in build.gradle
2. Create Applicatoin.java in some package. If the class not in any package, the application will report error. Also, the behaviour is discouraged.

```java
package rifu.demo.spring.basic_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

3. Create a Controller and run application to test if configurations correct or not by call api.

## Import Spring Boot and Spring JPA

1. Add dependencies in build.gradle

2. We met problem when using Spring 2.0.2.RELEASE with postgres jdbc.  
  
    It always show 
`java.sql.SQLFeatureNotSupportedException: 這個 org.postgresql.jdbc42.Jdbc42Connection.createClob() 方法尚未被實作。`.  
In `org.hibernate.engine.jdbc.env.internal.LobCreatorBuilderImpl`, line 109-111 explained this issue. It's about when Spring try to 
get database metadata, it needs the jdbc driver implement this method. However, postgres jdbc not support it. Therefore, 
the exceptions is threw by `org.postgresql.jdbc.PgConnectoin` which implements the `java.sql.Connection`, used to tell user the method
 is not supprot by postgres jdbc.  
 If we add `spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false` in applicatoin.properties, Spring will not try to load
  database metadata, we can avoid this exception threw.
 However, it still can work normally, even if you don't deal with it. 
[Reference here](https://stackoverflow.com/questions/10075081/hibernate-slow-to-acquire-postgres-connection)  
    
