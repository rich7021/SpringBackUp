# Spring Security - Basic Authentication

## Build Project and Import Spring Boot Web

1.  Import Spring Boot Web Starter in build.gradle  
    ```gradle
    ext {
        springBootVersion = '2.0.2.RELEASE'
    }
    dependencies {
        compile "org.springframework.boot:spring-boot-starter-web:${springBootVersion}"
    }
    ```
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

## Introducing Spring Data Jpa and postgreSQL

1. We user postgreSql here, so add dependencies of jpa and postgresql jdbc in build.gradle

    ```gradle
    compile "org.springframework.boot:spring-boot-starter-data-jpa:${springBootVersion}"
    compile "org.postgresql:postgresql:9.4-1206-jdbc42"
    ```

2. Add below setting in application.properties

    ```
   spring.datasource.driverClassName=org.postgresql.Driver
   spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/postgres
   spring.datasource.username=postgres
   spring.datasource.password=12345678
   #when spring initial, it will run this sql to init schema
   spring.datasource.schema=classpath:sql/ddl/schema.sql
   #when spring initial, it will run this sql to init data
   spring.datasource.data=classpath:sql/dml/data.sql

   spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL82Dialect
   #if sql showed up in log or not
   spring.jpa.show-sql=false
   #assign spring to initial tables and data when it start
   spring.jpa.hibernate.ddl-auto=create-drop
    ```

    > We met problem when using Spring 2.0.2.RELEASE with postgres jdbc.
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





> What is ddl? dml?  
[DDL](https://zh.wikipedia.org/zh-tw/%E8%B3%87%E6%96%99%E5%AE%9A%E7%BE%A9%E8%AA%9E%E8%A8%80) used to define data schema, composed by `CREATE`, `ALTER` and `DROP`.  
[DML](https://zh.wikipedia.org/wiki/%E8%B3%87%E6%96%99%E6%93%8D%E7%B8%B1%E8%AA%9E%E8%A8%80) used to manipulate database objects and data.
