package datastructures.stacks.simpletexteditor;

@FunctionalInterface
public interface TextEditorOperation {
    String execute(String text);
}
