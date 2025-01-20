import java.util.Scanner;

public class Assign1Temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the number of days
        System.out.print("Enter the number of days: ");
        int numberOfDays = scanner.nextInt();

        // Collects temperature values that are entered
        int[] temperatures = new int[numberOfDays];
        System.out.println("Enter the temperatures for " + numberOfDays + " days:");
        for (int i = 0; i < numberOfDays; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            temperatures[i] = scanner.nextInt();
        }

        //  Calculates the average temperature
        int sum = 0;
        for (int temp : temperatures) {
            sum += temp;
        }
        double averageTemperature = (double) sum / numberOfDays;

        //  Counts how many days are above the average temperature
        int aboveAverageCount = 0;
        for (int temp : temperatures) {
            if (temp > averageTemperature) {
                aboveAverageCount++;
            }
        }

        // Output results
        System.out.printf("Average temperature: %.2f%n", averageTemperature);
        System.out.println("Number of days above average temperature: " + aboveAverageCount);
    }
}
