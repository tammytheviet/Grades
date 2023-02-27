package mango.backend.exceptions.couldnotbesaved;

public class SubjectCouldNotBeSavedException extends RuntimeException 
{
	public SubjectCouldNotBeSavedException(String subject) 
	{
		super("Subject could not be saved.");
	}
	
}
