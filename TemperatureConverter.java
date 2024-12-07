import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create a Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Display a welcome message to the user
        System.out.println("Welcome to the Temperature Converter!");
        System.out.println("Choose an option:");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");

        // Variable to store user's choice for conversion
        int choice = 0;

        // Loop until the user enters a valid choice (1 or 2)
        while (choice != 1 && choice != 2) {
            // Prompt user to enter either 1 or 2
            System.out.print("Enter 1 or 2: ");

            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();  // Store the user's choice
                // Validate if the choice is either 1 or 2
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } else {
                // If input is not an integer, inform the user and clear invalid input
                System.out.println("Invalid input. Please enter a number (1 or 2).");
                scanner.next(); // Clear the invalid input
            }
        }

        // Ask the user to input the temperature they wish to convert
        System.out.print("Enter the temperature to convert: ");
        
        // Validate that the user input is a valid double (temperature)
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number for the temperature.");
            scanner.next(); // Clear the invalid input
        }
        
        // Store the user's input temperature
        double temperature = scanner.nextDouble();

        // Check if the input temperature is below absolute zero or too high
        if (temperature < -273.15 || temperature > 1e4) {
            // Alert the user if the temperature is out of expected range
            System.out.println("Warning: The entered temperature is outside typical ranges.");
        }

        double convertedTemperature;

        // Perform the conversion based on the user's choice
        if (choice == 1) {
            // Convert Celsius to Fahrenheit
            convertedTemperature = (temperature * 9 / 5) + 32;
            // Display the result
            System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, convertedTemperature);
        } else {
            // Convert Fahrenheit to Celsius
            convertedTemperature = (temperature - 32) * 5 / 9;
            // Display the result
            System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, convertedTemperature);
        }

        // Display a thank you message to the user
        System.out.println("Thank you for using the Temperature Converter!");

        // Close the scanner object to release resources
        scanner.close();
    }
}
