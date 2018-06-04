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
    
2. We met problem when using Spring 2.0.2.RELEASE with postgres jdbc. It always show `java.sql.SQLFeatureNotSupportedException: 這個 org.postgresql.jdbc42.Jdbc42Connection.createClob() 方法尚未被實作。`.  
It seems a hibernate issue. It looks like when hibernate initializing, it will load database metadata. However, the clob type is not recognized by the jdbc driver.
[Reference here](https://stackoverflow.com/questions/10075081/hibernate-slow-to-acquire-postgres-connection)