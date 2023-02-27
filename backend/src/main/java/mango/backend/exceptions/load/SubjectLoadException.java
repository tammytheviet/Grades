package mango.backend.exceptions.load;

public class SubjectLoadException extends RuntimeException 
{
	public SubjectLoadException() 
	{
		super("Subjects could not be loaded.");
	}
	
}
