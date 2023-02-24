package mango.backend.model.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author Tam Lai Nguyen
 * @version 1.0
 * @description This class creates a table "teacher" in the database "grades". In the table are the following columns: id, name
 */

@Entity
@Table(name = "teacher")
public class Teacher 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    @NotEmpty(message = "Surname may not be empty")
    private String surname;

    @NotEmpty(message = "Lastname may not be empty")
    private String lastname;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

 }
 
