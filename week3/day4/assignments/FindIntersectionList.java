package week3.day4.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersectionList {
    public static void main(String[] args) {

        // Declare array1
        Integer[] arr1 = { 3, 2, 11, 4, 6, 7 };

        // Convert array1 to List
        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));

        // declare array2
        int[] arr2 = { 1, 2, 8, 4, 9, 7 };
        // conver array2 to list
        List<Integer> list2 = new ArrayList<>();
        for (int num : arr2) {
            list2.add(num);

        }
        // Find intersection
        System.out.println("Intersection elements are: ");
        for (int i = 0; i < list1.size(); i++) {
            if (list2.contains(list1.get(i))) {
                System.out.print(list1.get(i) + " ");
            }
        }

    }

}
