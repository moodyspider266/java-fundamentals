import java.util.*;

public class Strings {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder("Tony");
        System.out.println(sb);

        //Insert character S at start : 
        sb.insert(0, 'S');
        System.out.println(sb);

        //Replacing T with P : 
        sb.setCharAt(0, 'P');
        System.out.println(sb);

        //Deleting characters / substring from the string :
        sb.delete(2, 3);
        System.out.println(sb);

        //Appending characters at the end:
        sb.append('o');
        System.out.println(sb);
    }
}
