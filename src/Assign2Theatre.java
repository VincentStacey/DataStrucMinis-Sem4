import java.util.Scanner;

public class Assign2Theatre {
    private static final int ROWS = 5;
    private static final int COLS = 10;
    private final char[][] seatingChart;

    public Assign2Theatre() {
        seatingChart = new char[ROWS][COLS];
        initializeSeatingChart();
    }

    private void initializeSeatingChart() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seatingChart[i][j] = 'A'; // 'A' = available
            }
        }
    }

    public void displaySeatingChart() {
        System.out.println("Current Seating chart");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void  reserveSeat(int row,int seat) {
        if (seatingChart[row][seat] == 'A') { // 'A' = available
            seatingChart[row][seat] = 'R'; // 'R' = reserved
            System.out.println ("Seat reserved successfully.");
        } else {
            System.out.println("Seat is already reserved. Suggesting an available seat...");
            suggestSeat();
        }
    }

    public void cancelSeat(int row,int seat) {
        if (seatingChart[row][seat] == 'R') {
            seatingChart[row][seat] = 'A';
            System.out.println ("Reservation cancelled successfully.");
        } else {
            System.out.println("Seat is not reserved");
        }
    }

    public void suggestSeat() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (seatingChart[i][j] == 'A') {
                    System.out.println("Suggested available seat: Row " + (i+1) + " Col " + (j+1));
                    return;
                }
            }
        }
        System.out.println("No available seat, Please check the seating chart for further details.");
    }

    public static void main(String[] args) {
        Assign2Theatre theatre = new Assign2Theatre();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Display Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Seat");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theatre.displaySeatingChart();
                    break;
                case 2:
                    System.out.print("Enter row number (1-" + ROWS + "): ");
                    int rowToReserve = scanner.nextInt() - 1;
                    System.out.print("Enter seat number (1-" + COLS + "): ");
                    int seatToReserve = scanner.nextInt() - 1;
                    if (isValidSeat(rowToReserve, seatToReserve)) {
                        theatre.reserveSeat(rowToReserve, seatToReserve);
                    } else {
                        System.out.println("Invalid seat number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter row number (1-" + ROWS + "): ");
                    int rowToCancel = scanner.nextInt() - 1;
                    System.out.print("Enter seat number (1-" + COLS + "): ");
                    int seatToCancel = scanner.nextInt() - 1;
                    if (isValidSeat(rowToCancel, seatToCancel)) {
                        theatre.cancelSeat(rowToCancel, seatToCancel);
                    } else {
                        System.out.println("Invalid seat number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static boolean isValidSeat(int row, int seat) {
        return row >= 0 && row < ROWS && seat >= 0 && seat < COLS;
    }
}


