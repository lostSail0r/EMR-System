
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Dentist extends Person {
    // Properties
    private String id;
    private String passwd;
    private String office;
    private AppointmentList aptList = new AppointmentList();
    final String denFileLocation = "C:/Users/Chris/Documents/NetBeansProjects/MiniProject2/build/classes/miniproject2/Dentists.txt";
    final String appFileLocation = "C:/Users/Chris/Documents/NetBeansProjects/MiniProject2/build/classes/miniproject2/Appointments.txt";
    
    // Constructors
    public Dentist() {
        super();
        id = "";
        passwd = "";
        office = "";
        aptList = new AppointmentList();
    }
    public Dentist(String f, String l, String a, String e, String i, String p, String o, AppointmentList ap) {
        super(f, l, a, e);
        id = i;
        passwd = p;
        office = o;
        aptList = ap;
    }
    
    // Behaviors
    public String getID() {return id;}
    public void setID(String p) {id = p;}
    public String getPasswd() {return passwd;}
    public void setPasswd(String pw) {passwd = pw;}
    public String getOffice() {return office;}
    public void setOffice(String o) {office = o;}
    public AppointmentList getAptList() {return aptList;}
    
    // Select Method
    public void select(String pCode) {
        try {
            // Dentist file operation
            Scanner dentistIn = new Scanner(new File(denFileLocation));
            dentistIn.useDelimiter(":|\n");
            while (dentistIn.hasNext()) {
                String next = dentistIn.next();
                if(pCode.equals(next)) {
                    id = next;
                    passwd = dentistIn.next();
                    setFirst(dentistIn.next());
                    setLast(dentistIn.next());
                    setEmail(dentistIn.next());
                    office = dentistIn.next();
                }
            }
            dentistIn.close();
            
            // Appointment file operation
            FileReader appIn = new FileReader(appFileLocation);
            BufferedReader br = new BufferedReader(appIn);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(id)) {
                    StringTokenizer x = new StringTokenizer(line, ":|\n");
                    while (x.hasMoreElements()) {
                        aptList.addAppointment(new Appointment(x.nextElement().toString(), x.nextElement().toString(), x.nextElement().toString(), x.nextElement().toString()));
                    }
                }
            }
            appIn.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    // Insert Method
    public void insert(String f, String l, String em, String dId, String pw, String o) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(denFileLocation, true));
            out.print("\n" + dId + ":" + pw + ":" + f + ":" + l + ":" + em + ":" + o);
            out.close();
        }
        catch(IOException e) {
            System.err.println("Error! File does not exist.");
        }
    }
    
    // Display Method
    public void display() {
        super.display();
        System.out.println("Dentist ID:      " +getID());
        System.out.println("Password:        " +getPasswd());
        System.out.println("Office Number:   " +getOffice());
        aptList.display();
    }
    
    // Main
    public static void main(String[] args) {
        Dentist d1 = new Dentist();
        //d1.insert("Chris", "Grady", "cgrady@aol.com", "D205", "12345", "554");
        d1.select("D201");
        d1.display();
    }
}