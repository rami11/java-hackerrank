package datastructures.stacks.simpletexteditor;

public class PrintOperation implements TextEditorOperation{

    private final int position;

    public PrintOperation(int position) {
        this.position = position;
    }

    @Override
    public String execute(String text) {
        try {
            System.out.println(text.charAt(position - 1));
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return text;
    }
}
