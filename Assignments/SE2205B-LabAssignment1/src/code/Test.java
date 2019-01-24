/* 
Milos Arsik - marsik - 250953645
Cyriac Jinson - cjinson - 250957394
*/

package code;

public class Test
{
    public static void main(String[] args)throws Exception
    {
        //int testPart = Integer.parseInt(args[0]);

        // this value here will vary for each different test, make sure to change
        int testPart = 3;

        Assignment1 a1 = new Assignment1();

        // matrix size (the size is 10 for part 1 and 8 for part 2)
        int n = 8;

        // the 2D array that holds the matrix
        int[][] matrix;

        // Testing begins here
        if(testPart==1)                                                     // PASSED
        {
            matrix = a1.initMatrix(n);

            a1.printMatrix(n, matrix);
        }
        else if(testPart==2)                                                // PASSED
        {
            matrix = a1.readMatrix("src/matrix1.txt",n);

            a1.printMatrix(n,matrix);
        }
        else if(testPart==3 )                                               // PASSED
        {
            //int nextPart = Integer.parseInt(args[1]);
            int nextPart = 2;

            if(nextPart==1){
                int[][] matrix1=a1.readMatrix("src/matrix1.txt",n);
                int[][] matrix2=a1.readMatrix("src/matrix2.txt",n);
                int[][] sumMatrix = a1.sum(matrix1, matrix2, 1, 1, 0, 1, 3);
                a1.printMatrix(n,matrix1);
                a1.printMatrix(n,matrix2);
                a1.printMatrix(3,sumMatrix);
            }
            else {
                int[][] matrix1=a1.readMatrix("src/matrix1.txt",n);
                int[][] matrix2=a1.readMatrix("src/matrix2.txt",n);
                int[][] sumMatrix = a1.sub(matrix1, matrix2, 1, 1, 0, 1, 3);
                a1.printMatrix(n,matrix1);
                a1.printMatrix(n,matrix2);
                a1.printMatrix(3,sumMatrix);
            }
        }
        else {                                                              //
            int[][] matrix1=a1.readMatrix("src/matrix1.txt",n);
            int[][] matrix2=a1.readMatrix("src/matrix2.txt",n);
            int[][] resultingMatrix=a1.denseMatrixMult(matrix1, matrix2, n);
            a1.printMatrix(n,resultingMatrix);
        }
    }
}
