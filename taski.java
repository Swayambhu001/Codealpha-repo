import java.util.*;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class GradeTracker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");

        // 1. Data Input Phase
        while (true) {
            System.out.print("Enter student name (or type 'exit' to finish): ");
            String name = in.nextLine().trim();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            System.out.print("Enter grade for " + name + ": ");
            double grade = 0;
            
            try {
                grade = Double.parseDouble(in.nextLine().trim());
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numerical grade.");
                continue;
            }

            students.add(new Student(name, grade));
        }

        // 2. Calculation and Report Phase
        if (students.isEmpty()) {
            System.out.println("\nNo grades were entered. Exiting program.");
        } else {
            double total = 0;
            double highest = students.get(0).grade;
            double lowest = students.get(0).grade;

            System.out.println("\n=== Class Summary Report ===");
            System.out.printf("%-20s %-10s\n", "Student Name", "Grade");
            System.out.println("----------------------------------");

            for (Student s : students) {
                System.out.printf("%-20s %-10.2f\n", s.name, s.grade);
                
                total += s.grade;
                if (s.grade > highest) highest = s.grade;
                if (s.grade < lowest) lowest = s.grade;
            }

            double average = total / students.size();

            System.out.println("----------------------------------");
            System.out.printf("Total Students: %d\n", students.size());
            System.out.printf("Class Average:  %.2f\n", average);
            System.out.printf("Highest Score:  %.2f\n", highest);
            System.out.printf("Lowest Score:   %.2f\n", lowest);
            System.out.println("==================================");
        }
    }
}