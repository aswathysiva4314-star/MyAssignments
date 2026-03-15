package week2.day2;

public class ReverseString {
    public static void main(String[] args) {
        String companyName= "TestLeaf";
        //converting given string to character array
       char[] charArray = companyName.toCharArray();

       System.out.print("Reverse String: ");
        for(int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i]);
        }
    }
}
