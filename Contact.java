package finalprojectmain;

public class Contact extends AddressBook{
    private String name;
    private int age;
    private int number;
    private int mon;
    private int day;
    public Contact(String name, int age, int number, int mon, int day)
    {
        this.name = name;
        this.age = age;
        this.number = number;
        this.mon = mon;
        this.day = day;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name+","+age+","+number+","+mon+","+day;
    }
    public void printContact(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + number);
        System.out.println("Month: " + mon + " day: " + day);
    }
}
