package example.controllers;

import org.junit.jupiter.api.Test;

public class NodeTreeTesting {
  @Test
  public void testNodeSorting() {
    TreeNode root = TreeBuilder.buildTree(TestConstants.RECORDS);
    String json = root.renderAsJson();
    System.out.println(json);
  }
}
