package week3.day4.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SecondLargestNum {

    public static void main(String[] args) {
        // 1. Declare the array as per requirements
        Integer[] numbersArray = { 3, 2, 11, 4, 6, 7 };
        // 2. Convert Array to List
        List<Integer> numberList = new ArrayList<>(Arrays.asList(numbersArray));
        //3.Before sorting
        System.out.println("Before sorting: " + numberList);
        // 4. Arrange the collection in ascending order
        Collections.sort(numberList);
        // 5. Find the size of the list
        int size = numberList.size();
        // 6. Use the get method to pick the 2nd element from the last
        Integer secondLargest = numberList.get(size - 2);
        // 7.Print the result
        System.out.println("The sorted list is: " + numberList);
        System.out.println("The second largest number is: " + secondLargest);

        // List<Integer> nums = new ArrayList<>();
        // nums.add(3);
        // nums.add(2);
        // nums.add(11);
        // nums.add(4);
        // nums.add(6);
        // nums.add(7);
        // // System.out.println(nums);
        // System.out.println("Before sorting");
        // for (Integer num : nums) {
        // System.out.println(num);
        // }
        // Collections.sort(nums);
        // System.out.println("After sorting: " + nums);
        // int secondLargest = nums.get((nums.size()) - 2);
        // System.out.println("Second Largest Number: " + secondLargest);

    }
}
