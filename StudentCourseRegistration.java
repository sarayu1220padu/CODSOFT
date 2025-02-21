import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistration {

    static ArrayList<String> courses = new ArrayList<>();  
    static ArrayList<Integer> capacities = new ArrayList<>();  
    static ArrayList<String> students = new ArrayList<>();  
    static ArrayList<ArrayList<String>> registrations = new ArrayList<>();  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        courses.add("BE"); capacities.add(50);
        courses.add("BTECH"); capacities.add(40);
        courses.add("MTECH"); capacities.add(60);

        int choice;
        do {
            System.out.println("\nCourse Registration");
            System.out.println("1. View Courses");
            System.out.println("2. Register");
            System.out.println("3. Remove");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    viewCourses();
                    break;
                case 2:
                    register(sc);
                    break;
                case 3:
                    remove(sc);
                    break;
                case 4:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid.");
            }
        } 
        while (choice != 4);
        sc.close();
    }

    static void viewCourses() 
    {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i) + " (Capacity: " + capacities.get(i) + ")");
        }
    }

    static void register(Scanner sc) 
    {
        System.out.print("Student Name: ");
        String student = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();

        if (courses.contains(course)) {
            int courseIndex = courses.indexOf(course);
            if (capacities.get(courseIndex) > countRegistrations(course)) { // Check capacity
                students.add(student);
                ArrayList<String> studentCourses = new ArrayList<>();
                studentCourses.add(course);
                registrations.add(studentCourses);
                System.out.println("Registered.");
            } 
            else {
                System.out.println("Course full.");
            }
        } 
        else 
        {
            System.out.println("Course not found.");
        }
    }

    static int countRegistrations(String course) {
        int count = 0;
        for (ArrayList<String> reg : registrations) {
            if (reg.contains(course)) {
                count++;
            }
        }
        return count;
    }

    static void remove(Scanner sc) {
        System.out.print("Student Name: ");
        String student = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();

        int studentIndex = students.indexOf(student);
        if(studentIndex != -1){
            ArrayList<String> studentCourses = registrations.get(studentIndex);
            if (studentCourses.contains(course)) {
                studentCourses.remove(course);
                System.out.println("Removed.");
            } else {
                System.out.println("Not registered for that course.");
            }
        } else
         {
            System.out.println("Student not found.");
        }

    }
}
