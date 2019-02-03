import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        int [] integerArray = {0, 1, 2, 3, 4, 5};
        int [] problem55 = {4, 3, 6, 2, 6};
        int [][] problem510 = {{1,1,1},{1,1,1},{1,1,1}};
        String problem517 = "Hello";

        System.out.println("Problem 5.1 - findMaxElement");
        System.out.println(findMaxElement(integerArray, integerArray.length));

        System.out.println("Problem 5.2 - ?");

        System.out.println("Problem 5.5 - reverseArray");
        reverseArray(problem55, 0,4);
        printArray(problem55, problem55.length);


        System.out.println("Problem 5.7 - harmonicNumber");
        System.out.println(harmonicNumber(2));

        System.out.println("Problem 5.10 - sumOfAllElements");
        System.out.println(sumOfAllElements(problem510, 3));

        System.out.println("Problem 5.17 - reverseString");
        String temp = reverseString(problem517);
        System.out.println(temp);

    }

    /**
     * Problem 5.1 - Describe a recursive algorithm for finding the maximum element in an array, A,
     * of n elements. What is your running time and space usage?
     *
     * @param   array   the array that is passed
     * @param   n       size of the array
     * @return          maximum element in the array
     **/
    public static int findMaxElement(int[] array, int n)
    {
        // if size = 0, that means that the whole array has been traversed
        if (n == 1)
        {
            return array[0];
        }

        return Math.max(array[n - 1], findMaxElement(array, n-1));
    }


    /**
     * Problem 5.2 - Explain how to modify the recursive binary search algorithm so
     * that it returns the index of the target in the sequence or−1 (if the target is not found).
     *
     * Problem 5.5 - Draw the recursion trace for the execution of reverseArray(data, 0, 4), from
     * Code Fragment 5.7, on array data = 4, 3, 6, 2, 6.
     *
     * @param   array   the array that is passed
     * @param   low     low index
     * @param   high    high index
     * @return          reverse array
     **/
    public static void reverseArray(int[] array, int low, int high)
    {
        // if at least two elements in subarray
        if(low < high)
        {
            int temp = array[low];                                      // swap array[low] and array[high]
            array[low] = array[high];
            array[high] = temp;

            reverseArray(array, low + 1, high - 1);         // recur on the rest
        }
    }

    /**
     * Problem 5.7 - Describe a recursive algorithm for computing the nth Harmonic number
     *
     * @param   n   the nth harmonic number
     * @return      computed nth harmonic number
     **/
    public static double harmonicNumber(int n)
    {
        // base case, if n = 1 we have reached the lowest number that n can be, we know 1/1 is 1 therefore we return 1
        if(n == 1)
        {
            return 1;
        }

        return 1.0 / n + harmonicNumber(n - 1);
    }

    /**
     * Problem 5.10 - Describe a way to use recursion to compute the sum of all the
     * elements in an n×n (two-dimensional) array of integers.
     *
     * @param   array   the 2D array we will compute
     * @param   n       the size of the array
     * @return          the computed sum of the 2D array
     **/
    // problem 5.10 - Describe a way to use recursion to compute the sum of all the elements in an n×n (two-dimensional) array of integers.
    public static int sumOfAllElements(int [][] array, int n)
    {
        if(n == 1)
        {
            return array[0][0];
        }

        int edges = 0;

        for(int i = 0; i < n; i++)
        {
            edges += array[i][n - 1] + array[n - 1][i];
        }

        edges -= array[n - 1][n - 1];

        return edges + sumOfAllElements(array, n - 1);
    }

    /**
     * Problem 5.17 - Write a short recursive Java method that takes a character string
     * s and outputs its reverse. For example, the reverse of 'pots&pans' would be 'snap&stop'.
     *
     * @param   string   the string to reverse
     * @return           the reverse string
     **/
    public static String reverseString(String string)
    {
        if(string.isEmpty())
        {
            return string;
        }

        return reverseString(string.substring(1)) + string.charAt(0);
    }

    /**
     * Problem 5.18 -  Write a short recursive Java method that determines if a string s is a
     * palindrome, that is, it is equal to its reverse. Examples of palindromes include 'racecar'
     * and 'gohangasalamiimalasagnahog'.
     *
     * @param   s   the sentence
     * @return      whether the string is a palindrom or not
     **/

    /**
     * Problem 5.21 -Given an unsorted array, A, of integers and an integer k, describe a recursive
     * algorithm for rearrangingthe elements in A so that all elements less than or equal to k come
     * before any elements larger than k. What is the running time of your algorithm on an array of
     * n values?
     *
     * @param   A   unsorted array
     * @param   k   integer
     * @return      rearranged array
     **/

    /**
     * Problem 5.23 - Describe a recursive algorithm that will check if an array A of integers
     * contains an integer A[i] that is the sum of two integers that appear earlier in A, that is,
     * such that A[i] = A[j]+A[k] for j,k < i.
     *
     * @param   A   array
     * @return      returns whether there is an integer that is the sum of two integers earlier in A
     **/



    /**
     * In-Class Problem - reverse a Queue
     *
     * @param   myQueue     the queue we want to reverse
     * @return              the reverse queue
     **/
    public void reverseQueue(Queue<Integer> myQueue)
    {
        if(myQueue.isEmpty())
        {
            return;
        }

        int temp = myQueue.remove();

        reverseQueue(myQueue);

        myQueue.add(temp);
    }

    /**
     * print function to print arrays
     *
     * @param   array   array that we will print
     **/
    public static void printArray(int [] array, int size)
    {
        for(int i = 0; i < size; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
}
