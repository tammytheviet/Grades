package mango.backend.controller;

import java.util.Optional;

import mango.backend.model.tables.Subject;

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
import mango.backend.exceptions.couldnotbedeleted.SubjectCouldNotBeDeletedException;
import mango.backend.exceptions.couldnotbesaved.SubjectCouldNotBeSavedException;
import mango.backend.exceptions.load.SubjectLoadException;
import mango.backend.model.repositories.SubjectRepository;

@RestController
@RequestMapping(path = "/subject")
public class SubjectController 
{
    
    @Autowired
    private SubjectRepository subjectRepo;

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

    @PostMapping
    public ResponseEntity<String> addNewSubject(@Valid @RequestBody Subject subject) 
	{

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