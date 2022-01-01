package interview.prep.day6.simpletexteditor;

public class Text {

    private String content;

    public Text(String content) {
        this.content = content;
    }

    public Text() {
        this("");
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int length() {
        return this.content.length();
    }
}
