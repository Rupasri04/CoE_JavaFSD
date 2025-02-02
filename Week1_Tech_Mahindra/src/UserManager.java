import java.util.Scanner;
import java.io.*;
public class UserManager {
	
	String name;
	String email;
	UserManager(String name,String email)
	{
		this.name=name;
		this.email=email;
	}
	
	public static void addUser(String name,String email) 
	{
		UserManager us=new UserManager(name,email);
		us.saveUsersToFile();
	
	}
	
	public  void saveUsersToFile() 
	{
		File savefile=new File("user.txt");
		BufferedWriter write;
		try {
			write = new BufferedWriter(new FileWriter(savefile,true));
			write.write("*****NAME******");
			write.write(name);
			write.write("******EMAIL******");
			write.write(email);
			write.newLine();
			System.out.println("SUCCESSFULLY WRITTEN......");
			if(write!=null)
			{
				write.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loadUsersFromFile();
		
	}
	
	public void loadUsersFromFile()
	{
		File file=new File("user.txt");
		FileInputStream fin = null;
        InputStreamReader isr = null;
        BufferedReader reader = null;

        try {
            fin = new FileInputStream(file); 
            isr = new InputStreamReader(fin);  
            reader = new BufferedReader(isr);  

            String line;
            while ((line = reader.readLine()) != null) {  
                System.out.println(line);  
            }
		
	        }
	 catch (IOException e) {
        System.out.println("An error occurred while reading the file: " + e.getMessage());
    } finally {
        try {
            if (reader != null) {
                reader.close();  
            }
        } catch (IOException e) {
            System.out.println("An error occurred while closing the file: " + e.getMessage());
        }
    }

}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		String email=sc.next();
		addUser(name,email);	
	}
		
	}
