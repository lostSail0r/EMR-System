
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;

public class AppointmentList {
    
    // Properties
    private Appointment[] apts = new Appointment[500];
    private int count;
    
    // Constructors
    public AppointmentList() {
        Appointment [] apts = new Appointment[10];
        count = 0;
    }
    
    // Behaviors
    public String showDate() {return "";}
    public String showPid() {return "";}
    public String showDid() {return "";}
    public String showCode() {return "";}
    
    public void addAppointment(Appointment a) {
        apts[count] = a;
        count++;
    }
    
    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println("\nAppointment " +(i+1) +":");
            apts[i].display();
        }
    }
    
    // Main
    public static void main(String[] args) {
        AppointmentList test = new AppointmentList();
        test.addAppointment(new Appointment("test", "test", "test", "test"));
        test.addAppointment(new Appointment("tester", "tester", "tester", "tester"));
        test.display();
    }
    
}
