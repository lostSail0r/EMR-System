
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

public class patAptGUI extends Application {
        
    // Misc Declarations
    GridPane topPane = new GridPane();
    GridPane middlePane = new GridPane();
    HBox bottomPane = new HBox();
    Patient p = new Patient();
    Label header = new Label("\n\n\n\nAppointment Information:\n\n----------------------------\n\n\n");
    Label patientData = new Label();
    Button exitBtn = new Button("Exit");
    
    public void start(Stage primaryStage, String userID) {
        p.select(userID);
        Appointment apt = p.getApt();
        patientData.setText("Appointment Date/Time: " + apt.getDate() + "\n" + "Patient ID: " + apt.getPID() + "\n" + "Dentist ID: " + apt.getDID() + "\n" + "Procedure Code: " + apt.getCode());
        topPane.add(header, 1,0);
        topPane.setAlignment(Pos.TOP_CENTER);
        middlePane.setHgap(10);
        middlePane.setVgap(10);
        middlePane.add(patientData, 1, 0);
        middlePane.setAlignment(Pos.TOP_CENTER);
        bottomPane.getChildren().addAll(exitBtn);
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);

        // BorderPane and Scene
        BorderPane root = new BorderPane();
        root.setTop(topPane);
        root.setCenter(middlePane);
        root.setBottom(bottomPane);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Appointment Information");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Event Handler
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
               System.exit(0);
            }
        });
    }    
    
    @Override
    public void start(Stage primaryStage) {
        patientData.setText("\n\nPatient Information:\n----------------------\n\n");
        middlePane.setHgap(10);
        middlePane.setVgap(10);
        middlePane.add(patientData, 1, 0);
        middlePane.setAlignment(Pos.TOP_CENTER);
        bottomPane.getChildren().addAll(exitBtn);
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        
        // BorderPane and Scene
        BorderPane root = new BorderPane();
        root.setTop(topPane);
        root.setCenter(middlePane);
        root.setBottom(bottomPane);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Patient Information");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Event Handler
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
               System.exit(0);
            }
        });
    }
    // Main
    public static void main(String[] args) {
        launch(args);
    }
}