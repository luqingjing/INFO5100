package Assignment4;

import java.util.*;

public class PerfectNumbers {

    public void printPerfectNumbers(int n) {

        for (int num = 1; num <= n; num++) {

            int sum = 0;

            for (int divisor = 1; divisor < num; divisor++) {

                if (num % divisor == 0)
                    sum = sum + divisor;
            }

            if (sum == num)
                System.out.println(num);
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PerfectNumbers num = new PerfectNumbers();
        num.printPerfectNumbers(n);
    }
}
