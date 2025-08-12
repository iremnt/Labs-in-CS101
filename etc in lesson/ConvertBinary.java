import java.util.Scanner;

public class ConvertBinary {
    public static void main(String[] args) {
        String number;
        int index, sum=0;
        Scanner input = new Scanner(System.in);
        System.out.print("gir: ");
        number = input.nextLine();
        index = number.length();
        while (index != 0){
            sum += Integer.parseInt(number.charAt(index - 1)+"") * Math.pow(2, Math.abs(index - number.length()));
            index--;
        }
        System.out.println(sum);
    }
}
