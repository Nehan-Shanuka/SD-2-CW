import java.util.Objects;
import java.util.Scanner;

public class Ticket {
    private String row;
    private String seat;
    private int price;

    Person Person;

    public Ticket(String option) {

        if (Objects.equals(option, "no")) {
            Person = new Person();
        }

        Scanner input = new Scanner(System.in);

        System.out.format("%-23s","Enter the row number");
        System.out.print(":   ");
        row = input.nextLine();

        System.out.format("%-23s","Enter the seat number");
        System.out.print(":   ");
        seat = input.nextLine();
    }

    public void print(String name, String surname, String email, int price){

        System.out.println("     ****** Ticket ******     ");

        System.out.format("%-25s","Name of the person");
        System.out.println(":  " + name);

        System.out.format("%-25s","Surname of the person");
        System.out.println(":  " + surname);

        System.out.format("%-25s","Email of the person");
        System.out.println(":  " + email);

        System.out.format("%-25s","The reserved row number");
        System.out.println(":  " + this.row);

        System.out.format("%-25s","The reserved seat number");
        System.out.println(":  " + this.seat);

        System.out.format("%-25s","Your ticket price");
        System.out.println(":  Rs." + price);
    }
    public int price() {

        this.price = 0;
        int seat_int = Integer.parseInt(this.seat);

        if (Objects.equals(row, "1")){
            if (seat_int > 3 && seat_int < 10){
                this.price = 600;
            }
            else if ((seat_int >= 1 && seat_int <= 3) || (seat_int >= 10 && seat_int <= 12)) {
                this.price = 500;
            }
        }
        if (Objects.equals(row, "2")){
            if (seat_int > 4 && seat_int < 12){
                this.price = 900;
            }
            else if ((seat_int >= 1 && seat_int <= 4) || (seat_int >= 12 && seat_int <= 16)) {
                this.price = 700;
            }
        }
        if (Objects.equals(row, "3")){
            if (seat_int > 5 && seat_int < 15){
                this.price = 1000;
            }
            else if ((seat_int >= 1 && seat_int <= 5) || (seat_int >= 15 && seat_int <= 20)) {
                this.price = 800;
            }
        }
        return this.price;
    }

    public String getRow() {
        return row;
    }

    public String getSeat() {
        return seat;
    }
}
