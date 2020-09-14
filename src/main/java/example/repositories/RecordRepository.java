package example.repositories;

import example.domain.Record;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.jdbc.runtime.JdbcOperations;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.stream.Collectors;

@Repository
@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class RecordRepository implements CrudRepository<Record, Long> {

    private final JdbcOperations jdbcOperations;

    RecordRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Transactional
    public List<Record> childrenOf(String root) {
        String sql = "select * from tree where ? @> path order by id asc";
        return jdbcOperations.prepareStatement(sql, statement -> {
            statement.setObject(1, root, Types.OTHER);
            ResultSet resultSet = statement.executeQuery();
            return jdbcOperations.entityStream(resultSet, Record.class)
                .collect(Collectors.toList());
        });
    }

}
