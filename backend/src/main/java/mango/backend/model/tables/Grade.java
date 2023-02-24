package mango.backend.model.tables;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

/**
 * @author Tam Lai Nguyen
 * @version 1.0
 * @description This class creates a table "subject" in the database "grades". In the table are the following columns: id, name, type, teacher
 */

@Entity
@Table(name = "grade")
public class Grade 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Grade may not be empty")
    private Double grade;

    @NotEmpty(message = "Weight may not be empty")
    private Double weight;

    @ManyToOne
    @JsonBackReference
	@JoinColumn(name = "subject", nullable = false)
    @NotEmpty(message = "Subject may not be empty")
    private Subject subject;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Double getGrade()
    {
        return grade;
    }

    public void setGrade(Double grade)
    {
        this.grade = grade;
    }

    public Double getWeight()
    {
        return weight;
    }

    public void setWeight(Double weight)
    {
        this.weight = weight;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

}
