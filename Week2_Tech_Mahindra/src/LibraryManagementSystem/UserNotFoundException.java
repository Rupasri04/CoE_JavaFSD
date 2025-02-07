package LibraryManagementSystem;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException()
	{
		System.out.println("USER IS NOT FOUND");
	}
	public UserNotFoundException(String e)
	{
		System.out.println(e);
	}

}
