import java.util.Scanner;
public class StudentGradeCalc 
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many subjects ? ");
        int subjects = sc.nextInt();
        int TotalMarks = 0;

        for (int i = 1; i <= subjects; i++) {
            System.out.println("Enter marks for subject " + i + ":");
            int marks = sc.nextInt();
            TotalMarks = TotalMarks + marks;
        }

        double Average = (double) TotalMarks / subjects;
        char Grade;

        switch ((int) (Average / 10)) {
            case 9:
                Grade = 'A';
                break;
            case 8:
                Grade = 'B';
                break;
            case 7:
                Grade = 'C';
                break;
            case 6:
                Grade = 'D';
                break;
            default:
                Grade = 'F';
        }

        System.out.println("\n Results ");
        System.out.println("Total Marks: " + TotalMarks);
        System.out.println("Average Percentage: " + Average + "%");
        System.out.println("Grade: " + Grade);

        sc.close();
    }
}

