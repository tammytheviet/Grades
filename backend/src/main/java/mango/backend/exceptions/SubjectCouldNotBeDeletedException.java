package mango.backend.exceptions;

public class SubjectCouldNotBeDeletedException extends RuntimeException
{
    public SubjectCouldNotBeDeletedException(String subject) 
    {
		super("The subject '" + subject + "' could not be deleted.");
	}
    
}
