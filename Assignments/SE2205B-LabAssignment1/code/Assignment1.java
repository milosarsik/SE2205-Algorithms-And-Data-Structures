/*
Milos Arsik - marsik - 250953645
Cyriac Jinson - cjinson - 250957394
*/

import java.io.*;
import java.io.File;
import java.util.Scanner;

public class Assignment1
{
  // denseMatrixMult - multiplying 2 matrices together with a recursive call
  public int[][] denseMatrixMult(int[][] A, int[][] B, int size)
  {
    // creating the resultant matrix
    int matrix[][] = new int [size][size];

    // base case for when the matrices reach a size of 1x1
    if (size == 1)
    {
      matrix[0][0] = A[0][0] * B[0][0];               // multiplying the two entries
    }
    else
    {
      // creating sub matrices for matrix A
      int[][] A00 = new int[size / 2][size / 2];      //a
      int[][] A01 = new int[size / 2][size / 2];      //b
      int[][] A10 = new int[size / 2][size / 2];      //c
      int[][] A11 = new int[size / 2][size / 2];      //d

      // creating sub matrices for matrix B
      int[][] B00 = new int[size / 2][size / 2];      //e
      int[][] B01 = new int[size / 2][size / 2];      //f
      int[][] B10 = new int[size / 2][size / 2];      //g
      int[][] B11 = new int[size / 2][size / 2];      //h

      // dividing matrix A into 4 parts and putting them into the sub matrices
      divideArray(A, A00, 0, 0);
      divideArray(A, A01, 0, size / 2);
      divideArray(A, A10, size / 2, 0);
      divideArray(A, A11, size/ 2, size / 2);

      // dividing matrix B into 4 parts and putting them into the sub matrices
      divideArray(B, B00, 0, 0);
      divideArray(B, B01, 0, size / 2);
      divideArray(B, B10, size / 2, 0);
      divideArray(B, B11, size / 2, size / 2);

      // these are the 7 matrices multiplications as follows
      int[][] M0 = denseMatrixMult(sum(A00, A11,0,0,0,0,size/2), sum(B00, B11,0,0,0,0,size/2),size/2);            // (A0,0 + A1,1) * (B0,0 + B1,1)
      int[][] M1 = denseMatrixMult(sum(A10,A11,0,0,0,0,size/2),B00,size/2);                                                           // (A1,0 + A1,1)* (B0,0)
      int[][] M2 = denseMatrixMult(A00, sub(B01, B11,0,0,0,0,size/2),size/2);                                                          // (A0,0) * (B0,1 − B1,1)
      int[][] M3 = denseMatrixMult(A11, sub(B10, B00,0,0,0,0,size/2),size/2);                                                           // (A0,0) * (B0,1 − B1,1)
      int[][] M4 = denseMatrixMult(sum(A00,A01,0,0,0,0,size/2), B11,size/2);                                                             // (A0,0 + A0,1) * (B1,1)
      int[][] M5 = denseMatrixMult(sub(A10, A00,0,0,0,0,size/2), sum(B00, B01,0,0,0,0,size/2),size/2);                // (A1,0 − A0,0) * (B0,0 + B0,1)
      int[][] M6 = denseMatrixMult(sub(A01, A11,0,0,0,0,size/2), sum(B10, B11,0,0,0,0,size/2), size/2);                // (A0,1 − A1,1)(B1,0 + B1,1)

      // combine matrix multiplications from the previous block to calculate the resultant matrix C
      int[][] C11 = sum(sub(sum(M0, M3,0,0,0,0,size/2), M4,0,0,0,0,size/2), M6,0,0,0,0,size/2);     // M0 + M3 − M4 + M6
      int[][] C12 = sum(M2, M4,0,0,0,0,size/2);                                                                                             // M2 + M4
      int[][] C21 = sum(M1, M3,0,0,0,0,size/2);                                                                                              // M1 + M3
      int[][] C22 = sum(sub(sum(M0, M2,0,0,0,0,size/2), M1,0,0,0,0,size/2), M5,0,0,0,0,size/2);        // M0 − M1 + M2 + M5

      // merges the C sub matrices
      mergeArray(C11, matrix, 0, 0);
      mergeArray(C12, matrix, 0, size / 2);
      mergeArray(C21, matrix, size / 2, 0);
      mergeArray(C22, matrix, size / 2, size / 2);
    }
    return matrix;
  }

  // divideArray - splits the array
  public void divideArray(int[][] P, int[][] C, int iB, int jB)
  {
    for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
      for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
        C[i1][j1] = P[i2][j2];
  }

  // mergeArray - merges two arrays from the given starting positions
  public void mergeArray(int[][] C, int[][] P, int iB, int jB)
  {
    for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
    {
      for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
      {
        P[i2][j2] = C[i1][j1];
      }
    }
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

  // readMatrix - read the content of a data file called filename and store the content of this file in a 2D array of size n
  public int[][] readMatrix(String filename, int n) throws Exception
  {
    // creates scanner object called read
    Scanner read = new Scanner (new File(filename));

    //creates an array called matrix to store the values
    int matrix[][]=new int [n][n];

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


