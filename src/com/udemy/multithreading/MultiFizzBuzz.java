package com.udemy.multithreading;

class FizzBuzzThread extends Thread {

    private static Object lock = new Object();
    protected static int current = 1;
    private int max;

    /* Operations */
    private boolean div3 = false;
    private boolean div5 = false;
    private String toPrint;

    /* Constructor */
    FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint) {
        this.div3 = div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void print() {
        System.out.println(this.toPrint);
    }

    public void run() {

        while(true) {
            synchronized (lock) {
                if(current > max) {
                    return;
                }

                if (((current % 3 == 0) == div3) && ((current % 5 == 0) == div5)) {
                    print();
                    current++;
                }
            }
        }
    }

}


class NumberThread extends FizzBuzzThread {

    public NumberThread(boolean div3, boolean div5, int max) {
        super(div3, div5, max, null);
    }

    public void print() {
        System.out.println(current);
    }
}
public class MultiFizzBuzz {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n = 200;
        Thread [] threads = {new FizzBuzzThread(true, true, n, "FizzBuzz"),
                                new FizzBuzzThread(true, false, n, "Fizz"),
                                new FizzBuzzThread(false, true, n, "Buzz"),
                                new NumberThread(false, false, n)
                        };

        for(Thread t : threads) {
            t.start();
        }


    }
}
