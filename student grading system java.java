import java.util.*;

// Interface defining grading operations
interface GradingOperations {
    void addStudent(String studentID, String name);
    void addGrade(String studentID, double grade);
    void viewGrades(String studentID);
    double calculateAverage(String studentID);
}

// Abstract class representing a student
abstract class Student {
    protected String studentID;
    protected String name;
    protected List<Double> grades;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public List<Double> getGrades() { return grades; }
}

// Concrete class implementing the grading system
class GradingSystem extends Student implements GradingOperations {
    private Map<String, Student> studentMap;

    public GradingSystem() {
        super("", ""); // Dummy initialization
        studentMap = new HashMap<>();
    }

    @Override
    public void addStudent(String studentID, String name) {
        studentMap.put(studentID, new Student(studentID, name) {});
        System.out.println("Student added: " + name);
    }

    @Override
    public void addGrade(String studentID, double grade) {
        Student student = studentMap.get(studentID);
        if (student != null) {
            student.getGrades().add(grade);
            System.out.println("Grade added for " + student.getName());
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public void viewGrades(String studentID) {
        Student student = studentMap.get(studentID);
        if (student != null) {
            System.out.println("Grades for " + student.getName() + ": " + student.getGrades());
        } else {
            System.out.println("Student not found.");
        }
    }

    @Override
    public double calculateAverage(String studentID) {
        Student student = studentMap.get(studentID);
        if (student != null && !student.getGrades().isEmpty()) {
            double sum = 0;
            for (double grade : student.getGrades()) {
                sum += grade;
            }
            return sum / student.getGrades().size();
        }
        return 0;
    }
}

// Main class with menu-driven program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradingSystem gradingSystem = new GradingSystem();

        while (true) {
            System.out.println("\nStudent Grading System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Grades");
            System.out.println("4. Calculate Average");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    gradingSystem.addStudent(studentID, name);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    double grade = scanner.nextDouble();
                    gradingSystem.addGrade(studentID, grade);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    gradingSystem.viewGrades(studentID);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    double average = gradingSystem.calculateAverage(studentID);
                    System.out.println("Average Grade: " + average);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
