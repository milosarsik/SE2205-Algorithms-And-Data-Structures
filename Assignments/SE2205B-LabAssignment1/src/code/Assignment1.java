package code;

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
        return null;
    }

    // sub -
    public int[][] sub(int[][] A, int[][] B, int x1, int y1, int x2, int y2, int n)
    {
        return null;
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
        // create matrix

        // read in file

        // etc

        return null;
    }
}

