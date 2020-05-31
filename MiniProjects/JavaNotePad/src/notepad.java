import com.sun.jndi.dns.DnsContextFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class notepad extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
     
              FileChooser fc = new FileChooser();
                            FileChooser fcc = new FileChooser();

              byte []b;
              b= new byte[1000];
        MenuBar bar= new MenuBar();
        Menu file = new Menu("File");
        file.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("file.png"))));
        
        MenuItem neww =new MenuItem("New");
        neww.setAccelerator(KeyCombination.keyCombination("ctrl+n"));
       neww.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("new.png"))));

        
        MenuItem open =new MenuItem("Open");
        open.setAccelerator(KeyCombination.keyCombination("ctrl+o"));
        open.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("open.png"))));

        MenuItem save =new MenuItem("Save");
        save.setAccelerator(KeyCombination.keyCombination("ctrl+s"));
        save.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("save.png"))));

        MenuItem exit =new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("ctrl+esc"));
        exit.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exit.png"))));

        Menu edit = new Menu("edit");
        //file.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("file.png"))));
        
        MenuItem undo =new MenuItem("undo");
        neww.setAccelerator(KeyCombination.keyCombination("ctrl+z"));
       //neww.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("new.png"))));

        
        MenuItem cut =new MenuItem("cut");
        open.setAccelerator(KeyCombination.keyCombination("ctrl+x"));
        //open.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("open.png"))));

        MenuItem copy =new MenuItem("copy");
        save.setAccelerator(KeyCombination.keyCombination("ctrl+c"));
        //save.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("save.png"))));

        MenuItem paste =new MenuItem("paste");
        exit.setAccelerator(KeyCombination.keyCombination("ctrl+v"));
        //exit.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exit.png"))));
        
        MenuItem delete =new MenuItem("delete");
        exit.setAccelerator(KeyCombination.keyCombination("ctrl+del"));
        //exit.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exit.png"))));
        
        MenuItem selectall =new MenuItem("selectall");
        selectall.setAccelerator(KeyCombination.keyCombination("ctrl+a"));
        //exit.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("exit.png"))));
        
        
        TextArea ta= new TextArea();
        
        Menu help = new Menu("help");

        neww.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.clear();
            }
        });
        
        open.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             File selectedFile = fc.showOpenDialog(primaryStage);
                try {
                   FileInputStream fis= new FileInputStream(selectedFile);
                   fis.read(b);
                   String s=new String(b);
                   ta.clear();
                   ta.appendText(s);
                } catch (FileNotFoundException ex) {

                } catch (IOException ex) {

                }
                
                

            }
        });
        
        
        save.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fcc.getExtensionFilters().add(extFilter);
                File file = fcc.showSaveDialog(primaryStage);                
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(ta.getText().getBytes());
                } catch (FileNotFoundException ex) {

                } catch (IOException ex) {

                }
                
                

            }
        });
        
        exit.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        undo.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.undo();
            }
        });
        
        
        copy.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.copy();
            }
        });
        
        
        cut.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.cut();
            }
        });
        
        
        selectall.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.selectAll();
            }
        });
        
        paste.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.paste();
            }
        });
        
        delete.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ta.deletePreviousChar();
            }
        });
        
        
        file.getItems().addAll(neww,open,save,exit);
        bar.getMenus().addAll(file);
        edit.getItems().addAll(undo,cut,copy,paste,delete,selectall);
        bar.getMenus().addAll(edit);
        bar.getMenus().addAll(help);
        
        BorderPane pane= new BorderPane();
        pane.setTop(bar);
        pane.setCenter(ta);
        Scene scene = new Scene(pane,300,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
     
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
