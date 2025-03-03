import java.util.Scanner;

// Lab 03, Q2, Admissions Score Calculator, Gülser İrem AÇIKGÖZ, 27.02.2025 

public class Lab03_Q2 {
    public static void main(String[] args){
        // limit values that candidate should have at least
        final double GPA_LIM = 3.3, IELTS_LIM = 6.5;
        final int REFSCORE_LIM = 6, PAPER_LIM = 1, FAIL_LIM = 3, PROF_LIM = 5;

        double GPA, IELTS;//double values from user
        int refScore1, refScore2, paperNumber, failedNumber, profScore, totalPoints;//in values from user and score output
        String eligibility = "";//if user is not eligible the reason why
        String prof;//if prof score is empty getting that value
        boolean profEli;//if prof value (wheter it is exist) is eligble this value would be true
        
        totalPoints = 0;//initial value

        Scanner input = new Scanner(System.in);
        System.out.print("GPA: ");
        GPA = input.nextDouble();
        GPA = Math.round(GPA * 10) / 10.0;//rounded GPA to 1 decimal point
        System.out.print("First reference score: ");
        refScore1 = input.nextInt();
        System.out.print("Second reference score: ");
        refScore2 = input.nextInt();
        System.out.print("Number of papers: ");
        paperNumber = input.nextInt();
        System.out.print("Number of failed courses: ");
        failedNumber = input.nextInt();
        System.out.print("Bilkent professor's score: ");
        prof = input.next();
        if (!(prof.equals("N/A"))){//empty?
            profScore = Integer.parseInt(prof);//to int
            totalPoints += profScore * 30;//add score
            if (profScore < PROF_LIM)//eligible?
                profEli = false;
            else
                profEli = true;
        }
        else 
            profEli = false;
        System.out.print("IELTS score:");
        IELTS = input.nextDouble();
        
        
        //GPA part
        if (GPA >= GPA_LIM)
            totalPoints += ((GPA - GPA_LIM) / 0.1) * 20; 
        else
            eligibility += "- GPA is below the required threshold.\n";
        //refScores
        totalPoints += (refScore1 + refScore2) * 10;
        if (refScore1 < REFSCORE_LIM)
            eligibility += "- The first reference score is below the required threshold.\n";
        if (refScore2 < REFSCORE_LIM)
            eligibility += "- The second reference score is below the required threshold.\n";
        //papers
        if (paperNumber >= PAPER_LIM)
            totalPoints += (paperNumber - 1) * 100;
        else
            eligibility += "- Candidate must have at least one research paper.\n";
        //failed course
        totalPoints -= failedNumber * 30;
        if (failedNumber > FAIL_LIM)
            eligibility += "- The number of failed courses exceeds the limit.\n";
        //ADD professor
        if (!profEli)
            eligibility += "- The score given by Bilkent professors is below the required threshold.\n" ;
        //IELTS
        if (IELTS >= IELTS_LIM)
            totalPoints += ((IELTS - IELTS_LIM) / 0.5) * 10;
        else 
            eligibility += "- IELTS score is below the required threshold.\n";
        //prints
        System.out.println("Calculated score: " + totalPoints);
        if ( eligibility.equals(""))
            System.out.println("The candidate is eligible for admission.");
        else
            System.out.printf("The candidate is NOT eligible.\nReasons:\n%s",eligibility);
        input.close();
    }
}
