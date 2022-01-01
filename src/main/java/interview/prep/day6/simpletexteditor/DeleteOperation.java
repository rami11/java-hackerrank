package interview.prep.day6.simpletexteditor;

public class DeleteOperation implements Operation, Undoable {

    private final int k;
    private final Text text;
    private final Text oldText;

    public DeleteOperation(Text text, int k) {
        this.text = text;
        this.oldText = new Text(text.getContent());
        this.k = Math.min(k, text.length());
    }

    @Override
    public void execute() {
        this.text.setContent(this.text.getContent().substring(0, this.text.length() - k));
    }

    @Override
    public void undo() {
        this.text.setContent(this.oldText.getContent());
    }
}
