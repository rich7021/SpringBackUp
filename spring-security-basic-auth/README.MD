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