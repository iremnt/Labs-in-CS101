import java.util.Scanner;

// Lab 04, Q2, GPA Calculator, Gülser İrem AÇIKGÖZ, 6.03.2025 

public class Lab04_Q4{
    public static void main(String[] args){
        int course, credits, totalCredits = 0, grade, contribution, totalContribution = 0, courseGPA;
        double totalGradeForCouse = 0, semesterGPA = 0;
        course = 1;
        Scanner input = new Scanner(System.in);
        System.out.printf("Course %d credits: ", course);
        credits = input.nextInt();
        while (credits > 0){
            totalCredits += credits;
            while (totalContribution < 100){
                System.out.print("\nEnter the grade: ");
                grade = input.nextInt();
                while (grade > 100 || grade < 0){
                    System.out.println("The grade you entered is invalid");
                    System.out.print("Enter the grade: ");
                    grade = input.nextInt();
                }
                System.out.print("Enter the contribution (in %): ");
                contribution = input.nextInt();
                while (contribution > 100 || contribution < 0){
                    System.out.println("The contribution you entered is invalid");
                    System.out.print("Enter the contribution (in %): ");
                    contribution = input.nextInt();
                }
                totalContribution += contribution;
                totalGradeForCouse += grade * contribution / 100.0;
            }
            if (totalGradeForCouse >= 80)
                courseGPA = 4;
            else if(totalGradeForCouse >= 60)
                courseGPA = 3;
            else if(totalGradeForCouse >= 40)
                courseGPA = 2;
            else if (totalGradeForCouse >= 20)
                courseGPA = 1;
            else 
                courseGPA = 0;

            System.out.println("\nTotal contribution has reached 100% for this course");
            System.out.printf("Course grade out of 100: %.2f\n", totalGradeForCouse);
            System.out.println("Course GPA: " + courseGPA + "\n");

            semesterGPA += courseGPA * credits;
            totalContribution = 0;
            totalGradeForCouse = 0;
            course++;
            System.out.printf("Course %d credits: ", course);
            credits = input.nextInt();
        }
        semesterGPA =  semesterGPA / totalCredits;
        System.out.println("\nTotal courses: " + (course - 1));
        System.out.println("Total credits: " + totalCredits);
        System.out.printf("Total GPA: %.2f", semesterGPA);
        input.close();
    }
}