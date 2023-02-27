package mango.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import mango.backend.exceptions.couldnotbedeleted.TeacherCouldNotBeDeletedException;
import mango.backend.exceptions.couldnotbesaved.TeacherCouldNotBeSavedException;
import mango.backend.exceptions.load.TeacherLoadException;
import mango.backend.model.repositories.TeacherRepository;
import mango.backend.model.tables.Teacher;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController 
{
    
    @Autowired
    private TeacherRepository teacherRepo;

    @GetMapping
    public ResponseEntity<Iterable<Teacher>> getAllTeachers() 
    {

        Iterable<Teacher> teachers = null;

        try 
		{
            teachers = teacherRepo.findAll();
        }

        catch(Exception e) 
		{
            throw new TeacherLoadException();
        }

        return ResponseEntity.ok(teachers);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<Optional<Teacher>> getTeacherById(@RequestParam Integer id) 
	{

		Optional<Teacher> teacher = null;

		try 
		{
			teacher = teacherRepo.findById(id);
		}
		
		catch (Exception ex) 
		{
			throw new TeacherLoadException();
		}

		return ResponseEntity.ok(teacher);
	}

    @PostMapping
    public ResponseEntity<String> addNewTeacher(@Valid @RequestBody Teacher teacher) 
	{

		try 
		{
			teacherRepo.save(teacher);
		}

		catch (Exception ex) 
		{
			throw new TeacherCouldNotBeSavedException(teacher.getLastname());
		}

		return ResponseEntity.ok("Saved");

	}

	@DeleteMapping
    public ResponseEntity<String> deleteTeacher(@QueryParam Teacher teacher) 
	{

        try 
		{
            teacherRepo.deleteById(teacher.getId());
        }

		catch (Exception e) 
		{
            throw new TeacherCouldNotBeDeletedException(teacher.getLastname());
        }

		return ResponseEntity.ok("Deleted");

    }

}
