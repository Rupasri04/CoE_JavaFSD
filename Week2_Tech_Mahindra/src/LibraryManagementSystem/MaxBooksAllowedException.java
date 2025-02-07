package LibraryManagementSystem;

public class MaxBooksAllowedException extends Exception {
	public MaxBooksAllowedException()
	{
		System.out.println("MAX LIMIT REACHED");
	}
	public MaxBooksAllowedException(String e)
	{
		System.out.println(e);
	}

}
