package mango.backend.exceptions.load;

public class TeacherLoadException extends RuntimeException 
{
	public TeacherLoadException() 
	{
		super("Teachers could not be loaded.");
	}
	
}

