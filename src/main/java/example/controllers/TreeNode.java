package example.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class TreeNode {

  @Nonnull
  @NotBlank
  private final String value;
  @Nonnull
  @NotBlank
  @EqualsAndHashCode.Exclude
  private final Set<TreeNode> children = new HashSet<>();

  Optional<TreeNode> firstNodeHavingValue(String valueToFind) {
    if (this.value.equals(valueToFind)) {
      return Optional.of(this);
    }
    return children.stream()
        .filter(treeNode -> treeNode.value.equals(valueToFind))
        .findFirst();
  }

  public String renderAsJson() {
    StringBuilder json = new StringBuilder("{ \"value\": \"" + this.value + "\"");
    if (this.children.size() > 0) {
      json.append(", \"children\":[" + this.renderChildrenAsJson() + "]");
    }
    json.append(" } ");
    return json.toString();
  }

  private String renderChildrenAsJson() {
    return this.children
        .stream()
        .map(TreeNode::renderAsJson)
        .collect(Collectors.joining(","));
  }
}
