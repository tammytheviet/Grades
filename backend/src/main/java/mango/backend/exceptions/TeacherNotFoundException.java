package mango.backend.exceptions;

public class TeacherNotFoundException extends RuntimeException 
{
	public TeacherNotFoundException(Integer id) 
	{
		super("Teacher " + id + "could not be found.");
	}
	
}

