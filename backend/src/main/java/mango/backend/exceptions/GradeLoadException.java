package mango.backend.exceptions;

public class GradeLoadException extends RuntimeException
{

    public GradeLoadException() 
	{
		super("Grades could not be loaded.");
	}
}
