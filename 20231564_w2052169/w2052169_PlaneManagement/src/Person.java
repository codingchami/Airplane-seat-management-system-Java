public class Person {
    //class attributes
    private String name;
    private  String surname;
    private  String email;

    //parameterized constructor
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //create printInformation method to print customers data
    public void printInformation(){
        System.out.println("Customer's name:"+ name);
        System.out.println("Customer's surname:"+ surname);
        System.out.println("Customer's email:"+ email);
    }
}
