
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;
import java.io.*;
import java.util.Scanner;

public class Appointment {

    // Properties
    private String apptDateTime;
    private String patID;
    private String dentID;
    private String procCode;
    final String fileLocation = "C:/Users/Chris/Documents/NetBeansProjects/MiniProject2/build/classes/miniproject2/Appointments.txt";
    
    // Constructors
    public Appointment() {
        apptDateTime = "";
        patID = "";
        dentID = "";
        procCode = "";
    }
    public Appointment(String date, String pID, String dID, String code) {
        apptDateTime = date;
        patID = pID;
        dentID = dID;
        procCode = code;
    }
    
    // Behaviors
    public String getDate() {return apptDateTime;}
    public void setDate(String d) {apptDateTime = d;}
    public String getPID() {return patID;}
    public void setPID(String p) {patID = p;}
    public String getDID() {return dentID;}
    public void setDID(String d) {dentID = d;}
    public String getCode() {return procCode;}
    public void setCode(String c) {procCode = c;}
    
    // Select Method
    public void select(String pCode) {
        try {
            Scanner in = new Scanner(new File(fileLocation));
            in.useDelimiter(":|\n");
            while (in.hasNext()) {
                String next = in.next();
                if(pCode.equals(next)) {
                    patID = next;
                    apptDateTime = in.next();
                    dentID = in.next();
                    procCode = in.next();
                }
            }
            in.close();
        }
        catch(IOException e) {
            System.err.println("Error! File does not exist.");
        }
    }
    
    // Insert Method
    public void insert(String paID, String date, String deID, String proc) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(fileLocation, true));
            out.print("\n" + paID + ":" + date + ":" + deID + ":" + proc);
            out.close();
        }
        catch(IOException e) {
            System.err.println("Error! File does not exist.");
        }
    }
    
    // Display Method
    public void display() {
        System.out.println("Appointment Time/Date:        " +getDate());
        System.out.println("Appointment Patient ID:       " +getPID());
        System.out.println("Appointment Dentist ID:       " +getDID());
        System.out.println("Appointment Procedure Code:   " +getCode());
    }
    
    // Main
    public static void main(String[] args) {
        Appointment a1 = new Appointment();
        a1.select("A902");
        //a1.insert("A902", "10/17/2016-9am", "D203", "P118");
        a1.display();
    }
    
}

