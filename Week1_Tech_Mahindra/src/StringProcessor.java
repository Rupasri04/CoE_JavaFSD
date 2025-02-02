import java.util.*;
public class StringProcessor {
	
	public static String reverseString(String str)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=str.length()-1;i>=0;i--)
		{
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static int countOccurences(String str,String sub)
	{
		int count=0;
		for(int i=0;i<str.length()-1;i++)
		{
			if(str.substring(i,sub.length()+i).equals(sub))
			{
				count++;
			}

		}
		return count;
	}
	
	public static String splitAndCapitalize(String str)
	{
		String temp="";
		char ch;
		for(int i=0;i<str.length();i++)
		{
			if(i<str.length()-1)
			{
			ch=str.charAt(i);
			temp+=Character.toUpperCase(ch)+" ";
			}
			else
			{
				ch=str.charAt(i);
				temp+=Character.toUpperCase(ch);
			}
			
		}
		
		return temp;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char c;
		do
		{
			System.out.println("****STRING HANDLING****");
			System.out.println("1.Reverse String");
			System.out.println("2.Count Occurences");
			System.out.println("3.Split And Capitalize");
			System.out.println("4.exit");
			System.out.println();
			System.out.println("Enter the Option");
			int num=sc.nextInt();
			
			switch(num)
			{
			case 1:
			{
				System.out.println("Enter the String");
				String str=sc.next();
				System.out.println(reverseString(str));
				break;
			}
			
			case 2:
			{
				System.out.println("Enter the String");
				String str=sc.next();
				System.out.println("Enter the Sub String");
				String sub=sc.next();
				System.out.println(countOccurences(str,sub));
				break;
				
			}
			
			case 3:
			{
				System.out.println("Enter the String");
				String str=sc.next();
				System.out.println(splitAndCapitalize(str));
				break;
			}
			
			case 4:
			{
				sc.close();
				return;
			}
			
			
			}
			System.out.println("Do you want to continue");
			c=sc.next().charAt(0);
		}while(c=='y');
	
	

}
}
