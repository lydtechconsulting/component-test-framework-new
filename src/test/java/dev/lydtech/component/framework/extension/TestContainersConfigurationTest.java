package dev.lydtech.component.framework.extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dev.lydtech.component.framework.extension.TestContainersConfiguration.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestContainersConfigurationTest {

    @BeforeEach
    public void setUp() {
        System.clearProperty("container.name.prefix");
        System.clearProperty("container.main.label");
        System.clearProperty("service.name");
        System.clearProperty("service.instance.count");
        System.clearProperty("service.port");
        System.clearProperty("service.debug.port");
        System.clearProperty("service.startup.timeout.seconds");
        System.clearProperty("service.image.tag");
        System.clearProperty("service.container.logging.enabled");

        System.clearProperty("additional.containers");

        System.clearProperty("postgres.enabled");
        System.clearProperty("postgres.image.tag");
        System.clearProperty("postgres.host.name");
        System.clearProperty("postgres.port");
        System.clearProperty("postgres.database.name");
        System.clearProperty("postgres.username");
        System.clearProperty("postgres.password");
        System.clearProperty("postgres.container.logging.enabled");

        System.clearProperty("kafka.enabled");
        System.clearProperty("kafka.broker.count");
        System.clearProperty("kafka.confluent.image.tag");
        System.clearProperty("kafka.port");
        System.clearProperty("kafka.topics");
        System.clearProperty("kafka.topic.partition.count");
        System.clearProperty("kafka.container.logging.enabled");
        System.clearProperty("kafka.topic.replication.factor");
        System.clearProperty("kafka.min.insync.replicas");

        System.clearProperty("kafka.schema.registry.enabled");
        System.clearProperty("kafka.schema.registry.confluent.image.tag");
        System.clearProperty("kafka.schema.registry.port");
        System.clearProperty("kafka.schema.registry.container.logging.enabled");

        System.clearProperty("kafka.control.center.enabled");
        System.clearProperty("kafka.control.center.confluent.image.tag");
        System.clearProperty("kafka.control.center.export.metrics.enabled");
        System.clearProperty("kafka.control.center.jmx.port");
        System.clearProperty("kafka.control.center.port");
        System.clearProperty("kafka.control.center.container.logging.enabled");

        System.clearProperty("conduktor.enabled");
        System.clearProperty("conduktor.image.tag");
        System.clearProperty("conduktor.license.key");
        System.clearProperty("conduktor.port");
        System.clearProperty("conduktor.container.logging.enabled");

        System.clearProperty("conduktor.gateway.enabled");
        System.clearProperty("conduktor.gateway.image.tag");
        System.clearProperty("conduktor.gateway.proxy.port");
        System.clearProperty("conduktor.gateway.http.port");
        System.clearProperty("conduktor.gateway.container.logging.enabled");

        System.clearProperty("debezium.enabled");
        System.clearProperty("debezium.image.tag");
        System.clearProperty("debezium.port");
        System.clearProperty("debezium.container.logging.enabled");

        System.clearProperty("wiremock.enabled");
        System.clearProperty("wiremock.image.tag");
        System.clearProperty("wiremock.port");
        System.clearProperty("wiremock.container.logging.enabled");

        System.clearProperty("localstack.enabled");
        System.clearProperty("localstack.image.tag");
        System.clearProperty("localstack.port");
        System.clearProperty("localstack.services");
        System.clearProperty("localstack.container.logging.enabled");
    }

    @Test
    public void testDefaultConfiguration() {

        TestContainersConfiguration.configure();

        assertThat(CONTAINER_NAME_PREFIX, equalTo("ct"));
        assertThat(CONTAINER_MAIN_LABEL, equalTo("main-container"));
        assertThat(SERVICE_NAME, equalTo("app"));
        assertThat(SERVICE_INSTANCE_COUNT, equalTo(1));
        assertThat(SERVICE_PORT, equalTo(9001));
        assertThat(SERVICE_DEBUG_PORT, equalTo(5001));
        assertThat(SERVICE_STARTUP_TIMEOUT_SECONDS, equalTo(180));
        assertThat(SERVICE_IMAGE_TAG, equalTo("latest"));
        assertThat(SERVICE_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(ADDITIONAL_CONTAINERS, equalTo(new ArrayList<>()));
        assertThat(POSTGRES_ENABLED, equalTo(false));
        assertThat(POSTGRES_IMAGE_TAG, equalTo("14-alpine"));
        assertThat(POSTGRES_HOST_NAME, equalTo("postgres-host"));
        assertThat(POSTGRES_PORT, equalTo(5432));
        assertThat(POSTGRES_DATABASE_NAME, equalTo("postgres-db"));
        assertThat(POSTGRES_USERNAME, equalTo("user"));
        assertThat(POSTGRES_PASSWORD, equalTo("password"));
        assertThat(POSTGRES_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(KAFKA_ENABLED, equalTo(false));
        assertThat(KAFKA_BROKER_COUNT, equalTo(1));
        assertThat(KAFKA_CONFLUENT_IMAGE_TAG, equalTo("7.3.2"));
        assertThat(KAFKA_PORT, equalTo(9093));
        assertThat(KAFKA_TOPICS, equalTo(new ArrayList<>()));
        assertThat(KAFKA_TOPIC_PARTITION_COUNT, equalTo(1));
        assertThat(KAFKA_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(KAFKA_TOPIC_REPLICATION_FACTOR, equalTo(1));
        assertThat(KAFKA_MIN_INSYNC_REPLICAS, equalTo(1));
        assertThat(KAFKA_SCHEMA_REGISTRY_ENABLED, equalTo(false));
        assertThat(KAFKA_SCHEMA_REGISTRY_CONFLUENT_IMAGE_TAG, equalTo("7.3.2"));
        assertThat(KAFKA_SCHEMA_REGISTRY_PORT, equalTo(8081));
        assertThat(KAFKA_SCHEMA_REGISTRY_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(KAFKA_CONTROL_CENTER_ENABLED, equalTo(false));
        assertThat(KAFKA_CONTROL_CENTER_CONFLUENT_IMAGE_TAG, equalTo("7.3.2"));
        assertThat(KAFKA_CONTROL_CENTER_EXPORT_METRICS_ENABLED, equalTo(false));
        assertThat(KAFKA_CONTROL_CENTER_JMX_PORT, equalTo("9101"));
        assertThat(KAFKA_CONTROL_CENTER_PORT, equalTo(9021));
        assertThat(KAFKA_CONTROL_CENTER_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(CONDUKTOR_ENABLED, equalTo(false));
        assertThat(CONDUKTOR_IMAGE_TAG, equalTo("1.15.0"));
        assertThat(CONDUKTOR_LICENSE_KEY, nullValue());
        assertThat(CONDUKTOR_PORT, equalTo(8088));
        assertThat(CONDUKTOR_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(CONDUKTOR_GATEWAY_ENABLED, equalTo(false));
        assertThat(CONDUKTOR_GATEWAY_IMAGE_TAG, equalTo("2.1.5"));
        assertThat(CONDUKTOR_GATEWAY_PROXY_PORT, equalTo(6969));
        assertThat(CONDUKTOR_GATEWAY_HTTP_PORT, equalTo(8888));
        assertThat(CONDUKTOR_GATEWAY_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(DEBEZIUM_ENABLED, equalTo(false));
        assertThat(DEBEZIUM_IMAGE_TAG, equalTo("2.2"));
        assertThat(DEBEZIUM_PORT, equalTo(8083));
        assertThat(DEBEZIUM_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(WIREMOCK_ENABLED, equalTo(false));
        assertThat(WIREMOCK_IMAGE_TAG, equalTo("2.35.0"));
        assertThat(WIREMOCK_PORT, equalTo(8080));
        assertThat(WIREMOCK_CONTAINER_LOGGING_ENABLED, equalTo(false));
        assertThat(LOCALSTACK_ENABLED, equalTo(false));
        assertThat(LOCALSTACK_IMAGE_TAG, equalTo("0.14.3"));
        assertThat(LOCALSTACK_PORT, equalTo(4566));
        assertThat(LOCALSTACK_SERVICES, equalTo("dynamodb"));
        assertThat(LOCALSTACK_CONTAINER_LOGGING_ENABLED, equalTo(false));
    }

    @Test
    public void testOverriddenConfiguration() {

        System.setProperty("container.name.prefix", "ct-override");
        System.setProperty("container.main.label", "main-override");
        System.setProperty("service.name", "app-override");
        System.setProperty("service.instance.count", "2");
        System.setProperty("service.port", "9002");
        System.setProperty("service.debug.port", "5002");
        System.setProperty("service.startup.timeout.seconds", "10");
        System.setProperty("service.image.tag", "service-override");
        System.setProperty("service.container.logging.enabled", "true");

        System.setProperty("additional.containers", "third-party-simulator,9002,5002,latest,false");

        System.setProperty("postgres.enabled", "true");
        System.setProperty("postgres.image.tag", "postgres-override");
        System.setProperty("postgres.host.name", "postgres-host-override");
        System.setProperty("postgres.port", "5433");
        System.setProperty("postgres.database.name", "postgres-db-override");
        System.setProperty("postgres.username", "postgres-user-override");
        System.setProperty("postgres.password", "postgres-password-override");
        System.setProperty("postgres.container.logging.enabled", "true");

        System.setProperty("kafka.enabled", "true");
        System.setProperty("kafka.broker.count", "12");
        System.setProperty("kafka.confluent.image.tag", "kafka-override");
        System.setProperty("kafka.port", "9094");
        System.setProperty("kafka.topics", "topic-1");
        System.setProperty("kafka.topic.partition.count", "2");
        System.setProperty("kafka.container.logging.enabled", "true");
        System.setProperty("kafka.topic.replication.factor", "5");
        System.setProperty("kafka.min.insync.replicas", "4");

        System.setProperty("kafka.schema.registry.enabled", "true");
        System.setProperty("kafka.schema.registry.confluent.image.tag", "registry-override");
        System.setProperty("kafka.schema.registry.port", "8082");
        System.setProperty("kafka.schema.registry.container.logging.enabled", "true");

        System.setProperty("kafka.control.center.enabled", "true");
        System.setProperty("kafka.control.center.confluent.image.tag", "control-center-override");
        System.setProperty("kafka.control.center.export.metrics.enabled", "true");
        System.setProperty("kafka.control.center.jmx.port", "9102");
        System.setProperty("kafka.control.center.port", "9022");
        System.setProperty("kafka.control.center.container.logging.enabled", "true");

        System.setProperty("conduktor.enabled", "true");
        System.setProperty("conduktor.image.tag", "conduktor-override");
        System.setProperty("conduktor.license.key", "conduktor-license-override");
        System.setProperty("conduktor.port", "8089");
        System.setProperty("conduktor.container.logging.enabled", "true");

        System.setProperty("conduktor.gateway.enabled", "true");
        System.setProperty("conduktor.gateway.image.tag", "conduktor-gateway-override");
        System.setProperty("conduktor.gateway.proxy.port", "6970");
        System.setProperty("conduktor.gateway.http.port", "8889");
        System.setProperty("conduktor.gateway.container.logging.enabled", "true");

        System.setProperty("debezium.enabled", "true");
        System.setProperty("debezium.image.tag", "debezium-override");
        System.setProperty("debezium.port", "8084");
        System.setProperty("debezium.container.logging.enabled", "true");

        System.setProperty("wiremock.enabled", "true");
        System.setProperty("wiremock.image.tag", "wiremock-override");
        System.setProperty("wiremock.port", "8081");
        System.setProperty("wiremock.container.logging.enabled", "true");

        System.setProperty("localstack.enabled", "true");
        System.setProperty("localstack.image.tag", "localstack-override");
        System.setProperty("localstack.port", "4567");
        System.setProperty("localstack.services", "dynamodb,s3");
        System.setProperty("localstack.container.logging.enabled", "true");

        TestContainersConfiguration.configure();

        assertThat(CONTAINER_NAME_PREFIX, equalTo("ct-override"));
        assertThat(CONTAINER_MAIN_LABEL, equalTo("main-override"));
        assertThat(SERVICE_NAME, equalTo("app-override"));
        assertThat(SERVICE_INSTANCE_COUNT, equalTo(2));
        assertThat(SERVICE_PORT, equalTo(9002));
        assertThat(SERVICE_DEBUG_PORT, equalTo(5002));
        assertThat(SERVICE_STARTUP_TIMEOUT_SECONDS, equalTo(10));
        assertThat(SERVICE_IMAGE_TAG, equalTo("service-override"));
        assertThat(SERVICE_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(ADDITIONAL_CONTAINERS, equalTo(Arrays.asList(new AdditionalContainer("third-party-simulator", 9002, 5002, "latest", false))));
        assertThat(POSTGRES_ENABLED, equalTo(true));
        assertThat(POSTGRES_IMAGE_TAG, equalTo("postgres-override"));
        assertThat(POSTGRES_HOST_NAME, equalTo("postgres-host-override"));
        assertThat(POSTGRES_PORT, equalTo(5433));
        assertThat(POSTGRES_DATABASE_NAME, equalTo("postgres-db-override"));
        assertThat(POSTGRES_USERNAME, equalTo("postgres-user-override"));
        assertThat(POSTGRES_PASSWORD, equalTo("postgres-password-override"));
        assertThat(POSTGRES_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(KAFKA_ENABLED, equalTo(true));
        assertThat(KAFKA_BROKER_COUNT, equalTo(12));
        assertThat(KAFKA_CONFLUENT_IMAGE_TAG, equalTo("kafka-override"));
        assertThat(KAFKA_PORT, equalTo(9094));
        assertThat(KAFKA_TOPICS, equalTo(Arrays.asList("topic-1")));
        assertThat(KAFKA_TOPIC_PARTITION_COUNT, equalTo(2));
        assertThat(KAFKA_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(KAFKA_TOPIC_REPLICATION_FACTOR, equalTo(5));
        assertThat(KAFKA_MIN_INSYNC_REPLICAS, equalTo(4));
        assertThat(KAFKA_SCHEMA_REGISTRY_ENABLED, equalTo(true));
        assertThat(KAFKA_SCHEMA_REGISTRY_CONFLUENT_IMAGE_TAG, equalTo("registry-override"));
        assertThat(KAFKA_SCHEMA_REGISTRY_PORT, equalTo(8082));
        assertThat(KAFKA_SCHEMA_REGISTRY_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(KAFKA_CONTROL_CENTER_ENABLED, equalTo(true));
        assertThat(KAFKA_CONTROL_CENTER_CONFLUENT_IMAGE_TAG, equalTo("control-center-override"));
        assertThat(KAFKA_CONTROL_CENTER_EXPORT_METRICS_ENABLED, equalTo(true));
        assertThat(KAFKA_CONTROL_CENTER_JMX_PORT, equalTo("9102"));
        assertThat(KAFKA_CONTROL_CENTER_PORT, equalTo(9022));
        assertThat(KAFKA_CONTROL_CENTER_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(CONDUKTOR_ENABLED, equalTo(true));
        assertThat(CONDUKTOR_IMAGE_TAG, equalTo("conduktor-override"));
        assertThat(CONDUKTOR_LICENSE_KEY, equalTo("conduktor-license-override"));
        assertThat(CONDUKTOR_PORT, equalTo(8089));
        assertThat(CONDUKTOR_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(CONDUKTOR_GATEWAY_ENABLED, equalTo(true));
        assertThat(CONDUKTOR_GATEWAY_IMAGE_TAG, equalTo("conduktor-gateway-override"));
        assertThat(CONDUKTOR_GATEWAY_PROXY_PORT, equalTo(6970));
        assertThat(CONDUKTOR_GATEWAY_HTTP_PORT, equalTo(8889));
        assertThat(CONDUKTOR_GATEWAY_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(DEBEZIUM_ENABLED, equalTo(true));
        assertThat(DEBEZIUM_IMAGE_TAG, equalTo("debezium-override"));
        assertThat(DEBEZIUM_PORT, equalTo(8084));
        assertThat(DEBEZIUM_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(WIREMOCK_ENABLED, equalTo(true));
        assertThat(WIREMOCK_IMAGE_TAG, equalTo("wiremock-override"));
        assertThat(WIREMOCK_PORT, equalTo(8081));
        assertThat(WIREMOCK_CONTAINER_LOGGING_ENABLED, equalTo(true));
        assertThat(LOCALSTACK_ENABLED, equalTo(true));
        assertThat(LOCALSTACK_IMAGE_TAG, equalTo("localstack-override"));
        assertThat(LOCALSTACK_PORT, equalTo(4567));
        assertThat(LOCALSTACK_SERVICES, equalTo("dynamodb,s3"));
        assertThat(LOCALSTACK_CONTAINER_LOGGING_ENABLED, equalTo(true));
    }

    @Test
    void testParseKafkaTopics() {
        System.setProperty("kafka.topics", "topic-a, topic-b, topic-c");
        assertThat(TestContainersConfiguration.parseKafkaTopics(), equalTo(Arrays.asList("topic-a", "topic-b", "topic-c")));
    }

    @Test
    void testParseAdditionalContainers() {
        System.setProperty("additional.containers", "third-party-simulator,9002,5002,latest,false:external-service-simulator,9003,5003,6.5.4,true");
        List<AdditionalContainer> additionalContainers = TestContainersConfiguration.parseAdditionalContainers();
        assertThat(additionalContainers.size(), equalTo(2));
        assertThat(additionalContainers.get(0).getName(), equalTo("third-party-simulator"));
        assertThat(additionalContainers.get(0).getPort(), equalTo(9002));
        assertThat(additionalContainers.get(0).getDebugPort(), equalTo(5002));
        assertThat(additionalContainers.get(0).getImageTag(), equalTo("latest"));
        assertThat(additionalContainers.get(0).getAdditionalContainerLoggingEnabled(), equalTo(false));
        assertThat(additionalContainers.get(1).getName(), equalTo("external-service-simulator"));
        assertThat(additionalContainers.get(1).getPort(), equalTo(9003));
        assertThat(additionalContainers.get(1).getDebugPort(), equalTo(5003));
        assertThat(additionalContainers.get(1).getImageTag(), equalTo("6.5.4"));
        assertThat(additionalContainers.get(1).getAdditionalContainerLoggingEnabled(), equalTo(true));
    }

    @Test
    void testParseAdditionalContainers_Invalid() {
        System.setProperty("additional.containers", "third-party-simulator,9002");
        Exception exception = assertThrows(RuntimeException.class, () -> TestContainersConfiguration.parseAdditionalContainers());
        assertThat(exception.getMessage(), equalTo("Invalid additional containers details: [third-party-simulator, 9002] -  expecting 5 args, found 2."));
    }
}
