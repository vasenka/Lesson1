package task4;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {

        double[] array = initialize();
        maximum(array);
    }
    static double[] initialize() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n===>");
        int n = in.nextInt();

        double[] array = new double[n];
        for (int i=0;i<array.length;i++) {
            array[i] = Math.random()*1000;
        }
        return array;
    }

    static void maximum(double[] array) {
        double maxOf = array[0]+array[1];
        if (array.length%2==0) {
            for (int i=2;i<array.length-1;i++) {
                if ((array[i]+array[i+1])>maxOf) {
                    maxOf = (array[i]+array[i+1]);
                }
            }
        } else {
            for (int i=2;i<array.length-2;i++) {
                if ((array[i]+array[i+1])>maxOf) {
                    maxOf = (array[i]+array[i+1]);
                }
            }
            if (array[array.length-1]>maxOf) {
                maxOf = array[array.length-1];
            }
        }
        System.out.println("Array: "+ Arrays.toString(array));
        System.out.println("Maximum: "+ maxOf);
    }
}
