import java.io.*;
import java.util.Scanner;

public class NotesAppSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter note: ");
                String note = sc.nextLine();
                try (FileWriter fw = new FileWriter(fileName, true)) {
                    fw.write(note + "\n");
                } catch (IOException e) {
                    System.out.println("Error writing file.");
                }
            } 
            else if (choice == 2) {
                try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    System.out.println("\n--- Notes ---");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("No notes found.");
                }
            } 
            else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
