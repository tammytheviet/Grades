package mango.backend.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Tam Lai Nguyen
 * @version 1.0
 * @description
 */

@Entity
@Table(name = "teacher")
public class Teacher {

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
 
