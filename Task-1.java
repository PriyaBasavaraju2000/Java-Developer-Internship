import java.util.Scanner;

public class Calculator {
    
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Simple Calculator");
        System.out.println("Enter +, -, *, / for operations. Enter q to quit.");
        
        while (true) {
            System.out.print("Enter operation: ");
            String op = scanner.nextLine().trim();
            
            if (op.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                break;
            }
            
            if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
                System.out.println("Invalid operation. Try again.");
                continue;
            }
            
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            scanner.nextLine(); 
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine(); 
            
            double result = 0;
            if (op.equals("+")) {
                result = add(num1, num2);
            } else if (op.equals("-")) {
                result = subtract(num1, num2);
            } else if (op.equals("*")) {
                result = multiply(num1, num2);
            } else if (op.equals("/")) {
                result = divide(num1, num2);
            }
            
            System.out.println(num1 + " " + op + " " + num2 + " = " + result);
        }
        
        scanner.close();
    }
}
