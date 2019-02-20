/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import javafx.event.EventHandler;

/**
 *
 * @author rauerjakob
 */
public class Presenter {

    static void start(Fenster aThis) {
         Databases db = new Databases();
         
         aThis.getAusgebenArtikel().setOnAction(e -> {
            
             db.ausgebenAlleArtikel();
         });
         
         aThis.getAusgebenNachArtNr().setOnAction(e -> {
            
             db.ausgebenArtikelNummer(aThis.getTextFieldArtNr().getText());
         });
         
         aThis.getAusgebenEingaenge().setOnAction(e -> {
             db.ausgebenAlleEingaenge();
         });
         
         aThis.getAusgebenNachArtNrTeil().setOnAction(e -> {
             db.ausgebenArtikelNummerTeil(aThis.getTextFieldArtNr().getText());
         });
         
    }
    
    static void start2(Fenster2 aThis) {
         Databases db = new Databases();
         
    }
}
