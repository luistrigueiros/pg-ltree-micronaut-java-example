package example.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import example.domain.Record;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@MicronautTest
@DisplayName("Full integration test of the API")
public class ApiTest {

  @Inject
  @Client("/tree")
  RxHttpClient client;

  @ParameterizedTest
  @CsvSource({
       "A, 7",
      "A.B, 2"
  })
  @DisplayName("For path={0}, expecting={1}")
  void testChildOfPath(String path, int expected) {
    testAndAssert(path, expected);
  }

  private void testAndAssert(String path, int expected) {
    HttpRequest<Record> request = HttpRequest.GET("/children-of?root=" + path);
    String json = client
        .retrieve(request, String.class)
        .blockingFirst();
    Assertions.assertTrue( !json.isBlank());
  }

}
