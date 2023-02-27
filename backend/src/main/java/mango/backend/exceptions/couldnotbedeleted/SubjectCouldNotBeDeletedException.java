package mango.backend.exceptions.couldnotbedeleted;

public class SubjectCouldNotBeDeletedException extends RuntimeException
{
    public SubjectCouldNotBeDeletedException(String subject) 
    {
		super("The subject '" + subject + "' could not be deleted.");
	}
    
}
