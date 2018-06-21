package com.interviews.techdevguide;

public class CanBalance {

    public boolean canBalance(int[] nums) {
        int first = 0;
        int second = 0;

        for(int i = 0; i < nums.length; i++)
            second += nums[i];

        for(int i = 0; i <= nums.length - 2; i++) {
            first += nums[i];
            second -= nums[i];

            if(first == second)
                return true;
        }

        return false;
    }

    public static void main(String [] args) {

        int [] input = {1,1,1,2,1};
        CanBalance cb = new CanBalance();

        System.out.println("Can balance -> " + cb.canBalance(input));

    }

}
