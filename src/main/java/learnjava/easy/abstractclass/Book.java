package learnjava.easy.abstractclass;

abstract class Book {
    protected String title;

    String getTitle() {
        return title;
    }

    abstract void setTitle(String s);
}
