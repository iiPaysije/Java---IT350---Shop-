package GIbson;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        GridPane gpane = new GridPane();

   
       
    

        Button izlaz = new Button("Izlaz");
        izlaz.setPrefSize(200, 50);
        izlaz.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.close();
                System.exit(0);
            }
        });
        
   

        Button dodajBrisi = new Button("Dodaj - izbrisi");
        dodajBrisi.setPrefSize(200, 50);
        dodajBrisi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.hide();
                DodajIzbrisi di = new DodajIzbrisi(stage);
            }
        });

        gpane.setVgap(10);
        gpane.setAlignment(Pos.CENTER);
        gpane.setPadding(new Insets(15));
     
     
    
        gpane.add(dodajBrisi, 1, 8);
        gpane.add(izlaz, 1, 9);

        Scene scena = new Scene(gpane, 500, 500);
        scena.getStylesheets().add(getClass().getResource("css.css").toString());
        stage.setScene(scena);
        stage.setTitle("IT350 - PZ - Pavle Ljubenovic 3688");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
