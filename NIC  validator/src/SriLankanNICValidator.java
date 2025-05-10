import java.time.LocalDate;
import java.util.Scanner;

/**
 * Main application class to run the NIC validator
 */
public class SriLankanNICValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;

        System.out.println("Sri Lankan NIC Validator");
        System.out.println("========================");

        while (!isValidInput) {
            System.out.println("Enter your NIC number (old or new format) or type 'exit' to quit:");
            String nicNumber = scanner.nextLine().trim().toUpperCase();

            // Check if user wants to exit
            if (nicNumber.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting application. Goodbye!");
                break;
            }

            try {
                NICProcessor processor = NICProcessorFactory.createProcessor(nicNumber);
                NICInfo nicInfo = processor.extractInfo();

                // Display the extracted information
                System.out.println("\nNIC Information:");
                System.out.println("===============");
                System.out.println("Format: " + (processor instanceof OldNICProcessor ? "Old (9 digits + letter)" : "New (12 digits)"));
                System.out.println("Gender: " + nicInfo.getGender());
                System.out.println("Date of Birth: " + nicInfo.getDateOfBirth());
                System.out.println("Year of Birth: " + nicInfo.getYearOfBirth());
                System.out.println("Day of Year: " + nicInfo.getDayOfYear() +
                        (nicInfo.getGender().equals("Female") ? " (Original value: " + (nicInfo.getDayOfYear() + 500) + ")" : ""));

                // Ask if the user wants to validate another NIC
                System.out.println("\nDo you want to validate another NIC? (Y/N)");
                String answer = scanner.nextLine().trim().toUpperCase();

                if (answer.equals("N") || answer.equals("NO")) {
                    System.out.println("Thank you for using the NIC Validator. Goodbye!");
                    isValidInput = true; // Exit the loop
                } else {
                    System.out.println(); // Add a blank line for better readability
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again with a valid NIC number.\n");
            }
        }

        scanner.close();
    }
}