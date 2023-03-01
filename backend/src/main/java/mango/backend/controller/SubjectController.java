package mango.backend.controller;

import java.util.Optional;

import mango.backend.model.*;
import mango.backend.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController 
{
    
    @Autowired
    private SubjectRepository subjectRepo;

	@Autowired
    private TeacherRepository teacherRepo;

    @GetMapping
    public ResponseEntity<Iterable<Subject>> getAllSubjects() 
    {

        Iterable<Subject> subjects = null;

        try 
		{
            subjects = subjectRepo.findAll();
        }

        catch(Exception e) 
		{
            throw new SubjectLoadException();
        }

        return ResponseEntity.ok(subjects);
    }

    @GetMapping(path = "/id")
    public ResponseEntity<Optional<Subject>> getSubjectById(@RequestParam Integer id) 
	{

		Optional<Subject> subject = null;

		try 
		{
			subject = subjectRepo.findById(id);
		}
		
		catch (Exception ex) 
		{
			throw new SubjectLoadException();
		}

		return ResponseEntity.ok(subject);
	}

    @PostMapping(path = "/{teacher}")
    public ResponseEntity<String> addNewSubject(@PathVariable(value = "teacher") Integer teacherId, 
												@Valid @RequestBody Subject subject) 
	{
		Optional<Teacher> teacher = teacherRepo.findById(teacherId);

		if (teacher.isEmpty())
		{
			throw new TeacherNotFoundException(teacherId);
		}

		subject.setTeacher(teacher.get());

		try 
		{
			subjectRepo.save(subject);
		}

		catch (Exception ex) 
		{
			throw new SubjectCouldNotBeSavedException(subject.getName());
		}

		return ResponseEntity.ok("Saved");

	}

	@DeleteMapping
    public ResponseEntity<String> deleteTeacher(@QueryParam Subject subject) 
	{

        try 
		{
            subjectRepo.deleteById(subject.getId());
        }

		catch (Exception e) 
		{
            throw new SubjectCouldNotBeDeletedException(subject.getName());
        }

		return ResponseEntity.ok("Deleted");

    }
    
}