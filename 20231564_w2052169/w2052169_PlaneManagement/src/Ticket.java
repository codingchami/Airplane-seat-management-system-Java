import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ticket {

    //class attributes
    private char row;
    private int seat;
    private double price;
    private Person person;

    //default constructor
    public Ticket() {

    }

    //parameterized constructor
    public Ticket(char row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //getters and setters
    public char getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    //in this save method create a file and prints all customers details and ticket information in one file.
    public void save(){
        //set the file name
        String filename = row+String.valueOf(seat)+".txt";
        //File obj = new File(filename);
        try{
            FileWriter myWriter = new FileWriter(row+String.valueOf(seat)+".txt");
            myWriter.write("=======================\n");
            myWriter.write("TICKET INFORMATION:\n");
            myWriter.write("=======================\n");
            myWriter.write("Row: "+row+"\n");
            myWriter.write("Seat: " + seat + "\n");
            myWriter.write("Price: " + price + "\n");
            myWriter.write("=======================\n");
            myWriter.write("Person Information:\n");
            myWriter.write("=======================\n");
            myWriter.write("Name: " + person.getName() + "\n");
            myWriter.write("Name: " + person.getName() + "\n");
            myWriter.write("Surname: " + person.getSurname() + "\n");
            myWriter.write("Email: " + person.getEmail() + "\n");
            myWriter.close();
            System.out.println("Ticket information are successfully saved to file: "+(filename));
            System.out.println("=========================================================");


        }catch (IOException e){
            System.out.println("An error occured!..........");

        }

    }
    public void printTicketinformation(){
        System.out.println("Row number:"+ row);
        System.out.println("Seat number:"+ seat);
        System.out.println("Seat price:"+ price);
        System.out.println("Person information:");
        person.printInformation();
    }
}
