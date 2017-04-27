package task2;

import java.util.*;
/*
Необходимо найти наименьший номер элемента последовательности, для которого выполняется условие M:

An = 1/(n+1)^2,  An<eps.

Можно просто решить уравнение, после программа выведет нужное n.

n > sqrt(1/eps) - 1

 */

public class Task2 {
    public static void main(String[] args) {
        Screen.screen();
    }
}
class Screen {
    static void screen() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter eps ===>");
        double eps = in.nextDouble();
        int n;
        try {
            if (Math.sqrt(1 / eps)!=Math.ceil(Math.sqrt(1 / eps))) {
                n = (int) Math.ceil((Math.sqrt(1 / eps) - 1));
            } else {
                n = (int) Math.ceil((Math.sqrt(1 / eps) - 1))+1;
            }
        System.out.println("Наименьший номер элемента последовательности:  " + n);
        System.out.println();

            for (int i = 1; i <= n; i++) {
                System.out.println("a" + i + " = " + (double)1 / ((i + 1)*(i + 1)));
            }
        } catch (ArithmeticException e) {

        }
    }
}
