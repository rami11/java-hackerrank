package datastructures.stacks.simpletexteditor;

public class AppendOperation implements TextEditorOperation{

    private final String textToAppend;

    public AppendOperation(String textToAppend) {
        this.textToAppend = textToAppend;
    }

    @Override
    public String execute(String text) {
        return text + textToAppend;
    }
}
