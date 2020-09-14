package example.domain;

import io.micronaut.context.annotation.Factory;
import io.micronaut.core.convert.TypeConverter;

import java.util.Optional;
import javax.inject.Singleton;

@Factory
class LTreeConverters {
    @Singleton
    TypeConverter<LTree, String> ltreeStringTypeConverter() {
        return (object, targetType, context) -> Optional.of(object.getValue());
    }

    @Singleton
    TypeConverter<String, LTree> stringLTreeTypeConverter() {
        return (object, targetType, context) -> Optional.of(new LTree((object)));
    }
}
