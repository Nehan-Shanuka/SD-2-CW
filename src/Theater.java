import java.io.*;
import java.util.*;

class Theater {
    public static void main(String[] args) {

        System.out.println();
        System.out.format("%42s","Welcome to the New Theater\n\n");

        //initializing row_1, row_2, row_3 String arrays
        String[] row_1 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_2 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_3 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};

        //initializing an arraylist called tickets for store the ticket data(task 12)
        ArrayList<ArrayList<String>> tickets = new ArrayList<>();
        //https://www.geeksforgeeks.org/multidimensional-collections-in-java/

        //to use in the while argument and takes "option" value
        int option_check;

        //to take how many persons took the tickets and add person information to the tickets arraylist
        int person_count = 0;

        do {
            //print set of "-" in a row
            String sep_line = new String(new char[60]).replace('\0', '-');
            //https://kodejava.org/how-do-i-align-string-print-out-in-left-right-center-alignment/
            System.out.println(sep_line + '\n');

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
            System.out.format("%10s","0) Quit\n");

            System.out.println("\n*** Please USE OPTION [2] to check what seats are available for you before purchase ***\n");

            System.out.println(sep_line + '\n');

            int option = 9;

            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Enter option :  ");
                option = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nSorry! Your input can not readable. Please Try again.\n");
                option_check = option;
                continue;
            }
            //assigning the value of option (option_check is for check the condition for do-while loop)
            option_check = option;

            if (!(option >= 0 && option <= 8)) {
                System.out.println("\nSorry! The input you entered is invalid. Please Try again.\n");
                continue;
            }

            System.out.println('\n' + sep_line);

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
        System.out.format("%39s","Purchace the Ticket\n\n");

        //to assign values in Ticket & Person class to new variables
        int rows;
        int seats;
        int price;
        String name = "none";
        String surname = "none";
        String email = "none";
        //initializing more_ticket vari to ask whether user want to purchase more tickets under his email or not
        String more_ticket = "no";

        do {
            //call the Ticket class
            Ticket myTicket = new Ticket(more_ticket);

            if (more_ticket.equals("no")) {

                name = myTicket.Person.getName();
                surname = myTicket.Person.getSurname();
                email = myTicket.Person.getEmail();
            }

            if (!(name.isEmpty() || surname.isEmpty() || email.isEmpty())) {
                if (!(myTicket.getRow().isEmpty() || myTicket.getSeat().isEmpty())) {

                    try {
                        rows = Integer.parseInt(myTicket.getRow());
                        seats = Integer.parseInt(myTicket.getSeat());

                        //one space allocated for 0 index
                        tickets.add(new ArrayList<>());
                        //https://www.geeksforgeeks.org/multidimensional-collections-in-java/

                        //call the price() method in Ticket class
                        price = myTicket.price();

                    } catch (NumberFormatException e) {
                        System.out.println("\nSorry! Your row/seat selection can not readable. Please Check and Try Again\n");
                        continue;
                    }

                    if (rows != 0 || seats != 0) {
                        System.out.println();

                        //checking the availability of seat that currant customer prefer
                        if (rows == 1) {
                            if ((seats >= 1 && seats <= 12)) {
                                if (Objects.equals(row_1[seats - 1], "1")) {
                                    tickets.remove(person_count);
                                    System.out.println("Sorry! The seat has been reserved already. Please Try another seat.");
                                    System.out.println("Please make sure that you have checked what seats are Available now through our system.");
                                } else {
                                    row_1[seats - 1] = "1";

                                    buyticket_adding2arraylist(tickets,name,surname,email, myTicket.getRow(), myTicket.getSeat(), String.valueOf(price), person_count);

                                    myTicket.print(name, surname, email, price);
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

                                    buyticket_adding2arraylist(tickets,name,surname,email, myTicket.getRow(), myTicket.getSeat(), String.valueOf(price), person_count);

                                    myTicket.print(name, surname, email, price);
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

                                    buyticket_adding2arraylist(tickets,name,surname,email, myTicket.getRow(), myTicket.getSeat(), String.valueOf(price), person_count);

                                    myTicket.print(name, surname, email, price);
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

                    do {
                        System.out.println();

                        try {
                            Scanner input = new Scanner(System.in);
                            System.out.print("Do you wish to purchase more than one ticket? (yes|no) : ");
                            more_ticket = input.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("\nSorry! Input can not readable. Please Try Again.");
                        }

                        if (!(Objects.equals(more_ticket, "yes") || Objects.equals(more_ticket, "no"))) {
                            System.out.println("\nSorry! Make sure to enter the valid response format shown there. Please Try Again.");
                        }
                    } while (!(Objects.equals(more_ticket, "yes") || Objects.equals(more_ticket, "no")));

                } else {
                    System.out.println("\nSorry! Your seat number information are not enough to processed forward. Try again.");
                }
            } else {
                System.out.println("\nSorry! Your credentials are not enough to processed forward. Try again.");
            }
            System.out.println();

        } while (Objects.equals(more_ticket, "yes"));

        return person_count;
    }
    public static void print_seating_area(String[] row_1, String[] row_2, String[] row_3){

        System.out.println();
        System.out.format("%58s","Choose the Best&Calm Place Available and Enjoy the Movie!\n\n");

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
            if (!Objects.equals(i,"1")){
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
        System.out.println();
    }
    public static int cancel_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<ArrayList<String>> tickets, int person_count){

        System.out.println();
        System.out.format("%51s","Cancel Here The Tickets Your Purchased Earlier\n\n");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your email : ");
        String email_input = input.nextLine();

        //initializing rows and seats variables to hold row number and seat number from the tickets arraylist.
        int rows = 0;
        int seats;

        System.out.println("The seats reserved under '" + email_input + "' :\n");

        //checking the email that take from the customer also in the tickets  arraylist.
        for (int i = tickets.size(); i > 0; i--){
            if (Objects.equals(tickets.get(i-1).get(2), email_input)){
                //assigning values to rows and seats
                rows = Integer.parseInt(tickets.get(i-1).get(3));
                seats = Integer.parseInt(tickets.get(i-1).get(4));

                System.out.format("%20s","[ row:" + rows + " | seat:" + seats + " ]\n");
            }
        }

        if (rows == 0) {
            System.out.println("Sorry! There is no reserved seat under '" + email_input + "' email holder.");
        }
        else {
            System.out.println();
            //to ask user wants to cancel all tickets that user reserved
            String all_cancel_opt = "none";

            do {
                try {
                    System.out.print("Do you want to cancel all tickets you reserved? (yes|no) : ");
                    all_cancel_opt = input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Sorry! Input can not readable. Please Try Again.\n");
                }

                System.out.println();

                //initialize and assign value to get user opinion to cancel another ticket
                String cancel_loop_opt = "yes";

                if (Objects.equals(all_cancel_opt, "no")) {
                    System.out.println("**Please enter the seat you want to cancel**");
                    do {
                        System.out.println();

                        System.out.print("Row number  : ");
                        int row_input = input.nextInt();
                        System.out.print("Seat number : ");
                        int seat_input = input.nextInt();

                        System.out.println();

                        //to validate and show a massage to say the cancel task done properly.
                        int seat_validity = 0;
                        for (int i = 0; i < tickets.size(); i++) {
                            if (Objects.equals(tickets.get(i).get(2), email_input)) {
                                if (Objects.equals(tickets.get(i).get(3), String.valueOf(row_input)) && Objects.equals(tickets.get(i).get(4), String.valueOf(seat_input))) {
                                    tickets.remove(i);
                                    //decrement person_count by one
                                    person_count--;
                                    seat_validity = 1;
                                }
                            }
                        }

                        if (seat_validity != 0) {
                            System.out.println("The row:" + row_input + " seat:" + seat_input + " numbered seat canceled successfully from '" + email_input + "'.\n");
                            if (row_input == 1) {
                                row_1[seat_input - 1] = "0";
                            }
                            if (row_input == 2) {
                                row_2[seat_input - 1] = "0";
                            }
                            if (row_input == 3) {
                                row_3[seat_input - 1] = "0";
                            }
                        } else {
                            System.out.println("Sorry! The seat you set to cancel is not for yours. Please check what are your seats and Try again.\n");
                        }

                        do {
                            try {
                                System.out.print("Do you want to cancel another? (yes|no) :  ");
                                cancel_loop_opt = input.nextLine();
                                System.out.println();
                            } catch (InputMismatchException e) {
                                System.out.println("Sorry! Input can not readable. Please Try Again.\n");
                            }
                            if (!(Objects.equals(cancel_loop_opt, "yes") || Objects.equals(cancel_loop_opt, "no"))) {
                                System.out.println("\nSorry! Make sure to enter the valid response format shown there. Please Try Again.\n");
                            }
                        } while (!(Objects.equals(cancel_loop_opt, "yes") || Objects.equals(cancel_loop_opt, "no")));

                    } while (Objects.equals(cancel_loop_opt, "yes"));

                } else if (Objects.equals(all_cancel_opt, "yes")) {
                    for (int i = tickets.size(); i > 0; i--) {
                        if (Objects.equals(tickets.get(i - 1).get(2), email_input)) {
                            rows = Integer.parseInt(tickets.get(i - 1).get(3));
                            seats = Integer.parseInt(tickets.get(i - 1).get(4));
                            if (rows == 1) {
                                row_1[seats - 1] = "0";
                            }
                            if (rows == 2) {
                                row_2[seats - 1] = "0";
                            }
                            if (rows == 3) {
                                row_3[seats - 1] = "0";
                            }
                            tickets.remove(i - 1);
                            //decrement person_count by one
                            person_count--;
                        }
                    }
                    System.out.println("All seats were reserved under '" + email_input + "' canceled successfully.\n");
                } else {
                    System.out.println("Sorry! Make sure to enter the valid response format shown there. Please Try Again.\n");
                }
            } while (!((Objects.equals(all_cancel_opt,"yes")) || (Objects.equals(all_cancel_opt,"no"))));
        }
        return person_count;
    }
    public static void show_available(String[] row_1, String[] row_2, String[] row_3){

        System.out.println();
        System.out.format("%46s","Pick Your Seat & Enjoy the Movie!\n\n");

        System.out.print("Seats available in row 1: ");

        //initializing an arraylist to store currently available seat numbers in row_1
        ArrayList<String> seatnum_row1 = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            if (!Objects.equals(row_1[i -1], "1")) {
                String seat_no = String.valueOf(i);
                seatnum_row1.add(seat_no);
            }
        }
        //print the array element with separating by a comma.
        String joined_row1 = String.join(", ", seatnum_row1);
        System.out.println(joined_row1);
        //https://stackoverflow.com/questions/18279622/print-out-elements-from-an-array-with-a-comma-between-the-elements

        System.out.print("Seats available in row 2: ");

        //initializing an arraylist to store currently available seat numbers in row_2
        ArrayList<String> seatnum_row2 = new ArrayList<>();
        for (int i = 1; i < 17; i++) {
            if (!Objects.equals(row_2[i -1], "1")) {
                String seat_no = String.valueOf(i);
                seatnum_row2.add(seat_no);
            }
        }
        String joined_row2 = String.join(", ", seatnum_row2);
        System.out.println(joined_row2);

        System.out.print("Seats available in row 3: ");

        //initializing an arraylist to store currently available seat numbers in row_3
        ArrayList<String> seat_row3 = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            if (!Objects.equals(row_3[i -1], "1")) {
                String seat_no = String.valueOf(i);
                seat_row3.add(seat_no);
            }
        }
        String joined_row3 = String.join(", ", seat_row3);
        System.out.println(joined_row3);

        System.out.println();
    }
    public static void save(String[] row_1, String[] row_2, String[] row_3) {

        try {
            FileWriter myWriter = new FileWriter("seatinfo.txt");
            //to write a new line
            String newline = System.getProperty("line.separator");
            //https://www.geeksforgeeks.org/java-program-to-print-a-new-line-in-string/

            for (String element : row_1) {
                myWriter.write(element);
            }
            myWriter.write(newline);

            for (String element : row_2) {
                myWriter.write(element);
            }
            myWriter.write(newline);

            for (String element : row_3) {
                myWriter.write(element);
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
                System.out.print("\nDo you want to proceed towards? (yes|no) : ");
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
                        System.out.format("%51s", "***** Successfully Loaded into the System! *****\n\n");

                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Sorry! Input can not readable. Please Try Again.\n");
            }
            if (!(Objects.equals(opinion, "yes") || Objects.equals(opinion, "no"))) {
                System.out.println("\nSorry! Make sure to enter the valid response format shown there. Please Try Again.");
            }
        } while (!(Objects.equals(opinion, "yes") || Objects.equals(opinion, "no")));
        System.out.println();
    }
    public static void show_tickets_info(ArrayList<ArrayList<String>> tickets){

        System.out.println();
        System.out.format("%48s","Details of The System Available Tickets\n\n");

        //initializing and assigning total variable
        int total = 0;

        for (int i = 0; i < tickets.size(); i++) {
            System.out.println("*** Ticket No [" + (i+1) + "] ***");
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    System.out.format("%-13s", "Name");
                    ticket_print(tickets, i, j);
                }
                if (j == 1) {
                    System.out.format("%-13s", "Surname");
                    ticket_print(tickets, i, j);
                }
                if (j == 2) {
                    System.out.format("%-13s", "Email");
                    ticket_print(tickets, i, j);
                }
                if (j == 3) {
                    System.out.format("%-13s", "Row Number");
                    ticket_print(tickets, i, j);
                }
                if (j == 4) {
                    System.out.format("%-13s", "Seat Number");
                    ticket_print(tickets, i, j);
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
        System.out.println("****************************************");
        System.out.println("The total price of the issued tickets  :  Rs." + total);
        System.out.println("****************************************");
        System.out.println();
    }
    public static void sort_tickets(ArrayList<ArrayList<String>> tickets) {

        System.out.println();
        System.out.format("%45s","Ascending Ordered List of Tickets");
        System.out.println();
        System.out.println();

        //Create a new 2D arraylist to store tickets
        ArrayList<ArrayList<String>> sorted_ticket_list = new ArrayList<>();

        //One space allocated for 0 index
        sorted_ticket_list.add(new ArrayList<>());

        if (tickets.size() != 0) {

            //Adding first element of tickets arraylist
            for (int i = 0; i < 6; i++) {
                sorted_ticket_list.get(0).add(i, tickets.get(0).get(i));
            }

            //Adding each element in tickets to sorted_tickets_list in an ascending way according to the seat price
            for (int i = 1; i < tickets.size(); i++) {

                //take the price of ticket in each iteration
                int ticket_price = Integer.parseInt(tickets.get(i).get(5));
                //take the price of current 0 index ticket which stored in sorted_ticket_list
                int min_ticket_price = Integer.parseInt(sorted_ticket_list.get(0).get(5));

                if (ticket_price <= min_ticket_price) {
                    sorted_ticket_list.add(0, tickets.get(i));
                } else {
                    for (int j = 0; j < sorted_ticket_list.size(); ) {
                        //take each ticket price that stored in the sorted_ticket_list so far
                        int num3 = Integer.parseInt(sorted_ticket_list.get(j).get(5));
                        j++;

                        if (ticket_price < num3) {
                            sorted_ticket_list.add((j - 1), tickets.get(i));
                            break;
                        }
                        /*check whether the loop iterate trough last index of sorted_ticket_list or not
                        if so add the currant ticket information as the last index of sorted_ticket_list*/
                        else if (i == j) {
                            sorted_ticket_list.add(tickets.get(i));
                        }
                    }
                }
            }

            //Print sorted_tickets_list
            for (int i = 0; i < sorted_ticket_list.size(); i++) {
                System.out.println();
                System.out.println("*** Ticket No [" + (i+1) + "] ***");
                for (int j = 0; j < 6; j++) {
                    if (j == 0) {
                        System.out.format("%-13s", "Name");
                        ticket_print(sorted_ticket_list, i, j);
                    }
                    if (j == 1) {
                        System.out.format("%-13s", "Surname");
                        ticket_print(sorted_ticket_list, i, j);
                    }
                    if (j == 2) {
                        System.out.format("%-13s", "Email");
                        ticket_print(sorted_ticket_list, i, j);
                    }
                    if (j == 3) {
                        System.out.format("%-13s", "Row Number");
                        ticket_print(sorted_ticket_list, i, j);
                    }
                    if (j == 4) {
                        System.out.format("%-13s", "Seat Number");
                        ticket_print(sorted_ticket_list, i, j);
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

    //to add ticket information into the ticket arraylist
    public static void buyticket_adding2arraylist(ArrayList<ArrayList<String>> tickets, String name, String surname, String email,
                                                   String row, String seat, String price, int person_count) {

        tickets.get(person_count).add(0, name);
        tickets.get(person_count).add(1, surname);
        tickets.get(person_count).add(2, email);
        tickets.get(person_count).add(3, row);
        tickets.get(person_count).add(4, seat);
        tickets.get(person_count).add(5, price);
    }

    //to get and print ticket information from the ticket arraylist
    public static void ticket_print(ArrayList<ArrayList<String>> array_list, int i, int j) {
        System.out.print(": ");
        System.out.print(array_list.get(i).get(j) + '\n');
    }

}
