package interview.prep.day6.simpletexteditor;

public class AppendOperation implements Operation, Undoable {

    private final Text text;
    private final Text oldText;
    private final String stringToAppend;

    public AppendOperation(Text text, String stringToAppend) {
        this.text = text;
        this.oldText = new Text(text.getContent());
        this.stringToAppend = stringToAppend;
    }

    @Override
    public void execute() {
        this.text.setContent(this.text.getContent() + this.stringToAppend);
    }

    @Override
    public void undo() {
        this.text.setContent(this.oldText.getContent());
    }
}
