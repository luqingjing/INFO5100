package Assignment5;

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
        System.out.println(c.add(3.5, 2));
        System.out.println(c.subtract(3.5, 2));
        System.out.println(c.multiply(3.5, 2));
        System.out.println(c.divide(3.5, 2));
        System.out.println(c.fahrenheitToCelsius(86));
        System.out.println(c.celsiusToFahrenheit(30));
        System.out.println(c.feetToInches(1.8));
        System.out.println(c.inchesToFeet(21.6));
        System.out.println(c.squareRoot(4));
        System.out.println(c.square(4));
        System.out.println(c.cube(4));

    }

}