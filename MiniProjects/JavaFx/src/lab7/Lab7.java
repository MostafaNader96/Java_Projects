
package lab7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Lab7 extends Application {
    
    Reflection reflection = new Reflection();
    Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.WHITE),new Stop(1, Color.BLACK)};
    LinearGradient lg1 = new LinearGradient(0, 0,0, 250, false, CycleMethod.REFLECT, stops);
    
    @Override
    public void start(Stage primaryStage) {
        
        Rectangle rec = new Rectangle(0,0,500,500);
        
        rec.setFill(lg1);
      
        
        Text hello = new Text("HELLO HONDA");
        /*hello.setFont(Font.font ("Verdana", 30));
        hello.setFill(Color.RED);
        hello.setEffect(reflection);*/
        rec.setEffect(reflection);
        StackPane root = new StackPane();

        root.getChildren().add(rec);
        root.getChildren().add(hello);
        
        Scene scene = new Scene(root, 500, 500);
        
        scene.getStylesheets().add(getClass().getResource("textstyle.css").toExternalForm());
        hello.getStyleClass().add("textclass");
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
