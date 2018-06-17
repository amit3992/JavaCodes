package com.bit;

public class NextPowerOf2 {

    public int nextPowerOf2(int num) {

        if(num == 0) {
            return 1;
        }

        //System.out.println("Num -> " + num);
        //System.out.println("Num - 1 -> " + (num - 1));
        //System.out.println("Num & (Num - 1) -> " + (num & (num - 1)));
        if(num > 0 && (num & (num - 1)) == 0) {
            return num;
        }

        //System.out.println("Entering while loop");
        while((num & (num - 1)) > 0) {

          //  System.out.println("Num -> " + num);
          //  System.out.println("Num - 1 -> " + (num - 1));
          //  System.out.println("Num & (Num - 1) -> " + (num & (num - 1)));

            num = num & (num - 1);
        }

        // System.out.println("Returning num  << 1  -> " + (num << 1));
        return num << 1;
    }

    public static void main(String [] args) {

        NextPowerOf2 np2 = new NextPowerOf2();
        System.out.println(np2.nextPowerOf2(13));
    }
}
