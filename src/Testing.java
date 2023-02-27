import java.util.ArrayList;

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
}
