package coursera.week2;

import java.util.Scanner;

public class Test
{
    public static long m;
    public static int ind;
    public static long first_no,second_no;
    public static boolean flag = false;
    public static long fib_no;

    public static int find_index(long mod_no)
    {
        int i = 1;
        first_no= 0;
        second_no= 1;

        while(flag != true)
        {
            fib_no = first_no + second_no;
            second_no = first_no;
            first_no = fib_no;

            if( fib_no%mod_no == 0)
            {
                if(((first_no%mod_no + second_no%mod_no)%mod_no) == 1)
                {
                    ind  = i;
                    flag = true;
                    System.out.println("i : " + i);
                    break;
                }
                else
                {
                    i++;
                }    
            }
            else
            {
                i++;
            }
        } 

        return ind;
    }

    public static void main(String[] args) 
    {
        int i=0;
        Scanner num = new Scanner(System.in);
        System.out.println("Enter Mod No : ");
        m = num.nextLong();

        ind = find_index(m);
        System.out.println(ind);
    }
}