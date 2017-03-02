
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

public class denAptGUI extends Application {
        
    // Misc Declarations
    GridPane topPane = new GridPane();
    GridPane middlePane = new GridPane();
    HBox bottomPane = new HBox();
    Dentist d = new Dentist();
    Label header = new Label("\n\n\n\nDentist Information:\n\n----------------------\n\n\n");
    Label patientData = new Label();
    Button exitBtn = new Button("Exit");
    
    public void start(Stage primaryStage, String userID) {
        d.select(userID);
        AppointmentList apt = d.getAptList();
        apt.display();
        patientData.setText("Appointment Date/Time: " + apt.showDate() + "\n" + "Dentist ID: " + apt.showDid() + "\n" + "Patient ID: " + apt.showPid() + "\n" + "Procedure Code: " + apt.showCode() + "\n");
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
        primaryStage.setTitle("Dentist Information");
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
        patientData.setText("\n\nDentist Information:\n----------------------\n\n");
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
        primaryStage.setTitle("Dentist Information");
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