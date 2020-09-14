# Micronaut Data JDBC Java Example

Based on http://patshaughnessy.net/2017/12/11/trying-to-represent-a-tree-structure-using-postgres

## Example Structure

* `src/main/java/example/domain` - Entities that map onto database tables
* `src/main/java/example/repositories` - Micronaut Data Repository interfaces
* `src/main/java/example/controllers` - Controllers that are injected with the repository interfaces
* `src/test/java/example` - JUnit 5 tests that test the example.

## Running the example

You can run the tests with either `./gradlew test` for Gradle or `./mvnw test` for Maven.

The application can be run with either `./gradlew run` or `./mvnw compile exec:exec`. 

Alternatively you can import the example into either IntelliJ, Visual Studio Code or Eclipse.

