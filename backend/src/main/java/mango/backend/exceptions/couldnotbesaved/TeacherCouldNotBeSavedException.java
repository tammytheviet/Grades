package mango.backend.exceptions.couldnotbesaved;

public class TeacherCouldNotBeSavedException extends RuntimeException
{
    public TeacherCouldNotBeSavedException(String teacher) 
	{
		super("The teacher '" + teacher + "' could not be saved.");
	}
	
}
