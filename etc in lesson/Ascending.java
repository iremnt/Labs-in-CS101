
import java.util.Scanner;
// hasnexınt int mi değil mi diye bakıyor
public class Ascending {
    public static void main(String[] args) { 
        int number, previous = 4, count = 0;
        boolean ascends = true, done = true;
        Scanner input = new Scanner(System.in);
        System.out.print("enter a number: ");
        if (!input.hasNextInt())
            done = false;
        while (input.hasNextInt() && done){
    
                if (count == 0){
                    previous = input.nextInt();
                    count = 1;
                }
                else{
                    number = input.nextInt();
                    if (number <= previous){
                        ascends = false;
                    }
                }
                System.out.print("enter a number: ");
                if (!input.hasNextInt())
                    done = false;
            
        }
        if (ascends)
                System.out.println("numbers are ascending order");
        else
                System.out.println("numbers are not ascending order");
    }
}
