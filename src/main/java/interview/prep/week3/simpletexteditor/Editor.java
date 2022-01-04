package interview.prep.week3.simpletexteditor;

import java.util.ArrayDeque;
import java.util.Deque;

public class Editor {

    private static final int MAX_UNDO = 10;

    private final Text text;
    private final Deque<Operation> operationStack;

    public Editor(Text text) {
        this.text = text;
        this.operationStack = new ArrayDeque<>();
    }

    public Editor() {
        this(new Text(""));
    }

    private void execute(Operation operation) {
        operation.execute();
        if (operation instanceof Undoable) {
            this.operationStack.addLast(operation);
            if (operationStack.size() > MAX_UNDO) {
                this.operationStack.removeFirst();
            }
        }
    }

    public void undoLastOperation() {
        if (!this.operationStack.isEmpty()) {
            Operation operation = this.operationStack.removeLast();
            operation.undo();
        }
    }

    public void append(String stringToAppend) {
        AppendOperation appendOperation = new AppendOperation(this.text, stringToAppend);
        execute(appendOperation);
    }

    public void delete(int k) {
        DeleteOperation deleteOperation = new DeleteOperation(this.text, k);
        execute(deleteOperation);
    }

    void print(int index) {
        PrintOperation printOperation = new PrintOperation(this.text, index);
        execute(printOperation);
    }
}
