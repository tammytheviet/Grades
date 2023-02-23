package mango.backend.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Tam Lai Nguyen
 * @version 1.0
 * @description This class creates a table "teacher" in the database "grades". In the table are the following columns: id, name
 */

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer te_id;
 
    private String te_name;

    public Integer getTe_id() {
        return te_id;
    }

    public void setTe_id(Integer te_id) {
        this.te_id = te_id;
    }

    public String getTe_name() {
        return te_name;
    }

    public void setTe_name(String te_name) {
        this.te_name = te_name;
    }
    
 }
 
