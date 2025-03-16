import java.util.Scanner;

// Lab 04, Q4, GPA Calculator, Gülser İrem AÇIKGÖZ, 6.03.2025 

public class Lab04_Q4{
    public static void main(String[] args){
        int credits, grade, contribution; //inputs (credits for a course, grade for one exam that exam's contribution)
        int totalCredits = 0, totalContribution = 0, courseGPA, course; // sum of credits, sum of contribution for a course, GPA for a course, course number
        double totalGradeForCouse = 0, semesterGPA = 0; //sum of grades considering contributions, GPA(output)

        course = 1;

        //scanning credits for the first time
        Scanner input = new Scanner(System.in);
        System.out.printf("Course %d credits: ", course);
        credits = input.nextInt();

        //if user input a invaid credit program would finishes
        if (credits > 0){
            while (credits > 0){
                totalCredits += credits;//sum of credits
                while (totalContribution < 100){//checking wether the total contribution reach 100
                    System.out.print("\nEnter the grade: ");
                    grade = input.nextInt();
                    while (grade > 100 || grade < 0){//invalid grade reinput
                        System.out.println("The grade you entered is invalid");
                        System.out.print("Enter the grade: ");
                        grade = input.nextInt();
                    }
                    System.out.print("Enter the contribution (in %): ");
                    contribution = input.nextInt();
                    while (contribution > 100 || contribution < 0){//invalid contribution reinput
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

                semesterGPA += courseGPA * credits; //to calculate semester gpa first adding courseGPA's considering credits then divide by totalcredits

                totalContribution = 0;//make it available for next course
                totalGradeForCouse = 0;//make it available for next course
                course++;//next course
                
                //scanning credits for others
                System.out.printf("Course %d credits: ", course);
                credits = input.nextInt();
            }
            semesterGPA =  semesterGPA / totalCredits;//last step

            //program finishes bc user input a invalid value only thing is printing outputs
            System.out.println("\nTotal courses: " + (course - 1));
            System.out.println("Total credits: " + totalCredits);
            System.out.printf("Total GPA: %.2f", semesterGPA);
        }
        else
            System.out.println("credit invalid");
        input.close();
    }
}