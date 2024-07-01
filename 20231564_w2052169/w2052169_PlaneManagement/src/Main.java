import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Database area.Using 1D arrays for the store data row by row.
    static String[] row_A = new String[14];
    static String[] row_B = new String[12];
    static String[] row_C = new String[12];
    static String[] row_D = new String[14];

    //declare Ticket array for store all information related to the Ticket class.
    static Ticket[] tickets = new Ticket[52];
    static int ticketsSold = 0;  //set the ticketSold count as Zero in beginning.
    //these public attributes can use not only in class but also another classes.
    public static String name;
    public static  String surname;
    public static String email;
    public static double price;
    public static Person person;


    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to the Plane Management application!..");
        System.out.println("*".repeat(50));
        System.out.println("* "+" ".repeat(18)+"Main menu"+" ".repeat(18)+" *");
        System.out.println("*".repeat(50));
        Scanner input = new Scanner(System.in);

        //Display the following menu and ask the user to select an option until user enter number '7' as a option.
        boolean loop = true;
        while(loop){
            String [] startMenu={            //using string array
                    "1).Buy a seat",
                    "2).Cancel a seat",
                    "3).Find first available seat",
                    "4).Show seating plan",
                    "5).Print tickets information and total sales",
                    "6).Search ticket",
                    "7).Quit\n"
            };

        //using enhanced for loop and display the string array with starting menu.
            for (String menu : startMenu) {
                System.out.println(menu);
            }
            //this try catch valid for the all the methods which content the try block...
            //User enter the invalid input as a input then not system crash, it catch by catch block and returns a error message.
            try {
                System.out.println("Please select an option (1-7):");
                int option = input.nextInt();
                //using switch case and inwalk the methods.
                switch (option) {
                    case 1:
                        System.out.println("==Now you can buy a seat==\n");
                        buy_seat();
                        break;
                    case 2:
                        System.out.println("==Now you can cancel a seat==\n");
                        cancel_seat();
                        break;
                    case 3:
                        System.out.println("==Now you can find first available seat==\n");
                        find_first_available();
                        break;
                    case 4:
                        System.out.println("==Now you can see seating plan==\n");
                        show_seating_plan();
                        break;
                    case 5:
                        System.out.println("==Now you can see tickets information and total sales==\n");
                        print_tickets_info();
                        break;
                    case 6:
                        System.out.println("==Now you can search ticket==\n");
                        show_seating_plan();
                        search_ticket();
                        break;
                    case 7:
                        System.out.println("You are exiting the Plane Management application!\n Good Bye!.....");
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid input!..Please check the Main Menu again!\n");
                        break;
                }
            }catch (InputMismatchException ex){
                System.out.println("Error occured!..Please enter the valid input.");
                input.nextLine();
            }
        }
    }
    public static boolean buy_seat() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the row letter (A-D):");
        //Getting row letter as a input and store it as a char value.
        char rowLetter = input.next().toUpperCase().charAt(0);


        System.out.println("Please enter the seat number:");
        // getting seat number as a input from user and store it as a int value.
        int seatNumber = input.nextInt();

        boolean validSeatnumber = false;
        switch(rowLetter){
            case 'A':
                validSeatnumber = seatNumber>=1 && seatNumber<=row_A.length;
                break;
            case 'B':
                validSeatnumber = seatNumber>=1 && seatNumber<=row_B.length;
                break;
            case 'C':
                validSeatnumber = seatNumber>=1 && seatNumber<=row_C.length;
                break;
            case 'D':
                validSeatnumber = seatNumber>=1 && seatNumber<=row_D.length;
                break;
            default:
                validSeatnumber = false;
        }
        if(!validSeatnumber){
            System.out.println("Invalid seat number!..Please check again.");
            return false;
        }

        boolean seatAvailable = false;
        switch (rowLetter){
            case 'A':
                seatAvailable = row_A[seatNumber-1]==null;
                break;
            case 'B':
                seatAvailable = row_B[seatNumber-1]==null;
                break;
            case 'C':
                seatAvailable = row_C[seatNumber-1]==null;
                break;
            case 'D':
                seatAvailable = row_D[seatNumber-1]==null;
                break;
            default:
                seatAvailable = false;
        }
        if(!seatAvailable){
            System.out.println("Sorry!..Already seat is not available.");
            return false;
        }
        System.out.println("Insert customer details:\n");

        boolean isValid =false;
        System.out.println("Insert your first name:");
        //using while loop and loops it again and again until when user insert valid correct inputs.
        while(!isValid){
            name = input.next();
            //using java Regular Expressions and check weather user insert valid input or not...
            //[a-zA-Z] it can check name content is only alphabetical letters..
            if(!name.matches("[a-zA-Z]+")){
                System.out.println("**Invalid name!..**");
                System.out.println("Insert name again: ");
            }else{
                isValid = true;
            }
        }

        isValid = false;
        System.out.println("Insert your surname:");
        while(!isValid){
            surname = input.next();
            if(!surname.matches("[a-zA-Z]+")){
                System.out.println("**Invalid surname!..**");
                System.out.println("Insert surname again: ");
            }else{
                isValid = true;
            }
        }

        isValid =false;
        System.out.println("Insert your email:");
        while(!isValid){
            email = input.next();
            //using java Regular Expressions and check weather user insert valid email or not...
            if(!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
                System.out.println("**Invalid email..Check and insert again!..**");
                System.out.println("Inset email again:");
            }else {
                isValid = true;
            }
        }

        System.out.println("All information enterd successfully!..\n");
        //name, surname, and email values are used to initialize the properties of the Person object being created.
        //person is the reference variable of Person class
        Person person = new Person(name, surname, email);

        switch (rowLetter){
            case 'A':
                row_A[seatNumber - 1] = "booked";
                break;
            case 'B':
                row_B[seatNumber - 1] = "booked";
                break;
            case 'C':
                row_C[seatNumber - 1] = "booked";
                break;
            case 'D':
                row_D[seatNumber - 1] = "booked";
                break;
        }

        // Create and store the ticket
        price = ticketPrice(seatNumber);
        Ticket ticket = new Ticket(rowLetter, seatNumber, price, person);
        //all data set and store the ticket array
        tickets[ticketsSold] = ticket;
        //sold tickets counter
        ticketsSold++;

        System.out.println("Seat booked successfully!");
        ticket.save();
        return true;
    }
    //set the ticket price using seat number
    public static double ticketPrice(int seatNumber){
        double price = 0;
        if(seatNumber>=1 && seatNumber<=5){
            price = 200;
        }else if(seatNumber>=6 && seatNumber<=9){
            price = 150;
        }else{
            price = 180;
        }
        return price;
    }
    public static boolean cancel_seat(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the row letter:");
        char rowLetter = input.next().toUpperCase().charAt(0);
        System.out.println("Please enter the seat number:");
        int seatNumber = input.nextInt();

        String filename = rowLetter+String.valueOf(seatNumber)+".txt";

        File deleteFile = new File(filename);

        Ticket ticket = new Ticket(rowLetter, seatNumber, price, person);

        switch (rowLetter) {
            case 'A':
                if (seatNumber < 1 || seatNumber >= row_A.length) { //check seat number is inrange or out of range
                    System.out.println("Inavalid seat number!...Check seeting plan again!..\n");
                } else if (row_A[seatNumber - 1] == null) { //check relevant seat number is null(available)
                    System.out.println("There's no need to cancel,the seat is available yet!..\n");
                } else if (row_A[seatNumber - 1] != null) {  //check relevant seat number is !null(not available)
                    row_A[seatNumber - 1] = null;
                    if (deleteFile.exists()) {
                        deleteFile.delete();  //delete file from file location.
                        System.out.println("Seat has been cancelled successfully!\n");
                    }
                }
                for (int i = 0; i <ticketsSold; i++) {
                    if(tickets[i]!=null){  //loop the ticket array and check what are the !null places to check conditions.
                        if(tickets[i].getRow() == rowLetter && tickets[i].getSeat() == seatNumber){
                            tickets[i]=null;  //when cancel the seat,remove the all data from tickets array and clear it.
                            break;
                        }
                    }
                }
                break;
            case 'B':
                if (seatNumber < 1 || seatNumber >= row_B.length) {
                    System.out.println("Inavalid seat number!...Check seeting plan again!..\n");
                } else if (row_B[seatNumber - 1] == null) {
                    System.out.println("There's no need to cancel,the seat is available yet!..\n");
                } else if (row_B[seatNumber - 1] != null) {
                    row_B[seatNumber - 1] = null;
                    if (deleteFile.exists()) {
                        deleteFile.delete();
                        System.out.println("Seat has been canceled successfully!\n");
                    }
                }
                for (int i = 0; i <ticketsSold; i++) {
                    if(tickets[i]!=null){
                        if(tickets[i].getRow() == rowLetter && tickets[i].getSeat() == seatNumber){
                            tickets[i]=null;
                            break;
                        }
                    }
                }
                break;
            case 'C':
                if (seatNumber < 1 || seatNumber >= row_C.length) {
                    System.out.println("Inavalid seat number!...Check seeting plan again!..\n");
                } else if (row_C[seatNumber - 1] == null) {
                    System.out.println("There's no need to cancel,the seat is available yet!..\n");
                } else if (row_C[seatNumber - 1] != null) {
                    row_C[seatNumber - 1] = null;
                    if (deleteFile.exists()) {
                        deleteFile.delete();
                        System.out.println("Seat has been canceled successfully!\n");
                    }
                }
                for (int i = 0; i <ticketsSold; i++) {
                    if(tickets[i]!=null){
                        if(tickets[i].getRow() == rowLetter && tickets[i].getSeat() == seatNumber){
                            tickets[i]=null;
                            break;
                        }
                    }
                }
                break;
            case 'D':
                if (seatNumber < 1 || seatNumber >= row_D.length) {
                    System.out.println("Inavalid seat number!...Check seeting plan again!..\n");
                } else if (row_D[seatNumber - 1] == null) {
                    System.out.println("There's no need to cancel,the seat is available yet!..\n");
                } else if (row_D[seatNumber - 1] != null) {
                    row_D[seatNumber - 1] = null;
                    if (deleteFile.exists()) {
                        deleteFile.delete();
                        System.out.println("Seat has been canceled successfully!\n");
                    }
                }
                for (int i = 0; i <ticketsSold; i++) {
                    if(tickets[i]!=null){
                        if(tickets[i].getRow() == rowLetter && tickets[i].getSeat() == seatNumber){
                            tickets[i]=null;
                            break;
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid seat!..Seat is not found!....\n");
        }
        return true;
    }
    public static boolean find_first_available(){
        //find the first available seat using by for loops
        for (int i = 0; i <=row_A.length; i++) { //using for i loop and loop row_A array and find what is the first null place in array.
            if (row_A[i] == null) {
                System.out.println("First available seat: Row A, Seat " + (i+1)+"\n");
                return true;
            }
        }
        for (int i = 0; i <=row_B.length; i++) {
            if(row_B[i] == null){
                System.out.println("First available seat: Row B,Seat " + (i+1)+"\n");
                return true;
            }
        }
        for (int i = 0; i <=row_C.length; i++) {
            if(row_C[i] == null){
                System.out.println("First available seat: Row C,Seat " + (i+1)+"\n");
                return true;
            }
        }
        for (int i = 0; i <=row_D.length; i++) {
            if(row_D[i] == null){
                System.out.println("First available seat: Row D,Seat " + (i+1)+"\n");
                return true;
            }
        }
        return true;
    }
    public static boolean show_seating_plan(){
        System.out.println("Seating Plan:\n");
        for (int i = 0; i <row_A.length; i++) {
            System.out.print(row_A[i] != null ? " X " : " O "); //check weather null or not, if it is !null then prints 'X' and if it is=null, then prints 'O'.
        }
        System.out.println(); //This line prints output to the console without starting a new line.

        for (int i = 0; i <row_B.length; i++) {
            System.out.print(row_B[i]!= null? " X " : " O ");
        }
        System.out.println();
        for (int i = 0; i <row_C.length; i++) {
            System.out.print(row_C[i]!= null? " X " : " O ");
        }
        System.out.println();
        for (int i = 0; i <row_D.length; i++) {
            System.out.print(row_D[i]!= null? " X " : " O ");
        }
        System.out.println("\n");
        return true;
    }
    public static boolean print_tickets_info(){
        double totalamountofTicket=0;
        if(ticketsSold == 0){
            System.out.println("No any ticket that have been sold during the session!..\n");
            return false;
        }
        //using for loop and loop tickets array and check below conditions,when these conditions are true then prints the ticket information.
        for (int i = 0; i < tickets.length; i++) {
            Ticket ticket = tickets[i];
            if (ticket != null) {
                ticket.printTicketinformation();
                //calculate total amount of tickets which sold tickets.
                totalamountofTicket += ticket.getPrice();
                System.out.println("=============================");
            }
        }
        System.out.println("Total tickets that have been sold during the session:"+ticketsSold);
        System.out.println("Total sales: £" + totalamountofTicket);
        System.out.println("=============================");

        return true;
    }
    public static boolean search_ticket(){
        Scanner input = new Scanner(System.in);
        System.out.println("Now you are in search ticket option.");
        System.out.println("Please enter the row letter(A-D):");
        char rowLetter = input.next().toUpperCase().charAt(0);
        System.out.println("Please enter the seat number:");
        int seatNumber = input.nextInt();
        System.out.println();

        boolean found = false;
        for (Ticket ticket : tickets) { //using enhanced for loop and loop the ticket array
            //check until null situation and then check row letter and seat number are equals,then it equals prints the ticket information.
            if (ticket != null  && ticket.getRow() == rowLetter && ticket.getSeat() == seatNumber) {
                found = true;
                System.out.println("==Ticket found!==");
                ticket.printTicketinformation();
                System.out.println("=======================");
                break;
            }
        }
        //conditions when not true, it says the seat is not yet buy anyone and its available already..and then prints("This seat is available.")
        if (!found) {
            System.out.println("This seat is available.\n");
        }
        return true;
    }

}
