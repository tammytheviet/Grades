package mango.backend.exceptions;

public class TeacherCouldNotBeSavedException extends RuntimeException
{
    public TeacherCouldNotBeSavedException(String teacher) 
	{
		super("The teacher '" + teacher + "' could not be saved.");
	}
	
}
