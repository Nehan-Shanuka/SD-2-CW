import java.util.Objects;
import java.util.Scanner;

public class Person {
    private String name;
    private String surname;
    private String email;

    public Person (String name, String surname, String email){

        this.name = name;
        this.surname = surname;
        this.email = email;

//        if (Objects.equals(option, "no")) {
//            Scanner input = new Scanner(System.in);
//
//            System.out.format("%-23s", "Enter your name");
//            System.out.print(":   ");
//            this.name = input.nextLine();
//            this.name = this.name.toUpperCase();
//
//            System.out.format("%-23s", "Enter your surname");
//            System.out.print(":   ");
//            this.surname = input.nextLine();
//            this.surname = this.surname.toUpperCase();
//
//            do {
//                System.out.format("%-23s", "Enter your email");
//                System.out.print(":   ");
//                this.email = input.nextLine();
//
//                //validate the email whether it can be taken as an email or not
//                //https://www.w3schools.com/java/ref_string_contains.asp
//                if (this.email.contains("@")) {
//                    break;
//                }
//                System.out.format("%70s", "***Sorry! Email can not be taken. Try again a with valid email***\n");
//            } while (!(email.contains("@")));
//
//        } else {
//            this.name = name;
//            this.surname = surname;
//            this.email = email;
//        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
