package datastructures.stacks.simpletexteditor;

import java.util.ArrayDeque;
import java.util.Deque;

public class OperationExecutor {

    final Deque<String> textStack;

    public OperationExecutor(String text) {
        textStack = new ArrayDeque<>();
        textStack.addLast(text);
    }

    public String getText() {
        return textStack.peekLast();
    }

    public void executeOperation(TextEditorOperation operation) {
        String newText = operation.execute(getText());
        if (operation instanceof AppendOperation || operation instanceof DeleteOperation) {
            textStack.addLast(newText);
        }
    }

    public void executeUndo() {
        textStack.pollLast();
    }
}
