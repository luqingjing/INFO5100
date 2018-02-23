package Assignment5;

import java.util.*;

public class Calculator {

    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }

    double divide(double a, double b) {

        if (b == 0)
            throw new RuntimeException("The denominator can't be 0.");
        else
            return  a / b;
    }

    double squareRoot(double a) {
        return Math.sqrt(a);
    }

    double square(double a) {
        return a * a;
    }

    double cube(double a) {
        return a * a * a;
    }

    double fahrenheitToCelsius(double f) {
        return (f - 32) / 1.8;
    }

    double celsiusToFahrenheit(double c) {
        return (c * 1.8) + 32;
    }

    double feetToInches(double f) {
        return 12 * f;
    }

    double inchesToFeet(double i) {
        return i / 12;
    }

    public static void main(String[] args) {

        Calculator c = new Calculator();
        double a;
        double b;
        int operation;
        Scanner op = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. squareRoot");
            System.out.println("6. square");
            System.out.println("7. Cube");
            System.out.println("8. Fahrenheit to Celsius");
            System.out.println("9. Celsius to Fahrenheit");
            System.out.println("10. Feet to Inches");
            System.out.println("11. Inches to Feet");
            operation = op.nextInt();

            if (operation > 11)
                System.out.println("Input is not valid.");

            if (operation == 1 || operation == 2 || operation == 3 || operation == 4) {

                System.out.println("Please enter the first number:");
                a = op.nextDouble();
                System.out.println("Please enter the second number:");
                b = op.nextDouble();
                if (operation == 1)
                    System.out.println(c.add(a, b));
                if (operation == 2)
                    System.out.println(c.subtract(a, b));
                if (operation == 3)
                    System.out.println(c.multiply(a, b));
                if (operation == 4)
                    System.out.println(c.divide(a, b));
            }
            else {

                System.out.println("Please enter the number:");
                a = op.nextDouble();
                if (operation == 5)
                    System.out.println(c.squareRoot(a));
                if (operation == 6)
                    System.out.println(c.square(a));
                if (operation == 7)
                    System.out.println(c.cube(a));
                if (operation == 8)
                    System.out.println(c.fahrenheitToCelsius(a));
                if (operation == 9)
                    System.out.println(c.celsiusToFahrenheit(a));
                if (operation == 10)
                    System.out.println(c.feetToInches(a));
                if (operation == 11)
                    System.out.println(c.inchesToFeet(a));
            }
        }
    }

}