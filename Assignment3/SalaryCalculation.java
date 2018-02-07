package Assignment3;

import java.util.*;

public class SalaryCalculation {

    // Time Complexity : O(1)
    // Space Complexity: O(1)
    public static double employeeSalary(double hours) {

        if (hours > 48) {
            System.err.println("Exceeds the maximum hours allowed!");
            System.exit(1);
        }

        if (hours <= 36)
            return hours * 15;
        else if (hours <= 36 + 5){

            double salary = 36 * 15 + (hours - 36) * 15 * 1.5;
            return salary;
        } else {

            double salary = 36 * 15 + 5 * 15 * 1.5 + (hours - 36 - 5) * 15 * 2;
            return salary;
        }
        // None extra time used. The time complexity is O(1).
        // None extra space used. The space complexity is O(1).
    }

    public static double getDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {

            System.out.println("Invalid input, please enter a number.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args){

        Scanner inputHours = new Scanner(System.in);
        double hoursWorked;

        System.out.println("Enter number of hours the employee worked:");
        hoursWorked = getDouble(inputHours);

        System.out.println("The salary is: " + employeeSalary(hoursWorked));
    }
}
