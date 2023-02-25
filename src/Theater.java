import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java. util. Scanner;
class Theater {
    public static void main(String[] args) {
        System.out.println("Welcome to the New Theater");

        String[] row_1 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_2 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        String[] row_3 = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        //String[] row_4 = {"0", "0", "0", "0"};
        //This is for testing purpose
        //String rows[] = row_1;

        ArrayList<ArrayList<String>> tickets = new ArrayList<ArrayList<String>>();

        int option_vari;
        //It gives an error without this(reason to be learned)
        int person_count = 0;

        do {

            String line = new String(new char[48]).replace('\0', '-');
            //https://kodejava.org/how-do-i-align-string-print-out-in-left-right-center-alignment/
            System.out.println(line);

            System.out.println("Please select an option :");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort ticket by price");
            System.out.println("0) Quit");
            System.out.println(line);

            Scanner input = new Scanner(System.in);
            System.out.print("Enter option: ");
            int option = input.nextInt();
            option_vari = option;
            //To use in loop condition "option" gives erros

            if (option == 1) {
                buy_ticket(row_1, row_2, row_3, tickets, person_count);
            }
            if (option == 2) {
                print_seating_area(row_1, row_2, row_3);
            }
            if (option == 3) {
                cancel_ticket(row_1, row_2, row_3, tickets, person_count);
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
        while (option_vari != 0);
    }
    public static void buy_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<ArrayList<String>> tickets, int person_count){

        /*Scanner input_list = new Scanner(System.in);
        System.out.print("Enter the row number you want to seat: ");
        int rows = input_list.nextInt();
        System.out.print("Enter the seat number you want to seat: ");
        int seats = input_list.nextInt();*/

        Person myPerson = new Person();
        System.out.println();

        Ticket myTicket = new Ticket();
        int rows = Integer.parseInt(myTicket.row);
        int seats = Integer.parseInt(myTicket.seat);
        Ticket.print(myTicket.row, myTicket.seat, myPerson.name, myPerson.surname, myPerson.email);

        tickets.add(new ArrayList<String>());

        //int person_count = 0;

        tickets.get(person_count).add(0, myPerson.name);
        tickets.get(person_count).add(1, myPerson.surname);
        tickets.get(person_count).add(2, myPerson.email);
        tickets.get(person_count).add(3, myTicket.row);
        tickets.get(person_count).add(4, myTicket.seat);

        person_count++;

        if (rows == 1){
            if ((seats>=1 && seats <=12)){
                if (row_1[seats-1] == "1"){
                    System.out.println("Sorry, the seat has occupied, Try again");
                }
                else {
                    row_1[seats - 1] = "1";
                }
            }
            else{
                System.out.println("Sorry, wrong selection, Try again");
            }
        }
        else if (rows == 2){
            if ((seats>=1 && seats <=16)){
                if (row_2[seats-1] == "1"){
                    System.out.println("Sorry, the seat has occupied, Try again");
                }
                else {
                    row_2[seats - 1] = "1";
                }
            }
            else{
                System.out.println("Sorry, wrong selection, Try again");
            }
        } else if (rows == 3){
            if ((seats>=1 && seats <=20)){
                if (row_3[seats-1] == "1"){
                    System.out.println("Sorry, the seat has occupied, Try again");
                }
                else {
                    row_3[seats - 1] = "1";
                }
            }
            else{
                System.out.println("Sorry, wrong selection, Try again");
            }
        }
        else{
            System.out.println("Sorry, wrong selection Try again");
        }
    }
    public static void print_seating_area(String[] row_1, String[] row_2, String[] row_3){
        System.out.format("%10s"," ");
        System.out.println("***********");
        System.out.format("%10s"," ");
        System.out.println("*  STAGE  *");
        System.out.format("%10s"," ");
        System.out.println("***********");

        int count = 1; // to print a space to shows the path between left and right set of seats in the same row.
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
    public static void cancel_ticket(String[] row_1, String[] row_2, String[] row_3, ArrayList<ArrayList<String>> tickets, int person_count){

        Scanner input_list = new Scanner(System.in);
        Scanner input_newlist = new Scanner(System.in);

        System.out.print("Enter your email : ");
        String email_input = input_newlist.nextLine();

        System.out.print("Enter the row number you want to cancel : ");
        int rows = input_list.nextInt();

        System.out.print("Enter the seat number you want to cancel : ");
        int seats = input_list.nextInt();


        /*if (Objects.equals(tickets.get(0).get(2), email_input)) {
            System.out.println("Job is done!");
        }*/

        for (int i = 0; i < tickets.toArray().length; i++){
            if (Objects.equals(tickets.get(i).get(2), email_input)){
                System.out.println("Job is done!");
                tickets.remove(i);
                person_count--;
            }
        }

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
    }
    public static void show_available(String[] row_1, String[] row_2, String[] row_3){
        System.out.print("Seats available in row 1: ");
        /*int m1 = 0;
        for (int i = 0; i < row_1.length; i++) {
            if (Objects.equals(row_1[i], "0")) {
                m1++;
            }
        }*/
        ArrayList<String> arrlist1 = new ArrayList<String>();
        for (int j = 1; j < 13; j++) {
            if (!Objects.equals(row_1[j-1], "1")) {
                String k = String.valueOf(j);
                arrlist1.add(k);
            }
        }
        String joinedStr1 = String.join(", ", arrlist1);
        System.out.println(joinedStr1);
        //https://stackoverflow.com/questions/18279622/print-out-elements-from-an-array-with-a-comma-between-the-elements

        System.out.print("Seats available in row 2: ");
        /*int m2 = 0;
        for (int i = 0; i < row_2.length; i++) {
            if (Objects.equals(row_2[i], "0")) {
                m2++;
            }
        }*/
        ArrayList<String> arrlist2 = new ArrayList<String>();
        for (int j = 1; j < 17; j++) {
            if (!Objects.equals(row_2[j-1], "1")) {
                String k = String.valueOf(j);
                arrlist2.add(k);
            }
        }
        String joinedStr2 = String.join(", ", arrlist2);
        System.out.println(joinedStr2);

        System.out.print("Seats available in row 3: ");
        /*int m3 = 0;
        for (int i = 0; i < row_3.length; i++) {
            if (Objects.equals(row_3[i], "0")) {
                m3++;
            }
        }*/
        ArrayList<String> arrlist3 = new ArrayList<String>();
        for (int j = 1; j < 21; j++) {
            if (!Objects.equals(row_3[j-1], "1")) {
                String k = String.valueOf(j);
                arrlist3.add(k);
            }
        }
        String joinedStr3 = String.join(", ", arrlist3);
        System.out.println(joinedStr3);
    }
    public static void save(String[] row_1, String[] row_2, String[] row_3){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            String newline = System.getProperty("line.separator");
            //To save or print in a new line
            //https://www.geeksforgeeks.org/java-program-to-print-a-new-line-in-string/
            for (int i = 0; i < row_1.length; i++){
                myWriter.write((row_1[i]));
            }
            myWriter.write(newline);
            for (int i = 0; i < row_2.length; i++){
                myWriter.write((row_2[i]));
            }
            myWriter.write(newline);
            for (int i = 0; i < row_3.length; i++) {
                myWriter.write((row_3[i]));
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static String[] load(String[] row_1, String[] row_2, String[] row_3) {
        String[] row_4 = new String[12];
        String[] row_5 = new String[16];
        String[] row_6 = new String[20];
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            int while_count = 1;
            while (myReader.hasNextLine()) {
                if (while_count == 1){
                    String ball1 = myReader.nextLine();
                    for (int i = 0; i < ball1.length(); i++){
                        row_1[i] = String.valueOf(ball1.charAt(i));
                    }
                }
                if (while_count == 2){
                    String ball2 = myReader.nextLine();
                    for (int i = 0; i < ball2.length(); i++){
                        row_2[i] = String.valueOf(ball2.charAt(i));
                    }
                }
                if (while_count == 3){
                    String ball3 = myReader.nextLine();
                    for (int i = 0; i < ball3.length(); i++){
                        row_3[i] = String.valueOf(ball3.charAt(i));
                    }
                }
                while_count++;
                //System.out.println(ball1);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return row_1;
        /*ArrayList<String> arrlist4 = new ArrayList<String>();
        for (int j = 1; j < 13; j++) {
                String k = String.valueOf(j);
                arrlist4.add(k);
        }*/
    }
}
