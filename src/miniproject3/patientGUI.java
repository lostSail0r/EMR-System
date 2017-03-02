
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;     
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class patientGUI extends Application {
        
    // Declaring GUI Elements
    Patient p = new Patient();
    Text title = new Text();
    GridPane grid = new GridPane();
    HBox bottomPane = new HBox(5);
    Label name = new Label("Name:");
    Label address = new Label("Address:");
    Label email = new Label("Email:");
    Label patID = new Label("Patient ID:");
    Label ins = new Label("Insurance:");
    Text userName = new Text();
    Text userAddress = new Text();
    Text userEmail = new Text();
    Text userId = new Text();
    Text userIns = new Text();
    PasswordField pwField = new PasswordField();
    Button aptBtn = new Button("Display Appointment");
    Button exitBtn = new Button("Exit");
    
    public void start(Stage primaryStage, String userID) {
        
        // Loading Patient Information
        p.select(userID);
        userName.setText(p.getFirst() + " " + p.getLast());
        userAddress.setText(p.getAddr());
        userEmail.setText(p.getEmail());
        userId.setText(p.getID());
        userIns.setText(p.getIns());
        
        // Positioning GUI elements
        title.setText("Patient Information\n-------------------------");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 35));
        grid.setAlignment(Pos.CENTER);

        grid.setVgap(10);
        grid.add(title, 0, 0, 2, 1);    
        grid.add(name, 0, 1);
        grid.add(userName, 1, 1);
        grid.add(address, 0, 2);
        grid.add(userAddress, 1, 2);
        grid.add(email, 0, 3);
        grid.add(userEmail, 1, 3);
        grid.add(patID, 0, 4);
        grid.add(userId, 1, 4);
        grid.add(ins, 0, 5);
        grid.add(userIns, 1, 5);
        grid.add(bottomPane, 0, 6);
        bottomPane.setAlignment(Pos.BOTTOM_RIGHT);
        bottomPane.getChildren().addAll(aptBtn, exitBtn);
        
        // BorderPane and Scene
        Scene root = new Scene(grid, 600, 500);
        primaryStage.setTitle("Patient Account");
        primaryStage.setScene(root);
        primaryStage.show();

        // Event Handler
        aptBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                patAptGUI apt = new patAptGUI();
                apt.start(primaryStage, userID);
            }
        });
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
               System.exit(0);
            }
        });
    }    
    @Override
    public void start(Stage primaryStage) {
        
    }
    // Main
    public static void main(String[] args) {
        launch(args);
    }
}
