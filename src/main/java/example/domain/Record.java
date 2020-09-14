package example.domain;

import io.micronaut.core.annotation.Creator;
import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Record implements Comparable<Record> {
    @Id
    private Long id;
    @Nonnull
    @NotBlank
    private String letter;
    @Nonnull
    @NotBlank
    private LTree path;

    @Creator
    public Record(Long id, @Nonnull @NotBlank String letter, @Nonnull LTree path) {
        this.id = id;
        this.letter = letter;
        this.path = path;
    }

    @Override
    public int compareTo(@NotNull Record other) {
        if (id > other.id) {
            return 1;
        } else if (id < other.id) {
            return -1;
        }
        return 0;
    }
}
