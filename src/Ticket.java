import java.util.Scanner;

public class Ticket {
    private int row;
    private int seat;
    private int price;

    Person Person;

    public Ticket(String option, String name, String surname, String email) {

        Person = new Person(option, name, surname, email);

        Scanner input = new Scanner(System.in);

        System.out.format("%-23s","Enter the row number");
        System.out.print(":   ");
        row = input.nextInt();

        System.out.format("%-23s","Enter the seat number");
        System.out.print(":   ");
        seat = input.nextInt();

        this.price = price();
    }

    public void print(String name, String surname, String email, int price){

        System.out.println("      ****** Ticket ******      ");

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

        if (row == 1){
            if (seat > 3 && seat < 10){
                this.price = 600;
            }
            else if ((seat >= 1 && seat <= 3) || (seat >= 10 && seat <= 12)) {
                this.price = 500;
            }
        }
        if (row == 2){
            if (seat > 4 && seat < 12){
                this.price = 900;
            }
            else if ((seat >= 1 && seat <= 4) || (seat >= 12 && seat <= 16)) {
                this.price = 700;
            }
        }
        if (row == 3){
            if (seat > 5 && seat < 15){
                this.price = 1000;
            }
            else if ((seat >= 1 && seat <= 5) || (seat >= 15 && seat <= 20)) {
                this.price = 800;
            }
        }
        return this.price;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }
}
