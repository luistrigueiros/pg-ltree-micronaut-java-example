package example;

import io.micronaut.test.annotation.MicronautTest;
import org.flywaydb.core.Flyway;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class FlywayMigrationTest {
    @Inject
    DataSource dataSource;

    @Test
    void testItWorks() {
        Assertions.assertDoesNotThrow(() -> {
            Flyway.configure()
                .dataSource(dataSource)
                .load()
                .migrate();
        });
    }
}
