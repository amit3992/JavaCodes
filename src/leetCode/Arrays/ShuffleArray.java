package leetCode.Arrays;

import java.util.Arrays;

public class ShuffleArray {

    int [] input;

    ShuffleArray(int [] input) {
        this.input = input;
    }

    public int [] reset() {
        return this.input;
    }

    public int [] shuffle() {

        int [] random = new int[this.input.length];

        for(int i = 0; i < this.input.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            random[i] = random[r];
            random[r] = this.input[i];
        }

        return random;

    }

    public static void main(String [] args) {

        int [] input = {1, 2, 3, 4};

        ShuffleArray sh = new ShuffleArray(input);
        int [] sh1 = sh.shuffle();

        System.out.println("Shuffle #1 -> " + Arrays.toString(sh1));
        int [] res = sh.reset();
        System.out.println("Reset -> " + Arrays.toString(res));

        int [] sh2 = sh.shuffle();
        System.out.println("Shuffle #2 -> " + Arrays.toString(sh2));
    }
}
