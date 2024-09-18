import java.util.*;

public class TwoDArrays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[][] two_d_arr = new int[5][3];
        System.out.println("Enter elements of the matrix :");
        for (int i=0; i<5; i++) {
            for (int j=0; j<3; j++) {
                two_d_arr[i][j] = sc.nextInt(); 
            }
        }
        //output :
        System.out.print("The 2D matrix is : \n");
        for (int i=0; i<5; i++) {
            for (int j=0; j<3; j++) {
                System.out.print(two_d_arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}