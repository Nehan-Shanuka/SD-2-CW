import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java. util. Scanner;
class Theater {
    public static void main(String[] args) {
        System.out.println("Welcome to the New Theater");

        //initializing row_1, row_2, row_3 String arrays
        String[] row_1 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_2 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_3 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};

        //initializing an arraylist called tickets for store the ticket data(task 12)
        ArrayList<ArrayList<String>> tickets = new ArrayList<ArrayList<String>>();
        //https://www.geeksforgeeks.org/multidimensional-collections-in-java/

        //to use in the while argument and takes "option" value
        int option_check;

        //to take how many persons took the tickets and add person information to the tickets arraylist
        int person_count = 0;

        do {

            //print set of "-" in a row
            String sep_line = new String(new char[48]).replace('\0', '-');
            //https://kodejava.org/how-do-i-align-string-print-out-in-left-right-center-alignment/
            System.out.println(sep_line);

            //print the menu
            System.out.println("Please select an option :");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort ticket by price");
            System.out.format("%13s","0) Quit");

            System.out.println();
            System.out.println(sep_line);

            Scanner input = new Scanner(System.in);

            System.out.print("Enter option : ");
            int option = input.nextInt();

            System.out.println();

            //assigning the value of option (option_check is for check the condition for do-while loop)
            option_check = option;

            if (option == 1) {
                buy_ticket(row_1, row_2, row_3, tickets, person_count);
                person_count++;
            }
            if (option == 2) {
                print_seating_area(row_1, row_2, row_3);
            }
            if (option == 3) {
                //return the value of person_count
                person_count = cancel_ticket(row_1, row_2, row_3, tickets, person_count);
            }
            if (option == 4) {
                show_available(row_1, row_2, row_3);
            }
            if (option == 5) {
                save(row_1, row_2, row_3);
            }
            if (option == 6) {
                load(row_1, row_2, row_3);
            }
        }
        while (option_check != 0);
    }
    public static void buy_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<ArrayList<String>> tickets, int person_count){

        //call the Person class
        Person myPerson = new Person();

        System.out.println();

        //call the Ticket class
        Ticket myTicket = new Ticket();

        //assigning row and seat values in Ticket class to new variables
        int rows = Integer.parseInt(myTicket.row);
        int seats = Integer.parseInt(myTicket.seat);

        //call the print() method in Ticket class
        Ticket.print(myTicket.row, myTicket.seat, myPerson.name, myPerson.surname, myPerson.email);

        //call the price() method in Ticket class
        Ticket.price(myTicket.row, myTicket.seat);

        //one space allocated for 0 index
        tickets.add(new ArrayList<String>());
        //https://www.geeksforgeeks.org/multidimensional-collections-in-java/

        //add following attributes into the tickets arraylist
        tickets.get(person_count).add(0, myPerson.name);
        tickets.get(person_count).add(1, myPerson.surname);
        tickets.get(person_count).add(2, myPerson.email);
        tickets.get(person_count).add(3, myTicket.row);
        tickets.get(person_count).add(4, myTicket.seat);

        System.out.println();

        for (ArrayList<String> ticket : tickets) {
            System.out.print(ticket + ", ");
        }
        System.out.println();
        System.out.println(tickets.size());

        //checking the availability of seat that currant customer prefer
        if (rows == 1){
            if ((seats>=1 && seats <=12)){
                if (Objects.equals(row_1[seats - 1], "1")){
                    System.out.println("Sorry, the seat has occupied already, You can try another seat please!");
                }
                else {
                    row_1[seats - 1] = "1";
                }
            }
            else{
                System.out.println("Sorry, The seat number you chosen is not exists in 1rd row. Please Try with valid seat number");
            }
        }
        else if (rows == 2){
            if ((seats>=1 && seats <=16)){
                if (Objects.equals(row_2[seats - 1], "1")){
                    System.out.println("Sorry, the seat has occupied already, You can try another seat please!");
                }
                else {
                    row_2[seats - 1] = "1";
                }
            }
            else{
                System.out.println("Sorry, The seat number you chosen is not exists in 2rd row. Please Try with valid seat number");
            }
        } else if (rows == 3){
            if ((seats>=1 && seats <=20)){
                if (Objects.equals(row_3[seats - 1], "1")){
                    System.out.println("Sorry, the seat has occupied already, You can try another seat please!");
                }
                else {
                    row_3[seats - 1] = "1";
                }
            }
            else{
                System.out.println("Sorry, The seat number you chosen is not exists in 3rd row. Please Try with valid seat number");
            }
        }
        else{
            System.out.println("Sorry, The row number you chosen is not exists. Please Try with valid seat number");
        }
    }
    public static void print_seating_area(String[] row_1, String[] row_2, String[] row_3){
        System.out.format("%10s"," ");
        System.out.println("***********");
        System.out.format("%10s"," ");
        System.out.println("*  STAGE  *");
        System.out.format("%10s"," ");
        System.out.println("***********");

        // to print a space to shows the path between left and right set of seats in the same row.
        int count = 1;

        System.out.format("%9s"," ");

        for (String i: row_1){
            if (!Objects.equals(i,"1")){ // when (i != "1") was the argument it always printed else part.
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
            if (count == 6){
                System.out.print(" ");
            }
            count++;
        }

        count = 1;
        System.out.println();

        System.out.format("%7s"," ");

        for (String i: row_2){
            if (!Objects.equals(i,"1")){
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
            if (count == 8){
                System.out.print(" ");
            }
            count++;
        }

        count = 1;
        System.out.println();

        System.out.format("%5s"," ");

        for (String i: row_3){
            if (!Objects.equals(i,"1")){
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
            if (count == 10){
                System.out.print(" ");
            }
            count++;
        }

        System.out.println();
    }
    public static int cancel_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<ArrayList<String>> tickets, int person_count){

        Scanner input_list = new Scanner(System.in);

        System.out.print("Enter your email : ");
        String email_input = input_list.nextLine();

        //initializing rows and seats variables to hold row number and seat number from the tickets arraylist.
        int rows = 0;
        int seats = 0;
        String pcv;

        //checking the email that take from the customer also in the tickets  arraylist.
        for (int i = 0; i < tickets.toArray().length; i++){
            if (Objects.equals(tickets.get(i).get(2), email_input)){
                //assigning values to rows and seats
                rows = Integer.parseInt(tickets.get(i).get(3));
                seats = Integer.parseInt(tickets.get(i).get(4));

                tickets.remove(i);
                System.out.println("Seats were reserved under '" + email_input + "' canceled successfully.");
                //decrement person_count by one
                person_count--;
                //tickets.add(new ArrayList<String>());
            }
        }

        /*for (ArrayList<String> ticket : tickets) {
            System.out.print(ticket + ", ");
        }*/
        System.out.println();

        if (rows == 0){
            System.out.println("Sorry, There is no reserved seat under '" + email_input + "' email holder.");
        }

        //changing the row_1, row_2 and row_3 after cancellation
        if (rows == 1){
            if ((seats>=1 && seats <=12)){
                if (Objects.equals(row_1[seats - 1], "1")){
                    row_1[seats-1] = "0";
                }
                else {
                    System.out.println("Sorry! the selected seat has not occupied, Try again");
                }
            }
            else{
                System.out.println("Sorry! wrong selection, Try again");
            }
        }
        else if (rows == 2){
            if ((seats>=1 && seats <=16)){
                if (Objects.equals(row_2[seats - 1], "1")){
                    row_2[seats-1] = "0";
                }
                else {
                    System.out.println("Sorry! the selected seat has not occupied, Try again");
                }
            }
            else{
                System.out.println("Sorry! wrong selection, Try again");
            }
        } else if (rows == 3){
            if ((seats>=1 && seats <=20)){
                if (Objects.equals(row_3[seats - 1], "1")){
                    row_3[seats-1] = "0";
                }
                else {
                    System.out.println("Sorry! the selected seat has not occupied, Try again");
                }
            }
            else {
                System.out.println("Sorry! wrong selection, Try again");
            }
        }
        else{
            System.out.println("Sorry! wrong selection Try again");
        }
        return person_count;
    }
    public static void show_available(String[] row_1, String[] row_2, String[] row_3){
        System.out.print("Seats available in row 1: ");

        //initializing an arraylist to store currently available seat numbers in row_1
        ArrayList<String> array_row1 = new ArrayList<String>();
        for (int i = 1; i < 13; i++) {
            if (!Objects.equals(row_1[i -1], "1")) {
                String k = String.valueOf(i);
                array_row1.add(k);
            }
        }
        //print the array element with separating by a comma.
        String joined_row1 = String.join(", ", array_row1);
        System.out.println(joined_row1);
        //https://stackoverflow.com/questions/18279622/print-out-elements-from-an-array-with-a-comma-between-the-elements

        System.out.print("Seats available in row 2: ");

        //initializing an arraylist to store currently available seat numbers in row_2
        ArrayList<String> array_row2 = new ArrayList<String>();
        for (int i = 1; i < 17; i++) {
            if (!Objects.equals(row_2[i -1], "1")) {
                String k = String.valueOf(i);
                array_row2.add(k);
            }
        }
        String joined_row2 = String.join(", ", array_row2);
        System.out.println(joined_row2);

        System.out.print("Seats available in row 3: ");

        //initializing an arraylist to store currently available seat numbers in row_3
        ArrayList<String> array_row3 = new ArrayList<String>();
        for (int i = 1; i < 21; i++) {
            if (!Objects.equals(row_3[i -1], "1")) {
                String k = String.valueOf(i);
                array_row3.add(k);
            }
        }
        String joined_row3 = String.join(", ", array_row3);
        System.out.println(joined_row3);
    }
    public static void save(String[] row_1, String[] row_2, String[] row_3) {
        try {
            FileWriter myWriter = new FileWriter("seatinfo.txt");
            //to write a new line
            String newline = System.getProperty("line.separator");
            //https://www.geeksforgeeks.org/java-program-to-print-a-new-line-in-string/

            for (int i = 0; i < row_1.length; i++) {
                myWriter.write((row_1[i]));
            }
            myWriter.write(newline);

            for (int i = 0; i < row_2.length; i++) {
                myWriter.write((row_2[i]));
            }
            myWriter.write(newline);

            for (int i = 0; i < row_3.length; i++) {
                myWriter.write((row_3[i]));
            }
            myWriter.close();

        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static void load(String[] row_1, String[] row_2, String[] row_3) {
        /*String[] row_4 = new String[12];
        String[] row_5 = new String[16];
        String[] row_6 = new String[20];*/

        try {
            File fileObj = new File("seatinfo.txt");
            Scanner fileReader = new Scanner(fileObj);

            //when reading the "seatinfo.txt" line by line it takes what line is it
            int while_count = 1;

            while (fileReader.hasNextLine()) {
                if (while_count == 1){
                    String saved_line1 = fileReader.nextLine();
                    //reassigning row_1 values according to previously saved
                    for (int i = 0; i < saved_line1.length(); i++){
                        row_1[i] = String.valueOf(saved_line1.charAt(i));
                    }
                }
                if (while_count == 2){
                    String saved_line2 = fileReader.nextLine();
                    for (int i = 0; i < saved_line2.length(); i++){
                        row_2[i] = String.valueOf(saved_line2.charAt(i));
                    }
                }
                if (while_count == 3){
                    String saved_line3 = fileReader.nextLine();
                    for (int i = 0; i < saved_line3.length(); i++){
                        row_3[i] = String.valueOf(saved_line3.charAt(i));
                    }
                }
                while_count++;
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
