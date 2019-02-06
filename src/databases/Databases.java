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
    
    void ausgebenAlleArtikel(String artikelNr) {
        try{
            String sql = "Select * from Artikel where ArtikelNr = '" + artikelNr+ "'";
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()) {
                System.out.println("ArtikelNr: " + rs.getString("ArtikelNr") + ", Bezeichnung: " + rs.getString("Artikelname"));
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
