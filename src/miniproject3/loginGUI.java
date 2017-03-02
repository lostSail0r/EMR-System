
/**********************************************
    Chris Grady
    CS 1302 Mini-Project 3
**********************************************/

package miniproject3;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;     
import javafx.scene.text.*;

public class loginGUI extends Application {
    BorderPane root = new BorderPane();
    // Declaring GUI Elements
    Text title = new Text();
    GridPane grid = new GridPane();
    HBox bottomPane = new HBox(10);
    Label username = new Label("Username:  ");
    Label password = new Label("Password:  ");
    TextField userField = new TextField();
    PasswordField pwField = new PasswordField();
    Button loginBtn = new Button("Sign In");
    
    @Override
    public void start(Stage primaryStage) {
        
        // Positioning GUI elements
        title.setText("Welcome\n\n\nPlease Enter Username and Password\n");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setHgap(10);
        grid.setVgap(10);
        // column 0, row 0, 2 & 1 set limits on col/row
        grid.add(title, 0, 0, 2, 1);    
        grid.add(username, 0, 1);
        grid.add(userField, 1, 1);
        grid.add(password, 0, 2);
        grid.add(pwField, 1, 2);
        bottomPane.setAlignment(Pos.BOTTOM_CENTER);
        bottomPane.getChildren().add(loginBtn);
        
        root.setCenter(grid);
        root.setBottom(bottomPane);
        
        // Packing GUI hierarchy
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Mini-Project 3");
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Event Handlers
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                String userInput = userField.getText();
                String pwInput = pwField.getText();
                char x = userInput.charAt(0);
                
                switch (x) {
                    // Patient Login
                    case 'A':
                        // Verify Password
                        Patient p = new Patient();
                        p.select(userInput);
                        if (pwInput.equals(Integer.toString(p.getPasswd()))){
                            patientGUI pat = new patientGUI();
                            pat.start(primaryStage, userInput);
                        }
                        else
                            System.out.println("Password Incorrect - Try Again");
                        break;
                    // Dentist Login
                    case 'D':
                        // Verify Password
                        Dentist d = new Dentist();
                        d.select(userInput);
                        if (pwInput.equals(d.getPasswd())){
                            dentistGUI den = new dentistGUI();
                            den.start(primaryStage, userInput);
                        }
                        else
                            System.out.println("Password Incorrect - Try Again");
                        break;   
                    default:
                        System.out.println("Username does not exist - Try again");
                        break;
                }
            }
        });
    }
    // Main
    public static void main(String[] args) {
        launch(args);
    }
}
