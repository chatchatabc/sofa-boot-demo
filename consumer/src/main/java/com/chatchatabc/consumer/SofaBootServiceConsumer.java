package com.chatchatabc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:META-INF/spring/sofa-services-reference.xml"})
public class SofaBootServiceConsumer {

    public static void main(String[] args) {
        SpringApplication.run(SofaBootServiceConsumer.class, args);
    }

}
