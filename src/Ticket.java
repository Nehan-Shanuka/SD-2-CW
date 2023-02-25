import java.util.Scanner;

public class Ticket {
    public String row;
    public String seat;
    int price;

    public Ticket() {
        Scanner input = new Scanner(System.in);
        System.out.format("%-23s","Enter the row number");
        System.out.print(":  ");
        row = input.nextLine();
        System.out.format("%-23s","Enter the seat number");
        System.out.print(":  ");
        seat = input.nextLine();
    }

    /*public static void main() {
        Person myPerson = new Person();
        Ticket myTicket = new Ticket();
        print(myTicket.row, myTicket.seat, myPerson.name, myPerson.surname, myPerson.email);
    }*/
    public static void print(String row, String seat, String name, String surname, String email){
        System.out.println();

        System.out.format("%-25s","Name of the person");
        System.out.println(":  " + name);

        System.out.format("%-25s","Surname of the person");
        System.out.println(":  " + surname);

        System.out.format("%-25s","Email of the person");
        System.out.println(":  " + email);

        System.out.format("%-25s","The reserved row number");
        System.out.println(":  " + row);

        System.out.format("%-25s","The reserved seat number");
        System.out.println(":  " + seat);
    }
}
