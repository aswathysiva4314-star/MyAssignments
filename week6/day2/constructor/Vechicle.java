package week6.day2.constructor;

public class Vechicle {

    public Vechicle(String numberPlate){
        System.out.println("VECHILE NUMBER FROM THE PARENT CLASS is :"+ numberPlate);
    }

    public void brandName(String bname){
        System.out.println("Brand Name from Parent class is :"+bname);
    }

  public Vechicle()
  {
    System.out.println("Parent Default Constructor");
  }

}

