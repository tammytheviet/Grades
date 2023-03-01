package mango.backend.controller;

import java.util.Optional;

import mango.backend.model.*;
import mango.backend.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import mango.backend.exceptions.GradeCouldNotBeDeletedException;

@RestController
@RequestMapping(path = "/grade")
public class GradeController 
{
    
    @Autowired
    private GradeRepository gradeRepo;

    @GetMapping
    public ResponseEntity<Iterable<Grade>> getAllGrades() 
    {

        Iterable<Grade> grades = null;

        try 
		{
            grades = gradeRepo.findAll();
        }

        catch(Exception e) 
		{
            throw new GradeLoadException();
        }

        return ResponseEntity.ok(grades);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<Optional<Grade>> getGradeById(@RequestParam Integer id) 
	{

		Optional<Grade> grade = null;

		try 
		{
			grade = gradeRepo.findById(id);
		}
		
		catch (Exception ex) 
		{
			throw new GradeLoadException();
		}

		return ResponseEntity.ok(grade);
	}

    @PostMapping
    public ResponseEntity<String> addNewGrade(@Valid @RequestBody Grade grade) 
	{

		try 
		{
			gradeRepo.save(grade);
		}

		catch (Exception ex) 
		{
			throw new GradeCouldNotBeSavedException(grade.getId());
		}

		return ResponseEntity.ok("Saved");

	}

	@DeleteMapping
    public ResponseEntity<String> deleteGrade(@QueryParam Grade grade) 
	{

        try 
		{
            gradeRepo.deleteById(grade.getId());
        }

		catch (Exception e) 
		{
            throw new GradeCouldNotBeDeletedException(grade.getId());
        }

		return ResponseEntity.ok("Deleted");

    }
    
}
