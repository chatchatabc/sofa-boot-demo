Sofa Spring Boot Demo
=====================

A Spring Boot demo with Sofa Boot and Sofa RPC.

![Sofa RPC Architecture](sofa-rpc-architecture.png)

# What is SofaBoot?

SOFABoot is a development framework open sourced by Ant Financial which is based on Spring Boot, provides capabilities such as Readiness Check, class isolation, and log space
isolation. In addition to enhancing the Spring Boot, SOFABoot provides users with the capability to easily use SOFA middleware in Spring Boot.

# What is SofaRPC?

SOFARPC is a Java-based RPC service framework open sourced by Ant Financial, which provides remote service call between applications, high scalability and fault tolerance features.
Currently, all RPC calls of Ant Financial businesses use SOFARPC. SOFARPC provides users with functions such as load balancing, traffic forwarding, link tracing, link data
transparent transmission, and fault removal.

# Project Structure

### service-api

Service interface contract definition

```java
public interface UserServiceFacade {
    User findById(Long id);
}
```

### Service Provider

Implement service interface and expose service to registry server by `@SofaService` annotation.

```java

@Service
@SofaService(interfaceType = UserServiceFacade.class, bindings = {@SofaServiceBinding(bindingType = "bolt")})
public class UserServiceFacadeImpl implements UserServiceFacade {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(id);
        user.setNick("linux_china");
        return user;
    }
}
```

### Service Consumer

There 2 ways to refer remote service:

* `@SofaReference` annotation: good for beginners

```java

@RestController
public class PortalController {
    @SofaReference(binding = @SofaReferenceBinding(bindingType = "bolt"))
    private UserServiceFacade userServiceFacade;
}

```

* XML declaration: good for unit test and maintain

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:sofa="http://sofastack.io/schema/sofaboot"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://sofastack.io/schema/sofaboot
            http://sofastack.io/schema/sofaboot.xsd"
       default-autowire="byName">

    <sofa:reference id="userServiceFacade" interface="com.chatchatabc.user.UserServiceFacade">
        <sofa:binding.bolt/>
    </sofa:reference>

</beans>
```

# Get Started

* Start ZooKeeper service by `docker-compose up -d`
* Start Service Provider: `SofaBootServiceProvider`
* Start Service Consumer: `SofaBootServiceConsumer`
* Test REST API with Sofa RPC call: `curl http://localhost:9080/user/1`

# References

* SOFAStack: https://www.sofastack.tech/en/
* SOFABoot: https://www.sofastack.tech/en/projects/sofa-boot/overview/
* SOFARPC: https://www.sofastack.tech/en/projects/sofa-rpc/overview/