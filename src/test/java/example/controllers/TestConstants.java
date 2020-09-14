package example.controllers;

import example.domain.LTree;
import example.domain.Record;
import java.util.List;

public final class TestConstants {

  public final static Record NODE_A = new Record(1L, "A", new LTree("A"));
  public final static Record NODE_B = new Record(2L, "B", new LTree("A.B"));
  public final static Record NODE_C = new Record(3L, "C", new LTree("A.C"));
  public final static Record NODE_D = new Record(4L, "D", new LTree("A.C.D"));
  public final static Record NODE_E = new Record(5L, "E", new LTree("A.C.E"));
  public final static Record NODE_F = new Record(6L, "F", new LTree("A.C.F"));
  public final static Record NODE_G = new Record(7L, "G", new LTree("A.C.G"));

  public final static List<Record> RECORDS = List.of(
      NODE_A,
      NODE_B,
      NODE_C,
      NODE_D,
      NODE_E,
      NODE_F,
      NODE_G
  );
}
