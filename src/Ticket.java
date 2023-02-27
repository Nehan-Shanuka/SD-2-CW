import java.util.Objects;
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
    public static int price(String row, String seat) {
        int price = 0;
        int seat_int = Integer.parseInt(seat);

        if (Objects.equals(row, "1")){
            if (seat_int > 3 && seat_int < 10){
                price = 600;
            }
            else {
                price = 500;
            }
        }
        if (Objects.equals(row, "2")){
            if (seat_int > 4 && seat_int < 12){
                price = 900;
            }
            else {
                price = 700;
            }
        }
        if (Objects.equals(row, "3")){
            if (seat_int > 5 && seat_int < 15){
                price = 1000;
            }
            else {
                price = 800;
            }
        }
        System.out.format("%-23s","Your ticket price is");
        System.out.println(":  Rs." + price);
        return price;
    }
}
