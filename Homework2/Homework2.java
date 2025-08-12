/** This homework is about finding the most frequently occuring
 * substring of length k in a given character array 'arr'.
 */
import java.util.Arrays;
import java.util.Random;
public class Homework2 {
    // Algorithm A: Brute Force Counting 
    public static String findMostFrequentA(char[] arr, int k){
        if(arr.length < k)
            return "";
        int max = 0;
        String maxs = "";
        for(int i = 0; i <= arr.length - k; i++){
            int sum = 0;
            String s = new String(arr, i, k);
            for(int j = 0; j <= arr.length - k; j++){
                if(s.equals(new String(arr, j, k))){
                    sum++;
                }
            }
            if(sum > max /* || ((sum == max) && (maxs.compareTo(s)>0)) */){
                max = sum;
                maxs = s;
            }
        }
        return maxs;
    }
    // Algorithm B:
    public static String findMostFrequentB(char[] arr, int k){
        if(arr.length < k)
            return "";
        String[] allKSubstrings = new String[arr.length - k + 1]; 
        for(int i = 0; i <= arr.length - k ; i++){
            allKSubstrings[i] = new String(arr, i, k);
        }
        Arrays.sort(allKSubstrings);

        int max = 0;
        String maxSub = allKSubstrings[0];
        int sum = 1;
        for(int i = 1; i < arr.length - k + 1; i++){
            if(allKSubstrings[i].equals(allKSubstrings[i-1])){
                sum++;
            }
            else{
                if(max < sum){
                    max = sum;
                    maxSub = allKSubstrings[i-1];
                }
                sum = 1;
            }
        }
        return maxSub;

    }
    public static void main(String[] args) {
        /* char[] sample1 = {'a','s','d','a','s','d','a', 's','w', 'd','a','s'}; */
        /* System.out.println(findMostFrequentA(sample1, 3));
        System.out.println(findMostFrequentB(sample1, 3)); */
        
        char[] randomizedArray = new char[100];
        char[] randomizedArray2 = new char[1000];
        char[] randomizedArray3 = new char[10000];
        char[] randomizedArray4 = new char[100000];


        long a1,a2,a3,a4,b1,b2,b3,b4;
        
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            randomizedArray[i] = (char)(rand.nextInt(26) + 97);
        }
        /* System.out.println(Arrays.toString(randomizedArray) + "\n"); */
        long a = System.nanoTime();
        System.out.println(findMostFrequentA(randomizedArray, 3));
        a1 = System.nanoTime() - a;
        a = System.nanoTime();
        System.out.println(findMostFrequentB(randomizedArray, 3));
        b1 = System.nanoTime() - a;
        
        for (int i = 0; i < 1000; i++) {
            randomizedArray2[i] = (char)(rand.nextInt(26) + 97);
        }
        /* System.out.println(Arrays.toString(randomizedArray2) + "\n"); */
        a = System.nanoTime();
        System.out.println(findMostFrequentA(randomizedArray2, 3));
        a2 = System.nanoTime() - a;
        a = System.nanoTime();
        System.out.println(findMostFrequentB(randomizedArray2, 3));
        b2 = System.nanoTime() - a;

        for (int i = 0; i < 10000; i++) {
            randomizedArray3[i] = (char)(rand.nextInt(26) + 97);
        }
        /* System.out.println(Arrays.toString(randomizedArray3) + "\n"); */
        a = System.nanoTime();
        System.out.println(findMostFrequentA(randomizedArray3, 3));
        a3 = System.nanoTime() - a;
        a = System.nanoTime();
        System.out.println(findMostFrequentB(randomizedArray3, 3));
        b3 = System.nanoTime() - a;

        for (int i = 0; i < 100000; i++) {
            randomizedArray4[i] = (char)(rand.nextInt(26) + 97);
        }
        /* System.out.println(Arrays.toString(randomizedArray4) + "\n"); */
        a = System.nanoTime();
        System.out.println(findMostFrequentA(randomizedArray4, 3));
        a4 = System.nanoTime() - a;
        a = System.nanoTime();
        System.out.println(findMostFrequentB(randomizedArray4, 3));
        b4 = System.nanoTime() - a;



        System.out.printf("%20s %20s %20s\n","Size", "Time A (ns)", "Time B (ns)");
        System.out.printf("%20d %20d %20d\n", 100,a1,b1);
        System.out.printf("%20d %20d %20d\n", 1000,a2,b2);
        System.out.printf("%20d %20d %20d\n", 10000,a3,b3);
        System.out.printf("%20d %20d %20d\n", 100000,a4,b4);
        
        

        
    }
}
