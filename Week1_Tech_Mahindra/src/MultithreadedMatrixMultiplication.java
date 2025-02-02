import java.util.*;
class MatrixMultiplicationThread extends Thread {
    private int row, column;
    private int[][] mat1, mat2, result;

    public MatrixMultiplicationThread(int row, int column, int[][] mat1, int[][] mat2, int[][] result) {
        this.row = row;
        this.column = column;
        this.mat1 = mat1;
        this.mat2 = mat2;
        this.result = result;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int k = 0; k < mat2.length; k++) {
            sum += mat1[row][k] * mat2[k][column];
        }
        result[row][column] = sum;
    }
}

public class MultithreadedMatrixMultiplication {
    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length, columns = mat2[0].length;
        int[][] result = new int[rows][columns];
        Thread[][] threads = new Thread[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                threads[i][j] = new MatrixMultiplicationThread(i, j, mat1, mat2, result);
                threads[i][j].start();
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter the array size");
    	int n=sc.nextInt();
    	
        int[][] matrixA = new int[n][n];
        int[][] matrixB = new int[n][n];
        
        System.out.println("enter the first matrix values:");
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		System.out.println("enter the value: ");
        		matrixA[i][j]=sc.nextInt();
        	}
        }
        
        System.out.println("enter the second matrix values:");
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		System.out.println("enter the value: ");
        		matrixB[i][j]=sc.nextInt();
        	}
        }

        int[][] result = multiplyMatrices(matrixA, matrixB);
        System.out.println("Result of the multiplication:");
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}


