package example.domain;

import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TypeDef(type = DataType.STRING)
public class LTree {
    private String value;

    public String[] pathSplit() {
        return value.split("\\.");
    }
}
