package mango.backend.exceptions;

public class GradeCouldNotBeDeletedException extends RuntimeException
{
    public GradeCouldNotBeDeletedException(Integer id) 
    {
		super("The Grade '" + id + "' could not be deleted.");
	}
    
}