import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;
    
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    
    public int getId() { 
    	return id; 
    }
    
    
    public void setId(int id) { 
    	this.id = id; 
    }
    
    
    public String getName() { 
    	return name; 
    }
    
    public void setName(String name) { 
    	this.name = name; 
    }
    
    public double getMarks() { 
    	return marks; 
    }
    
    public void setMarks(double marks) { 
    	this.marks = marks; 
    }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added!");
                    break;
                    
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s);
                        }
                    }
                    break;
                    
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No students.");
                        break;
                    }
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getId() == updateId) {
                            System.out.print("Enter new Name: ");
                            s.setName(scanner.nextLine());
                            System.out.print("Enter new Marks: ");
                            s.setMarks(scanner.nextDouble());
                            scanner.nextLine();
                            System.out.println("Updated!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Not found.");
                    }
                    break;
                    
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students.");
                        break;
                    }
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    found = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == deleteId) {
                            students.remove(i);
                            System.out.println("Deleted!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Not found.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}

