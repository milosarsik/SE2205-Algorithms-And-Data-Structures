package milosarsik.se2205labs;

import java.lang.Math;

public class Main
{
    final static int[] S = {1, 5, 10, 20, 25};

    public static void main(String[] args)
    {
        System.out.println("Lab 1: Week of Jan 23, 2019");

        System.out.println("Exericse 1");
        System.out.println(newtonSqrt(4,2,0.001));

        System.out.println("Exericse 2");
        System.out.println(findMinChangeCoins(1,1));
    }

    /**
     * Returns the square root of a given number to the precision
     *
     * @param   x   the number that we are finding the square root of
     * @param   a   our best guess
     * @param   eps precision
     * @return      the square root of the number x
     **/
    public static double newtonSqrt(double x, double a, double eps)
    {
        if( Math.abs((a*a) - x) <= eps)
        {
            return a;
        }
        else
        {
            a = (a+(x/a))/2;

            return newtonSqrt(x, a, eps);
        }
    }

    /** findMinChange - the coins that will be used are S = {1, 5, 10, 20, 25}
     * @param   C   the change needed
     * @param   n   the nth coin the set S containing the denominations of the coins in increasing order
     * @return      the total least number of coins needed to make the change
    **/
    public static int findMinChangeCoins(int C, int n)
    {
        if(C == 0)
        {
            return 0;
        }

        return 1;
    }
}
