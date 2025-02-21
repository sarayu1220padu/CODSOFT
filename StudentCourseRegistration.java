import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CourseRegistrationSystem {

    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        CourseRegistrationSystem s = new CourseRegistrationSystem();
        s.run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nCourse Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. List Courses");
            System.out.println("4. Register Student for Course");
            System.out.println("5. Remove Student from Course");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCourse(sc);
                    break;
                case 2:
                    addStudent(sc);
                    break;
                case 3:
                    listCourses();
                    break;
                case 4:
                    registerStudentForCourse(sc);
                    break;
                case 5:
                    removeStudentFromCourse(sc);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private void addCourse(Scanner sc) {
        System.out.print("Enter course code: ");
        String code = sc.nextLine();
        System.out.print("Enter course title: ");
        String title = sc.nextLine();
        System.out.print("Enter course description: ");
        String description = sc.nextLine();
        System.out.print("Enter course capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();  
        System.out.print("Enter course schedule: ");
        String schedule = sc.nextLine();

        courses.put(code, new Course(code, title, description, capacity, schedule));
        System.out.println("Course added successfully.");
    }

    private void addStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        students.put(id, new Student(id, name));
        System.out.println("Student added successfully.");
    }

    private void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses.values()) {
            System.out.println(course.getDetails());
        }
    }

    private void registerStudentForCourse(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = sc.nextLine();

        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student != null && course != null) {
            if (course.addStudent()) {
                student.registerCourse(courseCode);
                System.out.println("Student registered for course successfully.");
            } else {
                System.out.println("Course is full.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    private void removeStudentFromCourse(Scanner sc) {
        System.out.print("Enter student ID: ");
        String studentId = sc.nextLine();
        System.out.print("Enter course code: ");
        String courseCode = sc.nextLine();

        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (student != null && course != null) {
            if (course.removeStudent()) {
                student.removeCourse(courseCode);
                System.out.println("Student removed from course successfully.");
            } else {
                System.out.println("Error removing student from course.");  // Likely student not in course
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }



    // Inner classes for Course and Student
    private class Course {
        String code;
        String title;
        String description;
        int capacity;
        String schedule;
        int enrolled;

        public Course(String code, String title, String description, int capacity, String schedule) {
            this.code = code;
            this.title = title;
            this.description = description;
            this.capacity = capacity;
            this.schedule = schedule;
            this.enrolled = 0;
        }

        public boolean addStudent() {
            if (enrolled < capacity) {
                enrolled++;
                return true;
            }
            return false;
        }

        public boolean removeStudent() {
            if (enrolled > 0) { // Basic check, could be more robust
                enrolled--;
                return true;
            }
            return false;
        }

        public String getDetails() {
            return String.format("%s: %s (%s, Capacity: %d, Enrolled: %d, Slots Available: %d)",
                    code, title, schedule, capacity, enrolled, (capacity - enrolled));
        }
    }

    private class Student {
        String id;
        String name;
        ArrayList<String> registeredCourses;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
            this.registeredCourses = new ArrayList<>();
        }

        public void registerCourse(String courseCode) {
            registeredCourses.add(courseCode);
        }

        public void removeCourse(String courseCode) {
            registeredCourses.remove(courseCode);
        }
    }
}


