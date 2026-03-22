package week3.day4.assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingElement {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 10, 6, 8);
        System.out.println("Before sorting: " + arr);
        //sort the array
        Collections.sort(arr);
        System.out.println("Sorted array: " + arr);

    //Find missing element
    System.out.print("Missing Elements: ");
    for(int i = 0; i < arr.size() - 1; i++)
    {
        int current = arr.get(i);
        int next = arr.get(i + 1);
        if((current + 1) != next)
        {
            for(int j = current + 1; j < next; j++)
            {
                System.out.print( j + " ");
            }
        }
    }
        
    }
}
