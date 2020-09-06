package learnjava.easy.abstractclass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class AbstractClass {

    public static void main(String[] args) throws FileNotFoundException {
        //Book new_novel=new Book(); This line prHMain.java:25: error: Book is abstract; cannot be instantiated
        Scanner sc = new Scanner(new FileReader("input2.txt"));
        String title = sc.nextLine();
        MyBook new_novel = new MyBook();
        new_novel.setTitle(title);
        System.out.println("The title is: " + new_novel.getTitle());
        sc.close();
    }
}
