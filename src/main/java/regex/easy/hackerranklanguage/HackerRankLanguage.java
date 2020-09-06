package regex.easy.hackerranklanguage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankLanguage {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase1.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();
            while (n-- > 0) {
                String line = scan.nextLine();
                System.out.println(line);

                String regex =
                        "\\b(C|CPP|JAVA|PYTHON|PERL|PHP" +
                        "|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA" +
                        "|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO" +
                        "|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)\\b";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                System.out.println(m.find() ? "VALID" : "INVALID");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
