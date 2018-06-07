package leetCode.Arrays;

public class SortColors {

    public int [] sortColors (int [] colors) {
        if(colors == null || colors.length == 0) {
            return colors;
        }

        int low = 0;
        int high = colors.length - 1;
        int mid = 0;

        while(mid <= high) {

            switch(colors[mid]) {

                case 0:
                    swap(colors, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(colors, mid, high);
                    high--;
                    break;

            }
        }

        return colors;
    }

    private void swap(int [] colors, int a, int b) {
        int temp = colors[a];
        colors[a] = colors[b];
        colors[b] = temp;
    }

    public static void main(String [] args) {

        int [] colors = {0, 1, 2, 0, 1 ,2, 0};

        SortColors sc = new SortColors();
        colors = sc.sortColors(colors);

        for(Integer i : colors) {
            System.out.print(i + " ");
        }
    }


}
