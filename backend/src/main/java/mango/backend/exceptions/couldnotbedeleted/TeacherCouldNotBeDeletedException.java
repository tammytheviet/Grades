package mango.backend.exceptions.couldnotbedeleted;

public class TeacherCouldNotBeDeletedException extends RuntimeException
{
    public TeacherCouldNotBeDeletedException(String teacher) 
    {
		super("The teacher '" + teacher + "' could not be deleted.");
	}
    
}
