package code;

import java.io.File;
import java.util.Scanner;

public class Assignment1
{
    // denseMatrixMult -
    public int[][] denseMatrixMult(int[][] A, int[][] B, int size)
    {

        int matrix[][]=new int [size][size];
        if (size == 1)
        {

            matrix[0][0] = A[0][0] * B[0][0];
        }
        else
        {
            int[][] sub1a = new int[size / 2][size / 2];
            int[][] sub2a = new int[size / 2][size / 2];
            int[][] sub3a = new int[size / 2][size / 2];
            int[][] sub4a = new int[size / 2][size / 2];

            // second matrix
            int[][] sub1b = new int[size / 2][size / 2];
            int[][] sub2b = new int[size / 2][size / 2];
            int[][] sub3b = new int[size / 2][size / 2];
            int[][] sub4b = new int[size / 2][size / 2];

        }
        return matrix;
    }


    // sum - addition of two matrices
    public int[][] sum(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
    {
        // creates matrix to be returned
        int sumMatrix[][]= new int[n][n];

        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < n; j++)
            {
               // adds matrices
               sumMatrix[i][j] = A[i+x1][j+y1]+B[i+x2][j+y2];
            }
        }

        return sumMatrix;
    }

    // sub - subtraction of two matrices
    public int[][] sub(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
    {
        // creates matrix to be returned
        int subMatrix[][]= new int[n][n];

        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                //subtracts matrices
                subMatrix[i][j] = A[i+x1][j+y1]-B[i+x2][j+y2];
            }
        }

        return subMatrix;
    }

    // initMatrix - a 2D array of size n will be initialized
    public int[][] initMatrix(int n)
    {
        // creating a matrix of size n x n
        int matrix [][] = new int[n][n];

        // setting each element to zero
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = 0;
            }
        }

        return matrix;
    }

    // printMatrix - prints the 2D array of size n
    public void printMatrix(int n, int[][] A)
    {
        // printing the matrix
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(A[i][j] + " ");    // printing the element at position with a space after it
            }

            // going to the next row
            System.out.println();
        }
    }

    // readMatrix - read the content of a data ﬁle called filename and store the content of this ﬁle in a 2D array of size n
    public int[][] readMatrix(String filename, int n) throws Exception
    {
        // creates scanner object called read
        Scanner read = new Scanner (new File(filename));

        int matrix[][]=new int [n][n];//creates an array called matrix to store the values

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(read.hasNextInt())
                {
                    // stores values in matrix
                    matrix[i][j] = read.nextInt();
                }
            }
        }

        return matrix;
    }
}

