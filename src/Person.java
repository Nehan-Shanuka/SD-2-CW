import java.util.Scanner;

public class Person {
    String name;
    String surname;
    String email;

    public Person (){
        Scanner input = new Scanner(System.in);

        System.out.format("%-23s","Enter your name");
        System.out.print(":   ");
        name = input.nextLine();

        System.out.format("%-23s","Enter your surname");
        System.out.print(":   ");
        surname = input.nextLine();

        System.out.format("%-23s","Enter your email");
        System.out.print(":   ");
        email = input.nextLine();
    }
}
