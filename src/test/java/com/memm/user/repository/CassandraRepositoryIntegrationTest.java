package com.memm.user.repository;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.cassandra.CassandraContainer;

public abstract class CassandraRepositoryIntegrationTest {

    private static final String KEYSPACE = "user_service_test";

    static final CassandraContainer CASSANDRA = new CassandraContainer("cassandra:5.0.8")
            .withInitScript("cassandra/init-test-keyspace.cql");

    static {
        CASSANDRA.start();
    }

    @DynamicPropertySource
    static void cassandraProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.cassandra.contact-points", CASSANDRA::getHost);
        registry.add("spring.cassandra.port", () -> CASSANDRA.getMappedPort(9042));
        registry.add("spring.cassandra.local-datacenter", CASSANDRA::getLocalDatacenter);
        registry.add("spring.cassandra.keyspace-name", () -> KEYSPACE);
        registry.add("spring.cassandra.username", CASSANDRA::getUsername);
        registry.add("spring.cassandra.password", CASSANDRA::getPassword);
        registry.add("spring.cassandra.schema-action", () -> "create-if-not-exists");
    }
}
