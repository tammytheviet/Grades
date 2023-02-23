package mango.backend.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Klasse : Region
 * @author Tam Nguyen
 * @version 1.0
 * 
 * @Entity erstellt eine Verbindung zu der Datenbank "vct" und erstellt eine Tabelle
 * @Table deklariert den Namen der Tabelle : "region"
 */

 @Entity
 @Table(name = "dozent")
 public class Dozent {
 
     /**
      * @Id deklariert die Variable "id" zu einem Primary Key in der Tabelle "region"
      * @GeneratedValue spezifiziert die Generation Strategien für die Primary Key Werte
      */
 
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer do_id;
 
     private String do_name;

    public Integer getDo_id() {
        return do_id;
    }

    public void setDo_id(Integer do_id) {
        this.do_id = do_id;
    }

    public String getDo_name() {
        return do_name;
    }

    public void setDo_name(String do_name) {
        this.do_name = do_name;
    }
     
 }
 
