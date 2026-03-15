package week2.day2;

import java.util.Arrays;

public class FindDups {
    public static void main(String[] args) {
        int[] a = {2, 5, 7, 7, 5, 9, 2, 3};
        //Sort the array
        Arrays.sort(a);
        System.out.println("Sorted Array: ");
        for(int i =0; i< a.length-1; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nDuplicate numbers: ");
        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] == a[i+1])
            {
                System.out.println(a[i+1]);
            }
        }

    }

}
