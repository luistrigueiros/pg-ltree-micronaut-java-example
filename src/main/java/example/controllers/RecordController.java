package example.controllers;

import static example.controllers.TreeBuilder.buildTree;

import example.domain.Record;
import example.repositories.RecordRepository;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;

@Controller("/tree")
class RecordController {
    @Inject
    private RecordRepository recordRepository;

    @Get("/children-of")
    @Produces(MediaType.APPLICATION_JSON)
    String childrenOf(String root) {
        List<Record> records = recordRepository.childrenOf(root);
        return buildTree(records).renderAsJson();
    }

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    String index() {
        return "The time is now " + DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
    }
}
