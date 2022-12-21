package com.chatchatabc.consumer;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = SofaBootServiceConsumer.class, locations = {"classpath*:META-INF/spring/sofa-services-reference.xml"})
public abstract class SofaBootBaseTest {

}
