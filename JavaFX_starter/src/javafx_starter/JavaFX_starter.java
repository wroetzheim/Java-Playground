/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_starter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.*;


public class JavaFX_starter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text reply = new Text();
        reply.setText("Peanuts!");
        Button a_button = new Button();
        a_button.setText("Favorite Nut?");
        
        Pane left;
        left = new Pane();

        a_button.setOnAction(new EventHandler<ActionEvent>() {
            
            int x = 10;
            int y = 10;

            @Override
            public void handle(ActionEvent event) {

                reply.relocate(x, y);
                x += 10;
                y += 10;
   
            }
        });

        left.getChildren().add(a_button);
        left.getChildren().add(reply);
        a_button.relocate(70,70);
        Scene scene = new Scene(left, 500, 450);
        
        primaryStage.setTitle("A peanut's favorite nut");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
