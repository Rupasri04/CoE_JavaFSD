package LibraryManagementSystem;

public class BookNotFoundException extends Exception {
	
	public BookNotFoundException()
	{
		System.out.println("BOOK NOT FOUND");
	}
	public BookNotFoundException(String e)
	{
		System.out.println(e);
	}

}
