import java.io.*;
import java.util.*;

class Theatre {
    public static void main(String[] args) {

        System.out.println();
        System.out.format("%42s", "Welcome to the New Theater\n\n");

        //initializing row_1, row_2, row_3 String arrays
        String[] row_1 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_2 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_3 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};

        //initializing an arraylist called ticket_list for store the ticket data(task 12)
        ArrayList<Ticket> ticket_list = new ArrayList<>();
        //https://www.geeksforgeeks.org/multidimensional-collections-in-java/

        //to use in the while argument and takes "option" value
        int option_check;

        //to take how many persons took the tickets and add person information to the tickets arraylist
        int person_count = 0;

        do {
            //to print set of "-" in a row
            String sep_line = new String(new char[60]).replace('\0', '-');
            //https://kodejava.org/how-do-i-align-string-print-out-in-left-right-center-alignment/
            System.out.println(sep_line + '\n');

            //print the menu
            System.out.println("Please select an option :\n");

            System.out.println("1.) Buy a ticket");
            System.out.println("2.) Print seating area");
            System.out.println("3.) Cancel ticket");
            System.out.println("4.) List available seats");
            System.out.println("5.) Save to file");
            System.out.println("6.) Load from file");
            System.out.println("7.) Print ticket information and total price");
            System.out.println("8.) Sort ticket by price");
            System.out.format("%10s", "0.) Quit\n");

            System.out.println("\n*** Please USE OPTION [2] to check what seats are available before purchase ***\n");

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
                person_count = buy_ticket(row_1, row_2, row_3, ticket_list, person_count);
            } else if (option == 2) {
                print_seating_area(row_1, row_2, row_3);
            } else if (option == 3) {
                //return the value of person_count
                person_count = cancel_ticket(row_1, row_2, row_3, ticket_list, person_count);
            } else if (option == 4) {
                show_available(row_1, row_2, row_3);
            } else if (option == 5) {
                save(row_1, row_2, row_3);
            } else if (option == 6) {
                load(row_1, row_2, row_3);
            } else if (option == 7) {
                show_tickets_info(ticket_list);
            } else if (option == 8) {
                sort_tickets(ticket_list);
            } else {
                System.out.println();
                System.out.format("%47s", "*** SHUTTING DOWN THE PROGRAM ***\n");
            }
        }
        while (option_check != 0);
    }

    public static int buy_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<Ticket> ticket_list, int person_count) {

        System.out.println();
        System.out.format("%39s", "Purchase the Ticket\n\n");

        //to assign values in Ticket & Person class to new variables
        int rows = 0;
        int seats = 0;
        String name = "none";
        String surname = "none";
        String email = "none";
        //initializing more_ticket variable to ask whether user want to purchase more tickets under his email or not
        String more_ticket = "no";

        Scanner input = new Scanner(System.in);

        do {
            if (more_ticket.equals("no")) {
                System.out.format("%-23s", "Enter your name");
                System.out.print(":   ");
                name = input.nextLine();
                name = name.toUpperCase();

                System.out.format("%-23s", "Enter your surname");
                System.out.print(":   ");
                surname = input.nextLine();
                surname = surname.toUpperCase();

                do {
                    System.out.format("%-23s", "Enter your email");
                    System.out.print(":   ");
                    email = input.nextLine();

                    //validate the email whether it can be taken as an email or not
                    //https://www.w3schools.com/java/ref_string_contains.asp
                    if (email.contains("@")) {
                        break;
                    }
                    System.out.format("%70s", "***Sorry! Email can not be taken. Try again a with valid email***\n");
                } while (!(email.contains("@")));

            }

            System.out.format("%-23s", "Enter the row number");
            System.out.print(":   ");
            rows = input.nextInt();

            System.out.format("%-23s", "Enter the seat number");
            System.out.print(":   ");
            seats = input.nextInt();


            //call the Ticket class
            Ticket myTicket = new Ticket(name, surname, email, rows, seats);


            if (!(name.isEmpty() || surname.isEmpty())) {

                try {
                    rows = myTicket.getRow();
                    seats = myTicket.getSeat();

                } catch (NumberFormatException e) {
                    System.out.println("\nSorry! Your row/seat selection can not readable. Please Check and Try Again\n");
                    continue;
                }

                if (rows != 0 || seats != 0) {
                    System.out.println();

                    //checking the availability of seat that currant customer prefer
                    if (rows == 1) {

                        person_count = seat_status(seats, 1, 12, row_1, ticket_list, myTicket,
                                person_count, "1st");


                    } else if (rows == 2) {

                        person_count = seat_status(seats, 1, 16, row_2, ticket_list, myTicket,
                                person_count, "2nd");


                    } else if (rows == 3) {

                        person_count = seat_status(seats, 1, 12, row_1, ticket_list, myTicket,
                                person_count, "3rd");


                    } else {
                        System.out.println("Sorry! The row number you chose does not exists. Please Try with valid seat number");
                    }
                } else {
                    System.out.println("\nSorry! Your row/seat number information are not enough to processed forward. Try again.");
                }

                do {
                    System.out.println();

                    try {
                        Scanner new_input = new Scanner(System.in);
                        System.out.print("Do you wish to purchase more than one ticket? (yes|no) : ");
                        more_ticket = new_input.nextLine();
                        more_ticket = more_ticket.toLowerCase();
                    } catch (InputMismatchException e) {
                        System.out.println("\nSorry! Input can not readable. Please Try Again.");
                    }

                    if (!(Objects.equals(more_ticket, "yes") || Objects.equals(more_ticket, "no"))) {
                        System.out.println("\nSorry! Make sure to enter the valid response format shown there. Please Try Again.");
                    }
                } while (!(Objects.equals(more_ticket, "yes") || Objects.equals(more_ticket, "no")));

            } else {
                System.out.println("\nSorry! Your credentials are not enough to processed forward. Try again.");
            }
            System.out.println();

        } while (Objects.equals(more_ticket, "yes"));

        return person_count;
    }

    //method for change the seat status in the system when buying a ticket
    public static int seat_status (int seat, int first_seat_num, int last_seat_num, String[] row, ArrayList<Ticket> ticket_list,
                                   Ticket ticket_obj, int person_count, String row_number) {
        if (seat >= first_seat_num && seat <= last_seat_num) {
            if ((Objects.equals(row[seat - 1], "1"))) {
                System.out.println("Sorry! The seat has been reserved already. Please Try another seat.");
                System.out.println("Please make sure that you have checked what seats are Available now through our system.");
            }
            else {
                row[seat - 1] = "1";
                ticket_list.add(ticket_obj);
                person_count++;
            }
        }
        else {
            System.out.println("Sorry! The seat number uou choose does not exist in the "+ row_number +" row. Please Try with a valid seat number.");
        }
        return person_count;
    }

    public static void print_seating_area(String[] row_1, String[] row_2, String[] row_3) {

        System.out.println();
        System.out.format("%59s", "Select the Best&Calm Place Available to Enjoy the Movie!\n\n");

        System.out.format("%23s", " ");
        System.out.println("***********");
        System.out.format("%23s", " ");
        System.out.println("*  STAGE  *");
        System.out.format("%23s", " ");
        System.out.println("***********");

        System.out.format("%22s", " ");
        show_row_status(row_1, 6);

        System.out.println();

        System.out.format("%20s", " ");
        show_row_status(row_2, 8);

        System.out.println();

        System.out.format("%18s", " ");
        show_row_status(row_3, 10);

        System.out.println("\n");
    }

    //method for print seating area of each row
    public static void show_row_status (String[] row, int count_num) {

        // to print a space to shows the path between left and right set of seats in the same row.
        int count = 1;

        for (String i : row) {
            if (!Objects.equals(i, "1")) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
            if (count == count_num) {
                System.out.print(" ");
            }
            count++;
        }

    }

    public static int cancel_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<Ticket> ticket_list, int person_count) {

        System.out.println();
        System.out.format("%56s", "Cancel The Tickets Purchased Earlier\n\n");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your email : ");
        String email_input = input.nextLine();

        //initializing rows and seats variables to hold row number and seat number from the tickets arraylist.
        int row_ticket = 0;
        int seat_ticket;

        System.out.println("The seats reserved under '" + email_input + "' >>>\n");

        //checking the email that take from the customer also in the tickets  arraylist.
        for (int i = ticket_list.size(); i > 0; i--) {
            if (Objects.equals(ticket_list.get(i - 1).Person.getEmail(), email_input)) {
                //assigning values to rows and seats
                row_ticket = ticket_list.get(i - 1).getRow();
                seat_ticket = ticket_list.get(i - 1).getSeat();

                System.out.format("%20s", "[ row:" + row_ticket + " | seat:" + seat_ticket + " ]\n");
            }
        }

        if (row_ticket == 0) {
            System.out.println("Sorry! There is no reserved seat under '" + email_input + "' email holder.");
        } else {
            System.out.println();
            //to ask user wants to cancel all tickets that user reserved
            String all_cancel_opt;

            do {
                System.out.print("Do you want to cancel all the tickets reserved under '" + email_input + "' email? (yes|no) : ");
                all_cancel_opt = input.nextLine();
                all_cancel_opt = all_cancel_opt.toLowerCase();

                System.out.println();

                //to assign the value to get user opinion to cancel another ticket
                String cancel_loop_opt;

                if (Objects.equals(all_cancel_opt, "no")) {
                    System.out.println("*** Enter the seat want to cancel ***");
                    do {
                        System.out.println();

                        System.out.print("Enter the row number  : ");
                        int row_input = input.nextInt();
                        System.out.print("Enter the seat number : ");
                        int seat_input = input.nextInt();

                        System.out.println();

                        //to cancel and show a massage to say the cancel task done properly.
                        int seat_availability = 0;
                        for (int i = 0; i < ticket_list.size(); i++) {
                            if (Objects.equals(ticket_list.get(i).Person.getEmail(), email_input)) {
                                if (ticket_list.get(i).getRow() == row_input && ticket_list.get(i).getSeat() == seat_input) {
                                    ticket_list.remove(i);
                                    //decrement person_count by one
                                    person_count--;
                                    seat_availability = 1;
                                }
                            }
                        }

                        if (seat_availability != 0) {
                            System.out.println("The row:" + row_input + " seat:" + seat_input + " numbered seat canceled successfully from '" + email_input + "'.\n");
                            if (row_input == 1) {
                                row_1[seat_input - 1] = "0";
                            } else if (row_input == 2) {
                                row_2[seat_input - 1] = "0";
                            } else if (row_input == 3) {
                                row_3[seat_input - 1] = "0";
                            }
                        } else {
                            System.out.println("Sorry! The seat you set to cancel is not for yours. Please check what are the relevant seats and Try again.\n");
                        }

                        do {
                            Scanner input_cancel_loop_opt = new Scanner(System.in);
                            System.out.print("Do you want to cancel another? (yes|no) :  ");
                            cancel_loop_opt = input_cancel_loop_opt.nextLine();
                            cancel_loop_opt = cancel_loop_opt.toLowerCase();

                            if (!(Objects.equals(cancel_loop_opt, "yes") || Objects.equals(cancel_loop_opt, "no") || cancel_loop_opt.isEmpty())) {
                                System.out.println("\nSorry! Make sure to enter the valid response format shown there. Please Try Again.\n");
                            }
                        } while (!(Objects.equals(cancel_loop_opt, "yes") || Objects.equals(cancel_loop_opt, "no")));

                    } while (Objects.equals(cancel_loop_opt, "yes"));

                } else if (Objects.equals(all_cancel_opt, "yes")) {
                    for (int i = ticket_list.size(); i > 0; i--) {
                        if (Objects.equals(ticket_list.get(i - 1).Person.getEmail(), email_input)) {

                            row_ticket = ticket_list.get(i - 1).getRow();
                            seat_ticket = ticket_list.get(i - 1).getSeat();

                            if (row_ticket == 1) {
                                row_1[seat_ticket - 1] = "0";
                            } else if (row_ticket == 2) {
                                row_2[seat_ticket - 1] = "0";
                            } else if (row_ticket == 3) {
                                row_3[seat_ticket - 1] = "0";
                            }
                            ticket_list.remove(i - 1);
                            //decrement person_count by one
                            person_count--;
                        }
                    }
                    System.out.println("All seats were reserved under '" + email_input + "' canceled successfully.");
                } else {
                    System.out.println("Sorry! Make sure to enter the valid response format shown there. Please Try Again.\n");
                }
            } while (!((Objects.equals(all_cancel_opt, "yes")) || (Objects.equals(all_cancel_opt, "no"))));
        }
        System.out.println();
        return person_count;
    }

    public static void show_available(String[] row_1, String[] row_2, String[] row_3) {

        System.out.println();
        System.out.format("%44s", "Check the Seats Currently Available!\n\n");

        //initializing an arraylist to store currently available seat numbers in row_1
        ArrayList<String> seat_num_row1 = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            if (!Objects.equals(row_1[i - 1], "1")) {
                seat_num_row1.add(String.valueOf(i));
            }
        }
        //print the array element with separating by a comma.
        String joined_row1 = String.join(", ", seat_num_row1);
        //https://stackoverflow.com/questions/18279622/print-out-elements-from-an-array-with-a-comma-between-the-elements

        System.out.print("Seats available in row 1: ");
        System.out.println(joined_row1);


        //initializing an arraylist to store currently available seat numbers in row_2
        ArrayList<String> seat_num_row2 = new ArrayList<>();
        for (int i = 1; i < 17; i++) {
            if (!Objects.equals(row_2[i - 1], "1")) {
                seat_num_row2.add(String.valueOf(i));
            }
        }
        String joined_row2 = String.join(", ", seat_num_row2);

        System.out.print("Seats available in row 2: ");
        System.out.println(joined_row2);

        //initializing an arraylist to store currently available seat numbers in row_3
        ArrayList<String> seat_num_row3 = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            if (!Objects.equals(row_3[i - 1], "1")) {
                seat_num_row3.add(String.valueOf(i));
            }
        }
        String joined_row3 = String.join(", ", seat_num_row3);

        System.out.print("Seats available in row 3: ");
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
            System.out.format("%39s", "Successfully Saved!");
            System.out.println();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        System.out.println();
    }

    public static void load(String[] row_1, String[] row_2, String[] row_3) {

        Scanner input = new Scanner(System.in);
        System.out.println("**Please make sure the all the reserved seat information SAVED into the system already, before LOAD**");

        String opinion;

        do {
            System.out.print("\nDo you want to proceed forwards? (yes|no) : ");
            opinion = input.nextLine();
            opinion = opinion.toLowerCase();

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
                        } else if (while_count == 2) {
                            String saved_line2 = fileReader.nextLine();
                            for (int i = 0; i < saved_line2.length(); i++) {
                                row_2[i] = String.valueOf(saved_line2.charAt(i));
                            }
                        } else if (while_count == 3) {
                            String saved_line3 = fileReader.nextLine();
                            for (int i = 0; i < saved_line3.length(); i++) {
                                row_3[i] = String.valueOf(saved_line3.charAt(i));
                            }
                        }
                        while_count++;
                    }
                    fileReader.close();

                    System.out.println();
                    System.out.format("%55s", "***** Successfully Loaded into the System! *****\n");

                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }

            if (!(Objects.equals(opinion, "yes") || Objects.equals(opinion, "no"))) {
                System.out.println("\nSorry! Make sure to enter the valid response format shown there. Please Try Again.");
            }
        } while (!(Objects.equals(opinion, "yes") || Objects.equals(opinion, "no")));
        System.out.println();
    }

    // modified after the submission to correct "print" method taking from the "Ticket" class
    public static void show_tickets_info (ArrayList<Ticket> ticket_list) {

        System.out.println();
        System.out.format("%48s", "Details of The System Available Tickets\n\n");

        int total = 0;

        if (ticket_list.size() != 0) {

            for (Ticket ticket : ticket_list) {
                ticket.print();
                total += ticket.price();
            }

        } else {
            System.out.println("There is no Issued Tickets so far in the system.");
        }
        System.out.println("**********************************************");
        System.out.println("The total price of the issued tickets  :  Rs." + total);
        System.out.println("**********************************************\n");

    }

    // modified after the submission to correct "print" method taking from the "Ticket" class
    public static void sort_tickets (ArrayList<Ticket> ticket_list) {

        System.out.println();
        System.out.format("%45s", "Ascending Ordered List of Tickets\n\n");

        if (ticket_list.size() != 0) {

            //reference with the lecture notes
            ArrayList<Ticket> sorted_ticket_list = MergeSort(ticket_list, 0, ticket_list.size() - 1);

            for (Ticket ticket : sorted_ticket_list) {
                ticket.print();
            }

        } else {
            System.out.println("There is no Issued Tickets so far in the system.\n");
        }
    }


    public static ArrayList<Ticket> MergeSort(ArrayList<Ticket> array_list, int start, int end) {
        ArrayList<Ticket> sorted_ticket_list;

        if (start < end) {
            int mid = (start + end) / 2;
            ArrayList<Ticket> ticket_list_left = MergeSort(array_list, start, mid);
            ArrayList<Ticket> ticket_list_right = MergeSort(array_list, mid + 1, end);
            sorted_ticket_list = merge(ticket_list_left, ticket_list_right);
        } else {
            sorted_ticket_list = new ArrayList<>();
            sorted_ticket_list.add(0, array_list.get(start));
        }
        return sorted_ticket_list;
    }

    public static ArrayList<Ticket> merge(ArrayList<Ticket> ticket_list_1, ArrayList<Ticket> ticket_list_2) {
        ArrayList<Ticket> merged = new ArrayList<>();
        int idx_1 = 0, idx_2 = 0, idx_merged = 0;

        while (idx_1 < ticket_list_1.size() && idx_2 < ticket_list_2.size()) {

            if (ticket_list_1.get(idx_1).getPrice() <= ticket_list_2.get(idx_2).getPrice()) {
                merged.add(idx_merged, ticket_list_1.get(idx_1));
                idx_1++;
            } else {
                merged.add(idx_merged, (ticket_list_2.get(idx_2)));
                idx_2++;
            }
            idx_merged++;

        }
        while (idx_1 < ticket_list_1.size()) {
            merged.add(idx_merged, ticket_list_1.get(idx_1));
            idx_1++;
            idx_merged++;
        }
        while (idx_2 < ticket_list_2.size()) {
            merged.add(idx_merged, ticket_list_2.get(idx_2));
            idx_2++;
            idx_merged++;
        }
        return merged;
    }

}
