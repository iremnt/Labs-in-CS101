import java.util.Scanner;
public class Lab6_Q1 {
    public static String reverse(String str){
        String output = "";
        for(int i = str.length()-1; i>=0; i--){
            output+=str.charAt(i);
        }
        return output;
    }

    public static boolean isPalindrome(String str){
        String reversed = reverse(str);
        return reversed.equals(str);
    }

    public static boolean hasAllUniqueChars(String str){
        String uniqueChars = ",";
        for (int i = 0; i<str.length(); i++){
            if(uniqueChars.contains(str.charAt(i)+""))
                return false;
            else
                uniqueChars+=str.charAt(i);
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userS = in.nextLine();
        System.out.println("Reversed String: "+ reverse(userS));
        System.out.println("Is Palindrome: "+ isPalindrome(userS));
        System.out.println("Has All Unique Characters: "+ hasAllUniqueChars(userS));

    }
}
