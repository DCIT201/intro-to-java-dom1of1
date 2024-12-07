import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message and prompt for user choice
        System.out.println("Welcome to the Temperature Converter!");
        System.out.println("Choose an option:");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");

        int choice = 0;

        // Validate user input for the conversion option
        while (choice != 1 && choice != 2) {
            System.out.print("Enter 1 or 2: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.next(); // Clear invalid input
            }
        }

        // Prompt user for the temperature to convert
        System.out.print("Enter the temperature to convert: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number for the temperature.");
            scanner.next(); // Clear invalid input
        }
        double temperature = scanner.nextDouble();

        // Check for extreme temperature values
        if (temperature < -273.15 || temperature > 1e4) {
            System.out.println("Warning: The entered temperature is outside typical ranges.");
        }

        double convertedTemperature;

        // Perform the conversion based on user's choice
        if (choice == 1) {
            // Celsius to Fahrenheit conversion
            convertedTemperature = (temperature * 9 / 5) + 32;
            System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, convertedTemperature);
        } else {
            // Fahrenheit to Celsius conversion
            convertedTemperature = (temperature - 32) * 5 / 9;
            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, convertedTemperature);
        }

        // Goodbye message to improve user experience
        System.out.println("Thank you for using the Temperature Converter!");
        scanner.close();
    }
}
