package mango.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author Tam Lai Nguyen
 * @version 1.0
 * @description This class creates a table "subject" in the database "grades". In the table are the following columns: id, name, type, teacher
 */

@Entity
@Table(name = "subject")
public class Subject 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @NotEmpty(message = "Type may not be empty")
    private String type;

    @ManyToOne
	@JoinColumn(name = "teacher", nullable = false)
    @NotEmpty(message = "Type may not be empty")
    private Teacher teacher;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

}
