package code;

import java.io.File;
import java.util.Scanner;

public class Assignment1
{
    // denseMatrixMult -
    public int[][] denseMatrixMult(int[][] A, int[][] B, int size)
    {
        return null;
    }

    // sum -
    public int[][] sum(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
    {

        int sumMatrix[][]= new int[n][n];//Creates matrix to be returned
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < n; j++)
            {
               sumMatrix[i][j] = A[i+x1][j+y1]+B[i+x2][j+y2];//adds matrices
            }
        }

        return sumMatrix;
    }

    // sub -
    public int[][] sub(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
    {
        int subMatrix[][]= new int[n][n];//Creates matrix to be returned
        for(int i = 0; i < n; i ++)
        {
            for(int j = 0; j < n; j++)
            {
                subMatrix[i][j] = A[i+x1][j+y1]-B[i+x2][j+y2];//subtracts matrices
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

        // returning the matrix
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

        Scanner inp = new Scanner (new File(filename));//Creates scanner object called inp

        int matrix[][]=new int [n][n];//creates an array called matrix to store the values

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(inp.hasNextInt())
                {
                    matrix[i][j] = inp.nextInt();//Stores values in matrix
                }
            }
        }

        return matrix;
    }
}

