/*import java.util.ArrayList;

class Testing{
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> sorted_ticket_list = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> tickets = new ArrayList<ArrayList<String>>();

        tickets.add(new ArrayList<String>());
        tickets.get(0).add("h");
        tickets.get(0).add("h");
        tickets.get(0).add("h");
        tickets.get(0).add("1");
        tickets.get(0).add("1");
        tickets.get(0).add("500");

        tickets.add(new ArrayList<String>());
        tickets.get(1).add("l");
        tickets.get(1).add("l");
        tickets.get(1).add("l");
        tickets.get(1).add("2");
        tickets.get(1).add("2");
        tickets.get(1).add("1000");

        tickets.add(new ArrayList<String>());
        tickets.get(2).add("g");
        tickets.get(2).add("g");
        tickets.get(2).add("g");
        tickets.get(2).add("3");
        tickets.get(2).add("3");
        tickets.get(2).add("900");

        tickets.add(new ArrayList<String>());
        tickets.get(3).add("s");
        tickets.get(3).add("s");
        tickets.get(3).add("s");
        tickets.get(3).add("3");
        tickets.get(3).add("8");
        tickets.get(3).add("500");

        sorted_ticket_list.add(new ArrayList<String>());

        for (int i = 0; i < 6; i++) {
            sorted_ticket_list.get(0).add(i,tickets.get(0).get(i));
        }

        for (int i = 1; i < tickets.size(); i++){
            System.out.println(tickets.get(i));

            int num1 = Integer.parseInt(tickets.get(i).get(5));
            int num2 = Integer.parseInt(sorted_ticket_list.get(0).get(5));

            if (num1 <= num2){
                sorted_ticket_list.add(0,tickets.get(i));
            }
            else {
                for (int j = 0; j < sorted_ticket_list.size();) {
                    //System.out.println("Hi");
                    int num3 = Integer.parseInt(sorted_ticket_list.get(j).get(5));
                    //System.out.println(num3);

                    //System.out.println(sorted_ticket_list);
                    j++;
                    System.out.println(" "+ i + " " + j);
                    if (num1 < num3) {
                        sorted_ticket_list.add((j-1),tickets.get(i));
                        break;
                    }
                    else if (i == j) {
                        sorted_ticket_list.add(tickets.get(i));
                    }
                    //System.out.println(sorted_ticket_list);
                }
            }
        }
        //System.out.println(sorted_ticket_list);

        for (int i = 0; i < sorted_ticket_list.size(); i++){
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
}*/
import java.util.*;
/*public class Testing {
    public static void main(String[] args) {
        System.out.println();  //to add a space
        System.out.println("             Welcome to the New Theatre!!                 ");
        int[] row_1={0,0,0,0,0,0,0,0,0,0,0,0};
        int[] row_2={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] row_3={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println("---------------------------------------------------------");
        System.out.println("Please select an option :");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats ");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("    0) Quit");
        System.out.println("----------------------------------------------------------");

        Scanner input=new Scanner(System.in);
        int row_nb;
        int seat_nb;
        int option=input.nextInt();
        while (option==0 || option==1 || option==2 || option==3 || option==4 || option==5 || option==6 || option==7 || option==8){
            if (option==0){
                System.out.println("Quit");
                break;
            }
            if (option==1){         // to Buy a ticket
                System.out.println("Theare are 3 rows in the hall.Please select your row number : ");
                row_nb= input.nextInt();
                if (row_nb>=1 && row_nb<=3){   //select a row
                    if (row_nb==1){    //when row number is 1
                        System.out.println("There are 12 seats in row "+row_nb+". Please enter your prefer seat number");
                        seat_nb= input.nextInt();

                        if (seat_nb>=1 && seat_nb<=12){   //check seat numbers correvt or wrong
                            if (row_1[(seat_nb)-1]==1) {       //check the seat booked or not
                                System.out.println("Sorry!!. This seat already booked.Please select another seat");
                                continue;
                            }else {
                                row_1[(seat_nb)-1]=1;
                                System.out.println("You booked seat number "+seat_nb+" correctly.\n Thank you!!.\n Come Again");
                                break;

                            }

                        }else {
                            System.out.println("Invalid seat number.There are'nt such kind of seat number in this row.Please try again");
                            continue;
                        }

                    }
                    // when row number is 2;

                    else if (row_nb==2) {
                        System.out.println("There are 16 seats in row "+row_nb+". Please enter your prefer seat number");
                        seat_nb= input.nextInt();

                        if (seat_nb>=1 && seat_nb<=16){   //check seat numbers correct or wrong
                            if (row_2[(seat_nb)-1]==1) {       //check the seat booked or not
                                System.out.println("Sorry!!. This seat already booked.Please select another seat");
                                continue;
                            }else {
                                row_2[(seat_nb)-1]=1;
                                System.out.println("You booked seat number "+seat_nb+" correctly.\n Thank you!!.\n Come Again");
                                break;

                            }

                        }else {
                            System.out.println("Invalid seat number.There are'nt such kind of seat number in this row.Please try again");
                            continue;
                        }

                    }
                    //when row number is 3;
                    else {
                        System.out.println("There are 20 seats in row "+row_nb+". Please enter your prefer seat number");
                        seat_nb= input.nextInt();

                        if (seat_nb>=1 && seat_nb<=20){   //check seat numbers correct or wrong
                            if (row_3[(seat_nb)-1]==1) {       //check the seat booked or not
                                System.out.println("Sorry!!. This seat already booked.Please select another seat");
                                continue;
                            }else {
                                row_3[(seat_nb)-1]=1;
                                System.out.println("You booked seat number "+seat_nb+" correctly.\n Thank you!!.\n Come Again");
                                break;

                            }

                        }else {
                            System.out.println("Invalid seat number.There are'nt this such kind of seat number in this row.Please try again");
                            continue;
                        }
                    }

                }
                else {
                    System.out.println("Invalid row number.Plaese try again ");
                    continue;
                }

                //when select option 2
            } else if (option==2) {
                print_seating_area(row_1,row_2,row_3);
                break;

            }

        }

    }

    //created a new method and called to it as  print_seating_area
    public static void print_seating_area(int[] row1,int [] row2 , int[] row3){

        System.out.println(row1.length);
        for (int i:row1) {
            System.out.print(i + ", ");
        }
      /* for (int i=0;i< row2.length;i++) {
            System.out.print(row2[i] + ", ");
        }

       // for (int i=0;i< row3.length;i++) {
            System.out.print(row3[i] + ", ");
        }*/

class Testing {
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> tickets = new ArrayList<ArrayList<String>>();

        tickets.add(new ArrayList<String>());
        tickets.get(0).add("l");
        tickets.get(0).add("l");
        tickets.get(0).add("l");
        tickets.get(0).add("1");
        tickets.get(0).add("1");
        tickets.get(0).add("500");

        tickets.add(new ArrayList<String>());
        tickets.get(1).add("l");
        tickets.get(1).add("l");
        tickets.get(1).add("l");
        tickets.get(1).add("2");
        tickets.get(1).add("2");
        tickets.get(1).add("1000");

        tickets.add(new ArrayList<String>());
        tickets.get(2).add("l");
        tickets.get(2).add("l");
        tickets.get(2).add("l");
        tickets.get(2).add("3");
        tickets.get(2).add("3");
        tickets.get(2).add("900");

        tickets.add(new ArrayList<String>());
        tickets.get(3).add("l");
        tickets.get(3).add("l");
        tickets.get(3).add("l");
        tickets.get(3).add("3");
        tickets.get(3).add("8");
        tickets.get(3).add("500");

        Scanner input_list_str = new Scanner(System.in);
        Scanner input_list_int = new Scanner(System.in);

        System.out.print("Enter your email : ");
        String email_input = input_list_str.nextLine();

        //initializing rows and seats variables to hold row number and seat number from the tickets arraylist.
        int rows = 0;
        int seats = 0;
        int length = tickets.size();

        System.out.println("The seats reserved under '" + email_input + "' :");
        System.out.println();
        //checking the email that take from the customer also in the tickets  arraylist.
        for (int i = length; i > 0; i--){
            if (Objects.equals(tickets.get(i-1).get(2), email_input)){
                //assigning values to rows and seats
                rows = Integer.parseInt(tickets.get(i-1).get(3));
                seats = Integer.parseInt(tickets.get(i-1).get(4));

                System.out.format("%20s","[ row:" + rows + " | seat:" + seats + " ] ");
                System.out.println();
            }
        }

        System.out.println();
        System.out.println();

        if (rows == 0) {
            System.out.println();
            System.out.println("Sorry! There is no reserved seat under '" + email_input + "' email holder.");
        }
        else {
            System.out.print("Do you want to cancel all tickets you reserved? : ");
            String want = input_list_str.nextLine();

            String wish = "yes";

            if (Objects.equals(want, "no")) {
                System.out.println("**Please enter the seat you want to cancel**");
                do {
                    System.out.print("Row number  : ");
                    int row = input_list_int.nextInt();
                    System.out.print("Seat number : ");
                    int seat = input_list_int.nextInt();

                    int hi = 0;
                    for (int i = 0; i < tickets.size(); i++) {
                        if (Objects.equals(tickets.get(i).get(2), email_input)) {
                            if (Objects.equals(tickets.get(i).get(3), String.valueOf(row)) && Objects.equals(tickets.get(i).get(4), String.valueOf(seat))) {
                                tickets.remove(i);
                                hi = 1;
                                //person_count--;
                            }
                        }
                    }
                    if (hi == 0) {
                        System.out.println("Sorry! The seat you set to cancel is not for yours. Please check what are your seats and Try again.");
                        System.out.println();
                    }
                    else {
                        System.out.println("The row:" +row+ " seat:" +seat+ " numbered seat canceled successfully from '" +email_input+ "'.");
                        System.out.println();
                    }
                    System.out.print("Do you want to cancel another? (yes/no) :  ");
                    wish = input_list_str.nextLine();
                } while (Objects.equals(wish, "yes"));

            } else if (Objects.equals(want, "yes")) {
                for (int i = tickets.size(); i > 0; i--) {
                    if (Objects.equals(tickets.get(i - 1).get(2), email_input)) {
                        tickets.remove(i - 1);

                        //tickets.remove(i-1);
                        //System.out.println("Seats were reserved under '" + email_input + "' canceled successfully.");
                        //decrement person_count by one
                        //person_count--;
                        //tickets.add(new ArrayList<String>());
                    }
                }
            }
        }

    }
}


        /*changing the row_1, row_2 and row_3 after cancellation
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
        }*/