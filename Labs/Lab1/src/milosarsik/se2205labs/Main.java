package milosarsik.se2205labs;

import java.lang.Math;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(newtonSqrt(10,3,0.001));

        System.out.println(findMinChangeCoins(1,1));
    }

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

    public static int findMinChangeCoins(int C, int n)
    {
        return 1;
    }
}
