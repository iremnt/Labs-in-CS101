
/* Matrix Operations, 16.04.2025, İrem Açıkgöz */

public class Lab7_Q1 {

    //sum of the matrices if they are not same by their dimentions return null
    public static int[][] addMatrices(int[][] matrixOne, int[][] matrixTwo){
        int[][] matrixSum = new int[matrixOne.length][matrixOne[0].length];
        if(matrixOne.length != matrixTwo.length)
            return null;
        else{
            for (int i = 0; i < matrixOne.length; i++) {
                if(matrixOne[i].length != matrixTwo[i].length)
                    return null;
                for (int j = 0; j < matrixOne[i].length; j++) {
                    matrixSum[i][j] = matrixOne[i][j] + matrixTwo[i][j];
                }
            }
        }
        return matrixSum;
    }

    //check Identity or not
    public static boolean isIdentityMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if((i == j) && (matrix[i][j] != 1))
                    return false;
                else if((i != j) && (matrix[i][j] != 0))
                    return false;
            }
        }return true;
    }

    //return square matrix by clockwise if its not square return null
    public static int[][] rotateMatrix90Degrees(int[][] matrix){
        if(matrix.length != matrix[0].length)
            return null;
        int[][] rotated = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                rotated[j][matrix.length - 1 - i]=matrix[i][j];
            }
        }return rotated;
    }

    public static boolean isToeplitzMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if(matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }
        return true;
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){

        //sample run
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9} }; 
        int[][] matrixB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1} }; 
        int[][] matrixC = {{1, 2, 3, 4}, {5, 1, 2, 3}, {6, 5, 1, 2} }; 
        System.out.println("Initially matrix A is: "); 
        printMatrix(matrixA); 
        System.out.println("Initially matrix B is: "); 
        printMatrix(matrixB); 
        System.out.println("Initially matrix C is: "); 
        printMatrix(matrixC);

        int[][] sum = addMatrices(matrixA, matrixB); 
        System.out.println("Sum of matrices:"); 
        printMatrix(sum);

        System.out.println("Is matrixA an identity matrix? " + isIdentityMatrix(matrixA));

        int[][] rotatedMatrix = rotateMatrix90Degrees(matrixA); 
        System.out.println("MatrixA rotated 90 degrees clockwise:"); 
        printMatrix(rotatedMatrix);

        System.out.println("Is matrixA a Toeplitz matrix? " + isToeplitzMatrix(matrixA)); 
        System.out.println("Is matrixC a Toeplitz matrix? " + isToeplitzMatrix(matrixC));
    }
}
