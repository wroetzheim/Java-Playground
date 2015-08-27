/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_starter;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.*;

import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class JavaFX_starter extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Text reply = new Text();
        reply.setText("Peanuts!");
        
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        
        Button a_button = new Button();
        a_button.setText("Favorite Nut?");
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

        Group circles = new Group();
        
        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle();
            circle.setCenterX(10.0);
            circle.setCenterY(10.0);
            circle.setRadius(5.0);
            circles.getChildren().add(circle);
        }
        
        Ellipse circle = EllipseBuilder.create()
             .centerX(500)
             .centerY(500)
             .radiusX(30)
             .radiusY(30)
             .strokeWidth(3)
             .stroke(Color.YELLOW)
             .fill(Color.TEAL)
             .build();
        
        root.getChildren().add(a_button);
        root.getChildren().add(reply);
        root.getChildren().add(circle);
        a_button.relocate(70,70);
        
        
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
