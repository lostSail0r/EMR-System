
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;
import java.io.*;
import java.util.Scanner;

public class Procedure {

    // Properties
    private String procCode;
    private String procName;
    private String procDesc;
    private double cost;
    final String fileLocation = "C:/Users/Chris/Documents/NetBeansProjects/MiniProject2/build/classes/miniproject2/Procedures.txt";
    
    // Constructors
    public Procedure() {
        procCode = "";
        procName = "";
        procDesc = "";
        cost = 0.0;
    }
    public Procedure(String code, String name, String desc, double c) {
        procCode = code;
        procName = name;
        procDesc = desc;
        cost = c;
    }
    
    // Behaviors
    public String getCode() {return procCode;}
    public void setCode(String c) {procCode = c;}
    public String getName() {return procName;}
    public void setName(String n) {procName = n;}
    public String getDesc() {return procDesc;}
    public void setDesc(String d) {procDesc = d;}
    public double getCost() {return cost;}
    public void setCost(double co) {cost = co;}
    
    // Select Method
    public void select(String pCode) {
        try {
            Scanner in = new Scanner(new File(fileLocation));
            in.useDelimiter(":|\n");
            while (in.hasNext()) {
                String next = in.next();
                if(pCode.equals(next)) {
                    procCode = next;
                    procName = in.next();
                    procDesc = in.next();
                    cost = Double.parseDouble(in.next());
                }
            }
            in.close();
        }
        catch(IOException e) {
            System.err.println("Error! File does not exist.");
        }
    }
    // Insert Method
    public void insert(String pc, String pn, String pd, double c) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream(fileLocation, true));
            out.print("\n" + pc + ":" + pn + ":" + pd + ":" + c);
            out.close();
        }
        catch(IOException e) {
            System.err.println("Error! File does not exist.");
        }
    }
    // Display Method
    public void display() {
        System.out.println("Procedure Code:          " +getCode());
        System.out.println("Procedure Name:          " +getName());
        System.out.println("Procedure Description:   " +getDesc());
        System.out.println("Procedure Cost:          " +getCost());
    }
    
    // Main
    public static void main(String[] args) {
        Procedure pr1 = new Procedure();
        pr1.select("P119");
        pr1.display();
        pr1.insert("P119", "Polish", "Polish Teeth", 199.99);
    }
}
