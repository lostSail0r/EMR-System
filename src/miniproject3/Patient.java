
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;
import java.io.*;
import java.util.Scanner;

public class Patient extends Person {
    
    // Properties
    private String patId;
    private int passwd;
    private String insCo;
    private Appointment apt = new Appointment();
    final String patFileLocation = "C:/Users/Chris/Documents/NetBeansProjects/MiniProject2/build/classes/miniproject2/Patients.txt";
    final String appFileLocation = "C:/Users/Chris/Documents/NetBeansProjects/MiniProject2/build/classes/miniproject2/Appointments.txt";
    
    // Constructors
    public Patient() {
        super();
        patId = "";
        passwd = 0;
        insCo = "";
        apt = new Appointment();
    }
    public Patient(String f, String l, String a, String e, String id, int p, String ins, Appointment ap) {
        super(f, l, a, e);
        patId = id;
        passwd = p;
        insCo = ins;
        apt = ap;
    }
    
    // Behaviors
    public String getID() {return patId;}
    public void setID(String p) {patId = p;}
    public int getPasswd() {return passwd;}
    public void setPasswd(int pw) {passwd = pw;}
    public String getIns() {return insCo;}
    public void setIns(String i) {insCo = i;}
    public Appointment getApt() {return apt;}
    public void setApt(Appointment ap) {apt = ap;}
    
    
    // Select Method
    public void select(String pCode) {
        String dt, pid, did, proc;
        try {
            // Patient file operation
            Scanner patientFile = new Scanner(new File(patFileLocation));
            patientFile.useDelimiter(":|\n");
            while (patientFile.hasNext()) {
                String next = patientFile.next();
                if(pCode.equals(next)) {
                    patId = next;
                    passwd = Integer.parseInt(patientFile.next());
                    setFirst(patientFile.next());
                    setLast(patientFile.next());
                    setAddr(patientFile.next());
                    setEmail(patientFile.next());
                    insCo = patientFile.next();
                }
            }
            patientFile.close();
            
            // Appointment file operation
            Scanner aptFile = new Scanner(new File(appFileLocation));
            aptFile.useDelimiter(":|\n");
            while (aptFile.hasNext()) {
                String next = aptFile.next();
                if(pCode.equals(next)) {
                    pid = next;
                    dt = aptFile.next();
                    did = aptFile.next();
                    proc = aptFile.next();
                    setApt(new Appointment(dt, pid, did, proc));
                }
            }
            aptFile.close();
        }
        catch(IOException e) {
            System.err.println("Error! File does not exist.");
        }
    }
    
    // Insert Method
    public void insert(String f, String l, String a, String em, String pID, int pw, String ins) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(patFileLocation, true));
            out.print("\n" + pID + ":" + pw + ":" + f + ":" + l + ":" + a + ":" + em + ":" + ins);
            out.close();
        }
        catch(IOException e) {
            System.err.println("Error! File does not exist.");
        }
    }
    // Display Method
    @Override
    public void display() {
        super.display();
        System.out.println("Patient ID:         " +getID());
        System.out.println("Password:           " +getPasswd());
        System.out.println("Insurance Company:  " +getIns());
        apt.display();
    }

    // Main
    public static void main(String[] args) {
        Patient p1 = new Patient();
        p1.select("A900");
        p1.display();
        //p1.insert("Chris", "Grady", "Atlanta", "cgrady@aol.com", "A912", 1234, "Cigna");
    }
}