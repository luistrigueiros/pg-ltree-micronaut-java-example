package example.controllers;

import example.domain.Record;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public final class TreeBuilder {

  public static TreeNode buildTree(List<Record> records) {
    TreeNode root = new TreeNode(records.get(0).getLetter());
    records.forEach(record -> processRecord(record, root));
    return root;
  }

  static void processRecord(Record record, TreeNode root) {
    final AtomicReference<TreeNode> prevNode = new AtomicReference<>();
    String[] pathSplit = record.getPath().pathSplit();
    IntStream.range(0, pathSplit.length).forEach( idx -> {
      String value = pathSplit[idx];
      root.firstNodeHavingValue(value)
          .ifPresentOrElse(prevNode::set,
              () -> prevNode.get().getChildren().add(new TreeNode(value))
          );
    });
  }
}
