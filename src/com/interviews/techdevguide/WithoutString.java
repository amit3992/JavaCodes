package com.interviews.techdevguide;

public class WithoutString {

    public String withoutString(String base, String remove) {

        if(base == null || remove == null) {
            return base;
        }

        if(base.indexOf(remove) < 0) {
            return base;
        }

        boolean flag = true;
        int count = 0;
        while(base.indexOf(remove) != -1 && flag) {
            int index = base.indexOf(remove);
            System.out.println(index);

            if(count++ == 3) {
                flag = false;
            }

        }

        return base;
    }

    public static void main(String [] args) {

        String base = "Hello there";
        String remove = "e";

        WithoutString ws = new WithoutString();


    }
}
