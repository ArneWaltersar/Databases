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

    public Databases() {
        ausgebenAlleArtikel();
    }
    
    private void ausgebenAlleArtikel() {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:buero.sqlite");
            Statement stat = conn.createStatement();
            String sql = "Select * from artikel";
            ResultSet rs = stat.executeQuery(sql);

            while(rs.next()) {
                System.out.println("ArtikelNr: " + rs.getString("ArtikelNr") + ", Bezeichnung: " + rs.getString("Artikelname"));
            }
            rs.close();
            conn.close();
            
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }   
}
