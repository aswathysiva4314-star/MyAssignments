package week6.day2.constructor;

public class Car extends Vechicle {

    public Car(String num){
    super(num); // super --> new ParentClass() --> Parent class/object level reference
    System.out.println("This method is executed from child class Constructor");
    }
    @Override
    public void brandName(String bname){
        super.brandName("Hyundai");
        System.out.println("Brand Name from child class is "+bname);
    }
    public Car()
    {
            super();
    }

    public static void main(String[] args) {
        new Car();
        Car cr;
        cr = new Car("TN 12 AK 0007");
        cr.brandName("AUDI");
    
    }

}