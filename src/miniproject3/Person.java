
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;


public class Person {
    // Properties
    private String firstName;
    private String lastName;
    private String addr;
    private String email;
    
    // Constructors
    public Person() {
        firstName = "";
        lastName = "";
        addr = "";
        email = "";
    }
    public Person(String f, String l, String a, String e) {
        firstName = f;
        lastName = l;
        addr = a;
        email = e;
    }
    
    // Behaviors
    public String getFirst() {return firstName;}
    public void setFirst(String f) {firstName = f;}
    public String getLast() {return lastName;}
    public void setLast(String l) {lastName = l;}
    public String getAddr() {return addr;}
    public void setAddr(String a) {addr = a;}
    public String getEmail() {return email;}
    public void setEmail(String e) {email = e;}
    
    public void display() {
        System.out.println("First Name:  " +getFirst());
        System.out.println("Last Name:   " +getLast());
        if (addr.equals("")) {}
        else {
            System.out.println("Address:     " +getAddr());
        }
        System.out.println("Email:       " +getEmail());
    }
    
    // Main
    public static void main(String[] args) {

    }
}