import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a natural number: ");
        int n = sc.nextInt();
        int i;
        System.out.println("Table of "+n+" is given by ");
        for (i=1; i<=10; i++) {
            System.out.println(n+" x "+i+" = "+ n*i);
        }
    }
}