package databases;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Fenster extends Application {
    
    private StackPane root;
    private GridPane myWindow;
    private Button ausgebenArtikel;
    private Button ausgebenEingaenge;
    private Button ausgebenNachArtNr;
    private Button ausgebenNachArtNrTeil;
    private Label label1;
    private Label label2;
    private TextField textFieldArtNr;
    private TextField textFieldAnfang;
    
    @Override
    public void start(Stage primaryStage) {
        root = new StackPane();
        primaryStage.setScene(new Scene(root, 500, 120));
        primaryStage.setTitle("Datenbankzugriff");

        myWindow = new GridPane();
        myWindow.setVgap(5);
        myWindow.setHgap(5);
        myWindow.setPadding(new Insets(10));

        
        ausgebenArtikel = new Button("Artikel ausgeben");
        ausgebenEingaenge = new Button("Eingänge ausgeben");
        label1 = new Label("Artikelnr. eingeben:");
        textFieldArtNr = new TextField();
        ausgebenNachArtNr = new Button("Ausgänge anzeigen");
        label2 = new Label("Anfang Artikelnr. eingeben:");
        textFieldAnfang = new TextField();
        ausgebenNachArtNrTeil = new Button("Ausgänge anzeigen (Teil)");
        
        myWindow.add(getAusgebenArtikel(), 0, 0);
        myWindow.add(getAusgebenEingaenge(), 2, 0);
        myWindow.add(label1, 0, 1);
        myWindow.add(getTextFieldArtNr(), 1, 1);
        myWindow.add(getAusgebenNachArtNr(), 2, 1);
        myWindow.add(label2, 0, 2);
        myWindow.add(getTextFieldAnfang(), 1, 2);
        myWindow.add(getAusgebenNachArtNrTeil(), 2, 2);
        
        root.getChildren().add(myWindow);
        primaryStage.show();
        Presenter.start(this);
    }
    public static void main(String[] args) {
        launch(args);
    }

    public Button getAusgebenArtikel() {return ausgebenArtikel;}
    public Button getAusgebenEingaenge() {return ausgebenEingaenge;}
    public Button getAusgebenNachArtNr() {return ausgebenNachArtNr;}
    public Button getAusgebenNachArtNrTeil() {return ausgebenNachArtNrTeil;}
    public TextField getTextFieldArtNr() {return textFieldArtNr;}
    public TextField getTextFieldAnfang() {return textFieldAnfang;}
}
