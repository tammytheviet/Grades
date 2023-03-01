package mango.backend.exceptions;

public class SubjectCouldNotBeSavedException extends RuntimeException 
{
	public SubjectCouldNotBeSavedException(String subject) 
	{
		super("Subject could not be saved.");
	}
	
}
