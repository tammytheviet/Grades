package mango.backend.exceptions;

public class SubjectLoadException extends RuntimeException 
{
	public SubjectLoadException() 
	{
		super("Subjects could not be loaded.");
	}
	
}
