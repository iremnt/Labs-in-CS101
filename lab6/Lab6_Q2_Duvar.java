import java.util.Random;
import java.util.Scanner;
public class Lab6_Q2_Duvar {
    public static int snakeX;
    public static int snakeY;
    public static int foodX;
    public static int foodY;
    public static boolean gameOver;
    
    public static void moveSnake(String direction){
        if(direction.equals("w")||direction.equals("W"))
            snakeY--;
        if(direction.equals("s")||direction.equals("S"))
            snakeY++;
        if(direction.equals("d")||direction.equals("D"))
            snakeX++;
        if(direction.equals("a")||direction.equals("A"))
            snakeX--;
        outOfBounds();
    }
    public static void checkFood(){
        if(foodX==snakeX && foodY==snakeY){
            System.out.println("Yum! Snake ate the food!");
            generateFood();
        }
    }
    public static void isGameOver(){
        if (snakeX<0 || snakeX>9 || snakeY<0 || snakeY>9){
            System.out.println("Game over! Snake hit the wall.");
            gameOver = true;
        }
        gameOver = false;
    }
    public static void outOfBounds(){
        if(snakeX<0)
            snakeX=9;
        else if(snakeX>9)
            snakeX=0;
        else if(snakeY<0)
            snakeY=9;
        else if(snakeY>9)
            snakeY=0;
    }
    public static void generateFood(){
        Random rand = new Random();
        foodX = rand.nextInt(10);
        foodY = rand.nextInt(10);
        while(foodX==snakeX && foodY==snakeY){
            foodX = rand.nextInt(10);
            foodY = rand.nextInt(10);
        }    
    }
    public static void printGrid(){
        for(int i=0; i<10;i++){
            for (int j=0; j<10;j++){
                if(snakeY==i && snakeX==j)
                    System.out.printf("%-2s","S");
                else if(foodY==i && foodX==j)
                    System.out.printf("%-2s","O");
                else
                    System.out.printf("%-2s","*");
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String move;
        snakeX=5;
        snakeY=5;
        System.out.println("Welcome to Hungry Snake!");
        System.out.println("Use w (Up), A (Left), S (Down), D (Right) to move.");
        generateFood();
        while(true){
            printGrid();
            System.out.print("Move: ");
            move=in.nextLine();
            moveSnake(move);
            checkFood();
        }
    }
}