import java.io.*;
import java.util.*;

class Theater {
    public static void main(String[] args) {

        System.out.println();
        System.out.format("%42s","Welcome to the New Theater");
        System.out.println();

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
            String sep_line = new String(new char[60]).replace('\0', '-');
            //https://kodejava.org/how-do-i-align-string-print-out-in-left-right-center-alignment/
            System.out.println(sep_line);

            System.out.println();

            //print the menu
            System.out.println("Please select an option :");
            System.out.println();
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort ticket by price");
            System.out.format("%10s","0) Quit");

            System.out.println();
            System.out.println();
            System.out.println(sep_line);
            System.out.println();

            int option = 9;

            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter option :  ");
                option = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Sorry! Your input can not readable. Please Try again.");
            }

            System.out.println();
            System.out.println(sep_line);

            if (!(option >= 0 && option <= 8)) {
                System.out.println();
                System.out.println("Sorry! The input you enterd is wrong. Please Try again.");
            }

            //assigning the value of option (option_check is for check the condition for do-while loop)
            option_check = option;

            if (option == 1) {
                person_count = buy_ticket(row_1, row_2, row_3, tickets, person_count);
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
            if (option == 7){
                show_tickets_info(tickets);
            }
            if (option == 8){
                sort_tickets(tickets);
            }
        }
        while (option_check != 0);
    }

    public static int buy_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<ArrayList<String>> tickets, int person_count){

        System.out.println();
        System.out.format("%39s","Purchace the Ticket");
        System.out.println();
        System.out.println();

        //call the Person class
        Person myPerson = new Person();

        //one space allocated for 0 index
        //tickets.add(new ArrayList<String>());
        //https://www.geeksforgeeks.org/multidimensional-collections-in-java/

        //assigning row and seat values in Ticket class to new variables
        int rows = 0;
        int seats = 0;
        int price = 0;
        String more_ticket = "yes";

        while (Objects.equals(more_ticket, "yes")) {

            //call the Ticket class
            Ticket myTicket = new Ticket();

            if (!(myPerson.name.isEmpty() || myPerson.surname.isEmpty() || myPerson.email.isEmpty())) {
                if (!(myTicket.row.isEmpty() || myTicket.seat.isEmpty())) {

                    //while (rows == 0) {
                        try {
                            rows = Integer.parseInt(myTicket.row);
                            seats = Integer.parseInt(myTicket.seat);

                            tickets.add(new ArrayList<String>());

                            System.out.println();

                            //call the price() method in Ticket class
                            price = Ticket.price(myTicket.row, myTicket.seat);

                        } catch (NumberFormatException e) {
                            System.out.println();
                            System.out.println("Sorry! Your row/seat selection can not readable. Please Check and Try Again");
                            continue;
                        }
                    //}

                    if (rows != 0 || seats != 0) {

                        //checking the availability of seat that currant customer prefer
                        if (rows == 1) {
                            if ((seats >= 1 && seats <= 12)) {
                                if (Objects.equals(row_1[seats - 1], "1")) {
                                    tickets.remove(person_count);
                                    System.out.println("Sorry! The seat has been reserved already. Please Try another seat.");
                                    System.out.println("Please make sure that you have checked what seats are Available now through our system.");
                                    System.out.println();
                                } else {
                                    row_1[seats - 1] = "1";
                                    tickets.get(person_count).add(0, myPerson.name);
                                    tickets.get(person_count).add(1, myPerson.surname);
                                    tickets.get(person_count).add(2, myPerson.email);
                                    tickets.get(person_count).add(3, myTicket.row);
                                    tickets.get(person_count).add(4, myTicket.seat);
                                    tickets.get(person_count).add(5, String.valueOf(price));

                                    person_count++;
                                }
                            } else {
                                tickets.remove(person_count);
                                System.out.println("Sorry! The seat number you chose does not exist in the 1rd row. Please Try with a valid seat number.");
                            }
                        } else if (rows == 2) {
                            if ((seats >= 1 && seats <= 16)) {
                                if (Objects.equals(row_2[seats - 1], "1")) {
                                    tickets.remove(person_count);
                                    System.out.println("Sorry! The seat has been reserved already. Please Try another seat.");
                                    System.out.println("Please make sure that you have checked what seats are Available now through our system.");
                                } else {
                                    row_2[seats - 1] = "1";

                                    tickets.get(person_count).add(0, myPerson.name);
                                    tickets.get(person_count).add(1, myPerson.surname);
                                    tickets.get(person_count).add(2, myPerson.email);
                                    tickets.get(person_count).add(3, myTicket.row);
                                    tickets.get(person_count).add(4, myTicket.seat);
                                    tickets.get(person_count).add(5, String.valueOf(price));

                                    person_count++;
                                }
                            } else {
                                tickets.remove(person_count);
                                System.out.println("Sorry! The seat number you chose does not exist in the 2rd row. Please Try with a valid seat number.");
                            }
                        } else if (rows == 3) {
                            if ((seats >= 1 && seats <= 20)) {
                                if (Objects.equals(row_3[seats - 1], "1")) {
                                    tickets.remove(person_count);
                                    System.out.println("Sorry! The seat has been reserved already. Please Try another seat.");
                                    System.out.println("Please make sure that you have checked what seats are Available now through our system.");
                                } else {
                                    row_3[seats - 1] = "1";

                                    tickets.get(person_count).add(0, myPerson.name);
                                    tickets.get(person_count).add(1, myPerson.surname);
                                    tickets.get(person_count).add(2, myPerson.email);
                                    tickets.get(person_count).add(3, myTicket.row);
                                    tickets.get(person_count).add(4, myTicket.seat);
                                    tickets.get(person_count).add(5, String.valueOf(price));

                                    person_count++;
                                }
                            } else {
                                tickets.remove(person_count);
                                System.out.println("Sorry! The seat number you chose does not exist in the 3rd row. Please Try with a valid seat number.");
                            }
                        } else {
                            tickets.remove(person_count);
                            System.out.println("Sorry! The row number you chose does not exists. Please Try with valid seat number");
                        }
                    }
                    System.out.println();

                    do {
                        try {
                            Scanner input = new Scanner(System.in);
                            System.out.print("Do you wish to purchase more than one ticket? (yes|no) : ");
                            more_ticket = input.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Sorry! Input can not readable. Please Try Again.");
                            System.out.println();
                        }
                        if (!(Objects.equals(more_ticket, "yes") || Objects.equals(more_ticket, "no"))) {
                            System.out.println();
                            System.out.println("Sorry! Make sure to enter the valid response format shown there. Please Try Again.");
                            System.out.println();
                        }
                    } while (!(Objects.equals(more_ticket, "yes") || Objects.equals(more_ticket, "no")));

                    System.out.println();

                } else {
                    System.out.println("Sorry! Your seat number information are not enough to processed forward. Try again.");
                }
            } else {
                System.out.println("Sorry! Your credentials are not enough to processed forward. Try again.");
            }

            System.out.println();
        }
        return person_count;
    }
    public static void print_seating_area(String[] row_1, String[] row_2, String[] row_3){

        System.out.println();
        System.out.format("%58s","Choose the Best&Calm Place Available and Enjoy the Movie!");
        System.out.println();
        System.out.println();

        System.out.format("%23s"," ");
        System.out.println("***********");
        System.out.format("%23s"," ");
        System.out.println("*  STAGE  *");
        System.out.format("%23s"," ");
        System.out.println("***********");

        // to print a space to shows the path between left and right set of seats in the same row.
        int count = 1;

        System.out.format("%22s"," ");

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

        System.out.format("%20s"," ");

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

        System.out.format("%18s"," ");

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

        System.out.println();
        System.out.format("%51s","Cancel Here The Tickets Your Purchased Earlier");
        System.out.println();
        System.out.println();

        Scanner input_list_str = new Scanner(System.in);
        Scanner input_list_int = new Scanner(System.in);

        System.out.print("Enter your email : ");
        String email_input = input_list_str.nextLine();

        //initializing rows and seats variables to hold row number and seat number from the tickets arraylist.
        int rows = 0;
        int seats;

        System.out.println("The seats reserved under '" + email_input + "' :");
        System.out.println();
        //checking the email that take from the customer also in the tickets  arraylist.
        for (int i = tickets.size(); i > 0; i--){
            if (Objects.equals(tickets.get(i-1).get(2), email_input)){
                //assigning values to rows and seats
                rows = Integer.parseInt(tickets.get(i-1).get(3));
                seats = Integer.parseInt(tickets.get(i-1).get(4));

                System.out.format("%20s","[ row:" + rows + " | seat:" + seats + " ] ");
                System.out.println();
            }
        }

        System.out.println();

        if (rows == 0) {
            System.out.println("Sorry! There is no reserved seat under '" + email_input + "' email holder.");
        }
        else {
            //to ask user wants to cancel all tickets that user reserved
            String all_cancel_opt = "none";

            try {
                System.out.print("Do you want to cancel all tickets you reserved? (yes|no) : ");
                all_cancel_opt = input_list_str.nextLine();
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Sorry! Input can not readable. Please Try Again.");
                System.out.println();
            }

            System.out.println();

            //initialize and assign value to get user opinion to cancel another ticket
            String cancel_loop_opt = "yes";

            if (Objects.equals(all_cancel_opt, "no")) {
                System.out.println("**Please enter the seat you want to cancel**");
                do {
                    System.out.println();

                    System.out.print("Row number  : ");
                    int row = input_list_int.nextInt();
                    System.out.print("Seat number : ");
                    int seat = input_list_int.nextInt();

                    System.out.println();

                    //to validate and show a massage to say the cancel task done properly.
                    int seat_validity = 0;
                    for (int i = 0; i < tickets.size(); i++) {
                        if (Objects.equals(tickets.get(i).get(2), email_input)) {
                            if (Objects.equals(tickets.get(i).get(3), String.valueOf(row)) && Objects.equals(tickets.get(i).get(4), String.valueOf(seat))) {
                                tickets.remove(i);
                                //decrement person_count by one
                                person_count--;
                                seat_validity = 1;
                            }
                        }
                    }

                    if (seat_validity != 0) {
                        System.out.println("The row:" +row+ " seat:" +seat+ " numbered seat canceled successfully from '" +email_input+ "'.");
                        System.out.println();
                        if (row == 1) {
                            row_1[seat-1] = "0";
                        }
                        if (row == 2) {
                            row_2[seat-1] = "0";
                        }
                        if (row == 3) {
                            row_3[seat-1] = "0";
                        }
                    } else {
                        System.out.println("Sorry! The seat you set to cancel is not for yours. Please check what are your seats and Try again.");
                        System.out.println();
                    }

                    do {
                        try {
                            System.out.print("Do you want to cancel another? (yes|no) :  ");
                            cancel_loop_opt = input_list_str.nextLine();
                            System.out.println();
                        } catch (InputMismatchException e) {
                            System.out.println("Sorry! Input can not readable. Please Try Again.");
                            System.out.println();
                        }
                        if (!(Objects.equals(cancel_loop_opt, "yes") || Objects.equals(cancel_loop_opt, "no"))) {
                            System.out.println();
                            System.out.println("Sorry! Make sure to enter the valid response format shown there. Please Try Again.");
                            System.out.println();
                        }
                    } while (!(Objects.equals(cancel_loop_opt, "yes") || Objects.equals(cancel_loop_opt, "no")));

                } while (Objects.equals(cancel_loop_opt, "yes"));

            } else if (Objects.equals(all_cancel_opt, "yes")) {
                for (int i = tickets.size(); i > 0; i--) {
                    if (Objects.equals(tickets.get(i - 1).get(2), email_input)) {
                        rows = Integer.parseInt(tickets.get(i-1).get(3));
                        seats = Integer.parseInt(tickets.get(i-1).get(4));
                        if (rows == 1) {
                            row_1[seats-1] = "0";
                        }
                        if (rows == 2) {
                            row_2[seats-1] = "0";
                        }
                        if (rows == 3) {
                            row_3[seats-1] = "0";
                        }
                        tickets.remove(i - 1);
                        //decrement person_count by one
                        person_count--;
                    }
                }
                System.out.println("All seats were reserved under '" + email_input + "' canceled successfully.");
                System.out.println();
            }
            else {
                System.out.println("Sorry! Make sure to enter the valid response format shown there. Please Try Again.");
                System.out.println();
            }
        }
        return person_count;
    }
    public static void show_available(String[] row_1, String[] row_2, String[] row_3){

        System.out.println();
        System.out.format("%46s","Pick Your Seat & Enjoy the Movie!");
        System.out.println();
        System.out.println();

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
        System.out.println();
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

            System.out.println();
            System.out.format("%39s","Successfully Saved!");
            System.out.println();

        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
        System.out.println();
    }
    public static void load(String[] row_1, String[] row_2, String[] row_3) {

        Scanner input = new Scanner(System.in);
        System.out.println("**Please make sure the all the reserved seat information SAVED into the system already, before LOAD**");

        String opinion = "no";

        do {
            try {
                System.out.println();
                System.out.print("Do you want to proceed towards? (yes|no) : ");
                opinion = input.nextLine();

                if (Objects.equals(opinion, "yes")) {
                    try {
                        File fileObj = new File("seatinfo.txt");
                        Scanner fileReader = new Scanner(fileObj);

                        //when reading the "seatinfo.txt" line by line it takes what line is it
                        int while_count = 1;

                        while (fileReader.hasNextLine()) {
                            if (while_count == 1) {
                                String saved_line1 = fileReader.nextLine();
                                //reassigning row_1 values according to previously saved
                                for (int i = 0; i < saved_line1.length(); i++) {
                                    row_1[i] = String.valueOf(saved_line1.charAt(i));
                                }
                            }
                            if (while_count == 2) {
                                String saved_line2 = fileReader.nextLine();
                                for (int i = 0; i < saved_line2.length(); i++) {
                                    row_2[i] = String.valueOf(saved_line2.charAt(i));
                                }
                            }
                            if (while_count == 3) {
                                String saved_line3 = fileReader.nextLine();
                                for (int i = 0; i < saved_line3.length(); i++) {
                                    row_3[i] = String.valueOf(saved_line3.charAt(i));
                                }
                            }
                            while_count++;
                        }
                        fileReader.close();

                        System.out.println();
                        System.out.format("%51s", "***** Successfully Loaded into the System! *****");
                        System.out.println();
                        System.out.println();

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Sorry! Input can not readable. Please Try Again.");
                System.out.println();
            }
            if (!(Objects.equals(opinion, "yes") || Objects.equals(opinion, "no"))) {
                System.out.println();
                System.out.println("Sorry! Make sure to enter the valid response format shown there. Please Try Again.");
            }
        } while (!(Objects.equals(opinion, "yes") || Objects.equals(opinion, "no")));
    }
    public static void show_tickets_info(ArrayList<ArrayList<String>> tickets){

        System.out.println();
        System.out.format("%48s","Details of The System Available Tickets");
        System.out.println();
        System.out.println();

        //initializing and assigning total variable
        int total = 0;

        for (int i = 0; i < tickets.size(); i++) {
            System.out.println("***Ticket No : " + (i+1) + "***");
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    System.out.format("%-13s", "Name");
                    System.out.print(": ");
                    System.out.print(tickets.get(i).get(j));
                    System.out.println();
                }
                if (j == 1) {
                    System.out.format("%-13s", "Surname");
                    System.out.print(": ");
                    System.out.print(tickets.get(i).get(j));
                    System.out.println();
                }
                if (j == 2) {
                    System.out.format("%-13s", "Email");
                    System.out.print(": ");
                    System.out.print(tickets.get(i).get(j));
                    System.out.println();
                }
                if (j == 3) {
                    System.out.format("%-13s", "Row Number");
                    System.out.print(": ");
                    System.out.print(tickets.get(i).get(j));
                    System.out.println();
                }
                if (j == 4) {
                    System.out.format("%-13s", "Seat Number");
                    System.out.print(": ");
                    System.out.print(tickets.get(i).get(j));
                    System.out.println();
                }
                if (j == 5) {
                    System.out.format("%-13s", "Price");
                    System.out.print(": Rs.");
                    System.out.print(tickets.get(i).get(j));
                    System.out.println();
                    total += Integer.parseInt(tickets.get(i).get(j));
                }
            }
            System.out.println();
        }
        System.out.println("*********");
        System.out.println("The total price of the issued tickets  :  Rs." + total);
        System.out.println("*********");
        System.out.println();
    }
    public static void sort_tickets(ArrayList<ArrayList<String>> tickets) {

        System.out.println();
        System.out.format("%45s","Ascending Orderd List of Tickets");
        System.out.println();
        System.out.println();

        //Create a new 2D arraylist to store tickets
        ArrayList<ArrayList<String>> sorted_ticket_list = new ArrayList<ArrayList<String>>();

        //One space allocated for 0 index
        sorted_ticket_list.add(new ArrayList<String>());

        if (tickets.size() != 0) {

            //Adding first element of tickets arraylist
            for (int i = 0; i < 6; i++) {
                sorted_ticket_list.get(0).add(i, tickets.get(0).get(i));
            }

            //Adding each element in tickets to sorted_tickets_list in an ascending way according to the seat price
            for (int i = 1; i < tickets.size(); i++) {

                int num1 = Integer.parseInt(tickets.get(i).get(5));
                int num2 = Integer.parseInt(sorted_ticket_list.get(0).get(5));

                if (num1 <= num2) {
                    sorted_ticket_list.add(0, tickets.get(i));
                } else {
                    for (int j = 0; j < sorted_ticket_list.size(); ) {
                        int num3 = Integer.parseInt(sorted_ticket_list.get(j).get(5));
                        j++;

                        if (num1 < num3) {
                            sorted_ticket_list.add((j - 1), tickets.get(i));
                            break;
                        } else if (i == j) {
                            sorted_ticket_list.add(tickets.get(i));
                        }
                    }
                }
            }

            //Print sorted_tickets_list
            for (int i = 0; i < sorted_ticket_list.size(); i++) {
                System.out.println();
                System.out.println("***Ticket " + (i+1) + "***");
                for (int j = 0; j < 6; j++) {
                    if (j == 0) {
                        System.out.format("%-13s", "Name");
                        System.out.print(": ");
                        System.out.print(sorted_ticket_list.get(i).get(j));
                        System.out.println();
                    }
                    if (j == 1) {
                        System.out.format("%-13s", "Surname");
                        System.out.print(": ");
                        System.out.print(sorted_ticket_list.get(i).get(j));
                        System.out.println();
                    }
                    if (j == 2) {
                        System.out.format("%-13s", "Email");
                        System.out.print(": ");
                        System.out.print(sorted_ticket_list.get(i).get(j));
                        System.out.println();
                    }
                    if (j == 3) {
                        System.out.format("%-13s", "Row Number");
                        System.out.print(": ");
                        System.out.print(sorted_ticket_list.get(i).get(j));
                        System.out.println();
                    }
                    if (j == 4) {
                        System.out.format("%-13s", "Seat Number");
                        System.out.print(": ");
                        System.out.print(sorted_ticket_list.get(i).get(j));
                        System.out.println();
                    }
                    if (j == 5) {
                        System.out.format("%-13s", "Price");
                        System.out.print(": Rs.");
                        System.out.print(sorted_ticket_list.get(i).get(j));
                        System.out.println();
                    }
                }
            }
        }
        else {
            System.out.println("There is no Issued Tickets so far in the system.");
        }
        System.out.println();
    }
}
