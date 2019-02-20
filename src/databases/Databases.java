/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.*;
/**
 *
 * @author rauerjakob
 */
public class Databases {

    private Connection conn = null;
    private Statement stat = null;
    
    public Databases() {
        init();
        
        //ausgebenAlleArtikel();
    }
    
    private void init() {
        try{
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:buero.sqlite");
            this.stat = conn.createStatement();
            
        } catch(Exception e) {
            System.out.println(e.toString());
        }
       
    }
    
    public void close() {
        try {
             this.conn.close();
             this.stat.close();
        } catch(Exception e) {
            System.out.println(e);
        }
       
    }
    
    void ausgebenAlleArtikel() {
        try{
            String sql = "Select * from Artikel";
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()) {
                System.out.println("ArtikelNr: " + rs.getString("ArtikelNr") + ", Bezeichnung: " + rs.getString("Artikelname"));
            }
            
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }   
    
    void ausgebenArtikelNummer(String artikelNr) {
        try{
            String sql = "Select ArtikelName, Artikel.ArtikelNr, Ausgaenge.AusgangsNr, Einzelpreis, AnzahlEinheiten, Einzelpreis * AnzahlEinheiten as gesamt from Artikel "
                    + "JOIN Ausgaenge on Artikel.ArtikelNr = Ausgaenge.ArtikelNr where Artikel.ArtikelNr = '" + artikelNr+ "'";
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()) {
                System.out.println(rs.getString("AusgangsNr") + ": " + "ArtikelNr: " + rs.getString("ArtikelNr") + " Bezeichnung: " + rs.getString("Artikelname") 
                        + "     Preis: "  + rs.getString("Einzelpreis")
                        + "     Menge: " + rs.getString("AnzahlEinheiten") 
                        + "     Gesamtpreis: " +  rs.getString("gesamt"));
            }
            
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }   
    
    void ausgebenArtikelNummerTeil(String artikelNr) {
        try{
            String sql = "Select ArtikelName, Artikel.ArtikelNr, Ausgaenge.AusgangsNr, Einzelpreis, AnzahlEinheiten, Einzelpreis * AnzahlEinheiten as gesamt from Artikel "
                    + "JOIN Ausgaenge on Artikel.ArtikelNr = Ausgaenge.ArtikelNr where Artikel.ArtikelNr = '" + artikelNr+ "'";
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()) {
                System.out.println(rs.getString("AusgangsNr") + ": " + "ArtikelNr: " + rs.getString("ArtikelNr") + " Bezeichnung: " + rs.getString("Artikelname") 
                        + "     Preis: "  + rs.getString("Einzelpreis")
                        + "     Menge: " + rs.getString("AnzahlEinheiten") 
                        + "     Gesamtpreis: " +  rs.getString("gesamt"));
            }
            
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }   
    
    public void ausgebenAlleEingaenge() {
        try {
            String sql = "Select * from Eingaenge";
            ResultSet rs = stat.executeQuery(sql);

            System.out.println("Eingangsliste\n"
                             + "=============");
            while(rs.next()) {
                System.out.println("EingangsNr: " + rs.getString("EingangsNr") + ", Eingangsdatum: " + rs.getString("Eingangsdatum"));
            }
        } catch(Exception e) {
            
        }
    }
}
