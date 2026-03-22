package week3.day4.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseCollection {
public static void main(String[] args) {
    String[] companies = {"HCL", "Wipro", "Aspire Systems", "CTS"};
    List<String> companyList = new ArrayList<>(Arrays.asList(companies));
    System.out.print("List of companies before sorting: ");
    for (String company : companyList) {
        System.out.print(company + "  ");
    } 
    Collections.sort(companyList);
    System.out.println("\nList of companies after sorting: " + companyList);
    System.out.print("Reverse List: ");
    for(int i= (companyList.size() - 1); i>=0; i--)
    {
        System.out.print(companyList.get(i) + "  ");
    }
}
}
