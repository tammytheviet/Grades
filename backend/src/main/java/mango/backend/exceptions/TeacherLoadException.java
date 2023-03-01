package mango.backend.exceptions;

public class TeacherLoadException extends RuntimeException 
{
	public TeacherLoadException() 
	{
		super("Teachers could not be loaded.");
	}
	
}

