package mango.backend.exceptions;

public class GradeCouldNotBeSavedException extends RuntimeException 
{
	public GradeCouldNotBeSavedException(Integer Id) 
	{
		super("Grade could not be saved.");
	}
	
}
