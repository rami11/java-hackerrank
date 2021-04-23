package datastructures.stacks.simpletexteditor;

public class DeleteOperation implements TextEditorOperation{

    private final int count;

    public DeleteOperation(int count) {
        this.count = count;
    }

    @Override
    public String execute(String text) {
        return text.substring(0, text.length() - count);
    }
}
