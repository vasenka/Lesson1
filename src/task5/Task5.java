package task5;

import java.util.*;

public class Task5 {
    public static void main(String[] args) {

         arrayCreation();
    }
    static void arrayCreation() {
        System.out.println("Enter number of rows ===>");
        Scanner inRow = new Scanner(System.in);
        int n = inRow.nextInt();

        System.out.println("Enter number of columns ===>");
        Scanner inCol = new Scanner(System.in);
        int m = inCol.nextInt();


        byte[][] array = new byte[n][m];

        for (int i=0;i<n/2;i++) {
            for (int j=0;j<m/2;j++) {
                if (i==j) {
                    array[i][j]=1;
                }
            }
            for (int j=m/2;j<m;j++) {
                if (i+j==m-1) {
                    array[i][j]=1;
                }
            }
        }
        for (int i=n/2;i<n;i++) {
            for (int j=0;j<m/2;j++) {
                if (i+j==n-1) {
                    array[i][j]=1;
                }
            }
            for (int j=m/2;j<m;j++) {
                if (i-j==n-m) {
                    array[i][j]=1;
                }
            }
        }

        for (int k=0; k<array.length;k++) {
            System.out.println(Arrays.toString(array[k]));
        }

    }
}
