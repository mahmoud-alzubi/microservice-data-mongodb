package com.mahmoudz.microservicedatamongodb;

import com.mtech.microservicedatamongodb.DataMongodbApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;

@TestConfiguration(proxyBeanMethods = false)
public class TestMicroserviceDataMongodbApplication {

    @Bean
    @ServiceConnection
    MongoDBContainer mongoDbContainer() {
        return new MongoDBContainer("mongo:latest");
    }

    public static void main(String[] args) {
        SpringApplication.from(DataMongodbApplication::main).with(TestMicroserviceDataMongodbApplication.class).run(args);
    }

}
