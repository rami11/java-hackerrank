package interview.prep.week3.simpletexteditor;

public class PrintOperation implements Operation {

    private final Text text;
    private final int k;

    public PrintOperation(Text text, int k) {
        this.text = text;
        this.k = k;
    }

    @Override
    public void execute() {
        System.out.println(k < 1 || k > text.getContent().length() ? "" : text.getContent().charAt(k - 1));
    }

    @Override
    public void undo() {
        // do nothing
    }
}
