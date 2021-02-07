package first.maven;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String a="hello";
        String b="Hello";
        a.equals(b.toLowerCase());//!!!!!!!!check warnings, you must use .equalsIgnoreCase()
    }
}
