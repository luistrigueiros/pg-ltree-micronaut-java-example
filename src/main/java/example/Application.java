package example;

import io.micronaut.runtime.Micronaut;
import javax.inject.Singleton;

@Singleton
public class Application {
    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}
